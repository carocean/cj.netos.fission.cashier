package cj.netos.fission.chatroom;

import cj.lns.chip.sos.cube.framework.ICube;
import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.lns.chip.sos.cube.framework.TupleDocument;
import cj.netos.fission.*;
import cj.netos.fission.model.*;
import cj.netos.fission.model.PayRecord;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.util.Encript;
import cj.ultimate.util.StringUtil;
import com.rabbitmq.client.AMQP;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.UUID;

@CjService(name = "chatroomService")
public class ChatroomService extends AbstractService implements IChatroomService {
    static final String _COL_ROOM = "chat.rooms";
    static final String _COL_MEMBER = "chat.members";
    @CjServiceRef
    IPersonService personService;
    @CjServiceRef
    IPayRecordService payRecordService;
    @CjServiceRef(refByName = "@.rabbitmq.producer.chatroom")
    IRabbitMQProducer rabbitMQProducer;
    @CjServiceRef
    ICashierService cashierService;

    @Override
    public void enter(String recordSn, String payer, String payerName, String payee, String payeeName) throws CircuitException {
        //为支付者方建群；将被支付人加为成员；发出通知
        //支付方必须是充值者且必须是营业状态，没充过值不建群
        Cashier cashier = cashierService.getAndInitCashier(payer);
        Integer cashState = cashier.getState();
        if (cashState == null) {
            cashState = 0;
        }
        Integer supportsChatroom = cashier.getSupportsChatroom();
        if (supportsChatroom == null) {
            supportsChatroom = 0;
        }
        if (cashState == 1 || supportsChatroom == 0) {
            CJSystem.logging().info(getClass(), String.format("%s 的裂变游戏已停止营业或不具备拉群条件。state=%s supportsChatroom=%s", payerName,cashState,supportsChatroom));
            return;
        }
        String payerFull = String.format("%s@gbera.netos", payer);
        String payeeFull = String.format("%s@gbera.netos", payee);
        String roomId = Encript.md5(payerFull);
        Chatroom chatroom = getChatroom(payerFull, roomId);
        if (chatroom == null) {
            Person payerPerson = personService.get(payer);
            chatroom = createChatroom(payerFull, roomId, payerPerson);
            addMember(chatroom, payerFull, payerPerson, "creator");
            PayRecord record = payRecordService.getRecord(recordSn);
            pushAddMemberEvent(chatroom, payerFull, payerPerson, record);
            return;
        }

        if (existsMember(chatroom, payeeFull)) {
            CJSystem.logging().info(getClass(), String.format("抢群主:%s[%s]的群成员：%s[%s] 已在其聊天室：%s ，并且又领取了钱", payerName, payer, payeeName, payee, chatroom.getRoom()));
//            Person payeePerson = personService.get(payee);
//            PayRecord record = payRecordService.getRecord(recordSn);
//            pushAddMemberEvent(chatroom, payeeFull, payeePerson, record);
            return;
        }
        //添加成员

        Person payeePerson = personService.get(payee);
        addMember(chatroom, payeeFull, payeePerson, "user");
        PayRecord record = payRecordService.getRecord(recordSn);
        pushAddMemberEvent(chatroom, payeeFull, payeePerson, record);
    }

    @Override
    public void commission(WithdrawRecord record, String boss, String bossNickName, long amount) throws CircuitException {
        String bossFull = String.format("%s@gbera.netos", boss);
        String withdrawerFull = String.format("%s@gbera.netos", record.getWithdrawer());
        String roomId = Encript.md5(String.format("%s/38aef1fb-e99b-4b58-b983-252e50937604", boss));
        Chatroom chatroom = getChatroom(bossFull, roomId);
        if (chatroom == null) {
            Person payerPerson = personService.get(boss);
            chatroom = createChatroom2(bossFull, roomId, payerPerson);
            addMember(chatroom, bossFull, payerPerson, "creator");
            Person withdrawerPerson = personService.get(record.getWithdrawer());
            addMember(chatroom, withdrawerFull, withdrawerPerson, "user");
            pushAddMemberEvent2(chatroom, withdrawerFull, record.getNickName(), amount);
            return;
        }

        if (existsMember(chatroom, withdrawerFull)) {
            pushAddMemberEvent2(chatroom, withdrawerFull, record.getNickName(), amount);
//            CJSystem.logging().info(getClass(), String.format("抢群主:%s[%s]的群成员：%s[%s] 已在其聊天室：%s ，并且又领取了钱", bossNickName, boss, record.getNickName(), record.getNickName(), chatroom.getRoom()));
            return;
        }
        //添加成员

        Person withdrawerPerson = personService.get(record.getWithdrawer());
        addMember(chatroom, withdrawerFull, withdrawerPerson, "user");
        pushAddMemberEvent2(chatroom, withdrawerFull, withdrawerPerson.getNickName(), amount);
    }

    private void pushAddMemberEvent(Chatroom chatroom, String payeeFull, Person payeePerson, PayRecord record) throws CircuitException {
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/chat/message.mq")
                .headers(new HashMap() {
                    {
                        put("command", "pushMessage");
                        put("creator", chatroom.getCreator());
                        put("sender", payeeFull);
                        put("room", chatroom.getRoom());
                        put("msgid", Encript.md5(UUID.randomUUID().toString()));
                        put("contentType", "text");
                    }
                }).build();
        BigDecimal decimal = new BigDecimal(record.getAmount()).divide(new BigDecimal("100.00"), 2, RoundingMode.DOWN);
        String content = String.format("进群奖励：¥%s元", decimal.toString());
        byte[] body = content.getBytes();
        rabbitMQProducer.publish("jobCenter", properties, body);
    }

    private void pushAddMemberEvent2(Chatroom chatroom, String withdrawerFull, String nickName, long amount) throws CircuitException {
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/chat/message.mq")
                .headers(new HashMap() {
                    {
                        put("command", "pushMessage");
                        put("creator", chatroom.getCreator());
                        put("sender", withdrawerFull);
                        put("room", chatroom.getRoom());
                        put("msgid", Encript.md5(UUID.randomUUID().toString()));
                        put("contentType", "text");
                    }
                }).build();
        BigDecimal decimal = new BigDecimal(amount).divide(new BigDecimal("100.00"), 2, RoundingMode.DOWN);
        String content = String.format("给你佣金：¥%s元！请到\"钱包->裂变游戏\"账户中查看余额或账单", decimal.toString());
        byte[] body = content.getBytes();
        rabbitMQProducer.publish("jobCenter", properties, body);
    }

    private void addMember(Chatroom chatroom, String personFull, Person personInfo, String actor) {
        RoomMember member = new RoomMember();
        member.setActor(actor);
        member.setAtime(System.currentTimeMillis());
        member.setFlag(0);
        member.setNickName(personInfo.getNickName());
        member.setPerson(personFull);
        member.setRoom(chatroom.getRoom());
        cube(chatroom.getCreator()).saveDoc(_COL_MEMBER, new TupleDocument<>(member));
    }

    private boolean existsMember(Chatroom chatroom, String payeeFull) {
        return cube(chatroom.getCreator()).tupleCount(_COL_MEMBER, String.format("{'tuple.room':'%s','tuple.person':'%s'}", chatroom.getRoom(), payeeFull)) > 0;
    }

    private Chatroom createChatroom2(String payerFull, String roomId, Person payerPerson) {
        Chatroom chatroom = new Chatroom();
        chatroom.setCreator(payerFull);
        chatroom.setCtime(System.currentTimeMillis());
        chatroom.setFlag(0);
        chatroom.setLeading("http://47.105.165.186:7100/app/fission/img/tichengguanli.png");
        chatroom.setRoom(roomId);
        chatroom.setTitle("裂变游戏·佣金");
        cube(payerFull).saveDoc(_COL_ROOM, new TupleDocument<>(chatroom));
        return chatroom;
    }

    private Chatroom createChatroom(String payerFull, String roomId, Person payerPerson) {
        Chatroom chatroom = new Chatroom();
        chatroom.setCreator(payerFull);
        chatroom.setCtime(System.currentTimeMillis());
        chatroom.setFlag(0);
        chatroom.setLeading(payerPerson.getAvatarUrl());
        chatroom.setRoom(roomId);
        chatroom.setTitle(String.format("裂变游戏·交个朋友-%s", payerPerson.getNickName()));
        cube(payerFull).saveDoc(_COL_ROOM, new TupleDocument<>(chatroom));
        return chatroom;
    }

    private Chatroom getChatroom(String payerFull, String roomId) {
        ICube cube = cube(payerFull);
        String cjql = String.format("select {'tuple':'*'}.limit(1) from tuple chat.rooms %s where {'tuple.room':'%s'}", Chatroom.class.getName(), roomId);
        IQuery<Chatroom> query = cube.createQuery(cjql);
        IDocument<Chatroom> doc = query.getSingleResult();
        if (doc == null) {
            return null;
        }
        return doc.tuple();
    }

}

package cj.netos.fission.chatroom;

import cj.lns.chip.sos.cube.framework.ICube;
import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.lns.chip.sos.cube.framework.TupleDocument;
import cj.netos.fission.AbstractService;
import cj.netos.fission.IChatroomService;
import cj.netos.fission.IPayRecordService;
import cj.netos.fission.IPersonService;
import cj.netos.fission.model.Chatroom;
import cj.netos.fission.model.PayRecord;
import cj.netos.fission.model.Person;
import cj.netos.fission.model.RoomMember;
import cj.netos.rabbitmq.IRabbitMQProducer;
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

    @Override
    public void enter(String recordSn, String payer, String payerName, String payee, String payeeName) throws CircuitException {
        //为支付者方建群；将被支付人加为成员；发出通知
        String payerFull = String.format("%s@gbera.netos", payer);
        String payeeFull = String.format("%s@gbera.netos", payee);
        String roomId = Encript.md5(payerFull);
        Chatroom chatroom = getChatroom(payerFull, roomId);
        if (chatroom == null) {
            Person payerPerson = personService.get(payer);
            chatroom = createChatroom(payerFull, roomId, payerPerson);
            addMember(chatroom,payerFull,payerPerson,"creator");
            return;
        }

        if (existsMember(chatroom, payeeFull)) {
            return;
        }
        //添加成员

        Person payeePerson = personService.get(payee);
        addMember(chatroom, payeeFull, payeePerson,"user");
        PayRecord record = payRecordService.getRecord(recordSn);
        pushAddMemberEvent(chatroom, payeeFull, payeePerson, record);
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
        String content = String.format("欢迎%s进群！%s领取了¥%s元，谢谢群主红包，", payeePerson.getNickName(),payeePerson.getNickName(), decimal.toString());
        byte[] body = content.getBytes();
        rabbitMQProducer.publish("jobCenter", properties, body);
    }

    private void addMember(Chatroom chatroom, String personFull, Person personInfo,String actor) {
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

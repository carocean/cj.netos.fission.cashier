package cj.netos.fission.service;

import cj.netos.fission.IFissionRecordService;
import cj.netos.fission.mapper.*;
import cj.netos.fission.model.AbsorbInRecord;
import cj.netos.fission.model.BusinessInRecord;
import cj.netos.fission.model.IncomeRecord;
import cj.netos.fission.util.IdWorker;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import cj.ultimate.gson2.com.google.gson.Gson;
import com.rabbitmq.client.AMQP;

import java.util.HashMap;

@CjBridge(aspects = "@transaction")
@CjService(name = "fissionRecordService")
public class FissionRecordService implements IFissionRecordService {

    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.IncomeRecordMapper")
    IncomeRecordMapper incomeRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.OutcomeRecordMapper")
    OutcomeRecordMapper outcomeRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.AbsorbInRecordMapper")
    AbsorbInRecordMapper absorbInRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.AbsorbOutRecordMapper")
    AbsorbOutRecordMapper absorbOutRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.BusinessInRecordMapper")
    BusinessInRecordMapper businessInRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.BusinessShuntRecordMapper")
    BusinessShuntRecordMapper businessShuntRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.BusinessRefundRecordMapper")
    BusinessRefundRecordMapper businessRefundRecordMapper;

    @CjServiceRef(refByName = "@.rabbitmq.producer.shunt-withdraw-to-account")
    IRabbitMQProducer shuntWithdrawToAccountRabbitMQProducer;

    @CjServiceRef(refByName = "@.rabbitmq.producer.shunt-recharge-to-account")
    IRabbitMQProducer shuntRechargeToAccountRabbitMQProducer;

    @CjTransaction
    @Override
    public void income(String person, String nickName, long amount, String refsn) throws CircuitException {
        IncomeRecord record = new IncomeRecord();
        record.setSn(new IdWorker().nextId());
        record.setPerson(person);
        record.setNickName(nickName);
        record.setCurrency("CNY");
        record.setAmount(amount);
        record.setRefsn(refsn);
        record.setState(0);
        record.setState(200);
        record.setMessage("ok");
        incomeRecordMapper.insert(record);

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/fission/account.mhub")
                .headers(new HashMap<String, Object>() {{
                    put("command", "income");
                }})
                .build();
        shuntWithdrawToAccountRabbitMQProducer.publish("fission.account", properties, new Gson().toJson(record).getBytes());
    }


    @CjTransaction
    @Override
    public void inAbsorb(String person, String nickName, long amount, String refsn) throws CircuitException {
        AbsorbInRecord record = new AbsorbInRecord();
        record.setSn(new IdWorker().nextId());
        record.setPerson(person);
        record.setNickName(nickName);
        record.setCurrency("CNY");
        record.setAmount(amount);
        record.setRefsn(refsn);
        record.setState(0);
        record.setState(200);
        record.setMessage("ok");
        absorbInRecordMapper.insert(record);

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/fission/account.mhub")
                .headers(new HashMap<String, Object>() {{
                    put("command", "inAbsorb");
                }})
                .build();
        shuntWithdrawToAccountRabbitMQProducer.publish("fission.account", properties, new Gson().toJson(record).getBytes());
    }

    @CjTransaction
    @Override
    public void inBusiness(String person, String nickName, long amount, String refsn) throws CircuitException {
        BusinessInRecord record = new BusinessInRecord();
        record.setSn(new IdWorker().nextId());
        record.setPerson(person);
        record.setNickName(nickName);
        record.setCurrency("CNY");
        record.setAmount(amount);
        record.setRefsn(refsn);
        record.setState(0);
        record.setState(200);
        record.setMessage("ok");
        businessInRecordMapper.insert(record);

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/fission/account.mhub")
                .headers(new HashMap<String, Object>() {{
                    put("command", "inBusiness");
                }})
                .build();
        shuntRechargeToAccountRabbitMQProducer.publish("fission.account", properties, new Gson().toJson(record).getBytes());
    }
}

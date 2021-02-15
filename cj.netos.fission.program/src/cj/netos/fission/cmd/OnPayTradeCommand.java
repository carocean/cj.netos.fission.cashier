package cj.netos.fission.cmd;

import cj.netos.fission.ICuratorPathChecker;
import cj.netos.fission.IRechargeActivityController;
import cj.netos.fission.PaymentResult;
import cj.netos.fission.util.CashierUtils;
import cj.netos.rabbitmq.CjConsumer;
import cj.netos.rabbitmq.RabbitMQException;
import cj.netos.rabbitmq.RetryCommandException;
import cj.netos.rabbitmq.consumer.IConsumerCommand;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.LongString;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;

import java.io.IOException;
import java.util.UUID;

@CjConsumer(name = "fromWallet_onPayTrade")
@CjService(name = "/wallet/trade.mhub#payTrade")
public class OnPayTradeCommand implements IConsumerCommand {
    @CjServiceRef(refByName = "curator.framework")
    CuratorFramework framework;

    @CjServiceRef
    ICuratorPathChecker curatorPathChecker;
    @CjServiceRef
    IRechargeActivityController rechargeActivityController;
    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException, IOException {
        LongString payeeType = (LongString) properties.getHeaders().get("payeeType");
        if (!"fission-mf".equals(payeeType.toString())) {//1为洇取器
            throw new RetryCommandException("301", "不是向交个朋友付款的事件，返回给mhub");
        }
        String json = new String(body);
        PaymentResult result = new Gson().fromJson(json, PaymentResult.class);
        //每个用户一个锁
        String person= CashierUtils.getAccountCode(result.getDetails().getPayeeCode());
        result.getDetails().setPayeeCode(person);
        String path = String.format("/fission/mf/%s/locks", person);
        try {
            curatorPathChecker.check(framework, path);
        } catch (Exception e) {
            throw new RabbitMQException("500", e);
        }
        InterProcessReadWriteLock lock = new InterProcessReadWriteLock(framework, path);
        InterProcessMutex mutex = lock.writeLock();
        try {
            mutex.acquire();
            rechargeActivityController.recharge(result);
        } catch (Exception e) {
            String msg = e.getMessage();
            if (!StringUtil.isEmpty(msg)) {
                msg = msg.substring(0, msg.length() > 200 ? 200 : msg.length());
            }
            rechargeActivityController.error(result,500,msg);
            CJSystem.logging().error(getClass(), e);
            CircuitException ce = CircuitException.search(e);
            if (ce == null) {
                throw new RabbitMQException(ce.getStatus(), e);
            }
            throw new RabbitMQException("500", e);
        } finally {
            try {
                mutex.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

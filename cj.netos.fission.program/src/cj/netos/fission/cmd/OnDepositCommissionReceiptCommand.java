package cj.netos.fission.cmd;

import cj.netos.fission.ICuratorPathChecker;
import cj.netos.fission.IDepositCommissionActivityController;
import cj.netos.fission.IWithdrawActivityController;
import cj.netos.fission.util.CashierUtils;
import cj.netos.rabbitmq.CjConsumer;
import cj.netos.rabbitmq.RabbitMQException;
import cj.netos.rabbitmq.RetryCommandException;
import cj.netos.rabbitmq.consumer.IConsumerCommand;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.ultimate.util.StringUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;

import java.io.IOException;

@CjConsumer(name = "fission-mf")
@CjService(name = "/cashier/receipt.mhub#depositCommission")
public class OnDepositCommissionReceiptCommand implements IConsumerCommand {
    @CjServiceRef(refByName = "curator.framework")
    CuratorFramework framework;

    @CjServiceRef
    ICuratorPathChecker curatorPathChecker;
    @CjServiceRef
    IDepositCommissionActivityController depositCommissionActivityController;
    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException, IOException {
        String person=properties.getHeaders().getOrDefault("person","").toString();
        String refsn=properties.getHeaders().getOrDefault("refsn","").toString();
        person=CashierUtils.getAccountCode(person);
        String nickName=properties.getHeaders().getOrDefault("nick-name","").toString();
        long amount=(long)properties.getHeaders().getOrDefault("amount",0L);
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
            depositCommissionActivityController.deposit(person,nickName,amount,refsn);
        } catch (Exception e) {
            String msg = e.getMessage();
            if (!StringUtil.isEmpty(msg)) {
                msg = msg.substring(0, msg.length() > 200 ? 200 : msg.length());
            }
            depositCommissionActivityController.error(person ,nickName,amount,refsn,500,msg);
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

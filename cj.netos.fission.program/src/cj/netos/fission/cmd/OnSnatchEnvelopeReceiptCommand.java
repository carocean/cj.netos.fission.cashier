package cj.netos.fission.cmd;

import cj.netos.fission.ICuratorPathChecker;
import cj.netos.fission.IPersonService;
import cj.netos.fission.ISnatchEnveloperActivityController;
import cj.netos.fission.IWithdrawActivityController;
import cj.netos.fission.model.Person;
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
@CjService(name = "/cashier/receipt.mhub#snatchEnvelope")
public class OnSnatchEnvelopeReceiptCommand implements IConsumerCommand {
    @CjServiceRef(refByName = "curator.framework")
    CuratorFramework framework;

    @CjServiceRef
    ICuratorPathChecker curatorPathChecker;

    @CjServiceRef
    ISnatchEnveloperActivityController snatchEnveloperActivityController;
    @CjServiceRef
    IPersonService personService;

    @Override
    public void command(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws RabbitMQException, RetryCommandException, IOException {
        String payer = properties.getHeaders().getOrDefault("payer", "").toString();
        payer = CashierUtils.getAccountCode(payer);
        String payeeName = properties.getHeaders().getOrDefault("payee-name", "").toString();
        String payee = properties.getHeaders().getOrDefault("payee", "").toString();
        payee = CashierUtils.getAccountCode(payee);
        String recordSn = properties.getHeaders().getOrDefault("record_sn", "").toString();
        Person personPayer = personService.get(payer);
        if (personPayer == null) {
            snatchEnveloperActivityController.error(recordSn, payer, personPayer.getNickName(), payee, payeeName, 404, "被抢人不存在:" + payee);
            throw new RabbitMQException("500", "被抢人不存在:" + payee);
        }
        String path = String.format("/fission/mf/%s/locks", payer);
        try {
            curatorPathChecker.check(framework, path);
        } catch (Exception e) {
            throw new RabbitMQException("500", e);
        }
        InterProcessReadWriteLock lock = new InterProcessReadWriteLock(framework, path);
        InterProcessMutex mutex = lock.writeLock();
        try {
            mutex.acquire();
            snatchEnveloperActivityController.snatchEnveloper(recordSn, payer, personPayer.getNickName(), payee, payeeName);
        } catch (Exception e) {
            String msg = e.getMessage();
            if (!StringUtil.isEmpty(msg)) {
                msg = msg.substring(0, msg.length() > 200 ? 200 : msg.length());
            }
            snatchEnveloperActivityController.error(recordSn, payer, personPayer.getNickName(), payee, payeeName, 500, msg);
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

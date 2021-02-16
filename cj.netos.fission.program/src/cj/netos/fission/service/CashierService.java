package cj.netos.fission.service;

import cj.netos.fission.*;
import cj.netos.fission.mapper.CashierMapper;
import cj.netos.fission.model.*;
import cj.netos.fission.model.PayRecord;
import cj.netos.fission.util.CashierUtils;
import cj.netos.fission.util.IdWorker;
import cj.netos.rabbitmq.IRabbitMQProducer;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.orm.mybatis.annotation.CjTransaction;
import com.rabbitmq.client.AMQP;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;

@CjBridge(aspects = "@transaction")
@CjService(name = "cashierService")
public class CashierService implements ICashierService {
    @CjServiceRef
    ICashierBalanceService cashierBalanceService;
    @CjServiceRef
    ICashierBillService cashierBillService;
    @CjServiceRef
    IRechargeRecordService rechargeRecordService;
    @CjServiceRef
    IWithdrawRecordService withdrawRecordService;
    @CjServiceRef
    IPayRecordService payRecordService;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.CashierMapper")
    CashierMapper cashierMapper;
    @CjServiceRef(refByName = "@.rabbitmq.producer.withdraw-to-wallet")
    IRabbitMQProducer rabbitMQProducer;
    @CjServiceRef
    ISnatchEnvelopeAlgorithm snatchEnvelopeAlgorithm;

    @CjTransaction
    @Override
    public Cashier getAndInitCashier(String person) {
        Cashier cashier = cashierMapper.selectByPrimaryKey(person);
        if (cashier != null) {
            return cashier;
        }
        cashier = new Cashier();
        cashier.setType(0);
        cashier.setState(0);
        cashier.setPerson(person);
        cashier.setAmplitudeFactor(new BigDecimal("2.0"));
        cashier.setCacAverage(30L);
        cashier.setDayAmount(0L);
        cashierMapper.insert(cashier);
        return cashier;
    }

    @CjTransaction
    @Override
    public void setCacAverage(String principal, long cacAverage) {
        cashierMapper.setCacAverage(principal, cacAverage);
    }

    @CjTransaction
    @Override
    public void setAmplitudeFactor(String principal, BigDecimal amplitudeFactor) {
        cashierMapper.setAmplitudeFactor(principal, amplitudeFactor);
    }

    @CjTransaction
    @Override
    public void recharge(PaymentResult result) {
        PayDetails details = result.getDetails();
        String payeeCode = details.getPayeeCode();
        CashierBalance balance = cashierBalanceService.getAndInitBalance(payeeCode);
        Cashier cashier = getAndInitCashier(payeeCode);

        RechargeRecord record = new RechargeRecord();
        record.setSn(new IdWorker().nextId());
        record.setRecharger(payeeCode);
        record.setNickName(details.getPayeeName());
        record.setCurrency("CNY");
        record.setRechargeStrategy(cashier.getType());
        record.setDayLimitAmount(cashier.getDayAmount());
        record.setState(1);
        record.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        record.setAmount(result.getAmount());
        record.setRefOrderSn(details.getOrderNo());
        record.setRefOrderTitle(details.getOrderTitle());
        record.setRefPaySn(details.getPaySn());
        record.setStatus(200);
        record.setMessage("ok");
        record.setNote(details.getNote());
        rechargeRecordService.add(record);


        CashierBill bill = new CashierBill();
        bill.setSn(new IdWorker().nextId());
        bill.setTitle("充钱到出纳柜台");
        bill.setPerson(payeeCode);
        bill.setNickName(details.getPayeeName());
        bill.setAmount(record.getAmount());
        long balanceAmount = balance.getBalance() + bill.getAmount();
        bill.setBalance(balanceAmount);
        bill.setOrder(0);
        bill.setRefsn(record.getSn());
        bill.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        bill.setWorkday(CashierUtils.dateTimeToDay(System.currentTimeMillis()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        bill.setDay(calendar.get(Calendar.DAY_OF_MONTH));
        bill.setMonth(calendar.get(Calendar.MONTH));
        bill.setSeason(calendar.get(Calendar.MONTH) % 4);
        bill.setYear(calendar.get(Calendar.YEAR));
        bill.setNote(details.getNote());
        cashierBillService.add(bill);

        cashierBalanceService.updateBalance(payeeCode, balanceAmount);
    }

    @CjTransaction
    @Override
    public void rechargeError(PaymentResult result, int status, String message) {
        PayDetails details = result.getDetails();
        String payeeCode = details.getPayeeCode();
        RechargeRecord record = new RechargeRecord();
        record.setSn(new IdWorker().nextId());
        record.setRecharger(payeeCode);
        record.setNickName(details.getPayeeName());
        record.setCurrency("CNY");
        record.setRechargeStrategy(0);
        record.setDayLimitAmount(0L);
        record.setState(1);
        record.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        record.setAmount(result.getAmount());
        record.setRefOrderSn(details.getOrderNo());
        record.setRefOrderTitle(details.getOrderTitle());
        record.setRefPaySn(details.getPaySn());
        record.setStatus(status);
        record.setMessage(message);
        record.setNote(details.getNote());
        rechargeRecordService.add(record);
    }

    @CjTransaction
    @Override
    public void withdraw(String person, String nickName, long amount) throws CircuitException {
        getAndInitCashier(person);
        CashierBalance balance = cashierBalanceService.getAndInitBalance(person);
        if (balance.getBalance() < amount) {
            withdrawErrow(person, nickName, amount, 1002, String.format("金额不足:%s<%s", balance.getBalance(), amount));
            return;
        }
        WithdrawRecord record = new WithdrawRecord();
        record.setSn(new IdWorker().nextId());
        record.setWithdrawer(person);
        record.setNickName(nickName);
        record.setCurrency("CNY");
        record.setAmount(amount);
        record.setState(1);
        record.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        record.setStatus(200);
        record.setMessage("ok");
        withdrawRecordService.add(record);

        CashierBill bill = new CashierBill();
        bill.setSn(new IdWorker().nextId());
        bill.setTitle("提现到零钱");
        bill.setPerson(person);
        bill.setNickName(nickName);
        bill.setAmount(record.getAmount() * -1);
        long balanceAmount = balance.getBalance() + bill.getAmount();
        bill.setBalance(balanceAmount);
        bill.setOrder(1);
        bill.setRefsn(record.getSn());
        bill.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        bill.setWorkday(CashierUtils.dateTimeToDay(System.currentTimeMillis()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        bill.setDay(calendar.get(Calendar.DAY_OF_MONTH));
        bill.setMonth(calendar.get(Calendar.MONTH));
        bill.setSeason(calendar.get(Calendar.MONTH) % 4);
        bill.setYear(calendar.get(Calendar.YEAR));
        bill.setNote(null);
        cashierBillService.add(bill);

        cashierBalanceService.updateBalance(person, balanceAmount);

        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                .type("/wallet/receipt.mhub")
                .headers(new HashMap<String, Object>() {{
                    put("command", "transIn");
                    put("module-id", "fission/mf");
                    put("module-title", "裂变游戏·交个朋友");
                    put("person", String.format("%s@gbera.netos", person));
                    put("nick-name", nickName);
                    put("amount", amount);
                    put("note", "裂变游戏·交个朋友·转入账款");
                }})
                .build();
        rabbitMQProducer.publish("fission.mf", properties, new byte[0]);
    }


    @CjTransaction
    @Override
    public void withdrawErrow(String person, String nickName, long amount, int status, String message) {
        WithdrawRecord record = new WithdrawRecord();
        record.setSn(new IdWorker().nextId());
        record.setWithdrawer(person);
        record.setNickName(nickName);
        record.setCurrency("CNY");
        record.setAmount(amount);
        record.setState(1);
        record.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        record.setStatus(status);
        record.setMessage(message);
        withdrawRecordService.add(record);
    }

    @CjTransaction
    @Override
    public CashierBalance getCashierBalance(String principal) {
        CashierBalance balance = cashierBalanceService.getAndInitBalance(principal);
        return balance;
    }

    @CjTransaction
    @Override
    public void startCashier(String person) {
        getAndInitCashier(person);
        cashierMapper.updateState(person, 0, null);
    }

    @CjTransaction
    @Override
    public void stopCashier(String person, String closedCause) {
        getAndInitCashier(person);
        cashierMapper.updateState(person, 1, closedCause);
    }

    @CjTransaction
    @Override
    public void snatchEnveloper(String recordSn, String person, String payerName, String payee, String payeeName) throws CircuitException {
        Cashier cashier = getAndInitCashier(person);
        CashierBalance balance = getCashierBalance(person);
        long amount = snatchEnvelopeAlgorithm.snatchEnvelopeDynamic(cashier.getCacAverage(), cashier.getAmplitudeFactor().doubleValue());
        if (amount > balance.getBalance()) {
            snatchEnveloperError(recordSn, person, payerName, payee, payeeName,amount, 1002, String.format("余额不足:%s > %s",amount,balance.getBalance()));
            throw new CircuitException("1002", "余额不足");
        }
        PayRecord record = new PayRecord();
        record.setSn(recordSn);
        record.setPayer(person);
        record.setPayerName(payerName);
        record.setPayee(payee);
        record.setPayeeName(payeeName);
        record.setCurrency("CNY");
        record.setAmount(amount);
        record.setState(1);
        record.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        record.setStatus(200);
        record.setMessage("ok");
        record.setNote(null);
        payRecordService.add(record);

        addPayerBill(record, balance);
        addPayeeBill(record, balance);
    }

    private void addPayerBill(PayRecord record, CashierBalance balance) {
        CashierBill bill = new CashierBill();
        bill.setSn(new IdWorker().nextId());
        bill.setTitle("红包发放");
        bill.setPerson(record.getPayer());
        bill.setNickName(record.getPayerName());
        bill.setAmount(record.getAmount() * -1);
        long balanceAmount = balance.getBalance() + bill.getAmount();
        bill.setBalance(balanceAmount);
        bill.setOrder(2);
        bill.setRefsn(record.getSn());
        bill.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        bill.setWorkday(CashierUtils.dateTimeToDay(System.currentTimeMillis()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        bill.setDay(calendar.get(Calendar.DAY_OF_MONTH));
        bill.setMonth(calendar.get(Calendar.MONTH));
        bill.setSeason(calendar.get(Calendar.MONTH) % 4);
        bill.setYear(calendar.get(Calendar.YEAR));
        bill.setNote(record.getNote());
        cashierBillService.add(bill);

        cashierBalanceService.updateBalance(record.getPayer(), balanceAmount);
    }

    private void addPayeeBill(PayRecord record, CashierBalance balance) {
        CashierBill bill = new CashierBill();
        bill.setSn(new IdWorker().nextId());
        bill.setTitle("红包收益");
        bill.setPerson(record.getPayee());
        bill.setNickName(record.getPayeeName());
        bill.setAmount(record.getAmount());
        long balanceAmount = balance.getBalance() + bill.getAmount();
        bill.setBalance(balanceAmount);
        bill.setOrder(3);
        bill.setRefsn(record.getSn());
        bill.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        bill.setWorkday(CashierUtils.dateTimeToDay(System.currentTimeMillis()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        bill.setDay(calendar.get(Calendar.DAY_OF_MONTH));
        bill.setMonth(calendar.get(Calendar.MONTH));
        bill.setSeason(calendar.get(Calendar.MONTH) % 4);
        bill.setYear(calendar.get(Calendar.YEAR));
        bill.setNote(record.getNote());
        cashierBillService.add(bill);

        cashierBalanceService.updateBalance(record.getPayee(), balanceAmount);
    }

    @CjTransaction
    @Override
    public void snatchEnveloperError(String recordSn, String person, String payerName, String payee, String payeeName,long amount, int status, String msg) {
        PayRecord record = new PayRecord();
        record.setSn(recordSn);
        record.setPayer(person);
        record.setPayerName(payerName);
        record.setPayee(payee);
        record.setPayeeName(payeeName);
        record.setCurrency("CNY");
        record.setAmount(amount);
        record.setState(1);
        record.setCtime(CashierUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        record.setStatus(status);
        record.setMessage(msg);
        record.setNote(null);
        payRecordService.add(record);
    }
}
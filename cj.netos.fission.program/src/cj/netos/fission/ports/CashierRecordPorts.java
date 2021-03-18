package cj.netos.fission.ports;

import cj.netos.fission.ICashierRecordService;
import cj.netos.fission.IPersonService;
import cj.netos.fission.model.*;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CjService(name = "/cashier/record.ports")
public class CashierRecordPorts implements ICashierRecordPorts {
    @CjServiceRef
    ICashierRecordService cashierRecordService;
    @CjServiceRef
    IPersonService personService;
    @Override
    public RechargeRecord getRechargeRecord(ISecuritySession session, String sn) throws CircuitException {
        return cashierRecordService.getRechargeRecord(sn);
    }

    @Override
    public DepositCommission getDepositCommissionRecord(ISecuritySession session, String sn) throws CircuitException {
        return cashierRecordService.getDepositCommissionRecord(sn);
    }

    @Override
    public WithdrawRecord getWithdrawRecord(ISecuritySession session, String sn) throws CircuitException {
        return cashierRecordService.getWithdrawRecord(sn);
    }

    @Override
    public PayRecord getPayRecord(ISecuritySession session, String sn) throws CircuitException {
        return cashierRecordService.getPayRecord(sn);
    }

    @Override
    public List<PayPerson> pagePayerDetails(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<PayRecord> records = cashierRecordService.pagePayerRecord(securitySession.principal(), limit, offset);
        List<String> ids = new ArrayList<>();
        for (PayRecord record : records) {
            ids.add(record.getPayer());
        }
        Map<String, Person> personMap = personService.mapPersonIn(ids);
        List<PayPerson> list = new ArrayList<>();
        for (PayRecord record : records) {
            PayPerson payPerson = new PayPerson();
            payPerson.load(record);
            Person person = personMap.get(record.getPayer());
            payPerson.setPerson(person);
            list.add(payPerson);
        }
        return list;
    }

    @Override
    public List<Person> pagePayerInfo(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<String> ids = cashierRecordService.pagePayerId(securitySession.principal(), limit, offset);
        List<Person> personList = personService.listPersonIn(ids);
        return personList;
    }
    @Override
    public List<PayPerson> pagePayeeDetails(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<PayRecord> records= cashierRecordService.pagePayeeRecord(securitySession.principal(),limit,offset);
        List<String> ids = new ArrayList<>();
        for (PayRecord record : records) {
            ids.add(record.getPayee());
        }
        Map<String, Person> personMap = personService.mapPersonIn(ids);
        List<PayPerson> list = new ArrayList<>();
        for (PayRecord record : records) {
            PayPerson payPerson = new PayPerson();
            payPerson.load(record);
            Person person = personMap.get(record.getPayee());
            payPerson.setPerson(person);
            list.add(payPerson);
        }
        return list;
    }

    @Override
    public List<Person> pagePayeeInfo(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<String> ids = cashierRecordService.pagePayeeId(securitySession.principal(), limit, offset);
        List<Person> personList = personService.listPersonIn(ids);
        return personList;
    }


    @Override
    public Long totalPayer(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalPayer(securitySession.principal());
    }

    @Override
    public Long totalPayerOnDay(ISecuritySession securitySession, String dayTime) throws CircuitException {
        return cashierRecordService.totalPayerOnDay(securitySession.principal(),dayTime);
    }

    @Override
    public Long totalPayee(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalPayee(securitySession.principal());
    }

    @Override
    public Long totalPayeeOfDay(ISecuritySession securitySession, String dayTime) throws CircuitException {
        return cashierRecordService.totalPayeeOfDay(securitySession.principal(),dayTime);
    }
}

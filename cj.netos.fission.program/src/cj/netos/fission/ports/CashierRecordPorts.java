package cj.netos.fission.ports;

import cj.netos.fission.ICashierRecordService;
import cj.netos.fission.IPersonService;
import cj.netos.fission.model.*;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.math.BigDecimal;
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
    public List<PayPerson> pagePayerDetails2(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<PayRecord> records = cashierRecordService.pagePayerRecord2(securitySession.principal(), limit, offset);
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
    public List<Person> pagePayerInfo2(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<String> ids = cashierRecordService.pagePayerId2(securitySession.principal(), limit, offset);
        List<Person> personList = personService.listPersonIn(ids);
        return personList;
    }

    @Override
    public List<PayPerson> pagePayeeDetails(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<PayRecord> records = cashierRecordService.pagePayeeRecord(securitySession.principal(), limit, offset);
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
    public List<PayPerson> pagePayeeDetails2(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<PayRecord> records = cashierRecordService.pagePayeeRecord2(securitySession.principal(), limit, offset);
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
    public List<Person> pagePayeeInfo2(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<String> ids = cashierRecordService.pagePayeeId2(securitySession.principal(), limit, offset);
        List<Person> personList = personService.listPersonIn(ids);
        return personList;
    }

    @Override
    public Long totalPayer(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalPayer(securitySession.principal());
    }

    @Override
    public Long totalPayer2(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalPayer2(securitySession.principal());
    }

    @Override
    public Long totalPayerOnDay(ISecuritySession securitySession, String dayTime) throws CircuitException {
        return cashierRecordService.totalPayerOnDay(securitySession.principal(), dayTime);
    }

    @Override
    public Long totalPayerOnDay2(ISecuritySession securitySession, String dayTime) throws CircuitException {
        return cashierRecordService.totalPayerOnDay2(securitySession.principal(), dayTime);
    }

    @Override
    public Long totalCommissionOnDay(ISecuritySession securitySession, String dayTime) throws CircuitException {
        return cashierRecordService.totalCommissionOnDay(securitySession.principal(), dayTime);
    }

    @Override
    public Long totalPersonAmount(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalPersonAmount(securitySession.principal());
    }

    @Override
    public Long totalPayeeAmount(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalPayeeAmount2(securitySession.principal());
    }

    @Override
    public Long totalPayee(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalPayee(securitySession.principal());
    }

    @Override
    public Long totalPayee2(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalPayee2(securitySession.principal());
    }

    @Override
    public Long totalPayeeOfDay(ISecuritySession securitySession, String dayTime) throws CircuitException {
        return cashierRecordService.totalPayeeOfDay(securitySession.principal(), dayTime);
    }

    @Override
    public Long totalPayeeOfDay2(ISecuritySession securitySession, String dayTime) throws CircuitException {
        return cashierRecordService.totalPayeeOfDay2(securitySession.principal(), dayTime);
    }

    @Override
    public Long totalPerson(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalPerson(securitySession.principal());
    }

    @Override
    public Long totalPersonOfDay(ISecuritySession securitySession, String dayTime) throws CircuitException {
        return cashierRecordService.totalPersonOfDay(securitySession.principal(), dayTime);
    }

    @Override
    public List<Person> pagePersonInfo(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<String> ids = cashierRecordService.pagePersonId(securitySession.principal(), limit, offset);
        List<Person> personList = personService.listPersonIn(ids);
        return personList;
    }

    @Override
    public List<PayPerson> pagePersonDetails(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<PayRecord> records = cashierRecordService.pagePersonRecord(securitySession.principal(), limit, offset);
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
    public Long totalStaffAmount(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalStaffAmount(securitySession.principal());
    }

    @Override
    public List<Staff> pageStaffDetails(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<Map<String, Object>> records = cashierRecordService.pageStaffRecord(securitySession.principal(), limit, offset);
        List<String> ids = new ArrayList<>();
        for (Map<String, Object> record : records) {
            ids.add((String) record.get("person"));
        }
        Map<String, Person> personMap = personService.mapPersonIn(ids);
        List<Staff> list = new ArrayList<>();
        for (Map<String, Object> record : records) {
            Staff staff = new Staff();
            Object amount=record.get("amount");
            long lngAmount=0;
            if (amount instanceof BigDecimal) {
                lngAmount=((BigDecimal)amount).longValue();
            } else if (amount instanceof Long) {
                lngAmount=(long)amount;
            }else{
                lngAmount=Long.valueOf(amount+"");
            }
            staff.setAmount(lngAmount);
            Object count=record.get("count");
            long lngCount=0;
            if (count instanceof BigDecimal) {
                lngCount=((BigDecimal)count).longValue();
            } else if (count instanceof Long) {
                lngCount=(long)count;
            }else{
                lngCount=Long.valueOf(count+"");
            }
            staff.setCount(lngCount);
            staff.setCtime((String) record.get("ctime"));
            Person person = personMap.get((String) record.get("person"));
            staff.setPerson(person);
            list.add(staff);
        }
        return list;
    }

    @Override
    public Long totalAllStaff(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalAllStaff(securitySession.principal());
    }

    @Override
    public Long totalAllStaffAmount(ISecuritySession securitySession) throws CircuitException {
        return cashierRecordService.totalAllStaffAmount(securitySession.principal());
    }

    @Override
    public List<Staff> pageAllStaffDetails(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        List<Map<String, Object>> records = cashierRecordService.pageAllStaffRecord(securitySession.principal(), limit, offset);
        List<String> ids = new ArrayList<>();
        for (Map<String, Object> record : records) {
            ids.add((String) record.get("person"));
        }
        Map<String, Person> personMap = personService.mapPersonIn(ids);
        List<Staff> list = new ArrayList<>();
        for (Map<String, Object> record : records) {
            Staff staff = new Staff();
            Object amount=record.get("amount");
            long lngAmount=0;
            if (amount instanceof BigDecimal) {
                lngAmount=((BigDecimal)amount).longValue();
            } else if (amount instanceof Long) {
                lngAmount=(long)amount;
            }else{
                lngAmount=Long.valueOf(amount+"");
            }
            staff.setAmount(lngAmount);
            Object count=record.get("count");
            long lngCount=0;
            if (count instanceof BigDecimal) {
                lngCount=((BigDecimal)count).longValue();
            } else if (count instanceof Long) {
                lngCount=(long)count;
            }else{
                lngCount=Long.valueOf(count+"");
            }
            staff.setCount(lngCount);
            staff.setCtime((String) record.get("ctime"));
            Person person = personMap.get((String) record.get("person"));
            staff.setPerson(person);
            list.add(staff);
        }
        return list;
    }
}

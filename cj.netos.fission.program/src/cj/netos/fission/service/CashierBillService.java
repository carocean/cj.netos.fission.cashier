package cj.netos.fission.service;

import cj.netos.fission.ICashierBillService;
import cj.netos.fission.mapper.CashierBillMapper;
import cj.netos.fission.model.CashierBill;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "cashierBillService")
public class CashierBillService implements ICashierBillService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.CashierBillMapper")
    CashierBillMapper cashierBillMapper;

    @CjTransaction
    @Override
    public void add(CashierBill bill) {
        cashierBillMapper.insert(bill);
    }

    @CjTransaction
    @Override
    public List<CashierBill> pageBill(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        return cashierBillMapper.pageBill(securitySession.principal(),limit,offset);
    }

    @CjTransaction
    @Override
    public List<CashierBill> pageBillByOrder(ISecuritySession securitySession, int order, int limit, long offset) throws CircuitException {
        return cashierBillMapper.pageBillByOrder(securitySession.principal(),order,limit,offset);
    }

    @CjTransaction
    @Override
    public List<CashierBill> getBillOfMonth(ISecuritySession securitySession, int year, int month, int limit, long offset) throws CircuitException {
        return cashierBillMapper.getBillOfMonth(securitySession.principal(),year,month,limit,offset);
    }

    @CjTransaction
    @Override
    public List<CashierBill> pageBillOfMonth(ISecuritySession securitySession, int order, int year, int month, int limit, long offset) throws CircuitException {
        return cashierBillMapper.pageBillOfMonth(securitySession.principal(),order,year,month,limit,offset);
    }

    @CjTransaction
    @Override
    public List<CashierBill> pageBillOfDay(ISecuritySession securitySession, int order, int year, int month, int day,int limit, long offset) throws CircuitException {
        return cashierBillMapper.pageBillOfDay(securitySession.principal(),order,year,month,day,limit,offset);
    }

    @CjTransaction
    @Override
    public long totalBillOfMonthByOrder(ISecuritySession securitySession, int order, int year, int month) throws CircuitException {
        return cashierBillMapper.totalBillOfMonthByOrder(securitySession.principal(),order,year,month);
    }

    @CjTransaction
    @Override
    public long totalBillOfDayByOrder(ISecuritySession securitySession, int order, int year, int month, int day) throws CircuitException {
        return cashierBillMapper.totalBillOfDayByOrder(securitySession.principal(),order,year,month,day);
    }
    @CjTransaction
    @Override
    public long totalBillOfAll(ISecuritySession securitySession, int order) {
        return cashierBillMapper.totalBillOfAll(securitySession.principal(),order);
    }

    @CjTransaction
    @Override
    public long totalCacAverageByMonth(ISecuritySession securitySession, int year, int month) throws CircuitException {
        return cashierBillMapper.totalCacAverageByMonth(securitySession.principal(),year,month);
    }

    @CjTransaction
    @Override
    public long totalCacAverageByDay(ISecuritySession securitySession, int year, int month,int day) throws CircuitException {
        return cashierBillMapper.totalCacAverageByDay(securitySession.principal(),year,month,day);
    }
}

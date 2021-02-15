package cj.netos.fission.ports;

import cj.netos.fission.ICashierBillService;
import cj.netos.fission.model.CashierBill;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

import java.util.List;

@CjService(name = "/cashier/bill.ports")
public class CashierBillPorts implements ICashierBillPorts {
    @CjServiceRef
    ICashierBillService cashierBillService;

    @Override
    public List<CashierBill> pageBill(ISecuritySession securitySession, int limit, long offset) throws CircuitException {
        return cashierBillService.pageBill(securitySession, limit, offset);
    }

    @Override
    public List<CashierBill> pageBillByOrder(ISecuritySession securitySession, int order, int limit, long offset) throws CircuitException {
        return cashierBillService.pageBillByOrder(securitySession, order, limit, offset);
    }

    @Override
    public List<CashierBill> getBillOfMonth(ISecuritySession securitySession, int year, int month, int limit, long offset) throws CircuitException {
        return cashierBillService.getBillOfMonth(securitySession, year, month-1, limit, offset);
    }

    @Override
    public List<CashierBill> pageBillOfMonth(ISecuritySession securitySession, int order, int year, int month, int limit, long offset) throws CircuitException {
        return cashierBillService.pageBillOfMonth(securitySession, order, year, month-1, limit, offset);
    }

    @Override
    public List<CashierBill> pageBillOfDay(ISecuritySession securitySession, int order, int year, int month, int day, int limit, long offset) throws CircuitException {
        return cashierBillService.pageBillOfDay(securitySession, order, year, month-1, day, limit, offset);
    }

    @Override
    public long totalBillOfMonthByOrder(ISecuritySession securitySession, int order, int year, int month) throws CircuitException {
        return cashierBillService.totalBillOfMonthByOrder(securitySession, order, year, month-1);
    }

    @Override
    public long totalBillOfDayByOrder(ISecuritySession securitySession, int order, int year, int month, int day) throws CircuitException {
        return cashierBillService.totalBillOfDayByOrder(securitySession, order, year, month-1, day);
    }

    @Override
    public long totalCacAverageByMonth(ISecuritySession securitySession, int year, int month) throws CircuitException {
        return cashierBillService.totalCacAverageByMonth(securitySession, year, month-1);
    }

    @Override
    public long totalCacAverageByDay(ISecuritySession securitySession, int year, int month, int day) throws CircuitException {
        return cashierBillService.totalCacAverageByDay(securitySession, year, month-1, day);
    }
}

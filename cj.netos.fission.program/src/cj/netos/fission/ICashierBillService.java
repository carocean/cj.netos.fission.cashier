package cj.netos.fission;

import cj.netos.fission.model.CashierBill;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;

import java.util.List;

public interface ICashierBillService {
    void add(CashierBill bill);

    List<CashierBill> pageBill(ISecuritySession securitySession, int limit, long offset) throws CircuitException;

    List<CashierBill> pageBillByOrder(ISecuritySession securitySession, int order, int limit, long offset) throws CircuitException;

    List<CashierBill> getBillOfMonth(ISecuritySession securitySession, int year, int month, int limit, long offset) throws CircuitException;

    List<CashierBill> pageBillOfMonth(ISecuritySession securitySession, int order, int year, int month, int limit, long offset) throws CircuitException;

    List<CashierBill> pageBillOfDay(ISecuritySession securitySession, int order, int year, int month, int day, int limit, long offset) throws CircuitException;

    long totalBillOfMonthByOrder(ISecuritySession securitySession, int order, int year, int month) throws CircuitException;

    long totalBillOfDayByOrder(ISecuritySession securitySession, int order, int year, int month, int day) throws CircuitException;

    long totalCacAverageByMonth(ISecuritySession securitySession, int year, int month) throws CircuitException;

    long totalCacAverageByDay(ISecuritySession securitySession, int year, int month, int day) throws CircuitException;

    long totalBillOfAll(ISecuritySession securitySession, int order);
}

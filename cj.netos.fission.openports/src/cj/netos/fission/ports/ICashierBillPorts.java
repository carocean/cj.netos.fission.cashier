package cj.netos.fission.ports;

import cj.netos.fission.model.CashierBill;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "出纳账单服务")
public interface ICashierBillPorts extends IOpenportService {

    @CjOpenport(usage = "分页账单")
    List<CashierBill> pageBill(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                               @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "分页账单")
    List<CashierBill> pageBillByOrder(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "指令：- 0从裂变余额入金\n" +
                                              "- 1退回到用户余额\n" +
                                              "- 2向点击者支付\n" +
                                              "- 3收益（点击头像挣得）\n", name = "order") int order,
                                      @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                      @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;


    @CjOpenport(usage = "获取指定月份账单")
    List<CashierBill> getBillOfMonth(ISecuritySession securitySession,
                                     @CjOpenportParameter(usage = "年份", name = "year") int year,
                                     @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month,
                                     @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                     @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定月份账单")
    List<CashierBill> pageBillOfMonth(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "指令：- 0从裂变余额入金\n" +
                                              "- 1退回到用户余额\n" +
                                              "- 2向点击者支付\n" +
                                              "- 3收益（点击头像挣得）\n", name = "order") int order,
                                      @CjOpenportParameter(usage = "年份", name = "year") int year,
                                      @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month,
                                      @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                      @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定日账单")
    List<CashierBill> pageBillOfDay(ISecuritySession securitySession,
                                    @CjOpenportParameter(usage = "指令：- 0从裂变余额入金\n" +
                                            "- 1退回到用户余额\n" +
                                            "- 2向点击者支付\n" +
                                            "- 3收益（点击头像挣得）\n", name = "order") int order,
                                    @CjOpenportParameter(usage = "年份", name = "year") int year,
                                    @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month,
                                    @CjOpenportParameter(usage = "日", name = "day") int day,
                                    @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                    @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;


    @CjOpenport(usage = "获取指定月份账单总金额")
    long totalBillOfMonthByOrder(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "指令：- 0从裂变余额入金\n" +
                    "- 1退回到用户余额\n" +
                    "- 2向点击者支付\n" +
                    "- 3收益（点击头像挣得）\n", name = "order") int order,
            @CjOpenportParameter(usage = "年份", name = "year") int year,
            @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定月份账单出账总金额")
    long totalBillOfDayByOrder(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "指令：- 0从裂变余额入金\n" +
                    "- 1退回到用户余额\n" +
                    "- 2向点击者支付\n" +
                    "- 3收益（点击头像挣得）\n", name = "order") int order,
            @CjOpenportParameter(usage = "年份", name = "year") int year,
            @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month,
            @CjOpenportParameter(usage = "日", name = "day") int day
    ) throws CircuitException;

    @CjOpenport(usage = "获取出入总账")
    long totalBillOfAll(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "指令：- 0从裂变余额入金\n" +
                    "- 1退回到用户余额\n" +
                    "- 2向点击者支付\n" +
                    "- 3收益（点击头像挣得）\n", name = "order") int order
    ) throws CircuitException;

    @CjOpenport(usage = "平均获客成本")
    long totalCacAverageByMonth(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "年份", name = "year") int year,
            @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month
    ) throws CircuitException;


    @CjOpenport(usage = "平均获客成本")
    long totalCacAverageByDay(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "年份", name = "year") int year,
            @CjOpenportParameter(usage = "月份。（java特性，实际用份减1）", name = "month") int month,
            @CjOpenportParameter(usage = "日", name = "day") int day
    ) throws CircuitException;
}

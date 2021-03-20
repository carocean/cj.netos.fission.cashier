package cj.netos.fission.ports;

import cj.netos.fission.model.*;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "出纳记录服务")
public interface ICashierRecordPorts extends IOpenportService {
    @CjOpenport(usage = "佣金记录单")
    DepositCommission getDepositCommissionRecord(
            ISecuritySession session,
            @CjOpenportParameter(usage = "标识", name = "sn") String sn
    ) throws CircuitException;

    @CjOpenport(usage = "充值记录单")
    RechargeRecord getRechargeRecord(
            ISecuritySession session,
            @CjOpenportParameter(usage = "标识", name = "sn") String sn
    ) throws CircuitException;

    @CjOpenport(usage = "提现记录单")
    WithdrawRecord getWithdrawRecord(
            ISecuritySession session,
            @CjOpenportParameter(usage = "标识", name = "sn") String sn
    ) throws CircuitException;

    @CjOpenport(usage = "收付记录单")
    PayRecord getPayRecord(
            ISecuritySession session,
            @CjOpenportParameter(usage = "标识", name = "sn") String sn
    ) throws CircuitException;

    @CjOpenport(usage = "点击者获取向他支付的支付人列表", elementType = PayPerson.class)
    List<PayPerson> pagePayerDetails(ISecuritySession securitySession,
                                     @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                     @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "支付者获取他所支付的人列表", elementType = Person.class)
    List<Person> pagePayeeInfo(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                               @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "点击者获取向他支付的支付人列表", elementType = Person.class)
    List<Person> pagePayerInfo(ISecuritySession securitySession,
                               @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                               @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "支付者获取他所支付的人列表", elementType = PayPerson.class)
    List<PayPerson> pagePayeeDetails(ISecuritySession securitySession,
                                     @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                     @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "点击者获取多少人向他支付")
    Long totalPayer(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "点击者获取多少人向他支付")
    Long totalPayerOnDay(ISecuritySession securitySession,
                         @CjOpenportParameter(usage = "日时间串。yyyyMMddHHmmss", name = "dayTime") String dayTime
    ) throws CircuitException;

    @CjOpenport(usage = "获取指定日拥金")
    Long totalCommissionOnDay(ISecuritySession securitySession,
                              @CjOpenportParameter(usage = "日时间串。yyyyMMddHHmmss", name = "dayTime") String dayTime
    ) throws CircuitException;

    @CjOpenport(usage = "获取拉公众的花费")
    Long totalPersonAmount(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "获取拉成员的花费")
    Long totalPayeeAmount(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "支付者获取他发展的人数")
    Long totalPayee(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "支付者获取他发展的人数")
    Long totalPayeeOfDay(ISecuritySession securitySession,
                         @CjOpenportParameter(usage = "日时间串。yyyyMMddHHmmss", name = "dayTime") String dayTime
    ) throws CircuitException;

    //
    @CjOpenport(usage = "点击者获取向他支付的支付人列表", elementType = PayPerson.class)
    List<PayPerson> pagePayerDetails2(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                      @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "支付者获取他所支付的人列表", elementType = Person.class)
    List<Person> pagePayeeInfo2(ISecuritySession securitySession,
                                @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "点击者获取向他支付的支付人列表", elementType = Person.class)
    List<Person> pagePayerInfo2(ISecuritySession securitySession,
                                @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "支付者获取他所支付的人列表", elementType = PayPerson.class)
    List<PayPerson> pagePayeeDetails2(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                      @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "点击者获取多少人向他支付")
    Long totalPayer2(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "点击者获取多少人向他支付")
    Long totalPayerOnDay2(ISecuritySession securitySession,
                          @CjOpenportParameter(usage = "日时间串。yyyyMMddHHmmss", name = "dayTime") String dayTime
    ) throws CircuitException;


    @CjOpenport(usage = "支付者获取他发展的人数")
    Long totalPayee2(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "支付者获取他发展的人数")
    Long totalPayeeOfDay2(ISecuritySession securitySession,
                          @CjOpenportParameter(usage = "日时间串。yyyyMMddHHmmss", name = "dayTime") String dayTime
    ) throws CircuitException;

    @CjOpenport(usage = "支付者获取他发展的人数")
    Long totalPerson(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "支付者获取他发展的人数")
    Long totalPersonOfDay(ISecuritySession securitySession,
                          @CjOpenportParameter(usage = "日时间串。yyyyMMddHHmmss", name = "dayTime") String dayTime
    ) throws CircuitException;

    @CjOpenport(usage = "分页关联的公众", elementType = Person.class)
    List<Person> pagePersonInfo(ISecuritySession securitySession,
                                @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "分页关联的公众", elementType = PayPerson.class)
    List<PayPerson> pagePersonDetails(ISecuritySession securitySession,
                                      @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                      @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "统计现有员工为我赚取的佣金总额")
    Long totalStaffAmount(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "获取员工明细", elementType = PayPerson.class)
    List<Staff> pageStaffDetails(ISecuritySession securitySession,
                                 @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                 @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "统计所有员工为我赚取的佣金总额")
    Long totalAllStaff(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "统计所有员工为我赚取的佣金总额")
    Long totalAllStaffAmount(ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "获取员工明细", elementType = PayPerson.class)
    List<Staff> pageAllStaffDetails(ISecuritySession securitySession,
                                 @CjOpenportParameter(usage = "页大小", name = "limit") int limit,
                                 @CjOpenportParameter(usage = "当前记录位置", name = "offset") long offset
    ) throws CircuitException;
}

package cj.netos.fission.ports;

import cj.netos.fission.model.*;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.PKeyInRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.math.BigDecimal;
import java.util.List;

@CjOpenports(usage = "出纳柜台服务")
public interface ICashierPorts extends IOpenportService {

    @CjOpenport(usage = "获取余额")
    CashierBalance getCashierBalance(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "获取出纳柜台")
    Cashier getCashier(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "获取配置")
    MfSettings getSettings(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "设置代理人")
    void setSalesman(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "代理人公号", name = "person") String person
    ) throws CircuitException;

    @CjOpenport(usage = "获取老板的信息")
    BossInfo getBossInfo(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "提交认购需求")
    void setRequirement(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "想成为代理", name = "becomeAgent") int becomeAgent,
            @CjOpenportParameter(usage = "电话", name = "phone") String phone
    ) throws CircuitException;

    @CjOpenport(usage = "获取业务提成比率")
    List<BusinessIncomeRatio> listBusinessIncomeRatio(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "尝试进行提现分账")
    WithdrawShuntBO computeWithdrawShuntInfo(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "待分的金额", name = "amount") long amount
    ) throws CircuitException;

    @CjOpenport(usage = "获取配置的留存余额，如果用户没有配置的则取系统的")
    long getStayBalance(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "设置获客平均")
    void setCacAverage(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "获客成本，每客平均花费", name = "cacAverage") long cacAverage
    ) throws CircuitException;

    @CjOpenport(usage = "设置振幅因子")
    void setAmplitudeFactor(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "振幅因子", name = "amplitudeFactor") BigDecimal amplitudeFactor
    ) throws CircuitException;

    @CjOpenport(usage = "评估当前可获客数")
    long assessCacCount(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "开启营业")
    void startCashier(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "停止营业")
    void stopCashier(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "关停原因", name = "closedCause") String closedCause
    ) throws CircuitException;

    @CjOpenport(usage = "获取算法信息")
    AlgorithmInfo getAlgorithmInfo(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "配置标签", command = "post")
    void configTags(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "标签数据，json格式", name = "tags", in = PKeyInRequest.content, elementType = Tag.class) List<Tag> tags
    ) throws CircuitException;

    @CjOpenport(usage = "获取标签")
    List<Tag> listAllTag(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "添加限定标签")
    void addLimitTag(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "导演者。payer 即支付者限定想要获取什么标签的用户\n" +
                    "payee即被支付者限定想要获取什么标签的用户", name = "direct") String direct,
            @CjOpenportParameter(usage = "标签标识", name = "tagId") String tagId
    ) throws CircuitException;

    @CjOpenport(usage = "移除限定标签")
    void removeLimitTag(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "导演者。payer 即支付者限定想要获取什么标签的用户\n" +
                    "payee即被支付者限定想要获取什么标签的用户", name = "direct") String direct,
            @CjOpenportParameter(usage = "标签标识", name = "tagId") String tagId
    ) throws CircuitException;

    @CjOpenport(usage = "获取我的限定标签")
    List<Tag> listLimitTag(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "导演者。payer 即支付者限定想要获取什么标签的用户\n" +
                    "payee即被支付者限定想要获取什么标签的用户", name = "direct") String direct
    ) throws CircuitException;

    @CjOpenport(usage = "设置限定区域")
    void setLimitArea(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "导演者。payer 即支付者限定想要获取什么标签的用户\n" +
                    "payee即被支付者限定想要获取什么标签的用户", name = "direct") String direct,
            @CjOpenportParameter(usage = "类型：around周边\n" +
                    "provincine 省\n" +
                    "city 市\n" +
                    "等等", name = "areaType") String areaType,
            @CjOpenportParameter(usage = "区域名", name = "areaTitle") String areaTitle,
            @CjOpenportParameter(usage = "代号，在同一个area_type下不为空", name = "areaCode") String areaCode
    ) throws CircuitException;

    @CjOpenport(usage = "清除限定区域")
    void emptyLimitArea(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "导演者。payer 即支付者限定想要获取什么标签的用户\n" +
                    "payee即被支付者限定想要获取什么标签的用户", name = "direct") String direct
    ) throws CircuitException;

    @CjOpenport(usage = "清除我推荐过的，仅管理员有权")
    void emptyRecommendeds(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "公号不带租户", name = "person") String person
    ) throws CircuitException;

    @CjOpenport(usage = "获取限定区域")
    LimitArea getLimitArea(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "导演者。payer 即支付者限定想要获取什么标签的用户\n" +
                    "payee即被支付者限定想要获取什么标签的用户", name = "direct") String direct
    ) throws CircuitException;

    @CjOpenport(usage = "设置我的属性标签")
    void addPropertyTag(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "标签标识", name = "tagId") String tagId
    ) throws CircuitException;

    @CjOpenport(usage = "设置我的属性标签")
    void removePropertyTag(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "标签标识", name = "tagId") String tagId
    ) throws CircuitException;

    @CjOpenport(usage = "获取我的属性标签")
    List<Tag> listMyPropertyTag(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "获取属性标签")
    List<Tag> listPropertyTagOfPerson(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "用户标识", name = "person") String person
    ) throws CircuitException;

    @CjOpenport(usage = "获取标签")
    Tag getTag(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "标签标识", name = "tagId") String tagId
    ) throws CircuitException;


    @CjOpenport(usage = "设置广告附件")
    void setAttachment(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "超链接", name = "src") String src,
            @CjOpenportParameter(usage = "类型，支持：image|video", name = "type") String type
    ) throws CircuitException;

    @CjOpenport(usage = "清除广告附件")
    void emptyAttachment(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "获取广告附件")
    Attachment getAttachment(
            ISecuritySession securitySession
    ) throws CircuitException;

    @CjOpenport(usage = "设置广告语")
    void setAdvert(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "广告词", name = "note") String note
    ) throws CircuitException;

    @CjOpenport(usage = "更新位置", command = "post")
    void updateLocation(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "位置编码，国测码", name = "location", in = PKeyInRequest.content) LatLng location,
            @CjOpenportParameter(usage = "省编码，国测码", name = "province") String province,
            @CjOpenportParameter(usage = "市编码，国测码", name = "city") String city,
            @CjOpenportParameter(usage = "区县编码，国测码", name = "district") String district,
            @CjOpenportParameter(usage = "乡镇编码，国测码", name = "town") String town,
            @CjOpenportParameter(usage = "省编码，国测码", name = "provinceCode") String provinceCode,
            @CjOpenportParameter(usage = "市编码，国测码", name = "cityCode") String cityCode,
            @CjOpenportParameter(usage = "区县编码，国测码", name = "districtCode") String districtCode,
            @CjOpenportParameter(usage = "乡镇编码，国测码", name = "townCode") String townCode
    ) throws CircuitException;
}

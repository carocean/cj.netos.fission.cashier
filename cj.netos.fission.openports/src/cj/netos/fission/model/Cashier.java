package cj.netos.fission.model;

import java.math.BigDecimal;

/**
 * Table: cashier
 */
public class Cashier {
    /**
     * Column: person
     */
    private String person;

    /**
     * Column: state
     * Remark: 0 正常营业 1 停止营业
     */
    private Integer state;

    /**
     * Column: type
     * Remark: 0 为手动 1 为按日自动
     */
    private Integer type;

    /**
     * Column: day_amount
     * Remark: 如果是按日自动充，此为每日限额,单位为分
     */
    private Long dayAmount;

    /**
     * Column: cac_average
     * Remark: 获客成本，获取一个用户的平均成本，单位为分
     */
    private Long cacAverage;

    /**
     * Column: amplitude_factor
     * Remark: 振幅因子，默认2.0 并不等同于振幅，用于调整每个红包的最大上限
     */
    private BigDecimal amplitudeFactor;

    /**
     * Column: checked_withdraw_pt
     * Remark: 是否签过了提现协议 0为没有 1为有
     */
    private Integer checkedWithdrawPt;

    /**
     * Column: closed_cause
     * Remark: 停业原因： 主人手停 余额不足1元自动停
     */
    private String closedCause;

    /**
     * Column: stay_balance
     * Remark: 用户的留存余额，如果为空则启用mf_settings配置的留存余额 用于控制那些反复提现的，越高他要抢的就要越多才能提现
     */
    private Long stayBalance;

    /**
     * Column: referrer
     * Remark: 指向c端抢红包的推荐人
     */
    private String referrer;

    /**
     * Column: referrer_name
     * Remark: 引擎名昵称
     */
    private String referrerName;

    /**
     * Column: supports_chatroom
     * Remark: 是否支持拉群。一般情况只要充过值就支持拉群 0是不支持 1是支持
     */
    private Integer supportsChatroom;

    /**
     * Column: salesman
     * Remark: 该用户(成为超级会员才有）的客户经理，即上级 在商户通过客户经理二维码扫码关联后，则成为该客户经理的用户 客户经理的角色是动态产生的，因此在会计日需要系统计算出来（市、省是签约角色，但在该地区如发现了竞争相当的会提示压力，明年则有可能不被续约），如： - 代理人：初级（一阶）、中级（二阶）、高级（三阶） - 运营商：为二级。分为：初级（一阶）、中级（二阶）、高级（三阶） - 市代：拿一个市的平台返点 - 省代：拿一个省的平台返点
     */
    private String salesman;

    /**
     * Column: area_master
     * Remark: 区域代理，或叫区域运营商，由高阶竞争制发展而来。 - city市代 - province省代
     */
    private String areaMaster;

    /**
     * Column: stage
     * Remark: 是二级三阶制中的阶数，总分为3阶，该字段是计算出来的。由系统根据直接发展的下游会员数计算而得
     */
    private Integer stage;

    /**
     * Column: level
     * Remark: 是二级三阶制中的级别，总分为2级，该字段是计算出来的。由系统根据cashier表的salesman的父子节构计算出来
     */
    private Integer level;

    /**
     * Column: is_request
     * Remark: 是否提交了需求单 0未提交 1提交
     */
    private Integer isRequest;

    /**
     * Column: become_agent
     * Remark: 是否想做代理 0 不想 1 想
     */
    private Integer becomeAgent;

    /**
     * Column: phone
     * Remark: 联系电话
     */
    private String phone;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getDayAmount() {
        return dayAmount;
    }

    public void setDayAmount(Long dayAmount) {
        this.dayAmount = dayAmount;
    }

    public Long getCacAverage() {
        return cacAverage;
    }

    public void setCacAverage(Long cacAverage) {
        this.cacAverage = cacAverage;
    }

    public BigDecimal getAmplitudeFactor() {
        return amplitudeFactor;
    }

    public void setAmplitudeFactor(BigDecimal amplitudeFactor) {
        this.amplitudeFactor = amplitudeFactor;
    }

    public Integer getCheckedWithdrawPt() {
        return checkedWithdrawPt;
    }

    public void setCheckedWithdrawPt(Integer checkedWithdrawPt) {
        this.checkedWithdrawPt = checkedWithdrawPt;
    }

    public String getClosedCause() {
        return closedCause;
    }

    public void setClosedCause(String closedCause) {
        this.closedCause = closedCause == null ? null : closedCause.trim();
    }

    public Long getStayBalance() {
        return stayBalance;
    }

    public void setStayBalance(Long stayBalance) {
        this.stayBalance = stayBalance;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer == null ? null : referrer.trim();
    }

    public String getReferrerName() {
        return referrerName;
    }

    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName == null ? null : referrerName.trim();
    }

    public Integer getSupportsChatroom() {
        return supportsChatroom;
    }

    public void setSupportsChatroom(Integer supportsChatroom) {
        this.supportsChatroom = supportsChatroom;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    public String getAreaMaster() {
        return areaMaster;
    }

    public void setAreaMaster(String areaMaster) {
        this.areaMaster = areaMaster == null ? null : areaMaster.trim();
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsRequest() {
        return isRequest;
    }

    public void setIsRequest(Integer isRequest) {
        this.isRequest = isRequest;
    }

    public Integer getBecomeAgent() {
        return becomeAgent;
    }

    public void setBecomeAgent(Integer becomeAgent) {
        this.becomeAgent = becomeAgent;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}
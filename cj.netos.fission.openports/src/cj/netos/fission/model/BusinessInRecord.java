package cj.netos.fission.model;

import java.math.BigDecimal;

/**
 * Table: business_in_record
 */
public class BusinessInRecord {
    /**
     * Column: sn
     */
    private String sn;

    /**
     * Column: person
     * Remark: 用户
     */
    private String person;

    /**
     * Column: nick_name
     * Remark: 昵称
     */
    private String nickName;

    /**
     * Column: currency
     * Remark: 币种
     */
    private String currency;

    /**
     * Column: amount
     * Remark: 退还金额
     */
    private Long amount;

    /**
     * Column: state
     * Remark: 0为创建 1为完成
     */
    private Integer state;

    /**
     * Column: shunt_state
     * Remark: 分账状态 0未分账 1已分账
     */
    private Integer shuntState;

    /**
     * Column: refsn
     * Remark: 关联充值单
     */
    private String refsn;

    /**
     * Column: salesman
     * Remark: 经手的业务员
     */
    private String salesman;

    /**
     * Column: shunt_ratio
     * Remark: 充值平台收账比率
     */
    private BigDecimal shuntRatio;

    /**
     * Column: ctime
     */
    private String ctime;

    /**
     * Column: status
     * Remark: 处理状态
     */
    private Integer status;

    /**
     * Column: message
     * Remark: 处理消息
     */
    private String message;

    /**
     * Column: note
     */
    private String note;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person == null ? null : person.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getShuntState() {
        return shuntState;
    }

    public void setShuntState(Integer shuntState) {
        this.shuntState = shuntState;
    }

    public String getRefsn() {
        return refsn;
    }

    public void setRefsn(String refsn) {
        this.refsn = refsn == null ? null : refsn.trim();
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    public BigDecimal getShuntRatio() {
        return shuntRatio;
    }

    public void setShuntRatio(BigDecimal shuntRatio) {
        this.shuntRatio = shuntRatio;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}
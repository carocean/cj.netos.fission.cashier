package cj.netos.fission.model;

import java.math.BigDecimal;

/**
 * Table: withdraw_record
 */
public class WithdrawRecord {
    /**
     * Column: sn
     */
    private String sn;

    /**
     * Column: withdrawer
     * Remark: 退款人
     */
    private String withdrawer;

    /**
     * Column: nick_name
     * Remark: 充值时退款者的昵称
     */
    private String nickName;

    /**
     * Column: currency
     * Remark: 币种
     */
    private String currency;

    /**
     * Column: amount
     * Remark: 实际出账金额，是各个分账之和
     */
    private Long amount;

    /**
     * Column: income_ratio
     * Remark: 提现平台分账比率
     */
    private BigDecimal incomeRatio;

    /**
     * Column: commission_ratio
     * Remark: 引荐人的提拥率
     */
    private BigDecimal commissionRatio;

    /**
     * Column: absorb_ratio
     * Remark: 洇金分账账比
     */
    private BigDecimal absorbRatio;

    /**
     * Column: shunt_ratio
     * Remark: 提现分账比率=平如账比+洇金账比
     */
    private BigDecimal shuntRatio;

    /**
     * Column: income_amount
     * Remark: 平台分账金额
     */
    private Long incomeAmount;

    /**
     * Column: absorb_amount
     * Remark: 洇金分账金额
     */
    private Long absorbAmount;

    /**
     * Column: commission_amount
     * Remark: 引荐人的实际提拥金额
     */
    private Long commissionAmount;

    /**
     * Column: gain_amount
     * Remark: 提现人实际得到的，即利润
     */
    private Long gainAmount;

    /**
     * Column: state
     * Remark: 0为创建 1为完成
     */
    private Integer state;

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

    public String getWithdrawer() {
        return withdrawer;
    }

    public void setWithdrawer(String withdrawer) {
        this.withdrawer = withdrawer == null ? null : withdrawer.trim();
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

    public BigDecimal getIncomeRatio() {
        return incomeRatio;
    }

    public void setIncomeRatio(BigDecimal incomeRatio) {
        this.incomeRatio = incomeRatio;
    }

    public BigDecimal getCommissionRatio() {
        return commissionRatio;
    }

    public void setCommissionRatio(BigDecimal commissionRatio) {
        this.commissionRatio = commissionRatio;
    }

    public BigDecimal getAbsorbRatio() {
        return absorbRatio;
    }

    public void setAbsorbRatio(BigDecimal absorbRatio) {
        this.absorbRatio = absorbRatio;
    }

    public BigDecimal getShuntRatio() {
        return shuntRatio;
    }

    public void setShuntRatio(BigDecimal shuntRatio) {
        this.shuntRatio = shuntRatio;
    }

    public Long getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Long incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public Long getAbsorbAmount() {
        return absorbAmount;
    }

    public void setAbsorbAmount(Long absorbAmount) {
        this.absorbAmount = absorbAmount;
    }

    public Long getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Long commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public Long getGainAmount() {
        return gainAmount;
    }

    public void setGainAmount(Long gainAmount) {
        this.gainAmount = gainAmount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
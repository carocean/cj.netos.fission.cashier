package cj.netos.fission.model;

import java.math.BigDecimal;

/**
 * Table: mf_settings
 */
public class MfSettings {
    /**
     * Column: id
     * Remark: 标识
     */
    private String id;

    /**
     * Column: stay_balance
     * Remark: 余额留存资金最少金额限制
     */
    private Long stayBalance;

    /**
     * Column: withdraw_income_ratio
     * Remark: 提现平台分账比率
     */
    private BigDecimal withdrawIncomeRatio;

    /**
     * Column: withdraw_absorb_ratio
     * Remark: 洇金分账账比
     */
    private BigDecimal withdrawAbsorbRatio;

    /**
     * Column: withdraw_shunt_ratio
     * Remark: 提现分账比率=平如账比+洇金账比
     */
    private BigDecimal withdrawShuntRatio;

    /**
     * Column: recharge_shunt_ratio
     * Remark: 充值平台收账比率
     */
    private BigDecimal rechargeShuntRatio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getStayBalance() {
        return stayBalance;
    }

    public void setStayBalance(Long stayBalance) {
        this.stayBalance = stayBalance;
    }

    public BigDecimal getWithdrawIncomeRatio() {
        return withdrawIncomeRatio;
    }

    public void setWithdrawIncomeRatio(BigDecimal withdrawIncomeRatio) {
        this.withdrawIncomeRatio = withdrawIncomeRatio;
    }

    public BigDecimal getWithdrawAbsorbRatio() {
        return withdrawAbsorbRatio;
    }

    public void setWithdrawAbsorbRatio(BigDecimal withdrawAbsorbRatio) {
        this.withdrawAbsorbRatio = withdrawAbsorbRatio;
    }

    public BigDecimal getWithdrawShuntRatio() {
        return withdrawShuntRatio;
    }

    public void setWithdrawShuntRatio(BigDecimal withdrawShuntRatio) {
        this.withdrawShuntRatio = withdrawShuntRatio;
    }

    public BigDecimal getRechargeShuntRatio() {
        return rechargeShuntRatio;
    }

    public void setRechargeShuntRatio(BigDecimal rechargeShuntRatio) {
        this.rechargeShuntRatio = rechargeShuntRatio;
    }
}
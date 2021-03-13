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
     * Column: withdraw_comm_ratio
     * Remark: 提现拥金率，如果有推荐人的话
     */
    private BigDecimal withdrawCommRatio;

    /**
     * Column: withdraw_shunt_ratio
     * Remark: 提现分账比率=平如账比+洇金账比+提拥账比
     */
    private BigDecimal withdrawShuntRatio;

    /**
     * Column: refund_limit_day
     * Remark: 充许多少天内可退款
     */
    private Integer refundLimitDay;

    /**
     * Column: commission_stage1
     * Remark: 一阶提成率
     */
    private BigDecimal commissionStage1;

    /**
     * Column: commission_stage2
     * Remark: 二阶提成率
     */
    private BigDecimal commissionStage2;

    /**
     * Column: commission_stage3
     * Remark: 三阶提成率
     */
    private BigDecimal commissionStage3;

    /**
     * Column: platform_return_level2
     * Remark: 平台返给2级点数，而一级是按3阶来提成的
     */
    private BigDecimal platformReturnLevel2;

    /**
     * Column: platform_return_city_ratio
     * Remark: 默认的平台返点给市代比率
     */
    private BigDecimal platformReturnCityRatio;

    /**
     * Column: platform_return_province_ratio
     * Remark: 默认的平台返点给省代比率
     */
    private BigDecimal platformReturnProvinceRatio;

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

    public BigDecimal getWithdrawCommRatio() {
        return withdrawCommRatio;
    }

    public void setWithdrawCommRatio(BigDecimal withdrawCommRatio) {
        this.withdrawCommRatio = withdrawCommRatio;
    }

    public BigDecimal getWithdrawShuntRatio() {
        return withdrawShuntRatio;
    }

    public void setWithdrawShuntRatio(BigDecimal withdrawShuntRatio) {
        this.withdrawShuntRatio = withdrawShuntRatio;
    }

    public Integer getRefundLimitDay() {
        return refundLimitDay;
    }

    public void setRefundLimitDay(Integer refundLimitDay) {
        this.refundLimitDay = refundLimitDay;
    }

    public BigDecimal getCommissionStage1() {
        return commissionStage1;
    }

    public void setCommissionStage1(BigDecimal commissionStage1) {
        this.commissionStage1 = commissionStage1;
    }

    public BigDecimal getCommissionStage2() {
        return commissionStage2;
    }

    public void setCommissionStage2(BigDecimal commissionStage2) {
        this.commissionStage2 = commissionStage2;
    }

    public BigDecimal getCommissionStage3() {
        return commissionStage3;
    }

    public void setCommissionStage3(BigDecimal commissionStage3) {
        this.commissionStage3 = commissionStage3;
    }

    public BigDecimal getPlatformReturnLevel2() {
        return platformReturnLevel2;
    }

    public void setPlatformReturnLevel2(BigDecimal platformReturnLevel2) {
        this.platformReturnLevel2 = platformReturnLevel2;
    }

    public BigDecimal getPlatformReturnCityRatio() {
        return platformReturnCityRatio;
    }

    public void setPlatformReturnCityRatio(BigDecimal platformReturnCityRatio) {
        this.platformReturnCityRatio = platformReturnCityRatio;
    }

    public BigDecimal getPlatformReturnProvinceRatio() {
        return platformReturnProvinceRatio;
    }

    public void setPlatformReturnProvinceRatio(BigDecimal platformReturnProvinceRatio) {
        this.platformReturnProvinceRatio = platformReturnProvinceRatio;
    }
}
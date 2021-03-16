package cj.netos.fission.model;

import java.math.BigDecimal;

public class WithdrawShuntBO {
    long gainAmount;
    long shuntAmount;
    long absorbAmount;
    long commissionAmount;
    long incomeAmount;
    BigDecimal withdrawIncomeRatio;
    BigDecimal withdrawAbsorbRatio;
    BigDecimal withdrawCommRatio;
    BigDecimal withdrawShuntRatio;

    public long getGainAmount() {
        return gainAmount;
    }

    public void setGainAmount(long gainAmount) {
        this.gainAmount = gainAmount;
    }

    public long getShuntAmount() {
        return shuntAmount;
    }

    public void setShuntAmount(long shuntAmount) {
        this.shuntAmount = shuntAmount;
    }

    public long getAbsorbAmount() {
        return absorbAmount;
    }

    public void setAbsorbAmount(long absorbAmount) {
        this.absorbAmount = absorbAmount;
    }

    public long getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(long commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public long getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(long incomeAmount) {
        this.incomeAmount = incomeAmount;
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
}

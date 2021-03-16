package cj.netos.fission.model;

import java.util.List;

public class BossInfo {
    long balance;
    long payeeAmount;
    long commission;
    long payeeCount;
    long empCount;
    long payerCount;
    List<String> membersTop5;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getPayeeAmount() {
        return payeeAmount;
    }

    public void setPayeeAmount(long payeeAmount) {
        this.payeeAmount = payeeAmount;
    }

    public long getCommission() {
        return commission;
    }

    public void setCommission(long commission) {
        this.commission = commission;
    }

    public long getPayeeCount() {
        return payeeCount;
    }

    public void setPayeeCount(long payeeCount) {
        this.payeeCount = payeeCount;
    }

    public long getEmpCount() {
        return empCount;
    }

    public void setEmpCount(long empCount) {
        this.empCount = empCount;
    }

    public long getPayerCount() {
        return payerCount;
    }

    public void setPayerCount(long payerCount) {
        this.payerCount = payerCount;
    }

    public List<String> getMembersTop5() {
        return membersTop5;
    }

    public void setMembersTop5(List<String> membersTop5) {
        this.membersTop5 = membersTop5;
    }
}

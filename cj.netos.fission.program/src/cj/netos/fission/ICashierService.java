package cj.netos.fission;

import cj.netos.fission.model.Cashier;
import cj.netos.fission.model.CashierBalance;
import cj.studio.ecm.net.CircuitException;

import java.math.BigDecimal;
import java.util.List;

public interface ICashierService {
    Cashier getAndInitCashier(String person);

    void recharge(PaymentResult result) throws CircuitException;

    void rechargeError(PaymentResult result, int status, String message);

    void withdraw(String person, String nickName, long amount) throws CircuitException;

    void withdrawErrow(String person, String nickName, long amount, int status, String message);

    CashierBalance getCashierBalance(String principal);

    void startCashier(String principal);

    void stopCashier(String principal,String closedCause);


    void setCacAverage(String principal, long cacAverage);

    void setAmplitudeFactor(String principal, BigDecimal amplitudeFactor);

    void snatchEnveloper(String recordSn, String person, String payerName, String payee, String payeeName) throws CircuitException;

    void snatchEnveloperError(String recordSn, String person, String nickName, String payee,String payeeName,long amount, int status, String msg);

    void setSalesman(String principal, String person);

    void setRequirement(String principal, int becomeAgent, String phone);

    long totalEmployeeCount(String principal);

    void depositCommission(String person, String nickName, long amount, String refsn);

    void depositCommissionError(String person, String nickName, long amount, String refsn, int status, String message);

    List<String> pageStaffId(String principal, int limit, long offset);

    Long totalStaff(String principal);

}

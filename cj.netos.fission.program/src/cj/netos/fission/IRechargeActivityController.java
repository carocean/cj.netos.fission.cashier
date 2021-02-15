package cj.netos.fission;

public interface IRechargeActivityController {
    void recharge(PaymentResult result);

    void error(PaymentResult result, int status, String message);

}

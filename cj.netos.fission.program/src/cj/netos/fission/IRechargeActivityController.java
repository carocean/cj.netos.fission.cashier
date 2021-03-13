package cj.netos.fission;

import cj.studio.ecm.net.CircuitException;

public interface IRechargeActivityController {
    void recharge(PaymentResult result) throws CircuitException;

    void error(PaymentResult result, int status, String message);

}

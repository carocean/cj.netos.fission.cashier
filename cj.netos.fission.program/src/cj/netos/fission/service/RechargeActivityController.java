package cj.netos.fission.service;

import cj.netos.fission.ICashierService;
import cj.netos.fission.IRechargeActivityController;
import cj.netos.fission.PaymentResult;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "rechargeActivityController")
public class RechargeActivityController implements IRechargeActivityController {

    @CjServiceRef
    ICashierService cashierService;
    @Override
    public void recharge(PaymentResult result) throws CircuitException {
        cashierService.recharge(result);
    }

    @Override
    public void error(PaymentResult result, int status, String message) {
        cashierService.rechargeError(result,status,message);
    }
}

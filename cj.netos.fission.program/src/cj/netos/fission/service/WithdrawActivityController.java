package cj.netos.fission.service;

import cj.netos.fission.ICashierService;
import cj.netos.fission.IWithdrawActivityController;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "withdrawActivityController")
public class WithdrawActivityController implements IWithdrawActivityController {

    @CjServiceRef
    ICashierService cashierService;

    @Override
    public void withdraw(String person, String nickName, long amount) throws CircuitException {
        cashierService.withdraw(person, nickName, amount);
    }

    @Override
    public void error(String person, String nickName, long amount, int status, String message) {
        cashierService.withdrawErrow(person, nickName, amount, status, message);
    }
}

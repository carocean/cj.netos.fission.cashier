package cj.netos.fission.service;

import cj.netos.fission.ICashierService;
import cj.netos.fission.IDepositCommissionActivityController;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;

@CjService(name = "depositCommissionActivityController")
public class DepositCommissionActivityController implements IDepositCommissionActivityController {

    @CjServiceRef
    ICashierService cashierService;
    @Override
    public void deposit(String person, String nickName, long amount, String refsn) {
        cashierService.depositCommission(person,nickName,amount,refsn);
    }

    @Override
    public void error(String person, String nickName, long amount, String refsn, int status, String message) {
        cashierService.depositCommissionError(person, nickName, amount,refsn, status, message);
    }
}

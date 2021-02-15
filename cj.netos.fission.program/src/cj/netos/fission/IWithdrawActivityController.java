package cj.netos.fission;

import cj.studio.ecm.net.CircuitException;

public interface IWithdrawActivityController {
    void withdraw(String person, String nickName, long amount) throws CircuitException;

    void error(String person, String nickName, long amount, int status, String message);

}

package cj.netos.fission;

public interface IDepositCommissionActivityController {
    void deposit(String person, String nickName, long amount, String refsn);

    void error(String person, String nickName, long amount, String refsn, int status, String message);

}

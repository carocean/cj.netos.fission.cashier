package cj.netos.fission;

import cj.studio.ecm.net.CircuitException;

import java.math.BigDecimal;

public interface IFissionRecordService {

    void income(String person, String nickName, long incomeAmount, String refsn) throws CircuitException;

    void inAbsorb(String person, String nickName, long absorbAmount, String refsn) throws CircuitException;

    void inBusiness(String payeeCode, String payeeName, long shuntAmount, String sn, String salesman, BigDecimal shuntRatio) throws CircuitException;

}

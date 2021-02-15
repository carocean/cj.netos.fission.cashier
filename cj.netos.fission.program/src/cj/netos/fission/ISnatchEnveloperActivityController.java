package cj.netos.fission;

import cj.studio.ecm.net.CircuitException;

public interface ISnatchEnveloperActivityController {
    void snatchEnveloper(String recordSn, String person, String payerName, String payee, String payeeName) throws CircuitException;

    void error(String recordSn,String person, String nickName, String payee,  String payeeName,int status, String message);

}

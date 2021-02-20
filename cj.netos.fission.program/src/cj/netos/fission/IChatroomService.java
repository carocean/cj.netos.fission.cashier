package cj.netos.fission;

import cj.studio.ecm.net.CircuitException;

public interface IChatroomService {
    void enter(String recordSn, String payer, String payerName, String payee, String payeeName) throws CircuitException;

}

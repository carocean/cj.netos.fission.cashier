package cj.netos.fission;

import cj.netos.fission.model.WithdrawRecord;
import cj.studio.ecm.net.CircuitException;

public interface IChatroomService {
    void enter(String recordSn, String payer, String payerName, String payee, String payeeName) throws CircuitException;

    void commission(WithdrawRecord record, String person, String nickName, long amount) throws CircuitException;

}

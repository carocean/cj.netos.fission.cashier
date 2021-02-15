package cj.netos.fission.service;

import cj.netos.fission.ICashierService;
import cj.netos.fission.ISnatchEnveloperActivityController;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "snatchEnveloperActivityController")
public class SnatchEnveloperActivityController implements ISnatchEnveloperActivityController {

    @CjServiceRef
    ICashierService cashierService;

    @Override
    public void snatchEnveloper(String recordSn, String person, String payerName, String payee, String payeeName) throws CircuitException {
        cashierService.snatchEnveloper(recordSn,person, payerName,payee,payeeName);
    }

    @Override
    public void error(String recordSn, String person, String nickName, String payee,String payeeName, int status, String msg) {
        cashierService.snatchEnveloperError(recordSn,person, nickName,payee,payeeName,0, status, msg);
    }
}

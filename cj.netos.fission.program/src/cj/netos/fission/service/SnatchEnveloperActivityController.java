package cj.netos.fission.service;

import cj.netos.fission.ICashierService;
import cj.netos.fission.IChatroomService;
import cj.netos.fission.ISnatchEnveloperActivityController;
import cj.netos.fission.ITaskService;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;

@CjService(name = "snatchEnveloperActivityController")
public class SnatchEnveloperActivityController implements ISnatchEnveloperActivityController {

    @CjServiceRef
    ICashierService cashierService;
    @CjServiceRef
    ITaskService taskService;
    @CjServiceRef
    IChatroomService chatroomService;
    @Override
    public void snatchEnveloper(String recordSn, String payer, String payerName, String payee, String payeeName) throws CircuitException {
        cashierService.snatchEnveloper(recordSn, payer, payerName, payee, payeeName);
        try {
            taskService.addOpTimers(payee);
        } catch (Exception e) {
            CJSystem.logging().error(getClass(), String.format("增加任务计数失败:%s", e));
        }
        try {
            chatroomService.enter(recordSn,payer,payerName,payee,payeeName);
        } catch (Exception e) {
            CJSystem.logging().error(getClass(), String.format("聊天室服务处理失败:%s", e));
        }
    }

    @Override
    public void error(String recordSn, String person, String nickName, String payee, String payeeName, int status, String msg) {
        cashierService.snatchEnveloperError(recordSn, person, nickName, payee, payeeName, 0, status, msg);
    }
}

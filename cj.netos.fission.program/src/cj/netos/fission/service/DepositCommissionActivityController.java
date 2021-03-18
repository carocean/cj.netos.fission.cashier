package cj.netos.fission.service;

import cj.netos.fission.ICashierRecordService;
import cj.netos.fission.ICashierService;
import cj.netos.fission.IChatroomService;
import cj.netos.fission.IDepositCommissionActivityController;
import cj.netos.fission.model.RechargeRecord;
import cj.netos.fission.model.WithdrawRecord;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;

@CjService(name = "depositCommissionActivityController")
public class DepositCommissionActivityController implements IDepositCommissionActivityController {
    @CjServiceRef
    IChatroomService chatroomService;
    @CjServiceRef
    ICashierService cashierService;
    @CjServiceRef
    ICashierRecordService cashierRecordService;

    @Override
    public void deposit(String person, String nickName, long amount, String refsn) {
        cashierService.depositCommission(person, nickName, amount, refsn);
        try {
            WithdrawRecord record = cashierRecordService.getWithdrawRecord(refsn);
            chatroomService.commission(record, person, nickName, amount);
        } catch (Exception e) {
            CJSystem.logging().error(getClass(), String.format("聊天室服务处理失败:%s", e));
        }
    }

    @Override
    public void error(String person, String nickName, long amount, String refsn, int status, String message) {
        cashierService.depositCommissionError(person, nickName, amount, refsn, status, message);
    }
}

package cj.netos.fission.service;

import cj.netos.fission.IRechargeRecordService;
import cj.netos.fission.mapper.RechargeRecordMapper;
import cj.netos.fission.model.RechargeRecord;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "@transaction")
@CjService(name = "rechargeRecordService")
public class RechargeRecordService implements IRechargeRecordService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.RechargeRecordMapper")
    RechargeRecordMapper rechargeRecordMapper;

    @CjTransaction
    @Override
    public void add(RechargeRecord record) {
        rechargeRecordMapper.insert(record);
    }

    @CjTransaction
    @Override
    public void error(String paySn, int status, String message) {
        rechargeRecordMapper.updateStatus(paySn, status, message);
    }
}

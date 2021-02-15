package cj.netos.fission.service;

import cj.netos.fission.IWithdrawRecordService;
import cj.netos.fission.mapper.WithdrawRecordMapper;
import cj.netos.fission.model.WithdrawRecord;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "@transaction")
@CjService(name = "withdrawRecordService")
public class WithdrawRecordService implements IWithdrawRecordService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.WithdrawRecordMapper")
    WithdrawRecordMapper withdrawRecordMapper;

    @CjTransaction
    @Override
    public void add(WithdrawRecord record) {
        withdrawRecordMapper.insert(record);
    }
}

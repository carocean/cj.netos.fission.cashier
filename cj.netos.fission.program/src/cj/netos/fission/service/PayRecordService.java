package cj.netos.fission.service;

import cj.netos.fission.IPayRecordService;
import cj.netos.fission.mapper.PayRecordMapper;
import cj.netos.fission.model.PayRecord;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "@transaction")
@CjService(name = "payRecordService")
public class PayRecordService implements IPayRecordService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.PayRecordMapper")
    PayRecordMapper payRecordMapper;

    @CjTransaction
    @Override
    public void add(PayRecord record) {
        payRecordMapper.insert(record);
    }

    @CjTransaction
    @Override
    public PayRecord getRecord(String recordSn) {
        return payRecordMapper.selectByPrimaryKey(recordSn);
    }
}

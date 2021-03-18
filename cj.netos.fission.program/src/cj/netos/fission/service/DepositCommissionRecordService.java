package cj.netos.fission.service;

import cj.netos.fission.IDepositCommissionRecordService;
import cj.netos.fission.mapper.DepositCommissionMapper;
import cj.netos.fission.model.DepositCommission;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

@CjBridge(aspects = "@transaction")
@CjService(name = "depositCommissionRecordService")
public class DepositCommissionRecordService implements IDepositCommissionRecordService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.DepositCommissionMapper")
    DepositCommissionMapper depositCommissionMapper;

    @CjTransaction
    @Override
    public void add(DepositCommission record) {
        depositCommissionMapper.insert(record);
    }
}

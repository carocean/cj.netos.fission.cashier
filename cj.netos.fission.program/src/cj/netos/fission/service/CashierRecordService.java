package cj.netos.fission.service;

import cj.netos.fission.ICashierRecordService;
import cj.netos.fission.IDepositCommissionRecordService;
import cj.netos.fission.mapper.DepositCommissionMapper;
import cj.netos.fission.mapper.PayRecordMapper;
import cj.netos.fission.mapper.RechargeRecordMapper;
import cj.netos.fission.mapper.WithdrawRecordMapper;
import cj.netos.fission.model.DepositCommission;
import cj.netos.fission.model.PayRecord;
import cj.netos.fission.model.RechargeRecord;
import cj.netos.fission.model.WithdrawRecord;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "cashierRecordService")
public class CashierRecordService implements ICashierRecordService {
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.RechargeRecordMapper")
    RechargeRecordMapper rechargeRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.WithdrawRecordMapper")
    WithdrawRecordMapper withdrawRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.PayRecordMapper")
    PayRecordMapper payRecordMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.fission.mapper.DepositCommissionMapper")
    DepositCommissionMapper depositCommissionMapper;

    @CjTransaction
    @Override
    public RechargeRecord getRechargeRecord(String sn) {
        return rechargeRecordMapper.selectByPrimaryKey(sn);
    }

    @CjTransaction
    @Override
    public DepositCommission getDepositCommissionRecord(String sn) {
        return depositCommissionMapper.selectByPrimaryKey(sn);
    }

    @CjTransaction
    @Override
    public WithdrawRecord getWithdrawRecord(String sn) {
        return withdrawRecordMapper.selectByPrimaryKey(sn);
    }

    @CjTransaction
    @Override
    public PayRecord getPayRecord(String sn) {
        return payRecordMapper.selectByPrimaryKey(sn);
    }

    @CjTransaction
    @Override
    public List<PayRecord> pagePayerRecord(String payer, int limit, long offset) {
        return payRecordMapper.pagePayerRecord(payer, limit, offset);
    }

    @CjTransaction
    @Override
    public List<PayRecord> pagePayeeRecord(String payee, int limit, long offset) {
        return payRecordMapper.pagePayeeRecord(payee, limit, offset);
    }

    @CjTransaction
    @Override
    public List<String> pagePayerId(String payer, int limit, long offset) {
        return payRecordMapper.pagePayerId(payer, limit, offset);
    }

    @CjTransaction
    @Override
    public List<String> pagePayeeId(String payee, int limit, long offset) {
        return payRecordMapper.pagePayeeId(payee, limit, offset);
    }

    @CjTransaction
    @Override
    public Long totalPayer(String principal) {
        return payRecordMapper.totalPayer(principal);
    }

    @CjTransaction
    @Override
    public Long totalPayerOnDay(String principal, String dayTime) {
        return payRecordMapper.totalPayerOnDay(principal, dayTime + "%");
    }

    @CjTransaction
    @Override
    public Long totalCommissionOnDay(String principal, String dayTime) {
        return depositCommissionMapper.totalCommissionOnDay(principal, dayTime + "%");
    }

    @CjTransaction
    @Override
    public Long totalPayee(String principal) {
        return payRecordMapper.totalPayee(principal);
    }

    @CjTransaction
    @Override
    public Long totalPayeeOfDay(String principal, String dayTime) {
        return payRecordMapper.totalPayeeOfDay(principal, dayTime + "%");
    }

    @CjTransaction
    @Override
    public Long totalPayerAmount(String payee) {
        return payRecordMapper.totalPayerAmount(payee);
    }


    @CjTransaction
    @Override
    public long totalPayeeAmount(String payer) {
        return payRecordMapper.totalPayeeAmount(payer);
    }

    @CjTransaction
    @Override
    public Long totalPersonAmount(String payer) {
        return payRecordMapper.totalPersonAmount(payer);
    }

    @CjTransaction
    @Override
    public Long totalPayeeAmount2(String payer) {
        return payRecordMapper.totalPayeeAmount2(payer);
    }

    @CjTransaction
    @Override
    public long totalCommissionAmount(String principal) {
        return withdrawRecordMapper.totalCommissionAmount(principal);
    }

    @CjTransaction
    @Override
    public List<PayRecord> pagePayerRecord2(String principal, int limit, long offset) {
        return payRecordMapper.pagePayerRecord2(principal, limit, offset);
    }

    @CjTransaction
    @Override
    public List<String> pagePayerId2(String principal, int limit, long offset) {
        return payRecordMapper.pagePayerId2(principal, limit, offset);
    }

    @CjTransaction
    @Override
    public List<PayRecord> pagePayeeRecord2(String principal, int limit, long offset) {
        return payRecordMapper.pagePayeeRecord2(principal, limit, offset);
    }

    @CjTransaction
    @Override
    public List<String> pagePayeeId2(String principal, int limit, long offset) {
        return payRecordMapper.pagePayeeId2(principal, limit, offset);
    }

    @CjTransaction
    @Override
    public Long totalPayer2(String principal) {
        return payRecordMapper.totalPayer2(principal);
    }

    @CjTransaction
    @Override
    public Long totalPayerOnDay2(String principal, String dayTime) {
        return payRecordMapper.totalPayerOnDay2(principal, dayTime + "%");
    }

    @CjTransaction
    @Override
    public Long totalPayee2(String principal) {
        return payRecordMapper.totalPayee2(principal);
    }

    @CjTransaction
    @Override
    public Long totalPayeeOfDay2(String principal, String dayTime) {
        return payRecordMapper.totalPayeeOfDay2(principal, dayTime + "%");
    }

    @CjTransaction
    @Override
    public Long totalPerson(String principal) {
        return payRecordMapper.totalPerson(principal);
    }

    @CjTransaction
    @Override
    public Long totalPersonOfDay(String principal, String dayTime) {
        return payRecordMapper.totalPersonOfDay(principal, dayTime + "%");
    }

    @CjTransaction
    @Override
    public List<String> pagePersonId(String principal, int limit, long offset) {
        return payRecordMapper.pagePersonId(principal, limit, offset);
    }

    @CjTransaction
    @Override
    public List<PayRecord> pagePersonRecord(String principal, int limit, long offset) {
        return payRecordMapper.pagePersonRecord(principal, limit, offset);
    }
}

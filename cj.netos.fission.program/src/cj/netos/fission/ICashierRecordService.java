package cj.netos.fission;

import cj.netos.fission.model.DepositCommission;
import cj.netos.fission.model.PayRecord;
import cj.netos.fission.model.RechargeRecord;
import cj.netos.fission.model.WithdrawRecord;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

public interface ICashierRecordService {
    RechargeRecord getRechargeRecord(String sn);

    WithdrawRecord getWithdrawRecord(String sn);

    PayRecord getPayRecord(String sn);

    List<PayRecord> pagePayerRecord(String principal, int limit, long offset);

    List<PayRecord> pagePayeeRecord(String principal, int limit, long offset);

    Long totalPayer(String principal);

    Long totalPayee(String principal);
    Long totalPayeeOfDay(String principal, String dayTime);

    Long totalPayerOnDay(String principal, String dayTime);

    List<String> pagePayerId(String principal, int limit, long offset);

    List<String> pagePayeeId(String principal, int limit, long offset);
    Long totalPayerAmount(String principal);

    long totalPayeeAmount(String payer);

    long totalCommissionAmount(String principal);

    DepositCommission getDepositCommissionRecord(String sn);

    Long totalCommissionOnDay(String principal, String dayTime);

    List<PayRecord> pagePayerRecord2(String principal, int limit, long offset);

    List<String> pagePayerId2(String principal, int limit, long offset);

    List<PayRecord> pagePayeeRecord2(String principal, int limit, long offset);

    List<String> pagePayeeId2(String principal, int limit, long offset);

    Long totalPayer2(String principal);

    Long totalPayerOnDay2(String principal, String dayTime);

    Long totalPayee2(String principal);

    Long totalPayeeOfDay2(String principal, String dayTime);

    Long totalPerson(String principal);

    Long totalPersonOfDay(String principal, String dayTime);

    List<String> pagePersonId(String principal, int limit, long offset);

    List<PayRecord> pagePersonRecord(String principal, int limit, long offset);

    Long totalPersonAmount(String principal);

    Long totalPayeeAmount2(String principal);

}

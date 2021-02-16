package cj.netos.fission;

import cj.netos.fission.model.PayRecord;
import cj.netos.fission.model.RechargeRecord;
import cj.netos.fission.model.WithdrawRecord;

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

}
package cj.netos.fission;

import cj.netos.fission.model.RechargeRecord;

public interface IRechargeRecordService {
    void add(RechargeRecord record);

    void error(String paySn, int status, String message);

}

package cj.netos.fission;

import cj.netos.fission.model.PayRecord;

public interface IPayRecordService {
    void add(PayRecord record);

    PayRecord getRecord(String recordSn);

    void setRelationship(String recordSn, String relationship);

}

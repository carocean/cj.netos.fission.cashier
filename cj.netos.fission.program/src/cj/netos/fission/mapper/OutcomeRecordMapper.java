package cj.netos.fission.mapper;

import cj.netos.fission.model.OutcomeRecord;
import cj.netos.fission.model.OutcomeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutcomeRecordMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(OutcomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(OutcomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(OutcomeRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(OutcomeRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<OutcomeRecord> selectByExample(OutcomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    OutcomeRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") OutcomeRecord record, @Param("example") OutcomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") OutcomeRecord record, @Param("example") OutcomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(OutcomeRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(OutcomeRecord record);
}
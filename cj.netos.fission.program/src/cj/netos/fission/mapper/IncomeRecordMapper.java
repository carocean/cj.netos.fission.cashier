package cj.netos.fission.mapper;

import cj.netos.fission.model.IncomeRecord;
import cj.netos.fission.model.IncomeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeRecordMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(IncomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(IncomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(IncomeRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(IncomeRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<IncomeRecord> selectByExample(IncomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    IncomeRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") IncomeRecord record, @Param("example") IncomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") IncomeRecord record, @Param("example") IncomeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(IncomeRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(IncomeRecord record);
}
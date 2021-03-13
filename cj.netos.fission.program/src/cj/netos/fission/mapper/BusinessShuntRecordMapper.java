package cj.netos.fission.mapper;

import cj.netos.fission.model.BusinessShuntRecord;
import cj.netos.fission.model.BusinessShuntRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessShuntRecordMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(BusinessShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(BusinessShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(BusinessShuntRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(BusinessShuntRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<BusinessShuntRecord> selectByExample(BusinessShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BusinessShuntRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") BusinessShuntRecord record, @Param("example") BusinessShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") BusinessShuntRecord record, @Param("example") BusinessShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(BusinessShuntRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(BusinessShuntRecord record);
}
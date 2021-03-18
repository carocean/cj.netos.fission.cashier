package cj.netos.fission.mapper;

import cj.netos.fission.model.BusinessOutRecord;
import cj.netos.fission.model.BusinessOutRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessOutRecordMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(BusinessOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(BusinessOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(BusinessOutRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(BusinessOutRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<BusinessOutRecord> selectByExample(BusinessOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BusinessOutRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") BusinessOutRecord record, @Param("example") BusinessOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") BusinessOutRecord record, @Param("example") BusinessOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(BusinessOutRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(BusinessOutRecord record);
}
package cj.netos.fission.mapper;

import cj.netos.fission.model.BusinessRefundRecord;
import cj.netos.fission.model.BusinessRefundRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessRefundRecordMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(BusinessRefundRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(BusinessRefundRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(BusinessRefundRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(BusinessRefundRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<BusinessRefundRecord> selectByExample(BusinessRefundRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BusinessRefundRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") BusinessRefundRecord record, @Param("example") BusinessRefundRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") BusinessRefundRecord record, @Param("example") BusinessRefundRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(BusinessRefundRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(BusinessRefundRecord record);
}
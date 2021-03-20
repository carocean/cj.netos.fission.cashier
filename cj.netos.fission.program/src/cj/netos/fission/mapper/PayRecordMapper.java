package cj.netos.fission.mapper;

import cj.netos.fission.model.PayRecord;
import cj.netos.fission.model.PayRecordExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PayRecordMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(PayRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(PayRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<PayRecord> selectByExample(PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    PayRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") PayRecord record, @Param("example") PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") PayRecord record, @Param("example") PayRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(PayRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(PayRecord record);

    Long totalPayee(@Param(value = "payer") String payer);

    Long totalPayee2(@Param(value = "payer") String payer);
    Long totalPersonAmount(@Param(value = "payer") String payer);
    Long totalPayeeAmount2(@Param(value = "payer") String payer);
    long totalPayeeAmount(@Param(value = "payer") String payer);

    Long totalPayeeOfDay(@Param(value = "payer") String payer, @Param(value = "dayTime") String dayTime);

    Long totalPayeeOfDay2(@Param(value = "payer") String payer, @Param(value = "dayTime") String dayTime);

    List<PayRecord> pagePayeeRecord(@Param(value = "payer") String payer, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    List<PayRecord> pagePayeeRecord2(@Param(value = "payer") String payer, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    List<String> pagePayeeId(@Param(value = "payer") String payer, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    List<String> pagePayeeId2(@Param(value = "payer") String payer, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    Long totalPayer(@Param(value = "payee") String payee);

    Long totalPayer2(@Param(value = "payee") String payee);

    Long totalPayerAmount(@Param(value = "payee") String payee);

    Long totalPayerOnDay(@Param(value = "payee") String payee, @Param(value = "dayTime") String dayTime);

    Long totalPayerOnDay2(@Param(value = "payee") String payee, @Param(value = "dayTime") String dayTime);

    List<PayRecord> pagePayerRecord(@Param(value = "payee") String payee, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    List<PayRecord> pagePayerRecord2(@Param(value = "payee") String payee, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    List<String> pagePayerId(@Param(value = "payee") String payee, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    List<String> pagePayerId2(@Param(value = "payee") String payee, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    Long totalPerson(@Param(value = "payer") String payer);

    Long totalPersonOfDay(@Param(value = "payer") String payer, @Param(value = "dayTime") String dayTime);

    List<String> pagePersonId(@Param(value = "payer") String payer, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    List<PayRecord> pagePersonRecord(@Param(value = "payer") String payer, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    void setRelationship(@Param(value = "sn") String sn, @Param(value = "relationship") String relationship);

}
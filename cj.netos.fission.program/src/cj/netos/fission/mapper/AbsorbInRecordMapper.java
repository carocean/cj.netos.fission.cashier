package cj.netos.fission.mapper;

import cj.netos.fission.model.AbsorbInRecord;
import cj.netos.fission.model.AbsorbInRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbsorbInRecordMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(AbsorbInRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(AbsorbInRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(AbsorbInRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(AbsorbInRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<AbsorbInRecord> selectByExample(AbsorbInRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    AbsorbInRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") AbsorbInRecord record, @Param("example") AbsorbInRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") AbsorbInRecord record, @Param("example") AbsorbInRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(AbsorbInRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(AbsorbInRecord record);
}
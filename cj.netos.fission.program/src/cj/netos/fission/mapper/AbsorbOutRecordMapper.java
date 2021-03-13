package cj.netos.fission.mapper;

import cj.netos.fission.model.AbsorbOutRecord;
import cj.netos.fission.model.AbsorbOutRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AbsorbOutRecordMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(AbsorbOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(AbsorbOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(AbsorbOutRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(AbsorbOutRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<AbsorbOutRecord> selectByExample(AbsorbOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    AbsorbOutRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") AbsorbOutRecord record, @Param("example") AbsorbOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") AbsorbOutRecord record, @Param("example") AbsorbOutRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(AbsorbOutRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(AbsorbOutRecord record);
}
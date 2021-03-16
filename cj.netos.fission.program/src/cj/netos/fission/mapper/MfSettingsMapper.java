package cj.netos.fission.mapper;

import cj.netos.fission.model.MfSettings;
import cj.netos.fission.model.MfSettingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MfSettingsMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(MfSettingsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(MfSettingsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(MfSettings record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(MfSettings record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<MfSettings> selectByExample(MfSettingsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    MfSettings selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") MfSettings record, @Param("example") MfSettingsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") MfSettings record, @Param("example") MfSettingsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(MfSettings record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(MfSettings record);
}
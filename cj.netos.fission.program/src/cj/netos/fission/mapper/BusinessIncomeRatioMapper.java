package cj.netos.fission.mapper;

import cj.netos.fission.model.BusinessIncomeRatio;
import cj.netos.fission.model.BusinessIncomeRatioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessIncomeRatioMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(BusinessIncomeRatioExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(BusinessIncomeRatioExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(BusinessIncomeRatio record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(BusinessIncomeRatio record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<BusinessIncomeRatio> selectByExample(BusinessIncomeRatioExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BusinessIncomeRatio selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") BusinessIncomeRatio record, @Param("example") BusinessIncomeRatioExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") BusinessIncomeRatio record, @Param("example") BusinessIncomeRatioExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(BusinessIncomeRatio record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(BusinessIncomeRatio record);
}
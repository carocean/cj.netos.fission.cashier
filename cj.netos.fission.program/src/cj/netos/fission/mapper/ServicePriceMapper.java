package cj.netos.fission.mapper;

import cj.netos.fission.model.ServicePrice;
import cj.netos.fission.model.ServicePriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServicePriceMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ServicePriceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ServicePriceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ServicePrice record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ServicePrice record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ServicePrice> selectByExample(ServicePriceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ServicePrice selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ServicePrice record, @Param("example") ServicePriceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ServicePrice record, @Param("example") ServicePriceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ServicePrice record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ServicePrice record);
}
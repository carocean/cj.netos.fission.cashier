package cj.netos.fission.mapper;

import cj.netos.fission.model.DepositCommission;
import cj.netos.fission.model.DepositCommissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepositCommissionMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(DepositCommissionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(DepositCommissionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(DepositCommission record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(DepositCommission record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<DepositCommission> selectByExample(DepositCommissionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    DepositCommission selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") DepositCommission record, @Param("example") DepositCommissionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") DepositCommission record, @Param("example") DepositCommissionExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(DepositCommission record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(DepositCommission record);

    Long totalCommissionOnDay(@Param(value = "person") String person, @Param(value = "ctime")String ctime);

}
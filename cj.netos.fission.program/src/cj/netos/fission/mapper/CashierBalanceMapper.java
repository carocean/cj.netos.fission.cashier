package cj.netos.fission.mapper;

import cj.netos.fission.model.CashierBalance;
import cj.netos.fission.model.CashierBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashierBalanceMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(CashierBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(CashierBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(CashierBalance record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(CashierBalance record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<CashierBalance> selectByExample(CashierBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    CashierBalance selectByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") CashierBalance record, @Param("example") CashierBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") CashierBalance record, @Param("example") CashierBalanceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(CashierBalance record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(CashierBalance record);

    List<CashierBalance> page(@Param(value = "state") int state, @Param(value = "limit") int limit, @Param(value = "skip") int skip);

    void updateBalance(@Param(value = "person") String person, @Param(value = "balance") long balance);

    void updateState(@Param(value = "person") String person, @Param(value = "state") int state);
}
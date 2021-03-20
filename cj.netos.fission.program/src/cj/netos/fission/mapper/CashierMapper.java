package cj.netos.fission.mapper;

import cj.netos.fission.model.Cashier;
import cj.netos.fission.model.CashierExample;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.util.List;

public interface CashierMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Cashier record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Cashier record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Cashier> selectByExample(CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Cashier selectByPrimaryKey(String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Cashier record, @Param("example") CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Cashier record, @Param("example") CashierExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Cashier record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Cashier record);

    void updateState(@Param(value = "person") String person, @Param(value = "state") int state, @Param(value = "closedCause") String closedCause);

    void setCacAverage(@Param(value = "person") String person, @Param(value = "cacAverage") long cacAverage);

    void setAmplitudeFactor(@Param(value = "person") String person, @Param(value = "amplitudeFactor") BigDecimal amplitudeFactor);

    void setSalesman(@Param(value = "person") String person, @Param(value = "salesman") String salesman);

    void setSupportsChatroom(@Param(value = "person") String person, @Param(value = "supportsChatroom") int supportsChatroom);

    void setRequirement(@Param(value = "person")String person,@Param(value = "becomeAgent") int becomeAgent, @Param(value = "phone")String phone);

    List<String> pageStaffId(@Param(value = "referrer") String referrer,@Param(value = "limit") int limit,@Param(value = "offset") long offset);

    Long totalStaff(@Param(value = "referrer")String referrer);

}
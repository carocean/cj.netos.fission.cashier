package cj.netos.fission.mapper;

import cj.netos.fission.model.CashierBill;
import cj.netos.fission.model.CashierBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashierBillMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(CashierBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(CashierBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<CashierBill> selectByExample(CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    CashierBill selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") CashierBill record, @Param("example") CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") CashierBill record, @Param("example") CashierBillExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(CashierBill record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(CashierBill record);

    List<CashierBill> pageBill(@Param(value = "person") String person, @Param(value = "limit")int limit, @Param(value = "offset")long offset);

    List<CashierBill> pageBillByOrder(@Param(value = "person") String person,  @Param(value = "order")int order,@Param(value = "limit") int limit, @Param(value = "offset")long offset);

    List<CashierBill> getBillOfMonth(@Param(value = "person") String person, @Param(value = "year") int year,  @Param(value = "month")int month, @Param(value = "limit") int limit, @Param(value = "offset")long offset);

    List<CashierBill> pageBillOfMonth(@Param(value = "person") String person, @Param(value = "order")int order, @Param(value = "year") int year,  @Param(value = "month")int month, @Param(value = "limit") int limit, @Param(value = "offset")long offset);

    List<CashierBill> pageBillOfDay(@Param(value = "person") String person, @Param(value = "order")int order, @Param(value = "year") int year,  @Param(value = "month")int month, @Param(value = "day")int day, @Param(value = "limit") int limit, @Param(value = "offset")long offset);


    long totalBillOfMonthByOrder(@Param(value = "person") String person, @Param(value = "order") int order, @Param(value = "year") int year, @Param(value = "month")int month);

    long totalBillOfDayByOrder(@Param(value = "person") String person, @Param(value = "order")int order, @Param(value = "year") int year, @Param(value = "month")int month, @Param(value = "day")int day);

    long totalCacAverageByMonth(@Param(value = "person") String person, @Param(value = "year") int year,  @Param(value = "month")int month);

    long totalCacAverageByDay(@Param(value = "person") String person, @Param(value = "year") int year,  @Param(value = "month")int month,@Param(value = "day")int day);
}
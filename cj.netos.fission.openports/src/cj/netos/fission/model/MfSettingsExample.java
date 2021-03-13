package cj.netos.fission.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MfSettingsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public MfSettingsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStayBalanceIsNull() {
            addCriterion("stay_balance is null");
            return (Criteria) this;
        }

        public Criteria andStayBalanceIsNotNull() {
            addCriterion("stay_balance is not null");
            return (Criteria) this;
        }

        public Criteria andStayBalanceEqualTo(Long value) {
            addCriterion("stay_balance =", value, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andStayBalanceNotEqualTo(Long value) {
            addCriterion("stay_balance <>", value, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andStayBalanceGreaterThan(Long value) {
            addCriterion("stay_balance >", value, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andStayBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("stay_balance >=", value, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andStayBalanceLessThan(Long value) {
            addCriterion("stay_balance <", value, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andStayBalanceLessThanOrEqualTo(Long value) {
            addCriterion("stay_balance <=", value, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andStayBalanceIn(List<Long> values) {
            addCriterion("stay_balance in", values, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andStayBalanceNotIn(List<Long> values) {
            addCriterion("stay_balance not in", values, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andStayBalanceBetween(Long value1, Long value2) {
            addCriterion("stay_balance between", value1, value2, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andStayBalanceNotBetween(Long value1, Long value2) {
            addCriterion("stay_balance not between", value1, value2, "stayBalance");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioIsNull() {
            addCriterion("withdraw_income_ratio is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioIsNotNull() {
            addCriterion("withdraw_income_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioEqualTo(BigDecimal value) {
            addCriterion("withdraw_income_ratio =", value, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioNotEqualTo(BigDecimal value) {
            addCriterion("withdraw_income_ratio <>", value, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioGreaterThan(BigDecimal value) {
            addCriterion("withdraw_income_ratio >", value, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_income_ratio >=", value, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioLessThan(BigDecimal value) {
            addCriterion("withdraw_income_ratio <", value, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_income_ratio <=", value, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioIn(List<BigDecimal> values) {
            addCriterion("withdraw_income_ratio in", values, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioNotIn(List<BigDecimal> values) {
            addCriterion("withdraw_income_ratio not in", values, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_income_ratio between", value1, value2, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawIncomeRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_income_ratio not between", value1, value2, "withdrawIncomeRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioIsNull() {
            addCriterion("withdraw_absorb_ratio is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioIsNotNull() {
            addCriterion("withdraw_absorb_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioEqualTo(BigDecimal value) {
            addCriterion("withdraw_absorb_ratio =", value, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioNotEqualTo(BigDecimal value) {
            addCriterion("withdraw_absorb_ratio <>", value, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioGreaterThan(BigDecimal value) {
            addCriterion("withdraw_absorb_ratio >", value, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_absorb_ratio >=", value, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioLessThan(BigDecimal value) {
            addCriterion("withdraw_absorb_ratio <", value, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_absorb_ratio <=", value, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioIn(List<BigDecimal> values) {
            addCriterion("withdraw_absorb_ratio in", values, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioNotIn(List<BigDecimal> values) {
            addCriterion("withdraw_absorb_ratio not in", values, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_absorb_ratio between", value1, value2, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawAbsorbRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_absorb_ratio not between", value1, value2, "withdrawAbsorbRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioIsNull() {
            addCriterion("withdraw_comm_ratio is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioIsNotNull() {
            addCriterion("withdraw_comm_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioEqualTo(BigDecimal value) {
            addCriterion("withdraw_comm_ratio =", value, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioNotEqualTo(BigDecimal value) {
            addCriterion("withdraw_comm_ratio <>", value, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioGreaterThan(BigDecimal value) {
            addCriterion("withdraw_comm_ratio >", value, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_comm_ratio >=", value, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioLessThan(BigDecimal value) {
            addCriterion("withdraw_comm_ratio <", value, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_comm_ratio <=", value, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioIn(List<BigDecimal> values) {
            addCriterion("withdraw_comm_ratio in", values, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioNotIn(List<BigDecimal> values) {
            addCriterion("withdraw_comm_ratio not in", values, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_comm_ratio between", value1, value2, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawCommRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_comm_ratio not between", value1, value2, "withdrawCommRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioIsNull() {
            addCriterion("withdraw_shunt_ratio is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioIsNotNull() {
            addCriterion("withdraw_shunt_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioEqualTo(BigDecimal value) {
            addCriterion("withdraw_shunt_ratio =", value, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioNotEqualTo(BigDecimal value) {
            addCriterion("withdraw_shunt_ratio <>", value, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioGreaterThan(BigDecimal value) {
            addCriterion("withdraw_shunt_ratio >", value, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_shunt_ratio >=", value, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioLessThan(BigDecimal value) {
            addCriterion("withdraw_shunt_ratio <", value, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdraw_shunt_ratio <=", value, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioIn(List<BigDecimal> values) {
            addCriterion("withdraw_shunt_ratio in", values, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioNotIn(List<BigDecimal> values) {
            addCriterion("withdraw_shunt_ratio not in", values, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_shunt_ratio between", value1, value2, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andWithdrawShuntRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdraw_shunt_ratio not between", value1, value2, "withdrawShuntRatio");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayIsNull() {
            addCriterion("refund_limit_day is null");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayIsNotNull() {
            addCriterion("refund_limit_day is not null");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayEqualTo(Integer value) {
            addCriterion("refund_limit_day =", value, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayNotEqualTo(Integer value) {
            addCriterion("refund_limit_day <>", value, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayGreaterThan(Integer value) {
            addCriterion("refund_limit_day >", value, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_limit_day >=", value, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayLessThan(Integer value) {
            addCriterion("refund_limit_day <", value, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayLessThanOrEqualTo(Integer value) {
            addCriterion("refund_limit_day <=", value, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayIn(List<Integer> values) {
            addCriterion("refund_limit_day in", values, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayNotIn(List<Integer> values) {
            addCriterion("refund_limit_day not in", values, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayBetween(Integer value1, Integer value2) {
            addCriterion("refund_limit_day between", value1, value2, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andRefundLimitDayNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_limit_day not between", value1, value2, "refundLimitDay");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1IsNull() {
            addCriterion("commission_stage1 is null");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1IsNotNull() {
            addCriterion("commission_stage1 is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1EqualTo(BigDecimal value) {
            addCriterion("commission_stage1 =", value, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1NotEqualTo(BigDecimal value) {
            addCriterion("commission_stage1 <>", value, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1GreaterThan(BigDecimal value) {
            addCriterion("commission_stage1 >", value, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_stage1 >=", value, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1LessThan(BigDecimal value) {
            addCriterion("commission_stage1 <", value, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_stage1 <=", value, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1In(List<BigDecimal> values) {
            addCriterion("commission_stage1 in", values, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1NotIn(List<BigDecimal> values) {
            addCriterion("commission_stage1 not in", values, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_stage1 between", value1, value2, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_stage1 not between", value1, value2, "commissionStage1");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2IsNull() {
            addCriterion("commission_stage2 is null");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2IsNotNull() {
            addCriterion("commission_stage2 is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2EqualTo(BigDecimal value) {
            addCriterion("commission_stage2 =", value, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2NotEqualTo(BigDecimal value) {
            addCriterion("commission_stage2 <>", value, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2GreaterThan(BigDecimal value) {
            addCriterion("commission_stage2 >", value, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_stage2 >=", value, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2LessThan(BigDecimal value) {
            addCriterion("commission_stage2 <", value, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_stage2 <=", value, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2In(List<BigDecimal> values) {
            addCriterion("commission_stage2 in", values, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2NotIn(List<BigDecimal> values) {
            addCriterion("commission_stage2 not in", values, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_stage2 between", value1, value2, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_stage2 not between", value1, value2, "commissionStage2");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3IsNull() {
            addCriterion("commission_stage3 is null");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3IsNotNull() {
            addCriterion("commission_stage3 is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3EqualTo(BigDecimal value) {
            addCriterion("commission_stage3 =", value, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3NotEqualTo(BigDecimal value) {
            addCriterion("commission_stage3 <>", value, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3GreaterThan(BigDecimal value) {
            addCriterion("commission_stage3 >", value, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_stage3 >=", value, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3LessThan(BigDecimal value) {
            addCriterion("commission_stage3 <", value, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_stage3 <=", value, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3In(List<BigDecimal> values) {
            addCriterion("commission_stage3 in", values, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3NotIn(List<BigDecimal> values) {
            addCriterion("commission_stage3 not in", values, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_stage3 between", value1, value2, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andCommissionStage3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_stage3 not between", value1, value2, "commissionStage3");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2IsNull() {
            addCriterion("platform_return_level2 is null");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2IsNotNull() {
            addCriterion("platform_return_level2 is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2EqualTo(BigDecimal value) {
            addCriterion("platform_return_level2 =", value, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2NotEqualTo(BigDecimal value) {
            addCriterion("platform_return_level2 <>", value, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2GreaterThan(BigDecimal value) {
            addCriterion("platform_return_level2 >", value, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_return_level2 >=", value, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2LessThan(BigDecimal value) {
            addCriterion("platform_return_level2 <", value, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_return_level2 <=", value, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2In(List<BigDecimal> values) {
            addCriterion("platform_return_level2 in", values, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2NotIn(List<BigDecimal> values) {
            addCriterion("platform_return_level2 not in", values, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_return_level2 between", value1, value2, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnLevel2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_return_level2 not between", value1, value2, "platformReturnLevel2");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioIsNull() {
            addCriterion("platform_return_city_ratio is null");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioIsNotNull() {
            addCriterion("platform_return_city_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioEqualTo(BigDecimal value) {
            addCriterion("platform_return_city_ratio =", value, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioNotEqualTo(BigDecimal value) {
            addCriterion("platform_return_city_ratio <>", value, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioGreaterThan(BigDecimal value) {
            addCriterion("platform_return_city_ratio >", value, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_return_city_ratio >=", value, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioLessThan(BigDecimal value) {
            addCriterion("platform_return_city_ratio <", value, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_return_city_ratio <=", value, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioIn(List<BigDecimal> values) {
            addCriterion("platform_return_city_ratio in", values, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioNotIn(List<BigDecimal> values) {
            addCriterion("platform_return_city_ratio not in", values, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_return_city_ratio between", value1, value2, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnCityRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_return_city_ratio not between", value1, value2, "platformReturnCityRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioIsNull() {
            addCriterion("platform_return_province_ratio is null");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioIsNotNull() {
            addCriterion("platform_return_province_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioEqualTo(BigDecimal value) {
            addCriterion("platform_return_province_ratio =", value, "platformReturnProvinceRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioNotEqualTo(BigDecimal value) {
            addCriterion("platform_return_province_ratio <>", value, "platformReturnProvinceRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioGreaterThan(BigDecimal value) {
            addCriterion("platform_return_province_ratio >", value, "platformReturnProvinceRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_return_province_ratio >=", value, "platformReturnProvinceRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioLessThan(BigDecimal value) {
            addCriterion("platform_return_province_ratio <", value, "platformReturnProvinceRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_return_province_ratio <=", value, "platformReturnProvinceRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioIn(List<BigDecimal> values) {
            addCriterion("platform_return_province_ratio in", values, "platformReturnProvinceRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioNotIn(List<BigDecimal> values) {
            addCriterion("platform_return_province_ratio not in", values, "platformReturnProvinceRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_return_province_ratio between", value1, value2, "platformReturnProvinceRatio");
            return (Criteria) this;
        }

        public Criteria andPlatformReturnProvinceRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_return_province_ratio not between", value1, value2, "platformReturnProvinceRatio");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
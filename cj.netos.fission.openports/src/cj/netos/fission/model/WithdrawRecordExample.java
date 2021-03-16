package cj.netos.fission.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WithdrawRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public WithdrawRecordExample() {
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

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andWithdrawerIsNull() {
            addCriterion("withdrawer is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawerIsNotNull() {
            addCriterion("withdrawer is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawerEqualTo(String value) {
            addCriterion("withdrawer =", value, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerNotEqualTo(String value) {
            addCriterion("withdrawer <>", value, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerGreaterThan(String value) {
            addCriterion("withdrawer >", value, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerGreaterThanOrEqualTo(String value) {
            addCriterion("withdrawer >=", value, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerLessThan(String value) {
            addCriterion("withdrawer <", value, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerLessThanOrEqualTo(String value) {
            addCriterion("withdrawer <=", value, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerLike(String value) {
            addCriterion("withdrawer like", value, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerNotLike(String value) {
            addCriterion("withdrawer not like", value, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerIn(List<String> values) {
            addCriterion("withdrawer in", values, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerNotIn(List<String> values) {
            addCriterion("withdrawer not in", values, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerBetween(String value1, String value2) {
            addCriterion("withdrawer between", value1, value2, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andWithdrawerNotBetween(String value1, String value2) {
            addCriterion("withdrawer not between", value1, value2, "withdrawer");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioIsNull() {
            addCriterion("income_ratio is null");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioIsNotNull() {
            addCriterion("income_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioEqualTo(BigDecimal value) {
            addCriterion("income_ratio =", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioNotEqualTo(BigDecimal value) {
            addCriterion("income_ratio <>", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioGreaterThan(BigDecimal value) {
            addCriterion("income_ratio >", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income_ratio >=", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioLessThan(BigDecimal value) {
            addCriterion("income_ratio <", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income_ratio <=", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioIn(List<BigDecimal> values) {
            addCriterion("income_ratio in", values, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioNotIn(List<BigDecimal> values) {
            addCriterion("income_ratio not in", values, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_ratio between", value1, value2, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_ratio not between", value1, value2, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioIsNull() {
            addCriterion("commission_ratio is null");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioIsNotNull() {
            addCriterion("commission_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioEqualTo(BigDecimal value) {
            addCriterion("commission_ratio =", value, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioNotEqualTo(BigDecimal value) {
            addCriterion("commission_ratio <>", value, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioGreaterThan(BigDecimal value) {
            addCriterion("commission_ratio >", value, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_ratio >=", value, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioLessThan(BigDecimal value) {
            addCriterion("commission_ratio <", value, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission_ratio <=", value, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioIn(List<BigDecimal> values) {
            addCriterion("commission_ratio in", values, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioNotIn(List<BigDecimal> values) {
            addCriterion("commission_ratio not in", values, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_ratio between", value1, value2, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission_ratio not between", value1, value2, "commissionRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioIsNull() {
            addCriterion("absorb_ratio is null");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioIsNotNull() {
            addCriterion("absorb_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioEqualTo(BigDecimal value) {
            addCriterion("absorb_ratio =", value, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioNotEqualTo(BigDecimal value) {
            addCriterion("absorb_ratio <>", value, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioGreaterThan(BigDecimal value) {
            addCriterion("absorb_ratio >", value, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("absorb_ratio >=", value, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioLessThan(BigDecimal value) {
            addCriterion("absorb_ratio <", value, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("absorb_ratio <=", value, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioIn(List<BigDecimal> values) {
            addCriterion("absorb_ratio in", values, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioNotIn(List<BigDecimal> values) {
            addCriterion("absorb_ratio not in", values, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("absorb_ratio between", value1, value2, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andAbsorbRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("absorb_ratio not between", value1, value2, "absorbRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioIsNull() {
            addCriterion("shunt_ratio is null");
            return (Criteria) this;
        }

        public Criteria andShuntRatioIsNotNull() {
            addCriterion("shunt_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andShuntRatioEqualTo(BigDecimal value) {
            addCriterion("shunt_ratio =", value, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioNotEqualTo(BigDecimal value) {
            addCriterion("shunt_ratio <>", value, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioGreaterThan(BigDecimal value) {
            addCriterion("shunt_ratio >", value, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shunt_ratio >=", value, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioLessThan(BigDecimal value) {
            addCriterion("shunt_ratio <", value, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shunt_ratio <=", value, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioIn(List<BigDecimal> values) {
            addCriterion("shunt_ratio in", values, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioNotIn(List<BigDecimal> values) {
            addCriterion("shunt_ratio not in", values, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shunt_ratio between", value1, value2, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andShuntRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shunt_ratio not between", value1, value2, "shuntRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountIsNull() {
            addCriterion("income_amount is null");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountIsNotNull() {
            addCriterion("income_amount is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountEqualTo(Long value) {
            addCriterion("income_amount =", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountNotEqualTo(Long value) {
            addCriterion("income_amount <>", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountGreaterThan(Long value) {
            addCriterion("income_amount >", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("income_amount >=", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountLessThan(Long value) {
            addCriterion("income_amount <", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountLessThanOrEqualTo(Long value) {
            addCriterion("income_amount <=", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountIn(List<Long> values) {
            addCriterion("income_amount in", values, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountNotIn(List<Long> values) {
            addCriterion("income_amount not in", values, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountBetween(Long value1, Long value2) {
            addCriterion("income_amount between", value1, value2, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountNotBetween(Long value1, Long value2) {
            addCriterion("income_amount not between", value1, value2, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountIsNull() {
            addCriterion("absorb_amount is null");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountIsNotNull() {
            addCriterion("absorb_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountEqualTo(Long value) {
            addCriterion("absorb_amount =", value, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountNotEqualTo(Long value) {
            addCriterion("absorb_amount <>", value, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountGreaterThan(Long value) {
            addCriterion("absorb_amount >", value, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("absorb_amount >=", value, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountLessThan(Long value) {
            addCriterion("absorb_amount <", value, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountLessThanOrEqualTo(Long value) {
            addCriterion("absorb_amount <=", value, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountIn(List<Long> values) {
            addCriterion("absorb_amount in", values, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountNotIn(List<Long> values) {
            addCriterion("absorb_amount not in", values, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountBetween(Long value1, Long value2) {
            addCriterion("absorb_amount between", value1, value2, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andAbsorbAmountNotBetween(Long value1, Long value2) {
            addCriterion("absorb_amount not between", value1, value2, "absorbAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountIsNull() {
            addCriterion("commission_amount is null");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountIsNotNull() {
            addCriterion("commission_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountEqualTo(Long value) {
            addCriterion("commission_amount =", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountNotEqualTo(Long value) {
            addCriterion("commission_amount <>", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountGreaterThan(Long value) {
            addCriterion("commission_amount >", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("commission_amount >=", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountLessThan(Long value) {
            addCriterion("commission_amount <", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountLessThanOrEqualTo(Long value) {
            addCriterion("commission_amount <=", value, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountIn(List<Long> values) {
            addCriterion("commission_amount in", values, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountNotIn(List<Long> values) {
            addCriterion("commission_amount not in", values, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountBetween(Long value1, Long value2) {
            addCriterion("commission_amount between", value1, value2, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andCommissionAmountNotBetween(Long value1, Long value2) {
            addCriterion("commission_amount not between", value1, value2, "commissionAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountIsNull() {
            addCriterion("gain_amount is null");
            return (Criteria) this;
        }

        public Criteria andGainAmountIsNotNull() {
            addCriterion("gain_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGainAmountEqualTo(Long value) {
            addCriterion("gain_amount =", value, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountNotEqualTo(Long value) {
            addCriterion("gain_amount <>", value, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountGreaterThan(Long value) {
            addCriterion("gain_amount >", value, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("gain_amount >=", value, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountLessThan(Long value) {
            addCriterion("gain_amount <", value, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountLessThanOrEqualTo(Long value) {
            addCriterion("gain_amount <=", value, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountIn(List<Long> values) {
            addCriterion("gain_amount in", values, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountNotIn(List<Long> values) {
            addCriterion("gain_amount not in", values, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountBetween(Long value1, Long value2) {
            addCriterion("gain_amount between", value1, value2, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andGainAmountNotBetween(Long value1, Long value2) {
            addCriterion("gain_amount not between", value1, value2, "gainAmount");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(String value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(String value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(String value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(String value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(String value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLike(String value) {
            addCriterion("ctime like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotLike(String value) {
            addCriterion("ctime not like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<String> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<String> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(String value1, String value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(String value1, String value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andReferrerIsNull() {
            addCriterion("referrer is null");
            return (Criteria) this;
        }

        public Criteria andReferrerIsNotNull() {
            addCriterion("referrer is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerEqualTo(String value) {
            addCriterion("referrer =", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotEqualTo(String value) {
            addCriterion("referrer <>", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerGreaterThan(String value) {
            addCriterion("referrer >", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerGreaterThanOrEqualTo(String value) {
            addCriterion("referrer >=", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerLessThan(String value) {
            addCriterion("referrer <", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerLessThanOrEqualTo(String value) {
            addCriterion("referrer <=", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerLike(String value) {
            addCriterion("referrer like", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotLike(String value) {
            addCriterion("referrer not like", value, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerIn(List<String> values) {
            addCriterion("referrer in", values, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotIn(List<String> values) {
            addCriterion("referrer not in", values, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerBetween(String value1, String value2) {
            addCriterion("referrer between", value1, value2, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNotBetween(String value1, String value2) {
            addCriterion("referrer not between", value1, value2, "referrer");
            return (Criteria) this;
        }

        public Criteria andReferrerNameIsNull() {
            addCriterion("referrer_name is null");
            return (Criteria) this;
        }

        public Criteria andReferrerNameIsNotNull() {
            addCriterion("referrer_name is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerNameEqualTo(String value) {
            addCriterion("referrer_name =", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotEqualTo(String value) {
            addCriterion("referrer_name <>", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameGreaterThan(String value) {
            addCriterion("referrer_name >", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameGreaterThanOrEqualTo(String value) {
            addCriterion("referrer_name >=", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLessThan(String value) {
            addCriterion("referrer_name <", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLessThanOrEqualTo(String value) {
            addCriterion("referrer_name <=", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameLike(String value) {
            addCriterion("referrer_name like", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotLike(String value) {
            addCriterion("referrer_name not like", value, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameIn(List<String> values) {
            addCriterion("referrer_name in", values, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotIn(List<String> values) {
            addCriterion("referrer_name not in", values, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameBetween(String value1, String value2) {
            addCriterion("referrer_name between", value1, value2, "referrerName");
            return (Criteria) this;
        }

        public Criteria andReferrerNameNotBetween(String value1, String value2) {
            addCriterion("referrer_name not between", value1, value2, "referrerName");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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
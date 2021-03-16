package cj.netos.fission.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CashierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public CashierExample() {
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

        public Criteria andPersonIsNull() {
            addCriterion("person is null");
            return (Criteria) this;
        }

        public Criteria andPersonIsNotNull() {
            addCriterion("person is not null");
            return (Criteria) this;
        }

        public Criteria andPersonEqualTo(String value) {
            addCriterion("person =", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotEqualTo(String value) {
            addCriterion("person <>", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThan(String value) {
            addCriterion("person >", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonGreaterThanOrEqualTo(String value) {
            addCriterion("person >=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThan(String value) {
            addCriterion("person <", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLessThanOrEqualTo(String value) {
            addCriterion("person <=", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonLike(String value) {
            addCriterion("person like", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotLike(String value) {
            addCriterion("person not like", value, "person");
            return (Criteria) this;
        }

        public Criteria andPersonIn(List<String> values) {
            addCriterion("person in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotIn(List<String> values) {
            addCriterion("person not in", values, "person");
            return (Criteria) this;
        }

        public Criteria andPersonBetween(String value1, String value2) {
            addCriterion("person between", value1, value2, "person");
            return (Criteria) this;
        }

        public Criteria andPersonNotBetween(String value1, String value2) {
            addCriterion("person not between", value1, value2, "person");
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

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDayAmountIsNull() {
            addCriterion("day_amount is null");
            return (Criteria) this;
        }

        public Criteria andDayAmountIsNotNull() {
            addCriterion("day_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDayAmountEqualTo(Long value) {
            addCriterion("day_amount =", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountNotEqualTo(Long value) {
            addCriterion("day_amount <>", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountGreaterThan(Long value) {
            addCriterion("day_amount >", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("day_amount >=", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountLessThan(Long value) {
            addCriterion("day_amount <", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountLessThanOrEqualTo(Long value) {
            addCriterion("day_amount <=", value, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountIn(List<Long> values) {
            addCriterion("day_amount in", values, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountNotIn(List<Long> values) {
            addCriterion("day_amount not in", values, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountBetween(Long value1, Long value2) {
            addCriterion("day_amount between", value1, value2, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andDayAmountNotBetween(Long value1, Long value2) {
            addCriterion("day_amount not between", value1, value2, "dayAmount");
            return (Criteria) this;
        }

        public Criteria andCacAverageIsNull() {
            addCriterion("cac_average is null");
            return (Criteria) this;
        }

        public Criteria andCacAverageIsNotNull() {
            addCriterion("cac_average is not null");
            return (Criteria) this;
        }

        public Criteria andCacAverageEqualTo(Long value) {
            addCriterion("cac_average =", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageNotEqualTo(Long value) {
            addCriterion("cac_average <>", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageGreaterThan(Long value) {
            addCriterion("cac_average >", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageGreaterThanOrEqualTo(Long value) {
            addCriterion("cac_average >=", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageLessThan(Long value) {
            addCriterion("cac_average <", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageLessThanOrEqualTo(Long value) {
            addCriterion("cac_average <=", value, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageIn(List<Long> values) {
            addCriterion("cac_average in", values, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageNotIn(List<Long> values) {
            addCriterion("cac_average not in", values, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageBetween(Long value1, Long value2) {
            addCriterion("cac_average between", value1, value2, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andCacAverageNotBetween(Long value1, Long value2) {
            addCriterion("cac_average not between", value1, value2, "cacAverage");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorIsNull() {
            addCriterion("amplitude_factor is null");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorIsNotNull() {
            addCriterion("amplitude_factor is not null");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorEqualTo(BigDecimal value) {
            addCriterion("amplitude_factor =", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorNotEqualTo(BigDecimal value) {
            addCriterion("amplitude_factor <>", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorGreaterThan(BigDecimal value) {
            addCriterion("amplitude_factor >", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amplitude_factor >=", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorLessThan(BigDecimal value) {
            addCriterion("amplitude_factor <", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amplitude_factor <=", value, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorIn(List<BigDecimal> values) {
            addCriterion("amplitude_factor in", values, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorNotIn(List<BigDecimal> values) {
            addCriterion("amplitude_factor not in", values, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amplitude_factor between", value1, value2, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andAmplitudeFactorNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amplitude_factor not between", value1, value2, "amplitudeFactor");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtIsNull() {
            addCriterion("checked_withdraw_pt is null");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtIsNotNull() {
            addCriterion("checked_withdraw_pt is not null");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtEqualTo(Integer value) {
            addCriterion("checked_withdraw_pt =", value, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtNotEqualTo(Integer value) {
            addCriterion("checked_withdraw_pt <>", value, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtGreaterThan(Integer value) {
            addCriterion("checked_withdraw_pt >", value, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtGreaterThanOrEqualTo(Integer value) {
            addCriterion("checked_withdraw_pt >=", value, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtLessThan(Integer value) {
            addCriterion("checked_withdraw_pt <", value, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtLessThanOrEqualTo(Integer value) {
            addCriterion("checked_withdraw_pt <=", value, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtIn(List<Integer> values) {
            addCriterion("checked_withdraw_pt in", values, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtNotIn(List<Integer> values) {
            addCriterion("checked_withdraw_pt not in", values, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtBetween(Integer value1, Integer value2) {
            addCriterion("checked_withdraw_pt between", value1, value2, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andCheckedWithdrawPtNotBetween(Integer value1, Integer value2) {
            addCriterion("checked_withdraw_pt not between", value1, value2, "checkedWithdrawPt");
            return (Criteria) this;
        }

        public Criteria andClosedCauseIsNull() {
            addCriterion("closed_cause is null");
            return (Criteria) this;
        }

        public Criteria andClosedCauseIsNotNull() {
            addCriterion("closed_cause is not null");
            return (Criteria) this;
        }

        public Criteria andClosedCauseEqualTo(String value) {
            addCriterion("closed_cause =", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseNotEqualTo(String value) {
            addCriterion("closed_cause <>", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseGreaterThan(String value) {
            addCriterion("closed_cause >", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseGreaterThanOrEqualTo(String value) {
            addCriterion("closed_cause >=", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseLessThan(String value) {
            addCriterion("closed_cause <", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseLessThanOrEqualTo(String value) {
            addCriterion("closed_cause <=", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseLike(String value) {
            addCriterion("closed_cause like", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseNotLike(String value) {
            addCriterion("closed_cause not like", value, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseIn(List<String> values) {
            addCriterion("closed_cause in", values, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseNotIn(List<String> values) {
            addCriterion("closed_cause not in", values, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseBetween(String value1, String value2) {
            addCriterion("closed_cause between", value1, value2, "closedCause");
            return (Criteria) this;
        }

        public Criteria andClosedCauseNotBetween(String value1, String value2) {
            addCriterion("closed_cause not between", value1, value2, "closedCause");
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

        public Criteria andSupportsChatroomIsNull() {
            addCriterion("supports_chatroom is null");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomIsNotNull() {
            addCriterion("supports_chatroom is not null");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomEqualTo(Integer value) {
            addCriterion("supports_chatroom =", value, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomNotEqualTo(Integer value) {
            addCriterion("supports_chatroom <>", value, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomGreaterThan(Integer value) {
            addCriterion("supports_chatroom >", value, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomGreaterThanOrEqualTo(Integer value) {
            addCriterion("supports_chatroom >=", value, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomLessThan(Integer value) {
            addCriterion("supports_chatroom <", value, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomLessThanOrEqualTo(Integer value) {
            addCriterion("supports_chatroom <=", value, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomIn(List<Integer> values) {
            addCriterion("supports_chatroom in", values, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomNotIn(List<Integer> values) {
            addCriterion("supports_chatroom not in", values, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomBetween(Integer value1, Integer value2) {
            addCriterion("supports_chatroom between", value1, value2, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSupportsChatroomNotBetween(Integer value1, Integer value2) {
            addCriterion("supports_chatroom not between", value1, value2, "supportsChatroom");
            return (Criteria) this;
        }

        public Criteria andSalesmanIsNull() {
            addCriterion("salesman is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIsNotNull() {
            addCriterion("salesman is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanEqualTo(String value) {
            addCriterion("salesman =", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotEqualTo(String value) {
            addCriterion("salesman <>", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanGreaterThan(String value) {
            addCriterion("salesman >", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanGreaterThanOrEqualTo(String value) {
            addCriterion("salesman >=", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLessThan(String value) {
            addCriterion("salesman <", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLessThanOrEqualTo(String value) {
            addCriterion("salesman <=", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLike(String value) {
            addCriterion("salesman like", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotLike(String value) {
            addCriterion("salesman not like", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanIn(List<String> values) {
            addCriterion("salesman in", values, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotIn(List<String> values) {
            addCriterion("salesman not in", values, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanBetween(String value1, String value2) {
            addCriterion("salesman between", value1, value2, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotBetween(String value1, String value2) {
            addCriterion("salesman not between", value1, value2, "salesman");
            return (Criteria) this;
        }

        public Criteria andAreaMasterIsNull() {
            addCriterion("area_master is null");
            return (Criteria) this;
        }

        public Criteria andAreaMasterIsNotNull() {
            addCriterion("area_master is not null");
            return (Criteria) this;
        }

        public Criteria andAreaMasterEqualTo(String value) {
            addCriterion("area_master =", value, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterNotEqualTo(String value) {
            addCriterion("area_master <>", value, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterGreaterThan(String value) {
            addCriterion("area_master >", value, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterGreaterThanOrEqualTo(String value) {
            addCriterion("area_master >=", value, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterLessThan(String value) {
            addCriterion("area_master <", value, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterLessThanOrEqualTo(String value) {
            addCriterion("area_master <=", value, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterLike(String value) {
            addCriterion("area_master like", value, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterNotLike(String value) {
            addCriterion("area_master not like", value, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterIn(List<String> values) {
            addCriterion("area_master in", values, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterNotIn(List<String> values) {
            addCriterion("area_master not in", values, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterBetween(String value1, String value2) {
            addCriterion("area_master between", value1, value2, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andAreaMasterNotBetween(String value1, String value2) {
            addCriterion("area_master not between", value1, value2, "areaMaster");
            return (Criteria) this;
        }

        public Criteria andStageIsNull() {
            addCriterion("stage is null");
            return (Criteria) this;
        }

        public Criteria andStageIsNotNull() {
            addCriterion("stage is not null");
            return (Criteria) this;
        }

        public Criteria andStageEqualTo(Integer value) {
            addCriterion("stage =", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotEqualTo(Integer value) {
            addCriterion("stage <>", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThan(Integer value) {
            addCriterion("stage >", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageGreaterThanOrEqualTo(Integer value) {
            addCriterion("stage >=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThan(Integer value) {
            addCriterion("stage <", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageLessThanOrEqualTo(Integer value) {
            addCriterion("stage <=", value, "stage");
            return (Criteria) this;
        }

        public Criteria andStageIn(List<Integer> values) {
            addCriterion("stage in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotIn(List<Integer> values) {
            addCriterion("stage not in", values, "stage");
            return (Criteria) this;
        }

        public Criteria andStageBetween(Integer value1, Integer value2) {
            addCriterion("stage between", value1, value2, "stage");
            return (Criteria) this;
        }

        public Criteria andStageNotBetween(Integer value1, Integer value2) {
            addCriterion("stage not between", value1, value2, "stage");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("`level` is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("`level` is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("`level` =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("`level` <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("`level` >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("`level` >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("`level` <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("`level` <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("`level` in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("`level` not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("`level` between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("`level` not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andIsRequestIsNull() {
            addCriterion("is_request is null");
            return (Criteria) this;
        }

        public Criteria andIsRequestIsNotNull() {
            addCriterion("is_request is not null");
            return (Criteria) this;
        }

        public Criteria andIsRequestEqualTo(Integer value) {
            addCriterion("is_request =", value, "isRequest");
            return (Criteria) this;
        }

        public Criteria andIsRequestNotEqualTo(Integer value) {
            addCriterion("is_request <>", value, "isRequest");
            return (Criteria) this;
        }

        public Criteria andIsRequestGreaterThan(Integer value) {
            addCriterion("is_request >", value, "isRequest");
            return (Criteria) this;
        }

        public Criteria andIsRequestGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_request >=", value, "isRequest");
            return (Criteria) this;
        }

        public Criteria andIsRequestLessThan(Integer value) {
            addCriterion("is_request <", value, "isRequest");
            return (Criteria) this;
        }

        public Criteria andIsRequestLessThanOrEqualTo(Integer value) {
            addCriterion("is_request <=", value, "isRequest");
            return (Criteria) this;
        }

        public Criteria andIsRequestIn(List<Integer> values) {
            addCriterion("is_request in", values, "isRequest");
            return (Criteria) this;
        }

        public Criteria andIsRequestNotIn(List<Integer> values) {
            addCriterion("is_request not in", values, "isRequest");
            return (Criteria) this;
        }

        public Criteria andIsRequestBetween(Integer value1, Integer value2) {
            addCriterion("is_request between", value1, value2, "isRequest");
            return (Criteria) this;
        }

        public Criteria andIsRequestNotBetween(Integer value1, Integer value2) {
            addCriterion("is_request not between", value1, value2, "isRequest");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentIsNull() {
            addCriterion("become_agent is null");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentIsNotNull() {
            addCriterion("become_agent is not null");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentEqualTo(Integer value) {
            addCriterion("become_agent =", value, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentNotEqualTo(Integer value) {
            addCriterion("become_agent <>", value, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentGreaterThan(Integer value) {
            addCriterion("become_agent >", value, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentGreaterThanOrEqualTo(Integer value) {
            addCriterion("become_agent >=", value, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentLessThan(Integer value) {
            addCriterion("become_agent <", value, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentLessThanOrEqualTo(Integer value) {
            addCriterion("become_agent <=", value, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentIn(List<Integer> values) {
            addCriterion("become_agent in", values, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentNotIn(List<Integer> values) {
            addCriterion("become_agent not in", values, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentBetween(Integer value1, Integer value2) {
            addCriterion("become_agent between", value1, value2, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andBecomeAgentNotBetween(Integer value1, Integer value2) {
            addCriterion("become_agent not between", value1, value2, "becomeAgent");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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
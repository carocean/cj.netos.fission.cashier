package cj.netos.fission.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BusinessIncomeRatioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public BusinessIncomeRatioExample() {
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

        public Criteria andMinAmountEdgeIsNull() {
            addCriterion("min_amount_edge is null");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeIsNotNull() {
            addCriterion("min_amount_edge is not null");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeEqualTo(Long value) {
            addCriterion("min_amount_edge =", value, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeNotEqualTo(Long value) {
            addCriterion("min_amount_edge <>", value, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeGreaterThan(Long value) {
            addCriterion("min_amount_edge >", value, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeGreaterThanOrEqualTo(Long value) {
            addCriterion("min_amount_edge >=", value, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeLessThan(Long value) {
            addCriterion("min_amount_edge <", value, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeLessThanOrEqualTo(Long value) {
            addCriterion("min_amount_edge <=", value, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeIn(List<Long> values) {
            addCriterion("min_amount_edge in", values, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeNotIn(List<Long> values) {
            addCriterion("min_amount_edge not in", values, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeBetween(Long value1, Long value2) {
            addCriterion("min_amount_edge between", value1, value2, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMinAmountEdgeNotBetween(Long value1, Long value2) {
            addCriterion("min_amount_edge not between", value1, value2, "minAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeIsNull() {
            addCriterion("max_amount_edge is null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeIsNotNull() {
            addCriterion("max_amount_edge is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeEqualTo(Long value) {
            addCriterion("max_amount_edge =", value, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeNotEqualTo(Long value) {
            addCriterion("max_amount_edge <>", value, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeGreaterThan(Long value) {
            addCriterion("max_amount_edge >", value, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeGreaterThanOrEqualTo(Long value) {
            addCriterion("max_amount_edge >=", value, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeLessThan(Long value) {
            addCriterion("max_amount_edge <", value, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeLessThanOrEqualTo(Long value) {
            addCriterion("max_amount_edge <=", value, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeIn(List<Long> values) {
            addCriterion("max_amount_edge in", values, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeNotIn(List<Long> values) {
            addCriterion("max_amount_edge not in", values, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeBetween(Long value1, Long value2) {
            addCriterion("max_amount_edge between", value1, value2, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEdgeNotBetween(Long value1, Long value2) {
            addCriterion("max_amount_edge not between", value1, value2, "maxAmountEdge");
            return (Criteria) this;
        }

        public Criteria andRatioIsNull() {
            addCriterion("ratio is null");
            return (Criteria) this;
        }

        public Criteria andRatioIsNotNull() {
            addCriterion("ratio is not null");
            return (Criteria) this;
        }

        public Criteria andRatioEqualTo(BigDecimal value) {
            addCriterion("ratio =", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotEqualTo(BigDecimal value) {
            addCriterion("ratio <>", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThan(BigDecimal value) {
            addCriterion("ratio >", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ratio >=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThan(BigDecimal value) {
            addCriterion("ratio <", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ratio <=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioIn(List<BigDecimal> values) {
            addCriterion("ratio in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotIn(List<BigDecimal> values) {
            addCriterion("ratio not in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ratio between", value1, value2, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ratio not between", value1, value2, "ratio");
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
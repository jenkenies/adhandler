package com.utstar.adhandler.entity;

import java.util.ArrayList;
import java.util.List;

public class GlobalcodedefExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public GlobalcodedefExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
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

        public Criteria andGlobalcodedefidIsNull() {
            addCriterion("GLOBALCODEDEFID is null");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidIsNotNull() {
            addCriterion("GLOBALCODEDEFID is not null");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidEqualTo(Integer value) {
            addCriterion("GLOBALCODEDEFID =", value, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidNotEqualTo(Integer value) {
            addCriterion("GLOBALCODEDEFID <>", value, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidGreaterThan(Integer value) {
            addCriterion("GLOBALCODEDEFID >", value, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidGreaterThanOrEqualTo(Integer value) {
            addCriterion("GLOBALCODEDEFID >=", value, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidLessThan(Integer value) {
            addCriterion("GLOBALCODEDEFID <", value, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidLessThanOrEqualTo(Integer value) {
            addCriterion("GLOBALCODEDEFID <=", value, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidIn(List<Integer> values) {
            addCriterion("GLOBALCODEDEFID in", values, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidNotIn(List<Integer> values) {
            addCriterion("GLOBALCODEDEFID not in", values, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidBetween(Integer value1, Integer value2) {
            addCriterion("GLOBALCODEDEFID between", value1, value2, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andGlobalcodedefidNotBetween(Integer value1, Integer value2) {
            addCriterion("GLOBALCODEDEFID not between", value1, value2, "globalcodedefid");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIsNull() {
            addCriterion("OWNERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIsNotNull() {
            addCriterion("OWNERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOwnertypeEqualTo(String value) {
            addCriterion("OWNERTYPE =", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotEqualTo(String value) {
            addCriterion("OWNERTYPE <>", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeGreaterThan(String value) {
            addCriterion("OWNERTYPE >", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeGreaterThanOrEqualTo(String value) {
            addCriterion("OWNERTYPE >=", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLessThan(String value) {
            addCriterion("OWNERTYPE <", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLessThanOrEqualTo(String value) {
            addCriterion("OWNERTYPE <=", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLike(String value) {
            addCriterion("OWNERTYPE like", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotLike(String value) {
            addCriterion("OWNERTYPE not like", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIn(List<String> values) {
            addCriterion("OWNERTYPE in", values, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotIn(List<String> values) {
            addCriterion("OWNERTYPE not in", values, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeBetween(String value1, String value2) {
            addCriterion("OWNERTYPE between", value1, value2, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotBetween(String value1, String value2) {
            addCriterion("OWNERTYPE not between", value1, value2, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNull() {
            addCriterion("OWNERID is null");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNotNull() {
            addCriterion("OWNERID is not null");
            return (Criteria) this;
        }

        public Criteria andOwneridEqualTo(Integer value) {
            addCriterion("OWNERID =", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotEqualTo(Integer value) {
            addCriterion("OWNERID <>", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThan(Integer value) {
            addCriterion("OWNERID >", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(Integer value) {
            addCriterion("OWNERID >=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThan(Integer value) {
            addCriterion("OWNERID <", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThanOrEqualTo(Integer value) {
            addCriterion("OWNERID <=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridIn(List<Integer> values) {
            addCriterion("OWNERID in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotIn(List<Integer> values) {
            addCriterion("OWNERID not in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridBetween(Integer value1, Integer value2) {
            addCriterion("OWNERID between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotBetween(Integer value1, Integer value2) {
            addCriterion("OWNERID not between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andObjecttypeIsNull() {
            addCriterion("OBJECTTYPE is null");
            return (Criteria) this;
        }

        public Criteria andObjecttypeIsNotNull() {
            addCriterion("OBJECTTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andObjecttypeEqualTo(String value) {
            addCriterion("OBJECTTYPE =", value, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeNotEqualTo(String value) {
            addCriterion("OBJECTTYPE <>", value, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeGreaterThan(String value) {
            addCriterion("OBJECTTYPE >", value, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeGreaterThanOrEqualTo(String value) {
            addCriterion("OBJECTTYPE >=", value, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeLessThan(String value) {
            addCriterion("OBJECTTYPE <", value, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeLessThanOrEqualTo(String value) {
            addCriterion("OBJECTTYPE <=", value, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeLike(String value) {
            addCriterion("OBJECTTYPE like", value, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeNotLike(String value) {
            addCriterion("OBJECTTYPE not like", value, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeIn(List<String> values) {
            addCriterion("OBJECTTYPE in", values, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeNotIn(List<String> values) {
            addCriterion("OBJECTTYPE not in", values, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeBetween(String value1, String value2) {
            addCriterion("OBJECTTYPE between", value1, value2, "objecttype");
            return (Criteria) this;
        }

        public Criteria andObjecttypeNotBetween(String value1, String value2) {
            addCriterion("OBJECTTYPE not between", value1, value2, "objecttype");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNull() {
            addCriterion("PREFIX is null");
            return (Criteria) this;
        }

        public Criteria andPrefixIsNotNull() {
            addCriterion("PREFIX is not null");
            return (Criteria) this;
        }

        public Criteria andPrefixEqualTo(String value) {
            addCriterion("PREFIX =", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotEqualTo(String value) {
            addCriterion("PREFIX <>", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThan(String value) {
            addCriterion("PREFIX >", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("PREFIX >=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThan(String value) {
            addCriterion("PREFIX <", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLessThanOrEqualTo(String value) {
            addCriterion("PREFIX <=", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixLike(String value) {
            addCriterion("PREFIX like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotLike(String value) {
            addCriterion("PREFIX not like", value, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixIn(List<String> values) {
            addCriterion("PREFIX in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotIn(List<String> values) {
            addCriterion("PREFIX not in", values, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixBetween(String value1, String value2) {
            addCriterion("PREFIX between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andPrefixNotBetween(String value1, String value2) {
            addCriterion("PREFIX not between", value1, value2, "prefix");
            return (Criteria) this;
        }

        public Criteria andBodytypeIsNull() {
            addCriterion("BODYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andBodytypeIsNotNull() {
            addCriterion("BODYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBodytypeEqualTo(String value) {
            addCriterion("BODYTYPE =", value, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeNotEqualTo(String value) {
            addCriterion("BODYTYPE <>", value, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeGreaterThan(String value) {
            addCriterion("BODYTYPE >", value, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeGreaterThanOrEqualTo(String value) {
            addCriterion("BODYTYPE >=", value, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeLessThan(String value) {
            addCriterion("BODYTYPE <", value, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeLessThanOrEqualTo(String value) {
            addCriterion("BODYTYPE <=", value, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeLike(String value) {
            addCriterion("BODYTYPE like", value, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeNotLike(String value) {
            addCriterion("BODYTYPE not like", value, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeIn(List<String> values) {
            addCriterion("BODYTYPE in", values, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeNotIn(List<String> values) {
            addCriterion("BODYTYPE not in", values, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeBetween(String value1, String value2) {
            addCriterion("BODYTYPE between", value1, value2, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodytypeNotBetween(String value1, String value2) {
            addCriterion("BODYTYPE not between", value1, value2, "bodytype");
            return (Criteria) this;
        }

        public Criteria andBodyformatIsNull() {
            addCriterion("BODYFORMAT is null");
            return (Criteria) this;
        }

        public Criteria andBodyformatIsNotNull() {
            addCriterion("BODYFORMAT is not null");
            return (Criteria) this;
        }

        public Criteria andBodyformatEqualTo(String value) {
            addCriterion("BODYFORMAT =", value, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatNotEqualTo(String value) {
            addCriterion("BODYFORMAT <>", value, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatGreaterThan(String value) {
            addCriterion("BODYFORMAT >", value, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatGreaterThanOrEqualTo(String value) {
            addCriterion("BODYFORMAT >=", value, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatLessThan(String value) {
            addCriterion("BODYFORMAT <", value, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatLessThanOrEqualTo(String value) {
            addCriterion("BODYFORMAT <=", value, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatLike(String value) {
            addCriterion("BODYFORMAT like", value, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatNotLike(String value) {
            addCriterion("BODYFORMAT not like", value, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatIn(List<String> values) {
            addCriterion("BODYFORMAT in", values, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatNotIn(List<String> values) {
            addCriterion("BODYFORMAT not in", values, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatBetween(String value1, String value2) {
            addCriterion("BODYFORMAT between", value1, value2, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodyformatNotBetween(String value1, String value2) {
            addCriterion("BODYFORMAT not between", value1, value2, "bodyformat");
            return (Criteria) this;
        }

        public Criteria andBodylengthIsNull() {
            addCriterion("BODYLENGTH is null");
            return (Criteria) this;
        }

        public Criteria andBodylengthIsNotNull() {
            addCriterion("BODYLENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andBodylengthEqualTo(Integer value) {
            addCriterion("BODYLENGTH =", value, "bodylength");
            return (Criteria) this;
        }

        public Criteria andBodylengthNotEqualTo(Integer value) {
            addCriterion("BODYLENGTH <>", value, "bodylength");
            return (Criteria) this;
        }

        public Criteria andBodylengthGreaterThan(Integer value) {
            addCriterion("BODYLENGTH >", value, "bodylength");
            return (Criteria) this;
        }

        public Criteria andBodylengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("BODYLENGTH >=", value, "bodylength");
            return (Criteria) this;
        }

        public Criteria andBodylengthLessThan(Integer value) {
            addCriterion("BODYLENGTH <", value, "bodylength");
            return (Criteria) this;
        }

        public Criteria andBodylengthLessThanOrEqualTo(Integer value) {
            addCriterion("BODYLENGTH <=", value, "bodylength");
            return (Criteria) this;
        }

        public Criteria andBodylengthIn(List<Integer> values) {
            addCriterion("BODYLENGTH in", values, "bodylength");
            return (Criteria) this;
        }

        public Criteria andBodylengthNotIn(List<Integer> values) {
            addCriterion("BODYLENGTH not in", values, "bodylength");
            return (Criteria) this;
        }

        public Criteria andBodylengthBetween(Integer value1, Integer value2) {
            addCriterion("BODYLENGTH between", value1, value2, "bodylength");
            return (Criteria) this;
        }

        public Criteria andBodylengthNotBetween(Integer value1, Integer value2) {
            addCriterion("BODYLENGTH not between", value1, value2, "bodylength");
            return (Criteria) this;
        }

        public Criteria andSuffixIsNull() {
            addCriterion("SUFFIX is null");
            return (Criteria) this;
        }

        public Criteria andSuffixIsNotNull() {
            addCriterion("SUFFIX is not null");
            return (Criteria) this;
        }

        public Criteria andSuffixEqualTo(String value) {
            addCriterion("SUFFIX =", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixNotEqualTo(String value) {
            addCriterion("SUFFIX <>", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixGreaterThan(String value) {
            addCriterion("SUFFIX >", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixGreaterThanOrEqualTo(String value) {
            addCriterion("SUFFIX >=", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixLessThan(String value) {
            addCriterion("SUFFIX <", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixLessThanOrEqualTo(String value) {
            addCriterion("SUFFIX <=", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixLike(String value) {
            addCriterion("SUFFIX like", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixNotLike(String value) {
            addCriterion("SUFFIX not like", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixIn(List<String> values) {
            addCriterion("SUFFIX in", values, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixNotIn(List<String> values) {
            addCriterion("SUFFIX not in", values, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixBetween(String value1, String value2) {
            addCriterion("SUFFIX between", value1, value2, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixNotBetween(String value1, String value2) {
            addCriterion("SUFFIX not between", value1, value2, "suffix");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table globalcodedef
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table globalcodedef
     *
     * @mbg.generated
     */
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
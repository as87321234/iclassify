package com.pointtomap.iclassify.jpa.dao;

public class SQLClause {

    public final static String ID = "id";
    public final static String FILTER_TYPE = "filterType";
    public final static String NAME = "name";
    public final static String TABLE_NAME = "tableName";
    public final static String VALUE = "value";

    public final static String DATE_BETWEEN = "filter-date-between";
    public final static String BETWEEN = "filter-between";
    public final static String BETWEEN_FROM = "from";
    public final static String BETWEEN_TO = "to";

    public final static String GREATER_THAN = "filter-greater-than";
    public final static String DATE_GREATER_THAN = "filter-date-greater-than";
    public final static String GREATER_EQUAL_THAN = "filter-greater-or-equal-than";
    public final static String DATE_GREATER_EQUAL_THAN = "filter-date-greater-or-equal-than";
    public final static String LESS_THAN = "filter-less-than";
    public final static String DATE_LESS_THAN = "filter-date-less-than";
    public final static String LESS_EQUAL_THAN = "filter-less-or-equal-than";
    public final static String DATE_LESS_EQUAL_THAN = "filter-date-less-or-equal-than";
    public static final String EQUAL = "filter-equal";
    public static final String DATE_EQUAL = "filter-date-equal";

    public static final String PICKER = "filter-picker";
    public static final String INCLAUSE = "filter-inclause";

    // Filed Name as an ID
    String fieldName;

    // Filed Name Description
    String name;

    // Type of Filter
    String filterType; // Type of Clause

    // Database Table Name
    String tableName;

    public String getFieldName() {
	return fieldName;
    }

    public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getFilterType() {
	return filterType;
    }

    public void setFilterType(String filterType) {
	this.filterType = filterType;
    }

    public String getEntityName() {
	return tableName;
    }

    public void setEntityName(String tableName) {
	this.tableName = tableName;
    }

}

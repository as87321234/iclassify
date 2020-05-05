package com.pointtomap.iclassify.jpa.dao;

public class WhereClauseBinary extends SQLClause {
	// Binary
	public static final String OPERATOR_EQUAL = "=";
	public static final String FILTER_GREATER_THAN_OR_EQUAL_TO = ">=";
	public static final String FILTER_LESS_THAN_OR_EQUAL_TO = "<=";

	private final String fieldName;
	String operator;
	private final Object o;

	public <T> WhereClauseBinary(final String fieldName, final String operator,
			final Object o) {
		super();
		this.fieldName = fieldName;
		this.operator = operator;
		this.o = o;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getOperator() {
		return operator;
	}

	public Object getObject() {
		return o;
	}

}
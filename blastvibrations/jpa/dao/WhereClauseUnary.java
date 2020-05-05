package com.blastvibrations.jpa.dao;

public class WhereClauseUnary extends SQLClause {

	// Unary
	public static final String OPERATOR_IS_NOT_NULL = "is not null";

	private String fieldName;
	private String operator;

	public WhereClauseUnary(String fieldName, String operator) {
		super();
		this.fieldName = fieldName;
		this.operator = operator;
	}

	public String getfieldName() {
		return fieldName;
	}

	public String getOperator() {
		return operator;
	}

}

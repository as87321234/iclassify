package com.blastvibrations.jpa.dao;


public class SQLClauseBetween extends SQLClause {

	String fromValue;
	String toValue;

	public String getFromValue() {
		return fromValue;
	}

	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}

	public String getToValue() {
		return toValue;
	}

	public void setToValue(String toValue) {
		this.toValue = toValue;
	}

}

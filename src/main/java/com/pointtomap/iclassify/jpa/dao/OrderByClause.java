package com.pointtomap.iclassify.jpa.dao;

public class OrderByClause extends SQLClause {

	private String fieldName;
	private boolean ascending;

	public OrderByClause(String fieldName, boolean ascending) {
		super();
		this.fieldName = fieldName;
		this.ascending = ascending;
	}

	public OrderByClause(String orderBy, String order) {

		super();
		this.fieldName = orderBy;
		this.ascending = true;

		if (order.trim().toUpperCase().equals("ASC")) {
			this.ascending = true;
		} else if (order.trim().toUpperCase().equals("DESC")) {
			this.ascending = false;
		}
		// TODO Auto-generated constructor stub
	}

	public String getFieldName() {
		return fieldName;
	}

	public boolean isAscending() {
		return ascending;
	}

}

package com.blastvibrations.jpa.orm.converter;

import javax.persistence.AttributeConverter;

import com.google.common.base.Strings;

public class StringNullConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {

		if (Strings.isNullOrEmpty(attribute)) {
			return null;
		}

		return attribute;
	}

	@Override
	public String convertToEntityAttribute(String dbData) {

		if (dbData == null) {
			return "";
		}

		return dbData;
	}

}

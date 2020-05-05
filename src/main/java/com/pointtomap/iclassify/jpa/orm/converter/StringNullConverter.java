package com.pointtomap.iclassify.jpa.orm.converter;

import javax.persistence.AttributeConverter;

import org.apache.commons.lang3.StringUtils;

public class StringNullConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {

		if (!StringUtils.isNotBlank(attribute)) {
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

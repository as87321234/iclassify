package com.pointtomap.iclassify.jpa.json;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {

	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static <T> T fromString(final String string, final Class<T> clazz) {
		try {
			if (StringUtils.isBlank(string)) {
				return null;
			} else {
				return OBJECT_MAPPER.readValue(string, clazz);
			}
		} catch (final IOException e) {
			throw new IllegalArgumentException(
					"The given string value: " + string + " cannot be transformed to Json object");
		}
	}

	public static String toString(final Object value) {
		try {
			if (value == null) {
				return null;
			} else {
				return OBJECT_MAPPER.writeValueAsString(value);
			}
		} catch (final IOException e) {
			throw new IllegalArgumentException(
					"The given Json object value: " + value + " cannot be transformed to a String");
		}
	}

	public static JsonNode toJsonNode(final String value) {
		try {
			if (StringUtils.isBlank(value)) {
				return null;
			} else {
				return OBJECT_MAPPER.readTree(value);
			}
		} catch (final IOException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T clone(final T value) {
		return fromString(toString(value), (Class<T>) value.getClass());
	}
}
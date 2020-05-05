package com.toddfast.util.convert.conversion;

import java.util.UUID;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a long by parsing the value as a string
 *
 */
public class UUIDConversion implements TypeConverter.Conversion {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] { UUID.class, UUID.class, UUID.class.getName(),
				TypeConverter.TYPE_UUID };
	}

	@Override
	public Object convert(Object value) {
		if (value == null) {
			return null;
		}
		if (!(value instanceof UUID)) {
			value = UUID.fromString((String) value);
		}
		return value;
	}
}

package com.toddfast.util.convert.conversion;

import java.util.ArrayList;
import java.util.List;

import com.toddfast.util.convert.TypeConverter;

/**
 * Converts the value to a string. If the value is a byte or char array, it is
 * converted to a string via {@link toString()}.
 *
 */
public class ListStringTypeConversion implements TypeConverter.Conversion {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] { List.class, List.class.getName(),
				TypeConverter.TYPE_LIST };
	}

	@Override
	public Object convert(final Object value) {
		if (value == null) {
			return null;
		}

		final ArrayList<String> newValue = new ArrayList<String>();

		for (final String str : (String[]) value) {
			newValue.add(str);
		}

		return newValue;
	}
}

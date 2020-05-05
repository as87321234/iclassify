package com.toddfast.util.convert.conversion;

import java.lang.reflect.Method;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to an integer by parsing the value as a string
 *
 */
public class IntegerTypeConversion implements TypeConverter.Conversion {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] { Integer.class, Integer.TYPE,
				Integer.class.getName(), TypeConverter.TYPE_INT,
				TypeConverter.TYPE_INTEGER };
	}

	@Override
	public Object convert(Object value) {

		if (value == null) {
			return null;
		}

		// If you use Enumerator in your class
		// ensure that the name of the class end with Enum
		// and the getValue returns an integer

		boolean match = value.getClass().getName().matches(".*Enum$");

		if (match) {

			Method method;

			try {

				method = value.getClass().getMethod("getValue");
				value = method.invoke(value);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!(value instanceof Integer)) {
			String v = value.toString();
			if (v.trim().length() == 0) {
				value = null;
			} else {
				value = Integer.parseInt(v);
			}
		}
		return value;
	}
}

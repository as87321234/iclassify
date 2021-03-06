package com.toddfast.util.convert.conversion;

import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a float by parsing the value as a string
 *
 */
public class FloatTypeConversion implements TypeConverter.Conversion {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] {
			Float.class,
			Float.TYPE,
			Float.class.getName(),
			TypeConverter.TYPE_FLOAT
		};
	}

	@Override
	public Object convert(Object value) {
		if (value==null) {
			return null;
		}
		if (!(value instanceof Float)) {
			String v=value.toString();
			if (v.trim().length()==0) {
				value=null;
			}
			else {
				value=Float.parseFloat(v);
			}
		}
		return value;
	}
}

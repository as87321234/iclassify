package com.toddfast.util.convert.conversion;

import com.pointtomap.iclassify.jpa.orm.enumeration.PermissionBlastReportEnum;
import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a long by parsing the value as a string
 *
 */
public class PermissionBlastReportEnumConversion implements
		TypeConverter.Conversion {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] { PermissionBlastReportEnum.class,
				PermissionBlastReportEnum.TYPE,
				PermissionBlastReportEnum.class.getName(),
				TypeConverter.TYPE_PERMISSION_BLAST_REPORT_ENUM };
	}

	@Override
	public Object convert(Object value) {
		if (value == null) {
			return null;
		}
		if (!(value instanceof PermissionBlastReportEnum)) {
			value = PermissionBlastReportEnum.getEnum((Integer) value);
		}
		return value;
	}
}

package com.toddfast.util.convert.conversion;

import com.blastvibrations.jpa.orm.enumeration.GroupMemberShipEnum;
import com.toddfast.util.convert.TypeConverter;

/**
 * Convert to a long by parsing the value as a string
 *
 */
public class GroupMemberShipEnumConversion implements TypeConverter.Conversion {

	@Override
	public Object[] getTypeKeys() {
		return new Object[] { GroupMemberShipEnum.class,
				GroupMemberShipEnum.TYPE, GroupMemberShipEnum.class.getName(),
				TypeConverter.TYPE_GROUP_MEMBERSHIP_ENUM };
	}

	@Override
	public Object convert(Object value) {
		if (value == null) {
			return null;
		}
		if (!(value instanceof GroupMemberShipEnum)) {
			value = GroupMemberShipEnum.getEnum((Integer) value);
		}
		return value;
	}
}

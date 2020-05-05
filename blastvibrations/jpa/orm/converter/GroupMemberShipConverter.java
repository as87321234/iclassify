package com.blastvibrations.jpa.orm.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.blastvibrations.jpa.orm.enumeration.GroupMemberShipEnum;

@Converter
public class GroupMemberShipConverter implements
		AttributeConverter<GroupMemberShipEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(GroupMemberShipEnum value) {

		if (value != null) {
			switch (value) {
			case GROUP_USER:
				return 0;
			case GROUP_MANAGER:
				return 1;
			case GROUP_ADMIN:
				return 2;
			default:
				throw new IllegalArgumentException("Unknown" + value.getValue());
			}
		} else {
			return null;
		}

	}

	@Override
	public GroupMemberShipEnum convertToEntityAttribute(Integer value) {
		if (value != null) {
			switch (value) {
			case 0:
				return GroupMemberShipEnum.GROUP_USER;
			case 1:
				return GroupMemberShipEnum.GROUP_MANAGER;
			case 2:
				return GroupMemberShipEnum.GROUP_ADMIN;
			default:
				throw new IllegalArgumentException("Unknown" + value);
			}
		} else {
			return null;
		}
	}
}

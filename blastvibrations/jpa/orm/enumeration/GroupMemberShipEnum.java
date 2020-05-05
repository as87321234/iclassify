package com.blastvibrations.jpa.orm.enumeration;

public enum GroupMemberShipEnum {

	GROUP_USER(0), GROUP_MANAGER(1), GROUP_ADMIN(2);

	public static final Class<GroupMemberShipEnum> TYPE = GroupMemberShipEnum.class;

	private final int value;

	GroupMemberShipEnum(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

	public static GroupMemberShipEnum getEnum(int groupMembership) {
		// TODO Auto-generated method stub

		switch (groupMembership) {
		case 0:
			return GROUP_USER;
		case 1:
			return GROUP_MANAGER;
		case 2:
			return GROUP_ADMIN;
		default:
			break;
		}
		return null;
	}

}

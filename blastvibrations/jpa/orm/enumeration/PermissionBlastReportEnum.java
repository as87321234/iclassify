package com.blastvibrations.jpa.orm.enumeration;

public enum PermissionBlastReportEnum {

	USER_PERMISSION_BLASTREPORT_NONE(0), 
	USER_PERMISSION_BLASTREPORT_VIEW(1), 
	USER_PERMISSION_BLASTREPORT_CONTRIBUTE(2), 
	USER_PERMISSION_BLASTREPORT_EDIT(3);

	public static final Class<PermissionBlastReportEnum> TYPE = PermissionBlastReportEnum.class;

	private final int value;

	PermissionBlastReportEnum(final int newValue) {
		value = newValue;
	}

	public int getValue() {
		return value;
	}

	public static PermissionBlastReportEnum getEnum(int enumId) {
		switch (enumId) {
		case 0:
			return USER_PERMISSION_BLASTREPORT_NONE;
		case 1:
			return USER_PERMISSION_BLASTREPORT_VIEW;
		case 2:
			return USER_PERMISSION_BLASTREPORT_CONTRIBUTE;
		case 3:
			return USER_PERMISSION_BLASTREPORT_EDIT;
		default:
			break;

		}
		return null;
	}
}

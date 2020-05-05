package com.blastvibrations.jpa.orm.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.blastvibrations.jpa.orm.enumeration.PermissionBlastReportEnum;

@Converter
public class PermissionBlastReportConverter implements
		AttributeConverter<PermissionBlastReportEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(PermissionBlastReportEnum value) {

		if (value != null) {
			switch (value) {
			case USER_PERMISSION_BLASTREPORT_NONE:
				return 0;
			case USER_PERMISSION_BLASTREPORT_VIEW:
				return 1;
			case USER_PERMISSION_BLASTREPORT_CONTRIBUTE:
				return 2;
			case USER_PERMISSION_BLASTREPORT_EDIT:
				return 3;
			default:
				throw new IllegalArgumentException("Unknown" + value.getValue());
			}
		} else {
			return null;
		}

	}

	@Override
	public PermissionBlastReportEnum convertToEntityAttribute(Integer value) {

		if (value != null) {
			switch (value) {
			case 0:
				return PermissionBlastReportEnum.USER_PERMISSION_BLASTREPORT_NONE;
			case 1:
				return PermissionBlastReportEnum.USER_PERMISSION_BLASTREPORT_VIEW;
			case 2:
				return PermissionBlastReportEnum.USER_PERMISSION_BLASTREPORT_CONTRIBUTE;
			case 3:
				return PermissionBlastReportEnum.USER_PERMISSION_BLASTREPORT_EDIT;
			default:
				throw new IllegalArgumentException("Unknown" + value);
			}
		} else {
			return null;
		}
	}
}
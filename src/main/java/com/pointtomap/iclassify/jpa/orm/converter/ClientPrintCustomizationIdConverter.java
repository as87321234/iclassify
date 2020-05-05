package com.pointtomap.iclassify.jpa.orm.converter;

import javax.persistence.AttributeConverter;

import com.pointtomap.iclassify.jpa.orm.enumeration.ClientPrintCustomizationEnum;

public class ClientPrintCustomizationIdConverter implements
AttributeConverter<ClientPrintCustomizationEnum, String> {

	@Override
	public String convertToDatabaseColumn(
			final ClientPrintCustomizationEnum pickerType) {

		return pickerType.name();
	}

	@Override
	public ClientPrintCustomizationEnum convertToEntityAttribute(
			final String pickerType) {
		// TODO Auto-generated method stub

		return ClientPrintCustomizationEnum.valueOf(pickerType);
	}

}

package com.pointtomap.iclassify.jpa.orm.converter;

import javax.persistence.AttributeConverter;

import com.pointtomap.iclassify.jpa.orm.enumeration.PickerTypeEnum;

public class PickerTypeConverter implements
AttributeConverter<PickerTypeEnum, String> {

	@Override
	public String convertToDatabaseColumn(PickerTypeEnum pickerType) {

		return pickerType.name();
	}

	@Override
	public PickerTypeEnum convertToEntityAttribute(String pickerType) {
		// TODO Auto-generated method stub

		return PickerTypeEnum.valueOf(pickerType);
	}

}

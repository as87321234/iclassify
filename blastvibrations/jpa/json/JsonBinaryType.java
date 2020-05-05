package com.blastvibrations.jpa.json;

import java.util.Properties;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

public class JsonBinaryType extends
		AbstractSingleColumnStandardBasicType<Object> implements
		DynamicParameterizedType {

	/**
	 *
	 */
	private static final long serialVersionUID = 318706656877477398L;

	public JsonBinaryType() {
		super(JsonBinarySqlTypeDescriptor.INSTANCE, new JsonTypeDescriptor());
	}

	@Override
	public String getName() {
		return "jsonb";
	}

	@Override
	public void setParameterValues(Properties parameters) {
		((JsonTypeDescriptor) getJavaTypeDescriptor())
				.setParameterValues(parameters);
	}

}

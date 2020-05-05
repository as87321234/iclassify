package com.pointtomap.iclassify.jpa.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

	public static String stringify(Object o) {

		final ObjectMapper mapper = new ObjectMapper();
//	mapper.registerModule(new JstSerializerModule());

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		mapper.setDateFormat(df);

		final StringBuffer json = new StringBuffer();

		try {

			json.append(mapper.writeValueAsString(o));

		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		}
		return json.toString();

	}
}

package com.blastvibrations.jpa.util;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class StackTraceFormatter extends ExceptionUtils {

	public static String printCauseBy(Throwable ex) {

		String[] exceptionFrames = ExceptionUtils.getStackFrames(ex);

		StringBuffer sb = new StringBuffer();

		for (String frames : exceptionFrames) {

			if (frames.toLowerCase().matches(".*exception.*")) {

				sb.append(frames + "<br>");
			}
		}

		return sb.toString();
	}
}

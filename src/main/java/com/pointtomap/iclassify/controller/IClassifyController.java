package com.pointtomap.iclassify.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.pointtomap.iclassify.IC;
import com.pointtomap.iclassify.ICUserSession;
import com.pointtomap.iclassify.ICConstant;

/**
 * <h1>PerfTestInitEntrust</h1>
 *
 * All controllers in the PerfTest application extends this base controller.
 * 
 * Currently it does nothing.
 * 
 * @author Andre St-Louis
 * @version 1.0
 * @since 2020-04-15
 */

@SuppressWarnings("unused")
public class IClassifyController {

	private static Logger log = LoggerFactory.getLogger(IClassifyController.class);

	public IClassifyController() {

	}

	ICUserSession getUserSession(HttpServletRequest request) {

		ICUserSession userSession = (ICUserSession) request.getAttribute(IC.USER_SESSION);
		return userSession;
	}

	String exceptionFormatter(Exception e) {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);

		return sw.toString();

	}

	/**
	 * 
	 * The exceptionFormatter(e)) return a formatted string and update the
	 * ModelAndView object
	 * 
	 * @param model
	 * @param e
	 * @return
	 */
	String exceptionFormatter(ModelAndView model, Exception e) {

		String fmtExcept = exceptionFormatter(e);

		exceptionFormatter(model.getModel(), e);

		return fmtExcept;

	}

	/**
	 * 
	 * The exceptionFormatter(e)) return a formatted string and update the
	 * ModelAndView object
	 * 
	 * @param modelMap
	 * @param e
	 * @return
	 */
	String exceptionFormatter(Map<String, Object> modelMap, Exception e) {

		String fmtExcept = exceptionFormatter(e);

		modelMap.put(ICConstant.RESPONSE_ERROR, exceptionFormatter(e));

		return fmtExcept;

	}

	InputStream exceptionFormatterStream(Exception e) {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);

		ByteArrayInputStream bis = new ByteArrayInputStream(sw.toString().getBytes());

		return bis;
	}

	public boolean mustFlushSession() {
		return false;
	}

}

package com.pointtomap.iclassify;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pointtomap.iclassify.controller.IClassifyController;
import com.pointtomap.iclassify.controller.MainController;

@Component
public class ICHandlerInterceptor implements HandlerInterceptor {

	private static final String JSESSION_ID = "JSESSIONID";

	private static Logger log = LoggerFactory.getLogger(ICHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		request.setAttribute("date", (new Date()).toString());
		request.setAttribute("version", ICEnvironment.getManifestVersion());

		if (handler instanceof HandlerMethod && ((HandlerMethod) handler).getBean() instanceof IClassifyController) {

			// Initialize Cookie
			Cookie jessionCookie = getCookieByName(request, JSESSION_ID);

			// No cookie
			if (jessionCookie == null) {
				jessionCookie = new Cookie(JSESSION_ID, UUID.randomUUID().toString());
				response.addCookie(jessionCookie);
			}

			// Cookie but no jessionId
			if (StringUtils.isEmpty(jessionCookie.getValue())) {
				jessionCookie.setValue(UUID.randomUUID().toString());
			}

			// Reset session idle time
			jessionCookie.setMaxAge(1 * 60 * 60 * 1000);

			String jsessionId = jessionCookie.getValue();

			// Check if user has a session
			ICUserSession userSession = ICServerSessionHandler.getUserSession(jsessionId);

			if (userSession == null) {
				userSession = ICServerSessionHandler.getNewSession(jsessionId);
			}

			// Inject session id in model
			request.setAttribute(IC.USER_SESSION, userSession);

			// User logout
			if (userSession.isAuthenticated() && ((HandlerMethod) handler).getMethod().getName().contains("logout")) {
				ICServerSessionHandler.removeUserSession(jsessionId);
				userSession.setAuthenticated(false);
			}

			// User not authenticated
			// return user to authenticate.html
			if (!userSession.isAuthenticated()
					&& !((HandlerMethod) handler).getMethod().getName().contains("authenticate")) {

				response.sendRedirect(MainController.AUTHENTICATE_REQUEST);
				return HandlerInterceptor.super.preHandle(request, response, handler);

			} else if (!userSession.isAuthenticated()
					&& ((HandlerMethod) handler).getMethod().getName().contains("authenticate")) {

				return HandlerInterceptor.super.preHandle(request, response, handler);

			} else if (userSession.isAuthenticated()
					&& ((HandlerMethod) handler).getMethod().getName().contains("authenticate")) {

				response.sendRedirect(MainController.INDEX_REQUEST);
				return HandlerInterceptor.super.preHandle(request, response, handler);

			} else {
//				response.sendRedirect(MainController.INDEX_REQUEST);
				return HandlerInterceptor.super.preHandle(request, response, handler);
			}

		} else

		{
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}

	}

	private Cookie getCookieByName(HttpServletRequest request, String jessionId) {

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			List<Cookie> cookieList = Arrays.asList(cookies);

			Cookie[] cookie = new Cookie[1];
			cookieList.forEach(c -> {

				if (c.getName().contentEquals(JSESSION_ID))
					cookie[0] = c;
			});

			return cookie[0];
		} else {
			return null;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// Create a ModelAndView if it does not exists
		if (modelAndView == null) {
			modelAndView = new ModelAndView();
		}

//
		Map<String, Object> map = modelAndView.getModel();
//		// Inject current time in the mode
//		map.put("date", new Date());
//		// Inject software version
//		map.put("version", IClassifyEnvironment.getManifestVersion());

		// If error detected copy error in the results properties
		Object o = map.get(ICConstant.RESPONSE_ERROR);

		if (o != null) {
			map.put(ICConstant.RESPONSE_RESULT, o);
			log.error("\n" + o.toString());
		}

		// Continue
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

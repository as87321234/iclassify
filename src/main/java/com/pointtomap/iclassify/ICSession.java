package com.pointtomap.iclassify;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pointtomap.iclassify.jpa.orm.IcUser;

/*
 * Having DispatchActionSupport helps to get Spring Servlet
 */

@SuppressWarnings("deprecation")
@Controller
public abstract class ICSession {

	public ICUserSession getIclassifyUserSession() {
		return iclassifyUserSession;
	}

	public IcUser getUser() {
		return user;
	}

	public void setIclassifyUserSession(ICUserSession iclassifyUserSession) {
		this.iclassifyUserSession = iclassifyUserSession;
	}

	private static final Logger LOG = LoggerFactory.getLogger(ICSession.class);

	public final static String USER_SESSION = "USER";
	public final static String DTO_SESSION = "DTO";

	public final static Boolean CHECKING_ACTIVE_SESSION_ON = true;
	public final static Boolean CHECKING_ACTIVE_SESSION_OFF = false;

	public final static Boolean CHECKING_USE_ADMIN_SESSION_ON = true;
	public final static Boolean CHECKING_USE_ADMIN_SESSION_OFF = false;

	private static final String MAX_MODIFIED_LIST = "maxModifiedClientList";

	private HttpSession session;

	private ICUserSession iclassifyUserSession;

	private IcUser user;

	private HttpServletRequest request;

	private HttpServletResponse response;

	private String host;

	private String referer;

	private boolean isClientsAlwaysSet = false;

	private Boolean checkUserInSession = CHECKING_ACTIVE_SESSION_ON;

	private Boolean checkSessionAdmin = CHECKING_USE_ADMIN_SESSION_OFF;

	@Autowired
	private ICEntityDirtyCache exEntityDirtyCache;

	private Date maxModifiedClientList;

	abstract public boolean mustFlushSession();

	/*
	 * Typically here, always check the session
	 */
	public ICSession() {

	}

	/*
	 * There is the constructor to override the session checking
	 */
	public ICSession(final Boolean checkUserInSession) {
		this.checkUserInSession = checkUserInSession;
	}

	/*
	 * There is the constructor to override the session checking and also make sure
	 * the user is admin right
	 */
	public ICSession(final Boolean checkUserInSession, final Boolean checkSessionAdmin) {
		this.checkUserInSession = checkUserInSession;
		this.checkSessionAdmin = checkSessionAdmin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.actions.DispatchAction#execute(org.apache.struts.action
	 * .ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */

	public void setIClassifySession(final ICUserSession blastSession) {
		this.iclassifyUserSession = blastSession;
	}

	private String getMethodName() {
		if (request.getParameter("command") == null || request.getParameter("command").isEmpty()) {
			return "perform";
		}
		return request.getParameter("command");
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(final IcUser user) {
		this.user = user;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @return the referer
	 */
	public String getReferer() {
		return referer;
	}

//	/**
//	 * @return the mapping
//	 */
//	public ActionMapping getMapping() {
//		return mapping;
//	}
//
//	/**
//	 * @return the form
//	 */
//	public ActionForm getForm() {
//		return form;
//	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

//	/**
//	 * Return the current ServletContext.
//	 */
//	public WebApplicationContext getWebAppCtx() {
//		return this.getWebApplicationContext();
//	}
//
//	/**
//	 * Return the current ServletContext.
//	 */
//	public ServletContext getServletCtx() {
//		return this.getServletContext();
//	}

	public long getElapsedTime(final long start) {
		return System.currentTimeMillis() - start;
	}

	public boolean isUserSessionValid() {
		boolean stillInSession = true;

		if (getIclassifyUserSession() == null) {
			stillInSession = false;
		}

		return stillInSession;
	}

//	@Deprecated
//	// use hasBlastReortEditRequired()
//	public boolean isBlastreportEditRequired(final String act) {
//		boolean isAllowed = true;
//
//		// TODO: ANdre, replace 3 by ENUM
//		if ((act != null) && (act.equalsIgnoreCase("delete") && (getBlastSession().isAdmin() != true)
//				&& (getBlastSession().getUser().getPermissionBlastReport() == null || getUser()
//						.getPermissionBlastReport()
//						.getValue() != PermissionBlastReportEnum.USER_PERMISSION_BLASTREPORT_EDIT.getValue()))) {
//			isAllowed = false;
//		}
//
//		return isAllowed;
//	}

//	public ActionForward _makeErrorOnUserSessionRequired() {
//		final ActionErrors errors = new ActionErrors();
//
//		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.session.required"));
//		saveErrors(getRequest(), errors);
//
//		return (new ActionForward(getMapping().getInput()));
//	}
//
//	public ActionForward makeErrorOn(final HttpServletRequest request, final ActionMapping mapping,
//			final BlastActionError error) {
//		final ActionErrors errors = new ActionErrors();
//
//		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(error.toString()));
//		saveErrors(request, errors);
//
//		return (new ActionForward(mapping.getInput()));
//	}
//
//	public ActionForward makeErrorOn(final BlastActionError error) {
//		final ActionErrors errors = new ActionErrors();
//
//		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError(error.toString()));
//		saveErrors(getRequest(), errors);
//
//		return (new ActionForward(getMapping().getInput()));
//	}

	/*
	 * get timezone offset information from the user's browser session. This is used
	 * to get the correct set of events for the given time period. monitors don't
	 * have timezone/daylight savings info and therefore are recorded in the local
	 * time. all other timestamps are in UTC. Therefore, the timezoneOffset is used
	 * to get the right set of events for the timezone
	 */
	public int getTimezoneOffsetFromCookies() {
		final Cookie[] cookies = getRequest().getCookies();

		// Set the timezone offset
		String timezoneOffset = "-0";

		// Cookie[] cookies = request.getCookies();
		for (int n = 0; n < cookies.length; n++) {
			if (cookies[n].getName().equalsIgnoreCase("timezone")) {
				timezoneOffset = cookies[n].getValue();
			}
		}

		// offsetDF.setTimeZone(TimeZone.getTimeZone("GMT"+timezoneOffset));
		final int offset = Integer.parseInt(timezoneOffset);

		LOG.debug("User's timezone offset:" + timezoneOffset);

		return offset;

	}

	public long getMsfromTimezoneOffset(final long timezoneOffset) {
		// long offset = (long) timezoneOffset;

		final long offsetMs = timezoneOffset * 60 * 60 * 1000;
		return offsetMs;

	}

	/**
	 * @return the checkUserInSession
	 */
	public Boolean getCheckUserInSession() {
		return checkUserInSession;
	}

	/**
	 * @param checkUserInSession the checkUserInSession to set
	 */
	public void setCheckUserInSession(final Boolean checkUserInSession) {
		this.checkUserInSession = checkUserInSession;
	}

	/**
	 * @return the checkSessionAdmin
	 */
	public Boolean getCheckSessionAdmin() {
		return checkSessionAdmin;
	}

	/**
	 * @param checkSessionAdmin the checkSessionAdmin to set
	 */
	public void setCheckSessionAdmin(final Boolean checkSessionAdmin) {
		this.checkSessionAdmin = checkSessionAdmin;
	}

	private boolean checkIsListDirty(final Class c) {

		final Date maxModified = exEntityDirtyCache.getModified(c, session.getId());

		Date sessionMaxModified = (Date) request.getSession().getAttribute(MAX_MODIFIED_LIST + c.getCanonicalName());

		if (sessionMaxModified == null) {

			sessionMaxModified = new Date(0);

			request.getSession().setAttribute(MAX_MODIFIED_LIST + c.getCanonicalName(), sessionMaxModified);
		}

		if (maxModified.getTime() > sessionMaxModified.getTime()) {

			LOG.info("User Session Cache is dirty reloading: " + c.getCanonicalName());

			return true;

		}

		return false;
	}

	public void refreshUserSession() {

		LOG.info("Refreshing user session ");

	}
}

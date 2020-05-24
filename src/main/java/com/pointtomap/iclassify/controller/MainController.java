package com.pointtomap.iclassify.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pointtomap.iclassify.IC;
import com.pointtomap.iclassify.ICEnvironment;
import com.pointtomap.iclassify.ICUserSession;
import com.pointtomap.iclassify.form.MainControllerForm;
import com.pointtomap.iclassify.jpa.dao.IcDocumentDao;
import com.pointtomap.iclassify.jpa.dao.IcUserDao;
import com.pointtomap.iclassify.jpa.dao.IcUserDocumentDao;
import com.pointtomap.iclassify.jpa.orm.UserGroupEnum;
import com.pointtomap.iclassify.jpa.orm.IcUser;

/**
 * <h1>NistPacketController</h1>
 *
 * The NistPacketController contains a group of methods to manipulate NIST
 * packets.
 * 
 * @author Andre St-Louis
 * @version 1.0
 * @since 2020-04-15
 */

/**
 * @author stlouisa
 *
 */
/**
 * @author stlouisa
 *
 */
@Controller
@Transactional
public class MainController extends IClassifyController {

	private static final String INDEX_VIEW = "/thymeleaf/index.html";
	public static final String INDEX_REQUEST = "/index";

	private static final String AUTHENTICATE_VIEW = "/thymeleaf/main/authenticate.html";
	public static final String AUTHENTICATE_REQUEST = "/main/authenticate";
	public static final String LOGOUT_REQUEST = "/main/logout";
	private static final String AUTHENTICATE_VERIFY_REQUEST = "/main/authenticate/verify";

	private static final String LOGOUT_LOGIN_REQUEST = "/main/logoutLogin";

	Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired
	ICEnvironment env;

	@Autowired
	IcUserDao icUserDao;

	@Autowired
	IcDocumentDao icDocumentDao;

	@Autowired
	IcUserDocumentDao icUserDocumentDao;

	/**
	 * Default constructor
	 * 
	 */
	public MainController() {
		super();
	}

	/**
	 * 
	 * Initialize encryption, verification and processSolutionEPF1
	 * ClassPathResources
	 * 
	 * @param env
	 * 
	 */

	@Autowired
	public void init(ICEnvironment env) {
	}

	@GetMapping(value = "/")
	public ModelAndView defaultIndex(Locale locale, ModelMap model) {
		return new ModelAndView(INDEX_VIEW, model);
	}

	@GetMapping(value = INDEX_REQUEST)
	public ModelAndView index(Locale locale, ModelMap model) {
		return new ModelAndView(INDEX_VIEW, model);
	}

	@GetMapping(value = AUTHENTICATE_REQUEST)
	public String authenticate(Locale locale, ModelMap model) {
		initAdminAccount();

		return AUTHENTICATE_VIEW;
	}

	@GetMapping(value = LOGOUT_REQUEST)
	public String logout(Locale locale, ModelMap model) {
		return AUTHENTICATE_VIEW;
	}

	@GetMapping(value = LOGOUT_LOGIN_REQUEST)
	public String logoutLogin(Locale locale, ModelMap model) {
		return logout(locale, model);
	}

	@RequestMapping(value = AUTHENTICATE_VERIFY_REQUEST, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView authenticateVerify(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("mainControllerForm") MainControllerForm mainControllerForm,
			@ModelAttribute("requestQuery") String requestQuery, ModelMap model) {

		// Authenticate user
		boolean isCredential = icUserDao.checkCredential(mainControllerForm.getUsername(),
				mainControllerForm.getPassword());

		if (isCredential) {

			ICUserSession userSession = getUserSession(request);
			IcUser user = icUserDao.findUserByUsername(mainControllerForm.getUsername());

			userSession.setUser(user);
			userSession.setAuthenticated(true);

		} else {

			model.put(IC.ERROR_MSG, "Invalid username or password.");
			return new ModelAndView(AUTHENTICATE_VIEW, model);

		}

		return new ModelAndView("redirect:" + INDEX_REQUEST, model);

	}

	/**
	 * Initialize the admin account if it does not exists
	 * 
	 * Don't forget to change the password
	 * 
	 */
	public void initAdminAccount() {

		log.info("Initialization Database");

		IcUser adminUser = icUserDao.findUserByUsername("admin");
		IcUser defaultUser = icUserDao.findUserByUsername("sb87321234");
		IcUser defaultUser2 = icUserDao.findUserByUsername("as87321234");

		if (adminUser == null) {
			IcUser aUser = new IcUser();
			aUser.setUsername("admin");
			aUser.setEmailAddress("as87321234@gmail.com");
			aUser.setHashedPasswd("Password1");
			aUser.setUserGroup(UserGroupEnum.ADMIN);

			icUserDao.persist(aUser);

			log.info("\"admin\" user created");

		} else {
			log.info("\"admin\" user exits");
		}

		if (defaultUser == null) {
			IcUser aUser = new IcUser();
			aUser.setUsername("sb87321234");
			aUser.setEmailAddress("sb87321234@gmail.com");
			aUser.setHashedPasswd("p");
			aUser.setFirstName("Sonia");
			aUser.setLastName("Begin");
			aUser.setUserGroup(UserGroupEnum.READ_WRITE);

			icUserDao.persist(aUser);
		} else {
			log.info("\"default\" user exits");
		}

		if (defaultUser2 == null) {
			IcUser aUser = new IcUser();
			aUser.setUsername("as87321234");
			aUser.setEmailAddress("as87321234@gmail.com");
			aUser.setHashedPasswd("a");
			aUser.setFirstName("Andre");
			aUser.setLastName("St-Louis");
			aUser.setUserGroup(UserGroupEnum.READ_WRITE);

			icUserDao.persist(aUser);

			log.info("\"default2\" user created");

		} else {
			log.info("\"default2\" user exits");
		}

	}

	@Override
	public boolean mustFlushSession() {
		// TODO Auto-generated method stub
		return false;
	}

}

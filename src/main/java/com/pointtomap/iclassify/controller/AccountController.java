package com.pointtomap.iclassify.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pointtomap.iclassify.ICEnvironment;
import com.pointtomap.iclassify.form.MainControllerForm;
import com.pointtomap.iclassify.jpa.dao.IcUserDao;
import com.pointtomap.iclassify.jpa.orm.IcUser;

/**
 * <h1>ManagementController</h1>
 *
 * The ManagementController contains a group of methods to maintain user
 * accounts
 * 
 * @author Andre St-Louis
 * @version 1.0
 * @since 2020-04-15
 */

@Controller
@Transactional
public class AccountController extends IClassifyController {

	private static final String ACCOUNT_LIST_VIEW = "thymeleaf/account/list.html";
	private static final String ACCOUNT_LIST_REQUEST = "/account/list";
	private static final String USER_LIST = "userList";

	Logger log = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	ICEnvironment env;

	@Autowired
	IcUserDao icUserDao;

	/**
	 * Default constructor
	 * 
	 */
	public AccountController() {
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

	@RequestMapping(ACCOUNT_LIST_VIEW)
	public String defaultIndex(Locale locale, ModelMap model) {
//		initAdminAccount();
		return ACCOUNT_LIST_VIEW;
	}

	@RequestMapping(ACCOUNT_LIST_REQUEST)
	@ResponseBody

	public ModelAndView getAccountlLst(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("mainControllerForm") MainControllerForm mainControllerForm,
			@ModelAttribute("requestQuery") String requestQuery, ModelAndView model) {

		List<IcUser> icUserList = icUserDao.findAll();

		model.setViewName(ACCOUNT_LIST_VIEW);
		model.addObject(USER_LIST, icUserList);

		return model;

	}

	@Override
	public boolean mustFlushSession() {
		// TODO Auto-generated method stub
		return false;
	}

}

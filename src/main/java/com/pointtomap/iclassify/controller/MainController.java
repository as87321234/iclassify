package com.pointtomap.iclassify.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pointtomap.iclassify.IClassicyUserSession;
import com.pointtomap.iclassify.IClassifyConstant;
import com.pointtomap.iclassify.IClassifyEnvironment;
import com.pointtomap.iclassify.IClasssifyServerSessionHandler;
import com.pointtomap.iclassify.form.FileUploadForm;
import com.pointtomap.iclassify.form.MainControllerForm;
import com.pointtomap.iclassify.jpa.dao.IcDocumentDao;
import com.pointtomap.iclassify.jpa.dao.IcUserDao;
import com.pointtomap.iclassify.jpa.orm.EnumUserGroup;
import com.pointtomap.iclassify.jpa.orm.IcDocument;
import com.pointtomap.iclassify.jpa.orm.IcUser;
import com.pointtomap.iclassify.jpa.util.HashUtil;

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

	private static final String UPLOAD_DOCUMENT_VIEW = "/thymeleaf/main/uploadDocument.html";
	private static final String UPLOAD_DOCUMENT_REQUEST = "/main/uploadDocument";

	private static final String AUTHENTICATE_VIEW = "/thymeleaf/main/authenticate.html";
	public static final String AUTHENTICATE_REQUEST = "/main/authenticate";
	private static final String AUTHENTICATE_VERIFY_REQUEST = "/main/authenticate/verify";

	private static final String DRAG_AND_DROP_FILE_UPLOADING = "/main/dragAndDropFileUploading";

	Logger log = LoggerFactory.getLogger(MainController.class);

	@Autowired
	IClassifyEnvironment env;

	@Autowired
	IcUserDao icUserDao;

	@Autowired
	IcDocumentDao icDocumentDao;

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
	public void init(IClassifyEnvironment env) {
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

	@RequestMapping(value = AUTHENTICATE_VERIFY_REQUEST, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView authenticateVerify(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("mainControllerForm") MainControllerForm mainControllerForm,
			@ModelAttribute("requestQuery") String requestQuery, ModelAndView model) {

		System.out.println("tesT");

		IClassicyUserSession userSession = IClasssifyServerSessionHandler
				.getUserSession(request.getRequestedSessionId());

		userSession.setAuthenticated(true);

		return new ModelAndView("redirect:" + INDEX_REQUEST, model.getModel());

	}

	@RequestMapping(UPLOAD_DOCUMENT_REQUEST)
	@ResponseBody
	public ModelAndView uploadDocument(Locale locale, ModelMap model) {

		return new ModelAndView(UPLOAD_DOCUMENT_VIEW, model);

	}

	@RequestMapping(value = DRAG_AND_DROP_FILE_UPLOADING, method = RequestMethod.POST)
	public @ResponseBody ModelAndView dragAndDropFileUploading(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
			@ModelAttribute("requestQuery") String requestQuery, ModelAndView model) throws Exception {

		try {

			List<byte[]> fileList = getMultipleFiles(uploadForm);

			for (byte[] fileByteArray : fileList) {

				String filenameHash = HashUtil.sha256(fileByteArray) + ".dcs";
				log.debug(String.format("Loading file: %s", filenameHash));

				File f = new File(env.getDcsDirectory() + "\\" + filenameHash);
				FileCopyUtils.copy(fileByteArray, f);

				IcDocument aDocument = new IcDocument();
				aDocument.setDocumentSha1(filenameHash);
				aDocument.setDescription("");

				icDocumentDao.persist(aDocument);
			}

			model = new ModelAndView(UPLOAD_DOCUMENT_VIEW, new HashMap<String, Object>());

			model.getModel().put(IClassifyConstant.RESPONSE_RESULT, "Test");
			model.getModel().put(IClassifyConstant.RESPONSE_REQUEST_QUERY, requestQuery);

		} catch (Exception e) {

			model.getModel().put(IClassifyConstant.RESPONSE_ERROR, this.exceptionFormatter(e));
			throw e;

		}

		return model;

	}

	private List<byte[]> getMultipleFiles(FileUploadForm uploadForm) throws Exception {

		List<MultipartFile> multipartFileList = uploadForm.getFileselect();

		List<byte[]> fileList = new ArrayList<byte[]>();

		if (null != multipartFileList && multipartFileList.size() > 0) {

			for (MultipartFile multipartFile : multipartFileList) {

				String fileName = multipartFile.getOriginalFilename();

				log.debug(String.format("Processing file %s", fileName));

				if (!"".equalsIgnoreCase(fileName)) {

					byte[] fileByte = multipartFile.getBytes();

					fileList.add(fileByte);

				}

			}

		}

		return fileList;

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

		if (adminUser == null) {
			IcUser aUser = new IcUser();
			aUser.setUsername("admin");
			aUser.setEmailAddress("as87321234@gmail.com");
			aUser.setHashedPasswd("Password1");
			aUser.setUserGroup(EnumUserGroup.ADMIN);

			icUserDao.persist(aUser);

			log.info("\"admin\" user created");

		} else {
			log.info("\"admin\" user exits");
		}

	}

	@Override
	public boolean mustFlushSession() {
		// TODO Auto-generated method stub
		return false;
	}

}

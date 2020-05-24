package com.pointtomap.iclassify.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pointtomap.iclassify.IC;
import com.pointtomap.iclassify.ICConstant;
import com.pointtomap.iclassify.ICEnvironment;
import com.pointtomap.iclassify.ICUserSession;
import com.pointtomap.iclassify.form.FileUploadForm;
import com.pointtomap.iclassify.form.UploadedFile;
import com.pointtomap.iclassify.jpa.dao.IcDocumentDao;
import com.pointtomap.iclassify.jpa.dao.IcUserDao;
import com.pointtomap.iclassify.jpa.dao.IcUserDocumentDao;
import com.pointtomap.iclassify.jpa.orm.IcDocument;
import com.pointtomap.iclassify.jpa.orm.IcUser;
import com.pointtomap.iclassify.jpa.orm.IcUserDocument;
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

@Controller
@Transactional
public class DocumemtController extends IClassifyController {

	private static final String LIST_DOCUMENT_REQUEST = "/document/listDocumentRequest";
	private static final String LIST_DOCUMENT_VIEW = "thymeleaf/document/listDocumentRequest.html";

	private static final String UPLOAD_DOCUMENT_VIEW = "/thymeleaf/document/uploadDocument.html";
	private static final String UPLOAD_DOCUMENT_REQUEST = "/document/uploadDocument";

	private static final String DRAG_AND_DROP_FILE_UPLOADING = "/document/dragAndDropFileUploading";

	Logger log = LoggerFactory.getLogger(DocumemtController.class);

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
	public DocumemtController() {
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

	@RequestMapping(LIST_DOCUMENT_REQUEST)
	@ResponseBody
	public ModelAndView listDocumentRequest(Locale locale, ModelAndView model) {

		List<IcDocument> icDocumentList = icDocumentDao.findAll();

		model.setViewName(LIST_DOCUMENT_VIEW);
		model.addObject(IC.DOCUMENT_LIST, icDocumentList);

		return model;

	}

	@RequestMapping(UPLOAD_DOCUMENT_REQUEST)
	@ResponseBody
	public ModelAndView uploadDocument(Locale locale, ModelMap model) {

		return new ModelAndView(UPLOAD_DOCUMENT_VIEW, model);

	}

	@RequestMapping(value = DRAG_AND_DROP_FILE_UPLOADING, method = RequestMethod.POST)
	public @ResponseBody ModelAndView dragAndDropFileUploading(HttpServletRequest request,
			@ModelAttribute("uploadForm") FileUploadForm uploadForm,
			@ModelAttribute("requestQuery") String requestQuery, ModelAndView model) throws Exception {

		try {

			List<UploadedFile> fileList = getMultipleFiles(uploadForm);

			ICUserSession userSession = getUserSession(request);
			IcUser user = userSession.getUser();

			for (UploadedFile uploadedFile : fileList) {

				String filenameHash = HashUtil.sha256(uploadedFile.getFileByteArray()) + ".dcs";
				log.debug(String.format("Loading file: %s", filenameHash));

				// Check if file already exists

				IcDocument document = icDocumentDao.findByDocumentSha1(filenameHash);
				IcUserDocument userDocument = icUserDocumentDao.findByIcDocument(document, user);

				boolean isDocumentNotExist = document == null ? true : false;
				boolean isDocumentNotBoundWithUser = userDocument == null ? true : false;

				if (isDocumentNotExist) {

					File f = new File(env.getDcsDirectory() + "\\" + filenameHash);
					FileCopyUtils.copy(uploadedFile.getFileByteArray(), f);

					IcDocument aDocument = new IcDocument();
					aDocument.setDocumentSha1(filenameHash);
					aDocument.setDescription("");
					aDocument.setDocumentType(uploadedFile.getDocumentType());

					icDocumentDao.persist(aDocument);

					IcUserDocument aUserDocument = new IcUserDocument();
					aUserDocument.setIcUser(user);
					aUserDocument.setIcDocument(aDocument);

					icUserDocumentDao.persist(aUserDocument);

				} else if (isDocumentNotBoundWithUser) {

					IcUserDocument aUserDocument = new IcUserDocument();
					aUserDocument.setIcUser(user);
					aUserDocument.setIcDocument(document);

					icUserDocumentDao.persist(aUserDocument);

				} else {
					log.debug(String.format("File %s already exist", filenameHash));
				}

			}

			model = new ModelAndView(UPLOAD_DOCUMENT_VIEW, new HashMap<String, Object>());

			model.getModel().put(ICConstant.RESPONSE_RESULT, "Test");
			model.getModel().put(ICConstant.RESPONSE_REQUEST_QUERY, requestQuery);

		} catch (Exception e) {

			model.getModel().put(ICConstant.RESPONSE_ERROR, this.exceptionFormatter(e));
			throw e;

		}

		return model;

	}

	private List<UploadedFile> getMultipleFiles(FileUploadForm uploadForm) throws Exception {

		List<MultipartFile> multipartFileList = uploadForm.getFileselect();

		List<UploadedFile> fileList = new ArrayList<UploadedFile>();

		if (null != multipartFileList && multipartFileList.size() > 0) {

			for (MultipartFile multipartFile : multipartFileList) {

				String fileName = multipartFile.getOriginalFilename();

				log.debug(String.format("Processing file %s", fileName));

				if (!"".equalsIgnoreCase(fileName)) {

					byte[] fileByte = multipartFile.getBytes();

					UploadedFile uploadFile = new UploadedFile(fileByte, fileName);

					fileList.add(uploadFile);

				}

			}

		}

		return fileList;

	}

	@Override
	public boolean mustFlushSession() {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.pointtomap.iclassify.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pointtomap.iclassify.ICEnvironment;

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
public class DictionaryController extends IClassifyController {

	private static final String LIST_WORD_TRANSLATION_REQUEST = "/dictionary/listWordTranslation";
	private static final String LIST_WORD_TRANSLATION_VIEW = "thymeleaf/dictionary/listWordTranslation.html";

	Logger log = LoggerFactory.getLogger(DictionaryController.class);

	@Autowired
	ICEnvironment env;

	/**
	 * Default constructor
	 * 
	 */
	public DictionaryController() {
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

	@RequestMapping(LIST_WORD_TRANSLATION_VIEW)
	@ResponseBody
	public ModelAndView listWordTranslationView(Locale locale, ModelAndView model) {

		model.setViewName(LIST_WORD_TRANSLATION_VIEW);

		return model;

	}

	@RequestMapping(LIST_WORD_TRANSLATION_REQUEST)
	@ResponseBody
	public ModelAndView listWordTranslationRequest(Locale locale, ModelAndView model) {

//		List<IcDocument> icDocumentList = icDocumentDao.findAll();
//
		model.setViewName(LIST_WORD_TRANSLATION_VIEW);
//		model.addObject(IC.DOCUMENT_LIST, icDocumentList);

		return model;

	}

	@Override
	public boolean mustFlushSession() {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.pointtomap.iclassify;

import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ICServerSessionHandler {

	private static Logger log = LoggerFactory.getLogger(ICServerSessionHandler.class);

	private static ICServerSessionHandler instanceSessionHandler;

	private final static HashMap<String, ICUserSession> userSessionMap = new HashMap<String, ICUserSession>();

	public static ICServerSessionHandler getSingleton() {

		if (instanceSessionHandler == null) {
			instanceSessionHandler = new ICServerSessionHandler();
			return instanceSessionHandler;
		}

		return instanceSessionHandler;

	}

	public static ICUserSession getUserSession(String jsessionId) {

		log.debug(String.format("Getting session %s", jsessionId));

		if (jsessionId == null) {
			return getNewSession(UUID.randomUUID().toString());
		} else {
			ICUserSession userSession = userSessionMap.get(jsessionId);

			if (userSession == null) {
				return getNewSession(jsessionId);
			}

			return userSession;
		}

	}

	public static void removeUserSession(String jsessionId) {

		if (jsessionId != null && userSessionMap.get(jsessionId) != null) {

			log.debug(String.format("Removing session %s", jsessionId));
			userSessionMap.remove(jsessionId);

		}

	}

	public static ICUserSession getNewSession(String jsessionId) {

		ICUserSession userSession = new ICUserSession();
		userSession.setJesssionId(jsessionId);
		userSessionMap.put(userSession.getJesssionId(), userSession);

		log.debug(String.format("Getting new session %s", jsessionId));

		return userSession;

	}

}

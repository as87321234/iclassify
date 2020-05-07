package com.pointtomap.iclassify;

import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IClasssifyServerSessionHandler {

	private static Logger log = LoggerFactory.getLogger(IClasssifyServerSessionHandler.class);

	private static IClasssifyServerSessionHandler instanceSessionHandler;

	private final static HashMap<String, IClassicyUserSession> userSessionMap = new HashMap<String, IClassicyUserSession>();

	public static IClasssifyServerSessionHandler getSingleton() {

		if (instanceSessionHandler == null) {
			instanceSessionHandler = new IClasssifyServerSessionHandler();
			return instanceSessionHandler;
		}

		return instanceSessionHandler;

	}

	public static IClassicyUserSession getUserSession(String jsessionId) {

		log.debug(String.format("Getting session %s", jsessionId));

		if (jsessionId == null) {
			return getNewSession(UUID.randomUUID().toString());
		} else {
			IClassicyUserSession userSession = userSessionMap.get(jsessionId);

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

	public static IClassicyUserSession getNewSession(String jsessionId) {

		IClassicyUserSession userSession = new IClassicyUserSession();
		userSession.setJesssionId(jsessionId);
		userSessionMap.put(userSession.getJesssionId(), userSession);

		log.debug(String.format("Getting new session %s", jsessionId));

		return userSession;

	}

}

package com.pointtomap.iclassify;

import java.util.HashMap;
import java.util.UUID;

public class IClasssifyServerSessionHandler {

	private static IClasssifyServerSessionHandler instanceSessionHandler;

	private final static HashMap<String, IClassicyUserSession> userSessionMap = new HashMap<String, IClassicyUserSession>();

	public static IClasssifyServerSessionHandler getSingleton() {

		if (instanceSessionHandler == null) {
			instanceSessionHandler = new IClasssifyServerSessionHandler();
			return instanceSessionHandler;
		}

		return instanceSessionHandler;

	}

	public static IClassicyUserSession getUserSession(String jessionId) {

		if (jessionId == null) {
			return getNewSession(UUID.randomUUID().toString());
		} else {
			IClassicyUserSession userSession = userSessionMap.get(jessionId);

			if (userSession == null) {
				return getNewSession(jessionId);
			}

			return userSession;
		}

	}

	public static IClassicyUserSession getNewSession(String jessionId) {

		IClassicyUserSession userSession = new IClassicyUserSession();
		userSession.setJesssionId(jessionId);
		userSessionMap.put(userSession.getJesssionId(), userSession);

		return userSession;

	}

}

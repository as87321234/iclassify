package com.pointtomap.iclassify;

import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pointtomap.iclassify.jpa.orm.UserGroupEnum;
import com.pointtomap.iclassify.jpa.orm.IcUser;

public class ICUserSession {

	// TODO: Implement timer to clean the session automatically

	Logger LOG = LoggerFactory.getLogger(ICUserSession.class);

	private String jesssionId;

	private IcUser user;

	private boolean isAuthenticated = false;

	private final HashMap<Class<?>, UUID> keys = new HashMap<Class<?>, UUID>();
	private final HashMap<Class<?>, HashMap<String, Object>> objects = new HashMap<Class<?>, HashMap<String, Object>>();

	/**
	 * @return the user
	 */
	public IcUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(final IcUser user) {
		this.user = user;
	}

	public boolean isAdmin() {

		if (user.getUserGroup() == UserGroupEnum.ADMIN) {
			return true;
		}

		return false;

	}

	public void putKey(final Class<?> classType, final UUID id) {

		this.keys.put(classType, id);

	}

	public UUID getKey(final Class<?> classType) {

		return this.keys.get(classType);

	}

	public void removeKey(final Class<?> clazz) {
		this.keys.remove(clazz);

	}

	public void putObject(final Class<?> classType, final String keyName, final Object value) {

		HashMap<String, Object> classRelatedObjects = objects.get(classType);
		if (objects.get(classType) == null) {
			classRelatedObjects = new HashMap<String, Object>();

			objects.put(classType, classRelatedObjects);
		}

		classRelatedObjects.put(keyName, value);

	}

	public Object getObject(final Class<?> classType, final String keyName) {

		final HashMap<String, Object> classRelatedObjects = objects.get(classType);
		if (objects.get(classType) == null) {

			return null;
		}

		return classRelatedObjects.get(keyName);

	}

	public void removeObject(final Class<?> classType, final String keyName) {

		final HashMap<String, Object> classRelatedObjects = objects.get(classType);
		if (objects.get(classType) != null) {

			classRelatedObjects.remove(keyName);
		}

	}

	public void removeObject(final Class<?> classType) {

		objects.remove(classType);

	}

	public void cleanup(final Class<?> clazz) {

		removeKey(clazz);
		removeObject(clazz);
	}

	public void clear() {

		if (objects != null) {
			objects.clear();
		}

		if (keys != null) {
			keys.clear();
		}

	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}

	public String getJesssionId() {
		return jesssionId;
	}

	public void setJesssionId(String jesssionId) {
		this.jesssionId = jesssionId;
	}

}

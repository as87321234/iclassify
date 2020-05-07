package com.pointtomap.iclassify.jpa.dao;

import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.pointtomap.iclassify.jpa.orm.IcUser;
import com.pointtomap.iclassify.jpa.util.HashUtil;

@Repository
public class IcUserDaoImpl extends GenericDaoImpl<IcUser> implements IcUserDao {

	@Override
	public IcUser findByUserId(UUID userId) {

		IcUser user = null;

		try {
			user = (IcUser) getEntityManagerNamedQuery(IcUser.FIND_USER_BY_USER_ID).setParameter("userId", userId)
					.getSingleResult();

			if (user == null) {
				throw new Exception("Username not found");
			}
		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}
		return user;
	}

	@Override
	public IcUser findUserByUsername(String username) {

		IcUser user = null;

		try {

			user = (IcUser) getEntityManagerNamedQuery(IcUser.FIND_USER_BY_USERNAME).setParameter("username", username)
					.getSingleResult();

			if (user == null) {
				throw new Exception("Username not found");
			}

		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		return user;
	}

	@Override
	public boolean checkCredential(String username, String password) {

		IcUser user = findUserByUsername(username);

		if (user != null && (HashUtil.sha256(password).equals(user.getHashedPasswd()))) {

			return true;

		} else {

			return false;

		}

	}

}

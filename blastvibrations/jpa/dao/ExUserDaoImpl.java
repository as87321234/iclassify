package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.user.UserQueries;
import com.blastvibrations.jpa.orm.ExUser;

@Repository
public class ExUserDaoImpl extends GenericDaoImpl<ExUser> implements ExUserDao {

	@Override
	public ExUser findUsername(final String username) {
		ExUser user = null;

		try {
			user = (ExUser) getEntityManagerNamedQuery(
					UserQueries.USER_FINDUSERNAME).setParameter("username",
					username).getSingleResult();

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
	public ExUser findLoginUsername(final String username) {
		ExUser user = null;

		try {
			user = (ExUser) getEntityManagerNamedQuery(
					UserQueries.USER_FINDLOGINUSERNAME).setParameter(
					"username", username).getSingleResult();

			if (user == null) {
				throw new Exception(
						"Username not found or account logically deleted or disabled");
			}
		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExUser> findWhereUsernameNotNullOrderAcending() {

		List<ExUser> userList = null;

		try {
			userList = getEntityManagerNamedQuery(
					UserQueries.USER_FIND_WHERE_USERNAME_NOTNULL_ORDER_ASCENDING)
					.getResultList();

			if (userList == null) {
				userList = new ArrayList<ExUser>();
			}
		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExUser> findUserIdforGivenListOfClient(
			final List<UUID> activeClientList) {

		List<ExUser> userList = null;

		try {
			userList = getEntityManagerNamedQuery(
					UserQueries.USER_FIND_FIND_USERID_FOR_GIVEN_LIST_OF_CLIENT)
					.setParameter("activeClientList", activeClientList)
					.getResultList();

			if (userList == null) {
				userList = new ArrayList<ExUser>();
			}
		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExUser> findListUserByClientId(final UUID clientId) {
		List<ExUser> userList = null;

		try {
			userList = getEntityManagerNamedQuery(
					UserQueries.FIND_LIST_USER_BY_CLIENTID).setParameter(
							"clientId", clientId).getResultList();

			if (userList == null) {

				userList = new ArrayList<ExUser>();
			}
		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExUser> findListUnassingedForClientid(final UUID clientId) {
		List<ExUser> userList = null;

		final String sqlString = " select *  from (select  c.client_id, u.* from ex_user u , ex_client c where   c.client_id = :clientId and u.deleted = false  ) LIST left join ex_client_user_mapping m on ( LIST.user_id = m.user_id and LIST.client_id = m.client_id )  where m.client_id is null";

		try {

			userList = getEntityManager()
					.createNativeQuery(sqlString, ExUser.class)
					.setParameter("clientId", clientId).getResultList();

			// userList = getEntityManagerNamedQuery(
			// UserQueries.FIND_LIST_UNASSINGED_FOR_CLIENT_ID)
			// .setParameter("clientId", clientId).getResultList();

			if (userList == null) {
				userList = new ArrayList<ExUser>();
			}
		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

		return userList;
	}

}

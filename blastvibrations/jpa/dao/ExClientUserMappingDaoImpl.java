package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.clientusermapping.ClientUserMappingQueries;
import com.blastvibrations.jpa.orm.ExClientUserMapping;
import com.blastvibrations.jpa.orm.ExUser;

@Repository
public class ExClientUserMappingDaoImpl extends
GenericDaoImpl<ExClientUserMapping> implements ExClientUserMappingDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExClientUserMapping> findClientUserMappingforGivenListOfClient(
			final List<UUID> clientList) {
		List<ExClientUserMapping> exClientUserMappingList = null;

		try {
			exClientUserMappingList = getEntityManagerNamedQuery(
					ClientUserMappingQueries.CLIENTUSERMAPPING_FIND_FIND_USERID_FOR_GIVEN_LIST_OF_CLIENT)
					.setParameter("activeClientList", clientList)
					.getResultList();

			if (exClientUserMappingList == null) {
				throw new Exception("no user found");
			}
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		return exClientUserMappingList;
	}

	@Override
	public void deletePhysicalForUserId(final UUID userId) {

		try {
			getEntityManagerNamedQuery(
					ClientUserMappingQueries.DELETE_PHYSICAL_FOR_USERID)
					.setParameter("userId", userId).executeUpdate();

		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

	}

	@Override
	public void deleteLogicalForUserId(final UUID userId, final ExUser logonUser) {
		// TODO Auto-generated method stub
		try {
			getEntityManagerNamedQuery(
					ClientUserMappingQueries.DELETE_LOGICAL_FOR_USERID)
					.setParameter("userId", userId)
					.setParameter("lastModifiedByUser", logonUser.getUsername())
					.setParameter("lastModifiedByUserId", logonUser.getUserId())
					.executeUpdate();

		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExClientUserMapping> findClientUserMappingForUserID(
			final ExUser exUser) {

		List<ExClientUserMapping> exClientUserMappingList = null;

		try {
			exClientUserMappingList = getEntityManagerNamedQuery(
					ClientUserMappingQueries.FIND_CLIENT_USER_MAPPING_FOR_USER_ID)
					.setParameter("userId", exUser.getUserId()).getResultList();

			if (exClientUserMappingList == null) {
				throw new Exception("no user found");
			}
		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

		return exClientUserMappingList;

		// TODO Auto-generated method stub

	}

	@Override
	public void deletePhysicalForClientIdUserId(final UUID userId,
			final UUID clientId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try {
			getEntityManagerNamedQuery(
					ClientUserMappingQueries.DELETE_PHYSICAL_FOR_CLIENTID_USERID)
					.setParameter("clientId", clientId)
					.setParameter("userId", userId).executeUpdate();

		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

	}

	@Override
	public void deletePhysicalForClientId(final UUID clientId) {

		try {
			getEntityManagerNamedQuery(
					ClientUserMappingQueries.DELETE_PHYSICAL_FOR_CLIENTID)
					.setParameter("clientId", clientId).executeUpdate();

		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

	}
}

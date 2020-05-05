package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.client.ClientQueries;
import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExUser;

@Repository
public class ExClientDaoImpl extends GenericDaoImpl<ExClient> implements
		ExClientDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExClient> findAllClientsForUserId(final UUID userId) {

		List<ExClient> exClientList = null;

		try {
			exClientList = getEntityManagerNamedQuery(
					ClientQueries.CLIENT_FIND_BY_USER_ID).setParameter(
					"userId", userId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exClientList == null) {
			return new ArrayList<ExClient>();
		} else {
			return exClientList;
		}
	}

	@Override
	public ExClient findByClientId(final UUID clientId) {
		ExClient client = null;

		try {
			client = (ExClient) getEntityManagerNamedQuery(
					ClientQueries.CLIENT_FIND_BY_CLIENT_ID).setParameter(
					"clientId", clientId).getSingleResult();

			if (client == null) {
				throw new Exception("Client ID not found "
						+ clientId.toString());
			}
		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}
		return client;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExClient> findAllActiveClients() {

		List<ExClient> exClientList = null;

		try {
			exClientList = getEntityManagerNamedQuery(
					ClientQueries.FIND_ALL_ACTIVE_CLIENTS).getResultList();

		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

		if (exClientList == null) {
			return new ArrayList<ExClient>();
		} else {
			return exClientList;
		}
	}

	@Override
	public void deleteLogicalClientRelatedTables(final UUID clientId,
			final ExUser logonUser) {

		final Date currentDateTime = new Date();
		try {

			final String[] relatedTable = {
					"update  ex_client_user_mapping set deleted='true', modified = :currentDateTime , last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_blast_type_customization set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_client_customization set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_design_notes_customization set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_blast_notification_template set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_blast_information_customization set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_mailing_list set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_blast_mine_customization set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_picker set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_blast_detail_print_customization set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;",
					"update  ex_general_customization set deleted='true', modified = :currentDateTime, last_modified_by_user_id=:logonUserId, last_modified_by_user=:logonUsername  where  client_id =  :clientId ;" };

			final StringBuffer sqlString = new StringBuffer();

			for (final String sql : relatedTable) {
				sqlString.append(sql);
			}

			getEntityManager().createNativeQuery(sqlString.toString())
					.setParameter("clientId", clientId)
					.setParameter("logonUsername", logonUser.getUsername())
					.setParameter("logonUserId", logonUser.getUserId())
					.setParameter("currentDateTime", currentDateTime)
			.executeUpdate();

		} catch (final Exception ex) {
			ex.printStackTrace();
		}

	}
}

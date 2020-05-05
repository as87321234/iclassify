package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.mailinglistitem.MailinglistItemQueries;
import com.blastvibrations.jpa.orm.ExMailingListItem;

@Repository
public class ExMailingListItemDaoImpl extends GenericDaoImpl<ExMailingListItem>
		implements ExMailingListItemDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExMailingListItem> findMailingListItemForMailingListId(
			final UUID mailingListId) {

		List<ExMailingListItem> exMailingListItemList = null;

		try {

			exMailingListItemList = getEntityManagerNamedQuery(
					MailinglistItemQueries.FIND_MAILINGLISTITEM_FOR_MAILINGLISTID)
					.setParameter("mailingListId", mailingListId)
					.getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exMailingListItemList == null) {
			return new ArrayList<ExMailingListItem>();
		} else {
			return exMailingListItemList;
		}

	}

	@Override
	public void deletePhysicalForMailingListId(final UUID mailingListId) {
		try {
			getEntityManagerNamedQuery(
					MailinglistItemQueries.DELETE_PHYSICAL_FOR_MAILINGLISTID)
					.setParameter("mailingListId", mailingListId)
					.executeUpdate();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}
	}

	@Override
	public void deleteLogicalForMailingListId(final UUID mailingListId,
			final UUID logonUserId, final String logonUsername) {
		try {
			getEntityManagerNamedQuery(
					MailinglistItemQueries.DELETE_LOGICAL_FOR_MAILINGLISTID)
					.setParameter("mailingListId", mailingListId)
					.setParameter("logonUserId", logonUserId)
					.setParameter("logonUsername", logonUsername)
					.executeUpdate();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

	}

}

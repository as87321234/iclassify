package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.mailinglist.MailinglistQueries;
import com.blastvibrations.jpa.orm.ExMailingList;

@Repository
public class ExMailingListDaoImpl extends GenericDaoImpl<ExMailingList>
		implements ExMailingListDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExMailingList> findMailingListForUser(final UUID userId) {

		List<ExMailingList> exMailingListList = null;

		try {

			exMailingListList = getEntityManagerNamedQuery(
					MailinglistQueries.MAILING_FIND_MAILING_LIST_FOR_USER)
					.setParameter("userId", userId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exMailingListList == null) {
			return new ArrayList<ExMailingList>();
		} else {
			return exMailingListList;
		}

	}

}

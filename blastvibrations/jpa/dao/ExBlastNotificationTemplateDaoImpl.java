package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.notificationtemplate.NotificationTemplateQueries;
import com.blastvibrations.jpa.orm.ExBlastNotificationTemplate;

@Repository
public class ExBlastNotificationTemplateDaoImpl extends
	GenericDaoImpl<ExBlastNotificationTemplate> implements
	ExBlastNotificationTemplateDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastNotificationTemplate> findBlastNotificationTemplateByClientId(
	    final UUID clientId) {
	List<ExBlastNotificationTemplate> exNotificationTemplateList = null;

	try {
	    exNotificationTemplateList = getEntityManagerNamedQuery(
		    NotificationTemplateQueries.FIND_BY_CLIENTID).setParameter(
		    "clientId", clientId).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exNotificationTemplateList == null) {
	    return new ArrayList<ExBlastNotificationTemplate>();
	} else {
	    return exNotificationTemplateList;
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastNotificationTemplate> findBlastNotificationTemplatesByUserId(
	    final UUID userId, final boolean isDeleted) {
	@SuppressWarnings("unchecked")
	List<ExBlastNotificationTemplate> exNotificationTemplateList = null;

	try {
	    exNotificationTemplateList = getEntityManagerNamedQuery(
		    NotificationTemplateQueries.FIND_BLAST_NOTIFICATION_TEMPLATE_BY_USERID)
		    .setParameter("userId", userId)
		    .setParameter("deleted", isDeleted).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exNotificationTemplateList == null) {
	    return new ArrayList<ExBlastNotificationTemplate>();
	} else {
	    return exNotificationTemplateList;
	}

	//
	// final StringBuffer exSQL = new StringBuffer();
	// exSQL.append("SELECT * FROM ExBlastNotificationTemplate WHERE clientId IN ("
	// + getClientIdSQLInClause(user) + ") AND deleted != 'true' ");
	//
	// if (filterClient != null && !filterClient.equalsIgnoreCase("")) {
	// exSQL.append(" AND clientId = '" + filterClient + "' ");
	// maxPredicatesIncludingPredicates = maxPredicatesIncludingPredicates -
	// 1;
	// }
	//
	// if ((sort != null)
	// && ((sort.equalsIgnoreCase("clientName")) || (sort
	// .equalsIgnoreCase("subject")))) {
	// exSQL.append(" AND " + sort + " is not null ORDER BY " + sort + "");
	// maxPredicatesIncludingPredicates = maxPredicatesIncludingPredicates -
	// 2;
	// } else {
	// exSQL.append(" AND subject is not null ORDER BY subject");
	// maxPredicatesIncludingPredicates = maxPredicatesIncludingPredicates -
	// 2;
	//
	// }
	// // order by
	// if ((order != null)
	// && ((order.equalsIgnoreCase("ASC") || (order
	// .equalsIgnoreCase("DESC"))))) {
	// exSQL.append(" " + order);
	// } else {
	// exSQL.append(" ASC");
	// }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastNotificationTemplate> findBlsatNotificationTemplatesByUserIdClientId(
	    final UUID userId, final UUID clientId) {
	List<ExBlastNotificationTemplate> exNotificationTemplateList = null;

	return findBlsatNotificationTemplatesByUserIdClientId(userId, clientId,
		false);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastNotificationTemplate> findBlsatNotificationTemplatesByUserIdClientId(
	    final UUID userId, final UUID clientId, final boolean isDeleted) {
	List<ExBlastNotificationTemplate> exNotificationTemplateList = null;

	try {
	    exNotificationTemplateList = getEntityManagerNamedQuery(
		    NotificationTemplateQueries.FIND_BLAST_NOTIFICATION_TEMPLATE_BY_USERID_BY_CLIENTID)
		    .setParameter("userId", userId)
		    .setParameter("clientId", clientId)
		    .setParameter("deleted", isDeleted).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exNotificationTemplateList == null) {
	    return new ArrayList<ExBlastNotificationTemplate>();
	} else {
	    return exNotificationTemplateList;
	}
    }
}

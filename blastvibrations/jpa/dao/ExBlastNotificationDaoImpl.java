package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.notification.NotificationQueries;
import com.blastvibrations.jpa.dao.queries.notificationtemplate.NotificationTemplateQueries;
import com.blastvibrations.jpa.orm.ExBlastNotification;

@Repository
public class ExBlastNotificationDaoImpl extends
	GenericDaoImpl<ExBlastNotification> implements ExBlastNotificationDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastNotification> findBlastNotificationByClientId(
	    final UUID clientId) {
	List<ExBlastNotification> exNotificationList = null;

	try {
	    exNotificationList = getEntityManagerNamedQuery(
		    NotificationTemplateQueries.FIND_BY_CLIENTID).setParameter(
		    "clientId", clientId).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exNotificationList == null) {
	    return new ArrayList<ExBlastNotification>();
	} else {
	    return exNotificationList;
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastNotification> findByUserIdBlastComplaintIdContactId(
	    final UUID userId, final UUID blastComplaintId, final UUID contactId) {
	List<ExBlastNotification> exNotificationList = null;

	try {
	    exNotificationList = getEntityManagerNamedQuery(
		    NotificationQueries.FIND_BY_USERID_BLASTCOMPLAINTID_CONTACTID)
		    .setParameter("userId", userId)
		    .setParameter("blastComplaintId", blastComplaintId)
		    .setParameter("contactId", contactId).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exNotificationList == null) {
	    return new ArrayList<ExBlastNotification>();
	} else {
	    return exNotificationList;
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastNotification> findByUserIdBlastComplaintId(
	    final UUID userId, final UUID blastComplaintId) {
	List<ExBlastNotification> exNotificationList = null;

	try {
	    exNotificationList = getEntityManagerNamedQuery(
		    NotificationQueries.FIND_BY_USERID_BLASTCOMPLAINTID)
		    .setParameter("userId", userId)
		    .setParameter("blastComplaintId", blastComplaintId)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exNotificationList == null) {
	    return new ArrayList<ExBlastNotification>();
	} else {
	    return exNotificationList;
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastNotification> findByUserIdBlastContactId(
	    final UUID userId, final UUID blastContactId) {
	List<ExBlastNotification> exNotificationList = null;

	try {
	    exNotificationList = getEntityManagerNamedQuery(
		    NotificationQueries.FIND_BY_USERID_CONTACTID)
		    .setParameter("userId", userId)
		    .setParameter("blastContactId", blastContactId)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exNotificationList == null) {
	    return new ArrayList<ExBlastNotification>();
	} else {
	    return exNotificationList;
	}
    }

    @Override
    public List<ExBlastNotification> findBlastNotificationByClientUUIDList(
	    final List<UUID> clientUUIDList) {
	List<ExBlastNotification> exNotificationList = null;

	try {
	    exNotificationList = getEntityManagerNamedQuery(

	    NotificationQueries.FIND_BY_CLIENTUUIDLIST).setParameter(
		    "clientUUIDList", clientUUIDList).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exNotificationList == null) {
	    return new ArrayList<ExBlastNotification>();
	} else {
	    return exNotificationList;
	}
    }

    @Override
    public List<ExBlastNotification> findByBlastContactId(UUID blastContactId) {

	return findByBlastContactId(blastContactId, false);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastNotification> findByBlastContactId(UUID blastContactId,
	    boolean isDeleted) {
	List<ExBlastNotification> exNotificationList = null;

	try {
	    exNotificationList = getEntityManagerNamedQuery(

	    NotificationQueries.FIND_BY_CONTACTID)
		    .setParameter("blastContactId", blastContactId)
		    .setParameter("isDeleted", isDeleted).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exNotificationList == null) {
	    return new ArrayList<ExBlastNotification>();
	} else {
	    return exNotificationList;
	}
    }
}

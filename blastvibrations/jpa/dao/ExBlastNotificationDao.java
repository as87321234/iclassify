package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastNotification;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastNotificationDao {

    public List<ExBlastNotification> findAll();

    public List<ExBlastNotification> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastNotification> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecord);

    public ExBlastNotification find(final Object exBlastNotificationId);

    public void delete(final Object exBlastNotificationId);

    public void deleteLogical(final ExBlastNotification exBlastNotification);

    public ExBlastNotification persist(
	    final ExBlastNotification exBlastNotification);

    public List<ExBlastNotification> findBlastNotificationByClientId(
	    UUID clientId);

    public List<ExBlastNotification> findByUserIdBlastComplaintIdContactId(
	    UUID userId, UUID blastComplaintId, UUID contactId);

    public List<ExBlastNotification> findByUserIdBlastComplaintId(UUID userId,
	    UUID blastComplaintId);

    public List<ExBlastNotification> findByUserIdBlastContactId(UUID userId,
	    UUID contactId);

    public List<ExBlastNotification> findBlastNotificationByClientUUIDList(
	    List<UUID> clientUUIDList);

    public List<ExBlastNotification> findByBlastContactId(UUID blastContactId);

    public List<ExBlastNotification> findByBlastContactId(UUID blastContactId,
	    boolean isDeleted);
}

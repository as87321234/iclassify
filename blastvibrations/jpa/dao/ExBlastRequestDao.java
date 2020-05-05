package com.blastvibrations.jpa.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastRequest;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastRequestDao {

    public List<ExBlastRequest> findAll();

    public List<ExBlastRequest> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastRequest> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExBlastRequest find(final Object exBlastRequestId);

    public void delete(final Object exBlastRequestId);

    public void deleteLogical(final ExBlastRequest exBlastRequest);

    public ExBlastRequest persist(final ExBlastRequest exBlastRequest);

    public List<ExBlastRequest> findBlastRequestByClientId(final UUID clientId);

    public List<ExBlastRequest> findByContactId(UUID blastContactId);

    public List<ExBlastRequest> findByContactId(UUID blastContactId,
	    boolean isDeleted);

    List<ExBlastRequest> findBlastRequestsForUserClientList(UUID userId,
	    boolean isDeleted, String sort, String order, String status);

    List<ExBlastRequest> findBlastRequestsForUserClientList(UUID userId,
	    String sort, String order, String status);

    List<ExBlastRequest> findBlastRequestsForUserBetweenStartAndEndDate(
	    UUID userId, Date startDate, Date endDate);

    public ExBlastRequest findByShareId(UUID shareId);

    public List<ExBlastRequest> findActiveRequestByLocationEventDates(
	    String exLocationName, Date eventDate, UUID clientId);
}

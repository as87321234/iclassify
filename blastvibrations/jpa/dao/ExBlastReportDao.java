package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastReport;
import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExUser;

public interface ExBlastReportDao {

    public List<ExBlastReport> findAll();

    public List<ExBlastReport> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastReport> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExBlastReport find(final Object exBlastReportId);

    public ExBlastReport find(final String blastId);

    public void delete(final Object exBlastReportId);

    public void deleteLogical(final ExBlastReport exBlastReport);

    public ExBlastReport persist(final ExBlastReport exBlastReport);

    public List<ExBlastReport> findBlastReportByUserId(final UUID userId);

    public List<ExBlastReport> findBlastReportTemplateByClientId(
	    final UUID clientId);

    public List<ExBlastReport> findBlastReportsForUserBetweenStartAndEndDate(
	    UUID userId, Date startDate, Date endDate);

    public List<ExBlastReport> findBlastReportsNotDeleted();

    public List<ExBlastReport> findBlastReportsByBlastIdsListNotDeleted(
	    final List<String> blastIdsList);

    public List<ExBlastReport> findBlastReportsByBlastUuidsListNotDeleted(
	    final List<UUID> blastIdsList);

    public List<ExBlastReport> findBlastReportsNoTemplateByClientUuidsListNotDeleted(
	    final List<UUID> clientIdsList);

    public List<ExBlastReport> findBlastReportsNoTemplateByClientUuidsListNotDeletedBetweenStartAndEndDate(
	    final List<UUID> clientIdsList, Date startDate, Date endDate);

    public List<UUID> findBlastReportByUserId(UUID userId,
	    ArrayList<UUID> arrayList);

    public List<ExBlastReport> findEventFilterTab(final ExUser user,
	    final List<UUID> allowedClientList, final UUID filterClientId,
	    final String filterLocation, final String filterUnitSerialNumber,
	    final String filterHighlightEventType,
	    final String filterStartDate, final String filterEndDate,
	    final String sort,
	    final String filterStartTime /* not being used */,
	    final String filterEndTime /* not being used */,
	    final int maxRecordResultSet);

}

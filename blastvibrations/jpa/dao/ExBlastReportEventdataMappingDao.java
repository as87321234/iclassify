package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastReportEventdataMapping;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastReportEventdataMappingDao {

    public List<ExBlastReportEventdataMapping> findAll();

    public List<ExBlastReportEventdataMapping> tableSorting(
	    List<ExClient> list, final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastReportEventdataMapping> tableSorting(
	    List<ExClient> list, final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExBlastReportEventdataMapping find(
	    final Object exBlastReportEventdataId);

    public ExBlastReportEventdataMapping find(
	    final String exBlastReportEventdataId);

    public void delete(final Object exBlastReportEventdataId);

    public void deleteLogical(
	    final ExBlastReportEventdataMapping exBlastReportEventdataMapping);

    public ExBlastReportEventdataMapping persist(
	    final ExBlastReportEventdataMapping exBlastReportEventdataMapping);

    public ExBlastReportEventdataMapping findBlastIdEventdataIdWithDeletedRecord(
	    UUID blastId, String eventId);

    public List<ExBlastReportEventdataMapping> findAllByBlastId(UUID blastId);

}

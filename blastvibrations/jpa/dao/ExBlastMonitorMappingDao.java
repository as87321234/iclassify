package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastMonitorMapping;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastMonitorMappingDao {

    public List<ExBlastMonitorMapping> findAll();

    public List<ExBlastMonitorMapping> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastMonitorMapping> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecord);

    public ExBlastMonitorMapping find(final Object exBlastMonitorMappingId);

    public void delete(final Object exBlastMonitorMappingId);

    public void deleteLogical(final ExBlastMonitorMapping exBlastMonitorMapping);

    public ExBlastMonitorMapping persist(
	    final ExBlastMonitorMapping exBlastMonitorMapping);

    public List<ExBlastMonitorMapping> findAllBlastByBlastId(UUID blastId);

    public List<ExBlastMonitorMapping> findAllBlastByBlastId(String blastId);

    public List<ExBlastMonitorMapping> findMonitorMappingByClientId(
	    UUID clientId);
}

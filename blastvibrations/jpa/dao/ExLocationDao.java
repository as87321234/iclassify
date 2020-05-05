package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExLocation;

public interface ExLocationDao {

    public List<ExLocation> findAll();

    public List<ExLocation> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExLocation> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExLocation find(final Object exLocationId);

    public void delete(final Object exLocationId);

    public void deleteLogical(final ExLocation exLocation);

    public ExLocation persist(final ExLocation exLocation);

    public ExLocation findByLocationId(UUID locationId);

    public List<ExLocation> findLocationListOfMonitorId(UUID userId);

    public List<ExLocation> findLocationForMonitorUUIDList(
	    List<UUID> monitorUUIDList);

}

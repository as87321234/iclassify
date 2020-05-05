package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExMonitor;

public interface ExMonitorDao {

    public List<ExMonitor> findAll();

    public List<ExMonitor> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExMonitor> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExMonitor find(final Object exMonitorId);

    public void delete(final Object exMonitorId);

    public void deleteLogical(final ExMonitor exMonitor);

    public ExMonitor persist(final ExMonitor exMonitor);

    public List<ExMonitor> findListMonitorByUserId(final UUID userId);

    public List<ExMonitor> findAllActiveMonitor();

    public List<ExMonitor> findListMonitorByClientId(UUID clientId);

    public List<ExMonitor> findListUnassignedMonitors();

    public void unassignedAllMonitorsForClientId(UUID clientId);

    public List<ExMonitor> findListMonitorByClientIdNotDeleted(UUID clientId);

    public ExMonitor findByMonitorId(UUID fromString);

    public ExMonitor findListMonitorBySerialNumber(String newSerialNumber);

}

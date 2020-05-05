package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExEventData;
import com.blastvibrations.jpa.orm.ExUser;

public interface ExEventDataDao {

    public List<ExEventData> findAll();

    public List<ExEventData> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExEventData> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExEventData find(final Object exEventDataId);

    public void delete(final Object exEventDataId);

    public void deleteLogical(final ExEventData exEventData);

    public ExEventData persist(final ExEventData exEventData);

    public List<ExEventData> findEventFilterTab(ExUser user,
	    List<UUID> allowedClientList, UUID filterClientId,
	    String filterLocation, String filterUnitSerialNumber,
	    String filterHighlightEventType, String filterStartDate,
	    String filterEndDate, String sort, boolean asc,
	    String filterStartTime, String filterEndTime, int maxRecordResultSet);

    public List<ExEventData> findEventDataByClientIDList(
	    List<UUID> clientIdUUIDList);

    public List<ExEventData> findEventDataByEventDataIdList(
	    List<UUID> eventDataUUIDList, UUID userId);

    public List<ExEventData> findEventDataHavingNoMonitorNoClient();

    public List<ExEventData> findEventDataByClientIDWithEventDateList(
	    List<UUID> clientIdUUIDList);

    public List<ExEventData> findEventDataByBlastReportIdList(
	    List<UUID> selectedBlastReportList);
}

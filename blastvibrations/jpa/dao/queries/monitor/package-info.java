// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = MonitorQueries.MONITOR_FIND_LIST_MONITOR_BY_USERID,
			query = "SELECT m FROM ExMonitor m, ExClientUserMapping cum  WHERE m.deleted = false and  m.clientId = cum.clientId and cum.userId = :userId")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = MonitorQueries.MONITOR_FIND_ALL_ACTIVE_MONITOR,
			query = "select m from ExMonitor m where m.deleted = false and m.unitSerialNumber is not null order by m.unitSerialNumber asc")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = MonitorQueries.FIND_LIST_MONITOR_BY_CLIENTID,
			query = "select m from ExMonitor m where m.clientId = :clientId and  m.deleted = false and m.unitSerialNumber is not null order by m.unitSerialNumber asc")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = MonitorQueries.FIND_UNASSIGNED_MONITOR,
			//			query = "select m from ExMonitor m, ExBlastMonitorMapping map where map.clientId = :clientId and map.monitorId is null and   m.deleted='false' and m.unitSerialNumber is not null order by m.unitSerialNumber asc")
			query = "SELECT m FROM ExMonitor m WHERE m.clientId is null AND m.deleted = false and m.unitSerialNumber is not null order by m.unitSerialNumber")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = MonitorQueries.UNASSIGNED_ALL_MONITORS_FOR_CLIENTID,
			//			query = "select m from ExMonitor m, ExBlastMonitorMapping map where map.clientId = :clientId and map.monitorId is null and   m.deleted='false' and m.unitSerialNumber is not null order by m.unitSerialNumber asc")
			query = "update ExMonitor m set m.clientId = null WHERE m.clientId = :clientId")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = MonitorQueries.FIND_BY_CLIENTID_NOT_DELETED,
			query = "SELECT a FROM ExMonitor a, ExClient  c where a.clientId = c.clientId and a.clientId = :clientId and a.deleted = false ")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = MonitorQueries.FIND_BY_MONITOR_ID,
			query = "SELECT a FROM ExMonitor a where a.monitorId = :monitorId and a.deleted = false ")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = MonitorQueries.FIND_LIST_MONITOR_BY_SERIAL_NUMBER,
			query = "SELECT a FROM ExMonitor a where a.unitSerialNumber = :serialNumber and a.deleted = false ")


})

package com.blastvibrations.jpa.dao.queries.monitor;

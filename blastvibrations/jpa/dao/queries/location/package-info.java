// @formatter:off

@org.hibernate.annotations.NamedQueries({


	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = LocationQueries.FIND_BY_LOCATION_ID,
			query = "SELECT a FROM ExLocation a where a.locationId = :locationId and a.deleted = false ")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = LocationQueries.FIND_LOCATION_LIST_OF_MONITORID,
			query = "SELECT a FROM ExLocation a, ExMonitor m , ExClientUserMapping l"
					+ " where  l.userId = :userId and l.clientId = m.clientId and "
					+ "a.locationId = m.locationId  and  a.deleted = false  and m.deleted = false and l.deleted = false ")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = LocationQueries.FIND_LOCATION_FOR_MONITOR_UUID_LIST,
			query = "SELECT a FROM ExLocation a, ExMonitor m "
					+ " where  m.monitorId in (:monitorUUIDList) "
					+ "and a.locationId = m.locationId  and  a.deleted = false  and m.deleted = false and m.locationId is not null  ")

})

package com.blastvibrations.jpa.dao.queries.location;


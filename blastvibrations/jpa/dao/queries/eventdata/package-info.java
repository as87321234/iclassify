//@formatter:off
@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = EventDataQueries.FIND_EVENT_DATA_BY_USERID, 
	        query = "SELECT e FROM ExEventData e , ExClientUserMapping m where e.clientId = m.clientId and e.deleted = false and m.userId = :userId "),
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = EventDataQueries.FIND_EVENT_DATA_BY_CLIENTID_LIST, 
	        query = "SELECT e FROM ExEventData e  where e.clientId in ( :clientIdUUIDList )  and e.deleted = false  "
		          + "and e.eventDate is not null " + "order by eventDate desc  ")

	,
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = EventDataQueries.FIND_EVENT_DATA_BY_EVENTDATAUUID_LIST, 
	        query = "SELECT e FROM ExEventData e,  ExClientUserMapping m  where e.eventDataId in ( :eventDataUUIDList )  and e.deleted = false  "
		+ " and e.clientId = m.clientId  and m.userId = :userId "
		+ "order by e.eventDate desc  ")

	,
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = EventDataQueries.FIND_EVENT_DATA_BY_EVENTDATAUUID_DATENOTNULL_LIST, 
	        query = "SELECT e FROM ExEventData e where e.eventDataId in ( :eventDataUUIDList )  "
		+ " and e.eventDate is not null "
		+ "order by e.eventDate desc  ")

	,
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = EventDataQueries.FIND_MISSING_EVENT_DATA_NO_MONITOR_NO_CLIENT_LIST, 
	        query = "SELECT e FROM ExEventData e  where e.monitorId is null or e.monitorId = '' or e.clientId is null or e.clientId = '' and e.deleted = false  "
		+ "order by e.eventDate desc  "),
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = EventDataQueries.FIND_EVENT_DATA_BY_BLAST_REPORT_ID_LIST, 
	        query = "SELECT e FROM ExEventData e , ExBlastReportEventdataMapping m " 
	        + "where e.deleted = false and e.eventDataId = m.eventDataId and  "
	        + "m.blastId in ( :blastReportIdList ) "
		+ "order by e.eventDate desc  ")

})
package com.blastvibrations.jpa.dao.queries.eventdata;
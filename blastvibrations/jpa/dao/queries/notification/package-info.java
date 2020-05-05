// @formatter:off


@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
		cacheable = false,
		readOnly = false,
		name = NotificationQueries.FIND_BY_CLIENTID,
		query = "SELECT a FROM ExBlastNotification a, ExClient  c where a.clientId = c.clientId and a.clientId = :clientId and a.deleted = false   ")
,
@org.hibernate.annotations.NamedQuery(
	cacheable = false,
	readOnly = false,
	name = NotificationQueries.FIND_BY_CONTACTID,
	query = "SELECT a FROM ExBlastNotification a  where a.blastContactId = :blastContactId and ( a.deleted = false or a.deleted = :isDeleted )  ")
,
	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = NotificationQueries.FIND_BY_USERID_BLASTCOMPLAINTID_CONTACTID,
			query = "SELECT a FROM ExBlastNotification a, ExClientUserMapping m  where m.userId = :userId and m.clientId = :clientId and "
					+ " a.blastComplaintId = :blastComplaintId and a.blastContactId = :blastContactId and a.clientId = m.clientId  and a.deleted = false ")
	,
	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = NotificationQueries.FIND_BY_USERID_CONTACTID,
			query = "SELECT a FROM ExBlastNotification a, ExClientUserMapping m  where m.userId = :userId and m.clientId = a.clientId and "
					+ " a.blastContactId = :blastContactId and a.clientId = m.clientId  and a.deleted = false ")
	,
	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = NotificationQueries.FIND_BY_USERID_BLASTCOMPLAINTID,
			query = "SELECT a FROM ExBlastNotification a, ExClientUserMapping m  where m.userId = :userId and m.clientId = a.clientId and "
					+ " a.blastComplaintId = :blastComplaintId  and a.clientId = m.clientId  and a.deleted = false ")
	,
	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = NotificationQueries.FIND_BY_CLIENTUUIDLIST,
			query = "SELECT distinct a FROM ExBlastNotification a, ExClientUserMapping m  where  a.clientId = m.clientId "
					+ "and m.clientId in (:clientUUIDList)  "
					+ "and a.deleted = false order by a.created")
})

package com.blastvibrations.jpa.dao.queries.notification;
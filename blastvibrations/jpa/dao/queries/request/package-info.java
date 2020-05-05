// @formatter:off


@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = RequestQueries.FIND_BY_CLIENTID,
			query = "SELECT a FROM ExBlastRequest a, ExClient  c where a.clientId = c.clientId and a.clientId = :clientId  and a.deleted = false  order by lower (a.name) ")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = RequestQueries.FIND_BY_SHAREID,
			query = "SELECT a FROM ExBlastRequest a where a.shareId = :shareId")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = RequestQueries.FIND_BLASTREQUESTS_FOR_USER_CLIENTLIST,
			query = "SELECT a FROM ExBlastRequest a, ExClientUserMapping m  where a.clientId = m.clientId and m.userId = :userId  and ( a.deleted = false or a.deleted = :deleted ) order by   lower (a.name)   ")
	

	,
	

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = com.blastvibrations.jpa.dao.queries.request.RequestQueries.FIND_BLAST_REQUESTS_FOR_USER_BETWEEN_START_AND_END_DATE,
			query =
			"SELECT r FROM ExBlastRequest r, ExClientUserMapping m  "
					+ "where r.clientId = m.clientId and m.userId = :userId "
					// TODO:  The condition seems wrong Andre changed it to use only the start date
					//  also noted that the end date is all null pass 2014.
					//					+ "and r.startDate >= :startDate and r.endDate <= :endDate "
					+ "and r.startDate >= :startDate and r.startDate <= :endDate "
					+ "and r.deleted = false order by r.startDate desc ")
	,
	

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = com.blastvibrations.jpa.dao.queries.request.RequestQueries.FIND_ACTIVE_BLAST_REQUESTS_FOR_LOCATION_AND_DATE,
			query =	
			"SELECT r FROM ExBlastRequest r  "
					+ " where r.status = 'OPEN'  "
					+ " and  :eventDate  >= r.startDate "
					+ " and  :eventDate  <=  r.endDate  "
					+ " and r.clientId =  :clientId ")

})

package com.blastvibrations.jpa.dao.queries.request;


// @formatter:off

@org.hibernate.annotations.NamedQueries({


	@org.hibernate.annotations.NamedQuery( 
			cacheable = false,
			readOnly = false,
			name = BlastComplaintQueries.FIND_BY_CONTACTID,
			query = "SELECT c FROM ExBlastComplaint c where c.blastContactId  = :blastContactId and  ( c.deleted=:deleted or c.deleted= false) order by lower(c.clientName) asc ")

	,
	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = BlastComplaintQueries.FIND_BLASTCOMPLAINTS_FOR_USER_CLIENTLIST,
			query = "SELECT a FROM ExBlastComplaint a, ExClientUserMapping m  where a.clientId = m.clientId and m.userId = :userId  and ( a.deleted = false or a.deleted = :deleted)  ")



})

package com.blastvibrations.jpa.dao.queries.blastcomplaints;







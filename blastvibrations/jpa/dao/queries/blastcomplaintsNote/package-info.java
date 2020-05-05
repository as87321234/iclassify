// @formatter:off

@org.hibernate.annotations.NamedQueries({


	@org.hibernate.annotations.NamedQuery( 
			cacheable = false,
			readOnly = false,
			name = BlastComplaintNoteQueries.FIND_BLASTCOMPLAINTSNOTE_FOR_COMPLAINTID,
			query = "SELECT n FROM ExBlastComplaintNote n where n.blastComplaintId  = :blastComplaintId and  ( n.deleted=:deleted or n.deleted= false) order by n.noteDate desc ")
	,
	@org.hibernate.annotations.NamedQuery(
		cacheable = false,
		readOnly = false,
		name = BlastComplaintNoteQueries.FIND_BLASTCOMPLAINTNOTES_FOR_USER_CLIENTLIST,
		query = "SELECT cn FROM ExBlastComplaintNote cn, ExBlastComplaint a, ExClientUserMapping m  where a.clientId = m.clientId and cn.blastComplaintId = a.blastComplaintId and m.userId = :userId  and ( a.deleted = false or a.deleted = :deleted)  ")

	


})

package com.blastvibrations.jpa.dao.queries.blastcomplaintsNote;









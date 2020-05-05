// @formatter:off

@org.hibernate.annotations.NamedQueries({


	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = com.blastvibrations.jpa.dao.queries.blastcontacts.BlastContactQueries.FIND_FOR_CONTACT_ID_LIST,
			query = "SELECT c FROM ExBlastContact  c where c.blastContactId in (:contactIdList) and c.deleted = false ")


})

package com.blastvibrations.jpa.dao.queries.blastcontacts;








// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = BlastAttachmentQueries.FIND_BLAST_ATTACHMENT_NOT_DELETED,
			query = "SELECT br FROM ExBlastAttachment br  "
					+ "WHERE br.blastId = :blastId and br.deleted = false" )
})

package com.blastvibrations.jpa.dao.queries.blastattachment;
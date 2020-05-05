// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = BlastMonitorMappingQueries.BLASTMONITOMAPPING_FIND_LIST_NOT_DELETED,
			query = "SELECT e FROM ExBlastMonitorMapping e  "
					+ "WHERE e.deleted = false and "
					+ "      e.blastId = :blastId")


})

package com.blastvibrations.jpa.dao.queries.blastmonitormapping;
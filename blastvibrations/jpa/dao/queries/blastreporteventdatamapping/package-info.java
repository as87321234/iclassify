// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = BlastReportEventdataMappingQueries.BLASTREPORT_FIND_BLASTREPORTEVENTMAPPING_WITH_DELETED_RECORD, query = "SELECT e FROM ExBlastReportEventdataMapping e "
		+ "WHERE  e.blastId = :blastId and e.eventDataId = :eventDataId "),

	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = BlastReportEventdataMappingQueries.BLASTREPORT_FINDALL_BYBLASTID, query = "SELECT e FROM ExBlastReportEventdataMapping e "
		+ "WHERE e.deleted = false and e.blastId = :blastId ") })
package com.blastvibrations.jpa.dao.queries.blastreporteventdatamapping;
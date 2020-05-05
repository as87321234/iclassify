// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = BlastReportQueries.BLASTREPORT_FIND_LIST_BLAST_REPORT_BY_USERID,
			query = "SELECT br FROM ExBlastReport br, ExClientUserMapping cum  "
					+ "WHERE br.deleted = false and (br.isTemplate != true or br.isTemplate is null ) and br.startDate is not null "
					+ "and br.clientId = cum.clientId and cum.userId = :userId")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = BlastReportQueries.BLASTREPORT_FIND_LIST_BLAST_REPORT_TEMPLATE_BY_CLIENT_ID,
			query = "SELECT br FROM ExBlastReport br, ExClient c  "
					+ "WHERE br.deleted = false and br.isTemplate = true "
					+ "and br.clientId = c.clientId and br.clientId = :clientId" )
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = BlastReportQueries.FIND_BLAST_REPORTS_FOR_USER_BETWEEN_START_AND_END_DATE,
			query =
			"SELECT r FROM ExBlastReport r, ExClientUserMapping m  "
					+ "where r.clientId = m.clientId and m.userId = :userId "
					// TODO:  The condition seems wrong Andre changed it to use only the start date
					//  also noted that the end date is all null pass 2014.
					//					+ "and r.startDate >= :startDate and r.endDate <= :endDate "
					+ "and r.startDate >= :startDate and r.startDate <= :endDate "
					+ "and  ( r.isTemplate = false or r.isTemplate is null) "
					+ "and r.deleted = false order by r.startDate desc ")



	//	final StringBuffer exSQL = new StringBuffer();
	//	exSQL.append("SELECT * FROM ExBlastReport WHERE clientId IN ("
	//			+ getClientIdSQLInClause(userId)
	//			+ ") AND deleted != 'true' AND (isTemplate != 'true' or isTemplate is null ) AND start is not null");
	//
	//	if (clientId != null) {
	//		exSQL.append(" AND clientId = '" + clientId + "' ");
	//		maxPredicatesIncludingPredicates = maxPredicatesIncludingPredicates - 1;
	//	}
	//
	//	if (start != null && end != null) {
	//		exSQL.append(" AND start >= '" + start + "' AND end <= '" + end
	//				+ "'");
	//		maxPredicatesIncludingPredicates = maxPredicatesIncludingPredicates - 2;
	//	}
	//	exSQL.append(" ORDER BY start DESC");

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = BlastReportQueries.FIND_BLAST_REPORTS_NOT_DELETED,
			query = "SELECT br FROM ExBlastReport br  "
					+ "WHERE br.deleted = false" )

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = BlastReportQueries.FIND_BLAST_REPORTS_BY_BLASTIDS_LIST_NOT_DELETED,
			query = "SELECT t FROM ExBlastReport t where t.blastId in :blastIdList and " +
					" t.deleted = false and " +
					" t.startDate is not null " +
			" order by t.startDate desc")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = BlastReportQueries.FIND_BLAST_REPORTS_NOTEMPLATE_BY_CLIENTIDS_LIST_BETWEEN_START_AND_END_DATE,
			query = "SELECT t FROM ExBlastReport t where t.clientId in :clientIdList and " +
					" t.deleted = false and " +
					" t.isTemplate = false and " +
					" t.startDate is not null and " +
					" t.startDate >= :startDate and t.startDate <= :endDate " +
			" order by t.startDate desc")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = BlastReportQueries.FIND_BLAST_REPORTS_NOTEMPLATE_BY_CLIENTIDS_LIST_NOT_DELETED,
			query = "SELECT t FROM ExBlastReport t where t.clientId in :clientIdList and " +
					" t.deleted = false and " +
					" t.isTemplate = false and " +
					" t.startDate is not null " +
			" order by t.startDate desc")
})

package com.blastvibrations.jpa.dao.queries.blastreport;







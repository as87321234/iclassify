// @formatter:off


@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = MonitorMappingQueries.FIND_BY_CLIENTID,
			query = "SELECT a FROM ExBlastMonitorMapping a, ExClient  c where a.clientId = c.clientId and a.clientId = :clientId  ")

})

package com.blastvibrations.jpa.dao.queries.monitormapping;
// @formatter:off


@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = RegressionDataQueries.FIND_BY_CLIENTID,
			query = "SELECT a FROM ExRegressionData a, ExClient  c where a.clientId = c.clientId and a.clientId = :clientId  ")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = RegressionDataQueries.FIND_BY_CLIENT_AND_USER_ID,
			query = "SELECT a FROM ExRegressionData a, ExClient  c where a.clientId = c.clientId and a.clientId = :clientId and a.userId = :userId  and a.deleted = false ")

})

package com.blastvibrations.jpa.dao.queries.regressiondata;
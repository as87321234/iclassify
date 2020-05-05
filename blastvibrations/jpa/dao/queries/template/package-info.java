// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = TemplateQueries.MONITOR_FIND_TEMPLATE_FOR_USER,
			query = "SELECT t FROM ExTemplate t where userId in (:userId) and t.deleted = 'false' and t.templateName is not null order by t.templateName asc")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = TemplateQueries.FIND_BY_CLIENTID,
			query = "SELECT a FROM ExTemplate a, ExClient  c where a.clientId = c.clientId and a.clientId = :clientId  ")

})

package com.blastvibrations.jpa.dao.queries.template;




//String exSQL = "SELECT * FROM ExTemplate WHERE clientId IN ("
//		+ getClientIdSQLInClause(user)
//		+ ") AND deleted='false' and templateName is not null order by templateName asc";
//List<String> listSplitSQLInExpression = ExpressionParser
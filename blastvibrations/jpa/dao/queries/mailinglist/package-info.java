// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = MailinglistQueries.MAILING_FIND_MAILING_LIST_FOR_USER,
			query = "SELECT m FROM ExMailingList m where m.userId in (:userId) and m.deleted = 'false' and m.mailingListName is not null order by lower ( m.mailingListName ) asc")


})

package com.blastvibrations.jpa.dao.queries.mailinglist;



//String exSQL = "SELECT * from ExMailingList WHERE clientId IN ("
//		+ getClientIdSQLInClause(user)
//		+ ") AND deleted='false' and mailingListName is not null order by mailingListName asc";
//List<String> listSplitSQLInExpression = ExpressionParser
//		.splitSQLInClause(exSQL,
//				MAX_NUMBER_OF_PREDICATE_VALUES_PER_IN_CLAUSE);
//
//XMailingList[] mailingLists = new XMailingList[0];
//for (String expression : listSplitSQLInExpression) {
//	XMailingList[] result = SelectQuery.query(expression,
//			XMailingList.class).toArray(new XMailingList[0]);
//	mailingLists = XUtils.concat(mailingLists, result);





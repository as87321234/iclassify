// @formatter:off
@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = UserQueries.USER_FINDUSERNAME,
			query = "SELECT a FROM ExUser a WHERE lower(a.username) = lower(:username)")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = UserQueries.USER_FINDLOGINUSERNAME,
			query = "SELECT a FROM ExUser a WHERE lower(a.username) = lower(:username) and a.deleted = false and a.enabled = true")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = UserQueries.USER_FIND_WHERE_USERNAME_NOTNULL_ORDER_ASCENDING,
			query = "SELECT a FROM ExUser a WHERE a.deleted=false and a.username is not null order by lower( a.fullName ) asc")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = UserQueries.USER_FIND_FIND_USERID_FOR_GIVEN_LIST_OF_CLIENT,
			query = "SELECT a FROM ExUser a, ExClientUserMapping cum where  a.deleted = false and a.userId = cum.userId  and cum.clientId in (:activeClientList) ")


	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = UserQueries.FIND_LIST_USER_BY_CLIENTID,
			query = "SELECT  a FROM ExUser a, ExClientUserMapping cum where a.deleted = false and a.userId = cum.userId  and cum.clientId = :clientId  order by lower( a.fullName ) asc ")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = UserQueries.FIND_LIST_UNASSINGED_FOR_CLIENT_ID,
			query =
			"SELECT a FROM ExUser a left join  ExClientUserMapping cum  on a.userId = cum.userId where cum.clientId = :clientId and cum.userId is null and a.deleted = false order by a.fullName asc  ")

})

package com.blastvibrations.jpa.dao.queries.user;
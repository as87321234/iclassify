// @formatter:off
@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = ClientUserMappingQueries.CLIENTUSERMAPPING_FIND_FIND_USERID_FOR_GIVEN_LIST_OF_CLIENT,
			query = "SELECT  cum FROM  ExClientUserMapping cum where cum.clientId in (:activeClientList)  ")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = ClientUserMappingQueries.DELETE_PHYSICAL_FOR_USERID,
			query = "DELETE from ExClientUserMapping cum where  cum.userId = :userId ")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = ClientUserMappingQueries.DELETE_LOGICAL_FOR_USERID,
			query = "update from ExClientUserMapping cum set deleted='true', modified = now(), lastModifiedByUserId=:logonUserId, lastModifiedByUser=:logonUsername  where  cum.userId = :userId ")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = ClientUserMappingQueries.FIND_CLIENT_USER_MAPPING_FOR_USER_ID,
			query = "select cum from ExClientUserMapping cum where  cum.userId = :userId  and deleted = 'false' ")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = ClientUserMappingQueries.DELETE_PHYSICAL_FOR_CLIENTID_USERID,
			query = "DELETE from ExClientUserMapping cum where  cum.clientId = :clientId and cum.userId = :userId ")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = ClientUserMappingQueries.DELETE_PHYSICAL_FOR_CLIENTID,
			query = "DELETE from ExClientUserMapping cum where  cum.clientId = :clientId  ")



})

package com.blastvibrations.jpa.dao.queries.clientusermapping;

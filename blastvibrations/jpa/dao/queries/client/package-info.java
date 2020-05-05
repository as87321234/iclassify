//@formatter:off
@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = ClientQueries.CLIENT_FIND_BY_USER_ID,
			query = "SELECT c FROM ExClient c, ExClientUserMapping m where c.clientId = m.clientId and m.userId  = :userId and c.deleted=false order by lower(c.name) asc ")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = ClientQueries.CLIENT_FIND_BY_CLIENT_ID,
			query = "SELECT c FROM ExClient c where c.clientId = :clientId and c.deleted=false ")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = ClientQueries.FIND_ALL_ACTIVE_CLIENTS,
			query = "SELECT c FROM ExClient c where c.deleted = 'false' and c.name is not null order by lower(c.name) asc ")
})

package com.blastvibrations.jpa.dao.queries.client;


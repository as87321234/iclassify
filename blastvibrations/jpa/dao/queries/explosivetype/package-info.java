// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = ExplosiveTypeQueries.EXPLOSIVETYPE_FIND_ALL_EXPLOSIVE_TYPE,
			query = "SELECT e FROM ExExplosiveType e "
					+ "WHERE e.deleted = false and e.explosiveTypeName is not null order by e.explosiveTypeName asc")

})

package com.blastvibrations.jpa.dao.queries.explosivetype;


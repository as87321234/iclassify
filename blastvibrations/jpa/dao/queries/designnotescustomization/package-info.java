// @formatter:off

@org.hibernate.annotations.NamedQueries({

		@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = DesignNotesCustomizationQueries.FIND_CUSTOMIZATION_BY_CLIENTID, query = "SELECT a FROM ExDesignNotesCustomization a  where  a.clientId = :clientId and deleted=false "),
		@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = DesignNotesCustomizationQueries.FIND_CUSTOMIZATION_BY_CLIENTLIST, query = "SELECT a FROM ExDesignNotesCustomization a  where  a.clientId in ( :clientIdUUIDList )  and deleted=false ")

})
package com.blastvibrations.jpa.dao.queries.designnotescustomization;
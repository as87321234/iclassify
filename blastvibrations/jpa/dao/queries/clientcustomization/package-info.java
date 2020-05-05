// @formatter:off
@org.hibernate.annotations.NamedQueries({

		@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = ClientCustomizationQueries.FIND_CLIENT_HAS_CUSTOMIZATION_BY_CLIENTID, query = "SELECT a FROM ExClientCustomization a  where  a.clientId = :clientId  and a.deleted =false "),
		@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = ClientCustomizationQueries.FIND_CLIENT_HAS_CUSTOMIZATION_FOR_CLIENTLIST, query = "SELECT a FROM ExClientCustomization a  where a.clientId in ( :clientIdUUIDList )  and a.deleted =false ")

})
package com.blastvibrations.jpa.dao.queries.clientcustomization;


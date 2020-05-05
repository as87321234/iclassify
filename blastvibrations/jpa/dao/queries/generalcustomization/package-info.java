// @formatter:off

@org.hibernate.annotations.NamedQueries({

		@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = GeneralCustomizationQueries.GENERALCUSTOMIZATION_FIND_ALL_GENERAL_CUSTOMIZATION, query = "select a from ExGeneralCustomization a "),
		@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = GeneralCustomizationQueries.FIND_CUSTOMIZATION_BY_CLIENTID, query = "SELECT a FROM ExGeneralCustomization a where a.clientId = :clientId  and a.deleted = false"),
		@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = GeneralCustomizationQueries.FIND_CUSTOMIZATION_FOR_CLIENTLIST, query = "SELECT a FROM ExGeneralCustomization a where a.clientId in ( :clientIdUUIDList )  and a.deleted = false")

})
package com.blastvibrations.jpa.dao.queries.generalcustomization;


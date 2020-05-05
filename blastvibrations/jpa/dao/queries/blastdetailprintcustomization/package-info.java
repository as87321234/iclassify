// @formatter:off

@org.hibernate.annotations.NamedQueries({

		@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = BlastDetailPrintCustomizationQueries.FIND_BY_CLIENT_ID, query = "Select c from ExBlastDetailPrintCustomization c where clientId = :clientId "
				+ " and deleted = false "),
		@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = BlastDetailPrintCustomizationQueries.FIND_FOR_CLIENT_LIST, query = "Select c from ExBlastDetailPrintCustomization c where c.clientId in ( :clientIdUUIDList )  "
				+ " and deleted = false ") })
package com.blastvibrations.jpa.dao.queries.blastdetailprintcustomization;


// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = NotificationTemplateQueries.FIND_BY_CLIENTID, query = "SELECT a FROM ExBlastNotificationTemplate a, ExClient  c where a.clientId = c.clientId and a.clientId = :clientId  and a.deleted = false "),
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = NotificationTemplateQueries.FIND_BLAST_NOTIFICATION_TEMPLATE_BY_USERID, query = "SELECT a FROM ExBlastNotificationTemplate a, ExClientUserMapping  m where m.userId = :userId and a.clientId = m.clientId and ( a.deleted = false or a.deleted = :deleted ) ")

	,
	@org.hibernate.annotations.NamedQuery(cacheable = false, readOnly = false, name = NotificationTemplateQueries.FIND_BLAST_NOTIFICATION_TEMPLATE_BY_USERID_BY_CLIENTID, query = "SELECT a FROM ExBlastNotificationTemplate a, ExClientUserMapping  m "
		+ "where m.userId = :userId and a.clientId = :clientId and "
		+ "a.clientId = m.clientId and  ( a.deleted = false or a.deleted = :deleted )  and m.deleted = false   ")

})
package com.blastvibrations.jpa.dao.queries.notificationtemplate;
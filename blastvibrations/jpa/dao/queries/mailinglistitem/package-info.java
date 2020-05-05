// @formatter:off

@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = MailinglistItemQueries.FIND_MAILINGLISTITEM_FOR_MAILINGLISTID,
			query = "SELECT l FROM ExMailingListItem l where l.mailingListId = :mailingListId order by l.emailAddress asc")
	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = MailinglistItemQueries.DELETE_PHYSICAL_FOR_MAILINGLISTID,
			query = "delete from  ExMailingListItem l where l.mailingListId = :mailingListId ")

	,

	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name  = MailinglistItemQueries.DELETE_LOGICAL_FOR_MAILINGLISTID,
			query = "update ExMailingListItem l set l.enabled = false, l.deleted = true,   modified = now(), lastModifiedByUserId=:logonUserId, lastModifiedByUser=:logonUsername  where l.mailingListId = :mailingListId ")

})

package com.blastvibrations.jpa.dao.queries.mailinglistitem;



package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastNotificationTemplate;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastNotificationTemplateDao {

    public List<ExBlastNotificationTemplate> findAll();

    public List<ExBlastNotificationTemplate> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastNotificationTemplate> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExBlastNotificationTemplate find(
	    final Object exBlastNotificationTemplateId);

    public void delete(final Object exBlastNotificationTemplateId);

    public void deleteLogical(
	    final ExBlastNotificationTemplate exBlastNotificationTemplate);

    public ExBlastNotificationTemplate persist(
	    final ExBlastNotificationTemplate exBlastNotificationTemplate);

    public List<ExBlastNotificationTemplate> findBlastNotificationTemplateByClientId(
	    UUID clientId);

    public List<ExBlastNotificationTemplate> findBlastNotificationTemplatesByUserId(
	    UUID userId, boolean isDeleted);

    public List<ExBlastNotificationTemplate> findBlsatNotificationTemplatesByUserIdClientId(
	    UUID userId, UUID fromString, boolean isDeleted);

    public List<ExBlastNotificationTemplate> findBlsatNotificationTemplatesByUserIdClientId(
	    UUID userId, UUID fromString);
}

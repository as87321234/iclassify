package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExTemplate;

public interface ExTemplateDao {

    public List<ExTemplate> findAll();

    public List<ExTemplate> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExTemplate> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExTemplate find(final Object exTemplateId);

    public void delete(final Object exTemplateId);

    public void deleteLogical(final ExTemplate exTemplate);

    public ExTemplate persist(final ExTemplate exTemplate);

    public List<ExTemplate> findTemplatesForUser(final UUID userId);

    public List<ExTemplate> findTemplateByClientId(UUID clientId);

}

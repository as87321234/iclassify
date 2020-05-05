package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExDesignNotesCustomization;

public interface ExDesignNotesCustomizationDao {

    public List<ExDesignNotesCustomization> findAll();

    public List<ExDesignNotesCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExDesignNotesCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExDesignNotesCustomization find(
	    final Object exDesignNotesCustomizationId);

    public void delete(final Object exDesignNotesCustomizationId);

    public void deleteLogical(
	    final ExDesignNotesCustomization exDesignNotesCustomization);

    public ExDesignNotesCustomization persist(
	    final ExDesignNotesCustomization exDesignNotesCustomization);

    public ExDesignNotesCustomization findCustomizationByClientId(UUID clientId);

    public List<ExDesignNotesCustomization> findForClientList(
	    List<UUID> clientList);

    public List<ExDesignNotesCustomization> findForClientList(
	    String[] clientIdList);
}

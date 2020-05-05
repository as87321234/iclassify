package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExClientCustomization;

public interface ExClientCustomizationDao {

    public List<ExClientCustomization> findAll();

    public List<ExClientCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExClientCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExClientCustomization find(final Object exClientCustomizationId);

    public void delete(final Object exClientCustomizationId);

    public void deleteLogical(final ExClientCustomization exClientCustomization);

    public ExClientCustomization persist(
	    final ExClientCustomization exClientCustomization);

    public ExClientCustomization findCustomizationByClientId(UUID clientId);

    public List<ExClientCustomization> findForClientList(List<UUID> clientList);

    public List<ExClientCustomization> findForClientList(String[] clientIdList);

}

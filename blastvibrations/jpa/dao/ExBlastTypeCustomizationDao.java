package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastTypeCustomization;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastTypeCustomizationDao {

    public List<ExBlastTypeCustomization> findAll();

    public List<ExBlastTypeCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastTypeCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExBlastTypeCustomization find(final Object exBlastTypeCustomizationId);

    public void delete(final Object exBlastTypeCustomizationId);

    public void deleteLogical(
	    final ExBlastTypeCustomization exBlastTypeCustomization);

    public ExBlastTypeCustomization persist(
	    final ExBlastTypeCustomization exBlastTypeCustomization);

    public ExBlastTypeCustomization findCustomizationByClientId(UUID clientId);

    public List<ExBlastTypeCustomization> findForClientList(
	    List<UUID> clientList);

    public List<ExBlastTypeCustomization> findForClientList(
	    String[] clientIdList);
}

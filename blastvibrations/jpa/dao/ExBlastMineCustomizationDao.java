package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastMineCustomization;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastMineCustomizationDao {

    public List<ExBlastMineCustomization> findAll();

    public List<ExBlastMineCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastMineCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecord);

    public ExBlastMineCustomization find(final Object exBlastMineCustomizationId);

    public void delete(final Object exBlastMineCustomizationId);

    public void deleteLogical(
	    final ExBlastMineCustomization exBlastMineCustomization);

    public ExBlastMineCustomization persist(
	    final ExBlastMineCustomization exBlastMineCustomization);

    public ExBlastMineCustomization findCustomizationByClientId(UUID clientId);

    public List<ExBlastMineCustomization> findForClientList(
	    List<UUID> clientList);

    public List<ExBlastMineCustomization> findForClientList(
	    String[] clientIdList);
}

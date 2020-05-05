package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExGeneralCustomization;

public interface ExGeneralCustomizationDao {

    public List<ExGeneralCustomization> findAll();

    public List<ExGeneralCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExGeneralCustomization> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExGeneralCustomization find(final Object exGeneralCustomizationId);

    public void delete(final Object exGeneralCustomizationId);

    public void deleteLogical(
	    final ExGeneralCustomization exGeneralCustomization);

    public ExGeneralCustomization persist(
	    final ExGeneralCustomization exGeneralCustomization);

    public List<ExGeneralCustomization> findAllGeneralCustomization();

    public ExGeneralCustomization findCustomizationByClientId(UUID clientId);

    public List<ExGeneralCustomization> findForClientList(List<UUID> clientList);

    public List<ExGeneralCustomization> findForClientList(String[] clientIdList);

}

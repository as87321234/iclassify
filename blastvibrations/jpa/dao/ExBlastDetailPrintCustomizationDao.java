package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastDetailPrintCustomization;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastDetailPrintCustomizationDao {

    public List<ExBlastDetailPrintCustomization> findAll();

    public List<ExBlastDetailPrintCustomization> tableSorting(
	    List<ExClient> list, final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastDetailPrintCustomization> tableSorting(
	    List<ExClient> list, final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExBlastDetailPrintCustomization find(
	    final Object exBlastDetailPrintCustomizationId);

    public void delete(final Object exBlastDetailPrintCustomizationId);

    public void deleteLogical(
	    final ExBlastDetailPrintCustomization exBlastDetailPrintCustomization);

    public ExBlastDetailPrintCustomization persist(
	    final ExBlastDetailPrintCustomization exBlastDetailPrintCustomization);

    public ExBlastDetailPrintCustomization findByClientId(UUID clientId);

    public List<ExBlastDetailPrintCustomization> findForClientList(
	    List<UUID> clientList);

    public List<ExBlastDetailPrintCustomization> findForClientList(
	    String[] clientIdList);

}

package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastInformationCustomization;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastInformationCustomizationDao {

    public List<ExBlastInformationCustomization> findAll();

    public List<ExBlastInformationCustomization> tableSorting(
	    List<ExClient> list, final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastInformationCustomization> tableSorting(
	    List<ExClient> list, final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecord);

    public ExBlastInformationCustomization find(
	    final Object exBlastInformationCustomizationId);

    public void delete(final Object exBlastInformationCustomizationId);

    public void deleteLogical(
	    final ExBlastInformationCustomization exBlastInformationCustomization);

    public ExBlastInformationCustomization persist(
	    final ExBlastInformationCustomization exBlastInformationCustomization);

    public ExBlastInformationCustomization findCustomizationByClientId(
	    UUID clientId);

    List<ExBlastInformationCustomization> findForClientList(
	    List<UUID> clientList);

    public List<ExBlastInformationCustomization> findForClientList(
	    String[] clientIdList);
}

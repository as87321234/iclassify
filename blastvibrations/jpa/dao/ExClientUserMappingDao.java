package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExClientUserMapping;
import com.blastvibrations.jpa.orm.ExUser;

public interface ExClientUserMappingDao {

    public List<ExClientUserMapping> findAll();

    public List<ExClientUserMapping> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExClientUserMapping> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExClientUserMapping find(final Object exClientUserMappingId);

    public void delete(final Object exClientUserMappingId);

    public void deleteLogical(final ExClientUserMapping exClientUserMapping);

    public ExClientUserMapping persist(
	    final ExClientUserMapping exClientUserMapping);

    public List<ExClientUserMapping> findClientUserMappingforGivenListOfClient(
	    List<UUID> clientList);

    public void deletePhysicalForUserId(UUID userId);

    public void deleteLogicalForUserId(UUID userId, ExUser logonUser);

    public List<ExClientUserMapping> findClientUserMappingForUserID(
	    ExUser exUser);

    public void deletePhysicalForClientIdUserId(UUID userId, UUID clientId);

    public void deletePhysicalForClientId(UUID clientId);

}

package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExUser;

public interface ExClientDao {

    public List<ExClient> findAll();

    public List<ExClient> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExClient> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExClient find(final Object exClientId);

    public void delete(final Object exClientId);

    public void deleteLogical(final ExClient exClient);

    public ExClient persist(final ExClient exClient);

    public List<ExClient> findAllClientsForUserId(UUID userId);

    public ExClient findByClientId(final UUID clientId);

    List<ExClient> findAllActiveClients();

    void deleteLogicalClientRelatedTables(UUID clientId, ExUser exUser);

}

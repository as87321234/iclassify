package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExMailingList;

public interface ExMailingListDao {

    public List<ExMailingList> findAll();

    public List<ExMailingList> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExMailingList> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExMailingList find(final Object exMailingListId);

    public void delete(final Object exMailingListId);

    public void deleteLogical(final ExMailingList exMailingList);

    public ExMailingList persist(final ExMailingList exMailingList);

    public List<ExMailingList> findMailingListForUser(final UUID userId);

}

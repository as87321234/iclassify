package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExMailingListItem;

public interface ExMailingListItemDao {

    public List<ExMailingListItem> findAll();

    public List<ExMailingListItem> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExMailingListItem> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExMailingListItem find(final Object exMailingListItemId);

    public void delete(final Object exMailingListItemId);

    public ExMailingListItem persist(final ExMailingListItem exMailingListItem);

    public void deleteLogical(final ExMailingListItem exMailingListItem);

    public List<ExMailingListItem> findMailingListItemForMailingListId(
	    UUID mailingListId);

    public void deletePhysicalForMailingListId(UUID mailingListId);

    public void deleteLogicalForMailingListId(UUID mailingListId,
	    UUID logonUserId, String logonUsername);

}

package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastContact;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastContactDao {

    public List<ExBlastContact> findAll();

    public List<ExBlastContact> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastContact> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExBlastContact find(final Object exBlastContactId);

    public void delete(final Object exBlastContact);

    public void deleteLogical(final ExBlastContact exBlastAttachment);

    public ExBlastContact persist(final ExBlastContact exBlastAttachment);

    public List<ExBlastContact> findBlastContactsForClientId(UUID userId,
	    UUID clientId);

    public List<ExBlastContact> findBlastContactsForUserId(UUID userId);

    public List<ExBlastContact> findBlastContactsForContactIdList(
	    List<String> recipientContactIds);

}

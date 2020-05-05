package com.blastvibrations.jpa.dao;

import java.util.List;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExSystemMessage;

public interface ExSystemMessageDao {

    public List<ExSystemMessage> findAll();

    public List<ExSystemMessage> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExSystemMessage> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExSystemMessage find(final Object exSystemMessageId);

    public void delete(final Object exSystemMessageId);

    public void deleteLogical(final ExSystemMessage exSystemMessage);

    public ExSystemMessage persist(final ExSystemMessage exSystemMessage);

}

package com.blastvibrations.jpa.dao;

import java.util.List;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExEventDataFact;

public interface ExEventDataFactDao {

    public List<ExEventDataFact> findAll();

    public List<ExEventDataFact> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExEventDataFact> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExEventDataFact find(final Object exEventDataId);

    public void delete(final Object exEventDataId);

    public void deleteLogical(final ExEventDataFact exEventData);

    public ExEventDataFact persist(final ExEventDataFact exEventData);

    public void materializedView();

}

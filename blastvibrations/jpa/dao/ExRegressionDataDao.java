package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExRegressionData;

public interface ExRegressionDataDao {

    public List<ExRegressionData> findAll();

    public List<ExRegressionData> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExRegressionData> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExRegressionData find(final Object exRegressionDataId);

    public void delete(final Object exRegressionDataId);

    public void deleteLogical(final ExRegressionData exRegressionData);

    public ExRegressionData persist(final ExRegressionData exRegressionData);

    public List<ExRegressionData> findRegressionDataByClientId(UUID clientId);

    public List<ExRegressionData> findRegressionDataByClientAndUserId(
	    UUID clientId, UUID userId);

}

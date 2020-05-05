package com.blastvibrations.jpa.dao;

import java.util.List;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExExplosiveType;

public interface ExExplosiveTypeDao {

    public List<ExExplosiveType> findAll();

    public List<ExExplosiveType> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExExplosiveType> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExExplosiveType find(final Object exExplosiveTypeId);

    public void delete(final Object exExplosiveTypeId);

    public void deleteLogical(final ExExplosiveType exExplosiveType);

    public ExExplosiveType persist(final ExExplosiveType exExplosiveType);

    public List<ExExplosiveType> findAllExplosiveTypes();

}

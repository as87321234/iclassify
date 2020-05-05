/**
 * This class is ...
 *
 * <P>
 *     ______      ______             _____________________  ___
 * ________  /_________  /_______      ___  __ \__  __/__   |/  /
 * _  _ \_  __ \  _ \_  //_/  __ \     __  /_/ /_  /  __  /|_/ /
 * /  __/  /_/ /  __/  ,<  / /_/ /     _  ____/_  /   _  /  / /
 * \___//_.___/\___//_/|_| \____/      /_/     /_/    /_/  /_/
 *
 * <P>
 *
 * @SINCE 1.0
 * @AUTHOR RCARON
 * @VERSION 1.0
 */
package com.pointtomap.iclassify.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface GenericDao<T> {

	/**
	 * Method that returns the number of entries from a table that meet some
	 * criteria (where clause params)
	 *
	 * @param params sql parameters
	 * @return the number of records meeting the criteria
	 */
	// long countAll(Map<String, Object> params);
	long countAll();

	T persist(T t);

	void delete(Object id);

	void deleteLogical(T t);

	T find(Object id);

	List<T> findAll();

//    List<T> tableSorting(List<ExClient> list,
//	    final SQLClause[] whereClauseList,
//	    final OrderByClause[] orderByList, final int maxResultSet);
//
//    List<T> tableSorting(List<ExClient> list,
//	    final SQLClause[] whereClauseList,
//	    final OrderByClause[] orderByList, final int maxResultSet,
//	    final boolean includeDeletedRecords);

	EntityManager getEntityManager();

	Query getEntityManagerNamedQuery(final String namedQuery);

	Query getEntityManagerNamedQuery(String namedQuery, Class<?> returnType);

	Query getEntityManagerQuery(final String query);

	void logDebug(final String msg, final Throwable ex);

	void logTrace(final String msg, final Throwable ex);

	void logError(final String msg, final Throwable ex);

	void logFatal(final String msg, final Throwable ex);

	void logInfo(final String msg, final Throwable ex);

	void logWarn(final String msg, final Throwable ex);

	void logDebug(final String msg);

	void logTrace(final String msg);

	void logError(final String msg);

	void logFatal(final String msg);

	void logInfo(final String msg);

	void logWarn(final String msg);

}
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
package com.blastvibrations.jpa.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExEntity;
import com.blastvibrations.jpa.orm.ExUser;
import com.blastvibrations.jpa.orm.comparator.GenericComparator;
import com.blastvibrations.jpa.util.ReflectionUtils;
import com.toddfast.util.convert.TypeConverter;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private final static String NEW_UPDATE = "new_update";
    private final static String DELETE = "delete";
    private final static String NEW = "new";
    private final static String UPDATE = "update";

    private final Logger LOG = LoggerFactory.getLogger(GenericDaoImpl.class);

    private @Autowired HttpServletRequest request;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    @Autowired
    private ExEntityDirtyCache exEntityDirtyCache;

    private final Class<T> type;

    private String findAllQuery = "";

    private String countQuery = "";

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public GenericDaoImpl() {
	final Type t = getClass().getGenericSuperclass();
	final ParameterizedType pt = (ParameterizedType) t;
	this.type = (Class) pt.getActualTypeArguments()[0];
	this.findAllQuery = this.type.getSimpleName() + ".findAll";
	this.countQuery = "SELECT count(o) from " + this.type.getSimpleName()
		+ " o ";
    }

    @Override
    public EntityManager getEntityManager() {
	return this.em;
    }

    @Override
    public Query getEntityManagerNamedQuery(final String namedQuery) {
	return getEntityManager().createNamedQuery(namedQuery);
    }

    @Override
    public Query getEntityManagerNamedQuery(final String namedQuery,
	    final Class<?> returnType) {
	return getEntityManager().createNamedQuery(namedQuery, returnType);
    }

    @Override
    public Query getEntityManagerQuery(final String query) {
	return getEntityManager().createQuery(query);
    }

    @Override
    public long countAll() {
	final Query query = getEntityManagerQuery(this.countQuery);
	final Object o = query.getSingleResult();
	return (Long) o;
    }

    @Override
    public T persist(final T t) {
	final ExEntity e = (ExEntity) t;
	e.prePersist(e);
	return persist(t, NEW_UPDATE);

    }

    private T findSurrogateId(final T t) {

	final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
	final CriteriaQuery<T> query = cb.createQuery(this.type);
	final Root<T> routeRoot = query.from(this.type);
	query.select(routeRoot);

	final UUID uuid = ((ExEntity) t).getId();
	final Predicate p = cb.equal(routeRoot.get("id2"), uuid);
	query.where(p);

	final List<T> listResult = getEntityManager().createQuery(query)
		.getResultList();

	if (listResult.size() == 1) {
	    return listResult.get(0);
	} else if (listResult.size() == 0) {
	    return null;
	} else {
	    LOG.info("find Surrogate found more than 1 key, this is a database problem. Ensure column _id is unique");
	    getEntityManager().getTransaction().rollback();
	}

	return null;

    }

    private T persist(final T t, String action) {
	// TODO: ANDRE, got the session
	// Also check to make sure that the request is not empty, it may blow
	// If there is a timewout for some reason, the request.getSession()
	// could potentiony return null
	// and finally, the getAttribute("USER") could be null as well!!!
	// thus, you may want to thown a RuntimeException or do other things.

	ExUser exUser = (ExUser) request.getSession().getAttribute("EX_USER");

	// Set a System User
	if (exUser == null) {

	    Log.error("The User Id is missing for the dao : "
		    + this.getClass().getCanonicalName());

	    exUser = new ExUser();
	    exUser.setId(UUID
		    .fromString("00000000-0000-0000-0000-000000000000"));
	    exUser.setUsername("system");
	}

	final ExEntity e = (ExEntity) t;

	final UUID id = e.getId();

	if (action.equals(NEW_UPDATE)) {

	    // Creating a new record
	    if (id == null) {

		action = NEW;

		final Date createTimeStamp = new Date();
		e.setCreated(createTimeStamp);
		e.setCreatedByUser(exUser.getUsername());
		e.setCreatedByUserId(exUser.getUserId());
		e.setDeleted(false);
		e.setId(UUID.randomUUID());
		e.setLastModifiedByUser(exUser.getUsername());
		e.setLastModifiedByUserId(exUser.getUserId());
		e.setModified(createTimeStamp);

	    } else {
		action = UPDATE;
		// Modify an existing record
		e.setLastModifiedByUser(exUser.getUsername());
		e.setLastModifiedByUserId(exUser.getUserId());
		e.setModified(new Date());
	    }
	} else if (action.equals(DELETE)) {

	    e.setDeleted(true);
	    e.setLastModifiedByUser(exUser.getUsername());
	    e.setLastModifiedByUserId(exUser.getUserId());
	    e.setModified(new Date());
	} else {

	    // Rollback the transaction if the action is not set
	    getEntityManager().getTransaction().rollback();
	    LOG.error("call persist and the system could not determine the action");
	}

	// get attached object

	try {
	    final T attachedObject = findSurrogateId(t);

	    if (attachedObject != null) {
		// If attached Object is not null merge the T object with the
		// attache Object and persist
		ReflectionUtils.clone(t, attachedObject, null);
		getEntityManager().persist(attachedObject);

		getEntityManager().flush();

		exEntityDirtyCache.setModified((ExEntity) attachedObject,
			request.getSession().getId());

		return attachedObject;

	    } else {

		// If attached Object is null that it must be a new object

		((ExEntity) t).clearKey();
		((ExEntity) t).setId(UUID.randomUUID());

		getEntityManager().persist(t);

		getEntityManager().flush();

		exEntityDirtyCache.setModified((ExEntity) t, request
			.getSession().getId());

		return t;

	    }
	} catch (final Exception ex) {

	    // Only detach and clear the object if working on a new record
	    if (action.equals(NEW)) {

		getEntityManager().clear();

		((ExEntity) t).clearKey();

	    }

	    request.setAttribute("ERROR", ex);

	    ex.printStackTrace();

	    return t;
	}

    }

    @Override
    public void delete(final Object id) {

	getEntityManager().remove(getEntityManager().getReference(type, id));
    }

    @Override
    public void deleteLogical(final T t) {

	persist(t, DELETE);

    }

    @Override
    public T find(final Object id) {
	return getEntityManager().find(type, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
	return getEntityManagerNamedQuery(this.findAllQuery).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> tableSorting(final List<ExClient> list,
	    final SQLClause[] whereClauseArray,
	    final OrderByClause[] orderByArray, final int maxResultSet) {

	return tableSorting(list, whereClauseArray, orderByArray, maxResultSet,
		false);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> tableSorting(final List<ExClient> list,
	    final SQLClause[] whereClauseArray,
	    final OrderByClause[] orderByArray, final int maxResultSet,
	    final boolean includeDeletedRecords) {

	final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

	CriteriaQuery<T> query = cb.createQuery(this.type);
	final Root<T> routeRoot = query.from(this.type);
	query.select(routeRoot);

	final List<Order> orderList = new ArrayList<Order>();

	// query.where(routeRoot.get("owner").in(user));

	for (final OrderByClause orderByName : orderByArray) {

	    if (orderByName.isAscending()) {
		orderList
			.add(cb.asc(routeRoot.get(orderByName.getFieldName())));
	    } else {
		orderList
			.add(cb.desc(routeRoot.get(orderByName.getFieldName())));
	    }
	}

	final List<Predicate> predicateList = new ArrayList<Predicate>();

	// Never return deleted records
	List<SQLClause> whereClauseList = new ArrayList();
	whereClauseList.addAll(Arrays.asList(whereClauseArray));

	if (!includeDeletedRecords) {
	    SQLClauseEqual ignoreDeletedRecordsClause = new SQLClauseEqual();

	    ignoreDeletedRecordsClause.fieldName = "deleted";
	    ignoreDeletedRecordsClause.name = "Deleted";
	    ignoreDeletedRecordsClause.tableName = this.type.getName();
	    ignoreDeletedRecordsClause.filterType = "filter-inclause";
	    ignoreDeletedRecordsClause.value = "false";

	    whereClauseList.add((SQLClause) ignoreDeletedRecordsClause);
	}

	// Loop thru a list of SQLClause predicates and
	// convert them to JPA predicates
	for (final SQLClause whereClause : whereClauseList) {

	    try {
		// binary operator
		if (whereClause instanceof WhereClauseBinary) {

		    final WhereClauseBinary b = (WhereClauseBinary) whereClause;
		    final String operator = ((WhereClauseBinary) whereClause)
			    .getOperator();
		    final String fieldName = b.getFieldName();
		    Object o = b.getObject();
		    final Path<Object> pathObject = routeRoot.get(fieldName);

		    o = TypeConverter.generic(pathObject.getJavaType(), o);

		    // 3 possible filtering
		    switch (operator) {
		    case WhereClauseBinary.OPERATOR_EQUAL:
			predicateList.add(cb.equal(pathObject, o));
			break;

		    case WhereClauseBinary.FILTER_GREATER_THAN_OR_EQUAL_TO:
			predicateList.add(cb.greaterThanOrEqualTo(
				routeRoot.get(fieldName), (Comparable) o));
			break;

		    case WhereClauseBinary.FILTER_LESS_THAN_OR_EQUAL_TO:
			predicateList.add(cb.lessThanOrEqualTo(
				routeRoot.get(fieldName), (Comparable) o));
			break;

		    default:
			throw new Exception("operator not defined");

		    }

		} else if (whereClause instanceof WhereClauseUnary) {

		    final WhereClauseUnary u = (WhereClauseUnary) whereClause;
		    final String operator = ((WhereClauseUnary) whereClause)
			    .getOperator();
		    final String fieldName = u.getfieldName();

		    switch (operator) {
		    case WhereClauseUnary.OPERATOR_IS_NOT_NULL:
			predicateList
				.add(cb.isNotNull(routeRoot.get(fieldName)));
			break;

		    default:

			throw new Exception("operator not defined");

		    }

		} else if (whereClause instanceof SQLClauseBetween) {

		    final SQLClauseBetween u = (SQLClauseBetween) whereClause;

		    final String fieldName = u.getFieldName();

		    Class fieldNameClass = null;
		    try {
			fieldNameClass = this.type.getDeclaredField(fieldName)
				.getType();
		    } catch (NoSuchFieldException e) {
			fieldNameClass = this.type.getSuperclass()
				.getDeclaredField(fieldName).getType();

		    }

		    Object fromValue = TypeConverter.generic(fieldNameClass,
			    u.getFromValue());

		    Object toValue = TypeConverter.generic(fieldNameClass,
			    u.getToValue());

		    // If fromValue GT than toValue swap fromValue and toValue

		    if (fromValue instanceof Number) {

			GenericComparator comparator = new GenericComparator();

			if (comparator.compare((Number) fromValue,
				(Number) toValue) > 0) {
			    Object tmp = toValue;
			    toValue = fromValue;
			    fromValue = tmp;
			}

		    } else if (fromValue instanceof String) {

			if (((String) fromValue).compareTo((String) toValue) > 0) {
			    Object tmp = toValue;
			    toValue = fromValue;
			    fromValue = tmp;
			}

		    } else if (fromValue instanceof Date) {

			if (((Date) fromValue).compareTo((Date) toValue) > 0) {
			    Object tmp = toValue;
			    toValue = fromValue;
			    fromValue = tmp;
			}

		    }

		    predicateList.add(cb.between(routeRoot.get(fieldName),
			    (Comparable) fromValue, (Comparable) toValue));

		} else if (whereClause instanceof SQLClauseGT) {

		    final SQLClauseGT u = (SQLClauseGT) whereClause;

		    final String fieldName = u.getFieldName();

		    Class fieldNameClass = null;
		    try {
			fieldNameClass = this.type.getDeclaredField(fieldName)
				.getType();
		    } catch (NoSuchFieldException e) {
			fieldNameClass = this.type.getSuperclass()
				.getDeclaredField(fieldName).getType();

		    }

		    Object value = TypeConverter.generic(fieldNameClass,
			    u.getValue());

		    predicateList.add(cb.greaterThan(routeRoot.get(fieldName),
			    (Comparable) value));

		} else if (whereClause instanceof SQLClauseGE) {

		    final SQLClauseGE u = (SQLClauseGE) whereClause;

		    final String fieldName = u.getFieldName();

		    Class fieldNameClass = null;
		    try {
			fieldNameClass = this.type.getDeclaredField(fieldName)
				.getType();
		    } catch (NoSuchFieldException e) {
			fieldNameClass = this.type.getSuperclass()
				.getDeclaredField(fieldName).getType();

		    }

		    Object value = TypeConverter.generic(fieldNameClass,
			    u.getValue());

		    predicateList.add(cb.greaterThanOrEqualTo(
			    routeRoot.get(fieldName), (Comparable) value));

		} else if (whereClause instanceof SQLClauseLT) {

		    final SQLClauseLT u = (SQLClauseLT) whereClause;

		    final String fieldName = u.getFieldName();

		    Class fieldNameClass = null;
		    try {
			fieldNameClass = this.type.getDeclaredField(fieldName)
				.getType();
		    } catch (NoSuchFieldException e) {
			fieldNameClass = this.type.getSuperclass()
				.getDeclaredField(fieldName).getType();

		    }

		    Object value = TypeConverter.generic(fieldNameClass,
			    u.getValue());

		    predicateList.add(cb.lessThan(routeRoot.get(fieldName),
			    (Comparable) value));

		} else if (whereClause instanceof SQLClauseLE) {

		    final SQLClauseLE u = (SQLClauseLE) whereClause;

		    final String fieldName = u.getFieldName();

		    Class fieldNameClass = null;
		    try {
			fieldNameClass = this.type.getDeclaredField(fieldName)
				.getType();
		    } catch (NoSuchFieldException e) {
			fieldNameClass = this.type.getSuperclass()
				.getDeclaredField(fieldName).getType();

		    }

		    Object value = TypeConverter.generic(fieldNameClass,
			    u.getValue());

		    predicateList.add(cb.lessThanOrEqualTo(
			    routeRoot.get(fieldName), (Comparable) value));

		} else if (whereClause instanceof SQLClauseEqual) {

		    final SQLClauseEqual equal = (SQLClauseEqual) whereClause;

		    final String fieldName = equal.getFieldName();

		    Class fieldNameClass = null;
		    try {
			fieldNameClass = this.type.getDeclaredField(fieldName)
				.getType();
		    } catch (NoSuchFieldException e) {
			fieldNameClass = this.type.getSuperclass()
				.getDeclaredField(fieldName).getType();

		    }

		    Object value = TypeConverter.generic(fieldNameClass,
			    equal.getValue());

		    predicateList.add(cb.equal(routeRoot.get(fieldName),
			    (Comparable) value));

		} else if (whereClause instanceof SQLClauseInClause) {

		    final SQLClauseInClause inClause = (SQLClauseInClause) whereClause;

		    final String fieldName = inClause.getFieldName();

		    Class fieldNameClass = null;
		    try {
			fieldNameClass = this.type.getDeclaredField(fieldName)
				.getType();
		    } catch (NoSuchFieldException e) {
			fieldNameClass = this.type.getSuperclass()
				.getDeclaredField(fieldName).getType();

		    }

		    In<Object> in = cb.in(routeRoot.get(fieldName));

		    if (fieldNameClass.isAssignableFrom(UUID.class)) {

			StringTokenizer token = new StringTokenizer(
				inClause.getValue(), ",");

			while (token.hasMoreTokens()) {
			    in.value(UUID.fromString(token.nextToken()));
			}

		    } else {

			StringTokenizer strToken = new StringTokenizer(
				inClause.getValue(), ",");
			while (strToken.hasMoreTokens()) {
			    in.value(strToken.nextToken());
			}

		    }

		    // loop in.value to set the values;
		    // for (Serializable conditionColumnValue :
		    // conditionColumnValues) {
		    // in.value(conditionColumnValue);
		    // }

		    predicateList.add(in);

		} else {

		    throw new Exception(
			    "Invalid type must be WhereClauseBinary or WhereClauseUnary");
		}
	    } catch (final Exception ex) {
		ex.printStackTrace();
	    }
	}

	// test

	// final List<UUID> clientUUIDList = new ArrayList<UUID>();
	//
	// if (list != null) {
	// list.forEach(c -> clientUUIDList.add(c.getClientId()));
	//
	// if (clientUUIDList.size() > 0) {
	//
	// final Expression<UUID> exp = routeRoot.get("clientId");
	//
	// final Predicate predicate = exp.in(clientUUIDList);
	//
	// predicateList.add(predicate);
	//
	// // query.where(cb.and(predicateList
	// // .toArray(new Predicate[predicateList.size()])));
	//
	// }
	// }

	query.orderBy(orderList);

	final List<T> entityList = getEntityManager()
		.createQuery(
			query.where(predicateList
				.toArray(new Predicate[predicateList.size()])))
		.setMaxResults(maxResultSet).getResultList();

	return entityList;
    }

    @Override
    public void logDebug(final String msg, final Throwable ex) {
	this.LOG.debug(msg, ex);
    }

    @Override
    public void logTrace(final String msg, final Throwable ex) {
	this.LOG.trace(msg, ex);
    }

    @Override
    public void logError(final String msg, final Throwable ex) {
	this.LOG.error(msg, ex);
    }

    @Override
    public void logFatal(final String msg, final Throwable ex) {
	this.LOG.error(msg, ex);
    }

    @Override
    public void logInfo(final String msg, final Throwable ex) {
	this.LOG.error(msg, ex);
    }

    @Override
    public void logWarn(final String msg, final Throwable ex) {
	this.LOG.error(msg, ex);
    }

    @Override
    public void logDebug(final String msg) {
	this.LOG.debug(msg);
    }

    @Override
    public void logTrace(final String msg) {
	this.LOG.trace(msg);
    }

    @Override
    public void logError(final String msg) {
	this.LOG.error(msg);
    }

    @Override
    public void logFatal(final String msg) {
	this.LOG.error(msg);
    }

    @Override
    public void logInfo(final String msg) {
	this.LOG.info(msg);
    }

    @Override
    public void logWarn(final String msg) {
	this.LOG.warn(msg);
    }

}

package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.request.RequestQueries;
import com.blastvibrations.jpa.orm.ExBlastRequest;
import com.blastvibrations.jpa.orm.comparator.ExBlastRequestComparators;

@Repository
public class ExBlastRequestDaoImpl extends GenericDaoImpl<ExBlastRequest>
	implements ExBlastRequestDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastRequest> findBlastRequestByClientId(final UUID clientId) {
	List<ExBlastRequest> exRequestList = null;

	try {
	    exRequestList = getEntityManagerNamedQuery(
		    RequestQueries.FIND_BY_CLIENTID).setParameter("clientId",
		    clientId).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exRequestList == null) {
	    return new ArrayList<ExBlastRequest>();
	} else {
	    return exRequestList;
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastRequest> findByContactId(final UUID blastContactId,
	    boolean isDeleted) {

	List<ExBlastRequest> exBlastRequestList = null;

	final String querySql = " select * from ( SELECT json_array_elements (selected_contacts) as e, C.*  "
		+ " from ex_blast_request as C  where ( C.deleted = "
		+ isDeleted
		+ "  or deleted = false )) as r  where cast (e as text) = '\""
		+ blastContactId.toString() + "\"' ";

	try {

	    final Query q = getEntityManager().createNativeQuery(querySql,
		    ExBlastRequest.class);

	    exBlastRequestList = q.getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastRequestList == null) {
	    return new ArrayList<ExBlastRequest>();
	} else {
	    return exBlastRequestList;
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastRequest> findByContactId(final UUID blastContactId) {

	return findByContactId(blastContactId, false);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastRequest> findBlastRequestsForUserClientList(
	    final UUID userId, final String sort, final String order,
	    final String status) {

	return findBlastRequestsForUserClientList(userId, false, sort, order,
		status);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastRequest> findBlastRequestsForUserClientList(
	    final UUID userId, final boolean isDeleted, final String sort,
	    final String order, final String status) {

	List<ExBlastRequest> exBlastRequestList = null;

	try {
	    exBlastRequestList = getEntityManagerNamedQuery(
		    RequestQueries.FIND_BLASTREQUESTS_FOR_USER_CLIENTLIST)
		    .setParameter("userId", userId)
		    .setParameter("deleted", isDeleted).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastRequestList == null) {
	    return new ArrayList<ExBlastRequest>();
	} else {

	    if (sort != null) {
		if (sort.equalsIgnoreCase("contactName")) {
		    Collections.sort(exBlastRequestList,
			    ExBlastRequestComparators.CLIENT);
		} else if (sort.equalsIgnoreCase("addresse")) {
		    Collections.sort(exBlastRequestList,
			    ExBlastRequestComparators.CLIENT);
		} else if (sort.equalsIgnoreCase("client")) {
		    Collections.sort(exBlastRequestList,
			    ExBlastRequestComparators.CLIENT);
		} else if (sort.equalsIgnoreCase("status")) {
		    Collections.sort(exBlastRequestList,
			    ExBlastRequestComparators.STATUS);

		}
	    }

	    return exBlastRequestList;
	}

	//
	// Integer maxPredicatesIncludingPredicates = (new Integer(
	// MAX_NUMBER_OF_PREDICATE_VALUES_PER_IN_CLAUSE)) - 3;
	//
	// final StringBuffer exSQL = new StringBuffer();
	// exSQL.append("SELECT * FROM ExBlastRequest WHERE clientId IN ("
	// + getClientIdSQLInClause(user) + ") AND deleted != 'true' ");
	//
	// if ((sort != null)
	// && ((sort.equalsIgnoreCase("contactName"))
	// || (sort.equalsIgnoreCase("address"))
	// || (sort.equalsIgnoreCase("client")) || (sort
	// .equalsIgnoreCase("status")))) {
	// exSQL.append(" AND " + sort + " is not null ORDER BY " + sort + "");
	// maxPredicatesIncludingPredicates = maxPredicatesIncludingPredicates -
	// 2;
	// } else {
	// exSQL.append(" AND start is not null ORDER BY start");
	// maxPredicatesIncludingPredicates = maxPredicatesIncludingPredicates -
	// 2;
	//
	// }
	// // order by
	// if ((order != null)
	// && ((order.equalsIgnoreCase("ASC") || (order
	// .equalsIgnoreCase("DESC"))))) {
	// exSQL.append(" " + order);
	// } else {
	// exSQL.append(" DESC");
	// }
	//
	// final List<String> listSplitSQLInExpression = ExpressionParser
	// .splitSQLInClause(exSQL.toString(),
	// maxPredicatesIncludingPredicates);
	//
	// XBlastRequest[] blastRequests = new XBlastRequest[0];
	// for (final String expression : listSplitSQLInExpression) {
	// final XBlastRequest[] result = SelectQuery.query(expression,
	// XBlastRequest.class).toArray(new XBlastRequest[0]);
	// blastRequests = XUtils.concat(blastRequests, result);
	// }
	// return blastRequests;

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastRequest> findBlastRequestsForUserBetweenStartAndEndDate(
	    final UUID userId, final Date startDate, final Date endDate) {

	List<ExBlastRequest> exBlastRequestList = null;

	try {
	    exBlastRequestList = getEntityManagerNamedQuery(
		    RequestQueries.FIND_BLAST_REQUESTS_FOR_USER_BETWEEN_START_AND_END_DATE)
		    .setParameter("userId", userId)
		    .setParameter("startDate", startDate)
		    .setParameter("endDate", endDate).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastRequestList == null) {
	    return new ArrayList<ExBlastRequest>();
	} else {
	    return exBlastRequestList;
	}

    }

    @Override
    public ExBlastRequest findByShareId(final UUID shareId) {
	ExBlastRequest exBlastRequest = null;

	try {
	    exBlastRequest = (ExBlastRequest) getEntityManagerNamedQuery(
		    RequestQueries.FIND_BY_SHAREID).setParameter("shareId",
		    shareId).getSingleResult();

	} catch (final NoResultException noResultEx) {
	    logInfo(noResultEx.getMessage());
	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	return exBlastRequest;
    }

    @Override
    public List<ExBlastRequest> findActiveRequestByLocationEventDates(
	    String exLocationName, Date eventDate, UUID clientId) {

	List<ExBlastRequest> exBlastRequestList = null;

	try {
	    exBlastRequestList = getEntityManagerNamedQuery(
		    RequestQueries.FIND_ACTIVE_BLAST_REQUESTS_FOR_LOCATION_AND_DATE)
		    // .setParameter("exLocationName", exLocationName)
		    .setParameter("clientId", clientId)
		    .setParameter("eventDate", eventDate).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastRequestList == null) {
	    return new ArrayList<ExBlastRequest>();
	} else {
	    return exBlastRequestList;
	}
    }

}

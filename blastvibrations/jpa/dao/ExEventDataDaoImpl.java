package com.blastvibrations.jpa.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.eventdata.EventDataQueries;
import com.blastvibrations.jpa.orm.ExEventData;
import com.blastvibrations.jpa.orm.ExUser;

@Repository
public class ExEventDataDaoImpl extends GenericDaoImpl<ExEventData> implements
	ExEventDataDao {

    @Override
    public List<ExEventData> findEventFilterTab(final ExUser user,
	    final List<UUID> allowedClientList, final UUID filterClientId,
	    final String filterLocation, final String filterUnitSerialNumber,
	    final String filterHighlightEventType,
	    final String filterStartDate, final String filterEndDate,
	    final String sort, final boolean asc,
	    final String filterStartTime /* not being used */,
	    final String filterEndTime /* not being used */,
	    final int maxRecordResultSet) {

	List<ExEventData> exEventDataList = null;

	try {

	    // Get sets of event that the user can see
	    // @SuppressWarnings("unchecked")
	    // final Query query = getEntityManagerNamedQuery(
	    // EventDataQueries.FIND_EVENT_DATA_BY_USERID).setParameter(
	    // "userId", user.getUserId());

	    final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

	    final CriteriaQuery<ExEventData> query = cb
		    .createQuery(ExEventData.class);

	    final Root<ExEventData> e = query.from(ExEventData.class);

	    // Filter user allowed se

	    final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	    Date start = null;
	    Date end = null;

	    try {

		if (df.parse(filterStartDate) != null) {
		    start = df.parse(filterStartDate);
		    end = df.parse(filterEndDate);
		}

	    } catch (final Exception excep) {

		if (filterStartDate != null) {
		    start = new Date(Long.parseLong(filterStartDate));
		}

		if (filterEndDate != null) {
		    end = new Date(Long.parseLong(filterEndDate));
		}
	    }

	    final List<Predicate> predicates = new ArrayList<Predicate>();

	    if (start != null) {
		predicates.add(cb.greaterThanOrEqualTo(e.get("date"), start));
	    }

	    if (end != null) {
		predicates.add(cb.lessThanOrEqualTo(e.get("date"), end));
	    }

	    if (filterClientId != null) {
		predicates.add(cb.equal(e.get("clientId"), filterClientId));
	    }

	    if (filterLocation != null) {

		predicates.add(cb.equal(e.get("location"), filterLocation));
	    }

	    if (filterUnitSerialNumber != null) {
		predicates.add(cb.equal(e.get("unitSerialNumber"),
			filterUnitSerialNumber));
	    }

	    if (!StringUtils.isEmpty(filterHighlightEventType)) {
		predicates.add(cb.equal(e.get("highlightEventType"),
			filterHighlightEventType));
	    }

	    predicates.add(cb.equal(e.get("deleted"), false));

	    final Expression<String> exp = e.get("clientId");

	    // If no client associate to a given user add a bogus clientId
	    // to ensure no data is return to that end user
	    if (allowedClientList != null && allowedClientList.size() > 0) {
		predicates.add(exp.in(allowedClientList));

	    } else {

		allowedClientList.add(UUID.randomUUID());
		predicates.add(exp.in(allowedClientList));

	    }

	    final List<Order> orderList = new ArrayList<Order>();

	    if (sort != null) {

		if (asc) {
		    orderList.add(cb.asc(e.get(sort)));
		} else {
		    orderList.add(cb.desc(e.get(sort)));
		}

	    } else {
		orderList.add(cb.desc(e.get("eventDate")));
	    }

	    query.where((predicates.toArray(new Predicate[predicates.size()])))
		    .orderBy(orderList);

	    exEventDataList = getEntityManager().createQuery(query)
		    .setMaxResults(maxRecordResultSet).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exEventDataList == null) {
	    return new ArrayList<ExEventData>();
	} else {
	    return exEventDataList;
	}
	// if (exEventDataList == null) {
	// return new ExEventData[0];
	// } else {
	// return exEventDataList.stream().toArray(ExEventData[]::new);
	// }

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExEventData> findEventDataByClientIDList(
	    final List<UUID> clientIdUUIDList) {

	List<ExEventData> exEventDataList = null;

	try {

	    exEventDataList = getEntityManagerNamedQuery(
		    EventDataQueries.FIND_EVENT_DATA_BY_CLIENTID_LIST)
		    .setParameter("clientIdUUIDList", clientIdUUIDList)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exEventDataList == null) {
	    return new ArrayList<ExEventData>();
	} else {
	    return exEventDataList;
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExEventData> findEventDataByEventDataIdList(
	    final List<UUID> eventDataUUIDList, final UUID userId) {

	List<ExEventData> exEventDataList = null;

	try {

	    exEventDataList = getEntityManagerNamedQuery(
		    EventDataQueries.FIND_EVENT_DATA_BY_EVENTDATAUUID_LIST)
		    .setParameter("userId", userId)
		    .setParameter("eventDataUUIDList", eventDataUUIDList)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exEventDataList == null) {
	    return new ArrayList<ExEventData>();
	} else {
	    return exEventDataList;
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExEventData> findEventDataHavingNoMonitorNoClient() {
	List<ExEventData> exEventDataList = null;

	try {
	    exEventDataList = getEntityManagerNamedQuery(
		    EventDataQueries.FIND_MISSING_EVENT_DATA_NO_MONITOR_NO_CLIENT_LIST)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exEventDataList == null) {
	    return new ArrayList<ExEventData>();
	} else {
	    return exEventDataList;
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExEventData> findEventDataByClientIDWithEventDateList(
	    final List<UUID> eventDataUUIDList) {
	List<ExEventData> exEventDataList = null;

	try {

	    exEventDataList = getEntityManagerNamedQuery(
		    EventDataQueries.FIND_EVENT_DATA_BY_EVENTDATAUUID_DATENOTNULL_LIST)
		    .setParameter("eventDataUUIDList", eventDataUUIDList)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exEventDataList == null) {
	    return new ArrayList<ExEventData>();
	} else {
	    return exEventDataList;
	}
    }

    @Override
    public List<ExEventData> findEventDataByBlastReportIdList(
	    List<UUID> selectedBlastReportList) {

	List<ExEventData> exEventDataList = null;

	try {

	    exEventDataList = getEntityManagerNamedQuery(
		    EventDataQueries.FIND_EVENT_DATA_BY_BLAST_REPORT_ID_LIST)
		    .setParameter("blastReportIdList", selectedBlastReportList)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exEventDataList == null) {
	    return new ArrayList<ExEventData>();
	} else {
	    return exEventDataList;
	}

    }
}

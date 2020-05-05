package com.blastvibrations.jpa.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.blastreport.BlastReportQueries;
import com.blastvibrations.jpa.orm.ExBlastReport;
import com.blastvibrations.jpa.orm.ExUser;

@Repository
public class ExBlastReportDaoImpl extends GenericDaoImpl<ExBlastReport>
implements ExBlastReportDao {

	@Override
	public List<UUID> findBlastReportByUserId(final UUID userId,
			final ArrayList<UUID> arrayList) {

		final List<ExBlastReport> exBlastReportList = findBlastReportByUserId(userId);
		final List<UUID> blastIdUUIDList = new ArrayList<UUID>();

		exBlastReportList.forEach(b -> blastIdUUIDList.add(b.getBlastId()));

		return blastIdUUIDList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExBlastReport> findBlastReportByUserId(final UUID userId) {

		List<ExBlastReport> exBlastReportList = null;

		try {
			exBlastReportList = getEntityManagerNamedQuery(
					BlastReportQueries.BLASTREPORT_FIND_LIST_BLAST_REPORT_BY_USERID)
					.setParameter("userId", userId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastReportList == null) {
			return new ArrayList<ExBlastReport>();
		} else {
			return exBlastReportList;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExBlastReport> findBlastReportTemplateByClientId(
			final UUID clientId) {

		List<ExBlastReport> exBlastReportList = null;

		try {
			exBlastReportList = getEntityManagerNamedQuery(
					BlastReportQueries.BLASTREPORT_FIND_LIST_BLAST_REPORT_TEMPLATE_BY_CLIENT_ID)
					.setParameter("clientId", clientId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastReportList == null) {
			return new ArrayList<ExBlastReport>();
		} else {
			return exBlastReportList;
		}

	}

	@Override
	public ExBlastReport find(final String blastId) {
		final UUID uuid = java.util.UUID.fromString(blastId);
		return find(uuid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExBlastReport> findBlastReportsForUserBetweenStartAndEndDate(
			final UUID userId, final Date startDate, final Date endDate) {

		List<ExBlastReport> exBlastReportList = null;

		try {
			exBlastReportList = getEntityManagerNamedQuery(
					BlastReportQueries.FIND_BLAST_REPORTS_FOR_USER_BETWEEN_START_AND_END_DATE)
					.setParameter("userId", userId)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastReportList == null) {
			return new ArrayList<ExBlastReport>();
		} else {
			return exBlastReportList;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExBlastReport> findBlastReportsNotDeleted() {

		List<ExBlastReport> exBlastReportList = null;

		try {
			exBlastReportList = getEntityManagerNamedQuery(
					BlastReportQueries.FIND_BLAST_REPORTS_NOT_DELETED)
					.getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastReportList == null) {
			return new ArrayList<ExBlastReport>();
		} else {
			return exBlastReportList;
		}

	}

	@Override
	public List<ExBlastReport> findBlastReportsByBlastIdsListNotDeleted(
			final List<String> blastIdsList) {

		final List<UUID> uuidList = new ArrayList<UUID>();

		blastIdsList.forEach(c -> uuidList.add(UUID.fromString(c)));

		return findBlastReportsByBlastUuidsListNotDeleted(uuidList);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExBlastReport> findBlastReportsByBlastUuidsListNotDeleted(
			final List<UUID> blastIdsList) {

		List<ExBlastReport> exBlastReportList = null;

		try {

			final Query q = getEntityManager()
					.createNamedQuery(
							BlastReportQueries.FIND_BLAST_REPORTS_BY_BLASTIDS_LIST_NOT_DELETED);

			exBlastReportList = q.setParameter("blastIdList", blastIdsList)
					.getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastReportList == null) {
			return new ArrayList<ExBlastReport>();
		} else {

			return exBlastReportList;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExBlastReport> findBlastReportsNoTemplateByClientUuidsListNotDeleted(
			final List<UUID> clientIdsList) {

		List<ExBlastReport> exBlastReportList = null;

		try {

			final Query q = getEntityManager()
					.createNamedQuery(
							BlastReportQueries.FIND_BLAST_REPORTS_NOTEMPLATE_BY_CLIENTIDS_LIST_NOT_DELETED);

			exBlastReportList = q.setParameter("clientIdList", clientIdsList)
					.getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastReportList == null) {
			return new ArrayList<ExBlastReport>();
		} else {

			return exBlastReportList;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExBlastReport> findBlastReportsNoTemplateByClientUuidsListNotDeletedBetweenStartAndEndDate(
			final List<UUID> clientIdsList, final Date startDate,
			final Date endDate) {
		List<ExBlastReport> exBlastReportList = null;

		try {

			// final Query q = getEntityManager()
			// .createNamedQuery(
			// BlastReportQueries.FIND_BLAST_REPORTS_NOTEMPLATE_BY_CLIENTIDS_LIST_BETWEEN_NO_DATES);

			final Query q = getEntityManager()
					.createNamedQuery(
							BlastReportQueries.FIND_BLAST_REPORTS_NOTEMPLATE_BY_CLIENTIDS_LIST_BETWEEN_START_AND_END_DATE);

			exBlastReportList = q.setParameter("clientIdList", clientIdsList)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastReportList == null) {
			return new ArrayList<ExBlastReport>();
		} else {

			return exBlastReportList;
		}
	}

	@Override
	public List<ExBlastReport> findEventFilterTab(final ExUser user,
			final List<UUID> allowedClientList, final UUID filterClientId,
			final String filterLocation, final String filterUnitSerialNumber,
			final String filterHighlightEventType,
			final String filterStartDate, final String filterEndDate,
			final String sort,
			final String filterStartTime /* not being used */,
			final String filterEndTime /* not being used */,
			final int maxRecordResultSet) {

		List<ExBlastReport> exBlastReportList = null;

		try {

			// Get sets of event that the user can see
			// @SuppressWarnings("unchecked")
			// final Query query = getEntityManagerNamedQuery(
			// EventDataQueries.FIND_EVENT_DATA_BY_USERID).setParameter(
			// "userId", user.getUserId());

			final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();

			final CriteriaQuery<ExBlastReport> query = cb
					.createQuery(ExBlastReport.class);

			final Root<ExBlastReport> e = query.from(ExBlastReport.class);

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

			if (filterHighlightEventType != null
					&& StringUtils.isNoneEmpty(filterHighlightEventType)
					&& !filterHighlightEventType.equals("0")) {
				predicates.add(cb.equal(e.get("highlightEventType"),
						filterHighlightEventType));
			}

			predicates.add(cb.equal(e.get("deleted"), false));

			final Expression<String> exp = e.get("clientId");

			if (allowedClientList != null && allowedClientList.size() > 0) {
				predicates.add(exp.in(allowedClientList));

			}

			final List<Order> orderList = new ArrayList<Order>();

			orderList.add(cb.desc(e.get("startDate")));

			query.where((predicates.toArray(new Predicate[predicates.size()])))
					.orderBy(orderList);

			exBlastReportList = getEntityManager().createQuery(query)
					.setMaxResults(maxRecordResultSet).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastReportList == null) {
			return new ArrayList<ExBlastReport>();
		} else {
			return exBlastReportList;
		}

	}

}

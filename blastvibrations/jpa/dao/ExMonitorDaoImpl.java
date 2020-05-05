package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.monitor.MonitorQueries;
import com.blastvibrations.jpa.orm.ExMonitor;

@Repository
public class ExMonitorDaoImpl extends GenericDaoImpl<ExMonitor> implements
		ExMonitorDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExMonitor> findListMonitorByUserId(final UUID userId) {

		List<ExMonitor> exMonitorList = null;

		try {
			exMonitorList = getEntityManagerNamedQuery(
					MonitorQueries.MONITOR_FIND_LIST_MONITOR_BY_USERID)
					.setParameter("userId", userId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exMonitorList == null) {
			return new ArrayList<ExMonitor>();
		} else {
			return exMonitorList;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExMonitor> findAllActiveMonitor() {
		List<ExMonitor> exMonitorList = null;

		try {
			exMonitorList = getEntityManagerNamedQuery(
					MonitorQueries.MONITOR_FIND_ALL_ACTIVE_MONITOR)
					.getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exMonitorList == null) {
			return new ArrayList<ExMonitor>();
		} else {
			return exMonitorList;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExMonitor> findListMonitorByClientId(final UUID clientId) {

		List<ExMonitor> exMonitorList = null;

		try {
			exMonitorList = getEntityManagerNamedQuery(
					MonitorQueries.FIND_LIST_MONITOR_BY_CLIENTID).setParameter(
					"clientId", clientId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exMonitorList == null) {
			return new ArrayList<ExMonitor>();
		} else {
			return exMonitorList;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExMonitor> findListUnassignedMonitors() {

		List<ExMonitor> exMonitorList = null;

		try {
			exMonitorList = getEntityManagerNamedQuery(
					MonitorQueries.FIND_UNASSIGNED_MONITOR).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exMonitorList == null) {
			return new ArrayList<ExMonitor>();
		} else {
			return exMonitorList;
		}
	}

	@Override
	public void unassignedAllMonitorsForClientId(final UUID clientId) {

		try {
			getEntityManagerNamedQuery(
					MonitorQueries.UNASSIGNED_ALL_MONITORS_FOR_CLIENTID)
					.setParameter("clientId", clientId).executeUpdate();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExMonitor> findListMonitorByClientIdNotDeleted(
			final UUID clientId) {

		List<ExMonitor> exMonitorList = null;

		try {
			exMonitorList = getEntityManagerNamedQuery(
					MonitorQueries.FIND_BY_CLIENTID_NOT_DELETED).setParameter(
							"clientId", clientId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exMonitorList == null) {
			return new ArrayList<ExMonitor>();
		} else {
			return exMonitorList;
		}

	}

	@Override
	public ExMonitor findByMonitorId(final UUID monitorId) {
		ExMonitor exMonitor = null;

		try {
			exMonitor = (ExMonitor) getEntityManagerNamedQuery(
					MonitorQueries.FIND_BY_MONITOR_ID).setParameter(
							"monitorId", monitorId).getSingleResult();

		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}
		return exMonitor;

	}

	@Override
	public ExMonitor findListMonitorBySerialNumber(final String serialNumber) {
		ExMonitor exMonitor = null;

		try {
			exMonitor = (ExMonitor) getEntityManagerNamedQuery(
					MonitorQueries.FIND_LIST_MONITOR_BY_SERIAL_NUMBER)
					.setParameter("serialNumber", serialNumber)
					.getSingleResult();

		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}
		return exMonitor;
	}
}

package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.location.LocationQueries;
import com.blastvibrations.jpa.orm.ExLocation;

@Repository
public class ExLocationDaoImpl extends GenericDaoImpl<ExLocation> implements
		ExLocationDao {

	@Override
	public ExLocation findByLocationId(final UUID locationId) {
		ExLocation exLocation = null;

		try {
			exLocation = (ExLocation) getEntityManagerNamedQuery(
					LocationQueries.FIND_BY_LOCATION_ID).setParameter(
							"locationId", locationId).getSingleResult();

		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}
		return exLocation;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExLocation> findLocationListOfMonitorId(final UUID userId) {

		List<ExLocation> exLocationList = null;

		try {
			exLocationList = getEntityManagerNamedQuery(
					LocationQueries.FIND_LOCATION_LIST_OF_MONITORID)
					.setParameter("userId", userId).getResultList();

		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		return exLocationList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExLocation> findLocationForMonitorUUIDList(
			final List<UUID> monitorUUIDList) {

		List<ExLocation> exLocationList = null;

		try {

			if (monitorUUIDList == null || monitorUUIDList.size() == 0) {
				exLocationList = null;
			} else {

				exLocationList = getEntityManagerNamedQuery(
						LocationQueries.FIND_LOCATION_FOR_MONITOR_UUID_LIST)
						.setParameter("monitorUUIDList", monitorUUIDList)
						.getResultList();
			}

		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exLocationList == null) {
			exLocationList = new ArrayList<ExLocation>();
		}
		return exLocationList;
	}
}

package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.blastmonitormapping.BlastMonitorMappingQueries;
import com.blastvibrations.jpa.dao.queries.monitormapping.MonitorMappingQueries;
import com.blastvibrations.jpa.orm.ExBlastMonitorMapping;

@Repository
public class ExBlastMonitorMappingDaoImpl extends
GenericDaoImpl<ExBlastMonitorMapping> implements
		ExBlastMonitorMappingDao {

	@Override
	public List<ExBlastMonitorMapping> findAllBlastByBlastId(final UUID blastId) {
		List<ExBlastMonitorMapping> exBlastMonitorMappingList = null;

		try {
			exBlastMonitorMappingList = getEntityManagerNamedQuery(
					BlastMonitorMappingQueries.BLASTMONITOMAPPING_FIND_LIST_NOT_DELETED)
					.setParameter("blastId", blastId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastMonitorMappingList == null) {
			return new ArrayList<ExBlastMonitorMapping>();
		} else {
			return exBlastMonitorMappingList;
		}
	}

	@Override
	public List<ExBlastMonitorMapping> findAllBlastByBlastId(
			final String blastId) {
		final UUID uuid = java.util.UUID.fromString(blastId);
		return findAllBlastByBlastId(uuid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExBlastMonitorMapping> findMonitorMappingByClientId(
			final UUID clientId) {
		List<ExBlastMonitorMapping> exClientCustomizationList = null;

		try {
			exClientCustomizationList = getEntityManagerNamedQuery(
					MonitorMappingQueries.FIND_BY_CLIENTID).setParameter(
					"clientId", clientId).getResultList();

		} catch (final Exception ex) {
			logInfo(ex.getMessage(), ex);
		}

		if (exClientCustomizationList == null) {
			return new ArrayList<ExBlastMonitorMapping>();
		} else {
			return exClientCustomizationList;
		}
	}

}

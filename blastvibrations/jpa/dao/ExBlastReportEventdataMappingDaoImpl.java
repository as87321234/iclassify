package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.blastreporteventdatamapping.BlastReportEventdataMappingQueries;
import com.blastvibrations.jpa.orm.ExBlastReportEventdataMapping;

@Repository
public class ExBlastReportEventdataMappingDaoImpl extends
	GenericDaoImpl<ExBlastReportEventdataMapping> implements
	ExBlastReportEventdataMappingDao {

    @Override
    public ExBlastReportEventdataMapping find(String exBlastReportEventdataId) {

	final UUID uuid = java.util.UUID.fromString(exBlastReportEventdataId);
	return find(uuid);
    }

    @Override
    public ExBlastReportEventdataMapping findBlastIdEventdataIdWithDeletedRecord(
	    UUID blastId, String eventId) {
	ExBlastReportEventdataMapping exBlastReportEventdataMapping = null;

	try {
	    exBlastReportEventdataMapping = (ExBlastReportEventdataMapping) getEntityManagerNamedQuery(
		    BlastReportEventdataMappingQueries.BLASTREPORT_FIND_BLASTREPORTEVENTMAPPING_WITH_DELETED_RECORD)
		    .setParameter("blastId", blastId)
		    .setParameter("eventDataId", UUID.fromString(eventId))
		    .getSingleResult();

	} catch (final NoResultException ex) {
	    throw ex;

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	return exBlastReportEventdataMapping;

    }

    @Override
    public List<ExBlastReportEventdataMapping> findAllByBlastId(UUID blastId) {

	List<ExBlastReportEventdataMapping> exBlastReportEventdataMappingList = null;

	try {
	    exBlastReportEventdataMappingList = (List<ExBlastReportEventdataMapping>) getEntityManagerNamedQuery(
		    BlastReportEventdataMappingQueries.BLASTREPORT_FINDALL_BYBLASTID)
		    .setParameter("blastId", blastId).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastReportEventdataMappingList == null) {
	    exBlastReportEventdataMappingList = new ArrayList<ExBlastReportEventdataMapping>();
	}

	return exBlastReportEventdataMappingList;

    }
}

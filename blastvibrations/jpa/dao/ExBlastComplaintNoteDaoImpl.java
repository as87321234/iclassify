package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.blastcomplaintsNote.BlastComplaintNoteQueries;
import com.blastvibrations.jpa.orm.ExBlastComplaintNote;

@Repository
public class ExBlastComplaintNoteDaoImpl extends
	GenericDaoImpl<ExBlastComplaintNote> implements ExBlastComplaintNoteDao {

    @Override
    public List<ExBlastComplaintNote> findComplaintNoteByComplaintId(
	    UUID blastComplaintId, boolean isDeleted) {
	List<ExBlastComplaintNote> exBlastComplaintNoteList = null;

	try {
	    exBlastComplaintNoteList = getEntityManagerNamedQuery(
		    BlastComplaintNoteQueries.FIND_BLASTCOMPLAINTSNOTE_FOR_COMPLAINTID)
		    .setParameter("blastComplaintId", blastComplaintId)
		    .setParameter("deleted", isDeleted).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastComplaintNoteList == null) {
	    return new ArrayList<ExBlastComplaintNote>();
	} else {
	    return exBlastComplaintNoteList;
	}
    }

    @Override
    public List<ExBlastComplaintNote> findBlastComplaintNoteForUserClientList(
	    UUID userId, String sort) {

	List<ExBlastComplaintNote> exBlastComplaintNoteList = null;

	try {
	    exBlastComplaintNoteList = getEntityManagerNamedQuery(
		    BlastComplaintNoteQueries.FIND_BLASTCOMPLAINTNOTES_FOR_USER_CLIENTLIST)
		    .setParameter("userId", userId)
		    .setParameter("deleted", sort).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastComplaintNoteList == null) {
	    return new ArrayList<ExBlastComplaintNote>();
	} else {
	    return exBlastComplaintNoteList;
	}
    }
}

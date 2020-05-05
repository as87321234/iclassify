package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastComplaintNote;

public interface ExBlastComplaintNoteDao {

    public List<ExBlastComplaintNote> findAll();

    public ExBlastComplaintNote find(final Object exBlastComplaintNodeId);

    public void delete(final Object exBlastComplaintNodeId);

    public void deleteLogical(final ExBlastComplaintNote exBlastComplaintNode);

    public ExBlastComplaintNote persist(
	    final ExBlastComplaintNote exBlastComplaintNode);

    public List<ExBlastComplaintNote> findComplaintNoteByComplaintId(
	    UUID blastComplaintId, boolean isDeleted);

    public List<ExBlastComplaintNote> findBlastComplaintNoteForUserClientList(
	    UUID userId, String sort);

}

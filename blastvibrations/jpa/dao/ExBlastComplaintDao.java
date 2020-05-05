package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastComplaint;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastComplaintDao {

    public List<ExBlastComplaint> findAll();

    public List<ExBlastComplaint> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastComplaint> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExBlastComplaint find(final Object exBlastComplaintId);

    public void delete(final Object exBlastComplaintId);

    public void deleteLogical(final ExBlastComplaint exBlastComplaint);

    public ExBlastComplaint persist(final ExBlastComplaint exBlastComplaint);

    public List<ExBlastComplaint> findByContactId(UUID blastContactId);

    public List<ExBlastComplaint> findByContactId(UUID blastContactId,
	    boolean isDeleted);

    public List<ExBlastComplaint> findBlastComplaintForUserClientList(
	    UUID userId, String sort, String order);

    public List<ExBlastComplaint> findBlastComplaintForUserClientList(
	    UUID userId, boolean isDeleted, String sort, String order);

}

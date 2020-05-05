package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.blastcomplaints.BlastComplaintQueries;
import com.blastvibrations.jpa.orm.ExBlastComplaint;

@Repository
public class ExBlastComplaintDaoImpl extends GenericDaoImpl<ExBlastComplaint>
	implements ExBlastComplaintDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastComplaint> findByContactId(final UUID blastContactId,
	    boolean isDeleted) {
	List<ExBlastComplaint> exBlastComplaintList = null;

	try {
	    exBlastComplaintList = getEntityManagerNamedQuery(
		    BlastComplaintQueries.FIND_BY_CONTACTID)
		    .setParameter("blastContactId", blastContactId)
		    .setParameter("deleted", isDeleted).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastComplaintList == null) {
	    return new ArrayList<ExBlastComplaint>();
	} else {
	    return exBlastComplaintList;
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastComplaint> findByContactId(final UUID blastContactId) {

	return findByContactId(blastContactId, false);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastComplaint> findBlastComplaintForUserClientList(
	    final UUID userId, final String sort, final String order) {

	return findBlastComplaintForUserClientList(userId, false, sort, order);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastComplaint> findBlastComplaintForUserClientList(
	    final UUID userId, final boolean isDeleted, final String sort,
	    final String order) {
	List<ExBlastComplaint> exBlastComplaintList = null;

	try {
	    exBlastComplaintList = getEntityManagerNamedQuery(
		    BlastComplaintQueries.FIND_BLASTCOMPLAINTS_FOR_USER_CLIENTLIST)
		    .setParameter("userId", userId)
		    .setParameter("deleted", isDeleted).getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastComplaintList == null) {
	    return new ArrayList<ExBlastComplaint>();
	} else {

	    // if (sort != null) {
	    // if (sort.equalsIgnoreCase("contactName")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.CLIENT);
	    // } else if (sort.equalsIgnoreCase("addresse")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.CLIENT);
	    // } else if (sort.equalsIgnoreCase("client")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.CLIENT);
	    // } else if (sort.equalsIgnoreCase("status")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.STATUS);
	    //
	    // }
	    // }

	    return exBlastComplaintList;
	}
    }

}

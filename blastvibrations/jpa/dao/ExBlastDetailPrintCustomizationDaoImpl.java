package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.blastdetailprintcustomization.BlastDetailPrintCustomizationQueries;
import com.blastvibrations.jpa.orm.ExBlastDetailPrintCustomization;

@Repository
public class ExBlastDetailPrintCustomizationDaoImpl extends
	GenericDaoImpl<ExBlastDetailPrintCustomization> implements
	ExBlastDetailPrintCustomizationDao {

    @SuppressWarnings("unchecked")
    @Override
    public ExBlastDetailPrintCustomization findByClientId(final UUID clientId) {

	ExBlastDetailPrintCustomization exBlastDetailPrintCustomization = null;

	try {
	    exBlastDetailPrintCustomization = (ExBlastDetailPrintCustomization) getEntityManagerNamedQuery(
		    BlastDetailPrintCustomizationQueries.FIND_BY_CLIENT_ID)
		    .setParameter("clientId", clientId).getSingleResult();

	    // if (exBlastDetailPrintCustomization == null) {
	    // exBlastDetailPrintCustomization = new
	    // ExBlastDetailPrintCustomization();
	    // exBlastDetailPrintCustomization.setClientId(clientId);
	    // exBlastDetailPrintCustomization
	    // .setClientPrintCustomizationId(clientPrintCustomizationId
	    // .name());
	    // exBlastDetailPrintCustomization.setComments("");
	    // }
	} catch (final NoResultException noResultEx) {
	    logError(noResultEx.getMessage()
		    + " for Client UUID="
		    + (clientId == null ? "no client ID given?" : clientId
			    .toString()));
	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logError(
		    ex.getMessage()
			    + " for Client UUID="
			    + (clientId == null ? "no client ID given?"
				    : clientId.toString()), ex);
	}
	return exBlastDetailPrintCustomization;
    }

    @Override
    public List<ExBlastDetailPrintCustomization> findForClientList(
	    List<UUID> clientList) {

	List<ExBlastDetailPrintCustomization> exBlastDetailPrintCustomizationList = null;

	try {

	    if (clientList.size() > 0) {
		exBlastDetailPrintCustomizationList = (List<ExBlastDetailPrintCustomization>) getEntityManagerNamedQuery(
			BlastDetailPrintCustomizationQueries.FIND_FOR_CLIENT_LIST)
			.setParameter("clientIdUUIDList", clientList)
			.getResultList();
	    } else {
		exBlastDetailPrintCustomizationList = new ArrayList<ExBlastDetailPrintCustomization>();
	    }

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logError(
		    ex.getMessage()
			    + " for Client List ="
			    + (clientList == null ? "no client ID given?"
				    : clientList.toString()), ex);
	}

	return exBlastDetailPrintCustomizationList;
    }

    @Override
    public List<ExBlastDetailPrintCustomization> findForClientList(
	    String[] clientIdList) {

	List<UUID> clientUUIDList = new ArrayList<UUID>();

	if (clientIdList != null) {
	    for (int i = 0; i < clientIdList.length; i++) {
		clientUUIDList.add(UUID.fromString(clientIdList[i]));
	    }
	}

	return findForClientList(clientUUIDList);
    }
}

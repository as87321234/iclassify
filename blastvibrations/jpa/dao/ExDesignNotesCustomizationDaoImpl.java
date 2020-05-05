package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.designnotescustomization.DesignNotesCustomizationQueries;
import com.blastvibrations.jpa.orm.ExDesignNotesCustomization;

@Repository
public class ExDesignNotesCustomizationDaoImpl extends
	GenericDaoImpl<ExDesignNotesCustomization> implements
	ExDesignNotesCustomizationDao {

    @SuppressWarnings("unchecked")
    @Override
    public ExDesignNotesCustomization findCustomizationByClientId(
	    final UUID clientId) {
	ExDesignNotesCustomization exClientCustomization = null;

	try {
	    exClientCustomization = (ExDesignNotesCustomization) getEntityManagerNamedQuery(
		    DesignNotesCustomizationQueries.FIND_CUSTOMIZATION_BY_CLIENTID)
		    .setParameter("clientId", clientId).getSingleResult();

	} catch (final NoResultException noResultEx) {
	    logInfo(noResultEx.getMessage());
	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}
	return exClientCustomization;
    }

    @Override
    public List<ExDesignNotesCustomization> findForClientList(
	    List<UUID> clientList) {

	List<ExDesignNotesCustomization> exDesignNotesCustomizationList = null;

	try {

	    if (clientList.size() > 0) {
		exDesignNotesCustomizationList = (List<ExDesignNotesCustomization>) getEntityManagerNamedQuery(
			DesignNotesCustomizationQueries.FIND_CUSTOMIZATION_BY_CLIENTLIST)
			.setParameter("clientIdUUIDList", clientList)
			.getResultList();
	    } else {
		exDesignNotesCustomizationList = new ArrayList<ExDesignNotesCustomization>();
	    }

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logError(
		    ex.getMessage()
			    + " for Client List ="
			    + (clientList == null ? "no client ID given?"
				    : clientList.toString()), ex);
	}
	return exDesignNotesCustomizationList;
    }

    @Override
    public List<ExDesignNotesCustomization> findForClientList(
	    String[] clientIdList) {
	List<UUID> clientUUIDList = new ArrayList<UUID>();

	for (int i = 0; i < clientIdList.length; i++) {
	    clientUUIDList.add(UUID.fromString(clientIdList[i]));
	}
	return findForClientList(clientUUIDList);
    }

}

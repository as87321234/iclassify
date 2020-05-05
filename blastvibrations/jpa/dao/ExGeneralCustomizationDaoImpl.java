package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.generalcustomization.GeneralCustomizationQueries;
import com.blastvibrations.jpa.orm.ExGeneralCustomization;

@Repository
public class ExGeneralCustomizationDaoImpl extends
	GenericDaoImpl<ExGeneralCustomization> implements
	ExGeneralCustomizationDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<ExGeneralCustomization> findAllGeneralCustomization() {

	List<ExGeneralCustomization> exGeneralCustomizationList = null;

	try {
	    exGeneralCustomizationList = getEntityManagerNamedQuery(
		    GeneralCustomizationQueries.GENERALCUSTOMIZATION_FIND_ALL_GENERAL_CUSTOMIZATION)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exGeneralCustomizationList == null) {
	    return new ArrayList<ExGeneralCustomization>();
	} else {
	    return exGeneralCustomizationList;
	}

    }

    @Override
    public ExGeneralCustomization findCustomizationByClientId(
	    final UUID clientId) {
	ExGeneralCustomization exClientCustomization = null;

	try {
	    exClientCustomization = (ExGeneralCustomization) getEntityManagerNamedQuery(
		    GeneralCustomizationQueries.FIND_CUSTOMIZATION_BY_CLIENTID)
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
    public List<ExGeneralCustomization> findForClientList(List<UUID> clientList) {

	List<ExGeneralCustomization> exGeneralCustomizationList = null;

	try {

	    if (clientList.size() > 0) {
		exGeneralCustomizationList = (List<ExGeneralCustomization>) getEntityManagerNamedQuery(
			GeneralCustomizationQueries.FIND_CUSTOMIZATION_FOR_CLIENTLIST)
			.setParameter("clientIdUUIDList", clientList)
			.getResultList();
	    } else {
		exGeneralCustomizationList = new ArrayList<ExGeneralCustomization>();
	    }

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logError(
		    ex.getMessage()
			    + " for Client List ="
			    + (clientList == null ? "no client ID given?"
				    : clientList.toString()), ex);
	}
	return exGeneralCustomizationList;
    }

    @Override
    public List<ExGeneralCustomization> findForClientList(String[] clientIdList) {
	List<UUID> clientUUIDList = new ArrayList<UUID>();

	for (int i = 0; i < clientIdList.length; i++) {
	    clientUUIDList.add(UUID.fromString(clientIdList[i]));
	}
	return findForClientList(clientUUIDList);
    }

}

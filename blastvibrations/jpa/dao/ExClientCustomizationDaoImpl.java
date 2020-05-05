package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.clientcustomization.ClientCustomizationQueries;
import com.blastvibrations.jpa.orm.ExClientCustomization;

@Repository
public class ExClientCustomizationDaoImpl extends
	GenericDaoImpl<ExClientCustomization> implements
	ExClientCustomizationDao {

    @Override
    public ExClientCustomization findCustomizationByClientId(final UUID clientId) {

	ExClientCustomization exClientCustomization = null;

	try {
	    exClientCustomization = (ExClientCustomization) getEntityManagerNamedQuery(
		    ClientCustomizationQueries.FIND_CLIENT_HAS_CUSTOMIZATION_BY_CLIENTID)
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
    public List<ExClientCustomization> findForClientList(List<UUID> clientList) {

	List<ExClientCustomization> exClientCustomizationList = null;

	try {

	    if (clientList.size() > 0) {
		exClientCustomizationList = (List<ExClientCustomization>) getEntityManagerNamedQuery(
			ClientCustomizationQueries.FIND_CLIENT_HAS_CUSTOMIZATION_FOR_CLIENTLIST)
			.setParameter("clientIdUUIDList", clientList)
			.getResultList();
	    } else {
		exClientCustomizationList = new ArrayList<ExClientCustomization>();
	    }

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logError(
		    ex.getMessage()
			    + " for Client List ="
			    + (clientList == null ? "no client ID given?"
				    : clientList.toString()), ex);
	}
	return exClientCustomizationList;
    }

    @Override
    public List<ExClientCustomization> findForClientList(String[] clientIdList) {
	List<UUID> clientUUIDList = new ArrayList<UUID>();

	for (int i = 0; i < clientIdList.length; i++) {
	    clientUUIDList.add(UUID.fromString(clientIdList[i]));
	}
	return findForClientList(clientUUIDList);
    }

}

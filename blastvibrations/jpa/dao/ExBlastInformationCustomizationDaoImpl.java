package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.informationcustomization.InformationCustomizationQueries;
import com.blastvibrations.jpa.orm.ExBlastInformationCustomization;

@Repository
public class ExBlastInformationCustomizationDaoImpl extends
	GenericDaoImpl<ExBlastInformationCustomization> implements
	ExBlastInformationCustomizationDao {

    @SuppressWarnings("unchecked")
    @Override
    public ExBlastInformationCustomization findCustomizationByClientId(
	    final UUID clientId) {
	ExBlastInformationCustomization exClientCustomization = null;

	try {
	    exClientCustomization = (ExBlastInformationCustomization) getEntityManagerNamedQuery(
		    InformationCustomizationQueries.FIND_CUSTOMIZATION_BY_CLIENTID)
		    .setParameter("clientId", clientId).getSingleResult();

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
	return exClientCustomization;
    }

    @Override
    public List<ExBlastInformationCustomization> findForClientList(
	    List<UUID> clientList) {

	List<ExBlastInformationCustomization> exBlastInformationCustomizationList = null;

	try {
	    if (clientList.size() > 0) {
		exBlastInformationCustomizationList = (List<ExBlastInformationCustomization>) getEntityManagerNamedQuery(
			InformationCustomizationQueries.FIND_CUSTOMIZATION_FOR_CLIENTLIST)
			.setParameter("clientIdUUIDList", clientList)
			.getResultList();
	    } else {
		exBlastInformationCustomizationList = new ArrayList<ExBlastInformationCustomization>();

	    }

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logError(
		    ex.getMessage()
			    + " for Client List ="
			    + (clientList == null ? "no client ID given?"
				    : clientList.toString()), ex);
	}
	return exBlastInformationCustomizationList;
    }

    @Override
    public List<ExBlastInformationCustomization> findForClientList(
	    String[] clientIdList) {
	List<UUID> clientUUIDList = new ArrayList<UUID>();

	for (int i = 0; i < clientIdList.length; i++) {
	    clientUUIDList.add(UUID.fromString(clientIdList[i]));
	}
	return findForClientList(clientUUIDList);
    }
}

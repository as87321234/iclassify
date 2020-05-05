package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.typecustomization.TypeCustomizationQueries;
import com.blastvibrations.jpa.orm.ExBlastTypeCustomization;

@Repository
public class ExBlastTypeCustomizationDaoImpl extends
	GenericDaoImpl<ExBlastTypeCustomization> implements
	ExBlastTypeCustomizationDao {

    @SuppressWarnings("unchecked")
    @Override
    public ExBlastTypeCustomization findCustomizationByClientId(
	    final UUID clientId) {
	ExBlastTypeCustomization exClientCustomization = null;

	try {
	    exClientCustomization = (ExBlastTypeCustomization) getEntityManagerNamedQuery(
		    TypeCustomizationQueries.FIND_CUSTOMIZATION_BY_CLIENTID)
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
    public List<ExBlastTypeCustomization> findForClientList(
	    List<UUID> clientList) {

	List<ExBlastTypeCustomization> exBlastTypeCustomizationList = null;

	try {
	    if (clientList.size() > 0) {
		exBlastTypeCustomizationList = (List<ExBlastTypeCustomization>) getEntityManagerNamedQuery(
			TypeCustomizationQueries.FIND_CUSTOMIZATION_FOR_CLIENTLIST)
			.setParameter("clientIdUUIDList", clientList)
			.getResultList();
	    } else {
		exBlastTypeCustomizationList = new ArrayList<ExBlastTypeCustomization>();

	    }

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logError(
		    ex.getMessage()
			    + " for Client List ="
			    + (clientList == null ? "no client ID given?"
				    : clientList.toString()), ex);
	}
	return exBlastTypeCustomizationList;
    }

    @Override
    public List<ExBlastTypeCustomization> findForClientList(
	    String[] clientIdList) {
	List<UUID> clientUUIDList = new ArrayList<UUID>();

	for (int i = 0; i < clientIdList.length; i++) {
	    clientUUIDList.add(UUID.fromString(clientIdList[i]));
	}
	return findForClientList(clientUUIDList);
    }

}

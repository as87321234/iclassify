package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.minecustomization.MineCustomizationQueries;
import com.blastvibrations.jpa.orm.ExBlastMineCustomization;

@Repository
public class ExBlastMineCustomizationDaoImpl extends
	GenericDaoImpl<ExBlastMineCustomization> implements
	ExBlastMineCustomizationDao {

    @Override
    public ExBlastMineCustomization findCustomizationByClientId(
	    final UUID clientId) {
	ExBlastMineCustomization exClientCustomization = null;

	try {
	    exClientCustomization = (ExBlastMineCustomization) getEntityManagerNamedQuery(
		    MineCustomizationQueries.FIND_CUSTOMIZATION_BY_CLIENTID)
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
    public List<ExBlastMineCustomization> findForClientList(
	    List<UUID> clientList) {

	List<ExBlastMineCustomization> exBlastMineCustomizationList = null;

	try {

	    if (clientList.size() > 0) {
		exBlastMineCustomizationList = (List<ExBlastMineCustomization>) getEntityManagerNamedQuery(
			MineCustomizationQueries.FIND_CUSTOMIZATION_FOR_CLIENTLIST)
			.setParameter("clientIdUUIDList", clientList)
			.getResultList();
	    } else {
		exBlastMineCustomizationList = new ArrayList<ExBlastMineCustomization>();

	    }

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logError(
		    ex.getMessage()
			    + " for Client List ="
			    + (clientList == null ? "no client ID given?"
				    : clientList.toString()), ex);
	}
	return exBlastMineCustomizationList;
    }

    @Override
    public List<ExBlastMineCustomization> findForClientList(
	    String[] clientIdList) {
	List<UUID> clientUUIDList = new ArrayList<UUID>();

	for (int i = 0; i < clientIdList.length; i++) {
	    clientUUIDList.add(UUID.fromString(clientIdList[i]));
	}
	return findForClientList(clientUUIDList);
    }

}

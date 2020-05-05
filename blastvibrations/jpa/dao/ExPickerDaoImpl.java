package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.picker.PickerQueries;
import com.blastvibrations.jpa.orm.ExPicker;
import com.blastvibrations.jpa.orm.enumeration.PickerTypeEnum;

@Repository
public class ExPickerDaoImpl extends GenericDaoImpl<ExPicker> implements
	ExPickerDao {

    private static final Logger LOG = LoggerFactory
	    .getLogger(ExPickerDaoImpl.class);

    private @Autowired HttpServletRequest request;

    @SuppressWarnings("unchecked")
    @Override
    public List<ExPicker> findByClientByPickerTypeName(final UUID clientId,
	    final PickerTypeEnum pickerTypeName) {
	List<ExPicker> exPickerList = null;

	try {

	    if (clientId == null) {
		exPickerList = getEntityManagerNamedQuery(
			PickerQueries.PICKER_FIND_FOR_CLIENT_IS_NULL)
			.setParameter("pickerTypeName", pickerTypeName)
			.getResultList();
	    } else {
		exPickerList = getEntityManagerNamedQuery(
			PickerQueries.PICKER_FIND_FOR_CLIENT)
			.setParameter("clientId", clientId)
			.setParameter("pickerTypeName", pickerTypeName)
			.getResultList();
	    }

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exPickerList == null) {
	    return new ArrayList<ExPicker>();
	} else {
	    return exPickerList;
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExPicker> findExistingClientAndNullOneByPickerTypeName(
	    final UUID clientId, final PickerTypeEnum pickerTypeEnum) {
	List<ExPicker> exPickerList = null;

	try {
	    exPickerList = getEntityManagerNamedQuery(
		    PickerQueries.PICKER_FIND_FOR_EXISTING_CLIENT_AND_NULL)
		    .setParameter("clientId", clientId)
		    .setParameter("pickerTypeName", pickerTypeEnum)
		    .getResultList();
	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exPickerList == null) {
	    return new ArrayList<ExPicker>();
	} else {
	    return exPickerList;
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExPicker> findExistingPickerClientAndNullOneByPickerTypeName(
	    final UUID pickerId, final UUID clientId,
	    final PickerTypeEnum pickerTypeName) {

	List<ExPicker> exPickerList = null;

	try {
	    exPickerList = getEntityManagerNamedQuery(
		    PickerQueries.PICKER_FIND_FOR_EXISTING_PICKER_AND_CLIENT_AND_NULL)
		    .setParameter("pickerId", pickerId)
		    .setParameter("clientId", clientId)
		    .setParameter("pickerTypeName", pickerTypeName)
		    .getResultList();
	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exPickerList == null) {
	    return new ArrayList<ExPicker>();
	} else {
	    return exPickerList;
	}

    }

    @Override
    public List<ExPicker> listAll(final UUID clientId,
	    final PickerTypeEnum pickerType) {
	return findExistingClientAndNullOneByPickerTypeName(clientId,
		pickerType);
    }

    @Override
    public List<ExPicker> listAll(final String clientId,
	    final PickerTypeEnum pickerType) {
	return listAll(
		(StringUtils.isBlank(clientId) ? null
			: UUID.fromString(clientId)), pickerType);
    }

    @Override
    public ExPicker get(final UUID pickerId, final UUID clientId,
	    final PickerTypeEnum pickerType) {

	final List<ExPicker> listPickers = findExistingPickerClientAndNullOneByPickerTypeName(
		pickerId, clientId, pickerType);

	if (listPickers.size() > 1) {
	    throw new RuntimeException(
		    "Multiple pickers with that id exist, something is wrong");
	}
	if (listPickers.isEmpty()) {

	    // TODO: Andre - I changed it for a try catch there is potentilaly
	    // bad data in the EX_PICKER entity
	    // throw new RuntimeException(
	    // "No pickers with that id of that type for that client exist");

	    LOG.error("Could not get the description for pickerId="
		    + (pickerId == null ? "N/D" : pickerId.toString())
		    + ", clientId="
		    + (clientId == null ? "N/D" : clientId.toString())
		    + ", pickerEnum="
		    + (pickerType == null ? "N/D" : pickerType.name()));
	    return null;

	}
	return listPickers.get(0);
    }

    @Override
    public List<ExPicker> getConsolidatedPickers(String[] clientIdList) {

	List<UUID> clientIdListUUID = new ArrayList<UUID>();

	for (int i = 0; i < clientIdList.length; i++) {

	    clientIdListUUID.add(UUID.fromString(clientIdList[i]));

	}

	return getConsolidatedPickers(clientIdListUUID);

    }

    private List<ExPicker> getAllPickerForClientIsNull() {

	List<ExPicker> exPickerList = null;

	try {
	    exPickerList = getEntityManagerNamedQuery(
		    PickerQueries.PICKER_FIND_ALL_FOR_CLIENT_IS_NULL)
		    .getResultList();
	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exPickerList == null) {
	    return new ArrayList<ExPicker>();
	} else {
	    return exPickerList;
	}

    }

    @Override
    public List<ExPicker> getConsolidatedPickers(List<UUID> clientIdList) {

	List<ExPicker> exPickerList = null;

	try {
	    exPickerList = getEntityManagerNamedQuery(
		    PickerQueries.PICKER_FIND_FOR_CLIENT_LIST).setParameter(
		    "clientIdList", clientIdList).getResultList();

	    if (exPickerList == null) {
		exPickerList = new ArrayList<ExPicker>();
	    }

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	List<ExPicker> exPickerListSiteWide = getAllPickerForClientIsNull();

	// Consolidate Client List

	// Create a list of client picker type
	Set<PickerTypeEnum> clientPickerTypeSet = new HashSet<PickerTypeEnum>();

	for (int i = 0; i < exPickerList.size(); i++) {

	    clientPickerTypeSet.add(exPickerList.get(i).getPickerType());

	}

	// Remove site wide picker that are redefined by the client
	// and merge with client defined picker

	for (int i = 0; i < exPickerList.size(); i++) {

	    if (!clientPickerTypeSet.contains(exPickerList.get(i)
		    .getPickerType())) {
		clientPickerTypeSet.add(exPickerList.get(i).getPickerType());
	    }
	}

	return exPickerList;

    }

    @Override
    public ExPicker get(final String pickerId, final String clientId,
	    final PickerTypeEnum pickerType) {

	return get(
		(StringUtils.isBlank(pickerId) ? null
			: UUID.fromString(pickerId)),
		(StringUtils.isBlank(clientId) ? null : UUID
			.fromString(clientId)), pickerType);
    }

    @Override
    public String getDescriptionOrElse(final UUID pickerId,
	    final UUID clientId, final PickerTypeEnum pickerType,
	    final String orElse) {
	try {
	    return get(pickerId, clientId, pickerType).getDescription();
	} catch (final Throwable t) {
	    t.printStackTrace();
	    return orElse;
	}
    }

    @Override
    public String getDescriptionOrElse(final String pickerId,
	    final String clientId, final PickerTypeEnum pickerType,
	    final String orElse) {
	try {
	    return get(pickerId, clientId, pickerType).getDescription();
	} catch (final Throwable t) {
	    t.printStackTrace();
	    return orElse;
	}
    }

    @Override
    public void save(final ExPicker exPicker) {
	persist(exPicker);
    }

    @Override
    public void delete(final ExPicker exPicker) {
	delete(exPicker);
    }

    @Override
    public void delete(final String pickerId, final String clientId,
	    final PickerTypeEnum pickerType) {
	delete((StringUtils.isBlank(pickerId) ? null
		: UUID.fromString(pickerId)),
		(StringUtils.isBlank(clientId) ? null : UUID
			.fromString(clientId)), pickerType);
    }

    @Override
    public void delete(final UUID pickerId, final UUID clientId,
	    final PickerTypeEnum pickerType) {

	try {
	    final ExPicker picker = get(pickerId, clientId, pickerType);
	    delete(picker);
	} catch (final Exception ex) {
	    ex.printStackTrace();
	    LOG.error(
		    "Cannot find the ExPicker record pickerId="
			    + (pickerId == null ? "null" : pickerId.toString())
			    + " clientId="
			    + (clientId == null ? "null" : clientId.toString())
			    + " pickerType="
			    + (pickerType == null ? "null" : pickerType.name()),
		    ex);
	}

    }

    @Override
    public String getPickerNameDescription(final UUID pickerId,
	    final PickerTypeEnum pickerEnum, final UUID clientId) {

	@SuppressWarnings("unchecked")
	Map<UUID, ExPicker> exPickerMap = (Map<UUID, ExPicker>) request
		.getAttribute("DTO_PICKER");

	if (exPickerMap == null) {
	    exPickerMap = (Map<UUID, ExPicker>) request.getSession()
		    .getAttribute("DTO_PICKER");

	}

	if (pickerId == null) {
	    return "";
	}

	if (pickerId != null && exPickerMap.get(pickerId) != null) {
	    return exPickerMap.get(pickerId).getDescription() == null ? ""
		    : exPickerMap.get(pickerId).getDescription();
	}

	if (pickerId != null) {
	    try {
		final ExPicker exPicker = get(pickerId, clientId, pickerEnum);
		if (exPicker != null) {
		    return exPicker.getDescription();
		}
	    } catch (final Throwable ex) {
		LOG.error("Could not get the description for pickerId="
			+ pickerId.toString() + ", clientId=" + clientId
			+ ", pickerEnum=" + pickerEnum);
	    }
	}

	return "";
    }

}
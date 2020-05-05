package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExPicker;
import com.blastvibrations.jpa.orm.enumeration.PickerTypeEnum;

public interface ExPickerDao {

    public List<ExPicker> findAll();

    public List<ExPicker> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExPicker> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExPicker find(final Object exPickerId);

    public void delete(final Object exPickerId);

    public void deleteLogical(final ExPicker exPicker);

    public ExPicker persist(final ExPicker exPicker);

    public List<ExPicker> findByClientByPickerTypeName(UUID clientId,
	    PickerTypeEnum pickerTypeName);

    public List<ExPicker> findExistingClientAndNullOneByPickerTypeName(
	    UUID clientId, PickerTypeEnum pickerTypeEnum);

    public List<ExPicker> findExistingPickerClientAndNullOneByPickerTypeName(
	    UUID pickerId, UUID clientId, PickerTypeEnum pickerTypeName);

    public List<ExPicker> listAll(final UUID clientId,
	    final PickerTypeEnum pickerType);

    public List<ExPicker> listAll(final String clientId,
	    final PickerTypeEnum pickerType);

    public ExPicker get(final UUID pickerId, final UUID clientId,
	    final PickerTypeEnum pickerType);

    public List<ExPicker> getConsolidatedPickers(final String[] clientIdList);

    public List<ExPicker> getConsolidatedPickers(List<UUID> clientIdListUUID);

    public ExPicker get(final String pickerId, final String clientId,
	    final PickerTypeEnum pickerType);

    public String getDescriptionOrElse(final UUID pickerId,
	    final UUID clientId, final PickerTypeEnum pickerType,
	    final String orElse);

    public String getDescriptionOrElse(final String pickerId,
	    final String clientId, final PickerTypeEnum pickerType,
	    final String orElse);

    public void save(final ExPicker exPicker);

    public void delete(final ExPicker exPicker);

    public void delete(final String pickerId, final String clientId,
	    final PickerTypeEnum pickerType);

    public void delete(final UUID pickerId, final UUID clientId,
	    final PickerTypeEnum pickerTypeName);

    String getPickerNameDescription(UUID pickerId, PickerTypeEnum pickerEnum,
	    UUID clientId);

}

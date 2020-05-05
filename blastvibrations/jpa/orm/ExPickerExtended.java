package com.blastvibrations.jpa.orm;

import java.util.UUID;

import lombok.ToString;

import com.blastvibrations.jpa.annotation.Trim;
import com.blastvibrations.jpa.orm.enumeration.PickerTypeEnum;

@ToString
public class ExPickerExtended {

	ExPicker exPicker;

	public ExPickerExtended(final UUID pickerId,
			final PickerTypeEnum pickerTypeEnum) {

		exPicker = new ExPicker();

		exPicker.setPickerId(pickerId);
		exPicker.setPickerType(pickerTypeEnum);
	}

	public ExPickerExtended(final ExPicker exPicker) {
		this.exPicker = exPicker;
	}

	public void clearKey() {
		exPicker.clearKey();
	}

	public UUID getPickerId() {
		return exPicker.getPickerId();
	}

	public void setPickerId(final UUID pickerId) {
		exPicker.setPickerId(pickerId);
	}

	public UUID getClientId() {
		return exPicker.getClientId();
	}

	public void setClientId(final UUID clientId) {
		exPicker.setClientId(clientId);
	}

	public String getDescription() {
		return exPicker.getDescription();
	}

	@Trim
	public void setDescription(final String description) {
		exPicker.setDescription(description);
	}

	public PickerTypeEnum getPickerType() {
		return exPicker.getPickerType();
	}

	public void setPickerType(final PickerTypeEnum pickerType) {
		exPicker.setPickerType(pickerType);
	}

	public String getTooltip() {
		return exPicker.getTooltip();
	}

	@Trim
	public void setTooltip(final String tooltip) {
		exPicker.setTooltip(tooltip);
	}

	public String getBody() {
		return exPicker.getBody();
	}

	@Trim
	public void setBody(final String body) {
		exPicker.setBody(body);
	}

	public ExPicker getExPicker() {
		return exPicker;
	}

	public void setExPicker(final ExPicker exPicker) {
		this.exPicker = exPicker;
	}

}
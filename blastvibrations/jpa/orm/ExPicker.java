package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

import com.blastvibrations.jpa.annotation.Trim;
import com.blastvibrations.jpa.orm.enumeration.PickerTypeEnum;

/**
 * The persistent class for the ex_picker database table.
 *
 */
@Entity
@Table(name = "ex_picker")
@NamedQuery(name = "ExPicker.findAll", query = "SELECT e FROM ExPicker e")
@ToString
public class ExPicker extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.pickerId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "picker_id")
	private UUID pickerId;

	@Column(name = "client_id")
	private UUID clientId;

	private String comment;

	private String description;

	@Column(name = "picker_type")
	private PickerTypeEnum pickerType;

	private String tooltip;

	private String body;

	public ExPicker() {
	}

	public UUID getPickerId() {
		return this.pickerId;
	}

	public void setPickerId(final UUID pickerId) {
		this.pickerId = pickerId;
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(final UUID clientId) {
		this.clientId = clientId;
	}

	public String getComment() {
		return comment;
	}

	@Trim
	public void setComment(final String comment) {
		this.comment = comment;
	}

	public String getDescription() {
		return this.description;
	}

	@Trim
	public void setDescription(final String description) {
		this.description = description;
	}

	public PickerTypeEnum getPickerType() {
		return this.pickerType;
	}

	public void setPickerType(final PickerTypeEnum pickerType) {
		this.pickerType = pickerType;
	}

	public String getTooltip() {
		return this.tooltip;
	}

	@Trim
	public void setTooltip(final String tooltip) {
		this.tooltip = tooltip;
	}

	public String getBody() {
		return body;
	}

	@Trim
	public void setBody(final String body) {
		this.body = body;
	}

}
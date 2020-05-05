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

/**
 * The persistent class for the ex_blast_type_customization database table.
 *
 */
@Entity
@Table(name = "ex_blast_type_customization")
@NamedQuery(name = "ExBlastTypeCustomization.findAll", query = "SELECT e FROM ExBlastTypeCustomization e")
@ToString
public class ExBlastTypeCustomization extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.blastTypeCustomizationId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "blast_type_customization_id")
	private UUID blastTypeCustomizationId;

	@Column(name = "client_id")
	private UUID clientId;

	@Column(name = "label_logger_count")
	private String labelLoggerCount = "Enter the # of loggers";

	@Column(name = "show_logger_count")
	private boolean showLoggerCount = true;

	@Column(name = "tip_logger_count")
	private String tipLoggerCount = "Enter the # of loggers";

	public ExBlastTypeCustomization() {
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(final UUID clientId) {
		this.clientId = clientId;
	}

	public String getLabelLoggerCount() {
		return this.labelLoggerCount;
	}

	@Trim
	public void setLabelLoggerCount(final String labelLoggerCount) {
		this.labelLoggerCount = labelLoggerCount;
	}

	public boolean getShowLoggerCount() {
		return this.showLoggerCount;
	}

	public void setShowLoggerCount(final boolean showLoggerCount) {
		this.showLoggerCount = showLoggerCount;
	}

	public String getTipLoggerCount() {
		return this.tipLoggerCount;
	}

	@Trim
	public void setTipLoggerCount(final String tipLoggerCount) {
		this.tipLoggerCount = tipLoggerCount;
	}

	public UUID getBlastTypeCustomizationId() {
		return blastTypeCustomizationId;
	}

	public void setBlastTypeCustomizationId(final UUID blastTypeCustomizationId) {
		this.blastTypeCustomizationId = blastTypeCustomizationId;
	}

}
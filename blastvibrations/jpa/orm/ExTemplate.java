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
 * The persistent class for the ex_template database table.
 *
 */
@Entity
@Table(name = "ex_template")
@NamedQuery(name = "ExTemplate.findAll", query = "SELECT e FROM ExTemplate e")
@ToString
public class ExTemplate extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.templateId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "template_id")
	private UUID templateId;

	@Column(name = "client_id")
	private UUID clientId;

	private boolean enabled;

	@Column(name = "template_data")
	private String templateData;

	@Column(name = "template_name")
	private String templateName;

	@Column(name = "user_id")
	private UUID userId;

	public ExTemplate() {
	}

	public UUID getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(final UUID templateId) {
		this.templateId = templateId;
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(final UUID clientId) {
		this.clientId = clientId;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public String getTemplateData() {
		return this.templateData;
	}

	@Trim
	public void setTemplateData(final String templateData) {
		this.templateData = templateData;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	@Trim
	public void setTemplateName(final String templateName) {
		this.templateName = templateName;
	}

	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(final UUID userId) {
		this.userId = userId;
	}

}
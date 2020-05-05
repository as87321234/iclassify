package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

import com.blastvibrations.jpa.annotation.Trim;

/**
 * The persistent class for the ex_blast_detail_print_customization database
 * table.
 *
 */

@Entity
@Table(name = "ex_blast_detail_print_customization")
@NamedQuery(name = "ExBlastDetailPrintCustomization.findAll", query = "SELECT e FROM ExBlastDetailPrintCustomization e")
@ToString
public class ExBlastDetailPrintCustomization extends ExEntity implements
Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.clientPrintCustomizationId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "client_print_customization_id")
	private UUID clientPrintCustomizationId;

	@Column(name = "client_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	@Convert(disableConversion = true)
	private UUID clientId;

	private String comments;

	private String template;

	public ExBlastDetailPrintCustomization() {
	}

	public UUID getClientPrintCustomizationId() {
		return this.clientPrintCustomizationId;
	}

	public void setClientPrintCustomizationId(
			final UUID clientPrintCustomizationId) {
		this.clientPrintCustomizationId = clientPrintCustomizationId;
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(final UUID clientId) {
		this.clientId = clientId;
	}

	public String getComments() {
		return this.comments;
	}

	@Trim
	public void setComments(final String comments) {
		this.comments = comments;
	}

	public String getTemplate() {
		return template;
	}

	@Trim
	public void setTemplate(final String template) {
		this.template = template;
	}

}
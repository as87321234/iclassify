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

/**
 * The persistent class for the ex_client_user_mapping database table.
 *
 */
@Entity
@Table(name = "ex_client_user_mapping")
@NamedQuery(name = "ExClientUserMapping.findAll", query = "SELECT e FROM ExClientUserMapping e")
@ToString
public class ExClientUserMapping extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.clientUserMappingId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "client_user_mapping_id")
	private UUID clientUserMappingId;

	@Column(name = "client_id")
	private UUID clientId;

	@Column(name = "user_id")
	private UUID userId;

	public ExClientUserMapping() {
	}

	public UUID getClientUserMappingId() {
		return this.clientUserMappingId;
	}

	public void setClientUserMappingId(UUID clientUserMappingId) {
		this.clientUserMappingId = clientUserMappingId;
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

}
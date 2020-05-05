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
 * The persistent class for the ex_mailing_list database table.
 *
 */
@Entity
@Table(name = "ex_mailing_list")
@NamedQuery(name = "ExMailingList.findAll", query = "SELECT e FROM ExMailingList e")
@ToString
public class ExMailingList extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.mailingListId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "mailing_list_id")
	private UUID mailingListId;

	@Column(name = "client_id")
	private UUID clientId;

	private boolean enabled;

	@Column(name = "mailing_list_name")
	private String mailingListName;

	@Column(name = "user_id")
	private UUID userId;

	public ExMailingList() {
	}

	public UUID getMailingListId() {
		return this.mailingListId;
	}

	public void setMailingListId(final UUID mailingListId) {
		this.mailingListId = mailingListId;
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

	public String getMailingListName() {
		return this.mailingListName;
	}

	@Trim
	public void setMailingListName(final String mailingListName) {
		this.mailingListName = mailingListName;
	}

	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(final UUID userId) {
		this.userId = userId;
	}

}
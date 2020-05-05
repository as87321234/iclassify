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
 * The persistent class for the ex_mailing_list_item database table.
 *
 */
@Entity
@Table(name = "ex_mailing_list_item")
@NamedQuery(name = "ExMailingListItem.findAll", query = "SELECT e FROM ExMailingListItem e")
@ToString
public class ExMailingListItem extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.mailingListItemId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "mailing_list_item_id")
	private UUID mailingListItemId;

	@Column(name = "email_address")
	private String emailAddress;

	private boolean enabled;

	@Column(name = "mailing_list_id")
	private UUID mailingListId;

	@Column(name = "user_id")
	private UUID userId;

	public ExMailingListItem() {
	}

	public UUID getMailingListItemId() {
		return this.mailingListItemId;
	}

	public void setMailingListItemId(final UUID mailingListItemId) {
		this.mailingListItemId = mailingListItemId;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	@Trim
	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public UUID getMailingListId() {
		return this.mailingListId;
	}

	public void setMailingListId(final UUID mailingListId) {
		this.mailingListId = mailingListId;
	}

	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(final UUID userId) {
		this.userId = userId;
	}

}
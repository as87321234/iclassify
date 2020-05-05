package com.blastvibrations.jpa.orm;

import java.util.UUID;

import lombok.ToString;

import com.blastvibrations.jpa.annotation.Trim;

@ToString
public class ExMailingListExtended {

	ExMailingList exMailingList;

	public ExMailingListExtended(final ExMailingList exMailingList) {
		this.exMailingList = exMailingList;
	}

	public ExMailingList getExMailingList() {
		return exMailingList;
	}

	public void setExMailingList(final ExMailingList exMailingList) {
		this.exMailingList = exMailingList;
	}

	public UUID getMailingListId() {
		return exMailingList.getMailingListId();
	}

	public void setMailingListId(final UUID mailingListId) {
		exMailingList.setMailingListId(mailingListId);
	}

	public UUID getClientId() {
		return exMailingList.getClientId();
	}

	public void setClientId(final UUID clientId) {
		exMailingList.setClientId(clientId);
	}

	public boolean getEnabled() {
		return exMailingList.getEnabled();
	}

	public void setEnabled(final boolean enabled) {
		exMailingList.setEnabled(enabled);
	}

	public String getMailingListName() {
		return exMailingList.getMailingListName();
	}

	@Trim
	public void setMailingListName(final String mailingListName) {
		exMailingList.setMailingListName(mailingListName);
	}

	public UUID getUserId() {
		return exMailingList.getUserId();
	}

	public void setUserId(final UUID userId) {
		exMailingList.setUserId(userId);
	}

}

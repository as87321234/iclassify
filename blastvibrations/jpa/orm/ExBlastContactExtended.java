package com.blastvibrations.jpa.orm;

import java.util.List;
import java.util.UUID;

import lombok.ToString;

import com.blastvibrations.jpa.annotation.Trim;

@ToString
public class ExBlastContactExtended {

    private ExBlastContact exBlastContact;

    private boolean selected;

    public ExBlastContactExtended(final ExBlastContact exBlastContact) {

	this.exBlastContact = exBlastContact;
    }

    public UUID getBlastContactId() {
	return exBlastContact.getBlastContactId();
    }

    public void setBlastContactId(final UUID blastContactId) {
	exBlastContact.setBlastContactId(blastContactId);
    }

    public String getAddress() {
	return exBlastContact.getAddress();
    }

    @Trim
    public void setAddress(final String address) {
	exBlastContact.setAddress(address);
    }

    public List<String> getClientIds() {
	return exBlastContact.getClientIds();
    }

    @Trim
    public void setClientIds(final List<String> clientIds) {
	exBlastContact.setClientIds(clientIds);
    }

    public String getContactName() {
	return exBlastContact.getContactName();
    }

    @Trim
    public void setContactName(final String contactName) {
	exBlastContact.setContactName(contactName);
    }

    public String getEmailAddress() {
	return exBlastContact.getEmailAddress();
    }

    @Trim
    public void setEmailAddress(final String emailAddress) {
	exBlastContact.setEmailAddress(emailAddress);
    }

    public String getMobileNumber() {
	return exBlastContact.getMobileNumber();
    }

    @Trim
    public void setMobileNumber(final String mobileNumber) {
	exBlastContact.setMobileNumber(mobileNumber);
    }

    public String getPhoneNumber() {
	return exBlastContact.getPhoneNumber();
    }

    @Trim
    public void setPhoneNumber(final String phoneNumber) {
	exBlastContact.setPhoneNumber(phoneNumber);
    }

    public String getTitle() {
	return exBlastContact.getTitle();
    }

    @Trim
    public void setTitle(final String title) {
	exBlastContact.setTitle(title);
    }

    public ExBlastContact getExBlastContact() {
	return exBlastContact;
    }

    public void setExBlastContact(final ExBlastContact exBlastContact) {
	this.exBlastContact = exBlastContact;
    }

    public boolean isSelected() {
	return selected;
    }

    public void setSelected(final boolean selected) {
	this.selected = selected;
    }

    public boolean getVoiceNotificationMobileNumberFlag() {
	// TODO Auto-generated method stub
	return exBlastContact.getVoiceNotificationMobileNumberFlag();
    }

    public String getStrutVoiceNotificationMobileNumberFlag() {
	// TODO Auto-generated method stub
	return exBlastContact.getVoiceNotificationMobileNumberFlag() ? "on"
		: "off";
    }

    public void setVoiceNotificationMobileNumberFlag(
	    boolean voiceNotificationMobileNumberFlag) {
	// TODO Auto-generated method stub
	exBlastContact
		.setVoiceNotificationMobileNumberFlag(voiceNotificationMobileNumberFlag);
    }

    public boolean getVoiceNotificationPhoneNumberFlag() {

	return exBlastContact.getVoiceNotificationPhoneNumberFlag();
    }

    public String getStrutVoiceNotificationPhoneNumberFlag() {
	// TODO Auto-generated method stub
	return exBlastContact.getVoiceNotificationPhoneNumberFlag() ? "on"
		: "off";
    }

    public void setVoiceNotificationPhoneNumberFlag(
	    boolean voiceNotificationPhoneNumberFlag) {
	// TODO Auto-generated method stub
	exBlastContact
		.setVoiceNotificationPhoneNumberFlag(voiceNotificationPhoneNumberFlag);
    }

    public boolean getSmsNotificationFlag() {

	return exBlastContact.getSmsNotificationFlag();
    }

    public String getStrutsSmsNotificationFlag() {
	// TODO Auto-generated method stub
	return exBlastContact.getSmsNotificationFlag() ? "on" : "off";
    }

    public void setSmsNotificationFlag(boolean smsNotificationFlag) {
	// TODO Auto-generated method stub
	exBlastContact.setSmsNotificationFlag(smsNotificationFlag);
    }

    public boolean getEmailNotificationFlag() {

	return exBlastContact.getEmailNotificationFlag();
    }

    public String getStrutsEmailNotificationFlag() {
	// TODO Auto-generated method stub
	return exBlastContact.getEmailNotificationFlag() ? "on" : "off";
    }

    public void setEmailNotificationFlag(boolean emailNotificationFlag) {
	// TODO Auto-generated method stub
	exBlastContact.setEmailNotificationFlag(emailNotificationFlag);
    }

}
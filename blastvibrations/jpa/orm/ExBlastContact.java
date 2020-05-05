package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.blastvibrations.jpa.annotation.Trim;
import com.blastvibrations.jpa.json.JsonBinaryType;
import com.blastvibrations.jpa.json.JsonStringType;

/**
 * The persistent class for the ex_blast_contact database table.
 *
 */
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
	@TypeDef(name = "json", typeClass = JsonStringType.class) })
@Entity
@Table(name = "ex_blast_contact")
@NamedQuery(name = "ExBlastContact.findAll", query = "SELECT e FROM ExBlastContact e")
@ToString
public class ExBlastContact extends ExEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public void clearKey() {
	super.clearKey();
	this.blastContactId = null;

    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "blast_contact_id")
    private UUID blastContactId;

    private String address;

    @Type(type = "jsonb")
    @Column(name = "client_ids", columnDefinition = "jsonb")
    private List<String> clientIds;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "voice_notification_mobile_number_flag")
    private boolean voiceNotificationMobileNumberFlag;

    @Column(name = "voice_notification_phone_number_flag")
    private boolean voiceNotificationPhoneNumberFlag;

    @Column(name = "sms_notification_flag")
    private boolean smsNotificationFlag;

    @Column(name = "email_notification_flag")
    private boolean emailNotificationFlag;

    private String title;

    public ExBlastContact() {
    }

    public UUID getBlastContactId() {
	return this.blastContactId;
    }

    public void setBlastContactId(final UUID blastContactId) {
	this.blastContactId = blastContactId;
    }

    public String getAddress() {
	return this.address;
    }

    @Trim
    public void setAddress(final String address) {
	this.address = address;
    }

    public List<String> getClientIds() {
	return this.clientIds;
    }

    @Trim
    public void setClientIds(final List<String> clientIds) {
	this.clientIds = clientIds;
    }

    public String getContactName() {
	return this.contactName;
    }

    @Trim
    public void setContactName(final String contactName) {
	this.contactName = contactName;
    }

    public String getEmailAddress() {
	return this.emailAddress;
    }

    @Trim
    public void setEmailAddress(final String emailAddress) {
	this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
	return this.mobileNumber;
    }

    @Trim
    public void setMobileNumber(final String mobileNumber) {
	this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
	return this.phoneNumber;
    }

    @Trim
    public void setPhoneNumber(final String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
	return this.title;
    }

    @Trim
    public void setTitle(final String title) {
	this.title = title;
    }

    public boolean getVoiceNotificationMobileNumberFlag() {
	return voiceNotificationMobileNumberFlag;
    }

    public void setVoiceNotificationMobileNumberFlag(
	    boolean voiceNotificationMobileNumberFlag) {
	this.voiceNotificationMobileNumberFlag = voiceNotificationMobileNumberFlag;
    }

    public boolean getVoiceNotificationPhoneNumberFlag() {
	return voiceNotificationPhoneNumberFlag;
    }

    public void setVoiceNotificationPhoneNumberFlag(
	    boolean voiceNotificationPhoneNumberFlag) {
	this.voiceNotificationPhoneNumberFlag = voiceNotificationPhoneNumberFlag;
    }

    public boolean getSmsNotificationFlag() {
	return smsNotificationFlag;
    }

    public void setSmsNotificationFlag(boolean smsNotificationFlag) {
	this.smsNotificationFlag = smsNotificationFlag;
    }

    public boolean getEmailNotificationFlag() {
	return emailNotificationFlag;
    }

    public void setEmailNotificationFlag(boolean emailNotificationFlag) {
	this.emailNotificationFlag = emailNotificationFlag;
    }

}
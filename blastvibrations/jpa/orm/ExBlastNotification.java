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
 * The persistent class for the ex_blast_notification database table.
 *
 */
@Entity
@Table(name = "ex_blast_notification")
@NamedQuery(name = "ExBlastNotification.findAll", query = "SELECT e FROM ExBlastNotification e")
@ToString
public class ExBlastNotification extends ExEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String NOTIFICATION_TYPE_COMPLAINT_UPDATE = "complaint_update";
    public static final String NOTIFICATION_TYPE_COMPLAINT_RESOLUTION = "complaint_resolution";
    public static final String NOTIFICATION_TYPE_COMPLAINT_REOPEN = "complaint_reopen";
    public static final String NOTIFICATION_TYPE_INFORMATION_REQUEST_SENT = "information_request_sent";

    public static final String NOTIFICATION_TYPE_BLAST_NOTIFICATION = "notification";
    public static final String NOTIFICATION_TYPE_BLAST_NOTIFICATION_EXCEPTION = "notification_fail";
    public static final String NOTIFICATION_TYPE_BLAST_NOTIFICATION_EXCEPTION_ADDRESS = "notification_fail_email_address";
    public static final String NOTIFICATION_TYPE_BLAST_NOTIFICATION_EXCEPTION_MESSAGE = "notification_fail_message_exception";
    public static final String NOTIFICATION_TYPE_BLAST_SMS_NOTIFICATION = "SMS Notification";
    public static final String NOTIFICATION_TYPE_BLAST_VOICE_NOTIFICATION = "Voice Notification";

    @Override
    public void clearKey() {
	super.clearKey();
	this.notificationId = null;

    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "notification_id")
    private UUID notificationId;

    private String address;

    @Column(name = "blast_complaint_id")
    private UUID blastComplaintId;

    @Column(name = "blast_contact_id")
    private UUID blastContactId;

    @Column(name = "blast_request_id")
    private UUID blastRequestId;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "contact_name")
    private String contactName;

    private String message;

    @Column(name = "voice_mail_message")
    private String voiceMailMessage;

    private String type;

    public ExBlastNotification() {
    }

    public UUID getNotificationId() {
	return this.notificationId;
    }

    public void setNotificationId(final UUID notificationId) {
	this.notificationId = notificationId;
    }

    public String getAddress() {
	return this.address;
    }

    @Trim
    public void setAddress(final String address) {
	this.address = address;
    }

    public UUID getBlastComplaintId() {
	return this.blastComplaintId;
    }

    public void setBlastComplaintId(final UUID blastComplaintId) {
	this.blastComplaintId = blastComplaintId;
    }

    public UUID getBlastContactId() {
	return this.blastContactId;
    }

    public void setBlastContactId(final UUID blastContactId) {
	this.blastContactId = blastContactId;
    }

    public UUID getClientId() {
	return this.clientId;
    }

    public void setClientId(final UUID clientId) {
	this.clientId = clientId;
    }

    public String getClientName() {
	return this.clientName;
    }

    @Trim
    public void setClientName(final String clientName) {
	this.clientName = clientName;
    }

    public String getContactName() {
	return this.contactName;
    }

    @Trim
    public void setContactName(final String contactName) {
	this.contactName = contactName;
    }

    public String getMessage() {
	return this.message;
    }

    @Trim
    public void setMessage(final String message) {
	this.message = message;
    }

    public String getType() {
	return this.type;
    }

    @Trim
    public void setType(final String type) {
	this.type = type;
    }

    public UUID getBlastRequestId() {
	return blastRequestId;
    }

    public void setBlastRequestId(final UUID blastRequestId) {
	this.blastRequestId = blastRequestId;
    }

    public String getVoiceMailMessage() {
	return voiceMailMessage;
    }

    public void setVoiceMailmessage(String voiceMailMessage) {
	this.voiceMailMessage = voiceMailMessage;
    }

}
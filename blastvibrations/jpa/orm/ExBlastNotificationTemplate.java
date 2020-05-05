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
 * The persistent class for the ex_blast_notification_template database table.
 *
 */
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
	@TypeDef(name = "json", typeClass = JsonStringType.class) })
@Entity
@Table(name = "ex_blast_notification_template")
@NamedQuery(name = "ExBlastNotificationTemplate.findAll", query = "SELECT e FROM ExBlastNotificationTemplate e")
@ToString
public class ExBlastNotificationTemplate extends ExEntity implements
	Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public void clearKey() {
	super.clearKey();
	this.notificationTemplateId = null;

    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "notification_template_id")
    private UUID notificationTemplateId;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "client_name")
    private String clientName;

    private String message;

    @Column(name = "voice_mail_message")
    private String voiceMailMessage;

    @Type(type = "jsonb")
    @Column(name = "recipient_ids", columnDefinition = "jsonb")
    private List<String> recipientIds;

    private String subject;

    public ExBlastNotificationTemplate() {
    }

    public UUID getNotificationTemplateId() {
	return this.notificationTemplateId;
    }

    public void setNotificationTemplateId(final UUID notificationTemplateId) {
	this.notificationTemplateId = notificationTemplateId;
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

    public String getMessage() {
	return this.message;
    }

    @Trim
    public void setMessage(final String message) {
	this.message = message;
    }

    public List<String> getRecipientIds() {
	return this.recipientIds;
    }

    @Trim
    public void setRecipientIds(final List<String> recipientIds) {
	this.recipientIds = recipientIds;
    }

    public String getSubject() {
	return this.subject;
    }

    @Trim
    public void setSubject(final String subject) {
	this.subject = subject;
    }

    public String getVoiceMailMessage() {
	return voiceMailMessage;
    }

    @Trim
    public void setVoiceMailMessage(String voiceMailMessage) {
	this.voiceMailMessage = voiceMailMessage;
    }

}
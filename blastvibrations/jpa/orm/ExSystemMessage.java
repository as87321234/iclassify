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
 * The persistent class for the ex_system_message database table.
 *
 */
@Entity
@Table(name = "ex_system_message")
@NamedQuery(name = "ExSystemMessage.findAll", query = "SELECT e FROM ExSystemMessage e")
@ToString
public class ExSystemMessage extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.systemMessageId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "system_message_id")
	private UUID systemMessageId;

	@Column(name = "system_message")
	private String systemMessage;

	public ExSystemMessage() {
	}

	public UUID getSystemMessageId() {
		return this.systemMessageId;
	}

	public void setSystemMessageId(final UUID systemMessageId) {
		this.systemMessageId = systemMessageId;
	}

	public String getSystemMessage() {
		return this.systemMessage;
	}

	@Trim
	public void setSystemMessage(final String systemMessage) {
		this.systemMessage = systemMessage;
	}

}
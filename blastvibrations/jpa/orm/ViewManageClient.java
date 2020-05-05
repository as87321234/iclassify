package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

import com.blastvibrations.jpa.util.ReflectionUtils;

/**
 * The persistent class for the ex_client database table.
 *
 */
@ToString
@Entity
@Cacheable(false)
public class ViewManageClient extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.clientId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "client_id")
	private UUID clientId;

	private String address;

	@Column(name = "contact_person")
	private String contactPerson;

	private String description;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "email_notfication_message")
	private String emailNotficationMessage;

	@Column(name = "image_description")
	private String imageDescription;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "image_path")
	private String imagePath;

	private String message;

	@Column(name = "mic_threshold_exceedance")
	private Float micThresholdExceedance;

	@Column(name = "mic_threshold_warning")
	private Float micThresholdWarning;

	private String name;

	@Column(name = "notification_threshold_exceedance")
	private Float notificationThresholdExceedance;

	@Column(name = "notification_threshold_trigger")
	private Integer notificationThresholdTrigger;

	@Column(name = "notification_threshold_warning")
	private Float notificationThresholdWarning;

	private String phone;

	@Column(name = "preference_custom_logo")
	private boolean preferenceCustomLogo;

	@Column(name = "user_cnt")
	private Integer userCnt;

	@Column(name = "monitor_cnt")
	private Integer monitorCnt;

	@Column(name = "is_customized")
	private boolean isCustomized;

	public ViewManageClient() {
	}

	public ViewManageClient(final ViewManageClient exClient) {

		ReflectionUtils.cloneSkipNull(exClient, this, null);
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(final UUID clientId) {
		this.clientId = clientId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(final String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailNotficationMessage() {
		return this.emailNotficationMessage;
	}

	public void setEmailNotficationMessage(final String emailNotficationMessage) {
		this.emailNotficationMessage = emailNotficationMessage;
	}

	public String getImageDescription() {
		return this.imageDescription;
	}

	public void setImageDescription(final String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(final String imagePath) {
		this.imagePath = imagePath;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public Float getMicThresholdExceedance() {
		return this.micThresholdExceedance;
	}

	public void setMicThresholdExceedance(final Float micThresholdExceedance) {
		this.micThresholdExceedance = micThresholdExceedance;
	}

	public Float getMicThresholdWarning() {
		return this.micThresholdWarning;
	}

	public void setMicThresholdWarning(final Float micThresholdWarning) {
		this.micThresholdWarning = micThresholdWarning;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Float getNotificationThresholdExceedance() {
		return this.notificationThresholdExceedance;
	}

	public void setNotificationThresholdExceedance(
			final Float notificationThresholdExceedance) {
		this.notificationThresholdExceedance = notificationThresholdExceedance;
	}

	public Integer getNotificationThresholdTrigger() {
		return this.notificationThresholdTrigger;
	}

	public void setNotificationThresholdTrigger(
			final Integer notificationThresholdTrigger) {
		this.notificationThresholdTrigger = notificationThresholdTrigger;
	}

	public Float getNotificationThresholdWarning() {
		return this.notificationThresholdWarning;
	}

	public void setNotificationThresholdWarning(
			final Float notificationThresholdWarning) {
		this.notificationThresholdWarning = notificationThresholdWarning;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public boolean getPreferenceCustomLogo() {
		return this.preferenceCustomLogo;
	}

	public void setPreferenceCustomLogo(final boolean preferenceCustomLogo) {
		this.preferenceCustomLogo = preferenceCustomLogo;
	}

	public Integer getUserCnt() {
		return userCnt;
	}

	public void setUserCnt(final Integer userCnt) {
		this.userCnt = userCnt;
	}

	public Integer getMonitorCnt() {
		return monitorCnt;
	}

	public void setMonitorCnt(final Integer monitorCnt) {
		this.monitorCnt = monitorCnt;
	}

	public boolean getIsCustomized() {
		return isCustomized;
	}

	public void setIsCustomized(final boolean isCustomized) {
		this.isCustomized = isCustomized;
	}

}
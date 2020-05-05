package com.blastvibrations.jpa.orm;

import java.util.List;
import java.util.UUID;

import lombok.ToString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blastvibrations.jpa.annotation.Trim;
import com.blastvibrations.jpa.dao.ExGeneralCustomizationDao;
import com.blastvibrations.jpa.dao.ExMonitorDao;
import com.blastvibrations.jpa.dao.ExUserDao;

@Component
@ToString
public class ExClientExtended {

	/**
	 *
	 */

	@Autowired
	ExMonitorDao exMonitorDao;

	@Autowired
	ExUserDao exUserDao;

	private static final long serialVersionUID = -7661874279425169095L;

	private boolean selected = false;

	private boolean pageMonitorDetail = false;
	private boolean pageMonitorLocation = false;
	private boolean pageMonitorClient = false;

	private ExClient exClient;

	private List<ExMonitor> exMonitorIdList;

	private List<ExUser> exUserList;

	private boolean clientCustomization;

	public ExClientExtended() {
		super();
	}

	public ExClientExtended(final ExClient exClient) {

		this.exClient = exClient;

		// TODO Auto-generated constructor stub
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

	public UUID getClientId() {
		return exClient.getClientId();
	}

	public void setClientId(final UUID clientId) {
		exClient.setClientId(clientId);
	}

	public String getAddress() {
		return exClient.getAddress();
	}

	public void setAddress(final String address) {
		exClient.setAddress(address);
	}

	public String getContactPerson() {
		return exClient.getContactPerson();
	}

	@Trim
	public void setContactPerson(final String contactPerson) {
		exClient.setContactPerson(contactPerson);
	}

	public String getDescription() {
		return exClient.getDescription();
	}

	@Trim
	public void setDescription(final String description) {
		exClient.setDescription(description);
	}

	public String getEmailAddress() {
		return exClient.getEmailAddress();
	}

	@Trim
	public void setEmailAddress(final String emailAddress) {
		exClient.setEmailAddress(emailAddress);
	}

	public String getEmailNotficationMessage() {
		return exClient.getEmailNotficationMessage();
	}

	@Trim
	public void setEmailNotficationMessage(final String emailNotficationMessage) {
		exClient.setEmailNotficationMessage(emailNotficationMessage);
	}

	public boolean getEnabled() {
		return exClient.getEnabled();
	}

	public void setEnabled(final boolean enabled) {
		exClient.setEnabled(enabled);
	}

	public String getImageDescription() {
		return exClient.getImageDescription();
	}

	@Trim
	public void setImageDescription(final String imageDescription) {
		exClient.setImageDescription(imageDescription);
	}

	public String getImageName() {
		return exClient.getImageName();
	}

	@Trim
	public void setImageName(final String imageName) {
		exClient.setImageName(imageName);
	}

	public String getImagePath() {
		return exClient.getImagePath();
	}

	@Trim
	public void setImagePath(final String imagePath) {
		exClient.setImagePath(imagePath);
	}

	public String getMessage() {
		return exClient.getMessage();
	}

	@Trim
	public void setMessage(final String message) {
		exClient.setMessage(message);
	}

	public Float getMicThresholdExceedance() {
		return exClient.getMicThresholdExceedance();
	}

	public void setMicThresholdExceedance(final Float micThresholdExceedance) {
		exClient.setMicThresholdExceedance(micThresholdExceedance);
	}

	public Float getMicThresholdWarning() {
		return exClient.getMicThresholdWarning();
	}

	public void setMicThresholdWarning(final Float micThresholdWarning) {
		exClient.setMicThresholdWarning(micThresholdWarning);
	}

	public String getName() {
		return exClient.getName();
	}

	@Trim
	public void setName(final String name) {
		exClient.setName(name);
	}

	public Float getNotificationThresholdExceedance() {
		return exClient.getNotificationThresholdExceedance();
	}

	public void setNotificationThresholdExceedance(
			final Float notificationThresholdExceedance) {
		exClient.setNotificationThresholdExceedance(notificationThresholdExceedance);
	}

	public Integer getNotificationThresholdTrigger() {
		return exClient.getNotificationThresholdTrigger();
	}

	public void setNotificationThresholdTrigger(
			final Integer notificationThresholdTrigger) {
		exClient.setNotificationThresholdTrigger(notificationThresholdTrigger);
	}

	public Float getNotificationThresholdWarning() {
		return exClient.getNotificationThresholdWarning();
	}

	public void setNotificationThresholdWarning(
			final Float notificationThresholdWarning) {
		exClient.setNotificationThresholdWarning(notificationThresholdWarning);
	}

	public String getPhone() {
		return exClient.getPhone();
	}

	@Trim
	public void setPhone(final String phone) {
		exClient.setPhone(phone);
	}

	public boolean getPreferenceCustomLogo() {
		return exClient.getPreferenceCustomLogo();
	}

	public void setPreferenceCustomLogo(final boolean preferenceCustomLogo) {
		exClient.setPreferenceCustomLogo(preferenceCustomLogo);
	}

	public ExClient getExClient() {
		return exClient;
	}

	public void setExClient(final ExClient exClient) {
		this.exClient = exClient;
	}

	public List<ExMonitor> getExMonitorIdList() {
		return exMonitorIdList;
	}

	public void setExMonitorIdList(final List<ExMonitor> exMonitorIdList) {
		this.exMonitorIdList = exMonitorIdList;
	}

	public List<ExUser> getExUserList() {
		return exUserList;
	}

	public void setExUserList(final List<ExUser> exUserList) {
		this.exUserList = exUserList;
	}

	public boolean isClientCustomization() {
		return clientCustomization;
	}

	public void setClientCustomization(final boolean clientCustomization) {
		this.clientCustomization = clientCustomization;
	}

	public void loadMonitorList(final ExMonitorDao dao) {

		this.exMonitorIdList = dao.findListMonitorByClientId(getClientId());

	}

	public void loadUserList(final ExUserDao dao) {

		this.exUserList = dao.findListUserByClientId(getClientId());

	}

	public void loadIsCutomization(
			final ExGeneralCustomizationDao exGeneralCustomizationDao) {

		if (exGeneralCustomizationDao
				.findCustomizationByClientId(getClientId()) != null) {
			setClientCustomization(true);
		}
	}

	public boolean isPageMonitorDetail() {
		return pageMonitorDetail;
	}

	public boolean isPageMonitorLocation() {
		return pageMonitorLocation;
	}

	public boolean isPageMonitorClient() {
		return pageMonitorClient;
	}

	public void setPageMonitorDetail(final boolean pageMonitorDetail) {
		this.pageMonitorDetail = pageMonitorDetail;
	}

	public void setPageMonitorLocation(final boolean pageMonitorLocation) {
		this.pageMonitorLocation = pageMonitorLocation;
	}

	public void setPageMonitorClient(final boolean pageMonitorClient) {
		this.pageMonitorClient = pageMonitorClient;
	}
}

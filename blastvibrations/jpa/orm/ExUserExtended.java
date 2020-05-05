/*
 * Created on Jan 8, 2005
 */
package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.ToString;

import org.springframework.stereotype.Component;

import com.blastvibrations.jpa.annotation.Trim;
import com.blastvibrations.jpa.orm.enumeration.GroupMemberShipEnum;
import com.blastvibrations.jpa.orm.enumeration.PermissionBlastReportEnum;

/**
 * Object that represents a user session
 */
@Component
@ToString
public final class ExUserExtended implements Serializable {

	/**
	 * universal version identifier for this serializable object
	 */
	private static final long serialVersionUID = 2181790384397684918L;

	/**
	 * Client User memberships. These are the client objects that the user is
	 * associated with
	 */

	private ExUser exUser;
	private List<ExClientExtended> exClientExtendedList;
	private List<String> clientIds;
	private boolean selected;

	public ExUserExtended() {
		super();
	}

	public ExUserExtended(final ExUser exUser) {

		this.exUser = exUser;
	}

	public void defaultUser() {

		final ExUser defaultUser = new ExUser();

		defaultUser.setEnabled(true);

		// set default preferences
		defaultUser.setPreferenceDisplayAdministration(true);
		defaultUser.setPreferenceDisplayClientImage(true);
		defaultUser.setPreferenceDisplayDashboard(true);
		defaultUser.setPreferenceDisplayDownload(true);
		defaultUser.setPreferenceDisplayEngineeringReports(true);
		defaultUser.setPreferenceDisplaySystemMessage(true);
		defaultUser.setPreferenceDisplayTodaysEvents(true);
		defaultUser.setGroupMembership(GroupMemberShipEnum.GROUP_USER);
		defaultUser
				.setPermissionBlastReport(PermissionBlastReportEnum.USER_PERMISSION_BLASTREPORT_NONE);

		this.exUser = defaultUser;

	}

	public List<ExClientExtended> getExClientExtendedList() {
		return exClientExtendedList;
	}

	public void setExClientExtendedList(
			final List<ExClientExtended> exClientExtendedList) {
		this.exClientExtendedList = exClientExtendedList;
	}

	public List<String> getClientIds() {
		return clientIds;
	}

	@Trim
	public void setClientIds(final List<String> list) {
		this.clientIds = list;
	}

	public ExUser getExUser() {
		return exUser;
	}

	public void setExUser(final ExUser exUser) {
		this.exUser = exUser;
	}

	public boolean getEnabled() {
		return exUser.getEnabled();
	}

	public void setEnabled(final boolean enabled) {
		exUser.setEnabled(enabled);
	}

	public UUID getUserId() {
		return exUser.getUserId();
	}

	public void setUserId(final UUID userId) {
		exUser.setUserId(userId);
	}

	public String getEmailAddress() {
		return exUser.getEmailAddress();
	}

	@Trim
	public void setEmailAddress(final String emailAddress) {
		exUser.setEmailAddress(emailAddress);
	}

	public String getFullName() {
		return exUser.getFullName();
	}

	@Trim
	public void setFullName(final String fullName) {
		exUser.setFullName(fullName);
	}

	public GroupMemberShipEnum getGroupMembership() {
		return exUser.getGroupMembership();
	}

	public void setGroupMembership(final GroupMemberShipEnum groupMembership) {
		exUser.setGroupMembership(groupMembership);
	}

	public String getPassword() {
		return exUser.getPassword();
	}

	@Trim
	public void setPassword(final String password) {
		exUser.setPassword(password);
	}

	public PermissionBlastReportEnum getPermissionBlastReport() {
		return exUser.getPermissionBlastReport();
	}

	public void setPermissionBlastReport(
			final PermissionBlastReportEnum permissionBlastReport) {
		exUser.setPermissionBlastReport(permissionBlastReport);
	}

	public boolean getPermissionDownload() {
		return exUser.getPermissionDownload();
	}

	public void setPermissionDownload(final boolean permissionDownload) {
		exUser.setPermissionDownload(permissionDownload);
	}

	public boolean getPermissionEnableEmail() {
		return exUser.getPermissionEnableEmail();
	}

	public void setPermissionEnableEmail(final boolean permissionEnableEmail) {
		exUser.setPermissionEnableEmail(permissionEnableEmail);
	}

	public boolean getPermissionEngineeringReport() {
		return exUser.getPermissionEngineeringReport();
	}

	public void setPermissionEngineeringReport(
			final boolean permissionEngineeringReport) {
		exUser.setPermissionEngineeringReport(permissionEngineeringReport);
	}

	public boolean getPermissionViewPDF() {
		return exUser.getPermissionViewPDF();
	}

	public void setPermissionViewPDF(final boolean permissionViewPDF) {
		exUser.setPermissionViewPDF(permissionViewPDF);
	}

	public boolean getPermissionViewVibration() {
		return exUser.getPermissionViewVibration();
	}

	public void setPermissionViewVibration(final boolean permissionViewVibration) {
		exUser.setPermissionViewVibration(permissionViewVibration);
	}

	public boolean getPreferenceDisplayAdministration() {
		return exUser.getPreferenceDisplayAdministration();
	}

	public void setPreferenceDisplayAdministration(
			final boolean preferenceDisplayAdministration) {
		exUser.setPreferenceDisplayAdministration(preferenceDisplayAdministration);
	}

	public boolean getPreferenceDisplayClientImage() {
		return exUser.getPreferenceDisplayClientImage();
	}

	public void setPreferenceDisplayClientImage(
			final boolean preferenceDisplayClientImage) {
		exUser.setPreferenceDisplayClientImage(preferenceDisplayClientImage);
	}

	public boolean getPreferenceDisplayDashboard() {
		return exUser.getPreferenceDisplayDashboard();
	}

	public void setPreferenceDisplayDashboard(
			final boolean preferenceDisplayDashboard) {
		exUser.setPreferenceDisplayDashboard(preferenceDisplayDashboard);
	}

	public boolean getPreferenceDisplayDownload() {
		return exUser.getPreferenceDisplayDownload();
	}

	public void setPreferenceDisplayDownload(
			final boolean preferenceDisplayDownload) {
		exUser.setPreferenceDisplayDownload(preferenceDisplayDownload);
	}

	public boolean getPreferenceDisplayEngineeringReports() {
		return exUser.getPreferenceDisplayEngineeringReports();
	}

	public void setPreferenceDisplayEngineeringReports(
			final boolean preferenceDisplayEngineeringReports) {
		exUser.setPreferenceDisplayEngineeringReports(preferenceDisplayEngineeringReports);
	}

	public boolean getPreferenceDisplaySystemMessage() {
		return exUser.getPreferenceDisplaySystemMessage();
	}

	public void setPreferenceDisplaySystemMessage(
			final boolean preferenceDisplaySystemMessage) {
		exUser.setPreferenceDisplaySystemMessage(preferenceDisplaySystemMessage);
	}

	public boolean getPreferenceDisplayTodaysEvents() {
		return exUser.getPreferenceDisplayTodaysEvents();
	}

	public void setPreferenceDisplayTodaysEvents(
			final boolean preferenceDisplayTodaysEvents) {
		exUser.setPreferenceDisplayTodaysEvents(preferenceDisplayTodaysEvents);
	}

	public boolean getPreferenceEmailNotification() {
		return exUser.getPreferenceEmailNotification();
	}

	public void setPreferenceEmailNotification(
			final boolean preferenceEmailNotification) {
		exUser.setPreferenceEmailNotification(preferenceEmailNotification);
	}

	public boolean getPreferenceTextNotification() {
		return exUser.getPreferenceTextNotification();
	}

	public void setPreferenceTextNotification(
			final boolean preferenceTextNotification) {
		exUser.setPreferenceTextNotification(preferenceTextNotification);
	}

	public String getTextAddress() {
		return exUser.getTextAddress();
	}

	@Trim
	public void setTextAddress(final String textAddress) {
		exUser.setTextAddress(textAddress);
	}

	public Integer getUserNotificationThreshold() {
		return exUser.getUserNotificationThreshold();
	}

	public void setUserNotificationThreshold(
			final Integer userNotificationThreshold) {
		exUser.setUserNotificationThreshold(userNotificationThreshold);
	}

	public Integer getUserReportType() {
		return exUser.getUserReportType();
	}

	public void setUserReportType(final Integer userReportType) {
		exUser.setUserReportType(userReportType);
	}

	public String getUsername() {
		return exUser.getUsername();
	}

	@Trim
	public void setUsername(final String username) {
		exUser.setUsername(username);
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

	public List<ExClient> getExClientList() {

		final List<ExClient> list = new ArrayList<ExClient>();
		exClientExtendedList.forEach(c -> list.add(c.getExClient()));

		return list;
	}

}
package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

import com.blastvibrations.jpa.annotation.Trim;
import com.blastvibrations.jpa.orm.enumeration.GroupMemberShipEnum;
import com.blastvibrations.jpa.orm.enumeration.PermissionBlastReportEnum;

/**
 * The persistent class for the ex_user database table.
 *
 */

@Entity
@Table(name = "ex_user")
@NamedQueries({ @NamedQuery(name = "ExUser.findAll", query = "SELECT e FROM ExUser e") })
@ToString
public class ExUser extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.userId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "user_id")
	private UUID userId;

	@Column(name = "email_address")
	private String emailAddress;

	private boolean enabled;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "group_membership")
	private GroupMemberShipEnum groupMembership;

	private String password;

	@Column(name = "permission_blast_report")
	private PermissionBlastReportEnum permissionBlastReport;

	@Column(name = "permission_download")
	private boolean permissionDownload;

	@Column(name = "permission_enable_email")
	private boolean permissionEnableEmail;

	// TODO: ANDRE - Sent an email to MItch to confirm if those should be
	// defaulted to false or true.

	@Column(name = "permission_engineering_report")
	private boolean permissionEngineeringReport = false;

	@Column(name = "permission_view_p_d_f")
	private boolean permissionViewPDF = false;

	@Column(name = "permission_view_vibration")
	private boolean permissionViewVibration = false;

	@Column(name = "preference_display_administration")
	private boolean preferenceDisplayAdministration;

	@Column(name = "preference_display_client_image")
	private boolean preferenceDisplayClientImage;

	@Column(name = "preference_display_dashboard")
	private boolean preferenceDisplayDashboard;

	@Column(name = "preference_display_download")
	private boolean preferenceDisplayDownload;

	@Column(name = "preference_display_engineering_reports")
	private boolean preferenceDisplayEngineeringReports;

	@Column(name = "preference_display_system_message")
	private boolean preferenceDisplaySystemMessage;

	@Column(name = "preference_display_todays_events")
	private boolean preferenceDisplayTodaysEvents;

	@Column(name = "preference_email_notification")
	private boolean preferenceEmailNotification;

	@Column(name = "preference_text_notification")
	private boolean preferenceTextNotification;

	@Column(name = "text_address")
	private String textAddress;

	@Column(name = "user_notification_threshold")
	private Integer userNotificationThreshold = 0;

	@Column(name = "user_report_type")
	private Integer userReportType = 0;;

	private String username;

	public ExUser() {
	}

	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(final UUID userId) {
		this.userId = userId;
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

	public String getFullName() {
		return this.fullName;
	}

	@Trim
	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	public GroupMemberShipEnum getGroupMembership() {
		return this.groupMembership;
	}

	public void setGroupMembership(final GroupMemberShipEnum groupMembership) {
		this.groupMembership = groupMembership;
	}

	public String getPassword() {
		return this.password;
	}

	@Trim
	public void setPassword(final String password) {
		this.password = password;
	}

	public PermissionBlastReportEnum getPermissionBlastReport() {
		return this.permissionBlastReport;
	}

	public void setPermissionBlastReport(
			final PermissionBlastReportEnum permissionBlastReport) {
		this.permissionBlastReport = permissionBlastReport;
	}

	public boolean getPermissionDownload() {
		return this.permissionDownload;
	}

	public void setPermissionDownload(final boolean permissionDownload) {
		this.permissionDownload = permissionDownload;
	}

	public boolean getPermissionEnableEmail() {
		return this.permissionEnableEmail;
	}

	public void setPermissionEnableEmail(final boolean permissionEnableEmail) {
		this.permissionEnableEmail = permissionEnableEmail;
	}

	public boolean getPermissionEngineeringReport() {
		return this.permissionEngineeringReport;
	}

	public void setPermissionEngineeringReport(
			final boolean permissionEngineeringReport) {
		this.permissionEngineeringReport = permissionEngineeringReport;
	}

	public boolean getPermissionViewPDF() {
		return this.permissionViewPDF;
	}

	public void setPermissionViewPDF(final boolean permissionViewPDF) {
		this.permissionViewPDF = permissionViewPDF;
	}

	public boolean getPermissionViewVibration() {
		return this.permissionViewVibration;
	}

	public void setPermissionViewVibration(final boolean permissionViewVibration) {
		this.permissionViewVibration = permissionViewVibration;

	}

	public boolean getPreferenceDisplayAdministration() {
		return this.preferenceDisplayAdministration;
	}

	public void setPreferenceDisplayAdministration(
			final boolean preferenceDisplayAdministration) {
		this.preferenceDisplayAdministration = preferenceDisplayAdministration;
	}

	public boolean getPreferenceDisplayClientImage() {
		return this.preferenceDisplayClientImage;
	}

	public void setPreferenceDisplayClientImage(
			final boolean preferenceDisplayClientImage) {
		this.preferenceDisplayClientImage = preferenceDisplayClientImage;
	}

	public boolean getPreferenceDisplayDashboard() {
		return this.preferenceDisplayDashboard;
	}

	public void setPreferenceDisplayDashboard(
			final boolean preferenceDisplayDashboard) {
		this.preferenceDisplayDashboard = preferenceDisplayDashboard;
	}

	public boolean getPreferenceDisplayDownload() {
		return this.preferenceDisplayDownload;
	}

	public void setPreferenceDisplayDownload(
			final boolean preferenceDisplayDownload) {
		this.preferenceDisplayDownload = preferenceDisplayDownload;
	}

	public boolean getPreferenceDisplayEngineeringReports() {
		return this.preferenceDisplayEngineeringReports;
	}

	public void setPreferenceDisplayEngineeringReports(
			final boolean preferenceDisplayEngineeringReports) {
		this.preferenceDisplayEngineeringReports = preferenceDisplayEngineeringReports;
	}

	public boolean getPreferenceDisplaySystemMessage() {
		return this.preferenceDisplaySystemMessage;
	}

	public void setPreferenceDisplaySystemMessage(
			final boolean preferenceDisplaySystemMessage) {
		this.preferenceDisplaySystemMessage = preferenceDisplaySystemMessage;
	}

	public boolean getPreferenceDisplayTodaysEvents() {
		return this.preferenceDisplayTodaysEvents;
	}

	public void setPreferenceDisplayTodaysEvents(
			final boolean preferenceDisplayTodaysEvents) {
		this.preferenceDisplayTodaysEvents = preferenceDisplayTodaysEvents;
	}

	public boolean getPreferenceEmailNotification() {
		return this.preferenceEmailNotification;
	}

	public void setPreferenceEmailNotification(
			final boolean preferenceEmailNotification) {
		this.preferenceEmailNotification = preferenceEmailNotification;
	}

	public boolean getPreferenceTextNotification() {
		return this.preferenceTextNotification;
	}

	public void setPreferenceTextNotification(
			final boolean preferenceTextNotification) {
		this.preferenceTextNotification = preferenceTextNotification;
	}

	public String getTextAddress() {
		return this.textAddress;
	}

	@Trim
	public void setTextAddress(final String textAddress) {
		this.textAddress = textAddress;
	}

	public Integer getUserNotificationThreshold() {
		return this.userNotificationThreshold;
	}

	public void setUserNotificationThreshold(
			final Integer userNotificationThreshold) {
		this.userNotificationThreshold = userNotificationThreshold;
	}

	public Integer getUserReportType() {
		return this.userReportType;
	}

	public void setUserReportType(final Integer userReportType) {
		this.userReportType = userReportType;
	}

	public String getUsername() {
		return this.username;
	}

	@Trim
	public void setUsername(final String username) {
		this.username = username;
	}

}
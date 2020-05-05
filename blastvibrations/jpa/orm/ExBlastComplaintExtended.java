package com.blastvibrations.jpa.orm;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.ToString;

import com.blastvibrations.jpa.annotation.Trim;

@ToString
public class ExBlastComplaintExtended {

    /**
	 *
	 */
    private static final long serialVersionUID = 567053948087265215L;

    private ExBlastComplaint exBlastComplaint;

    public ExBlastComplaintExtended(final ExBlastComplaint exBlastComplaint) {
	this.exBlastComplaint = exBlastComplaint;
    }

    public boolean isOpen() {
	return exBlastComplaint.isOpen();
    }

    public boolean isClosed() {
	return exBlastComplaint.isClosed();
    }

    public Date getClosedDate() {
	return exBlastComplaint.getClosedDate();
    }

    public void setClosedDate(Date closedDate) {
	exBlastComplaint.setClosedDate(closedDate);
    }

    public String getClosedBy() {
	return exBlastComplaint.getClosedBy();
    }

    public void setClosedBy(String closedBy) {
	exBlastComplaint.setClosedBy(closedBy);
    }

    public String getClosedRemark() {
	return exBlastComplaint.getClosedRemark();
    }

    public void setClosedRemark(String closedRemark) {
	exBlastComplaint.setClosedRemark(closedRemark);
    }

    public UUID getBlastComplaintId() {
	return exBlastComplaint.getBlastComplaintId();
    }

    public void setBlastComplaintId(final UUID blastComplaintId) {
	exBlastComplaint.setBlastComplaintId(blastComplaintId);
    }

    public String getAddress() {
	return exBlastComplaint.getAddress();
    }

    @Trim
    public void setAddress(final String address) {

	exBlastComplaint.setAddress(address);
    }

    public UUID getBlastContactId() {

	return exBlastComplaint.getBlastContactId();
    }

    public void setBlastContactId(final UUID blastContactId) {

	exBlastComplaint.setBlastContactId(blastContactId);
    }

    public List<String> getBlastReportIds() {

	return exBlastComplaint.getBlastReportIds();
    }

    @Trim
    public void setBlastReportIds(final List<String> blastReportIds) {

	exBlastComplaint.setBlastReportIds(blastReportIds);
    }

    public UUID getClientId() {

	return exBlastComplaint.getClientId();
    }

    public void setClientId(final UUID clientId) {

	exBlastComplaint.setClientId(clientId);
    }

    public String getClientName() {

	return exBlastComplaint.getClientName();
    }

    @Trim
    public void setClientName(final String clientName) {

	exBlastComplaint.setClientName(clientName);
    }

    public Date getComplaintDate() {

	return exBlastComplaint.getComplaintDate();
    }

    public void setComplaintDate(final Date complaintDate) {

	exBlastComplaint.setComplaintDate(complaintDate);
    }

    public String getContactName() {

	return exBlastComplaint.getContactName();
    }

    @Trim
    public void setContactName(final String contactName) {

	exBlastComplaint.setContactName(contactName);
    }

    public String getDescription() {

	return exBlastComplaint.getDescription();
    }

    @Trim
    public void setDescription(final String description) {

	exBlastComplaint.setDescription(description);
    }

    public String getEmailAddress() {

	return exBlastComplaint.getEmailAddress();
    }

    @Trim
    public void setEmailAddress(final String emailAddress) {

	exBlastComplaint.setEmailAddress(emailAddress);
    }

    public Date getEndDate() {

	if (exBlastComplaint.getEndDate() != null) {
	    return exBlastComplaint.getEndDate();
	} else {
	    return new Date();
	}
    }

    public void setEndDate(final Date endDate) {

	exBlastComplaint.setEndDate(endDate);
    }

    public String getMobileNumber() {

	return exBlastComplaint.getMobileNumber();
    }

    @Trim
    public void setMobileNumber(final String mobileNumber) {

	exBlastComplaint.setMobileNumber(mobileNumber);
    }

    public String getPhoneNumber() {

	return exBlastComplaint.getPhoneNumber();
    }

    @Trim
    public void setPhoneNumber(final String phoneNumber) {

	exBlastComplaint.setPhoneNumber(phoneNumber);
    }

    public Date getStartDate() {

	if (exBlastComplaint.getStartDate() != null) {
	    return exBlastComplaint.getStartDate();
	} else {
	    return new Date();
	}

    }

    public void setStartDate(final Date startDate) {

	exBlastComplaint.setStartDate(startDate);
    }

    public String getStatus() {

	return exBlastComplaint.getStatus();
    }

    @Trim
    public void setStatus(final String status) {

	exBlastComplaint.setStatus(status);
    }

    public String getTitle() {

	return exBlastComplaint.getTitle();
    }

    @Trim
    public void setTitle(final String title) {

	exBlastComplaint.setTitle(title);
    }

    public ExBlastComplaint getExBlastComplaint() {
	return exBlastComplaint;
    }

    public void setExBlastComplaint(final ExBlastComplaint exBlastComplaint) {
	this.exBlastComplaint = exBlastComplaint;
    }

}

package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.blastvibrations.jpa.annotation.Trim;
import com.blastvibrations.jpa.json.JsonBinaryType;
import com.blastvibrations.jpa.json.JsonStringType;

/**
 * The persistent class for the ex_blast_complaint database table.
 *
 */

@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
	@TypeDef(name = "json", typeClass = JsonStringType.class) })
@Entity
@Table(name = "ex_blast_complaint")
@NamedQuery(name = "ExBlastComplaint.findAll", query = "SELECT e FROM ExBlastComplaint e")
@ToString
public class ExBlastComplaint extends ExEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String COMPLAINT_STATUS_OPEN = "open";
    public static final String COMPLAINT_STATUS_RESOLVED = "closed";

    public boolean isOpen() {
	return getStatus().equals(COMPLAINT_STATUS_OPEN);
    }

    public boolean isClosed() {
	return getStatus().equals(COMPLAINT_STATUS_RESOLVED);
    }

    @Override
    public void clearKey() {
	super.clearKey();
	this.blastComplaintId = null;

    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "blast_complaint_id")
    private UUID blastComplaintId;

    private String address;

    @Column(name = "blast_contact_id")
    @org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
    @Convert(disableConversion = true)
    private UUID blastContactId;

    @Type(type = "jsonb")
    @Column(name = "blast_report_ids", columnDefinition = "jsonb")
    @Convert(disableConversion = true)
    private List<String> blastReportIds;

    @Column(name = "client_id")
    @org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
    // @Convert(disableConversion = true)
    private UUID clientId;

    @Column(name = "client_name")
    private String clientName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "complaint_date")
    private Date complaintDate;

    @Column(name = "contact_name")
    private String contactName;

    private String description;

    @Column(name = "email_address")
    private String emailAddress;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    private String status;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "closed_date")
    private Date closedDate;

    @Column(name = "closed_by")
    private String closedBy;

    @Column(name = "closed_remark")
    private String closedRemark;

    public ExBlastComplaint() {
    }

    public UUID getBlastComplaintId() {
	return this.blastComplaintId;
    }

    public void setBlastComplaintId(final UUID blastComplaintId) {
	this.blastComplaintId = blastComplaintId;
    }

    public String getAddress() {
	return this.address;
    }

    @Trim
    public void setAddress(final String address) {
	this.address = address;
    }

    public UUID getBlastContactId() {
	return this.blastContactId;
    }

    public void setBlastContactId(final UUID blastContactId) {
	this.blastContactId = blastContactId;
    }

    public List<String> getBlastReportIds() {
	return this.blastReportIds;
    }

    @Trim
    public void setBlastReportIds(final List<String> blastReportIds) {
	this.blastReportIds = blastReportIds;
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

    public Date getComplaintDate() {
	return this.complaintDate;
    }

    public void setComplaintDate(final Date complaintDate) {
	this.complaintDate = complaintDate;
    }

    public String getContactName() {
	return this.contactName;
    }

    @Trim
    public void setContactName(final String contactName) {
	this.contactName = contactName;
    }

    public String getDescription() {
	return this.description;
    }

    @Trim
    public void setDescription(final String description) {
	this.description = description;
    }

    public String getEmailAddress() {
	return this.emailAddress;
    }

    @Trim
    public void setEmailAddress(final String emailAddress) {
	this.emailAddress = emailAddress;
    }

    public Date getEndDate() {
	return this.endDate;
    }

    public void setEndDate(final Date endDate) {
	this.endDate = endDate;
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

    public Date getStartDate() {
	return this.startDate;
    }

    public void setStartDate(final Date startDate) {
	this.startDate = startDate;
    }

    public String getStatus() {
	return this.status;
    }

    @Trim
    public void setStatus(final String status) {
	this.status = status;
    }

    public String getTitle() {
	return this.title;
    }

    @Trim
    public void setTitle(final String title) {
	this.title = title;
    }

    public Date getClosedDate() {
	return closedDate;
    }

    public void setClosedDate(Date closedDate) {
	this.closedDate = closedDate;
    }

    public String getClosedBy() {
	return closedBy;
    }

    @Trim
    public void setClosedBy(String closedBy) {
	this.closedBy = closedBy;
    }

    public String getClosedRemark() {
	return closedRemark;
    }

    @Trim
    public void setClosedRemark(String closedRemark) {
	this.closedRemark = closedRemark;
    }

}
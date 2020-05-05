package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.blastvibrations.jpa.annotation.Trim;

/**
 * The persistent class for the ex_blast_request database table.
 *
 */
@Entity
@Table(name = "ex_blast_request")
@NamedQuery(name = "ExBlastRequest.findAll", query = "SELECT e FROM ExBlastRequest e")
@ToString
public class ExBlastRequest extends ExEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String REQUEST_STATUS_OPEN = "open";
    public static final String REQUEST_STATUS_CLOSED = "closed";

    @Override
    public void clearKey() {
	super.clearKey();
	this.blastRequestId = null;

    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "blast_request_id")
    private UUID blastRequestId;

    @Column(name = "blast_report_id")
    private UUID blastReportId;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "client_name")
    private String clientName;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "is_share_event_data")
    private boolean isShareEventData;

    @Column(name = "is_share_limit_time")
    private boolean isShareLimitTime;

    @Column(name = "is_share_map")
    private boolean isShareMap;

    @Column(name = "is_share_request_description")
    private boolean isShareRequestDescription;

    @Column(name = "is_shared")
    private boolean isShared;

    @Column(name = "is_subscribe_to_events")
    private boolean isSubscribeToEvents;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_share_view_time")
    private Date lastShareViewTime;

    private String name;

    @Type(type = "jsonb")
    @Column(name = "selected_contacts", columnDefinition = "jsonb")
    @Convert(disableConversion = true)
    private List<String> selectedContacts;

    @Type(type = "jsonb")
    @Column(name = "selected_locations", columnDefinition = "jsonb")
    @Convert(disableConversion = true)
    private List<String> selectedLocations;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "share_end")
    private Date shareEnd;

    @Column(name = "share_id")
    private UUID shareId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "share_start")
    private Date shareStart;

    @Column(name = "share_view_count")
    private BigDecimal shareViewCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    private String status;

    public ExBlastRequest() {
    }

    public UUID getBlastRequestId() {
	return this.blastRequestId;
    }

    public void setBlastRequestId(final UUID blastRequestId) {
	this.blastRequestId = blastRequestId;
    }

    public UUID getBlastReportId() {
	return this.blastReportId;
    }

    public void setBlastReportId(final UUID blastReportId) {
	this.blastReportId = blastReportId;
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

    public String getDescription() {
	return this.description;
    }

    @Trim
    public void setDescription(final String description) {
	this.description = description;
    }

    public Date getEndDate() {
	return this.endDate;
    }

    public void setEndDate(final Date endDate) {
	this.endDate = endDate;
    }

    public boolean getIsShareEventData() {
	return this.isShareEventData;
    }

    public void setIsShareEventData(final boolean isShareEventData) {
	this.isShareEventData = isShareEventData;
    }

    public boolean getIsShareLimitTime() {
	return this.isShareLimitTime;
    }

    public void setIsShareLimitTime(final boolean isShareLimitTime) {
	this.isShareLimitTime = isShareLimitTime;
    }

    public boolean getIsShareMap() {
	return this.isShareMap;
    }

    public void setIsShareMap(final boolean isShareMap) {
	this.isShareMap = isShareMap;
    }

    public boolean getIsShareRequestDescription() {
	return this.isShareRequestDescription;
    }

    public void setIsShareRequestDescription(
	    final boolean isShareRequestDescription) {
	this.isShareRequestDescription = isShareRequestDescription;
    }

    public boolean getIsShared() {
	return this.isShared;
    }

    public void setIsShared(final boolean isShared) {
	this.isShared = isShared;
    }

    public Date getLastShareViewTime() {
	return this.lastShareViewTime;
    }

    public void setLastShareViewTime(final Date lastShareViewTime) {
	this.lastShareViewTime = lastShareViewTime;
    }

    public String getName() {
	return this.name;
    }

    @Trim
    public void setName(final String name) {
	this.name = name;
    }

    public List<String> getSelectedContacts() {
	return this.selectedContacts;
    }

    @Trim
    public void setSelectedContacts(final List<String> selectedContacts) {
	this.selectedContacts = selectedContacts;
    }

    public Date getShareEnd() {
	return this.shareEnd;
    }

    public void setShareEnd(final Date shareEnd) {
	this.shareEnd = shareEnd;
    }

    public UUID getShareId() {
	return this.shareId;
    }

    public void setShareId(final UUID shareId) {
	this.shareId = shareId;
    }

    public Date getShareStart() {
	return this.shareStart;
    }

    public void setShareStart(final Date shareStart) {
	this.shareStart = shareStart;
    }

    public BigDecimal getShareViewCount() {

	if (this.shareViewCount == null) {
	    return new BigDecimal("0");
	} else {
	    return this.shareViewCount;

	}
    }

    public void setShareViewCount(final BigDecimal shareViewCount) {
	this.shareViewCount = shareViewCount;
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

    public List<String> getSelectedLocations() {
	return selectedLocations;
    }

    @Trim
    public void setSelectedLocations(List<String> selectedLocations) {
	this.selectedLocations = selectedLocations;
    }

    public boolean getIsSubscribeToEvents() {
	return isSubscribeToEvents;
    }

    public void setIsSubscribeToEvents(boolean isSubscribeToEvents) {
	this.isSubscribeToEvents = isSubscribeToEvents;
    }

}
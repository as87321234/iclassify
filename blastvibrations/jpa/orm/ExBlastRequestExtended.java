package com.blastvibrations.jpa.orm;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.annotation.Trim;

public class ExBlastRequestExtended {

	private ExBlastRequest exBlastRequest;

	public ExBlastRequestExtended(final ExBlastRequest exBlastRequest) {

		this.exBlastRequest = exBlastRequest;

	}

	public UUID getBlastRequestId() {

		return exBlastRequest.getBlastRequestId();
	}

	public void setBlastRequestId(final UUID blastRequestId) {

		exBlastRequest.setBlastRequestId(blastRequestId);
	}

	public UUID getBlastReportId() {

		return exBlastRequest.getBlastReportId();
	}

	public void setBlastReportId(final UUID blastReportId) {

		exBlastRequest.setBlastReportId(blastReportId);
	}

	public UUID getClientId() {

		return exBlastRequest.getClientId();
	}

	public void setClientId(final UUID clientId) {

		exBlastRequest.setClientId(clientId);
	}

	public String getClientName() {

		return exBlastRequest.getClientName();
	}

	@Trim
	public void setClientName(final String clientName) {

		exBlastRequest.setClientName(clientName);
	}

	public String getDescription() {

		return exBlastRequest.getDescription();
	}

	@Trim
	public void setDescription(final String description) {

		exBlastRequest.setDescription(description);
	}

	public long getEndDate() {

		return exBlastRequest.getEndDate() != null ? exBlastRequest
				.getEndDate().getTime() : 0;
	}

	public void setEndDate(final Date endDate) {

		exBlastRequest.setEndDate(endDate);
	}

	public boolean getIsShareEventData() {

		return exBlastRequest.getIsShareEventData();
	}

	public void setIsShareEventData(final boolean isShareEventData) {

		exBlastRequest.setIsShareEventData(isShareEventData);
	}

	public boolean getIsShareLimitTime() {

		return exBlastRequest.getIsShareLimitTime();
	}

	public void setIsShareLimitTime(final boolean isShareLimitTime) {

		exBlastRequest.setIsShareLimitTime(isShareLimitTime);
	}

	public boolean getIsShareMap() {

		return exBlastRequest.getIsShareMap();
	}

	public void setIsShareMap(final boolean isShareMap) {

		exBlastRequest.setIsShareMap(isShareMap);
	}

	public boolean getIsShareRequestDescription() {

		return exBlastRequest.getIsShareRequestDescription();
	}

	public void setIsShareRequestDescription(
			final boolean isShareRequestDescription) {

		exBlastRequest.setIsShareRequestDescription(isShareRequestDescription);
	}

	public boolean getIsShared() {

		return exBlastRequest.getIsShared();
	}

	public void setIsShared(final boolean isShared) {

		exBlastRequest.setIsShared(isShared);
	}

	public Date getLastShareViewTime() {

		return exBlastRequest.getLastShareViewTime();
	}

	public void setLastShareViewTime(final Date lastShareViewTime) {

		exBlastRequest.setLastShareViewTime(lastShareViewTime);
	}

	public String getName() {

		return exBlastRequest.getName();
	}

	@Trim
	public void setName(final String name) {

		exBlastRequest.setName(name);
	}

	public List<String> getSelectedContacts() {

		return exBlastRequest.getSelectedContacts();
	}

	@Trim
	public void setSelectedContacts(final List<String> selectedContacts) {

		exBlastRequest.setSelectedContacts(selectedContacts);
	}

	public Date getShareEnd() {

		return exBlastRequest.getShareEnd();
	}

	public void setShareEnd(final Date shareEnd) {

		exBlastRequest.setShareEnd(shareEnd);
	}

	public UUID getShareId() {

		return exBlastRequest.getShareId();
	}

	public void setShareId(final UUID shareId) {

		exBlastRequest.setShareId(shareId);
	}

	public Date getShareStart() {

		return exBlastRequest.getShareStart();
	}

	public void setShareStart(final Date shareStart) {

		exBlastRequest.setShareStart(shareStart);
	}

	public BigDecimal getShareViewCount() {

		return exBlastRequest.getShareViewCount();
	}

	public void setShareViewCount(final BigDecimal shareViewCount) {

		exBlastRequest.setShareViewCount(shareViewCount);
	}

	public long getStartDate() {

		return exBlastRequest.getStartDate() != null ? exBlastRequest
				.getStartDate().getTime() : 0;
	}

	public void setStartDate(final Date startDate) {

		exBlastRequest.setStartDate(startDate);
	}

	public ExBlastRequest getExBlastRequest() {
		return exBlastRequest;
	}

	public void setExBlastRequest(final ExBlastRequest exBlastRequest) {
		this.exBlastRequest = exBlastRequest;
	}

	public String getStatus() {

		return exBlastRequest.getStatus();
	}

	@Trim
	public void setStatus(final String status) {

		exBlastRequest.setStatus(status);
	}

	public boolean isBlastReportComplaint() {
		return (this.getBlastRequestId() != null) ? true : false;
	}

	public boolean hasShareExpired() {

		return this.getIsShared()
				&& this.getShareEnd() != null
				&& this.getShareEnd().before(
						new Timestamp(System.currentTimeMillis()));
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 3710817580003349127L;

}

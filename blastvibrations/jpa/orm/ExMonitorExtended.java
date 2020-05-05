package com.blastvibrations.jpa.orm;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.ToString;

import com.blastvibrations.jpa.annotation.Trim;
import com.vividsolutions.jts.geom.Point;

@ToString
public class ExMonitorExtended {

	ExMonitor exMonitor;

	boolean selected = false;

	String locationDescription = "";

	public ExMonitorExtended(final ExMonitor exMonitor) {

		this.exMonitor = exMonitor;
	}

	public ExMonitorExtended() {
	}

	public ExMonitor getExMonitor() {
		return exMonitor;
	}

	public void setExMonitor(final ExMonitor exMonitor) {
		this.exMonitor = exMonitor;
	}

	public UUID getMonitorId() {
		return exMonitor.getMonitorId();
	}

	public void setMonitorId(final UUID monitorId) {
		exMonitor.setMonitorId(monitorId);
	}

	public UUID getClientId() {
		return exMonitor.getClientId();
	}

	public void setClientId(final UUID clientId) {
		exMonitor.setClientId(clientId);
	}

	public String getClientName() {
		return exMonitor.getClientName();
	}

	@Trim
	public void setClientName(final String clientName) {
		exMonitor.setClientName(clientName);
	}

	public String getDescription() {
		return exMonitor.getDescription();
	}

	@Trim
	public void setDescription(final String description) {
		exMonitor.setDescription(description);
	}

	public BigDecimal getElevation() {
		return exMonitor.getElevation();
	}

	public void setElevation(final BigDecimal elevation) {
		exMonitor.setElevation(elevation);
	}

	public Point getGeom() {
		return exMonitor.getGeom();
	}

	public void setGeom(final Point geom) {
		exMonitor.setGeom(geom);
	}

	public String getImageName() {
		return exMonitor.getImageName();
	}

	@Trim
	public void setImageName(final String imageName) {
		exMonitor.setImageName(imageName);
	}

	public BigDecimal getLatitude() {
		return exMonitor.getLatitude();
	}

	public void setLatitude(final BigDecimal latitude) {
		exMonitor.setLatitude(latitude);
	}

	public UUID getLocationId() {
		return exMonitor.getLocationId();
	}

	public void setLocationId(final UUID locationId) {
		exMonitor.setLocationId(locationId);
	}

	public BigDecimal getLongitude() {
		return exMonitor.getLongitude();
	}

	public void setLongitude(final BigDecimal longitude) {
		exMonitor.setLongitude(longitude);
	}

	public String getUnitSerialNumber() {
		return exMonitor.getUnitSerialNumber();
	}

	@Trim
	public void setUnitSerialNumber(final String unitSerialNumber) {
		exMonitor.setUnitSerialNumber(unitSerialNumber);
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	@Trim
	public void setLocationDescription(final String locationDescription) {
		this.locationDescription = locationDescription;
	}

}

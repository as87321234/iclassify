package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.math.BigDecimal;
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
import com.vividsolutions.jts.geom.Point;

/**
 * The persistent class for the ex_monitor database table.
 *
 */
@Entity
@Table(name = "ex_monitor")
@NamedQuery(name = "ExMonitor.findAll", query = "SELECT e FROM ExMonitor e")
@ToString
public class ExMonitor extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.monitorId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "monitor_id")
	private UUID monitorId;

	@Column(name = "client_id")
	private UUID clientId;

	@Column(name = "client_name")
	private String clientName;

	private String description;

	private BigDecimal elevation;

	private Point geom;

	@Column(name = "image_name")
	private String imageName;

	private BigDecimal latitude;

	@Column(name = "location_id")
	private UUID locationId;

	private BigDecimal longitude;

	@Column(name = "unit_serial_number")
	private String unitSerialNumber;

	public ExMonitor() {
	}

	public UUID getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(final UUID monitorId) {
		this.monitorId = monitorId;
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

	public BigDecimal getElevation() {
		return this.elevation;
	}

	public void setElevation(final BigDecimal elevation) {
		this.elevation = elevation;
	}

	public Point getGeom() {
		return this.geom;
	}

	public void setGeom(final Point geom) {
		this.geom = geom;
	}

	public String getImageName() {
		return this.imageName;
	}

	@Trim
	public void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(final BigDecimal latitude) {
		this.latitude = latitude;
	}

	public UUID getLocationId() {
		return this.locationId;
	}

	public void setLocationId(final UUID locationId) {
		this.locationId = locationId;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(final BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getUnitSerialNumber() {
		return this.unitSerialNumber;
	}

	@Trim
	public void setUnitSerialNumber(final String unitSerialNumber) {
		this.unitSerialNumber = unitSerialNumber;
	}

}
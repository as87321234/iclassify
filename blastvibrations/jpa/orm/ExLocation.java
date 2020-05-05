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
 * The persistent class for the ex_location database table.
 *
 */
@Entity
@Table(name = "ex_location")
@NamedQuery(name = "ExLocation.findAll", query = "SELECT e FROM ExLocation e")
@ToString
public class ExLocation extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.locationId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "location_id")
	private UUID locationId;

	private String address;

	private BigDecimal elevation;

	private boolean enabled;

	private Point geom;

	@Column(name = "image_description")
	private String imageDescription;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "image_path")
	private String imagePath;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String name;

	public ExLocation() {
	}

	public UUID getLocationId() {
		return this.locationId;
	}

	public void setLocationId(final UUID locationId) {
		this.locationId = locationId;
	}

	public String getAddress() {
		return this.address;
	}

	@Trim
	public void setAddress(final String address) {
		this.address = address;
	}

	public BigDecimal getElevation() {
		return this.elevation;
	}

	public void setElevation(final BigDecimal elevation) {
		this.elevation = elevation;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public Point getGeom() {
		return this.geom;
	}

	public void setGeom(final Point geom) {
		this.geom = geom;
	}

	public String getImageDescription() {
		return this.imageDescription;
	}

	@Trim
	public void setImageDescription(final String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public String getImageName() {
		return this.imageName;
	}

	@Trim
	public void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	@Trim
	public void setImagePath(final String imagePath) {
		this.imagePath = imagePath;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(final BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(final BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return this.name;
	}

	@Trim
	public void setName(final String name) {
		this.name = name;
	}

}
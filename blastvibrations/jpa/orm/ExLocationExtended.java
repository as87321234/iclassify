package com.blastvibrations.jpa.orm;

import java.math.BigDecimal;
import java.util.UUID;

import com.blastvibrations.jpa.annotation.Trim;
import com.vividsolutions.jts.geom.Point;

public class ExLocationExtended {

	ExLocation exLocation;

	public ExLocationExtended(final ExLocation exLocation) {
		this.exLocation = exLocation;
	}

	public ExLocationExtended() {
		// TODO Auto-generated constructor stub
	}

	public ExLocation getExLocation() {
		return exLocation;
	}

	public void setExLocation(final ExLocation exLocation) {
		this.exLocation = exLocation;
	}

	@Override
	public String toString() {
		return exLocation.toString();
	}

	public UUID getLocationId() {
		return exLocation.getLocationId();
	}

	public void setLocationId(final UUID locationId) {
		exLocation.setLocationId(locationId);
	}

	public String getAddress() {
		return exLocation.getAddress();
	}

	@Trim
	public void setAddress(final String address) {
		exLocation.setAddress(address);
	}

	public BigDecimal getElevation() {
		return exLocation.getElevation();
	}

	public void setElevation(final BigDecimal elevation) {
		exLocation.setElevation(elevation);
	}

	public boolean getEnabled() {
		return exLocation.getEnabled();
	}

	public void setEnabled(final boolean enabled) {
		exLocation.setEnabled(enabled);
	}

	public Point getGeom() {
		return exLocation.getGeom();
	}

	public void setGeom(final Point geom) {
		exLocation.setGeom(geom);
	}

	public String getImageDescription() {
		return exLocation.getImageDescription();
	}

	@Trim
	public void setImageDescription(final String imageDescription) {
		exLocation.setImageDescription(imageDescription);
	}

	public String getImageName() {
		return exLocation.getImageName();
	}

	@Trim
	public void setImageName(final String imageName) {
		exLocation.setImageName(imageName);
	}

	public String getImagePath() {
		return exLocation.getImagePath();
	}

	@Trim
	public void setImagePath(final String imagePath) {
		exLocation.setImagePath(imagePath);
	}

	public BigDecimal getLatitude() {
		return exLocation.getLatitude();
	}

	public void setLatitude(final BigDecimal latitude) {
		exLocation.setLatitude(latitude);
	}

	public BigDecimal getLongitude() {
		return exLocation.getLongitude();
	}

	public void setLongitude(final BigDecimal longitude) {
		exLocation.setLongitude(longitude);
	}

	public String getName() {
		return exLocation.getName();
	}

	@Trim
	public void setName(final String name) {
		exLocation.setName(name);
	}

}
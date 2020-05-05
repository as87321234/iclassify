package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
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
 * The persistent class for the ex_regression_data database table.
 *
 */
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
		@TypeDef(name = "json", typeClass = JsonStringType.class) })
@Entity
@Table(name = "ex_regression_data")
@NamedQuery(name = "ExRegressionData.findAll", query = "SELECT e FROM ExRegressionData e")
@ToString
public class ExRegressionData extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.regressionId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "regression_id")
	private UUID regressionId;

	@Column(name = "client_id")
	private UUID clientId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	private Date endDate = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated")
	private Date lastUpdated = new Date();

	private String name = "";

	@Type(type = "jsonb")
	@Column(name = "selected_reports_to_events", columnDefinition = "jsonb")
	private Map<String, ArrayList<String>> selectedReportsToEvents;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate = new Date();

	@Column(name = "user_id")
	private UUID userId;

	public ExRegressionData() {
	}

	public UUID getRegressionId() {
		return this.regressionId;
	}

	public void setRegressionId(final UUID regressionId) {
		this.regressionId = regressionId;
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(final UUID clientId) {
		this.clientId = clientId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(final Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getName() {
		return this.name;
	}

	@Trim
	public void setName(final String name) {
		this.name = name;
	}

	public Map<String, ArrayList<String>> getSelectedReportsToEvents() {
		return this.selectedReportsToEvents;
	}

	public void setSelectedReportsToEvents(
			final Map<String, ArrayList<String>> selectedReportsToEvents) {
		this.selectedReportsToEvents = selectedReportsToEvents;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	public UUID getUserId() {
		return this.userId;
	}

	public void setUserId(final UUID userId) {
		this.userId = userId;
	}

}
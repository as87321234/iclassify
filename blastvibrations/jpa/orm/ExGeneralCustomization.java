package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
 * The persistent class for the ex_general_customization database table.
 *
 */

@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
		@TypeDef(name = "json", typeClass = JsonStringType.class) })
@Entity
@Table(name = "ex_general_customization")
@NamedQuery(name = "ExGeneralCustomization.findAll", query = "SELECT e FROM ExGeneralCustomization e")
@ToString
public class ExGeneralCustomization extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.generalCustomizationId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "general_customization_id")
	private UUID generalCustomizationId;

	@Column(name = "client_id")
	private UUID clientId;

	@Column(name = "auto_populate_elevation")
	private boolean autoPopulateElevation = true;

	@Type(type = "jsonb")
	@Column(name = "blast_categories", columnDefinition = "jsonb")
	private List<String> blastCategories;

	@Column(name = "blast_report_print_template")
	private String blastReportPrintTemplate = "";

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "default_time")
	private Date defaultTime;

	@Column(name = "format_blast_number")
	private String formatBlastNumber = "";

	@Column(name = "label_bench")
	private String labelBench = "Bench";

	@Column(name = "label_blast_number")
	private String labelBlastNumber = "Blast Number";

	@Column(name = "label_description")
	private String labelDescription = "Description";

	@Column(name = "label_location")
	private String labelLocation = "Blast Location";

	@Column(name = "label_name")
	private String labelName = "Name";

	@Column(name = "label_quarry_site")
	private String labelQuarrySite = "Quarry site";

	@Column(name = "measurement_system")
	private String measurementSystem = "MeasureSystemMetric";

	@Column(name = "name_strategy")
	private String nameStrategy = "";

	@Column(name = "show_bench")
	private boolean showBench = true;

	@Column(name = "show_blast_number")
	private boolean showBlastNumber = true;

	@Column(name = "show_description")
	private boolean showDescription = true;

	@Column(name = "show_location")
	private boolean showLocation = true;

	@Column(name = "show_name")
	private boolean showName = true;

	@Column(name = "show_quarry_site")
	private boolean showQuarrySite = false;

	@Column(name = "surface_p_p_v_strategy")
	private String surfacePPVStrategy = "CopperCliff";

	@Column(name = "tip_bench")
	private String tipBench = "Bench";

	@Column(name = "tip_blast_number")
	private String tipBlastNumber = "Input blast number corresponding to this blast";

	@Column(name = "tip_description")
	private String tipDescription = "Input optional description of this blast";

	@Column(name = "tip_location")
	private String tipLocation = "Blast Location";

	@Column(name = "tip_name")
	private String tipName = "Input name of this blast";

	@Column(name = "tip_quarry_site")
	private String tipQuarrySite = "Enter a quarry site";

	public ExGeneralCustomization() {
	}

	public UUID getGeneralCustomizationId() {
		return generalCustomizationId;
	}

	public void setGeneralCustomizationId(final UUID generalCustomizationId) {
		this.generalCustomizationId = generalCustomizationId;
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(final UUID clientId) {
		this.clientId = clientId;
	}

	public boolean getAutoPopulateElevation() {
		return this.autoPopulateElevation;
	}

	public void setAutoPopulateElevation(final boolean autoPopulateElevation) {
		this.autoPopulateElevation = autoPopulateElevation;
	}

	public List<String> getBlastCategories() {
		return this.blastCategories;
	}

	@Trim
	public void setBlastCategories(final List<String> blastCategories) {
		this.blastCategories = blastCategories;
	}

	public String getBlastReportPrintTemplate() {
		return this.blastReportPrintTemplate;
	}

	public void setBlastReportPrintTemplate(
			final String blastReportPrintTemplate) {
		this.blastReportPrintTemplate = blastReportPrintTemplate;
	}

	public Date getDefaultTime() {
		return this.defaultTime;
	}

	public void setDefaultTime(final Date defaultTime) {
		this.defaultTime = defaultTime;
	}

	public String getFormatBlastNumber() {
		return this.formatBlastNumber;
	}

	@Trim
	public void setFormatBlastNumber(final String formatBlastNumber) {
		this.formatBlastNumber = formatBlastNumber;
	}

	public String getLabelBench() {
		return this.labelBench;
	}

	@Trim
	public void setLabelBench(final String labelBench) {
		this.labelBench = labelBench;
	}

	public String getLabelBlastNumber() {
		return this.labelBlastNumber;
	}

	@Trim
	public void setLabelBlastNumber(final String labelBlastNumber) {
		this.labelBlastNumber = labelBlastNumber;
	}

	public String getLabelDescription() {
		return this.labelDescription;
	}

	@Trim
	public void setLabelDescription(final String labelDescription) {
		this.labelDescription = labelDescription;
	}

	public String getLabelLocation() {
		return this.labelLocation;
	}

	@Trim
	public void setLabelLocation(final String labelLocation) {
		this.labelLocation = labelLocation;
	}

	public String getLabelName() {
		return this.labelName;
	}

	@Trim
	public void setLabelName(final String labelName) {
		this.labelName = labelName;
	}

	public String getLabelQuarrySite() {
		return this.labelQuarrySite;
	}

	@Trim
	public void setLabelQuarrySite(final String labelQuarrySite) {
		this.labelQuarrySite = labelQuarrySite;
	}

	public String getMeasurementSystem() {
		return this.measurementSystem;
	}

	@Trim
	public void setMeasurementSystem(final String measurementSystem) {
		this.measurementSystem = measurementSystem;
	}

	public String getNameStrategy() {
		return this.nameStrategy;
	}

	@Trim
	public void setNameStrategy(final String nameStrategy) {
		this.nameStrategy = nameStrategy;
	}

	public boolean getShowBench() {
		return this.showBench;
	}

	public void setShowBench(final boolean showBench) {
		this.showBench = showBench;
	}

	public boolean getShowBlastNumber() {
		return this.showBlastNumber;
	}

	public void setShowBlastNumber(final boolean showBlastNumber) {
		this.showBlastNumber = showBlastNumber;
	}

	public boolean getShowDescription() {
		return this.showDescription;
	}

	public void setShowDescription(final boolean showDescription) {
		this.showDescription = showDescription;
	}

	public boolean getShowLocation() {
		return this.showLocation;
	}

	public void setShowLocation(final boolean showLocation) {
		this.showLocation = showLocation;
	}

	public boolean getShowName() {
		return this.showName;
	}

	public void setShowName(final boolean showName) {
		this.showName = showName;
	}

	public boolean getShowQuarrySite() {
		return this.showQuarrySite;
	}

	public void setShowQuarrySite(final boolean showQuarrySite) {
		this.showQuarrySite = showQuarrySite;
	}

	public String getSurfacePPVStrategy() {
		return this.surfacePPVStrategy;
	}

	@Trim
	public void setSurfacePPVStrategy(final String surfacePPVStrategy) {
		this.surfacePPVStrategy = surfacePPVStrategy;
	}

	public String getTipBench() {
		return this.tipBench;
	}

	@Trim
	public void setTipBench(final String tipBench) {
		this.tipBench = tipBench;
	}

	public String getTipBlastNumber() {
		return this.tipBlastNumber;
	}

	@Trim
	public void setTipBlastNumber(final String tipBlastNumber) {
		this.tipBlastNumber = tipBlastNumber;
	}

	public String getTipDescription() {
		return this.tipDescription;
	}

	@Trim
	public void setTipDescription(final String tipDescription) {
		this.tipDescription = tipDescription;
	}

	public String getTipLocation() {
		return this.tipLocation;
	}

	@Trim
	public void setTipLocation(final String tipLocation) {
		this.tipLocation = tipLocation;
	}

	public String getTipName() {
		return this.tipName;
	}

	@Trim
	public void setTipName(final String tipName) {
		this.tipName = tipName;
	}

	public String getTipQuarrySite() {
		return this.tipQuarrySite;
	}

	@Trim
	public void setTipQuarrySite(final String tipQuarrySite) {
		this.tipQuarrySite = tipQuarrySite;
	}

}
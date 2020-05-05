package com.blastvibrations.jpa.orm;

import java.io.Serializable;
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

/**
 * The persistent class for the ex_design_notes_customization database table.
 *
 */
@Entity
@Table(name = "ex_design_notes_customization")
@NamedQuery(name = "ExDesignNotesCustomization.findAll", query = "SELECT e FROM ExDesignNotesCustomization e")
@ToString
public class ExDesignNotesCustomization extends ExEntity implements
	Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public void clearKey() {
	super.clearKey();
	this.designNotesCustomizationId = null;

    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "design_notes_customization_id")
    private UUID designNotesCustomizationId;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "custom1_label")
    private String labelCustom1 = "Custom 1";

    @Column(name = "custom2_label")
    private String labelCustom2 = "Custom 2";

    @Column(name = "custom3_label")
    private String labelCustom3 = "Custom 3";

    @Column(name = "label_blast_detail_comments_picker")
    private String labelBlastDetailCommentsPicker = "Blast detail comments picker";

    @Column(name = "label_blaster_name")
    private String labelBlasterName = "Blaster Name";

    @Column(name = "label_blaster_name_picker")
    private String labelBlasterNamePicker = "Blaster Name";

    @Column(name = "label_completed_by")
    private String labelCompletedBy = "Completed By";

    @Column(name = "label_estimated_p_p_v")
    private String labelEstimatedPPV = "PPV value estimated to be";

    @Column(name = "label_estimated_surface_p_p_v")
    private String labelEstimatedSurfacePPV = "PPV value on Surface estimated to be";

    @Column(name = "label_flyrock")
    private String labelFlyrock = "Flyrock";

    @Column(name = "label_fragmentation")
    private String labelFragmentation = "Fragmentation";

    @Column(name = "label_muckpile_configuration")
    private String labelMuckpileConfiguration = "Muckpile Configuration";

    @Column(name = "label_notes")
    private String labelNotes = "Notes";

    @Column(name = "label_reviewed_by")
    private String labelReviewedBy = "Reviewed By";

    @Column(name = "label_technician")
    private String labelTechnician = "Technician";

    @Column(name = "label_temperature")
    private String labelTemperature = "Temperature";

    @Column(name = "label_weather")
    private String labelWeather = "Weather";

    @Column(name = "label_wind_direction")
    private String labelWindDirection = "Wind Direction";

    @Column(name = "label_wind_velocity")
    private String labelWindVelocity = "Wind Velocity";

    @Column(name = "label_wind_velocity_picker")
    private String labelWindVelocityPicker = "Wind Velocity";

    @Column(name = "show_blast_detail_comments_picker")
    private boolean showBlastDetailCommentsPicker = true;

    @Column(name = "show_blaster_name")
    private boolean showBlasterName = true;

    @Column(name = "show_blaster_name_picker")
    private boolean showBlasterNamePicker = true;

    @Column(name = "show_completed_by")
    private boolean showCompletedBy = true;

    @Column(name = "show_custom1")
    private boolean showCustom1 = true;

    @Column(name = "show_custom2")
    private boolean showCustom2 = true;

    @Column(name = "show_custom3")
    private boolean showCustom3 = true;

    @Column(name = "show_estimated_p_p_v")
    private boolean showEstimatedPPV = false;

    @Column(name = "show_estimated_surface_p_p_v")
    private boolean showEstimatedSurfacePPV = false;

    @Column(name = "show_flyrock")
    private boolean showFlyrock = true;

    @Column(name = "show_fragmentation")
    private boolean showFragmentation = true;

    @Column(name = "show_muckpile_configuration")
    private boolean showMuckpileConfiguration = true;

    @Column(name = "show_notes")
    private boolean showNotes = true;

    @Column(name = "show_reviewed_by")
    private boolean showReviewedBy = true;

    @Column(name = "show_technician")
    private boolean showTechnician = true;

    @Column(name = "show_temperature")
    private boolean showTemperature = true;

    @Column(name = "show_weather")
    private boolean showWeather = true;

    @Column(name = "show_wind_direction")
    private boolean showWindDirection = true;

    @Column(name = "show_wind_velocity")
    private boolean showWindVelocity = true;

    @Column(name = "show_wind_velocity_picker")
    private boolean showWindVelocityPicker = false;

    @Column(name = "tip_blast_detail_comments_picker")
    private String tipBlastDetailCommentsPicker = "Use predetermined blast detail comments for printing";

    @Column(name = "tip_blaster_name")
    private String tipBlasterName = "Input name of the blaster";

    @Column(name = "tip_blaster_name_picker")
    private String tipBlasterNamePicker = "Select the name of the blaster from the list of options";

    @Column(name = "tip_completed_by")
    private String tipCompletedBy = "Input name of the individual completing this report";

    @Column(name = "tip_custom1")
    private String tipCustom1 = "Custom 1";

    @Column(name = "tip_custom2")
    private String tipCustom2 = "Custom 2";

    @Column(name = "tip_custom3")
    private String tipCustom3 = "Custom 3";

    @Column(name = "tip_estimated_p_p_v")
    private String tipEstimatedPPV = "PPV value estimated to be";

    @Column(name = "tip_estimated_surface_p_p_v")
    private String tipEstimatedSurfacePPV = "PPV value on Surface estimated to be";

    @Column(name = "tip_flyrock")
    private String tipFlyrock = "Input notes on the flyrock from the blast";

    @Column(name = "tip_fragmentation")
    private String tipFragmentation = "Input notes on the fragmentation of the blast";

    @Column(name = "tip_muckpile_configuration")
    private String tipMuckpileConfiguration = "Input notes on the muckpile configuration of the blast";

    @Column(name = "tip_notes")
    private String tipNotes = "Input any additional notes about the blast";

    @Column(name = "tip_reviewed_by")
    private String tipReviewedBy = "Input name of the individual reviewing this report";

    @Column(name = "tip_technician")
    private String tipTechnician = "Input name of the vibration monitoring technician";

    @Column(name = "tip_temperature")
    private String tipTemperature = "Input the temperature at the time of the blast";

    @Column(name = "tip_weather")
    private String tipWeather = "Select weatherId conditions at time of blast";

    @Column(name = "tip_wind_direction")
    private String tipWindDirection = "Input wind direction at the time of blast";

    @Column(name = "tip_wind_velocity")
    private String tipWindVelocity = "Input wind speed at the time of blast";

    @Column(name = "tip_wind_velocity_picker")
    private String tipWindVelocityPicker = "Select the wind speed at the time of blast";

    public ExDesignNotesCustomization() {
    }

    public UUID getClientId() {
	return this.clientId;
    }

    public void setClientId(final UUID clientId) {
	this.clientId = clientId;
    }

    public String getLabelCustom1() {
	return this.labelCustom1;
    }

    @Trim
    public void setLabelCustom1(final String labelCustom1) {
	this.labelCustom1 = labelCustom1;
    }

    public String getLabelCustom2() {
	return this.labelCustom2;
    }

    @Trim
    public void setLabelCustom2(final String labelCustom2) {
	this.labelCustom2 = labelCustom2;
    }

    public String getLabelCustom3() {
	return this.labelCustom3;
    }

    @Trim
    public void setLabelCustom3(final String labelCustom3) {
	this.labelCustom3 = labelCustom3;
    }

    public String getLabelBlastDetailCommentsPicker() {
	return this.labelBlastDetailCommentsPicker;
    }

    public void setLabelBlastDetailCommentsPicker(
	    final String labelBlastDetailCommentsPicker) {
	this.labelBlastDetailCommentsPicker = labelBlastDetailCommentsPicker;
    }

    public String getLabelBlasterName() {
	return this.labelBlasterName;
    }

    @Trim
    public void setLabelBlasterName(final String labelBlasterName) {
	this.labelBlasterName = labelBlasterName;
    }

    public String getLabelBlasterNamePicker() {
	return this.labelBlasterNamePicker;
    }

    @Trim
    public void setLabelBlasterNamePicker(final String labelBlasterNamePicker) {
	this.labelBlasterNamePicker = labelBlasterNamePicker;
    }

    public String getLabelCompletedBy() {
	return this.labelCompletedBy;
    }

    @Trim
    public void setLabelCompletedBy(final String labelCompletedBy) {
	this.labelCompletedBy = labelCompletedBy;
    }

    public String getLabelEstimatedPPV() {
	return this.labelEstimatedPPV;
    }

    @Trim
    public void setLabelEstimatedPPV(final String labelEstimatedPPV) {
	this.labelEstimatedPPV = labelEstimatedPPV;
    }

    public String getLabelEstimatedSurfacePPV() {
	return this.labelEstimatedSurfacePPV;
    }

    public void setLabelEstimatedSurfacePPV(
	    final String labelEstimatedSurfacePPV) {
	this.labelEstimatedSurfacePPV = labelEstimatedSurfacePPV;
    }

    public String getLabelFlyrock() {
	return this.labelFlyrock;
    }

    @Trim
    public void setLabelFlyrock(final String labelFlyrock) {
	this.labelFlyrock = labelFlyrock;
    }

    public String getLabelFragmentation() {
	return this.labelFragmentation;
    }

    @Trim
    public void setLabelFragmentation(final String labelFragmentation) {
	this.labelFragmentation = labelFragmentation;
    }

    public String getLabelMuckpileConfiguration() {
	return this.labelMuckpileConfiguration;
    }

    public void setLabelMuckpileConfiguration(
	    final String labelMuckpileConfiguration) {
	this.labelMuckpileConfiguration = labelMuckpileConfiguration;
    }

    public String getLabelNotes() {
	return this.labelNotes;
    }

    @Trim
    public void setLabelNotes(final String labelNotes) {
	this.labelNotes = labelNotes;
    }

    public String getLabelReviewedBy() {
	return this.labelReviewedBy;
    }

    @Trim
    public void setLabelReviewedBy(final String labelReviewedBy) {
	this.labelReviewedBy = labelReviewedBy;
    }

    public String getLabelTechnician() {
	return this.labelTechnician;
    }

    @Trim
    public void setLabelTechnician(final String labelTechnician) {
	this.labelTechnician = labelTechnician;
    }

    public String getLabelTemperature() {
	return this.labelTemperature;
    }

    @Trim
    public void setLabelTemperature(final String labelTemperature) {
	this.labelTemperature = labelTemperature;
    }

    public String getLabelWeather() {
	return this.labelWeather;
    }

    @Trim
    public void setLabelWeather(final String labelWeather) {
	this.labelWeather = labelWeather;
    }

    public String getLabelWindDirection() {
	return this.labelWindDirection;
    }

    @Trim
    public void setLabelWindDirection(final String labelWindDirection) {
	this.labelWindDirection = labelWindDirection;
    }

    public String getLabelWindVelocity() {
	return this.labelWindVelocity;
    }

    @Trim
    public void setLabelWindVelocity(final String labelWindVelocity) {
	this.labelWindVelocity = labelWindVelocity;
    }

    public String getLabelWindVelocityPicker() {
	return this.labelWindVelocityPicker;
    }

    @Trim
    public void setLabelWindVelocityPicker(final String labelWindVelocityPicker) {
	this.labelWindVelocityPicker = labelWindVelocityPicker;
    }

    public boolean getShowBlastDetailCommentsPicker() {
	return this.showBlastDetailCommentsPicker;
    }

    public void setShowBlastDetailCommentsPicker(
	    final boolean showBlastDetailCommentsPicker) {
	this.showBlastDetailCommentsPicker = showBlastDetailCommentsPicker;
    }

    public boolean getShowBlasterName() {
	return this.showBlasterName;
    }

    public void setShowBlasterName(final boolean showBlasterName) {
	this.showBlasterName = showBlasterName;
    }

    public boolean getShowBlasterNamePicker() {
	return this.showBlasterNamePicker;
    }

    public void setShowBlasterNamePicker(final boolean showBlasterNamePicker) {
	this.showBlasterNamePicker = showBlasterNamePicker;
    }

    public boolean getShowCompletedBy() {
	return this.showCompletedBy;
    }

    public void setShowCompletedBy(final boolean showCompletedBy) {
	this.showCompletedBy = showCompletedBy;
    }

    public boolean getShowCustom1() {
	return this.showCustom1;
    }

    public void setShowCustom1(final boolean showCustom1) {
	this.showCustom1 = showCustom1;
    }

    public boolean getShowCustom2() {
	return this.showCustom2;
    }

    public void setShowCustom2(final boolean showCustom2) {
	this.showCustom2 = showCustom2;
    }

    public boolean getShowCustom3() {
	return this.showCustom3;
    }

    public void setShowCustom3(final boolean showCustom3) {
	this.showCustom3 = showCustom3;
    }

    public boolean getShowEstimatedPPV() {
	return this.showEstimatedPPV;
    }

    public void setShowEstimatedPPV(final boolean showEstimatedPPV) {
	this.showEstimatedPPV = showEstimatedPPV;
    }

    public boolean getShowEstimatedSurfacePPV() {
	return this.showEstimatedSurfacePPV;
    }

    public void setShowEstimatedSurfacePPV(final boolean showEstimatedSurfacePPV) {
	this.showEstimatedSurfacePPV = showEstimatedSurfacePPV;
    }

    public boolean getShowFlyrock() {
	return this.showFlyrock;
    }

    public void setShowFlyrock(final boolean showFlyrock) {
	this.showFlyrock = showFlyrock;
    }

    public boolean getShowFragmentation() {
	return this.showFragmentation;
    }

    public void setShowFragmentation(final boolean showFragmentation) {
	this.showFragmentation = showFragmentation;
    }

    public boolean getShowMuckpileConfiguration() {
	return this.showMuckpileConfiguration;
    }

    public void setShowMuckpileConfiguration(
	    final boolean showMuckpileConfiguration) {
	this.showMuckpileConfiguration = showMuckpileConfiguration;
    }

    public boolean getShowNotes() {
	return this.showNotes;
    }

    public void setShowNotes(final boolean showNotes) {
	this.showNotes = showNotes;
    }

    public boolean getShowReviewedBy() {
	return this.showReviewedBy;
    }

    public void setShowReviewedBy(final boolean showReviewedBy) {
	this.showReviewedBy = showReviewedBy;
    }

    public boolean getShowTechnician() {
	return this.showTechnician;
    }

    public void setShowTechnician(final boolean showTechnician) {
	this.showTechnician = showTechnician;
    }

    public boolean getShowTemperature() {
	return this.showTemperature;
    }

    public void setShowTemperature(final boolean showTemperature) {
	this.showTemperature = showTemperature;
    }

    public boolean getShowWeather() {
	return this.showWeather;
    }

    public void setShowWeather(final boolean showWeather) {
	this.showWeather = showWeather;
    }

    public boolean getShowWindDirection() {
	return this.showWindDirection;
    }

    public void setShowWindDirection(final boolean showWindDirection) {
	this.showWindDirection = showWindDirection;
    }

    public boolean getShowWindVelocity() {
	return this.showWindVelocity;
    }

    public void setShowWindVelocity(final boolean showWindVelocity) {
	this.showWindVelocity = showWindVelocity;
    }

    public boolean getShowWindVelocityPicker() {
	return this.showWindVelocityPicker;
    }

    public void setShowWindVelocityPicker(final boolean showWindVelocityPicker) {
	this.showWindVelocityPicker = showWindVelocityPicker;
    }

    public String getTipBlastDetailCommentsPicker() {
	return this.tipBlastDetailCommentsPicker;
    }

    public void setTipBlastDetailCommentsPicker(
	    final String tipBlastDetailCommentsPicker) {
	this.tipBlastDetailCommentsPicker = tipBlastDetailCommentsPicker;
    }

    public String getTipBlasterName() {
	return this.tipBlasterName;
    }

    @Trim
    public void setTipBlasterName(final String tipBlasterName) {
	this.tipBlasterName = tipBlasterName;
    }

    public String getTipBlasterNamePicker() {
	return this.tipBlasterNamePicker;
    }

    @Trim
    public void setTipBlasterNamePicker(final String tipBlasterNamePicker) {
	this.tipBlasterNamePicker = tipBlasterNamePicker;
    }

    public String getTipCompletedBy() {
	return this.tipCompletedBy;
    }

    @Trim
    public void setTipCompletedBy(final String tipCompletedBy) {
	this.tipCompletedBy = tipCompletedBy;
    }

    public String getTipCustom1() {
	return this.tipCustom1;
    }

    @Trim
    public void setTipCustom1(final String tipCustom1) {
	this.tipCustom1 = tipCustom1;
    }

    public String getTipCustom2() {
	return this.tipCustom2;
    }

    @Trim
    public void setTipCustom2(final String tipCustom2) {
	this.tipCustom2 = tipCustom2;
    }

    public String getTipCustom3() {
	return this.tipCustom3;
    }

    @Trim
    public void setTipCustom3(final String tipCustom3) {
	this.tipCustom3 = tipCustom3;
    }

    public String getTipEstimatedPPV() {
	return this.tipEstimatedPPV;
    }

    @Trim
    public void setTipEstimatedPPV(final String tipEstimatedPPV) {
	this.tipEstimatedPPV = tipEstimatedPPV;
    }

    public String getTipEstimatedSurfacePPV() {
	return this.tipEstimatedSurfacePPV;
    }

    @Trim
    public void setTipEstimatedSurfacePPV(final String tipEstimatedSurfacePPV) {
	this.tipEstimatedSurfacePPV = tipEstimatedSurfacePPV;
    }

    public String getTipFlyrock() {
	return this.tipFlyrock;
    }

    @Trim
    public void setTipFlyrock(final String tipFlyrock) {
	this.tipFlyrock = tipFlyrock;
    }

    public String getTipFragmentation() {
	return this.tipFragmentation;
    }

    @Trim
    public void setTipFragmentation(final String tipFragmentation) {
	this.tipFragmentation = tipFragmentation;
    }

    public String getTipMuckpileConfiguration() {
	return this.tipMuckpileConfiguration;
    }

    public void setTipMuckpileConfiguration(
	    final String tipMuckpileConfiguration) {
	this.tipMuckpileConfiguration = tipMuckpileConfiguration;
    }

    public String getTipNotes() {
	return this.tipNotes;
    }

    @Trim
    public void setTipNotes(final String tipNotes) {
	this.tipNotes = tipNotes;
    }

    public String getTipReviewedBy() {
	return this.tipReviewedBy;
    }

    @Trim
    public void setTipReviewedBy(final String tipReviewedBy) {
	this.tipReviewedBy = tipReviewedBy;
    }

    public String getTipTechnician() {
	return this.tipTechnician;
    }

    @Trim
    public void setTipTechnician(final String tipTechnician) {
	this.tipTechnician = tipTechnician;
    }

    public String getTipTemperature() {
	return this.tipTemperature;
    }

    @Trim
    public void setTipTemperature(final String tipTemperature) {
	this.tipTemperature = tipTemperature;
    }

    public String getTipWeather() {
	return this.tipWeather;
    }

    @Trim
    public void setTipWeather(final String tipWeather) {
	this.tipWeather = tipWeather;
    }

    public String getTipWindDirection() {
	return this.tipWindDirection;
    }

    @Trim
    public void setTipWindDirection(final String tipWindDirection) {
	this.tipWindDirection = tipWindDirection;
    }

    public String getTipWindVelocity() {
	return this.tipWindVelocity;
    }

    @Trim
    public void setTipWindVelocity(final String tipWindVelocity) {
	this.tipWindVelocity = tipWindVelocity;
    }

    public String getTipWindVelocityPicker() {
	return this.tipWindVelocityPicker;
    }

    @Trim
    public void setTipWindVelocityPicker(final String tipWindVelocityPicker) {
	this.tipWindVelocityPicker = tipWindVelocityPicker;
    }

    public UUID getDesignNotesCustomizationId() {
	return designNotesCustomizationId;
    }

    public void setDesignNotesCustomizationId(
	    final UUID designNotesCustomizationId) {
	this.designNotesCustomizationId = designNotesCustomizationId;
    }

}
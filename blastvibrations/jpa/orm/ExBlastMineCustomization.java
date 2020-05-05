package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

import com.blastvibrations.jpa.annotation.Trim;

/**
 * The persistent class for the ex_blast_mine_customization database table.
 *
 */
@Entity
@Table(name = "ex_blast_mine_customization")
@NamedQuery(name = "ExBlastMineCustomization.findAll", query = "SELECT e FROM ExBlastMineCustomization e")
@ToString
public class ExBlastMineCustomization extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.mineCustomizationId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "mine_customization_id")
	private UUID mineCustomizationId;

	@Column(name = "blast_letter_number_strategy")
	private String blastLetterNumberStrategy = "";

	@Column(name = "client_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	@Convert(disableConversion = true)
	private UUID clientId;

	@Column(name = "label_blast_letter_number")
	private String labelBlastLetterNumber = "Blast letter #";

	@Column(name = "label_blast_type")
	private String labelBlastType = "Blast Categories";

	@Column(name = "label_detonation_method")
	private String labelDetonationMethod = "Detonation method";

	@Column(name = "label_estimated_collar")
	private String labelEstimatedCollar = "Estimated Collar";

	@Column(name = "label_estimated_drill_depth")
	private String labelEstimatedDrillDepth = "Estimated Drill Depth";

	@Column(name = "label_estimated_hole_count")
	private String labelEstimatedHoleCount = "Estimated number of holes";

	@Column(name = "label_estimated_hole_depth")
	private String labelEstimatedHoleDepth = "Estimated Hole Depth";

	@Column(name = "label_estimated_hole_diameter")
	private String labelEstimatedHoleDiameter = "Estimated Hole Diameter";

	@Column(name = "label_estimated_max_load_per_delay")
	private String labelEstimatedMaxLoadPerDelay = "Estimated Max Load/Delay";

	@Column(name = "label_estimated_pattern_burden")
	private String labelEstimatedPatternBurden = "Estimated Pattern Burden";

	@Column(name = "label_estimated_pattern_spacing")
	private String labelEstimatedPatternSpacing = "Estimated Pattern Spacing";

	@Column(name = "label_estimated_preblast_volume")
	private String labelEstimatedPreblastVolume = "Estimated Rock volume pre-blast";

	@Column(name = "label_estimated_sub_drill")
	private String labelEstimatedSubDrill = "Estimated Sub Drill";

	@Column(name = "label_estimated_total_explosives")
	private String labelEstimatedTotalExplosives = "Estimated Total Explosives";

	@Column(name = "label_firing_location")
	private String labelFiringLocation = "Firing location";

	@Column(name = "label_firing_location_level")
	private String labelFiringLocationLevel = "Underground firing location level";

	@Column(name = "label_from_level")
	private String labelFromLevel = "From level";

	@Column(name = "label_job_number")
	private String labelJobNumber = "Job Number";

	@Column(name = "label_location2")
	private String labelLocation2 = "Location2";

	@Column(name = "label_location3")
	private String labelLocation3 = "Location3";

	@Column(name = "label_location4")
	private String labelLocation4 = "Location4";

	@Column(name = "label_mining_method")
	private String labelMiningMethod = "Mining Method";

	@Column(name = "label_safety_notice_number")
	private String labelSafetyNoticeNumber = "Safety notice number";

	@Column(name = "label_to_level")
	private String labelToLevel = "To level";

	@Column(name = "show_blast_letter_number")
	private boolean showBlastLetterNumber = false;

	@Column(name = "show_blast_type")
	private boolean showBlastType = true; // now used for blast categories

	@Column(name = "show_detonation_method")
	private boolean showDetonationMethod = false;

	@Column(name = "show_estimated_collar")
	private boolean showEstimatedCollar = false;

	@Column(name = "show_estimated_drill_depth")
	private boolean showEstimatedDrillDepth = false;

	@Column(name = "show_estimated_hole_count")
	private boolean showEstimatedHoleCount = false;

	@Column(name = "show_estimated_hole_depth")
	private boolean showEstimatedHoleDepth = false;

	@Column(name = "show_estimated_hole_diameter")
	private boolean showEstimatedHoleDiameter = false;

	@Column(name = "show_estimated_max_load_per_delay")
	private boolean showEstimatedMaxLoadPerDelay = false;

	@Column(name = "show_estimated_pattern_burden")
	private boolean showEstimatedPatternBurden = false;

	@Column(name = "show_estimated_pattern_spacing")
	private boolean showEstimatedPatternSpacing = false;

	@Column(name = "show_estimated_preblast_volume")
	private boolean showEstimatedPreblastVolume = true;

	@Column(name = "show_estimated_sub_drill")
	private boolean showEstimatedSubDrill = false;

	@Column(name = "show_estimated_total_explosives")
	private boolean showEstimatedTotalExplosives = false;

	@Column(name = "show_firing_location")
	private boolean showFiringLocation = false;

	@Column(name = "show_firing_location_level")
	private boolean showFiringLocationLevel = false;

	@Column(name = "show_from_level")
	private boolean showFromLevel = false;

	@Column(name = "show_job_number")
	private boolean showJobNumber = true;

	@Column(name = "show_location2")
	private boolean showLocation2 = true;

	@Column(name = "show_location3")
	private boolean showLocation3 = true;

	@Column(name = "show_location4")
	private boolean showLocation4 = true;

	@Column(name = "show_mining_method")
	private boolean showMiningMethod = true;

	@Column(name = "show_safety_notice_number")
	private boolean showSafetyNoticeNumber = false;

	@Column(name = "show_to_level")
	private boolean showToLevel = false;

	@Column(name = "tip_blast_letter_number")
	private String tipBlastLetterNumber = "Blast letter #";

	@Column(name = "tip_blast_type")
	private String tipBlastType = "Blast Categories";

	@Column(name = "tip_detonation_method")
	private String tipDetonationMethod = "Detonation method";

	@Column(name = "tip_estimated_collar")
	private String tipEstimatedCollar = "Input the estimated Collar value(s)";

	@Column(name = "tip_estimated_drill_depth")
	private String tipEstimatedDrillDepth = "Input the estimated Drill Depth value(s)";

	@Column(name = "tip_estimated_hole_count")
	private String tipEstimatedHoleCount = "Input the estimated number of holes";

	@Column(name = "tip_estimated_hole_depth")
	private String tipEstimatedHoleDepth = "Input the estimated Hole Depth value(s)";

	@Column(name = "tip_estimated_hole_diameter")
	private String tipEstimatedHoleDiameter = "Input the estimated Hole Diameter value(s)";

	@Column(name = "tip_estimated_max_load_per_delay")
	private String tipEstimatedMaxLoadPerDelay = "Input the Estimated Max Load Per Delay";

	@Column(name = "tip_estimated_pattern_burden")
	private String tipEstimatedPatternBurden = "Input the estimated Pattern Burden value(s)";

	@Column(name = "tip_estimated_pattern_spacing")
	private String tipEstimatedPatternSpacing = "Input the estimated Pattern Spacing value(s)";

	@Column(name = "tip_estimated_preblast_volume")
	private String tipEstimatedPreblastVolume = "Enter the estimated rock volume pre-blast";

	@Column(name = "tip_estimated_sub_drill")
	private String tipEstimatedSubDrill = "Input the estimated Sub drill value(s)";

	@Column(name = "tip_estimated_total_explosives")
	private String tipEstimatedTotalExplosives = "Estimated Total Explosives";

	@Column(name = "tip_firing_location")
	private String tipFiringLocation = "Firing location";

	@Column(name = "tip_firing_location_level")
	private String tipFiringLocationLevel = "Underground firing location level";

	@Column(name = "tip_from_level")
	private String tipFromLevel = "From level";

	@Column(name = "tip_job_number")
	private String tipJobNumber = "Input Project or Job number corresponding to this blast";

	@Column(name = "tip_location2")
	private String tipLocation2 = "Location2";

	@Column(name = "tip_location3")
	private String tipLocation3 = "Location3";

	@Column(name = "tip_location4")
	private String tipLocation4 = "Location4";

	@Column(name = "tip_mining_method")
	private String tipMiningMethod = "Input the mining method used";

	@Column(name = "tip_safety_notice_number")
	private String tipSafetyNoticeNumber = "Safety notice number";

	@Column(name = "tip_to_level")
	private String tipToLevel = "To level";

	public ExBlastMineCustomization() {
	}

	public UUID getMineCustomizationId() {
		return this.mineCustomizationId;
	}

	public void setMineCustomizationId(final UUID mineCustomizationId) {
		this.mineCustomizationId = mineCustomizationId;
	}

	public String getBlastLetterNumberStrategy() {
		return this.blastLetterNumberStrategy;
	}

	public void setBlastLetterNumberStrategy(
			final String blastLetterNumberStrategy) {
		this.blastLetterNumberStrategy = blastLetterNumberStrategy;
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(final UUID clientId) {
		this.clientId = clientId;
	}

	public String getLabelBlastLetterNumber() {
		return this.labelBlastLetterNumber;
	}

	@Trim
	public void setLabelBlastLetterNumber(final String labelBlastLetterNumber) {
		this.labelBlastLetterNumber = labelBlastLetterNumber;
	}

	public String getLabelBlastType() {
		return this.labelBlastType;
	}

	@Trim
	public void setLabelBlastType(final String labelBlastType) {
		this.labelBlastType = labelBlastType;
	}

	public String getLabelDetonationMethod() {
		return this.labelDetonationMethod;
	}

	public void setLabelDetonationMethod(final String labelDetonationMethod) {
		this.labelDetonationMethod = labelDetonationMethod;
	}

	public String getLabelEstimatedCollar() {
		return this.labelEstimatedCollar;
	}

	@Trim
	public void setLabelEstimatedCollar(final String labelEstimatedCollar) {
		this.labelEstimatedCollar = labelEstimatedCollar;
	}

	public String getLabelEstimatedDrillDepth() {
		return this.labelEstimatedDrillDepth;
	}

	public void setLabelEstimatedDrillDepth(
			final String labelEstimatedDrillDepth) {
		this.labelEstimatedDrillDepth = labelEstimatedDrillDepth;
	}

	public String getLabelEstimatedHoleCount() {
		return this.labelEstimatedHoleCount;
	}

	@Trim
	public void setLabelEstimatedHoleCount(final String labelEstimatedHoleCount) {
		this.labelEstimatedHoleCount = labelEstimatedHoleCount;
	}

	public String getLabelEstimatedHoleDepth() {
		return this.labelEstimatedHoleDepth;
	}

	@Trim
	public void setLabelEstimatedHoleDepth(final String labelEstimatedHoleDepth) {
		this.labelEstimatedHoleDepth = labelEstimatedHoleDepth;
	}

	public String getLabelEstimatedHoleDiameter() {
		return this.labelEstimatedHoleDiameter;
	}

	public void setLabelEstimatedHoleDiameter(
			final String labelEstimatedHoleDiameter) {
		this.labelEstimatedHoleDiameter = labelEstimatedHoleDiameter;
	}

	public String getLabelEstimatedMaxLoadPerDelay() {
		return this.labelEstimatedMaxLoadPerDelay;
	}

	public void setLabelEstimatedMaxLoadPerDelay(
			final String labelEstimatedMaxLoadPerDelay) {
		this.labelEstimatedMaxLoadPerDelay = labelEstimatedMaxLoadPerDelay;
	}

	public String getLabelEstimatedPatternBurden() {
		return this.labelEstimatedPatternBurden;
	}

	public void setLabelEstimatedPatternBurden(
			final String labelEstimatedPatternBurden) {
		this.labelEstimatedPatternBurden = labelEstimatedPatternBurden;
	}

	public String getLabelEstimatedPatternSpacing() {
		return this.labelEstimatedPatternSpacing;
	}

	public void setLabelEstimatedPatternSpacing(
			final String labelEstimatedPatternSpacing) {
		this.labelEstimatedPatternSpacing = labelEstimatedPatternSpacing;
	}

	public String getLabelEstimatedPreblastVolume() {
		return this.labelEstimatedPreblastVolume;
	}

	public void setLabelEstimatedPreblastVolume(
			final String labelEstimatedPreblastVolume) {
		this.labelEstimatedPreblastVolume = labelEstimatedPreblastVolume;
	}

	public String getLabelEstimatedSubDrill() {
		return this.labelEstimatedSubDrill;
	}

	@Trim
	public void setLabelEstimatedSubDrill(final String labelEstimatedSubDrill) {
		this.labelEstimatedSubDrill = labelEstimatedSubDrill;
	}

	public String getLabelEstimatedTotalExplosives() {
		return this.labelEstimatedTotalExplosives;
	}

	public void setLabelEstimatedTotalExplosives(
			final String labelEstimatedTotalExplosives) {
		this.labelEstimatedTotalExplosives = labelEstimatedTotalExplosives;
	}

	public String getLabelFiringLocation() {
		return this.labelFiringLocation;
	}

	@Trim
	public void setLabelFiringLocation(final String labelFiringLocation) {
		this.labelFiringLocation = labelFiringLocation;
	}

	public String getLabelFiringLocationLevel() {
		return this.labelFiringLocationLevel;
	}

	public void setLabelFiringLocationLevel(
			final String labelFiringLocationLevel) {
		this.labelFiringLocationLevel = labelFiringLocationLevel;
	}

	public String getLabelFromLevel() {
		return this.labelFromLevel;
	}

	@Trim
	public void setLabelFromLevel(final String labelFromLevel) {
		this.labelFromLevel = labelFromLevel;
	}

	public String getLabelJobNumber() {
		return this.labelJobNumber;
	}

	@Trim
	public void setLabelJobNumber(final String labelJobNumber) {
		this.labelJobNumber = labelJobNumber;
	}

	public String getLabelLocation2() {
		return this.labelLocation2;
	}

	@Trim
	public void setLabelLocation2(final String labelLocation2) {
		this.labelLocation2 = labelLocation2;
	}

	public String getLabelLocation3() {
		return this.labelLocation3;
	}

	@Trim
	public void setLabelLocation3(final String labelLocation3) {
		this.labelLocation3 = labelLocation3;
	}

	public String getLabelLocation4() {
		return this.labelLocation4;
	}

	@Trim
	public void setLabelLocation4(final String labelLocation4) {
		this.labelLocation4 = labelLocation4;
	}

	public String getLabelMiningMethod() {
		return this.labelMiningMethod;
	}

	@Trim
	public void setLabelMiningMethod(final String labelMiningMethod) {
		this.labelMiningMethod = labelMiningMethod;
	}

	public String getLabelSafetyNoticeNumber() {
		return this.labelSafetyNoticeNumber;
	}

	@Trim
	public void setLabelSafetyNoticeNumber(final String labelSafetyNoticeNumber) {
		this.labelSafetyNoticeNumber = labelSafetyNoticeNumber;
	}

	public String getLabelToLevel() {
		return this.labelToLevel;
	}

	@Trim
	public void setLabelToLevel(final String labelToLevel) {
		this.labelToLevel = labelToLevel;
	}

	public boolean getShowBlastLetterNumber() {
		return this.showBlastLetterNumber;
	}

	public void setShowBlastLetterNumber(final boolean showBlastLetterNumber) {
		this.showBlastLetterNumber = showBlastLetterNumber;
	}

	public boolean getShowBlastType() {
		return this.showBlastType;
	}

	public void setShowBlastType(final boolean showBlastType) {
		this.showBlastType = showBlastType;
	}

	public boolean getShowDetonationMethod() {
		return this.showDetonationMethod;
	}

	public void setShowDetonationMethod(final boolean showDetonationMethod) {
		this.showDetonationMethod = showDetonationMethod;
	}

	public boolean getShowEstimatedCollar() {
		return this.showEstimatedCollar;
	}

	public void setShowEstimatedCollar(final boolean showEstimatedCollar) {
		this.showEstimatedCollar = showEstimatedCollar;
	}

	public boolean getShowEstimatedDrillDepth() {
		return this.showEstimatedDrillDepth;
	}

	public void setShowEstimatedDrillDepth(final boolean showEstimatedDrillDepth) {
		this.showEstimatedDrillDepth = showEstimatedDrillDepth;
	}

	public boolean getShowEstimatedHoleCount() {
		return this.showEstimatedHoleCount;
	}

	public void setShowEstimatedHoleCount(final boolean showEstimatedHoleCount) {
		this.showEstimatedHoleCount = showEstimatedHoleCount;
	}

	public boolean getShowEstimatedHoleDepth() {
		return this.showEstimatedHoleDepth;
	}

	public void setShowEstimatedHoleDepth(final boolean showEstimatedHoleDepth) {
		this.showEstimatedHoleDepth = showEstimatedHoleDepth;
	}

	public boolean getShowEstimatedHoleDiameter() {
		return this.showEstimatedHoleDiameter;
	}

	public void setShowEstimatedHoleDiameter(
			final boolean showEstimatedHoleDiameter) {
		this.showEstimatedHoleDiameter = showEstimatedHoleDiameter;
	}

	public boolean getShowEstimatedMaxLoadPerDelay() {
		return this.showEstimatedMaxLoadPerDelay;
	}

	public void setShowEstimatedMaxLoadPerDelay(
			final boolean showEstimatedMaxLoadPerDelay) {
		this.showEstimatedMaxLoadPerDelay = showEstimatedMaxLoadPerDelay;
	}

	public boolean getShowEstimatedPatternBurden() {
		return this.showEstimatedPatternBurden;
	}

	public void setShowEstimatedPatternBurden(
			final boolean showEstimatedPatternBurden) {
		this.showEstimatedPatternBurden = showEstimatedPatternBurden;
	}

	public boolean getShowEstimatedPatternSpacing() {
		return this.showEstimatedPatternSpacing;
	}

	public void setShowEstimatedPatternSpacing(
			final boolean showEstimatedPatternSpacing) {
		this.showEstimatedPatternSpacing = showEstimatedPatternSpacing;
	}

	public boolean getShowEstimatedPreblastVolume() {
		return this.showEstimatedPreblastVolume;
	}

	public void setShowEstimatedPreblastVolume(
			final boolean showEstimatedPreblastVolume) {
		this.showEstimatedPreblastVolume = showEstimatedPreblastVolume;
	}

	public boolean getShowEstimatedSubDrill() {
		return this.showEstimatedSubDrill;
	}

	public void setShowEstimatedSubDrill(final boolean showEstimatedSubDrill) {
		this.showEstimatedSubDrill = showEstimatedSubDrill;
	}

	public boolean getShowEstimatedTotalExplosives() {
		return this.showEstimatedTotalExplosives;
	}

	public void setShowEstimatedTotalExplosives(
			final boolean showEstimatedTotalExplosives) {
		this.showEstimatedTotalExplosives = showEstimatedTotalExplosives;
	}

	public boolean getShowFiringLocation() {
		return this.showFiringLocation;
	}

	public void setShowFiringLocation(final boolean showFiringLocation) {
		this.showFiringLocation = showFiringLocation;
	}

	public boolean getShowFiringLocationLevel() {
		return this.showFiringLocationLevel;
	}

	public void setShowFiringLocationLevel(final boolean showFiringLocationLevel) {
		this.showFiringLocationLevel = showFiringLocationLevel;
	}

	public boolean getShowFromLevel() {
		return this.showFromLevel;
	}

	public void setShowFromLevel(final boolean showFromLevel) {
		this.showFromLevel = showFromLevel;
	}

	public boolean getShowJobNumber() {
		return this.showJobNumber;
	}

	public void setShowJobNumber(final boolean showJobNumber) {
		this.showJobNumber = showJobNumber;
	}

	public boolean getShowLocation2() {
		return this.showLocation2;
	}

	public void setShowLocation2(final boolean showLocation2) {
		this.showLocation2 = showLocation2;
	}

	public boolean getShowLocation3() {
		return this.showLocation3;
	}

	public void setShowLocation3(final boolean showLocation3) {
		this.showLocation3 = showLocation3;
	}

	public boolean getShowLocation4() {
		return this.showLocation4;
	}

	public void setShowLocation4(final boolean showLocation4) {
		this.showLocation4 = showLocation4;
	}

	public boolean getShowMiningMethod() {
		return this.showMiningMethod;
	}

	public void setShowMiningMethod(final boolean showMiningMethod) {
		this.showMiningMethod = showMiningMethod;
	}

	public boolean getShowSafetyNoticeNumber() {
		return this.showSafetyNoticeNumber;
	}

	public void setShowSafetyNoticeNumber(final boolean showSafetyNoticeNumber) {
		this.showSafetyNoticeNumber = showSafetyNoticeNumber;
	}

	public boolean getShowToLevel() {
		return this.showToLevel;
	}

	public void setShowToLevel(final boolean showToLevel) {
		this.showToLevel = showToLevel;
	}

	public String getTipBlastLetterNumber() {
		return this.tipBlastLetterNumber;
	}

	@Trim
	public void setTipBlastLetterNumber(final String tipBlastLetterNumber) {
		this.tipBlastLetterNumber = tipBlastLetterNumber;
	}

	public String getTipBlastType() {
		return this.tipBlastType;
	}

	@Trim
	public void setTipBlastType(final String tipBlastType) {
		this.tipBlastType = tipBlastType;
	}

	public String getTipDetonationMethod() {
		return this.tipDetonationMethod;
	}

	@Trim
	public void setTipDetonationMethod(final String tipDetonationMethod) {
		this.tipDetonationMethod = tipDetonationMethod;
	}

	public String getTipEstimatedCollar() {
		return this.tipEstimatedCollar;
	}

	@Trim
	public void setTipEstimatedCollar(final String tipEstimatedCollar) {
		this.tipEstimatedCollar = tipEstimatedCollar;
	}

	public String getTipEstimatedDrillDepth() {
		return this.tipEstimatedDrillDepth;
	}

	@Trim
	public void setTipEstimatedDrillDepth(final String tipEstimatedDrillDepth) {
		this.tipEstimatedDrillDepth = tipEstimatedDrillDepth;
	}

	public String getTipEstimatedHoleCount() {
		return this.tipEstimatedHoleCount;
	}

	@Trim
	public void setTipEstimatedHoleCount(final String tipEstimatedHoleCount) {
		this.tipEstimatedHoleCount = tipEstimatedHoleCount;
	}

	public String getTipEstimatedHoleDepth() {
		return this.tipEstimatedHoleDepth;
	}

	@Trim
	public void setTipEstimatedHoleDepth(final String tipEstimatedHoleDepth) {
		this.tipEstimatedHoleDepth = tipEstimatedHoleDepth;
	}

	public String getTipEstimatedHoleDiameter() {
		return this.tipEstimatedHoleDiameter;
	}

	public void setTipEstimatedHoleDiameter(
			final String tipEstimatedHoleDiameter) {
		this.tipEstimatedHoleDiameter = tipEstimatedHoleDiameter;
	}

	public String getTipEstimatedMaxLoadPerDelay() {
		return this.tipEstimatedMaxLoadPerDelay;
	}

	public void setTipEstimatedMaxLoadPerDelay(
			final String tipEstimatedMaxLoadPerDelay) {
		this.tipEstimatedMaxLoadPerDelay = tipEstimatedMaxLoadPerDelay;
	}

	public String getTipEstimatedPatternBurden() {
		return this.tipEstimatedPatternBurden;
	}

	public void setTipEstimatedPatternBurden(
			final String tipEstimatedPatternBurden) {
		this.tipEstimatedPatternBurden = tipEstimatedPatternBurden;
	}

	public String getTipEstimatedPatternSpacing() {
		return this.tipEstimatedPatternSpacing;
	}

	public void setTipEstimatedPatternSpacing(
			final String tipEstimatedPatternSpacing) {
		this.tipEstimatedPatternSpacing = tipEstimatedPatternSpacing;
	}

	public String getTipEstimatedPreblastVolume() {
		return this.tipEstimatedPreblastVolume;
	}

	public void setTipEstimatedPreblastVolume(
			final String tipEstimatedPreblastVolume) {
		this.tipEstimatedPreblastVolume = tipEstimatedPreblastVolume;
	}

	public String getTipEstimatedSubDrill() {
		return this.tipEstimatedSubDrill;
	}

	@Trim
	public void setTipEstimatedSubDrill(final String tipEstimatedSubDrill) {
		this.tipEstimatedSubDrill = tipEstimatedSubDrill;
	}

	public String getTipEstimatedTotalExplosives() {
		return this.tipEstimatedTotalExplosives;
	}

	public void setTipEstimatedTotalExplosives(
			final String tipEstimatedTotalExplosives) {
		this.tipEstimatedTotalExplosives = tipEstimatedTotalExplosives;
	}

	public String getTipFiringLocation() {
		return this.tipFiringLocation;
	}

	@Trim
	public void setTipFiringLocation(final String tipFiringLocation) {
		this.tipFiringLocation = tipFiringLocation;
	}

	public String getTipFiringLocationLevel() {
		return this.tipFiringLocationLevel;
	}

	@Trim
	public void setTipFiringLocationLevel(final String tipFiringLocationLevel) {
		this.tipFiringLocationLevel = tipFiringLocationLevel;
	}

	public String getTipFromLevel() {
		return this.tipFromLevel;
	}

	@Trim
	public void setTipFromLevel(final String tipFromLevel) {
		this.tipFromLevel = tipFromLevel;
	}

	public String getTipJobNumber() {
		return this.tipJobNumber;
	}

	@Trim
	public void setTipJobNumber(final String tipJobNumber) {
		this.tipJobNumber = tipJobNumber;
	}

	public String getTipLocation2() {
		return this.tipLocation2;
	}

	@Trim
	public void setTipLocation2(final String tipLocation2) {
		this.tipLocation2 = tipLocation2;
	}

	public String getTipLocation3() {
		return this.tipLocation3;
	}

	@Trim
	public void setTipLocation3(final String tipLocation3) {
		this.tipLocation3 = tipLocation3;
	}

	public String getTipLocation4() {
		return this.tipLocation4;
	}

	@Trim
	public void setTipLocation4(final String tipLocation4) {
		this.tipLocation4 = tipLocation4;
	}

	public String getTipMiningMethod() {
		return this.tipMiningMethod;
	}

	@Trim
	public void setTipMiningMethod(final String tipMiningMethod) {
		this.tipMiningMethod = tipMiningMethod;
	}

	public String getTipSafetyNoticeNumber() {
		return this.tipSafetyNoticeNumber;
	}

	@Trim
	public void setTipSafetyNoticeNumber(final String tipSafetyNoticeNumber) {
		this.tipSafetyNoticeNumber = tipSafetyNoticeNumber;
	}

	public String getTipToLevel() {
		return this.tipToLevel;
	}

	@Trim
	public void setTipToLevel(final String tipToLevel) {
		this.tipToLevel = tipToLevel;
	}

}
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
 * The persistent class for the ex_blast_information_customization database
 * table.
 *
 */
@Entity
@Table(name = "ex_blast_information_customization")
@NamedQuery(name = "ExBlastInformationCustomization.findAll", query = "SELECT e FROM ExBlastInformationCustomization e")
@ToString
public class ExBlastInformationCustomization extends ExEntity implements
Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.informationCustomizationId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "information_customization_id")
	private UUID informationCustomizationId;

	@Column(name = "client_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	@Convert(disableConversion = true)
	private UUID clientId;

	@Column(name = "label_bench_height")
	private String labelBenchHeight = "Bench Height";

	@Column(name = "label_buffer_line_spacing")
	private String labelBufferLineSpacing = "Buffer Line Spacing";

	@Column(name = "label_collar")
	private String labelCollar = "Collar";

	@Column(name = "label_deck_count")
	private String labelDeckCount = "Deck Count";

	@Column(name = "label_drill_depth")
	private String labelDrillDepth = "Drill depth";

	@Column(name = "label_estimated_volume")
	private String labelEstimatedVolume = "Estimated rock volume";

	@Column(name = "label_hole_count")
	private String labelHoleCount = "Number of Holes";

	@Column(name = "label_hole_depth")
	private String labelHoleDepth = "Hole Depth";

	@Column(name = "label_hole_diameter")
	private String labelHoleDiameter = "Hole Diameter";

	@Column(name = "label_max_load_per_delay")
	private String labelMaxLoadPerDelay = "Max Load/Delay";

	@Column(name = "label_pattern_burden")
	private String labelPatternBurden = "Pattern Burden";

	@Column(name = "label_pattern_spacing")
	private String labelPatternSpacing = "Pattern Spacing";

	@Column(name = "label_pattern_type")
	private String labelPatternType = "Pattern Type";

	@Column(name = "label_planned_blast_duration")
	private String labelPlannedBlastDuration = "Planned blast duration";

	@Column(name = "label_powder_factor")
	private String labelPowderFactor = "Powder Factor";

	@Column(name = "label_ring_burden")
	private String labelRingBurden = "Ring burden";

	@Column(name = "label_rock_type")
	private String labelRockType = "Rock Type";

	@Column(name = "label_stemming_material")
	private String labelStemmingMaterial = "Stemming Material";

	@Column(name = "label_sub_drill")
	private String labelSubDrill = "Sub Drill";

	@Column(name = "label_toe_spacing")
	private String labelToeSpacing = "Toe spacing";

	@Column(name = "label_total_explosives")
	private String labelTotalExplosives = "Total Explosives";

	@Column(name = "label_total_totes")
	private String labelTotalTotes = "Total totes";

	@Column(name = "label_weight_per_tote")
	private String labelWeightPerTote = "Weight per tote";

	@Column(name = "show_bench_height")
	private boolean showBenchHeight = true;

	@Column(name = "show_buffer_line_spacing")
	private boolean showBufferLineSpacing = true;

	@Column(name = "show_collar")
	private boolean showCollar = true;

	@Column(name = "show_deck_count")
	private boolean showDeckCount = true;

	@Column(name = "show_drill_depth")
	private boolean showDrillDepth = false;

	@Column(name = "show_estimated_volume")
	private boolean showEstimatedVolume = true;

	@Column(name = "show_hole_count")
	private boolean showHoleCount = true;

	@Column(name = "show_hole_depth")
	private boolean showHoleDepth = true;

	@Column(name = "show_hole_diameter")
	private boolean showHoleDiameter = true;

	@Column(name = "show_max_load_per_delay")
	private boolean showMaxLoadPerDelay = true;

	@Column(name = "show_pattern_burden")
	private boolean showPatternBurden = true;

	@Column(name = "show_pattern_spacing")
	private boolean showPatternSpacing = true;

	@Column(name = "show_pattern_type")
	private boolean showPatternType = true;

	@Column(name = "show_planned_blast_duration")
	private boolean showPlannedBlastDuration = true;

	@Column(name = "show_powder_factor")
	private boolean showPowderFactor = true;

	@Column(name = "show_ring_burden")
	private boolean showRingBurden = false;

	@Column(name = "show_rock_type")
	private boolean showRockType = true;

	@Column(name = "show_stemming_material")
	private boolean showStemmingMaterial = true;

	@Column(name = "show_sub_drill")
	private boolean showSubDrill = true;

	@Column(name = "show_toe_spacing")
	private boolean showToeSpacing = false;

	@Column(name = "show_total_explosives")
	private boolean showTotalExplosives = true;

	@Column(name = "show_total_totes")
	private boolean showTotalTotes = false;

	@Column(name = "show_weight_per_tote")
	private boolean showWeightPerTote = false;

	@Column(name = "tip_bench_height")
	private String tipBenchHeight = "Input the Bench Height value(s)";

	@Column(name = "tip_buffer_line_spacing")
	private String tipBufferLineSpacing = "Input the Buffer Line Spacing value(s)";

	@Column(name = "tip_collar")
	private String tipCollar = "Input the Collar value(s)";

	@Column(name = "tip_deck_count")
	private String tipDeckCount = "Input the number of explosive decks used";

	@Column(name = "tip_drill_depth")
	private String tipDrillDepth = "Input the drill depth";

	@Column(name = "tip_estimated_volume")
	private String tipEstimatedVolume = "Input the Estimated Rock Volume";

	@Column(name = "tip_hole_count")
	private String tipHoleCount = "Input the number of holes";

	@Column(name = "tip_hole_depth")
	private String tipHoleDepth = "Input the Hole Depth value(s)";

	@Column(name = "tip_hole_diameter")
	private String tipHoleDiameter = "Input the Hole Diameter value(s)";

	@Column(name = "tip_max_load_per_delay")
	private String tipMaxLoadPerDelay = "Input the Max Load Per Delay";

	@Column(name = "tip_pattern_burden")
	private String tipPatternBurden = "Input the Pattern Burden value(s)";

	@Column(name = "tip_pattern_spacing")
	private String tipPatternSpacing = "Input the Pattern Spacing value(s)";

	@Column(name = "tip_pattern_type")
	private String tipPatternType = "Input the type of blast pattern used";

	@Column(name = "tip_planned_blast_duration")
	private String tipPlannedBlastDuration = "Input the blast duration in ms";

	@Column(name = "tip_powder_factor")
	private String tipPowderFactor = "Powder Factor";

	@Column(name = "tip_ring_burden")
	private String tipRingBurden = "Ring burden";

	@Column(name = "tip_rock_type")
	private String tipRockType = "Input the rock type of this blast";

	@Column(name = "tip_stemming_material")
	private String tipStemmingMaterial = "Input the stemming material used for this blast";

	@Column(name = "tip_sub_drill")
	private String tipSubDrill = "Input the Subdrill value(s)";

	@Column(name = "tip_toe_spacing")
	private String tipToeSpacing = "Toe spacing";

	@Column(name = "tip_total_explosives")
	private String tipTotalExplosives = "Total Explosives";

	@Column(name = "tip_total_totes")
	private String tipTotalTotes = "Total totes";

	@Column(name = "tip_weight_per_tote")
	private String tipWeightPerTote = "Weight per tote";

	public ExBlastInformationCustomization() {
	}

	public UUID getInformationCustomizationId() {
		return this.informationCustomizationId;
	}

	public void setInformationCustomizationId(
			final UUID informationCustomizationId) {
		this.informationCustomizationId = informationCustomizationId;
	}

	public UUID getClientId() {
		return this.clientId;
	}

	public void setClientId(final UUID clientId) {
		this.clientId = clientId;
	}

	public String getLabelBenchHeight() {
		return this.labelBenchHeight;
	}

	@Trim
	public void setLabelBenchHeight(final String labelBenchHeight) {
		this.labelBenchHeight = labelBenchHeight;
	}

	public String getLabelBufferLineSpacing() {
		return this.labelBufferLineSpacing;
	}

	@Trim
	public void setLabelBufferLineSpacing(final String labelBufferLineSpacing) {
		this.labelBufferLineSpacing = labelBufferLineSpacing;
	}

	public String getLabelCollar() {
		return this.labelCollar;
	}

	@Trim
	public void setLabelCollar(final String labelCollar) {
		this.labelCollar = labelCollar;
	}

	public String getLabelDeckCount() {
		return this.labelDeckCount;
	}

	@Trim
	public void setLabelDeckCount(final String labelDeckCount) {
		this.labelDeckCount = labelDeckCount;
	}

	public String getLabelDrillDepth() {
		return this.labelDrillDepth;
	}

	@Trim
	public void setLabelDrillDepth(final String labelDrillDepth) {
		this.labelDrillDepth = labelDrillDepth;
	}

	public String getLabelEstimatedVolume() {
		return this.labelEstimatedVolume;
	}

	@Trim
	public void setLabelEstimatedVolume(final String labelEstimatedVolume) {
		this.labelEstimatedVolume = labelEstimatedVolume;
	}

	public String getLabelHoleCount() {
		return this.labelHoleCount;
	}

	@Trim
	public void setLabelHoleCount(final String labelHoleCount) {
		this.labelHoleCount = labelHoleCount;
	}

	public String getLabelHoleDepth() {
		return this.labelHoleDepth;
	}

	@Trim
	public void setLabelHoleDepth(final String labelHoleDepth) {
		this.labelHoleDepth = labelHoleDepth;
	}

	public String getLabelHoleDiameter() {
		return this.labelHoleDiameter;
	}

	@Trim
	public void setLabelHoleDiameter(final String labelHoleDiameter) {
		this.labelHoleDiameter = labelHoleDiameter;
	}

	public String getLabelMaxLoadPerDelay() {
		return this.labelMaxLoadPerDelay;
	}

	@Trim
	public void setLabelMaxLoadPerDelay(final String labelMaxLoadPerDelay) {
		this.labelMaxLoadPerDelay = labelMaxLoadPerDelay;
	}

	public String getLabelPatternBurden() {
		return this.labelPatternBurden;
	}

	@Trim
	public void setLabelPatternBurden(final String labelPatternBurden) {
		this.labelPatternBurden = labelPatternBurden;
	}

	public String getLabelPatternSpacing() {
		return this.labelPatternSpacing;
	}

	@Trim
	public void setLabelPatternSpacing(final String labelPatternSpacing) {
		this.labelPatternSpacing = labelPatternSpacing;
	}

	public String getLabelPatternType() {
		return this.labelPatternType;
	}

	@Trim
	public void setLabelPatternType(final String labelPatternType) {
		this.labelPatternType = labelPatternType;
	}

	public String getLabelPlannedBlastDuration() {
		return this.labelPlannedBlastDuration;
	}

	public void setLabelPlannedBlastDuration(
			final String labelPlannedBlastDuration) {
		this.labelPlannedBlastDuration = labelPlannedBlastDuration;
	}

	public String getLabelPowderFactor() {
		return this.labelPowderFactor;
	}

	@Trim
	public void setLabelPowderFactor(final String labelPowderFactor) {
		this.labelPowderFactor = labelPowderFactor;
	}

	public String getLabelRingBurden() {
		return this.labelRingBurden;
	}

	@Trim
	public void setLabelRingBurden(final String labelRingBurden) {
		this.labelRingBurden = labelRingBurden;
	}

	public String getLabelRockType() {
		return this.labelRockType;
	}

	@Trim
	public void setLabelRockType(final String labelRockType) {
		this.labelRockType = labelRockType;
	}

	public String getLabelStemmingMaterial() {
		return this.labelStemmingMaterial;
	}

	@Trim
	public void setLabelStemmingMaterial(final String labelStemmingMaterial) {
		this.labelStemmingMaterial = labelStemmingMaterial;
	}

	public String getLabelSubDrill() {
		return this.labelSubDrill;
	}

	@Trim
	public void setLabelSubDrill(final String labelSubDrill) {
		this.labelSubDrill = labelSubDrill;
	}

	public String getLabelToeSpacing() {
		return this.labelToeSpacing;
	}

	@Trim
	public void setLabelToeSpacing(final String labelToeSpacing) {
		this.labelToeSpacing = labelToeSpacing;
	}

	public String getLabelTotalExplosives() {
		return this.labelTotalExplosives;
	}

	@Trim
	public void setLabelTotalExplosives(final String labelTotalExplosives) {
		this.labelTotalExplosives = labelTotalExplosives;
	}

	public String getLabelTotalTotes() {
		return this.labelTotalTotes;
	}

	@Trim
	public void setLabelTotalTotes(final String labelTotalTotes) {
		this.labelTotalTotes = labelTotalTotes;
	}

	public String getLabelWeightPerTote() {
		return this.labelWeightPerTote;
	}

	@Trim
	public void setLabelWeightPerTote(final String labelWeightPerTote) {
		this.labelWeightPerTote = labelWeightPerTote;
	}

	public boolean getShowBenchHeight() {
		return this.showBenchHeight;
	}

	public void setShowBenchHeight(final boolean showBenchHeight) {
		this.showBenchHeight = showBenchHeight;
	}

	public boolean getShowBufferLineSpacing() {
		return this.showBufferLineSpacing;
	}

	public void setShowBufferLineSpacing(final boolean showBufferLineSpacing) {
		this.showBufferLineSpacing = showBufferLineSpacing;
	}

	public boolean getShowCollar() {
		return this.showCollar;
	}

	public void setShowCollar(final boolean showCollar) {
		this.showCollar = showCollar;
	}

	public boolean getShowDeckCount() {
		return this.showDeckCount;
	}

	public void setShowDeckCount(final boolean showDeckCount) {
		this.showDeckCount = showDeckCount;
	}

	public boolean getShowDrillDepth() {
		return this.showDrillDepth;
	}

	public void setShowDrillDepth(final boolean showDrillDepth) {
		this.showDrillDepth = showDrillDepth;
	}

	public boolean getShowEstimatedVolume() {
		return this.showEstimatedVolume;
	}

	public void setShowEstimatedVolume(final boolean showEstimatedVolume) {
		this.showEstimatedVolume = showEstimatedVolume;
	}

	public boolean getShowHoleCount() {
		return this.showHoleCount;
	}

	public void setShowHoleCount(final boolean showHoleCount) {
		this.showHoleCount = showHoleCount;
	}

	public boolean getShowHoleDepth() {
		return this.showHoleDepth;
	}

	public void setShowHoleDepth(final boolean showHoleDepth) {
		this.showHoleDepth = showHoleDepth;
	}

	public boolean getShowHoleDiameter() {
		return this.showHoleDiameter;
	}

	public void setShowHoleDiameter(final boolean showHoleDiameter) {
		this.showHoleDiameter = showHoleDiameter;
	}

	public boolean getShowMaxLoadPerDelay() {
		return this.showMaxLoadPerDelay;
	}

	public void setShowMaxLoadPerDelay(final boolean showMaxLoadPerDelay) {
		this.showMaxLoadPerDelay = showMaxLoadPerDelay;
	}

	public boolean getShowPatternBurden() {
		return this.showPatternBurden;
	}

	public void setShowPatternBurden(final boolean showPatternBurden) {
		this.showPatternBurden = showPatternBurden;
	}

	public boolean getShowPatternSpacing() {
		return this.showPatternSpacing;
	}

	public void setShowPatternSpacing(final boolean showPatternSpacing) {
		this.showPatternSpacing = showPatternSpacing;
	}

	public boolean getShowPatternType() {
		return this.showPatternType;
	}

	public void setShowPatternType(final boolean showPatternType) {
		this.showPatternType = showPatternType;
	}

	public boolean getShowPlannedBlastDuration() {
		return this.showPlannedBlastDuration;
	}

	public void setShowPlannedBlastDuration(
			final boolean showPlannedBlastDuration) {
		this.showPlannedBlastDuration = showPlannedBlastDuration;
	}

	public boolean getShowPowderFactor() {
		return this.showPowderFactor;
	}

	public void setShowPowderFactor(final boolean showPowderFactor) {
		this.showPowderFactor = showPowderFactor;
	}

	public boolean getShowRingBurden() {
		return this.showRingBurden;
	}

	public void setShowRingBurden(final boolean showRingBurden) {
		this.showRingBurden = showRingBurden;
	}

	public boolean getShowRockType() {
		return this.showRockType;
	}

	public void setShowRockType(final boolean showRockType) {
		this.showRockType = showRockType;
	}

	public boolean getShowStemmingMaterial() {
		return this.showStemmingMaterial;
	}

	public void setShowStemmingMaterial(final boolean showStemmingMaterial) {
		this.showStemmingMaterial = showStemmingMaterial;
	}

	public boolean getShowSubDrill() {
		return this.showSubDrill;
	}

	public void setShowSubDrill(final boolean showSubDrill) {
		this.showSubDrill = showSubDrill;
	}

	public boolean getShowToeSpacing() {
		return this.showToeSpacing;
	}

	public void setShowToeSpacing(final boolean showToeSpacing) {
		this.showToeSpacing = showToeSpacing;
	}

	public boolean getShowTotalExplosives() {
		return this.showTotalExplosives;
	}

	public void setShowTotalExplosives(final boolean showTotalExplosives) {
		this.showTotalExplosives = showTotalExplosives;
	}

	public boolean getShowTotalTotes() {
		return this.showTotalTotes;
	}

	public void setShowTotalTotes(final boolean showTotalTotes) {
		this.showTotalTotes = showTotalTotes;
	}

	public boolean getShowWeightPerTote() {
		return this.showWeightPerTote;
	}

	public void setShowWeightPerTote(final boolean showWeightPerTote) {
		this.showWeightPerTote = showWeightPerTote;
	}

	public String getTipBenchHeight() {
		return this.tipBenchHeight;
	}

	@Trim
	public void setTipBenchHeight(final String tipBenchHeight) {
		this.tipBenchHeight = tipBenchHeight;
	}

	public String getTipBufferLineSpacing() {
		return this.tipBufferLineSpacing;
	}

	@Trim
	public void setTipBufferLineSpacing(final String tipBufferLineSpacing) {
		this.tipBufferLineSpacing = tipBufferLineSpacing;
	}

	public String getTipCollar() {
		return this.tipCollar;
	}

	@Trim
	public void setTipCollar(final String tipCollar) {
		this.tipCollar = tipCollar;
	}

	public String getTipDeckCount() {
		return this.tipDeckCount;
	}

	@Trim
	public void setTipDeckCount(final String tipDeckCount) {
		this.tipDeckCount = tipDeckCount;
	}

	public String getTipDrillDepth() {
		return this.tipDrillDepth;
	}

	@Trim
	public void setTipDrillDepth(final String tipDrillDepth) {
		this.tipDrillDepth = tipDrillDepth;
	}

	public String getTipEstimatedVolume() {
		return this.tipEstimatedVolume;
	}

	@Trim
	public void setTipEstimatedVolume(final String tipEstimatedVolume) {
		this.tipEstimatedVolume = tipEstimatedVolume;
	}

	public String getTipHoleCount() {
		return this.tipHoleCount;
	}

	@Trim
	public void setTipHoleCount(final String tipHoleCount) {
		this.tipHoleCount = tipHoleCount;
	}

	public String getTipHoleDepth() {
		return this.tipHoleDepth;
	}

	@Trim
	public void setTipHoleDepth(final String tipHoleDepth) {
		this.tipHoleDepth = tipHoleDepth;
	}

	public String getTipHoleDiameter() {
		return this.tipHoleDiameter;
	}

	@Trim
	public void setTipHoleDiameter(final String tipHoleDiameter) {
		this.tipHoleDiameter = tipHoleDiameter;
	}

	public String getTipMaxLoadPerDelay() {
		return this.tipMaxLoadPerDelay;
	}

	@Trim
	public void setTipMaxLoadPerDelay(final String tipMaxLoadPerDelay) {
		this.tipMaxLoadPerDelay = tipMaxLoadPerDelay;
	}

	public String getTipPatternBurden() {
		return this.tipPatternBurden;
	}

	@Trim
	public void setTipPatternBurden(final String tipPatternBurden) {
		this.tipPatternBurden = tipPatternBurden;
	}

	public String getTipPatternSpacing() {
		return this.tipPatternSpacing;
	}

	@Trim
	public void setTipPatternSpacing(final String tipPatternSpacing) {
		this.tipPatternSpacing = tipPatternSpacing;
	}

	public String getTipPatternType() {
		return this.tipPatternType;
	}

	@Trim
	public void setTipPatternType(final String tipPatternType) {
		this.tipPatternType = tipPatternType;
	}

	public String getTipPlannedBlastDuration() {
		return this.tipPlannedBlastDuration;
	}

	@Trim
	public void setTipPlannedBlastDuration(final String tipPlannedBlastDuration) {
		this.tipPlannedBlastDuration = tipPlannedBlastDuration;
	}

	public String getTipPowderFactor() {
		return this.tipPowderFactor;
	}

	@Trim
	public void setTipPowderFactor(final String tipPowderFactor) {
		this.tipPowderFactor = tipPowderFactor;
	}

	public String getTipRingBurden() {
		return this.tipRingBurden;
	}

	@Trim
	public void setTipRingBurden(final String tipRingBurden) {
		this.tipRingBurden = tipRingBurden;
	}

	public String getTipRockType() {
		return this.tipRockType;
	}

	@Trim
	public void setTipRockType(final String tipRockType) {
		this.tipRockType = tipRockType;
	}

	public String getTipStemmingMaterial() {
		return this.tipStemmingMaterial;
	}

	@Trim
	public void setTipStemmingMaterial(final String tipStemmingMaterial) {
		this.tipStemmingMaterial = tipStemmingMaterial;
	}

	public String getTipSubDrill() {
		return this.tipSubDrill;
	}

	@Trim
	public void setTipSubDrill(final String tipSubDrill) {
		this.tipSubDrill = tipSubDrill;
	}

	public String getTipToeSpacing() {
		return this.tipToeSpacing;
	}

	@Trim
	public void setTipToeSpacing(final String tipToeSpacing) {
		this.tipToeSpacing = tipToeSpacing;
	}

	public String getTipTotalExplosives() {
		return this.tipTotalExplosives;
	}

	@Trim
	public void setTipTotalExplosives(final String tipTotalExplosives) {
		this.tipTotalExplosives = tipTotalExplosives;
	}

	public String getTipTotalTotes() {
		return this.tipTotalTotes;
	}

	@Trim
	public void setTipTotalTotes(final String tipTotalTotes) {
		this.tipTotalTotes = tipTotalTotes;
	}

	public String getTipWeightPerTote() {
		return this.tipWeightPerTote;
	}

	@Trim
	public void setTipWeightPerTote(final String tipWeightPerTote) {
		this.tipWeightPerTote = tipWeightPerTote;
	}

}
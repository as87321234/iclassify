package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.ArrayList;
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
 * The persistent class for the ex_client_customization database table.
 *
 */
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
		@TypeDef(name = "json", typeClass = JsonStringType.class) })
@Entity
@Table(name = "ex_client_customization")
@NamedQuery(name = "ExClientCustomization.findAll", query = "SELECT e FROM ExClientCustomization e")
@ToString
public class ExClientCustomization extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.clientCustomizationId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "client_customization_id")
	private UUID clientCustomizationId;

	@Column(name = "auto_populate_elevation")
	// Add a clickable option to the client customization page (where you select
	// which fields appear for the client)
	// that controls whether the elevation information auto populates when
	// entering lat and long coordinates.
	// Note: When you click on a point on the map, it should likely always auto
	// populate regardless of the clickable option
	private boolean autoPopulateElevation = true;

	@Type(type = "jsonb")
	@Column(name = "blast_categories", columnDefinition = "jsonb")
	// When entering information for a blast report,
	// above explosive type needs to be "Blast Category" where you select which
	// categories were used
	// (needs to be square boxes for select multiple on 1 blast)
	// Production Blast
	// Shear Blasts
	// Sinking Cut
	// Drift Round
	// Crown Blast
	// Trenching Blast
	private List<String> blastCategories = new ArrayList<String>();

	@Column(name = "blast_letter_number_strategy")
	private String blastLetterNumberStrategy = "";

	@Column(name = "blast_report_print_template")
	private String blastReportPrintTemplate;

	@Column(name = "client_id")
	private UUID clientId;

	@Column(name = "custom1_label")
	private String labelCustom1 = "Custom 1";

	@Column(name = "custom2_label")
	private String labelCustom2 = "Custom 2";

	@Column(name = "custom3_label")
	private String labelCustom3 = "Custom 3";

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "default_time")
	private Date defaultTime;

	@Column(name = "format_blast_number")
	private String formatBlastNumber;

	@Column(name = "label_bench")
	private String labelBench = "Bench";

	@Column(name = "label_bench_height")
	private String labelBenchHeight = "Bench Height";

	@Column(name = "label_blast_letter_number")
	private String labelBlastLetterNumber = "Blast letter #";

	@Column(name = "label_blast_number")
	private String labelBlastNumber = "Blast Number";

	@Column(name = "label_blast_type")
	private String labelBlastType = "Blast Categories";

	@Column(name = "label_blaster_name")
	private String labelBlasterName = "Blaster Name";

	@Column(name = "label_buffer_line_spacing")
	private String labelBufferLineSpacing = "Buffer Line Spacing";

	@Column(name = "label_collar")
	private String labelCollar = "Collar";

	@Column(name = "label_completed_by")
	private String labelCompletedBy = "Completed By";

	@Column(name = "label_deck_count")
	private String labelDeckCount = "Deck Count";

	@Column(name = "label_description")
	private String labelDescription = "Description";

	@Column(name = "label_detonation_method")
	private String labelDetonationMethod = "Detonation method";

	@Column(name = "label_estimated_collar")
	private String labelEstimatedCollar = "Estimated Collar";

	@Column(name = "label_estimated_hole_count")
	private String labelEstimatedHoleCount = "Estimated number of holes";

	@Column(name = "label_estimated_hole_depth")
	private String labelEstimatedHoleDepth = "Estimated Hole Depth";

	@Column(name = "label_estimated_hole_diameter")
	private String labelEstimatedHoleDiameter = "Estimated Hole Diameter";

	@Column(name = "label_estimated_max_load_per_delay")
	private String labelEstimatedMaxLoadPerDelay = "Estimated Max Load/Delay";

	@Column(name = "label_estimated_p_p_v")
	private String labelEstimatedPPV = "PPV value estimated to be";

	@Column(name = "label_estimated_pattern_burden")
	private String labelEstimatedPatternBurden = "Estimated Pattern Burden";

	@Column(name = "label_estimated_pattern_spacing")
	private String labelEstimatedPatternSpacing = "Estimated Pattern Spacing";

	@Column(name = "label_estimated_preblast_volume")
	private String labelEstimatedPreblastVolume = "Estimated Rock volume pre-blast";

	@Column(name = "label_estimated_sub_drill")
	private String labelEstimatedSubDrill = "Estimated Sub Drill";

	@Column(name = "label_estimated_surface_p_p_v")
	private String labelEstimatedSurfacePPV = "PPV value on Surface estimated to be";

	@Column(name = "label_estimated_total_explosives")
	private String labelEstimatedTotalExplosives = "Estimated Total Explosives";

	@Column(name = "label_estimated_volume")
	private String labelEstimatedVolume = "Estimated rock volume";

	@Column(name = "label_explosive_type")
	private String labelExplosiveType = "Explosive Type";

	@Column(name = "label_firing_location")
	private String labelFiringLocation = "Firing location";

	@Column(name = "label_firing_location_level")
	private String labelFiringLocationLevel = "Underground firing location level";

	@Column(name = "label_flyrock")
	private String labelFlyrock = "Flyrock";

	@Column(name = "label_fragmentation")
	private String labelFragmentation = "Fragmentation";

	@Column(name = "label_from_level")
	private String labelFromLevel = "From level";

	@Column(name = "label_hole_count")
	private String labelHoleCount = "Number of Holes";

	@Column(name = "label_hole_depth")
	private String labelHoleDepth = "Hole Depth";

	@Column(name = "label_hole_diameter")
	private String labelHoleDiameter = "Hole Diameter";

	@Column(name = "label_job_number")
	private String labelJobNumber = "Job Number";

	@Column(name = "label_location")
	private String labelLocation = "Blast Location";

	@Column(name = "label_location2")
	private String labelLocation2 = "Location2";

	@Column(name = "label_location3")
	private String labelLocation3 = "Location3";

	@Column(name = "label_location4")
	private String labelLocation4 = "Location4";

	@Column(name = "label_max_load_per_delay")
	private String labelMaxLoadPerDelay = "Max Load/Delay";

	@Column(name = "label_mining_method")
	private String labelMiningMethod = "Mining Method";

	@Column(name = "label_muckpile_configuration")
	private String labelMuckpileConfiguration = "Muckpile Configuration";

	@Column(name = "label_name")
	private String labelName = "Name";

	@Column(name = "label_notes")
	private String labelNotes = "Notes";

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

	@Column(name = "label_quarry_site")
	private String labelQuarrySite = "Quarry site";

	@Column(name = "label_reviewed_by")
	private String labelReviewedBy = "Reviewed By";

	@Column(name = "label_ring_burden")
	private String labelRingBurden = "Ring burden";

	@Column(name = "label_rock_type")
	private String labelRockType = "Rock Type";

	@Column(name = "label_safety_notice_number")
	private String labelSafetyNoticeNumber = "Safety notice number";

	@Column(name = "label_stemming_material")
	private String labelStemmingMaterial = "Stemming Material";

	@Column(name = "label_sub_drill")
	private String labelSubDrill = "Sub Drill";

	@Column(name = "label_technician")
	private String labelTechnician = "Technician";

	@Column(name = "label_temperature")
	private String labelTemperature = "Temperature";

	@Column(name = "label_to_level")
	private String labelToLevel = "To level";

	@Column(name = "label_toe_spacing")
	private String labelToeSpacing = "Toe spacing";

	@Column(name = "label_total_explosives")
	private String labelTotalExplosives = "Total Explosives";

	@Column(name = "label_total_totes")
	private String labelTotalTotes = "Total totes";

	@Column(name = "label_weather")
	private String labelWeather = "Weather";

	@Column(name = "label_weight_per_tote")
	private String labelWeightPerTote = "Weight per tote";

	@Column(name = "label_wind_direction")
	private String labelWindDirection = "Wind Direction";

	@Column(name = "label_wind_velocity")
	private String labelWindVelocity = "Wind Velocity";

	@Column(name = "measurement_system")
	private String measurementSystem = "MeasureSystemMetric";

	@Type(type = "jsonb")
	@Column(name = "pattern_type_list", columnDefinition = "jsonb")
	private List<String> patternTypeList = new ArrayList<String>() {
		private static final long serialVersionUID = 5939013871925616119L;
		{
			add("Square");
			add("Dice");
			add("Zipper");
			add("Ring");
			add("Shear");
		}
	};

	@Column(name = "show_bench")
	private boolean showBench = true;

	@Column(name = "show_bench_height")
	private boolean showBenchHeight = true;

	@Column(name = "show_blast_letter_number")
	private boolean showBlastLetterNumber = false;

	@Column(name = "show_blast_number")
	private boolean showBlastNumber = true;

	@Column(name = "show_blast_type")
	private boolean showBlastType = true; // now used for blast categories

	@Column(name = "show_blaster_name")
	private boolean showBlasterName = true;

	@Column(name = "show_buffer_line_spacing")
	private boolean showBufferLineSpacing = true;

	@Column(name = "show_collar")
	private boolean showCollar = true;

	@Column(name = "show_completed_by")
	private boolean showCompletedBy = true;

	@Column(name = "show_custom1")
	private boolean showCustom1 = true;

	@Column(name = "show_custom2")
	private boolean showCustom2 = true;

	@Column(name = "show_custom3")
	private boolean showCustom3 = true;

	@Column(name = "show_deck_count")
	private boolean showDeckCount = true;

	@Column(name = "show_description")
	private boolean showDescription = true;

	@Column(name = "show_detonation_method")
	private boolean showDetonationMethod = false;

	@Column(name = "show_estimated_collar")
	private boolean showEstimatedCollar = false;

	@Column(name = "show_estimated_hole_count")
	private boolean showEstimatedHoleCount = false;

	@Column(name = "show_estimated_hole_depth")
	private boolean showEstimatedHoleDepth = false;

	@Column(name = "show_estimated_hole_diameter")
	private boolean showEstimatedHoleDiameter = false;

	@Column(name = "show_estimated_max_load_per_delay")
	private boolean showEstimatedMaxLoadPerDelay = false;

	@Column(name = "show_estimated_p_p_v")
	private boolean showEstimatedPPV = false;

	@Column(name = "show_estimated_pattern_burden")
	private boolean showEstimatedPatternBurden = false;

	@Column(name = "show_estimated_pattern_spacing")
	private boolean showEstimatedPatternSpacing = false;

	@Column(name = "show_estimated_preblast_volume")
	private boolean showEstimatedPreblastVolume = true;

	@Column(name = "show_estimated_sub_drill")
	private boolean showEstimatedSubDrill = false;

	@Column(name = "show_estimated_surface_p_p_v")
	private boolean showEstimatedSurfacePPV = false;

	@Column(name = "show_estimated_total_explosives")
	private boolean showEstimatedTotalExplosives = false;

	@Column(name = "show_estimated_volume")
	private boolean showEstimatedVolume = true;

	@Column(name = "show_explosive_type")
	private boolean showExplosiveType = true;

	@Column(name = "show_firing_location")
	private boolean showFiringLocation = false;

	@Column(name = "show_firing_location_level")
	private boolean showFiringLocationLevel = false;

	@Column(name = "show_flyrock")
	private boolean showFlyrock = true;

	@Column(name = "show_fragmentation")
	private boolean showFragmentation = true;

	@Column(name = "show_from_level")
	private boolean showFromLevel = false;

	@Column(name = "show_hole_count")
	private boolean showHoleCount = true;

	@Column(name = "show_hole_depth")
	private boolean showHoleDepth = true;

	@Column(name = "show_hole_diameter")
	private boolean showHoleDiameter = true;

	@Column(name = "show_job_number")
	private boolean showJobNumber = true;

	@Column(name = "show_levels")
	private boolean showLevels;

	@Column(name = "show_location")
	private boolean showLocation = true;

	@Column(name = "show_location2")
	private boolean showLocation2 = true;

	@Column(name = "show_location3")
	private boolean showLocation3 = true;

	@Column(name = "show_location4")
	private boolean showLocation4 = true;

	@Column(name = "show_max_load_per_delay")
	private boolean showMaxLoadPerDelay = true;

	@Column(name = "show_mining_method")
	private boolean showMiningMethod = true;

	@Column(name = "show_muckpile_configuration")
	private boolean showMuckpileConfiguration = true;

	@Column(name = "show_name")
	private boolean showName = true;

	@Column(name = "show_neck_count")
	private boolean showNeckCount;

	@Column(name = "show_notes")
	private boolean showNotes = true;

	@Column(name = "show_orebody")
	private boolean showOrebody;

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

	@Column(name = "show_quarry_site")
	private boolean showQuarrySite = false;

	@Column(name = "show_reviewed_by")
	private boolean showReviewedBy = true;

	@Column(name = "show_ring_burden")
	private boolean showRingBurden = false;

	@Column(name = "show_rock_type")
	private boolean showRockType = true;

	@Column(name = "show_safety_notice_number")
	private boolean showSafetyNoticeNumber = false;

	@Column(name = "show_stemming_material")
	private boolean showStemmingMaterial = true;

	@Column(name = "show_stope_name")
	private boolean showStopeName;

	@Column(name = "show_sub_drill")
	private boolean showSubDrill = true;

	@Column(name = "show_technician")
	private boolean showTechnician = true;

	@Column(name = "show_temperature")
	private boolean showTemperature = true;

	@Column(name = "show_to_level")
	private boolean showToLevel = false;

	@Column(name = "show_toe_spacing")
	private boolean showToeSpacing = false;

	@Column(name = "show_total_explosives")
	private boolean showTotalExplosives = true;

	@Column(name = "show_total_totes")
	private boolean showTotalTotes = false;

	@Column(name = "show_weather")
	private boolean showWeather = true;

	@Column(name = "show_weight_per_tote")
	private boolean showWeightPerTote = false;

	@Column(name = "show_wind_direction")
	private boolean showWindDirection = true;

	@Column(name = "show_wind_velocity")
	private boolean showWindVelocity = true;

	@Column(name = "tip_bench")
	private String tipBench = "Bench";

	@Column(name = "tip_bench_height")
	private String tipBenchHeight = "Input the Bench Height value(s)";

	@Column(name = "tip_blast_letter_number")
	private String tipBlastLetterNumber = "Blast letter #";

	@Column(name = "tip_blast_number")
	private String tipBlastNumber = "Input blast number corresponding to this blast";

	@Column(name = "tip_blast_type")
	private String tipBlastType = "Blast Categories";

	@Column(name = "tip_blaster_name")
	private String tipBlasterName = "Input name of the blaster";

	@Column(name = "tip_buffer_line_spacing")
	private String tipBufferLineSpacing = "Input the Buffer Line Spacing value(s)";

	@Column(name = "tip_collar")
	private String tipCollar = "Input the Collar value(s)";

	@Column(name = "tip_completed_by")
	private String tipCompletedBy = "Input name of the individual completing this report";

	@Column(name = "tip_custom1")
	private String tipCustom1 = "Custom 1";

	@Column(name = "tip_custom2")
	private String tipCustom2 = "Custom 2";

	@Column(name = "tip_custom3")
	private String tipCustom3 = "Custom 3";;

	@Column(name = "tip_deck_count")
	private String tipDeckCount = "Input the number of explosive decks used";

	@Column(name = "tip_description")
	private String tipDescription = "Input optional description of this blast";

	@Column(name = "tip_detonation_method")
	private String tipDetonationMethod = "Detonation method";

	@Column(name = "tip_estimated_collar")
	private String tipEstimatedCollar = "Input the estimated Collar value(s)";

	@Column(name = "tip_estimated_hole_count")
	private String tipEstimatedHoleCount = "Input the estimated number of holes";

	@Column(name = "tip_estimated_hole_depth")
	private String tipEstimatedHoleDepth = "Input the estimated Hole Depth value(s)";

	@Column(name = "tip_estimated_hole_diameter")
	private String tipEstimatedHoleDiameter = "Input the estimated Hole Diameter value(s)";

	@Column(name = "tip_estimated_max_load_per_delay")
	private String tipEstimatedMaxLoadPerDelay = "Input the Estimated Max Load Per Delay";

	@Column(name = "tip_estimated_p_p_v")
	private String tipEstimatedPPV = "PPV value estimated to be";

	@Column(name = "tip_estimated_pattern_burden")
	private String tipEstimatedPatternBurden = "Input the estimated Pattern Burden value(s)";

	@Column(name = "tip_estimated_pattern_spacing")
	private String tipEstimatedPatternSpacing = "Input the estimated Pattern Spacing value(s)";

	@Column(name = "tip_estimated_preblast_volume")
	private String tipEstimatedPreblastVolume = "Enter the estimated rock volume pre-blast";

	@Column(name = "tip_estimated_sub_drill")
	private String tipEstimatedSubDrill = "Input the estimated Sub drill value(s)";

	@Column(name = "tip_estimated_surface_p_p_v")
	private String tipEstimatedSurfacePPV = "PPV value on Surface estimated to be";

	@Column(name = "tip_estimated_total_explosives")
	private String tipEstimatedTotalExplosives = "Estimated Total Explosives";

	@Column(name = "tip_estimated_volume")
	private String tipEstimatedVolume = "Input the Estimated Rock Volume";

	@Column(name = "tip_explosive_type")
	private String tipExplosiveType = "Explosive Type";

	@Column(name = "tip_firing_location")
	private String tipFiringLocation = "Firing location";

	@Column(name = "tip_firing_location_level")
	private String tipFiringLocationLevel = "Underground firing location level";

	@Column(name = "tip_flyrock")
	private String tipFlyrock = "Input notes on the flyrock from the blast";

	@Column(name = "tip_fragmentation")
	private String tipFragmentation = "Input notes on the fragmentation of the blast";

	@Column(name = "tip_from_level")
	private String tipFromLevel = "From level";

	@Column(name = "tip_hole_count")
	private String tipHoleCount = "Input the number of holes";

	@Column(name = "tip_hole_depth")
	private String tipHoleDepth = "Input the Hole Depth value(s)";

	@Column(name = "tip_hole_diameter")
	private String tipHoleDiameter = "Input the Hole Diameter value(s)";

	@Column(name = "tip_job_number")
	private String tipJobNumber = "Input Project or Job number corresponding to this blast";

	@Column(name = "tip_location")
	private String tipLocation = "Blast Location";

	@Column(name = "tip_location2")
	private String tipLocation2 = "Location2";

	@Column(name = "tip_location3")
	private String tipLocation3 = "Location3";

	@Column(name = "tip_location4")
	private String tipLocation4 = "Location4";

	@Column(name = "tip_max_load_per_delay")
	private String tipMaxLoadPerDelay = "Input the Max Load Per Delay";

	@Column(name = "tip_mining_method")
	private String tipMiningMethod = "Input the mining method used";

	@Column(name = "tip_muckpile_configuration")
	private String tipMuckpileConfiguration = "Input notes on the muckpile configuration of the blast";

	@Column(name = "tip_name")
	private String tipName = "Input name of this blast";

	@Column(name = "tip_notes")
	private String tipNotes = "Input any additional notes about the blast";

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

	@Column(name = "tip_quarry_site")
	private String tipQuarrySite = "Enter a quarry site";

	@Column(name = "tip_reviewed_by")
	private String tipReviewedBy = "Input name of the individual reviewing this report";

	@Column(name = "tip_ring_burden")
	private String tipRingBurden = "Ring burden";

	@Column(name = "tip_rock_type")
	private String tipRockType = "Input the rock type of this blast";

	@Column(name = "tip_safety_notice_number")
	private String tipSafetyNoticeNumber = "Safety notice number";

	@Column(name = "tip_stemming_material")
	private String tipStemmingMaterial = "Input the stemming material used for this blast";

	@Column(name = "tip_sub_drill")
	private String tipSubDrill = "Input the Subdrill value(s)";

	@Column(name = "tip_technician")
	private String tipTechnician = "Input name of the vibration monitoring technician";

	@Column(name = "tip_temperature")
	private String tipTemperature = "Input the temperature at the time of the blast";

	@Column(name = "tip_to_level")
	private String tipToLevel = "To level";

	@Column(name = "tip_toe_spacing")
	private String tipToeSpacing = "Toe spacing";

	@Column(name = "tip_total_explosives")
	private String tipTotalExplosives = "Total Explosives";

	@Column(name = "tip_total_totes")
	private String tipTotalTotes = "Total totes";

	@Column(name = "tip_weather")
	private String tipWeather = "Select weatherId conditions at time of blast";

	@Column(name = "tip_weight_per_tote")
	private String tipWeightPerTote = "Weight per tote";

	@Column(name = "tip_wind_direction")
	private String tipWindDirection = "Input wind direction at the time of blast";

	@Column(name = "tip_wind_velocity")
	private String tipWindVelocity = "Input wind speed at the time of blast";

	@Type(type = "jsonb")
	@Column(name = "weather_list", columnDefinition = "jsonb")
	private List<String> weatherList = new ArrayList<String>() {

		private static final long serialVersionUID = 5939013871925616119L;
		{
			add("Sunny");
			add("Partly Cloudy");
			add("Cloudy");
			add("Overcast");
			add("Rain");
			add("Snow");
			add("Snow and Rain");
		}
	};

	@Type(type = "jsonb")
	@Column(name = "wind_direction_list", columnDefinition = "jsonb")
	private List<String> windDirectionList = new ArrayList<String>() {
		private static final long serialVersionUID = 5939013871925616119L;
		{
			add("NW");
			add("N");
			add("NE");
			add("E");
			add("SE");
			add("S");
			add("SW");
			add("W");
		}
	};

	public ExClientCustomization() {
	}

	public UUID getClientCustomizationId() {
		return this.clientCustomizationId;
	}

	public void setClientCustomizationId(final UUID clientCustomizationId) {
		this.clientCustomizationId = clientCustomizationId;
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

	public String getBlastLetterNumberStrategy() {
		return this.blastLetterNumberStrategy;
	}

	public void setBlastLetterNumberStrategy(
			final String blastLetterNumberStrategy) {
		this.blastLetterNumberStrategy = blastLetterNumberStrategy;
	}

	public String getBlastReportPrintTemplate() {
		return this.blastReportPrintTemplate;
	}

	public void setBlastReportPrintTemplate(
			final String blastReportPrintTemplate) {
		this.blastReportPrintTemplate = blastReportPrintTemplate;
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

	public String getLabelBenchHeight() {
		return this.labelBenchHeight;
	}

	@Trim
	public void setLabelBenchHeight(final String labelBenchHeight) {
		this.labelBenchHeight = labelBenchHeight;
	}

	public String getLabelBlastLetterNumber() {
		return this.labelBlastLetterNumber;
	}

	@Trim
	public void setLabelBlastLetterNumber(final String labelBlastLetterNumber) {
		this.labelBlastLetterNumber = labelBlastLetterNumber;
	}

	public String getLabelBlastNumber() {
		return this.labelBlastNumber;
	}

	@Trim
	public void setLabelBlastNumber(final String labelBlastNumber) {
		this.labelBlastNumber = labelBlastNumber;
	}

	public String getLabelBlastType() {
		return this.labelBlastType;
	}

	@Trim
	public void setLabelBlastType(final String labelBlastType) {
		this.labelBlastType = labelBlastType;
	}

	public String getLabelBlasterName() {
		return this.labelBlasterName;
	}

	@Trim
	public void setLabelBlasterName(final String labelBlasterName) {
		this.labelBlasterName = labelBlasterName;
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

	public String getLabelCompletedBy() {
		return this.labelCompletedBy;
	}

	@Trim
	public void setLabelCompletedBy(final String labelCompletedBy) {
		this.labelCompletedBy = labelCompletedBy;
	}

	public String getLabelDeckCount() {
		return this.labelDeckCount;
	}

	@Trim
	public void setLabelDeckCount(final String labelDeckCount) {
		this.labelDeckCount = labelDeckCount;
	}

	public String getLabelDescription() {
		return this.labelDescription;
	}

	@Trim
	public void setLabelDescription(final String labelDescription) {
		this.labelDescription = labelDescription;
	}

	public String getLabelDetonationMethod() {
		return this.labelDetonationMethod;
	}

	@Trim
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

	public String getLabelEstimatedPPV() {
		return this.labelEstimatedPPV;
	}

	@Trim
	public void setLabelEstimatedPPV(final String labelEstimatedPPV) {
		this.labelEstimatedPPV = labelEstimatedPPV;
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

	public String getLabelEstimatedSurfacePPV() {
		return this.labelEstimatedSurfacePPV;
	}

	public void setLabelEstimatedSurfacePPV(
			final String labelEstimatedSurfacePPV) {
		this.labelEstimatedSurfacePPV = labelEstimatedSurfacePPV;
	}

	public String getLabelEstimatedTotalExplosives() {
		return this.labelEstimatedTotalExplosives;
	}

	public void setLabelEstimatedTotalExplosives(
			final String labelEstimatedTotalExplosives) {
		this.labelEstimatedTotalExplosives = labelEstimatedTotalExplosives;
	}

	public String getLabelEstimatedVolume() {
		return this.labelEstimatedVolume;
	}

	@Trim
	public void setLabelEstimatedVolume(final String labelEstimatedVolume) {
		this.labelEstimatedVolume = labelEstimatedVolume;
	}

	public String getLabelExplosiveType() {
		return this.labelExplosiveType;
	}

	@Trim
	public void setLabelExplosiveType(final String labelExplosiveType) {
		this.labelExplosiveType = labelExplosiveType;
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

	public String getLabelFromLevel() {
		return this.labelFromLevel;
	}

	@Trim
	public void setLabelFromLevel(final String labelFromLevel) {
		this.labelFromLevel = labelFromLevel;
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

	public String getLabelJobNumber() {
		return this.labelJobNumber;
	}

	@Trim
	public void setLabelJobNumber(final String labelJobNumber) {
		this.labelJobNumber = labelJobNumber;
	}

	public String getLabelLocation() {
		return this.labelLocation;
	}

	@Trim
	public void setLabelLocation(final String labelLocation) {
		this.labelLocation = labelLocation;
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

	public String getLabelMaxLoadPerDelay() {
		return this.labelMaxLoadPerDelay;
	}

	@Trim
	public void setLabelMaxLoadPerDelay(final String labelMaxLoadPerDelay) {
		this.labelMaxLoadPerDelay = labelMaxLoadPerDelay;
	}

	public String getLabelMiningMethod() {
		return this.labelMiningMethod;
	}

	@Trim
	public void setLabelMiningMethod(final String labelMiningMethod) {
		this.labelMiningMethod = labelMiningMethod;
	}

	public String getLabelMuckpileConfiguration() {
		return this.labelMuckpileConfiguration;
	}

	public void setLabelMuckpileConfiguration(
			final String labelMuckpileConfiguration) {
		this.labelMuckpileConfiguration = labelMuckpileConfiguration;
	}

	public String getLabelName() {
		return this.labelName;
	}

	@Trim
	public void setLabelName(final String labelName) {
		this.labelName = labelName;
	}

	public String getLabelNotes() {
		return this.labelNotes;
	}

	@Trim
	public void setLabelNotes(final String labelNotes) {
		this.labelNotes = labelNotes;
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

	public String getLabelQuarrySite() {
		return this.labelQuarrySite;
	}

	@Trim
	public void setLabelQuarrySite(final String labelQuarrySite) {
		this.labelQuarrySite = labelQuarrySite;
	}

	public String getLabelReviewedBy() {
		return this.labelReviewedBy;
	}

	@Trim
	public void setLabelReviewedBy(final String labelReviewedBy) {
		this.labelReviewedBy = labelReviewedBy;
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

	public String getLabelSafetyNoticeNumber() {
		return this.labelSafetyNoticeNumber;
	}

	@Trim
	public void setLabelSafetyNoticeNumber(final String labelSafetyNoticeNumber) {
		this.labelSafetyNoticeNumber = labelSafetyNoticeNumber;
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

	public String getLabelToLevel() {
		return this.labelToLevel;
	}

	@Trim
	public void setLabelToLevel(final String labelToLevel) {
		this.labelToLevel = labelToLevel;
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

	public String getLabelWeather() {
		return this.labelWeather;
	}

	@Trim
	public void setLabelWeather(final String labelWeather) {
		this.labelWeather = labelWeather;
	}

	public String getLabelWeightPerTote() {
		return this.labelWeightPerTote;
	}

	@Trim
	public void setLabelWeightPerTote(final String labelWeightPerTote) {
		this.labelWeightPerTote = labelWeightPerTote;
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

	public String getMeasurementSystem() {
		return this.measurementSystem;
	}

	@Trim
	public void setMeasurementSystem(final String measurementSystem) {
		this.measurementSystem = measurementSystem;
	}

	public List<String> getPatternTypeList() {
		return this.patternTypeList;
	}

	@Trim
	public void setPatternTypeList(final List<String> patternTypeList) {
		this.patternTypeList = patternTypeList;
	}

	public boolean getShowBench() {
		return this.showBench;
	}

	public void setShowBench(final boolean showBench) {
		this.showBench = showBench;
	}

	public boolean getShowBenchHeight() {
		return this.showBenchHeight;
	}

	public void setShowBenchHeight(final boolean showBenchHeight) {
		this.showBenchHeight = showBenchHeight;
	}

	public boolean getShowBlastLetterNumber() {
		return this.showBlastLetterNumber;
	}

	public void setShowBlastLetterNumber(final boolean showBlastLetterNumber) {
		this.showBlastLetterNumber = showBlastLetterNumber;
	}

	public boolean getShowBlastNumber() {
		return this.showBlastNumber;
	}

	public void setShowBlastNumber(final boolean showBlastNumber) {
		this.showBlastNumber = showBlastNumber;
	}

	public boolean getShowBlastType() {
		return this.showBlastType;
	}

	public void setShowBlastType(final boolean showBlastType) {
		this.showBlastType = showBlastType;
	}

	public boolean getShowBlasterName() {
		return this.showBlasterName;
	}

	public void setShowBlasterName(final boolean showBlasterName) {
		this.showBlasterName = showBlasterName;
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

	public boolean getShowDeckCount() {
		return this.showDeckCount;
	}

	public void setShowDeckCount(final boolean showDeckCount) {
		this.showDeckCount = showDeckCount;
	}

	public boolean getShowDescription() {
		return this.showDescription;
	}

	public void setShowDescription(final boolean showDescription) {
		this.showDescription = showDescription;
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

	public boolean getShowEstimatedPPV() {
		return this.showEstimatedPPV;
	}

	public void setShowEstimatedPPV(final boolean showEstimatedPPV) {
		this.showEstimatedPPV = showEstimatedPPV;
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

	public boolean getShowEstimatedSurfacePPV() {
		return this.showEstimatedSurfacePPV;
	}

	public void setShowEstimatedSurfacePPV(final boolean showEstimatedSurfacePPV) {
		this.showEstimatedSurfacePPV = showEstimatedSurfacePPV;
	}

	public boolean getShowEstimatedTotalExplosives() {
		return this.showEstimatedTotalExplosives;
	}

	public void setShowEstimatedTotalExplosives(
			final boolean showEstimatedTotalExplosives) {
		this.showEstimatedTotalExplosives = showEstimatedTotalExplosives;
	}

	public boolean getShowEstimatedVolume() {
		return this.showEstimatedVolume;
	}

	public void setShowEstimatedVolume(final boolean showEstimatedVolume) {
		this.showEstimatedVolume = showEstimatedVolume;
	}

	public boolean getShowExplosiveType() {
		return this.showExplosiveType;
	}

	public void setShowExplosiveType(final boolean showExplosiveType) {
		this.showExplosiveType = showExplosiveType;
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

	public boolean getShowFromLevel() {
		return this.showFromLevel;
	}

	public void setShowFromLevel(final boolean showFromLevel) {
		this.showFromLevel = showFromLevel;
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

	public boolean getShowJobNumber() {
		return this.showJobNumber;
	}

	public void setShowJobNumber(final boolean showJobNumber) {
		this.showJobNumber = showJobNumber;
	}

	public boolean getShowLevels() {
		return this.showLevels;
	}

	public void setShowLevels(final boolean showLevels) {
		this.showLevels = showLevels;
	}

	public boolean getShowLocation() {
		return this.showLocation;
	}

	public void setShowLocation(final boolean showLocation) {
		this.showLocation = showLocation;
	}

	/*
	 * public boolean isShowOrebody() { return showOrebody; } public void
	 * setShowOrebody(boolean showOrebody) { this.showOrebody = showOrebody; }
	 * public boolean isShowStopeName() { return showStopeName; } public void
	 * setShowStopeName(boolean showStopeName) { this.showStopeName =
	 * showStopeName; } public boolean isShowLevels() { return showLevels; }
	 * public void setShowLevels(boolean showLevels) { this.showLevels =
	 * showLevels; }
	 */

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

	public boolean getShowMaxLoadPerDelay() {
		return this.showMaxLoadPerDelay;
	}

	public void setShowMaxLoadPerDelay(final boolean showMaxLoadPerDelay) {
		this.showMaxLoadPerDelay = showMaxLoadPerDelay;
	}

	public boolean getShowMiningMethod() {
		return this.showMiningMethod;
	}

	public void setShowMiningMethod(final boolean showMiningMethod) {
		this.showMiningMethod = showMiningMethod;
	}

	public boolean getShowMuckpileConfiguration() {
		return this.showMuckpileConfiguration;
	}

	public void setShowMuckpileConfiguration(
			final boolean showMuckpileConfiguration) {
		this.showMuckpileConfiguration = showMuckpileConfiguration;
	}

	public boolean getShowName() {
		return this.showName;
	}

	public void setShowName(final boolean showName) {
		this.showName = showName;
	}

	public boolean getShowNeckCount() {
		return this.showNeckCount;
	}

	public void setShowNeckCount(final boolean showNeckCount) {
		this.showNeckCount = showNeckCount;
	}

	public boolean getShowNotes() {
		return this.showNotes;
	}

	public void setShowNotes(final boolean showNotes) {
		this.showNotes = showNotes;
	}

	public boolean getShowOrebody() {
		return this.showOrebody;
	}

	public void setShowOrebody(final boolean showOrebody) {
		this.showOrebody = showOrebody;
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

	public boolean getShowQuarrySite() {
		return this.showQuarrySite;
	}

	public void setShowQuarrySite(final boolean showQuarrySite) {
		this.showQuarrySite = showQuarrySite;
	}

	public boolean getShowReviewedBy() {
		return this.showReviewedBy;
	}

	public void setShowReviewedBy(final boolean showReviewedBy) {
		this.showReviewedBy = showReviewedBy;
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

	public boolean getShowSafetyNoticeNumber() {
		return this.showSafetyNoticeNumber;
	}

	public void setShowSafetyNoticeNumber(final boolean showSafetyNoticeNumber) {
		this.showSafetyNoticeNumber = showSafetyNoticeNumber;
	}

	public boolean getShowStemmingMaterial() {
		return this.showStemmingMaterial;
	}

	public void setShowStemmingMaterial(final boolean showStemmingMaterial) {
		this.showStemmingMaterial = showStemmingMaterial;
	}

	public boolean getShowStopeName() {
		return this.showStopeName;
	}

	public void setShowStopeName(final boolean showStopeName) {
		this.showStopeName = showStopeName;
	}

	public boolean getShowSubDrill() {
		return this.showSubDrill;
	}

	public void setShowSubDrill(final boolean showSubDrill) {
		this.showSubDrill = showSubDrill;
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

	public boolean getShowToLevel() {
		return this.showToLevel;
	}

	public void setShowToLevel(final boolean showToLevel) {
		this.showToLevel = showToLevel;
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

	public boolean getShowWeather() {
		return this.showWeather;
	}

	public void setShowWeather(final boolean showWeather) {
		this.showWeather = showWeather;
	}

	public boolean getShowWeightPerTote() {
		return this.showWeightPerTote;
	}

	public void setShowWeightPerTote(final boolean showWeightPerTote) {
		this.showWeightPerTote = showWeightPerTote;
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

	public String getTipBench() {
		return this.tipBench;
	}

	@Trim
	public void setTipBench(final String tipBench) {
		this.tipBench = tipBench;
	}

	public String getTipBenchHeight() {
		return this.tipBenchHeight;
	}

	@Trim
	public void setTipBenchHeight(final String tipBenchHeight) {
		this.tipBenchHeight = tipBenchHeight;
	}

	public String getTipBlastLetterNumber() {
		return this.tipBlastLetterNumber;
	}

	@Trim
	public void setTipBlastLetterNumber(final String tipBlastLetterNumber) {
		this.tipBlastLetterNumber = tipBlastLetterNumber;
	}

	public String getTipBlastNumber() {
		return this.tipBlastNumber;
	}

	@Trim
	public void setTipBlastNumber(final String tipBlastNumber) {
		this.tipBlastNumber = tipBlastNumber;
	}

	public String getTipBlastType() {
		return this.tipBlastType;
	}

	@Trim
	public void setTipBlastType(final String tipBlastType) {
		this.tipBlastType = tipBlastType;
	}

	public String getTipBlasterName() {
		return this.tipBlasterName;
	}

	@Trim
	public void setTipBlasterName(final String tipBlasterName) {
		this.tipBlasterName = tipBlasterName;
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

	public String getTipDeckCount() {
		return this.tipDeckCount;
	}

	@Trim
	public void setTipDeckCount(final String tipDeckCount) {
		this.tipDeckCount = tipDeckCount;
	}

	public String getTipDescription() {
		return this.tipDescription;
	}

	@Trim
	public void setTipDescription(final String tipDescription) {
		this.tipDescription = tipDescription;
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

	public String getTipEstimatedPPV() {
		return this.tipEstimatedPPV;
	}

	@Trim
	public void setTipEstimatedPPV(final String tipEstimatedPPV) {
		this.tipEstimatedPPV = tipEstimatedPPV;
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

	public String getTipEstimatedSurfacePPV() {
		return this.tipEstimatedSurfacePPV;
	}

	@Trim
	public void setTipEstimatedSurfacePPV(final String tipEstimatedSurfacePPV) {
		this.tipEstimatedSurfacePPV = tipEstimatedSurfacePPV;
	}

	public String getTipEstimatedTotalExplosives() {
		return this.tipEstimatedTotalExplosives;
	}

	public void setTipEstimatedTotalExplosives(
			final String tipEstimatedTotalExplosives) {
		this.tipEstimatedTotalExplosives = tipEstimatedTotalExplosives;
	}

	public String getTipEstimatedVolume() {
		return this.tipEstimatedVolume;
	}

	@Trim
	public void setTipEstimatedVolume(final String tipEstimatedVolume) {
		this.tipEstimatedVolume = tipEstimatedVolume;
	}

	public String getTipExplosiveType() {
		return this.tipExplosiveType;
	}

	@Trim
	public void setTipExplosiveType(final String tipExplosiveType) {
		this.tipExplosiveType = tipExplosiveType;
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

	public String getTipFromLevel() {
		return this.tipFromLevel;
	}

	@Trim
	public void setTipFromLevel(final String tipFromLevel) {
		this.tipFromLevel = tipFromLevel;
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

	public String getTipJobNumber() {
		return this.tipJobNumber;
	}

	@Trim
	public void setTipJobNumber(final String tipJobNumber) {
		this.tipJobNumber = tipJobNumber;
	}

	public String getTipLocation() {
		return this.tipLocation;
	}

	@Trim
	public void setTipLocation(final String tipLocation) {
		this.tipLocation = tipLocation;
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

	public String getTipMaxLoadPerDelay() {
		return this.tipMaxLoadPerDelay;
	}

	@Trim
	public void setTipMaxLoadPerDelay(final String tipMaxLoadPerDelay) {
		this.tipMaxLoadPerDelay = tipMaxLoadPerDelay;
	}

	public String getTipMiningMethod() {
		return this.tipMiningMethod;
	}

	@Trim
	public void setTipMiningMethod(final String tipMiningMethod) {
		this.tipMiningMethod = tipMiningMethod;
	}

	public String getTipMuckpileConfiguration() {
		return this.tipMuckpileConfiguration;
	}

	public void setTipMuckpileConfiguration(
			final String tipMuckpileConfiguration) {
		this.tipMuckpileConfiguration = tipMuckpileConfiguration;
	}

	public String getTipName() {
		return this.tipName;
	}

	@Trim
	public void setTipName(final String tipName) {
		this.tipName = tipName;
	}

	public String getTipNotes() {
		return this.tipNotes;
	}

	@Trim
	public void setTipNotes(final String tipNotes) {
		this.tipNotes = tipNotes;
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

	public String getTipQuarrySite() {
		return this.tipQuarrySite;
	}

	@Trim
	public void setTipQuarrySite(final String tipQuarrySite) {
		this.tipQuarrySite = tipQuarrySite;
	}

	public String getTipReviewedBy() {
		return this.tipReviewedBy;
	}

	@Trim
	public void setTipReviewedBy(final String tipReviewedBy) {
		this.tipReviewedBy = tipReviewedBy;
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

	public String getTipSafetyNoticeNumber() {
		return this.tipSafetyNoticeNumber;
	}

	@Trim
	public void setTipSafetyNoticeNumber(final String tipSafetyNoticeNumber) {
		this.tipSafetyNoticeNumber = tipSafetyNoticeNumber;
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

	public String getTipToLevel() {
		return this.tipToLevel;
	}

	@Trim
	public void setTipToLevel(final String tipToLevel) {
		this.tipToLevel = tipToLevel;
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

	public String getTipWeather() {
		return this.tipWeather;
	}

	@Trim
	public void setTipWeather(final String tipWeather) {
		this.tipWeather = tipWeather;
	}

	public String getTipWeightPerTote() {
		return this.tipWeightPerTote;
	}

	@Trim
	public void setTipWeightPerTote(final String tipWeightPerTote) {
		this.tipWeightPerTote = tipWeightPerTote;
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

	public List<String> getWeatherList() {
		return this.weatherList;
	}

	@Trim
	public void setWeatherList(final List<String> weatherList) {
		this.weatherList = weatherList;
	}

	public List<String> getWindDirectionList() {
		return this.windDirectionList;
	}

	@Trim
	public void setWindDirectionList(final List<String> windDirectionList) {
		this.windDirectionList = windDirectionList;
	}

}
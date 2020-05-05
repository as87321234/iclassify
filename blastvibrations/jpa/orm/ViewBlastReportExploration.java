package com.blastvibrations.jpa.orm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.blastvibrations.jpa.annotation.Trim;
import com.vividsolutions.jts.geom.Point;

public class ViewBlastReportExploration extends ExEntity  {

	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_NAME = "Blast Report";

	@Override
	public void clearKey() {
		super.clearKey();
		this.blastId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "blast_id")
	private UUID blastId;

	@Column(name = "bench_height")
	private BigDecimal benchHeight;

	@Column(name = "bench_height_user")
	private BigDecimal benchHeightUser;

	@Column(name = "bench_id")
	private UUID benchId;

	@Type(type = "jsonb")
	@Column(name = "blast_categories", columnDefinition = "jsonb")
	private List<String> blastCategories;

	@Column(name = "blast_detail_comment_id")
	private UUID blastDetailCommentId;

	@Column(name = "blast_letter_number")
	private String blastLetterNumber;

	@Column(name = "blast_number")
	private String blastNumber;

	@Column(name = "blast_type")
	private String blastType;

	@Column(name = "blaster_name")
	private String blasterName;

	@Column(name = "blaster_name_id")
	private UUID blasterNameId;

	@Column(name = "buffer_line_spacing")
	private BigDecimal bufferLineSpacing;

	@Column(name = "buffer_line_spacing_user")
	private BigDecimal bufferLineSpacingUser;

	@Column(name = "client_id")
	private UUID clientId;

	@Column(name = "client_name")
	private String clientName;

	private BigDecimal collar;

	@Column(name = "collar_user")
	private BigDecimal collarUser;

	@Column(name = "completed_by")
	private String completedBy;

	private String custom1;

	private String custom2;

	private String custom3;

	@Column(name = "deck_count")
	private BigDecimal deckCount;

	private String description;

	@Column(name = "detonation_method")
	private String detonationMethod;

	@Column(name = "detonation_method_id")
	private UUID detonationMethodId;

	@Column(name = "detonator_count")
	private BigDecimal detonatorCount;

	@Column(name = "detonator_count1")
	private BigDecimal detonatorCount1;

	@Column(name = "detonator_count2")
	private BigDecimal detonatorCount2;

	@Column(name = "detonator_count3")
	private BigDecimal detonatorCount3;

	@Column(name = "detonator_count4")
	private BigDecimal detonatorCount4;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names1", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames1;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names10", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames10;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names2", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames2;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names3", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames3;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names4", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames4;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names5", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames5;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names6", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames6;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names7", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames7;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names8", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames8;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names9", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames9;

	@Column(name = "drill_depth")
	private BigDecimal drillDepth;

	@Column(name = "drill_depth_user")
	private BigDecimal drillDepthUser;

	private BigDecimal elevation;

	@Column(name = "elevation_user")
	private BigDecimal elevationUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "estimated_collar")
	private BigDecimal estimatedCollar;

	@Column(name = "estimated_collar_user")
	private BigDecimal estimatedCollarUser;

	@Column(name = "estimated_drill_depth_user")
	private BigDecimal estimatedDrillDepthUser;

	@Column(name = "estimated_hole_count")
	private BigDecimal estimatedHoleCount;

	@Column(name = "estimated_hole_depth")
	private BigDecimal estimatedHoleDepth;

	@Column(name = "estimated_hole_depth_user")
	private BigDecimal estimatedHoleDepthUser;

	@Column(name = "estimated_hole_diameter")
	private BigDecimal estimatedHoleDiameter;

	@Column(name = "estimated_hole_diameter_user")
	private BigDecimal estimatedHoleDiameterUser;

	@Column(name = "estimated_max_load_per_delay")
	private BigDecimal estimatedMaxLoadPerDelay;

	@Column(name = "estimated_max_load_per_delay_user")
	private BigDecimal estimatedMaxLoadPerDelayUser;

	@Column(name = "estimated_p_p_v")
	private BigDecimal estimatedPPV;

	@Column(name = "estimated_p_p_v_user")
	private BigDecimal estimatedPPVUser;

	@Column(name = "estimated_pattern_burden")
	private BigDecimal estimatedPatternBurden;

	@Column(name = "estimated_pattern_burden_user")
	private BigDecimal estimatedPatternBurdenUser;

	@Column(name = "estimated_pattern_spacing")
	private BigDecimal estimatedPatternSpacing;

	@Column(name = "estimated_pattern_spacing_user")
	private BigDecimal estimatedPatternSpacingUser;

	@Column(name = "estimated_preblast_volume")
	private BigDecimal estimatedPreblastVolume;

	@Column(name = "estimated_preblast_volume_user")
	private BigDecimal estimatedPreblastVolumeUser;

	@Column(name = "estimated_sub_drill")
	private BigDecimal estimatedSubDrill;

	@Column(name = "estimated_sub_drill_user")
	private BigDecimal estimatedSubDrillUser;

	@Column(name = "estimated_surface_p_p_v")
	private BigDecimal estimatedSurfacePPV;

	@Column(name = "estimated_surface_p_p_v_user")
	private BigDecimal estimatedSurfacePPVUser;

	@Column(name = "estimated_total_explosives")
	private BigDecimal estimatedTotalExplosives;

	@Column(name = "estimated_total_explosives_user")
	private BigDecimal estimatedTotalExplosivesUser;

	@Column(name = "estimated_volume")
	private BigDecimal estimatedVolume;

	@Column(name = "estimated_volume_user")
	private BigDecimal estimatedVolumeUser;

	@Type(type = "jsonb")
	@Column(name = "excluded_event_ids", columnDefinition = "jsonb")
	private List<String> excludedEventIds;

	@Column(name = "explosive_mass_user1")
	private BigDecimal explosiveMassUser1;

	@Column(name = "explosive_mass_user10")
	private BigDecimal explosiveMassUser10;

	@Column(name = "explosive_mass_user2")
	private BigDecimal explosiveMassUser2;

	@Column(name = "explosive_mass_user3")
	private BigDecimal explosiveMassUser3;

	@Column(name = "explosive_mass_user4")
	private BigDecimal explosiveMassUser4;

	@Column(name = "explosive_mass_user5")
	private BigDecimal explosiveMassUser5;

	@Column(name = "explosive_mass_user6")
	private BigDecimal explosiveMassUser6;

	@Column(name = "explosive_mass_user7")
	private BigDecimal explosiveMassUser7;

	@Column(name = "explosive_mass_user8")
	private BigDecimal explosiveMassUser8;

	@Column(name = "explosive_mass_user9")
	private BigDecimal explosiveMassUser9;

	@Column(name = "explosive_mass1")
	private BigDecimal explosiveMass1;

	@Column(name = "explosive_mass10")
	private BigDecimal explosiveMass10;

	@Column(name = "explosive_mass2")
	private BigDecimal explosiveMass2;

	@Column(name = "explosive_mass3")
	private BigDecimal explosiveMass3;

	@Column(name = "explosive_mass4")
	private BigDecimal explosiveMass4;

	@Column(name = "explosive_mass5")
	private BigDecimal explosiveMass5;

	@Column(name = "explosive_mass6")
	private BigDecimal explosiveMass6;

	@Column(name = "explosive_mass7")
	private BigDecimal explosiveMass7;

	@Column(name = "explosive_mass8")
	private BigDecimal explosiveMass8;

	@Column(name = "explosive_mass9")
	private BigDecimal explosiveMass9;

	@Column(name = "explosive_type")
	private String explosiveType;

	@Column(name = "explosive_type_det_name1")
	private String explosiveTypeDetName1;

	@Column(name = "explosive_type_det_name10")
	private String explosiveTypeDetName10;

	@Column(name = "explosive_type_det_name2")
	private String explosiveTypeDetName2;

	@Column(name = "explosive_type_det_name3")
	private String explosiveTypeDetName3;

	@Column(name = "explosive_type_det_name4")
	private String explosiveTypeDetName4;

	@Column(name = "explosive_type_det_name5")
	private String explosiveTypeDetName5;

	@Column(name = "explosive_type_det_name6")
	private String explosiveTypeDetName6;

	@Column(name = "explosive_type_det_name7")
	private String explosiveTypeDetName7;

	@Column(name = "explosive_type_det_name8")
	private String explosiveTypeDetName8;

	@Column(name = "explosive_type_det_name9")
	private String explosiveTypeDetName9;

	@Column(name = "explosive_type_name1")
	private String explosiveTypeName1;

	@Column(name = "explosive_type_name10")
	private String explosiveTypeName10;

	@Column(name = "explosive_type_name2")
	private String explosiveTypeName2;

	@Column(name = "explosive_type_name3")
	private String explosiveTypeName3;

	@Column(name = "explosive_type_name4")
	private String explosiveTypeName4;

	@Column(name = "explosive_type_name5")
	private String explosiveTypeName5;

	@Column(name = "explosive_type_name6")
	private String explosiveTypeName6;

	@Column(name = "explosive_type_name7")
	private String explosiveTypeName7;

	@Column(name = "explosive_type_name8")
	private String explosiveTypeName8;

	@Column(name = "explosive_type_name9")
	private String explosiveTypeName9;

	@Column(name = "firing_location")
	private String firingLocation;

	@Column(name = "firing_location_id")
	private UUID firingLocationId;

	@Column(name = "firing_location_level")
	private String firingLocationLevel;

	private String flyrock;

	private String fragmentation;

	@Column(name = "from_level")
	private String fromLevel;

	private Point geom;

	private Point geom_user;

	@Column(name = "has_no_related_events")
	private boolean hasNoRelatedEvents;

	@Column(name = "hole_count")
	private BigDecimal holeCount;

	@Column(name = "hole_depth")
	private BigDecimal holeDepth;

	@Column(name = "hole_depth_user")
	private BigDecimal holeDepthUser;

	@Column(name = "hole_diameter")
	private BigDecimal holeDiameter;

	@Column(name = "hole_diameter_user")
	private BigDecimal holeDiameterUser;

	@Type(type = "jsonb")
	@Column(name = "included_event_ids", columnDefinition = "jsonb")
	private List<String> includedEventIds;

	@Column(name = "is_template")
	private boolean isTemplate;

	@Column(name = "job_number")
	private String jobNumber;

	private BigDecimal latitude;

	@Column(name = "latitude_user")
	private BigDecimal latitudeUser;

	private String levels;

	private String location;

	private String location2;

	private String location3;

	private String location4;

	@Column(name = "logger_count")
	private BigDecimal loggerCount;

	private BigDecimal longitude;

	@Column(name = "longitude_user")
	private BigDecimal longitudeUser;

	@Column(name = "max_load_per_delay")
	private BigDecimal maxLoadPerDelay;

	@Column(name = "max_load_per_delay_user")
	private BigDecimal maxLoadPerDelayUser;

	@Column(name = "measure_system_name")
	private String measureSystemName;

	@Column(name = "mining_method")
	private String miningMethod;

	@Column(name = "mining_method_id")
	private UUID miningMethodId;

	@Column(name = "muckpile_configuration")
	private String muckpileConfiguration;

	private String name;

	private String notes;

	private String orebody;

	@Column(name = "pattern_burden")
	private BigDecimal patternBurden;

	@Column(name = "pattern_burden_user")
	private BigDecimal patternBurdenUser;

	@Column(name = "pattern_spacing")
	private BigDecimal patternSpacing;

	@Column(name = "pattern_spacing_user")
	private BigDecimal patternSpacingUser;

	@Column(name = "pattern_type")
	private String patternType;

	@Column(name = "pattern_type_id")
	private UUID patternTypeId;

	@Column(name = "planned_blast_duration")
	private BigDecimal plannedBlastDuration;

	@Column(name = "powder_factor")
	private BigDecimal powderFactor;

	@Column(name = "powder_factor_user")
	private BigDecimal powderFactorUser;

	@Type(type = "jsonb")
	@Column(name = "product_type_names1", columnDefinition = "jsonb")
	private List<String> productTypeNames1;

	@Type(type = "jsonb")
	@Column(name = "product_type_names10", columnDefinition = "jsonb")
	private List<String> productTypeNames10;

	@Type(type = "jsonb")
	@Column(name = "product_type_names2", columnDefinition = "jsonb")
	private List<String> productTypeNames2;

	@Type(type = "jsonb")
	@Column(name = "product_type_names3", columnDefinition = "jsonb")
	private List<String> productTypeNames3;

	@Type(type = "jsonb")
	@Column(name = "product_type_names4", columnDefinition = "jsonb")
	private List<String> productTypeNames4;

	@Type(type = "jsonb")
	@Column(name = "product_type_names5", columnDefinition = "jsonb")
	private List<String> productTypeNames5;

	@Type(type = "jsonb")
	@Column(name = "product_type_names6", columnDefinition = "jsonb")
	private List<String> productTypeNames6;

	@Type(type = "jsonb")
	@Column(name = "product_type_names7", columnDefinition = "jsonb")
	private List<String> productTypeNames7;

	@Type(type = "jsonb")
	@Column(name = "product_type_names8", columnDefinition = "jsonb")
	private List<String> productTypeNames8;

	@Type(type = "jsonb")
	@Column(name = "product_type_names9", columnDefinition = "jsonb")
	private List<String> productTypeNames9;

	@Column(name = "quarry_site_id")
	private UUID quarrySiteId;

	@Column(name = "reviewed_by")
	private String reviewedBy;

	@Column(name = "ring_burden")
	private BigDecimal ringBurden;

	@Column(name = "ring_burden_user")
	private BigDecimal ringBurdenUser;

	@Column(name = "rock_type")
	private String rockType;

	@Column(name = "rock_type_id")
	private UUID rockTypeId;

	@Column(name = "safety_notice_number")
	private String safetyNoticeNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "stemming_material")
	private String stemmingMaterial;

	@Column(name = "stemming_material_id")
	private UUID stemmingMaterialId;

	@Column(name = "stope_name")
	private String stopeName;

	@Column(name = "sub_drill")
	private BigDecimal subDrill;

	@Column(name = "sub_drill_user")
	private BigDecimal subDrillUser;

	private String technician;

	private BigDecimal temperature;

	@Column(name = "temperature_user")
	private BigDecimal temperatureUser;

	@Column(name = "template_name")
	private String templateName;

	@Column(name = "timezone_offset")
	private BigDecimal timezoneOffset;

	@Column(name = "to_level")
	private String toLevel;

	@Column(name = "toe_spacing")
	private BigDecimal toeSpacing;

	@Column(name = "toe_spacing_user")
	private BigDecimal toeSpacingUser;

	@Column(name = "total_explosives")
	private BigDecimal totalExplosives;

	@Column(name = "total_explosives_user")
	private BigDecimal totalExplosivesUser;

	@Column(name = "total_totes")
	private BigDecimal totalTotes;

	private String weather;

	@Column(name = "weather_id")
	private UUID weatherId;

	@Column(name = "weight_per_tote")
	private BigDecimal weightPerTote;

	@Column(name = "weight_per_tote_user")
	private BigDecimal weightPerToteUser;

	@Column(name = "wind_direction")
	private String windDirection;

	@Column(name = "wind_direction_id")
	private UUID windDirectionId;

	@Column(name = "wind_velocity")
	private BigDecimal windVelocity;

	@Column(name = "wind_velocity_id")
	private UUID windVelocityId;

	@Column(name = "wind_velocity_user")
	private BigDecimal windVelocityUser;

	public UUID getBlastId() {
		return this.blastId;
	}
 
	public void setBlastId(final UUID blastId) {
		this.blastId = blastId;
	}

	public BigDecimal getBenchHeight() {
		return this.benchHeight;
	}

	public void setBenchHeight(final BigDecimal benchHeight) {
		this.benchHeight = benchHeight;
	}

	public BigDecimal getBenchHeightUser() {
		return this.benchHeightUser;
	}

	public void setBenchHeightUser(final BigDecimal benchHeightUser) {
		this.benchHeightUser = benchHeightUser;
	}

	public UUID getBenchId() {
		return this.benchId;
	}

	public void setBenchId(final UUID benchId) {
		this.benchId = benchId;
	}

	public List<String> getBlastCategories() {
		return this.blastCategories;
	}

	@Trim
	public void setBlastCategories(final List<String> blastCategories) {
		this.blastCategories = blastCategories;
	}

	public UUID getBlastDetailCommentId() {
		return this.blastDetailCommentId;
	}

	public void setBlastDetailCommentId(final UUID blastDetailCommentId) {
		this.blastDetailCommentId = blastDetailCommentId;
	}

	public String getBlastLetterNumber() {
		return this.blastLetterNumber;
	}

	@Trim
	public void setBlastLetterNumber(final String blastLetterNumber) {
		this.blastLetterNumber = blastLetterNumber;
	}

	public String getBlastNumber() {
		return this.blastNumber;
	}

	@Trim
	public void setBlastNumber(final String blastNumber) {
		this.blastNumber = blastNumber;
	}

	public String getBlastType() {
		return this.blastType;
	}

	@Trim
	public void setBlastType(final String blastType) {
		this.blastType = blastType;
	}

	public String getBlasterName() {
		return this.blasterName;
	}

	@Trim
	public void setBlasterName(final String blasterName) {
		this.blasterName = blasterName;
	}

	public UUID getBlasterNameId() {
		return this.blasterNameId;
	}

	public void setBlasterNameId(final UUID blasterNameId) {
		this.blasterNameId = blasterNameId;
	}

	public BigDecimal getBufferLineSpacing() {
		return this.bufferLineSpacing;
	}

	public void setBufferLineSpacing(final BigDecimal bufferLineSpacing) {
		this.bufferLineSpacing = bufferLineSpacing;
	}

	public BigDecimal getBufferLineSpacingUser() {
		return this.bufferLineSpacingUser;
	}

	public void setBufferLineSpacingUser(final BigDecimal bufferLineSpacingUser) {
		this.bufferLineSpacingUser = bufferLineSpacingUser;
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

	public BigDecimal getCollar() {
		return this.collar;
	}

	public void setCollar(final BigDecimal collar) {
		this.collar = collar;
	}

	public BigDecimal getCollarUser() {
		return this.collarUser;
	}

	public void setCollarUser(final BigDecimal collarUser) {
		this.collarUser = collarUser;
	}

	public String getCompletedBy() {
		return this.completedBy;
	}

	@Trim
	public void setCompletedBy(final String completedBy) {
		this.completedBy = completedBy;
	}

	public String getCustom1() {
		return this.custom1;
	}

	@Trim
	public void setCustom1(final String custom1) {
		this.custom1 = custom1;
	}

	public String getCustom2() {
		return this.custom2;
	}

	@Trim
	public void setCustom2(final String custom2) {
		this.custom2 = custom2;
	}

	public String getCustom3() {
		return this.custom3;
	}

	@Trim
	public void setCustom3(final String custom3) {
		this.custom3 = custom3;
	}

	public BigDecimal getDeckCount() {
		return this.deckCount;
	}

	public void setDeckCount(final BigDecimal deckCount) {
		this.deckCount = deckCount;
	}

	public String getDescription() {
		return this.description;
	}

	@Trim
	public void setDescription(final String description) {
		this.description = description;
	}

	public String getDetonationMethod() {
		return this.detonationMethod;
	}

	@Trim
	public void setDetonationMethod(final String detonationMethod) {
		this.detonationMethod = detonationMethod;
	}

	public UUID getDetonationMethodId() {
		return this.detonationMethodId;
	}

	public void setDetonationMethodId(final UUID detonationMethodId) {
		this.detonationMethodId = detonationMethodId;
	}

	public BigDecimal getDetonatorCount() {
		return this.detonatorCount;
	}

	public void setDetonatorCount(final BigDecimal detonatorCount) {
		this.detonatorCount = detonatorCount;
	}

	public BigDecimal getDetonatorCount1() {
		return this.detonatorCount1;
	}

	public void setDetonatorCount1(final BigDecimal detonatorCount1) {
		this.detonatorCount1 = detonatorCount1;
	}

	public BigDecimal getDetonatorCount2() {
		return this.detonatorCount2;
	}

	public void setDetonatorCount2(final BigDecimal detonatorCount2) {
		this.detonatorCount2 = detonatorCount2;
	}

	public BigDecimal getDetonatorCount3() {
		return this.detonatorCount3;
	}

	public void setDetonatorCount3(final BigDecimal detonatorCount3) {
		this.detonatorCount3 = detonatorCount3;
	}

	public BigDecimal getDetonatorCount4() {
		return this.detonatorCount4;
	}

	public void setDetonatorCount4(final BigDecimal detonatorCount4) {
		this.detonatorCount4 = detonatorCount4;
	}

	public List<String> getDetonatorTypeNames1() {
		return this.detonatorTypeNames1;
	}

	@Trim
	public void setDetonatorTypeNames1(final List<String> detonatorTypeNames1) {
		this.detonatorTypeNames1 = detonatorTypeNames1;
	}

	public List<String> getDetonatorTypeNames10() {
		return this.detonatorTypeNames10;
	}

	@Trim
	public void setDetonatorTypeNames10(final List<String> detonatorTypeNames10) {
		this.detonatorTypeNames10 = detonatorTypeNames10;
	}

	public List<String> getDetonatorTypeNames2() {
		return this.detonatorTypeNames2;
	}

	@Trim
	public void setDetonatorTypeNames2(final List<String> detonatorTypeNames2) {
		this.detonatorTypeNames2 = detonatorTypeNames2;
	}

	public List<String> getDetonatorTypeNames3() {
		return this.detonatorTypeNames3;
	}

	@Trim
	public void setDetonatorTypeNames3(final List<String> detonatorTypeNames3) {
		this.detonatorTypeNames3 = detonatorTypeNames3;
	}

	public List<String> getDetonatorTypeNames4() {
		return this.detonatorTypeNames4;
	}

	@Trim
	public void setDetonatorTypeNames4(final List<String> detonatorTypeNames4) {
		this.detonatorTypeNames4 = detonatorTypeNames4;
	}

	public List<String> getDetonatorTypeNames5() {
		return this.detonatorTypeNames5;
	}

	@Trim
	public void setDetonatorTypeNames5(final List<String> detonatorTypeNames5) {
		this.detonatorTypeNames5 = detonatorTypeNames5;
	}

	public List<String> getDetonatorTypeNames6() {
		return this.detonatorTypeNames6;
	}

	@Trim
	public void setDetonatorTypeNames6(final List<String> detonatorTypeNames6) {
		this.detonatorTypeNames6 = detonatorTypeNames6;
	}

	public List<String> getDetonatorTypeNames7() {
		return this.detonatorTypeNames7;
	}

	@Trim
	public void setDetonatorTypeNames7(final List<String> detonatorTypeNames7) {
		this.detonatorTypeNames7 = detonatorTypeNames7;
	}

	public List<String> getDetonatorTypeNames8() {
		return this.detonatorTypeNames8;
	}

	@Trim
	public void setDetonatorTypeNames8(final List<String> detonatorTypeNames8) {
		this.detonatorTypeNames8 = detonatorTypeNames8;
	}

	public List<String> getDetonatorTypeNames9() {
		return this.detonatorTypeNames9;
	}

	@Trim
	public void setDetonatorTypeNames9(final List<String> detonatorTypeNames9) {
		this.detonatorTypeNames9 = detonatorTypeNames9;
	}

	public BigDecimal getDrillDepth() {
		return this.drillDepth;
	}

	public void setDrillDepth(final BigDecimal drillDepth) {
		this.drillDepth = drillDepth;
	}

	public BigDecimal getDrillDepthUser() {
		return this.drillDepthUser;
	}

	public void setDrillDepthUser(final BigDecimal drillDepthUser) {
		this.drillDepthUser = drillDepthUser;
	}

	public BigDecimal getElevation() {
		return this.elevation;
	}

	public void setElevation(final BigDecimal elevation) {
		this.elevation = elevation;
	}

	public BigDecimal getElevationUser() {
		return this.elevationUser;
	}

	public void setElevationUser(final BigDecimal elevationUser) {
		this.elevationUser = elevationUser;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getEstimatedCollar() {
		return this.estimatedCollar;
	}

	public void setEstimatedCollar(final BigDecimal estimatedCollar) {
		this.estimatedCollar = estimatedCollar;
	}

	public BigDecimal getEstimatedCollarUser() {
		return this.estimatedCollarUser;
	}

	public void setEstimatedCollarUser(final BigDecimal estimatedCollarUser) {
		this.estimatedCollarUser = estimatedCollarUser;
	}

	public BigDecimal getEstimatedDrillDepthUser() {
		return this.estimatedDrillDepthUser;
	}

	public void setEstimatedDrillDepthUser(
			final BigDecimal estimatedDrillDepthUser) {
		this.estimatedDrillDepthUser = estimatedDrillDepthUser;
	}

	public BigDecimal getEstimatedHoleCount() {
		return this.estimatedHoleCount;
	}

	public void setEstimatedHoleCount(final BigDecimal estimatedHoleCount) {
		this.estimatedHoleCount = estimatedHoleCount;
	}

	public BigDecimal getEstimatedHoleDepth() {
		return this.estimatedHoleDepth;
	}

	public void setEstimatedHoleDepth(final BigDecimal estimatedHoleDepth) {
		this.estimatedHoleDepth = estimatedHoleDepth;
	}

	public BigDecimal getEstimatedHoleDepthUser() {
		return this.estimatedHoleDepthUser;
	}

	public void setEstimatedHoleDepthUser(
			final BigDecimal estimatedHoleDepthUser) {
		this.estimatedHoleDepthUser = estimatedHoleDepthUser;
	}

	public BigDecimal getEstimatedHoleDiameter() {
		return this.estimatedHoleDiameter;
	}

	public void setEstimatedHoleDiameter(final BigDecimal estimatedHoleDiameter) {
		this.estimatedHoleDiameter = estimatedHoleDiameter;
	}

	public BigDecimal getEstimatedHoleDiameterUser() {
		return this.estimatedHoleDiameterUser;
	}

	public void setEstimatedHoleDiameterUser(
			final BigDecimal estimatedHoleDiameterUser) {
		this.estimatedHoleDiameterUser = estimatedHoleDiameterUser;
	}

	public BigDecimal getEstimatedMaxLoadPerDelay() {
		return this.estimatedMaxLoadPerDelay;
	}

	public void setEstimatedMaxLoadPerDelay(
			final BigDecimal estimatedMaxLoadPerDelay) {
		this.estimatedMaxLoadPerDelay = estimatedMaxLoadPerDelay;
	}

	public BigDecimal getEstimatedMaxLoadPerDelayUser() {
		return this.estimatedMaxLoadPerDelayUser;
	}

	public void setEstimatedMaxLoadPerDelayUser(
			final BigDecimal estimatedMaxLoadPerDelayUser) {
		this.estimatedMaxLoadPerDelayUser = estimatedMaxLoadPerDelayUser;
	}

	public BigDecimal getEstimatedPPV() {
		return this.estimatedPPV;
	}

	public void setEstimatedPPV(final BigDecimal estimatedPPV) {
		this.estimatedPPV = estimatedPPV;
	}

	public BigDecimal getEstimatedPPVUser() {
		return this.estimatedPPVUser;
	}

	public void setEstimatedPPVUser(final BigDecimal estimatedPPVUser) {
		this.estimatedPPVUser = estimatedPPVUser;
	}

	public BigDecimal getEstimatedPatternBurden() {
		return this.estimatedPatternBurden;
	}

	public void setEstimatedPatternBurden(
			final BigDecimal estimatedPatternBurden) {
		this.estimatedPatternBurden = estimatedPatternBurden;
	}

	public BigDecimal getEstimatedPatternBurdenUser() {
		return this.estimatedPatternBurdenUser;
	}

	public void setEstimatedPatternBurdenUser(
			final BigDecimal estimatedPatternBurdenUser) {
		this.estimatedPatternBurdenUser = estimatedPatternBurdenUser;
	}

	public BigDecimal getEstimatedPatternSpacing() {
		return this.estimatedPatternSpacing;
	}

	public void setEstimatedPatternSpacing(
			final BigDecimal estimatedPatternSpacing) {
		this.estimatedPatternSpacing = estimatedPatternSpacing;
	}

	public BigDecimal getEstimatedPatternSpacingUser() {
		return this.estimatedPatternSpacingUser;
	}

	public void setEstimatedPatternSpacingUser(
			final BigDecimal estimatedPatternSpacingUser) {
		this.estimatedPatternSpacingUser = estimatedPatternSpacingUser;
	}

	public BigDecimal getEstimatedPreblastVolume() {
		return this.estimatedPreblastVolume;
	}

	public void setEstimatedPreblastVolume(
			final BigDecimal estimatedPreblastVolume) {
		this.estimatedPreblastVolume = estimatedPreblastVolume;
	}

	public BigDecimal getEstimatedPreblastVolumeUser() {
		return this.estimatedPreblastVolumeUser;
	}

	public void setEstimatedPreblastVolumeUser(
			final BigDecimal estimatedPreblastVolumeUser) {
		this.estimatedPreblastVolumeUser = estimatedPreblastVolumeUser;
	}

	public BigDecimal getEstimatedSubDrill() {
		return this.estimatedSubDrill;
	}

	public void setEstimatedSubDrill(final BigDecimal estimatedSubDrill) {
		this.estimatedSubDrill = estimatedSubDrill;
	}

	public BigDecimal getEstimatedSubDrillUser() {
		return this.estimatedSubDrillUser;
	}

	public void setEstimatedSubDrillUser(final BigDecimal estimatedSubDrillUser) {
		this.estimatedSubDrillUser = estimatedSubDrillUser;
	}

	public BigDecimal getEstimatedSurfacePPV() {
		return this.estimatedSurfacePPV;
	}

	public void setEstimatedSurfacePPV(final BigDecimal estimatedSurfacePPV) {
		this.estimatedSurfacePPV = estimatedSurfacePPV;
	}

	public BigDecimal getEstimatedSurfacePPVUser() {
		return this.estimatedSurfacePPVUser;
	}

	public void setEstimatedSurfacePPVUser(
			final BigDecimal estimatedSurfacePPVUser) {
		this.estimatedSurfacePPVUser = estimatedSurfacePPVUser;
	}

	public BigDecimal getEstimatedTotalExplosives() {
		return this.estimatedTotalExplosives;
	}

	public void setEstimatedTotalExplosives(
			final BigDecimal estimatedTotalExplosives) {
		this.estimatedTotalExplosives = estimatedTotalExplosives;
	}

	public BigDecimal getEstimatedTotalExplosivesUser() {
		return this.estimatedTotalExplosivesUser;
	}

	public void setEstimatedTotalExplosivesUser(
			final BigDecimal estimatedTotalExplosivesUser) {
		this.estimatedTotalExplosivesUser = estimatedTotalExplosivesUser;
	}

	public BigDecimal getEstimatedVolume() {
		return this.estimatedVolume;
	}

	public void setEstimatedVolume(final BigDecimal estimatedVolume) {
		this.estimatedVolume = estimatedVolume;
	}

	public BigDecimal getEstimatedVolumeUser() {
		return this.estimatedVolumeUser;
	}

	public void setEstimatedVolumeUser(final BigDecimal estimatedVolumeUser) {
		this.estimatedVolumeUser = estimatedVolumeUser;
	}

	public List<String> getExcludedEventIds() {
		return this.excludedEventIds;
	}

	@Trim
	public void setExcludedEventIds(final List<String> excludedEventIds) {
		this.excludedEventIds = excludedEventIds;
	}

	public BigDecimal getExplosiveMassUser1() {
		return this.explosiveMassUser1;
	}

	public void setExplosiveMassUser1(final BigDecimal explosiveMassUser1) {
		this.explosiveMassUser1 = explosiveMassUser1;
	}

	public BigDecimal getExplosiveMassUser10() {
		return this.explosiveMassUser10;
	}

	public void setExplosiveMassUser10(final BigDecimal explosiveMassUser10) {
		this.explosiveMassUser10 = explosiveMassUser10;
	}

	public BigDecimal getExplosiveMassUser2() {
		return this.explosiveMassUser2;
	}

	public void setExplosiveMassUser2(final BigDecimal explosiveMassUser2) {
		this.explosiveMassUser2 = explosiveMassUser2;
	}

	public BigDecimal getExplosiveMassUser3() {
		return this.explosiveMassUser3;
	}

	public void setExplosiveMassUser3(final BigDecimal explosiveMassUser3) {
		this.explosiveMassUser3 = explosiveMassUser3;
	}

	public BigDecimal getExplosiveMassUser4() {
		return this.explosiveMassUser4;
	}

	public void setExplosiveMassUser4(final BigDecimal explosiveMassUser4) {
		this.explosiveMassUser4 = explosiveMassUser4;
	}

	public BigDecimal getExplosiveMassUser5() {
		return this.explosiveMassUser5;
	}

	public void setExplosiveMassUser5(final BigDecimal explosiveMassUser5) {
		this.explosiveMassUser5 = explosiveMassUser5;
	}

	public BigDecimal getExplosiveMassUser6() {
		return this.explosiveMassUser6;
	}

	public void setExplosiveMassUser6(final BigDecimal explosiveMassUser6) {
		this.explosiveMassUser6 = explosiveMassUser6;
	}

	public BigDecimal getExplosiveMassUser7() {
		return this.explosiveMassUser7;
	}

	public void setExplosiveMassUser7(final BigDecimal explosiveMassUser7) {
		this.explosiveMassUser7 = explosiveMassUser7;
	}

	public BigDecimal getExplosiveMassUser8() {
		return this.explosiveMassUser8;
	}

	public void setExplosiveMassUser8(final BigDecimal explosiveMassUser8) {
		this.explosiveMassUser8 = explosiveMassUser8;
	}

	public BigDecimal getExplosiveMassUser9() {
		return this.explosiveMassUser9;
	}

	public void setExplosiveMassUser9(final BigDecimal explosiveMassUser9) {
		this.explosiveMassUser9 = explosiveMassUser9;
	}

	public BigDecimal getExplosiveMass1() {
		return this.explosiveMass1;
	}

	public void setExplosiveMass1(final BigDecimal explosiveMass1) {
		this.explosiveMass1 = explosiveMass1;
	}

	public BigDecimal getExplosiveMass10() {
		return this.explosiveMass10;
	}

	public void setExplosiveMass10(final BigDecimal explosiveMass10) {
		this.explosiveMass10 = explosiveMass10;
	}

	public BigDecimal getExplosiveMass2() {
		return this.explosiveMass2;
	}

	public void setExplosiveMass2(final BigDecimal explosiveMass2) {
		this.explosiveMass2 = explosiveMass2;
	}

	public BigDecimal getExplosiveMass3() {
		return this.explosiveMass3;
	}

	public void setExplosiveMass3(final BigDecimal explosiveMass3) {
		this.explosiveMass3 = explosiveMass3;
	}

	public BigDecimal getExplosiveMass4() {
		return this.explosiveMass4;
	}

	public void setExplosiveMass4(final BigDecimal explosiveMass4) {
		this.explosiveMass4 = explosiveMass4;
	}

	public BigDecimal getExplosiveMass5() {
		return this.explosiveMass5;
	}

	public void setExplosiveMass5(final BigDecimal explosiveMass5) {
		this.explosiveMass5 = explosiveMass5;
	}

	public BigDecimal getExplosiveMass6() {
		return this.explosiveMass6;
	}

	public void setExplosiveMass6(final BigDecimal explosiveMass6) {
		this.explosiveMass6 = explosiveMass6;
	}

	public BigDecimal getExplosiveMass7() {
		return this.explosiveMass7;
	}

	public void setExplosiveMass7(final BigDecimal explosiveMass7) {
		this.explosiveMass7 = explosiveMass7;
	}

	public BigDecimal getExplosiveMass8() {
		return this.explosiveMass8;
	}

	public void setExplosiveMass8(final BigDecimal explosiveMass8) {
		this.explosiveMass8 = explosiveMass8;
	}

	public BigDecimal getExplosiveMass9() {
		return this.explosiveMass9;
	}

	public void setExplosiveMass9(final BigDecimal explosiveMass9) {
		this.explosiveMass9 = explosiveMass9;
	}

	public String getExplosiveType() {
		return this.explosiveType;
	}

	@Trim
	public void setExplosiveType(final String explosiveType) {
		this.explosiveType = explosiveType;
	}

	public String getExplosiveTypeDetName1() {
		return this.explosiveTypeDetName1;
	}

	@Trim
	public void setExplosiveTypeDetName1(final String explosiveTypeDetName1) {
		this.explosiveTypeDetName1 = explosiveTypeDetName1;
	}

	public String getExplosiveTypeDetName10() {
		return this.explosiveTypeDetName10;
	}

	@Trim
	public void setExplosiveTypeDetName10(final String explosiveTypeDetName10) {
		this.explosiveTypeDetName10 = explosiveTypeDetName10;
	}

	public String getExplosiveTypeDetName2() {
		return this.explosiveTypeDetName2;
	}

	@Trim
	public void setExplosiveTypeDetName2(final String explosiveTypeDetName2) {
		this.explosiveTypeDetName2 = explosiveTypeDetName2;
	}

	public String getExplosiveTypeDetName3() {
		return this.explosiveTypeDetName3;
	}

	@Trim
	public void setExplosiveTypeDetName3(final String explosiveTypeDetName3) {
		this.explosiveTypeDetName3 = explosiveTypeDetName3;
	}

	public String getExplosiveTypeDetName4() {
		return this.explosiveTypeDetName4;
	}

	@Trim
	public void setExplosiveTypeDetName4(final String explosiveTypeDetName4) {
		this.explosiveTypeDetName4 = explosiveTypeDetName4;
	}

	public String getExplosiveTypeDetName5() {
		return this.explosiveTypeDetName5;
	}

	@Trim
	public void setExplosiveTypeDetName5(final String explosiveTypeDetName5) {
		this.explosiveTypeDetName5 = explosiveTypeDetName5;
	}

	public String getExplosiveTypeDetName6() {
		return this.explosiveTypeDetName6;
	}

	@Trim
	public void setExplosiveTypeDetName6(final String explosiveTypeDetName6) {
		this.explosiveTypeDetName6 = explosiveTypeDetName6;
	}

	public String getExplosiveTypeDetName7() {
		return this.explosiveTypeDetName7;
	}

	@Trim
	public void setExplosiveTypeDetName7(final String explosiveTypeDetName7) {
		this.explosiveTypeDetName7 = explosiveTypeDetName7;
	}

	public String getExplosiveTypeDetName8() {
		return this.explosiveTypeDetName8;
	}

	@Trim
	public void setExplosiveTypeDetName8(final String explosiveTypeDetName8) {
		this.explosiveTypeDetName8 = explosiveTypeDetName8;
	}

	public String getExplosiveTypeDetName9() {
		return this.explosiveTypeDetName9;
	}

	@Trim
	public void setExplosiveTypeDetName9(final String explosiveTypeDetName9) {
		this.explosiveTypeDetName9 = explosiveTypeDetName9;
	}

	public String getExplosiveTypeName1() {
		return this.explosiveTypeName1;
	}

	@Trim
	public void setExplosiveTypeName1(final String explosiveTypeName1) {
		this.explosiveTypeName1 = explosiveTypeName1;
	}

	public String getExplosiveTypeName10() {
		return this.explosiveTypeName10;
	}

	@Trim
	public void setExplosiveTypeName10(final String explosiveTypeName10) {
		this.explosiveTypeName10 = explosiveTypeName10;
	}

	public String getExplosiveTypeName2() {
		return this.explosiveTypeName2;
	}

	@Trim
	public void setExplosiveTypeName2(final String explosiveTypeName2) {
		this.explosiveTypeName2 = explosiveTypeName2;
	}

	public String getExplosiveTypeName3() {
		return this.explosiveTypeName3;
	}

	@Trim
	public void setExplosiveTypeName3(final String explosiveTypeName3) {
		this.explosiveTypeName3 = explosiveTypeName3;
	}

	public String getExplosiveTypeName4() {
		return this.explosiveTypeName4;
	}

	@Trim
	public void setExplosiveTypeName4(final String explosiveTypeName4) {
		this.explosiveTypeName4 = explosiveTypeName4;
	}

	public String getExplosiveTypeName5() {
		return this.explosiveTypeName5;
	}

	@Trim
	public void setExplosiveTypeName5(final String explosiveTypeName5) {
		this.explosiveTypeName5 = explosiveTypeName5;
	}

	public String getExplosiveTypeName6() {
		return this.explosiveTypeName6;
	}

	@Trim
	public void setExplosiveTypeName6(final String explosiveTypeName6) {
		this.explosiveTypeName6 = explosiveTypeName6;
	}

	public String getExplosiveTypeName7() {
		return this.explosiveTypeName7;
	}

	@Trim
	public void setExplosiveTypeName7(final String explosiveTypeName7) {
		this.explosiveTypeName7 = explosiveTypeName7;
	}

	public String getExplosiveTypeName8() {
		return this.explosiveTypeName8;
	}

	@Trim
	public void setExplosiveTypeName8(final String explosiveTypeName8) {
		this.explosiveTypeName8 = explosiveTypeName8;
	}

	public String getExplosiveTypeName9() {
		return this.explosiveTypeName9;
	}

	@Trim
	public void setExplosiveTypeName9(final String explosiveTypeName9) {
		this.explosiveTypeName9 = explosiveTypeName9;
	}

	public String getFiringLocation() {
		return this.firingLocation;
	}

	@Trim
	public void setFiringLocation(final String firingLocation) {
		this.firingLocation = firingLocation;
	}

	public UUID getFiringLocationId() {
		return this.firingLocationId;
	}

	public void setFiringLocationId(final UUID firingLocationId) {
		this.firingLocationId = firingLocationId;
	}

	public String getFiringLocationLevel() {
		return this.firingLocationLevel;
	}

	@Trim
	public void setFiringLocationLevel(final String firingLocationLevel) {
		this.firingLocationLevel = firingLocationLevel;
	}

	public String getFlyrock() {
		return this.flyrock;
	}

	@Trim
	public void setFlyrock(final String flyrock) {
		this.flyrock = flyrock;
	}

	public String getFragmentation() {
		return this.fragmentation;
	}

	@Trim
	public void setFragmentation(final String fragmentation) {
		this.fragmentation = fragmentation;
	}

	public String getFromLevel() {
		return this.fromLevel;
	}

	public void setFromLevel(final String fromLevel) {
		this.fromLevel = fromLevel;
	}

	public Point getGeom() {
		return this.geom;
	}

	public void setGeom(final Point geom) {
		this.geom = geom;
	}

	public boolean getHasNoRelatedEvents() {
		return this.hasNoRelatedEvents;
	}

	public void setHasNoRelatedEvents(final boolean hasNoRelatedEvents) {
		this.hasNoRelatedEvents = hasNoRelatedEvents;
	}

	public BigDecimal getHoleCount() {
		return this.holeCount;
	}

	public void setHoleCount(final BigDecimal holeCount) {
		this.holeCount = holeCount;
	}

	public BigDecimal getHoleDepth() {
		return this.holeDepth;
	}

	public void setHoleDepth(final BigDecimal holeDepth) {
		this.holeDepth = holeDepth;
	}

	public BigDecimal getHoleDepthUser() {
		return this.holeDepthUser;
	}

	public void setHoleDepthUser(final BigDecimal holeDepthUser) {
		this.holeDepthUser = holeDepthUser;
	}

	public BigDecimal getHoleDiameter() {
		return this.holeDiameter;
	}

	public void setHoleDiameter(final BigDecimal holeDiameter) {
		this.holeDiameter = holeDiameter;
	}

	public BigDecimal getHoleDiameterUser() {
		return this.holeDiameterUser;
	}

	public void setHoleDiameterUser(final BigDecimal holeDiameterUser) {
		this.holeDiameterUser = holeDiameterUser;
	}

	public List<String> getIncludedEventIds() {
		return this.includedEventIds;
	}

	@Trim
	public void setIncludedEventIds(final List<String> includedEventIds) {
		this.includedEventIds = includedEventIds;
	}

	public boolean getIsTemplate() {
		return this.isTemplate;
	}

	public void setIsTemplate(final boolean isTemplate) {
		this.isTemplate = isTemplate;
	}

	public String getJobNumber() {
		return this.jobNumber;
	}

	@Trim
	public void setJobNumber(final String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(final BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLatitudeUser() {
		return this.latitudeUser;
	}

	public void setLatitudeUser(final BigDecimal latitudeUser) {
		this.latitudeUser = latitudeUser;
	}

	public String getLevels() {
		return this.levels;
	}

	@Trim
	public void setLevels(final String levels) {
		this.levels = levels;
	}

	public String getLocation() {
		return this.location;
	}

	@Trim
	public void setLocation(final String location) {
		this.location = location;
	}

	public String getLocation2() {
		return this.location2;
	}

	@Trim
	public void setLocation2(final String location2) {
		this.location2 = location2;
	}

	public String getLocation3() {
		return this.location3;
	}

	@Trim
	public void setLocation3(final String location3) {
		this.location3 = location3;
	}

	public String getLocation4() {
		return this.location4;
	}

	@Trim
	public void setLocation4(final String location4) {
		this.location4 = location4;
	}

	public BigDecimal getLoggerCount() {
		return this.loggerCount;
	}

	public void setLoggerCount(final BigDecimal loggerCount) {
		this.loggerCount = loggerCount;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(final BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLongitudeUser() {
		return this.longitudeUser;
	}

	public void setLongitudeUser(final BigDecimal longitudeUser) {
		this.longitudeUser = longitudeUser;
	}

	public BigDecimal getMaxLoadPerDelay() {
		return this.maxLoadPerDelay;
	}

	public void setMaxLoadPerDelay(final BigDecimal maxLoadPerDelay) {
		this.maxLoadPerDelay = maxLoadPerDelay;
	}

	public BigDecimal getMaxLoadPerDelayUser() {
		return this.maxLoadPerDelayUser;
	}

	public void setMaxLoadPerDelayUser(final BigDecimal maxLoadPerDelayUser) {
		this.maxLoadPerDelayUser = maxLoadPerDelayUser;
	}

	public String getMeasureSystemName() {
		return this.measureSystemName;
	}

	@Trim
	public void setMeasureSystemName(final String measureSystemName) {
		this.measureSystemName = measureSystemName;
	}

	public String getMiningMethod() {
		return this.miningMethod;
	}

	@Trim
	public void setMiningMethod(final String miningMethod) {
		this.miningMethod = miningMethod;
	}

	public UUID getMiningMethodId() {
		return this.miningMethodId;
	}

	public void setMiningMethodId(final UUID miningMethodId) {
		this.miningMethodId = miningMethodId;
	}

	public String getMuckpileConfiguration() {
		return this.muckpileConfiguration;
	}

	@Trim
	public void setMuckpileConfiguration(final String muckpileConfiguration) {
		this.muckpileConfiguration = muckpileConfiguration;
	}

	public String getName() {
		return this.name;
	}

	@Trim
	public void setName(final String name) {
		this.name = name;
	}

	public String getNotes() {
		return this.notes;
	}

	@Trim
	public void setNotes(final String notes) {
		this.notes = notes;
	}

	public String getOrebody() {
		return this.orebody;
	}

	@Trim
	public void setOrebody(final String orebody) {
		this.orebody = orebody;
	}

	public BigDecimal getPatternBurden() {
		return this.patternBurden;
	}

	public void setPatternBurden(final BigDecimal patternBurden) {
		this.patternBurden = patternBurden;
	}

	public BigDecimal getPatternBurdenUser() {
		return this.patternBurdenUser;
	}

	public void setPatternBurdenUser(final BigDecimal patternBurdenUser) {
		this.patternBurdenUser = patternBurdenUser;
	}

	public BigDecimal getPatternSpacing() {
		return this.patternSpacing;
	}

	public void setPatternSpacing(final BigDecimal patternSpacing) {
		this.patternSpacing = patternSpacing;
	}

	public BigDecimal getPatternSpacingUser() {
		return this.patternSpacingUser;
	}

	public void setPatternSpacingUser(final BigDecimal patternSpacingUser) {
		this.patternSpacingUser = patternSpacingUser;
	}

	public String getPatternType() {
		return this.patternType;
	}

	@Trim
	public void setPatternType(final String patternType) {
		this.patternType = patternType;
	}

	public UUID getPatternTypeId() {
		return this.patternTypeId;
	}

	public void setPatternTypeId(final UUID patternTypeId) {
		this.patternTypeId = patternTypeId;
	}

	public BigDecimal getPlannedBlastDuration() {
		return this.plannedBlastDuration;
	}

	public void setPlannedBlastDuration(final BigDecimal plannedBlastDuration) {
		this.plannedBlastDuration = plannedBlastDuration;
	}

	public BigDecimal getPowderFactor() {
		return this.powderFactor;
	}

	public void setPowderFactor(final BigDecimal powderFactor) {
		this.powderFactor = powderFactor;
	}

	public BigDecimal getPowderFactorUser() {
		return this.powderFactorUser;
	}

	public void setPowderFactorUser(final BigDecimal powderFactorUser) {
		this.powderFactorUser = powderFactorUser;
	}

	public List<String> getProductTypeNames1() {
		return this.productTypeNames1;
	}

	@Trim
	public void setProductTypeNames1(final List<String> productTypeNames1) {
		this.productTypeNames1 = productTypeNames1;
	}

	public List<String> getProductTypeNames10() {
		return this.productTypeNames10;
	}

	@Trim
	public void setProductTypeNames10(final List<String> productTypeNames10) {
		this.productTypeNames10 = productTypeNames10;
	}

	public List<String> getProductTypeNames2() {
		return this.productTypeNames2;
	}

	@Trim
	public void setProductTypeNames2(final List<String> productTypeNames2) {
		this.productTypeNames2 = productTypeNames2;
	}

	public List<String> getProductTypeNames3() {
		return this.productTypeNames3;
	}

	@Trim
	public void setProductTypeNames3(final List<String> productTypeNames3) {
		this.productTypeNames3 = productTypeNames3;
	}

	public List<String> getProductTypeNames4() {
		return this.productTypeNames4;
	}

	@Trim
	public void setProductTypeNames4(final List<String> productTypeNames4) {
		this.productTypeNames4 = productTypeNames4;
	}

	public List<String> getProductTypeNames5() {
		return this.productTypeNames5;
	}

	@Trim
	public void setProductTypeNames5(final List<String> productTypeNames5) {
		this.productTypeNames5 = productTypeNames5;
	}

	public List<String> getProductTypeNames6() {
		return this.productTypeNames6;
	}

	@Trim
	public void setProductTypeNames6(final List<String> productTypeNames6) {
		this.productTypeNames6 = productTypeNames6;
	}

	public List<String> getProductTypeNames7() {
		return this.productTypeNames7;
	}

	@Trim
	public void setProductTypeNames7(final List<String> productTypeNames7) {
		this.productTypeNames7 = productTypeNames7;
	}

	public List<String> getProductTypeNames8() {
		return this.productTypeNames8;
	}

	@Trim
	public void setProductTypeNames8(final List<String> productTypeNames8) {
		this.productTypeNames8 = productTypeNames8;
	}

	public List<String> getProductTypeNames9() {
		return this.productTypeNames9;
	}

	@Trim
	public void setProductTypeNames9(final List<String> productTypeNames9) {
		this.productTypeNames9 = productTypeNames9;
	}

	public UUID getQuarrySiteId() {
		return this.quarrySiteId;
	}

	public void setQuarrySiteId(final UUID quarrySiteId) {
		this.quarrySiteId = quarrySiteId;
	}

	public String getReviewedBy() {
		return this.reviewedBy;
	}

	@Trim
	public void setReviewedBy(final String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public BigDecimal getRingBurden() {
		return this.ringBurden;
	}

	public void setRingBurden(final BigDecimal ringBurden) {
		this.ringBurden = ringBurden;
	}

	public BigDecimal getRingBurdenUser() {
		return this.ringBurdenUser;
	}

	public void setRingBurdenUser(final BigDecimal ringBurdenUser) {
		this.ringBurdenUser = ringBurdenUser;
	}

	public String getRockType() {
		return this.rockType;
	}

	@Trim
	public void setRockType(final String rockType) {
		this.rockType = rockType;
	}

	public UUID getRockTypeId() {
		return this.rockTypeId;
	}

	public void setRockTypeId(final UUID rockTypeId) {
		this.rockTypeId = rockTypeId;
	}

	public String getSafetyNoticeNumber() {
		return this.safetyNoticeNumber;
	}

	@Trim
	public void setSafetyNoticeNumber(final String safetyNoticeNumber) {
		this.safetyNoticeNumber = safetyNoticeNumber;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	public String getStemmingMaterial() {
		return this.stemmingMaterial;
	}

	@Trim
	public void setStemmingMaterial(final String stemmingMaterial) {
		this.stemmingMaterial = stemmingMaterial;
	}

	public UUID getStemmingMaterialId() {
		return this.stemmingMaterialId;
	}

	public void setStemmingMaterialId(final UUID stemmingMaterialId) {
		this.stemmingMaterialId = stemmingMaterialId;
	}

	public String getStopeName() {
		return this.stopeName;
	}

	@Trim
	public void setStopeName(final String stopeName) {
		this.stopeName = stopeName;
	}

	public BigDecimal getSubDrill() {
		return this.subDrill;
	}

	public void setSubDrill(final BigDecimal subDrill) {
		this.subDrill = subDrill;
	}

	public BigDecimal getSubDrillUser() {
		return this.subDrillUser;
	}

	public void setSubDrillUser(final BigDecimal subDrillUser) {
		this.subDrillUser = subDrillUser;
	}

	public String getTechnician() {
		return this.technician;
	}

	@Trim
	public void setTechnician(final String technician) {
		this.technician = technician;
	}

	public BigDecimal getTemperature() {
		return this.temperature;
	}

	public void setTemperature(final BigDecimal temperature) {
		this.temperature = temperature;
	}

	public BigDecimal getTemperatureUser() {
		return this.temperatureUser;
	}

	public void setTemperatureUser(final BigDecimal temperatureUser) {
		this.temperatureUser = temperatureUser;
	}

	public String getTemplateName() {
		return this.templateName;
	}

	@Trim
	public void setTemplateName(final String templateName) {
		this.templateName = templateName;
	}

	public BigDecimal getTimezoneOffset() {
		return this.timezoneOffset;
	}

	public void setTimezoneOffset(final BigDecimal timezoneOffset) {
		this.timezoneOffset = timezoneOffset;
	}

	public String getToLevel() {
		return this.toLevel;
	}

	public void setToLevel(final String toLevel) {
		this.toLevel = toLevel;
	}

	public BigDecimal getToeSpacing() {
		return this.toeSpacing;
	}

	public void setToeSpacing(final BigDecimal toeSpacing) {
		this.toeSpacing = toeSpacing;
	}

	public BigDecimal getToeSpacingUser() {
		return this.toeSpacingUser;
	}

	public void setToeSpacingUser(final BigDecimal toeSpacingUser) {
		this.toeSpacingUser = toeSpacingUser;
	}

	public BigDecimal getTotalExplosives() {
		return this.totalExplosives;
	}

	public void setTotalExplosives(final BigDecimal totalExplosives) {
		this.totalExplosives = totalExplosives;
	}

	public BigDecimal getTotalExplosivesUser() {
		return this.totalExplosivesUser;
	}

	public void setTotalExplosivesUser(final BigDecimal totalExplosivesUser) {
		this.totalExplosivesUser = totalExplosivesUser;
	}

	public BigDecimal getTotalTotes() {
		return this.totalTotes;
	}

	public void setTotalTotes(final BigDecimal totalTotes) {
		this.totalTotes = totalTotes;
	}

	public String getWeather() {
		return this.weather;
	}

	@Trim
	public void setWeather(final String weather) {
		this.weather = weather;
	}

	public UUID getWeatherId() {
		return this.weatherId;
	}

	public void setWeatherId(final UUID weatherId) {
		this.weatherId = weatherId;
	}

	public BigDecimal getWeightPerTote() {
		return this.weightPerTote;
	}

	public void setWeightPerTote(final BigDecimal weightPerTote) {
		this.weightPerTote = weightPerTote;
	}

	public BigDecimal getWeightPerToteUser() {
		return this.weightPerToteUser;
	}

	public void setWeightPerToteUser(final BigDecimal weightPerToteUser) {
		this.weightPerToteUser = weightPerToteUser;
	}

	public String getWindDirection() {
		return this.windDirection;
	}

	@Trim
	public void setWindDirection(final String windDirection) {
		this.windDirection = windDirection;
	}

	public UUID getWindDirectionId() {
		return this.windDirectionId;
	}

	public void setWindDirectionId(final UUID windDirectionId) {
		this.windDirectionId = windDirectionId;
	}

	public BigDecimal getWindVelocity() {
		return this.windVelocity;
	}

	public void setWindVelocity(final BigDecimal windVelocity) {
		this.windVelocity = windVelocity;
	}

	public UUID getWindVelocityId() {
		return this.windVelocityId;
	}

	public void setWindVelocityId(final UUID windVelocityId) {
		this.windVelocityId = windVelocityId;
	}

	public BigDecimal getWindVelocityUser() {
		return this.windVelocityUser;
	}

	public void setWindVelocityUser(final BigDecimal windVelocityUser) {
		this.windVelocityUser = windVelocityUser;
	}

	public Point getGeom_user() {
		return geom_user;
	}

	public void setGeom_user(final Point geom_user) {
		this.geom_user = geom_user;
	}

}

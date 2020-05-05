package com.blastvibrations.jpa.orm;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.annotation.Trim;
import com.vividsolutions.jts.geom.Point;

public class ExBlastReportExtended {

	ExBlastReport exBlastReport;

	public ExBlastReportExtended(final ExBlastReport exBlastReport) {
		this.exBlastReport = exBlastReport;
	}

	public ExBlastReport getExBlastReport() {
		return exBlastReport;
	}

	public void setExBlastReport(final ExBlastReport exBlastReport) {
		this.exBlastReport = exBlastReport;
	}

	@Override
	public String toString() {

		return exBlastReport.toString();
	}

	public void clearKey() {

		exBlastReport.clearKey();
	}

	public UUID getBlastId() {

		return exBlastReport.getBlastId();
	}

	public void setBlastId(final UUID blastId) {

		exBlastReport.setBlastId(blastId);
	}

	public BigDecimal getBenchHeight() {

		return exBlastReport.getBenchHeight();
	}

	public void setBenchHeight(final BigDecimal benchHeight) {

		exBlastReport.setBenchHeight(benchHeight);
	}

	public BigDecimal getBenchHeightUser() {

		return exBlastReport.getBenchHeightUser();
	}

	public void setBenchHeightUser(final BigDecimal benchHeightUser) {

		exBlastReport.setBenchHeightUser(benchHeightUser);
	}

	public UUID getBenchId() {

		return exBlastReport.getBenchId();
	}

	public void setBenchId(final UUID benchId) {

		exBlastReport.setBenchId(benchId);
	}

	public List<String> getBlastCategories() {

		return exBlastReport.getBlastCategories();
	}

	@Trim
	public void setBlastCategories(final List<String> blastCategories) {

		exBlastReport.setBlastCategories(blastCategories);
	}

	public UUID getBlastDetailCommentId() {

		return exBlastReport.getBlastDetailCommentId();
	}

	public void setBlastDetailCommentId(final UUID blastDetailCommentId) {

		exBlastReport.setBlastDetailCommentId(blastDetailCommentId);
	}

	public String getBlastLetterNumber() {

		return exBlastReport.getBlastLetterNumber();
	}

	@Trim
	public void setBlastLetterNumber(final String blastLetterNumber) {

		exBlastReport.setBlastLetterNumber(blastLetterNumber);
	}

	public String getBlastNumber() {

		return exBlastReport.getBlastNumber();
	}

	@Trim
	public void setBlastNumber(final String blastNumber) {

		exBlastReport.setBlastNumber(blastNumber);
	}

	public String getBlastType() {

		return exBlastReport.getBlastType();
	}

	@Trim
	public void setBlastType(final String blastType) {

		exBlastReport.setBlastType(blastType);
	}

	public String getBlasterName() {

		return exBlastReport.getBlasterName();
	}

	@Trim
	public void setBlasterName(final String blasterName) {

		exBlastReport.setBlasterName(blasterName);
	}

	public UUID getBlasterNameId() {

		return exBlastReport.getBlasterNameId();
	}

	public void setBlasterNameId(final UUID blasterNameId) {

		exBlastReport.setBlasterNameId(blasterNameId);
	}

	public BigDecimal getBufferLineSpacing() {

		return exBlastReport.getBufferLineSpacing();
	}

	public void setBufferLineSpacing(final BigDecimal bufferLineSpacing) {

		exBlastReport.setBufferLineSpacing(bufferLineSpacing);
	}

	public BigDecimal getBufferLineSpacingUser() {

		return exBlastReport.getBufferLineSpacingUser();
	}

	public void setBufferLineSpacingUser(final BigDecimal bufferLineSpacingUser) {

		exBlastReport.setBufferLineSpacingUser(bufferLineSpacingUser);
	}

	public UUID getClientId() {

		return exBlastReport.getClientId();
	}

	public void setClientId(final UUID clientId) {

		exBlastReport.setClientId(clientId);
	}

	public String getClientName() {

		return exBlastReport.getClientName();
	}

	@Trim
	public void setClientName(final String clientName) {

		exBlastReport.setClientName(clientName);
	}

	public BigDecimal getCollar() {

		return exBlastReport.getCollar();
	}

	public void setCollar(final BigDecimal collar) {

		exBlastReport.setCollar(collar);
	}

	public BigDecimal getCollarUser() {

		return exBlastReport.getCollarUser();
	}

	public void setCollarUser(final BigDecimal collarUser) {

		exBlastReport.setCollarUser(collarUser);
	}

	public String getCompletedBy() {

		return exBlastReport.getCompletedBy();
	}

	@Trim
	public void setCompletedBy(final String completedBy) {

		exBlastReport.setCompletedBy(completedBy);
	}

	public String getCustom1() {

		return exBlastReport.getCustom1();
	}

	@Trim
	public void setCustom1(final String custom1) {

		exBlastReport.setCustom1(custom1);
	}

	public String getCustom2() {

		return exBlastReport.getCustom2();
	}

	@Trim
	public void setCustom2(final String custom2) {

		exBlastReport.setCustom2(custom2);
	}

	public String getCustom3() {

		return exBlastReport.getCustom3();
	}

	@Trim
	public void setCustom3(final String custom3) {

		exBlastReport.setCustom3(custom3);
	}

	public BigDecimal getDeckCount() {

		return exBlastReport.getDeckCount();
	}

	public void setDeckCount(final BigDecimal deckCount) {

		exBlastReport.setDeckCount(deckCount);
	}

	public String getDescription() {

		return exBlastReport.getDescription();
	}

	@Trim
	public void setDescription(final String description) {

		exBlastReport.setDescription(description);
	}

	public String getDetonationMethod() {

		return exBlastReport.getDetonationMethod();
	}

	@Trim
	public void setDetonationMethod(final String detonationMethod) {

		exBlastReport.setDetonationMethod(detonationMethod);
	}

	public UUID getDetonationMethodId() {

		return exBlastReport.getDetonationMethodId();
	}

	public void setDetonationMethodId(final UUID detonationMethodId) {

		exBlastReport.setDetonationMethodId(detonationMethodId);
	}

	public BigDecimal getDetonatorCount() {

		return exBlastReport.getDetonatorCount();
	}

	public void setDetonatorCount(final BigDecimal detonatorCount) {

		exBlastReport.setDetonatorCount(detonatorCount);
	}

	public BigDecimal getDetonatorCount1() {

		return exBlastReport.getDetonatorCount1();
	}

	public void setDetonatorCount1(final BigDecimal detonatorCount1) {

		exBlastReport.setDetonatorCount1(detonatorCount1);
	}

	public BigDecimal getDetonatorCount2() {

		return exBlastReport.getDetonatorCount2();
	}

	public void setDetonatorCount2(final BigDecimal detonatorCount2) {

		exBlastReport.setDetonatorCount2(detonatorCount2);
	}

	public BigDecimal getDetonatorCount3() {

		return exBlastReport.getDetonatorCount3();
	}

	public void setDetonatorCount3(final BigDecimal detonatorCount3) {

		exBlastReport.setDetonatorCount3(detonatorCount3);
	}

	public BigDecimal getDetonatorCount4() {

		return exBlastReport.getDetonatorCount4();
	}

	public void setDetonatorCount4(final BigDecimal detonatorCount4) {

		exBlastReport.setDetonatorCount4(detonatorCount4);
	}

	public List<String> getDetonatorTypeNames1() {

		return exBlastReport.getDetonatorTypeNames1();
	}

	@Trim
	public void setDetonatorTypeNames1(final List<String> detonatorTypeNames1) {

		exBlastReport.setDetonatorTypeNames1(detonatorTypeNames1);
	}

	public List<String> getDetonatorTypeNames10() {

		return exBlastReport.getDetonatorTypeNames10();
	}

	@Trim
	public void setDetonatorTypeNames10(final List<String> detonatorTypeNames10) {

		exBlastReport.setDetonatorTypeNames10(detonatorTypeNames10);
	}

	public List<String> getDetonatorTypeNames2() {

		return exBlastReport.getDetonatorTypeNames2();
	}

	@Trim
	public void setDetonatorTypeNames2(final List<String> detonatorTypeNames2) {

		exBlastReport.setDetonatorTypeNames2(detonatorTypeNames2);
	}

	public List<String> getDetonatorTypeNames3() {

		return exBlastReport.getDetonatorTypeNames3();
	}

	@Trim
	public void setDetonatorTypeNames3(final List<String> detonatorTypeNames3) {

		exBlastReport.setDetonatorTypeNames3(detonatorTypeNames3);
	}

	public List<String> getDetonatorTypeNames4() {

		return exBlastReport.getDetonatorTypeNames4();
	}

	@Trim
	public void setDetonatorTypeNames4(final List<String> detonatorTypeNames4) {

		exBlastReport.setDetonatorTypeNames4(detonatorTypeNames4);
	}

	public List<String> getDetonatorTypeNames5() {

		return exBlastReport.getDetonatorTypeNames5();
	}

	@Trim
	public void setDetonatorTypeNames5(final List<String> detonatorTypeNames5) {

		exBlastReport.setDetonatorTypeNames5(detonatorTypeNames5);
	}

	public List<String> getDetonatorTypeNames6() {

		return exBlastReport.getDetonatorTypeNames6();
	}

	@Trim
	public void setDetonatorTypeNames6(final List<String> detonatorTypeNames6) {

		exBlastReport.setDetonatorTypeNames6(detonatorTypeNames6);
	}

	public List<String> getDetonatorTypeNames7() {

		return exBlastReport.getDetonatorTypeNames7();
	}

	@Trim
	public void setDetonatorTypeNames7(final List<String> detonatorTypeNames7) {

		exBlastReport.setDetonatorTypeNames7(detonatorTypeNames7);
	}

	public List<String> getDetonatorTypeNames8() {

		return exBlastReport.getDetonatorTypeNames8();
	}

	@Trim
	public void setDetonatorTypeNames8(final List<String> detonatorTypeNames8) {

		exBlastReport.setDetonatorTypeNames8(detonatorTypeNames8);
	}

	public List<String> getDetonatorTypeNames9() {

		return exBlastReport.getDetonatorTypeNames9();
	}

	@Trim
	public void setDetonatorTypeNames9(final List<String> detonatorTypeNames9) {

		exBlastReport.setDetonatorTypeNames9(detonatorTypeNames9);
	}

	public BigDecimal getDrillDepth() {

		return exBlastReport.getDrillDepth();
	}

	public void setDrillDepth(final BigDecimal drillDepth) {

		exBlastReport.setDrillDepth(drillDepth);
	}

	public BigDecimal getDrillDepthUser() {

		return exBlastReport.getDrillDepthUser();
	}

	public void setDrillDepthUser(final BigDecimal drillDepthUser) {

		exBlastReport.setDrillDepthUser(drillDepthUser);
	}

	public BigDecimal getElevation() {

		return exBlastReport.getElevation();
	}

	public void setElevation(final BigDecimal elevation) {

		exBlastReport.setElevation(elevation);
	}

	public BigDecimal getElevationUser() {

		return exBlastReport.getElevationUser();
	}

	public void setElevationUser(final BigDecimal elevationUser) {

		exBlastReport.setElevationUser(elevationUser);
	}

	public Date getEndDate() {

		return exBlastReport.getEndDate();
	}

	public void setEndDate(final Date endDate) {

		exBlastReport.setEndDate(endDate);
	}

	public BigDecimal getEstimatedCollar() {

		return exBlastReport.getEstimatedCollar();
	}

	public void setEstimatedCollar(final BigDecimal estimatedCollar) {

		exBlastReport.setEstimatedCollar(estimatedCollar);
	}

	public BigDecimal getEstimatedCollarUser() {

		return exBlastReport.getEstimatedCollarUser();
	}

	public void setEstimatedCollarUser(final BigDecimal estimatedCollarUser) {

		exBlastReport.setEstimatedCollarUser(estimatedCollarUser);
	}

	public BigDecimal getEstimatedDrillDepthUser() {

		return exBlastReport.getEstimatedDrillDepthUser();
	}

	public void setEstimatedDrillDepthUser(
			final BigDecimal estimatedDrillDepthUser) {

		exBlastReport.setEstimatedDrillDepthUser(estimatedDrillDepthUser);
	}

	public BigDecimal getEstimatedHoleCount() {

		return exBlastReport.getEstimatedHoleCount();
	}

	public void setEstimatedHoleCount(final BigDecimal estimatedHoleCount) {

		exBlastReport.setEstimatedHoleCount(estimatedHoleCount);
	}

	public BigDecimal getEstimatedHoleDepth() {

		return exBlastReport.getEstimatedHoleDepth();
	}

	public void setEstimatedHoleDepth(final BigDecimal estimatedHoleDepth) {

		exBlastReport.setEstimatedHoleDepth(estimatedHoleDepth);
	}

	public BigDecimal getEstimatedHoleDepthUser() {

		return exBlastReport.getEstimatedHoleDepthUser();
	}

	public void setEstimatedHoleDepthUser(
			final BigDecimal estimatedHoleDepthUser) {

		exBlastReport.setEstimatedHoleDepthUser(estimatedHoleDepthUser);
	}

	public BigDecimal getEstimatedHoleDiameter() {

		return exBlastReport.getEstimatedHoleDiameter();
	}

	public void setEstimatedHoleDiameter(final BigDecimal estimatedHoleDiameter) {

		exBlastReport.setEstimatedHoleDiameter(estimatedHoleDiameter);
	}

	public BigDecimal getEstimatedHoleDiameterUser() {

		return exBlastReport.getEstimatedHoleDiameterUser();
	}

	public void setEstimatedHoleDiameterUser(
			final BigDecimal estimatedHoleDiameterUser) {

		exBlastReport.setEstimatedHoleDiameterUser(estimatedHoleDiameterUser);
	}

	public BigDecimal getEstimatedMaxLoadPerDelay() {

		return exBlastReport.getEstimatedMaxLoadPerDelay();
	}

	public void setEstimatedMaxLoadPerDelay(
			final BigDecimal estimatedMaxLoadPerDelay) {

		exBlastReport.setEstimatedMaxLoadPerDelay(estimatedMaxLoadPerDelay);
	}

	public BigDecimal getEstimatedMaxLoadPerDelayUser() {

		return exBlastReport.getEstimatedMaxLoadPerDelayUser();
	}

	public void setEstimatedMaxLoadPerDelayUser(
			final BigDecimal estimatedMaxLoadPerDelayUser) {

		exBlastReport
		.setEstimatedMaxLoadPerDelayUser(estimatedMaxLoadPerDelayUser);
	}

	public BigDecimal getEstimatedPPV() {

		return exBlastReport.getEstimatedPPV();
	}

	public void setEstimatedPPV(final BigDecimal estimatedPPV) {

		exBlastReport.setEstimatedPPV(estimatedPPV);
	}

	public BigDecimal getEstimatedPPVUser() {

		return exBlastReport.getEstimatedPPVUser();
	}

	public void setEstimatedPPVUser(final BigDecimal estimatedPPVUser) {

		exBlastReport.setEstimatedPPVUser(estimatedPPVUser);
	}

	public BigDecimal getEstimatedPatternBurden() {

		return exBlastReport.getEstimatedPatternBurden();
	}

	public void setEstimatedPatternBurden(
			final BigDecimal estimatedPatternBurden) {

		exBlastReport.setEstimatedPatternBurden(estimatedPatternBurden);
	}

	public BigDecimal getEstimatedPatternBurdenUser() {

		return exBlastReport.getEstimatedPatternBurdenUser();
	}

	public void setEstimatedPatternBurdenUser(
			final BigDecimal estimatedPatternBurdenUser) {

		exBlastReport.setEstimatedPatternBurdenUser(estimatedPatternBurdenUser);
	}

	public BigDecimal getEstimatedPatternSpacing() {

		return exBlastReport.getEstimatedPatternSpacing();
	}

	public void setEstimatedPatternSpacing(
			final BigDecimal estimatedPatternSpacing) {

		exBlastReport.setEstimatedPatternSpacing(estimatedPatternSpacing);
	}

	public BigDecimal getEstimatedPatternSpacingUser() {

		return exBlastReport.getEstimatedPatternSpacingUser();
	}

	public void setEstimatedPatternSpacingUser(
			final BigDecimal estimatedPatternSpacingUser) {

		exBlastReport
		.setEstimatedPatternSpacingUser(estimatedPatternSpacingUser);
	}

	public BigDecimal getEstimatedPreblastVolume() {

		return exBlastReport.getEstimatedPreblastVolume();
	}

	public void setEstimatedPreblastVolume(
			final BigDecimal estimatedPreblastVolume) {

		exBlastReport.setEstimatedPreblastVolume(estimatedPreblastVolume);
	}

	public BigDecimal getEstimatedPreblastVolumeUser() {

		return exBlastReport.getEstimatedPreblastVolumeUser();
	}

	public void setEstimatedPreblastVolumeUser(
			final BigDecimal estimatedPreblastVolumeUser) {

		exBlastReport
		.setEstimatedPreblastVolumeUser(estimatedPreblastVolumeUser);
	}

	public BigDecimal getEstimatedSubDrill() {

		return exBlastReport.getEstimatedSubDrill();
	}

	public void setEstimatedSubDrill(final BigDecimal estimatedSubDrill) {

		exBlastReport.setEstimatedSubDrill(estimatedSubDrill);
	}

	public BigDecimal getEstimatedSubDrillUser() {

		return exBlastReport.getEstimatedSubDrillUser();
	}

	public void setEstimatedSubDrillUser(final BigDecimal estimatedSubDrillUser) {

		exBlastReport.setEstimatedSubDrillUser(estimatedSubDrillUser);
	}

	public BigDecimal getEstimatedSurfacePPV() {

		return exBlastReport.getEstimatedSurfacePPV();
	}

	public void setEstimatedSurfacePPV(final BigDecimal estimatedSurfacePPV) {

		exBlastReport.setEstimatedSurfacePPV(estimatedSurfacePPV);
	}

	public BigDecimal getEstimatedSurfacePPVUser() {

		return exBlastReport.getEstimatedSurfacePPVUser();
	}

	public void setEstimatedSurfacePPVUser(
			final BigDecimal estimatedSurfacePPVUser) {

		exBlastReport.setEstimatedSurfacePPVUser(estimatedSurfacePPVUser);
	}

	public BigDecimal getEstimatedTotalExplosives() {

		return exBlastReport.getEstimatedTotalExplosives();
	}

	public void setEstimatedTotalExplosives(
			final BigDecimal estimatedTotalExplosives) {

		exBlastReport.setEstimatedTotalExplosives(estimatedTotalExplosives);
	}

	public BigDecimal getEstimatedTotalExplosivesUser() {

		return exBlastReport.getEstimatedTotalExplosivesUser();
	}

	public void setEstimatedTotalExplosivesUser(
			final BigDecimal estimatedTotalExplosivesUser) {

		exBlastReport
		.setEstimatedTotalExplosivesUser(estimatedTotalExplosivesUser);
	}

	public BigDecimal getEstimatedVolume() {

		return exBlastReport.getEstimatedVolume();
	}

	public void setEstimatedVolume(final BigDecimal estimatedVolume) {

		exBlastReport.setEstimatedVolume(estimatedVolume);
	}

	public BigDecimal getEstimatedVolumeUser() {

		return exBlastReport.getEstimatedVolumeUser();
	}

	public void setEstimatedVolumeUser(final BigDecimal estimatedVolumeUser) {

		exBlastReport.setEstimatedVolumeUser(estimatedVolumeUser);
	}

	public List<String> getExcludedEventIds() {

		return exBlastReport.getExcludedEventIds();
	}

	@Trim
	public void setExcludedEventIds(final List<String> excludedEventIds) {

		exBlastReport.setExcludedEventIds(excludedEventIds);
	}

	public BigDecimal getExplosiveMassUser1() {

		return exBlastReport.getExplosiveMassUser1();
	}

	public void setExplosiveMassUser1(final BigDecimal explosiveMassUser1) {

		exBlastReport.setExplosiveMassUser1(explosiveMassUser1);
	}

	public BigDecimal getExplosiveMassUser10() {

		return exBlastReport.getExplosiveMassUser10();
	}

	public void setExplosiveMassUser10(final BigDecimal explosiveMassUser10) {

		exBlastReport.setExplosiveMassUser10(explosiveMassUser10);
	}

	public BigDecimal getExplosiveMassUser2() {

		return exBlastReport.getExplosiveMassUser2();
	}

	public void setExplosiveMassUser2(final BigDecimal explosiveMassUser2) {

		exBlastReport.setExplosiveMassUser2(explosiveMassUser2);
	}

	public BigDecimal getExplosiveMassUser3() {

		return exBlastReport.getExplosiveMassUser3();
	}

	public void setExplosiveMassUser3(final BigDecimal explosiveMassUser3) {

		exBlastReport.setExplosiveMassUser3(explosiveMassUser3);
	}

	public BigDecimal getExplosiveMassUser4() {

		return exBlastReport.getExplosiveMassUser4();
	}

	public void setExplosiveMassUser4(final BigDecimal explosiveMassUser4) {

		exBlastReport.setExplosiveMassUser4(explosiveMassUser4);
	}

	public BigDecimal getExplosiveMassUser5() {

		return exBlastReport.getExplosiveMassUser5();
	}

	public void setExplosiveMassUser5(final BigDecimal explosiveMassUser5) {

		exBlastReport.setExplosiveMassUser5(explosiveMassUser5);
	}

	public BigDecimal getExplosiveMassUser6() {

		return exBlastReport.getExplosiveMassUser6();
	}

	public void setExplosiveMassUser6(final BigDecimal explosiveMassUser6) {

		exBlastReport.setExplosiveMassUser6(explosiveMassUser6);
	}

	public BigDecimal getExplosiveMassUser7() {

		return exBlastReport.getExplosiveMassUser7();
	}

	public void setExplosiveMassUser7(final BigDecimal explosiveMassUser7) {

		exBlastReport.setExplosiveMassUser7(explosiveMassUser7);
	}

	public BigDecimal getExplosiveMassUser8() {

		return exBlastReport.getExplosiveMassUser8();
	}

	public void setExplosiveMassUser8(final BigDecimal explosiveMassUser8) {

		exBlastReport.setExplosiveMassUser8(explosiveMassUser8);
	}

	public BigDecimal getExplosiveMassUser9() {

		return exBlastReport.getExplosiveMassUser9();
	}

	public void setExplosiveMassUser9(final BigDecimal explosiveMassUser9) {

		exBlastReport.setExplosiveMassUser9(explosiveMassUser9);
	}

	public BigDecimal getExplosiveMass1() {

		return exBlastReport.getExplosiveMass1();
	}

	public void setExplosiveMass1(final BigDecimal explosiveMass1) {

		exBlastReport.setExplosiveMass1(explosiveMass1);
	}

	public BigDecimal getExplosiveMass10() {

		return exBlastReport.getExplosiveMass10();
	}

	public void setExplosiveMass10(final BigDecimal explosiveMass10) {

		exBlastReport.setExplosiveMass10(explosiveMass10);
	}

	public BigDecimal getExplosiveMass2() {

		return exBlastReport.getExplosiveMass2();
	}

	public void setExplosiveMass2(final BigDecimal explosiveMass2) {

		exBlastReport.setExplosiveMass2(explosiveMass2);
	}

	public BigDecimal getExplosiveMass3() {

		return exBlastReport.getExplosiveMass3();
	}

	public void setExplosiveMass3(final BigDecimal explosiveMass3) {

		exBlastReport.setExplosiveMass3(explosiveMass3);
	}

	public BigDecimal getExplosiveMass4() {

		return exBlastReport.getExplosiveMass4();
	}

	public void setExplosiveMass4(final BigDecimal explosiveMass4) {

		exBlastReport.setExplosiveMass4(explosiveMass4);
	}

	public BigDecimal getExplosiveMass5() {

		return exBlastReport.getExplosiveMass5();
	}

	public void setExplosiveMass5(final BigDecimal explosiveMass5) {

		exBlastReport.setExplosiveMass5(explosiveMass5);
	}

	public BigDecimal getExplosiveMass6() {

		return exBlastReport.getExplosiveMass6();
	}

	public void setExplosiveMass6(final BigDecimal explosiveMass6) {

		exBlastReport.setExplosiveMass6(explosiveMass6);
	}

	public BigDecimal getExplosiveMass7() {

		return exBlastReport.getExplosiveMass7();
	}

	public void setExplosiveMass7(final BigDecimal explosiveMass7) {

		exBlastReport.setExplosiveMass7(explosiveMass7);
	}

	public BigDecimal getExplosiveMass8() {

		return exBlastReport.getExplosiveMass8();
	}

	public void setExplosiveMass8(final BigDecimal explosiveMass8) {

		exBlastReport.setExplosiveMass8(explosiveMass8);
	}

	public BigDecimal getExplosiveMass9() {

		return exBlastReport.getExplosiveMass9();
	}

	public void setExplosiveMass9(final BigDecimal explosiveMass9) {

		exBlastReport.setExplosiveMass9(explosiveMass9);
	}

	public String getExplosiveType() {

		return exBlastReport.getExplosiveType();
	}

	@Trim
	public void setExplosiveType(final String explosiveType) {

		exBlastReport.setExplosiveType(explosiveType);
	}

	public String getExplosiveTypeDetName1() {

		return exBlastReport.getExplosiveTypeDetName1();
	}

	@Trim
	public void setExplosiveTypeDetName1(final String explosiveTypeDetName1) {

		exBlastReport.setExplosiveTypeDetName1(explosiveTypeDetName1);
	}

	public String getExplosiveTypeDetName10() {

		return exBlastReport.getExplosiveTypeDetName10();
	}

	@Trim
	public void setExplosiveTypeDetName10(final String explosiveTypeDetName10) {

		exBlastReport.setExplosiveTypeDetName10(explosiveTypeDetName10);
	}

	public String getExplosiveTypeDetName2() {

		return exBlastReport.getExplosiveTypeDetName2();
	}

	@Trim
	public void setExplosiveTypeDetName2(final String explosiveTypeDetName2) {

		exBlastReport.setExplosiveTypeDetName2(explosiveTypeDetName2);
	}

	public String getExplosiveTypeDetName3() {

		return exBlastReport.getExplosiveTypeDetName3();
	}

	@Trim
	public void setExplosiveTypeDetName3(final String explosiveTypeDetName3) {

		exBlastReport.setExplosiveTypeDetName3(explosiveTypeDetName3);
	}

	public String getExplosiveTypeDetName4() {

		return exBlastReport.getExplosiveTypeDetName4();
	}

	@Trim
	public void setExplosiveTypeDetName4(final String explosiveTypeDetName4) {

		exBlastReport.setExplosiveTypeDetName4(explosiveTypeDetName4);
	}

	public String getExplosiveTypeDetName5() {

		return exBlastReport.getExplosiveTypeDetName5();
	}

	@Trim
	public void setExplosiveTypeDetName5(final String explosiveTypeDetName5) {

		exBlastReport.setExplosiveTypeDetName5(explosiveTypeDetName5);
	}

	public String getExplosiveTypeDetName6() {

		return exBlastReport.getExplosiveTypeDetName6();
	}

	@Trim
	public void setExplosiveTypeDetName6(final String explosiveTypeDetName6) {

		exBlastReport.setExplosiveTypeDetName6(explosiveTypeDetName6);
	}

	public String getExplosiveTypeDetName7() {

		return exBlastReport.getExplosiveTypeDetName7();
	}

	@Trim
	public void setExplosiveTypeDetName7(final String explosiveTypeDetName7) {

		exBlastReport.setExplosiveTypeDetName7(explosiveTypeDetName7);
	}

	public String getExplosiveTypeDetName8() {

		return exBlastReport.getExplosiveTypeDetName8();
	}

	@Trim
	public void setExplosiveTypeDetName8(final String explosiveTypeDetName8) {

		exBlastReport.setExplosiveTypeDetName8(explosiveTypeDetName8);
	}

	public String getExplosiveTypeDetName9() {

		return exBlastReport.getExplosiveTypeDetName9();
	}

	@Trim
	public void setExplosiveTypeDetName9(final String explosiveTypeDetName9) {

		exBlastReport.setExplosiveTypeDetName9(explosiveTypeDetName9);
	}

	public String getExplosiveTypeName1() {

		return exBlastReport.getExplosiveTypeName1();
	}

	@Trim
	public void setExplosiveTypeName1(final String explosiveTypeName1) {

		exBlastReport.setExplosiveTypeName1(explosiveTypeName1);
	}

	public String getExplosiveTypeName10() {

		return exBlastReport.getExplosiveTypeName10();
	}

	@Trim
	public void setExplosiveTypeName10(final String explosiveTypeName10) {

		exBlastReport.setExplosiveTypeName10(explosiveTypeName10);
	}

	public String getExplosiveTypeName2() {

		return exBlastReport.getExplosiveTypeName2();
	}

	@Trim
	public void setExplosiveTypeName2(final String explosiveTypeName2) {

		exBlastReport.setExplosiveTypeName2(explosiveTypeName2);
	}

	public String getExplosiveTypeName3() {

		return exBlastReport.getExplosiveTypeName3();
	}

	@Trim
	public void setExplosiveTypeName3(final String explosiveTypeName3) {

		exBlastReport.setExplosiveTypeName3(explosiveTypeName3);
	}

	public String getExplosiveTypeName4() {

		return exBlastReport.getExplosiveTypeName4();
	}

	@Trim
	public void setExplosiveTypeName4(final String explosiveTypeName4) {

		exBlastReport.setExplosiveTypeName4(explosiveTypeName4);
	}

	public String getExplosiveTypeName5() {

		return exBlastReport.getExplosiveTypeName5();
	}

	@Trim
	public void setExplosiveTypeName5(final String explosiveTypeName5) {

		exBlastReport.setExplosiveTypeName5(explosiveTypeName5);
	}

	public String getExplosiveTypeName6() {

		return exBlastReport.getExplosiveTypeName6();
	}

	@Trim
	public void setExplosiveTypeName6(final String explosiveTypeName6) {

		exBlastReport.setExplosiveTypeName6(explosiveTypeName6);
	}

	public String getExplosiveTypeName7() {

		return exBlastReport.getExplosiveTypeName7();
	}

	@Trim
	public void setExplosiveTypeName7(final String explosiveTypeName7) {

		exBlastReport.setExplosiveTypeName7(explosiveTypeName7);
	}

	public String getExplosiveTypeName8() {

		return exBlastReport.getExplosiveTypeName8();
	}

	@Trim
	public void setExplosiveTypeName8(final String explosiveTypeName8) {

		exBlastReport.setExplosiveTypeName8(explosiveTypeName8);
	}

	public String getExplosiveTypeName9() {

		return exBlastReport.getExplosiveTypeName9();
	}

	@Trim
	public void setExplosiveTypeName9(final String explosiveTypeName9) {

		exBlastReport.setExplosiveTypeName9(explosiveTypeName9);
	}

	public String getFiringLocation() {

		return exBlastReport.getFiringLocation();
	}

	@Trim
	public void setFiringLocation(final String firingLocation) {

		exBlastReport.setFiringLocation(firingLocation);
	}

	public UUID getFiringLocationId() {

		return exBlastReport.getFiringLocationId();
	}

	public void setFiringLocationId(final UUID firingLocationId) {

		exBlastReport.setFiringLocationId(firingLocationId);
	}

	public String getFiringLocationLevel() {

		return exBlastReport.getFiringLocationLevel();
	}

	@Trim
	public void setFiringLocationLevel(final String firingLocationLevel) {

		exBlastReport.setFiringLocationLevel(firingLocationLevel);
	}

	public String getFlyrock() {

		return exBlastReport.getFlyrock();
	}

	@Trim
	public void setFlyrock(final String flyrock) {

		exBlastReport.setFlyrock(flyrock);
	}

	public String getFragmentation() {

		return exBlastReport.getFragmentation();
	}

	@Trim
	public void setFragmentation(final String fragmentation) {

		exBlastReport.setFragmentation(fragmentation);
	}

	public String getFromLevel() {

		return exBlastReport.getFromLevel();
	}

	public void setFromLevel(final String fromLevel) {

		exBlastReport.setFromLevel(fromLevel);
	}

	public Point getGeom() {

		return exBlastReport.getGeom();
	}

	public void setGeom(final Point geom) {

		exBlastReport.setGeom(geom);
	}

	public boolean getHasNoRelatedEvents() {

		return exBlastReport.getHasNoRelatedEvents();
	}

	public void setHasNoRelatedEvents(final boolean hasNoRelatedEvents) {

		exBlastReport.setHasNoRelatedEvents(hasNoRelatedEvents);
	}

	public BigDecimal getHoleCount() {

		return exBlastReport.getHoleCount();
	}

	public void setHoleCount(final BigDecimal holeCount) {

		exBlastReport.setHoleCount(holeCount);
	}

	public BigDecimal getHoleDepth() {

		return exBlastReport.getHoleDepth();
	}

	public void setHoleDepth(final BigDecimal holeDepth) {

		exBlastReport.setHoleDepth(holeDepth);
	}

	public BigDecimal getHoleDepthUser() {

		return exBlastReport.getHoleDepthUser();
	}

	public void setHoleDepthUser(final BigDecimal holeDepthUser) {

		exBlastReport.setHoleDepthUser(holeDepthUser);
	}

	public BigDecimal getHoleDiameter() {

		return exBlastReport.getHoleDiameter();
	}

	public void setHoleDiameter(final BigDecimal holeDiameter) {

		exBlastReport.setHoleDiameter(holeDiameter);
	}

	public BigDecimal getHoleDiameterUser() {

		return exBlastReport.getHoleDiameterUser();
	}

	public void setHoleDiameterUser(final BigDecimal holeDiameterUser) {

		exBlastReport.setHoleDiameterUser(holeDiameterUser);
	}

	public List<String> getIncludedEventIds() {

		return exBlastReport.getIncludedEventIds();
	}

	@Trim
	public void setIncludedEventIds(final List<String> includedEventIds) {

		exBlastReport.setIncludedEventIds(includedEventIds);
	}

	public boolean getIsTemplate() {

		return exBlastReport.getIsTemplate();
	}

	public void setIsTemplate(final boolean isTemplate) {

		exBlastReport.setIsTemplate(isTemplate);
	}

	public String getJobNumber() {

		return exBlastReport.getJobNumber();
	}

	@Trim
	public void setJobNumber(final String jobNumber) {

		exBlastReport.setJobNumber(jobNumber);
	}

	public BigDecimal getLatitude() {

		return exBlastReport.getLatitude();
	}

	public void setLatitude(final BigDecimal latitude) {

		exBlastReport.setLatitude(latitude);
	}

	public BigDecimal getLatitudeUser() {

		return exBlastReport.getLatitudeUser();
	}

	public void setLatitudeUser(final BigDecimal latitudeUser) {

		exBlastReport.setLatitudeUser(latitudeUser);
	}

	public String getLevels() {

		return exBlastReport.getLevels();
	}

	@Trim
	public void setLevels(final String levels) {

		exBlastReport.setLevels(levels);
	}

	public String getLocation() {

		return exBlastReport.getLocation();
	}

	@Trim
	public void setLocation(final String location) {

		exBlastReport.setLocation(location);
	}

	public String getLocation2() {

		return exBlastReport.getLocation2();
	}

	@Trim
	public void setLocation2(final String location2) {

		exBlastReport.setLocation2(location2);
	}

	public String getLocation3() {

		return exBlastReport.getLocation3();
	}

	@Trim
	public void setLocation3(final String location3) {

		exBlastReport.setLocation3(location3);
	}

	public String getLocation4() {

		return exBlastReport.getLocation4();
	}

	@Trim
	public void setLocation4(final String location4) {

		exBlastReport.setLocation4(location4);
	}

	public BigDecimal getLoggerCount() {

		return exBlastReport.getLoggerCount();
	}

	public void setLoggerCount(final BigDecimal loggerCount) {

		exBlastReport.setLoggerCount(loggerCount);
	}

	public BigDecimal getLongitude() {

		return exBlastReport.getLongitude();
	}

	public void setLongitude(final BigDecimal longitude) {

		exBlastReport.setLongitude(longitude);
	}

	public BigDecimal getLongitudeUser() {

		return exBlastReport.getLongitudeUser();
	}

	public void setLongitudeUser(final BigDecimal longitudeUser) {

		exBlastReport.setLongitudeUser(longitudeUser);
	}

	public BigDecimal getMaxLoadPerDelay() {

		return exBlastReport.getMaxLoadPerDelay();
	}

	public void setMaxLoadPerDelay(final BigDecimal maxLoadPerDelay) {

		exBlastReport.setMaxLoadPerDelay(maxLoadPerDelay);
	}

	public BigDecimal getMaxLoadPerDelayUser() {

		return exBlastReport.getMaxLoadPerDelayUser();
	}

	public void setMaxLoadPerDelayUser(final BigDecimal maxLoadPerDelayUser) {

		exBlastReport.setMaxLoadPerDelayUser(maxLoadPerDelayUser);
	}

	public String getMeasureSystemName() {

		return exBlastReport.getMeasureSystemName();
	}

	@Trim
	public void setMeasureSystemName(final String measureSystemName) {

		exBlastReport.setMeasureSystemName(measureSystemName);
	}

	public String getMiningMethod() {

		return exBlastReport.getMiningMethod();
	}

	@Trim
	public void setMiningMethod(final String miningMethod) {

		exBlastReport.setMiningMethod(miningMethod);
	}

	public UUID getMiningMethodId() {

		return exBlastReport.getMiningMethodId();
	}

	public void setMiningMethodId(final UUID miningMethodId) {

		exBlastReport.setMiningMethodId(miningMethodId);
	}

	public String getMuckpileConfiguration() {

		return exBlastReport.getMuckpileConfiguration();
	}

	@Trim
	public void setMuckpileConfiguration(final String muckpileConfiguration) {

		exBlastReport.setMuckpileConfiguration(muckpileConfiguration);
	}

	public String getName() {

		return exBlastReport.getName();
	}

	@Trim
	public void setName(final String name) {

		exBlastReport.setName(name);
	}

	public String getNotes() {

		return exBlastReport.getNotes();
	}

	@Trim
	public void setNotes(final String notes) {

		exBlastReport.setNotes(notes);
	}

	public String getOrebody() {

		return exBlastReport.getOrebody();
	}

	@Trim
	public void setOrebody(final String orebody) {

		exBlastReport.setOrebody(orebody);
	}

	public BigDecimal getPatternBurden() {

		return exBlastReport.getPatternBurden();
	}

	public void setPatternBurden(final BigDecimal patternBurden) {

		exBlastReport.setPatternBurden(patternBurden);
	}

	public BigDecimal getPatternBurdenUser() {

		return exBlastReport.getPatternBurdenUser();
	}

	public void setPatternBurdenUser(final BigDecimal patternBurdenUser) {

		exBlastReport.setPatternBurdenUser(patternBurdenUser);
	}

	public BigDecimal getPatternSpacing() {

		return exBlastReport.getPatternSpacing();
	}

	public void setPatternSpacing(final BigDecimal patternSpacing) {

		exBlastReport.setPatternSpacing(patternSpacing);
	}

	public BigDecimal getPatternSpacingUser() {

		return exBlastReport.getPatternSpacingUser();
	}

	public void setPatternSpacingUser(final BigDecimal patternSpacingUser) {

		exBlastReport.setPatternSpacingUser(patternSpacingUser);
	}

	public String getPatternType() {

		return exBlastReport.getPatternType();
	}

	@Trim
	public void setPatternType(final String patternType) {

		exBlastReport.setPatternType(patternType);
	}

	public UUID getPatternTypeId() {

		return exBlastReport.getPatternTypeId();
	}

	public void setPatternTypeId(final UUID patternTypeId) {

		exBlastReport.setPatternTypeId(patternTypeId);
	}

	public BigDecimal getPlannedBlastDuration() {

		return exBlastReport.getPlannedBlastDuration();
	}

	public void setPlannedBlastDuration(final BigDecimal plannedBlastDuration) {

		exBlastReport.setPlannedBlastDuration(plannedBlastDuration);
	}

	public BigDecimal getPowderFactor() {

		return exBlastReport.getPowderFactor();
	}

	public void setPowderFactor(final BigDecimal powderFactor) {

		exBlastReport.setPowderFactor(powderFactor);
	}

	public BigDecimal getPowderFactorUser() {

		return exBlastReport.getPowderFactorUser();
	}

	public void setPowderFactorUser(final BigDecimal powderFactorUser) {

		exBlastReport.setPowderFactorUser(powderFactorUser);
	}

	public List<String> getProductTypeNames1() {

		return exBlastReport.getProductTypeNames1();
	}

	@Trim
	public void setProductTypeNames1(final List<String> productTypeNames1) {

		exBlastReport.setProductTypeNames1(productTypeNames1);
	}

	public List<String> getProductTypeNames10() {

		return exBlastReport.getProductTypeNames10();
	}

	@Trim
	public void setProductTypeNames10(final List<String> productTypeNames10) {

		exBlastReport.setProductTypeNames10(productTypeNames10);
	}

	public List<String> getProductTypeNames2() {

		return exBlastReport.getProductTypeNames2();
	}

	@Trim
	public void setProductTypeNames2(final List<String> productTypeNames2) {

		exBlastReport.setProductTypeNames2(productTypeNames2);
	}

	public List<String> getProductTypeNames3() {

		return exBlastReport.getProductTypeNames3();
	}

	@Trim
	public void setProductTypeNames3(final List<String> productTypeNames3) {

		exBlastReport.setProductTypeNames3(productTypeNames3);
	}

	public List<String> getProductTypeNames4() {

		return exBlastReport.getProductTypeNames4();
	}

	@Trim
	public void setProductTypeNames4(final List<String> productTypeNames4) {

		exBlastReport.setProductTypeNames4(productTypeNames4);
	}

	public List<String> getProductTypeNames5() {

		return exBlastReport.getProductTypeNames5();
	}

	@Trim
	public void setProductTypeNames5(final List<String> productTypeNames5) {

		exBlastReport.setProductTypeNames5(productTypeNames5);
	}

	public List<String> getProductTypeNames6() {

		return exBlastReport.getProductTypeNames6();
	}

	public void setProductTypeNames6(final List<String> productTypeNames6) {

		exBlastReport.setProductTypeNames6(productTypeNames6);
	}

	public List<String> getProductTypeNames7() {

		return exBlastReport.getProductTypeNames7();
	}

	@Trim
	public void setProductTypeNames7(final List<String> productTypeNames7) {

		exBlastReport.setProductTypeNames7(productTypeNames7);
	}

	public List<String> getProductTypeNames8() {

		return exBlastReport.getProductTypeNames8();
	}

	@Trim
	public void setProductTypeNames8(final List<String> productTypeNames8) {

		exBlastReport.setProductTypeNames8(productTypeNames8);
	}

	public List<String> getProductTypeNames9() {

		return exBlastReport.getProductTypeNames9();
	}

	@Trim
	public void setProductTypeNames9(final List<String> productTypeNames9) {

		exBlastReport.setProductTypeNames9(productTypeNames9);
	}

	public UUID getQuarrySiteId() {

		return exBlastReport.getQuarrySiteId();
	}

	public void setQuarrySiteId(final UUID quarrySiteId) {

		exBlastReport.setQuarrySiteId(quarrySiteId);
	}

	public String getReviewedBy() {

		return exBlastReport.getReviewedBy();
	}

	@Trim
	public void setReviewedBy(final String reviewedBy) {

		exBlastReport.setReviewedBy(reviewedBy);
	}

	public BigDecimal getRingBurden() {

		return exBlastReport.getRingBurden();
	}

	public void setRingBurden(final BigDecimal ringBurden) {

		exBlastReport.setRingBurden(ringBurden);
	}

	public BigDecimal getRingBurdenUser() {

		return exBlastReport.getRingBurdenUser();
	}

	public void setRingBurdenUser(final BigDecimal ringBurdenUser) {

		exBlastReport.setRingBurdenUser(ringBurdenUser);
	}

	public String getRockType() {

		return exBlastReport.getRockType();
	}

	@Trim
	public void setRockType(final String rockType) {

		exBlastReport.setRockType(rockType);
	}

	public UUID getRockTypeId() {

		return exBlastReport.getRockTypeId();
	}

	public void setRockTypeId(final UUID rockTypeId) {

		exBlastReport.setRockTypeId(rockTypeId);
	}

	public String getSafetyNoticeNumber() {

		return exBlastReport.getSafetyNoticeNumber();
	}

	@Trim
	public void setSafetyNoticeNumber(final String safetyNoticeNumber) {

		exBlastReport.setSafetyNoticeNumber(safetyNoticeNumber);
	}

	public Date getStartDate() {

		return exBlastReport.getStartDate();
	}

	public void setStartDate(final Date startDate) {

		exBlastReport.setStartDate(startDate);
	}

	public String getStemmingMaterial() {

		return exBlastReport.getStemmingMaterial();
	}

	@Trim
	public void setStemmingMaterial(final String stemmingMaterial) {

		exBlastReport.setStemmingMaterial(stemmingMaterial);
	}

	public UUID getStemmingMaterialId() {

		return exBlastReport.getStemmingMaterialId();
	}

	public void setStemmingMaterialId(final UUID stemmingMaterialId) {

		exBlastReport.setStemmingMaterialId(stemmingMaterialId);
	}

	public String getStopeName() {

		return exBlastReport.getStopeName();
	}

	@Trim
	public void setStopeName(final String stopeName) {

		exBlastReport.setStopeName(stopeName);
	}

	public BigDecimal getSubDrill() {

		return exBlastReport.getSubDrill();
	}

	public void setSubDrill(final BigDecimal subDrill) {

		exBlastReport.setSubDrill(subDrill);
	}

	public BigDecimal getSubDrillUser() {

		return exBlastReport.getSubDrillUser();
	}

	public void setSubDrillUser(final BigDecimal subDrillUser) {

		exBlastReport.setSubDrillUser(subDrillUser);
	}

	public String getTechnician() {

		return exBlastReport.getTechnician();
	}

	@Trim
	public void setTechnician(final String technician) {

		exBlastReport.setTechnician(technician);
	}

	public BigDecimal getTemperature() {

		return exBlastReport.getTemperature();
	}

	public void setTemperature(final BigDecimal temperature) {

		exBlastReport.setTemperature(temperature);
	}

	public BigDecimal getTemperatureUser() {

		return exBlastReport.getTemperatureUser();
	}

	public void setTemperatureUser(final BigDecimal temperatureUser) {

		exBlastReport.setTemperatureUser(temperatureUser);
	}

	public String getTemplateName() {

		return exBlastReport.getTemplateName();
	}

	@Trim
	public void setTemplateName(final String templateName) {

		exBlastReport.setTemplateName(templateName);
	}

	public BigDecimal getTimezoneOffset() {

		return exBlastReport.getTimezoneOffset();
	}

	public void setTimezoneOffset(final BigDecimal timezoneOffset) {

		exBlastReport.setTimezoneOffset(timezoneOffset);
	}

	public String getToLevel() {

		return exBlastReport.getToLevel();
	}

	public void setToLevel(final String toLevel) {

		exBlastReport.setToLevel(toLevel);
	}

	public BigDecimal getToeSpacing() {

		return exBlastReport.getToeSpacing();
	}

	public void setToeSpacing(final BigDecimal toeSpacing) {

		exBlastReport.setToeSpacing(toeSpacing);
	}

	public BigDecimal getToeSpacingUser() {

		return exBlastReport.getToeSpacingUser();
	}

	public void setToeSpacingUser(final BigDecimal toeSpacingUser) {

		exBlastReport.setToeSpacingUser(toeSpacingUser);
	}

	public BigDecimal getTotalExplosives() {

		return exBlastReport.getTotalExplosives();
	}

	public void setTotalExplosives(final BigDecimal totalExplosives) {

		exBlastReport.setTotalExplosives(totalExplosives);
	}

	public BigDecimal getTotalExplosivesUser() {

		return exBlastReport.getTotalExplosivesUser();
	}

	public void setTotalExplosivesUser(final BigDecimal totalExplosivesUser) {

		exBlastReport.setTotalExplosivesUser(totalExplosivesUser);
	}

	public BigDecimal getTotalTotes() {

		return exBlastReport.getTotalTotes();
	}

	public void setTotalTotes(final BigDecimal totalTotes) {

		exBlastReport.setTotalTotes(totalTotes);
	}

	public String getWeather() {

		return exBlastReport.getWeather();
	}

	@Trim
	public void setWeather(final String weather) {

		exBlastReport.setWeather(weather);
	}

	public UUID getWeatherId() {

		return exBlastReport.getWeatherId();
	}

	public void setWeatherId(final UUID weatherId) {

		exBlastReport.setWeatherId(weatherId);
	}

	public BigDecimal getWeightPerTote() {

		return exBlastReport.getWeightPerTote();
	}

	public void setWeightPerTote(final BigDecimal weightPerTote) {

		exBlastReport.setWeightPerTote(weightPerTote);
	}

	public BigDecimal getWeightPerToteUser() {

		return exBlastReport.getWeightPerToteUser();
	}

	public void setWeightPerToteUser(final BigDecimal weightPerToteUser) {

		exBlastReport.setWeightPerToteUser(weightPerToteUser);
	}

	public String getWindDirection() {

		return exBlastReport.getWindDirection();
	}

	@Trim
	public void setWindDirection(final String windDirection) {

		exBlastReport.setWindDirection(windDirection);
	}

	public UUID getWindDirectionId() {

		return exBlastReport.getWindDirectionId();
	}

	public void setWindDirectionId(final UUID windDirectionId) {

		exBlastReport.setWindDirectionId(windDirectionId);
	}

	public BigDecimal getWindVelocity() {

		return exBlastReport.getWindVelocity();
	}

	public void setWindVelocity(final BigDecimal windVelocity) {

		exBlastReport.setWindVelocity(windVelocity);
	}

	public UUID getWindVelocityId() {

		return exBlastReport.getWindVelocityId();
	}

	public void setWindVelocityId(final UUID windVelocityId) {

		exBlastReport.setWindVelocityId(windVelocityId);
	}

	public BigDecimal getWindVelocityUser() {

		return exBlastReport.getWindVelocityUser();
	}

	public void setWindVelocityUser(final BigDecimal windVelocityUser) {

		exBlastReport.setWindVelocityUser(windVelocityUser);
	}

	public Point getGeom_user() {

		return exBlastReport.getGeom_user();
	}

	public void setGeom_user(final Point geom_user) {

		exBlastReport.setGeom_user(geom_user);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -6813332582144961551L;

}

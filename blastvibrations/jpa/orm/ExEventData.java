package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.ToString;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.blastvibrations.jpa.annotation.Trim;
import com.vividsolutions.jts.geom.Point;

/**
 * The persistent class for the ex_event_data database table.
 *
 */
@Entity
@Table(name = "ex_event_data")
@NamedQuery(name = "ExEventData.findAll", query = "SELECT e FROM ExEventData e")
@ToString
public class ExEventData extends ExEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    // report types
    // W - Waveform (has FFT reports)
    // H - Histogram
    public static final String EVENT_REPORT_WAVEFORM = "W";
    public static final String EVENT_REPORT_HISTOGRAM = "H";
    public static final int USER_REPORT_TYPE_ALL = 0; // default
    public static final int USER_REPORT_TYPE_WAVEFORM = 1;
    public static final int USER_REPORT_TYPE_HISTOGRAM = 2;

    public static final Integer EVENT_HIGHLIGHT_0 = 0;
    public static final Integer EVENT_HIGHLIGHT_1 = 1;
    public static final Integer EVENT_HIGHLIGHT_2 = 2;
    public static final Integer EVENT_HIGHLIGHT_3 = 3;

    @Override
    public void clearKey() {
	super.clearKey();
	this.eventDataId = null;

    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "event_data_id")
    private UUID eventDataId;

    @Column(name = "blastware_file_data")
    private String blastwareFileData;

    @Column(name = "blastware_file_name")
    private String blastwareFileName;

    private String calibration;

    @Column(name = "chan1_accel")
    private Double chan1Accel;

    @Column(name = "chan1_check")
    private String chan1Check;

    @Column(name = "chan1_name")
    private String chan1Name;

    @Column(name = "chan1_peak")
    private Double chan1Peak;

    @Column(name = "chan2_accel")
    private Double chan2Accel;

    @Column(name = "chan2_check")
    private String chan2Check;

    @Column(name = "chan2_name")
    private String chan2Name;

    @Column(name = "chan2_peak")
    private Double chan2Peak;

    @Column(name = "chan3_accel")
    private Double chan3Accel;

    @Column(name = "chan3_check")
    private String chan3Check;

    @Column(name = "chan3_name")
    private String chan3Name;

    @Column(name = "chan3_peak")
    private Double chan3Peak;

    @Column(name = "chan4_accel")
    private Double chan4Accel;

    @Column(name = "chan4_check")
    private String chan4Check;

    @Column(name = "chan4_name")
    private String chan4Name;

    @Column(name = "chan4_peak")
    private Double chan4Peak;

    @Column(name = "chan5_accel")
    private Double chan5Accel;

    @Column(name = "chan5_check")
    private String chan5Check;

    @Column(name = "chan5_name")
    private String chan5Name;

    @Column(name = "chan5_peak")
    private Double chan5Peak;

    @Column(name = "chan6_accel")
    private Double chan6Accel;

    @Column(name = "chan6_check")
    private String chan6Check;

    @Column(name = "chan6_name")
    private String chan6Name;

    @Column(name = "chan6_peak")
    private Double chan6Peak;

    @Column(name = "chan7_accel")
    private Double chan7Accel;

    @Column(name = "chan7_check")
    private String chan7Check;

    @Column(name = "chan7_name")
    private String chan7Name;

    @Column(name = "chan7_peak")
    private Double chan7Peak;

    @Column(name = "chan8_accel")
    private Double chan8Accel;

    @Column(name = "chan8_check")
    private String chan8Check;

    @Column(name = "chan8_name")
    private String chan8Name;

    @Column(name = "chan8_peak")
    private Double chan8Peak;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "data_base_file_name")
    private String dataBaseFileName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    private BigDecimal elevation;

    private boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_date")
    private Date eventDate;

    @Column(name = "event_f_f_t_file_data1_4")
    private String eventFFTFileData14;

    @Transient
    private String eventFFTFileData1_4;

    @Column(name = "event_f_f_t_file_data5_8")
    private String eventFFTFileData58;
    @Transient
    private String eventFFTFileData5_8;

    @Column(name = "event_f_f_t_file_name1_4")
    private String eventFFTFileName14;
    @Transient
    private String eventFFTFileName1_4;

    @Column(name = "event_f_f_t_file_name5_8")
    private String eventFFTFileName58;
    @Transient
    private String eventFFTFileName5_8;

    @Column(name = "event_report_file_data1_4")
    private String eventReportFileData14;
    @Transient
    private String eventReportFileData1_4;

    @Column(name = "event_report_file_data5_8")
    private String eventReportFileData58;
    @Transient
    private String eventReportFileData5_8;

    @Column(name = "event_report_file_name1_4")
    private String eventReportFileName14;
    @Transient
    private String eventReportFileName1_4;

    @Column(name = "event_report_file_name5_8")
    private String eventReportFileName58;
    @Transient
    private String eventReportFileName5_8;

    @Column(name = "event_type")
    private BigDecimal eventType;

    private Point geom;

    @Column(name = "highlight_event_description")
    private String highlightEventDescription;

    @Column(name = "highlight_event_type")
    private BigDecimal highlightEventType;

    @Column(name = "job_number")
    private String jobNumber;

    private BigDecimal latitude;

    @Column(name = "ex_location_name")
    private String exLocationName;

    @Column(name = "ex_location_id")
    private UUID exLocationId;

    private String location;

    @Column(name = "location_id")
    private UUID locationId;

    private BigDecimal longitude;

    @Column(name = "monitor_id")
    private UUID monitorId;

    @Column(name = "peak_vector_sum")
    private Double peakVectorSum;

    @Column(name = "peak_vector_sum2")
    private Double peakVectorSum2;

    private String time;

    @Column(name = "unit_serial_number")
    private String unitSerialNumber;

    public ExEventData() {
    }

    public UUID getEventDataId() {
	return this.eventDataId;
    }

    public void setEventDataId(final UUID eventDataId) {
	this.eventDataId = eventDataId;
    }

    public String getBlastwareFileData() {
	return this.blastwareFileData;
    }

    public void setBlastwareFileData(final String blastwareFileData) {
	this.blastwareFileData = blastwareFileData;
    }

    public String getBlastwareFileName() {
	return this.blastwareFileName;
    }

    @Trim
    public void setBlastwareFileName(final String blastwareFileName) {
	this.blastwareFileName = blastwareFileName;
    }

    public String getCalibration() {
	return this.calibration;
    }

    @Trim
    public void setCalibration(final String calibration) {
	this.calibration = calibration;
    }

    public Double getChan1Accel() {
	return this.chan1Accel;
    }

    public void setChan1Accel(final Double chan1Accel) {
	this.chan1Accel = chan1Accel;
    }

    public String getChan1Check() {
	return this.chan1Check;
    }

    @Trim
    public void setChan1Check(final String chan1Check) {
	this.chan1Check = chan1Check;
    }

    public String getChan1Name() {
	return this.chan1Name;
    }

    @Trim
    public void setChan1Name(final String chan1Name) {
	this.chan1Name = chan1Name;
    }

    public Double getChan1Peak() {
	return this.chan1Peak;
    }

    public void setChan1Peak(final Double chan1Peak) {
	this.chan1Peak = chan1Peak;
    }

    public Double getChan2Accel() {
	return this.chan2Accel;
    }

    public void setChan2Accel(final Double chan2Accel) {
	this.chan2Accel = chan2Accel;
    }

    public String getChan2Check() {
	return this.chan2Check;
    }

    @Trim
    public void setChan2Check(final String chan2Check) {
	this.chan2Check = chan2Check;
    }

    public String getChan2Name() {
	return this.chan2Name;
    }

    @Trim
    public void setChan2Name(final String chan2Name) {
	this.chan2Name = chan2Name;
    }

    public Double getChan2Peak() {
	return this.chan2Peak;
    }

    public void setChan2Peak(final Double chan2Peak) {
	this.chan2Peak = chan2Peak;
    }

    public Double getChan3Accel() {
	return this.chan3Accel;
    }

    public void setChan3Accel(final Double chan3Accel) {
	this.chan3Accel = chan3Accel;
    }

    public String getChan3Check() {
	return this.chan3Check;
    }

    @Trim
    public void setChan3Check(final String chan3Check) {
	this.chan3Check = chan3Check;
    }

    public String getChan3Name() {
	return this.chan3Name;
    }

    @Trim
    public void setChan3Name(final String chan3Name) {
	this.chan3Name = chan3Name;
    }

    public Double getChan3Peak() {
	return this.chan3Peak;
    }

    public void setChan3Peak(final Double chan3Peak) {
	this.chan3Peak = chan3Peak;
    }

    public Double getChan4Accel() {
	return this.chan4Accel;
    }

    public void setChan4Accel(final Double chan4Accel) {
	this.chan4Accel = chan4Accel;
    }

    public String getChan4Check() {
	return this.chan4Check;
    }

    @Trim
    public void setChan4Check(final String chan4Check) {
	this.chan4Check = chan4Check;
    }

    public String getChan4Name() {
	return this.chan4Name;
    }

    @Trim
    public void setChan4Name(final String chan4Name) {
	this.chan4Name = chan4Name;
    }

    public Double getChan4Peak() {
	return this.chan4Peak;
    }

    public void setChan4Peak(final Double chan4Peak) {
	this.chan4Peak = chan4Peak;
    }

    public Double getChan5Accel() {
	return this.chan5Accel;
    }

    public void setChan5Accel(final Double chan5Accel) {
	this.chan5Accel = chan5Accel;
    }

    public String getChan5Check() {
	return this.chan5Check;
    }

    @Trim
    public void setChan5Check(final String chan5Check) {
	this.chan5Check = chan5Check;
    }

    public String getChan5Name() {
	return this.chan5Name;
    }

    @Trim
    public void setChan5Name(final String chan5Name) {
	this.chan5Name = chan5Name;
    }

    public Double getChan5Peak() {
	return this.chan5Peak;
    }

    public void setChan5Peak(final Double chan5Peak) {
	this.chan5Peak = chan5Peak;
    }

    public Double getChan6Accel() {
	return this.chan6Accel;
    }

    public void setChan6Accel(final Double chan6Accel) {
	this.chan6Accel = chan6Accel;
    }

    public String getChan6Check() {
	return this.chan6Check;
    }

    @Trim
    public void setChan6Check(final String chan6Check) {
	this.chan6Check = chan6Check;
    }

    public String getChan6Name() {
	return this.chan6Name;
    }

    @Trim
    public void setChan6Name(final String chan6Name) {
	this.chan6Name = chan6Name;
    }

    public Double getChan6Peak() {
	return this.chan6Peak;
    }

    public void setChan6Peak(final Double chan6Peak) {
	this.chan6Peak = chan6Peak;
    }

    public Double getChan7Accel() {
	return this.chan7Accel;
    }

    public void setChan7Accel(final Double chan7Accel) {
	this.chan7Accel = chan7Accel;
    }

    public String getChan7Check() {
	return this.chan7Check;
    }

    @Trim
    public void setChan7Check(final String chan7Check) {
	this.chan7Check = chan7Check;
    }

    public String getChan7Name() {
	return this.chan7Name;
    }

    @Trim
    public void setChan7Name(final String chan7Name) {
	this.chan7Name = chan7Name;
    }

    public Double getChan7Peak() {
	return this.chan7Peak;
    }

    public void setChan7Peak(final Double chan7Peak) {
	this.chan7Peak = chan7Peak;
    }

    public Double getChan8Accel() {
	return this.chan8Accel;
    }

    public void setChan8Accel(final Double chan8Accel) {
	this.chan8Accel = chan8Accel;
    }

    public String getChan8Check() {
	return this.chan8Check;
    }

    @Trim
    public void setChan8Check(final String chan8Check) {
	this.chan8Check = chan8Check;
    }

    public String getChan8Name() {
	return this.chan8Name;
    }

    @Trim
    public void setChan8Name(final String chan8Name) {
	this.chan8Name = chan8Name;
    }

    public Double getChan8Peak() {
	return this.chan8Peak;
    }

    public void setChan8Peak(final Double chan8Peak) {
	this.chan8Peak = chan8Peak;
    }

    public UUID getClientId() {
	return this.clientId;
    }

    public void setClientId(final UUID clientId) {
	this.clientId = clientId;
    }

    public String getDataBaseFileName() {
	return this.dataBaseFileName;
    }

    @Trim
    public void setDataBaseFileName(final String dataBaseFileName) {
	this.dataBaseFileName = dataBaseFileName;
    }

    public Date getDate() {
	return this.date;
    }

    public void setDate(final Date date) {
	this.date = date;
    }

    public String getDescription() {
	return this.description;
    }

    @Trim
    public void setDescription(final String description) {
	this.description = description;
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

    public Date getEventDate() {
	return this.eventDate;
    }

    public void setEventDate(final Date eventDate) {
	this.eventDate = eventDate;
    }

    public String getEventFFTFileData14() {
	return this.eventFFTFileData14;
    }

    @Trim
    public void setEventFFTFileData14(final String eventFFTFileData14) {
	this.eventFFTFileData14 = eventFFTFileData14;
    }

    public String getEventFFTFileData58() {
	return this.eventFFTFileData58;
    }

    @Trim
    public void setEventFFTFileData58(final String eventFFTFileData58) {
	this.eventFFTFileData58 = eventFFTFileData58;
    }

    public String getEventFFTFileName14() {
	return this.eventFFTFileName14;
    }

    @Trim
    public void setEventFFTFileName14(final String eventFFTFileName14) {
	this.eventFFTFileName14 = eventFFTFileName14;
    }

    public String getEventFFTFileName58() {
	return this.eventFFTFileName58;
    }

    @Trim
    public void setEventFFTFileName58(final String eventFFTFileName58) {
	this.eventFFTFileName58 = eventFFTFileName58;
    }

    public String getEventReportFileData14() {
	return this.eventReportFileData14;
    }

    @Trim
    public void setEventReportFileData14(final String eventReportFileData14) {
	this.eventReportFileData14 = eventReportFileData14;
    }

    public String getEventReportFileData58() {
	return this.eventReportFileData58;
    }

    @Trim
    public void setEventReportFileData58(final String eventReportFileData58) {
	this.eventReportFileData58 = eventReportFileData58;
    }

    public String getEventReportFileName14() {
	return this.eventReportFileName14;
    }

    @Trim
    public void setEventReportFileName14(final String eventReportFileName14) {
	this.eventReportFileName14 = eventReportFileName14;
    }

    public String getEventReportFileName58() {
	return this.eventReportFileName58;
    }

    @Trim
    public void setEventReportFileName58(final String eventReportFileName58) {
	this.eventReportFileName58 = eventReportFileName58;
    }

    public BigDecimal getEventType() {
	return this.eventType;
    }

    public void setEventType(final BigDecimal eventType) {
	this.eventType = eventType;
    }

    public Point getGeom() {
	return this.geom;
    }

    public void setGeom(final Point geom) {
	this.geom = geom;
    }

    public String getHighlightEventDescription() {
	return this.highlightEventDescription;
    }

    public void setHighlightEventDescription(
	    final String highlightEventDescription) {
	this.highlightEventDescription = highlightEventDescription;
    }

    public BigDecimal getHighlightEventType() {
	return this.highlightEventType;
    }

    public void setHighlightEventType(final BigDecimal highlightEventType) {
	this.highlightEventType = highlightEventType;
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

    public String getLocation() {
	return this.location;
    }

    @Trim
    public void setLocation(final String location) {
	this.location = location;
    }

    public UUID getLocationId() {
	return this.locationId;
    }

    public void setLocationId(final UUID locationId) {
	this.locationId = locationId;
    }

    public BigDecimal getLongitude() {
	return this.longitude;
    }

    public void setLongitude(final BigDecimal longitude) {
	this.longitude = longitude;
    }

    public UUID getMonitorId() {
	return this.monitorId;
    }

    public void setMonitorId(final UUID monitorId) {
	this.monitorId = monitorId;
    }

    public Double getPeakVectorSum() {
	return this.peakVectorSum;
    }

    @Trim
    public void setPeakVectorSum(final Double peakVectorSum) {
	this.peakVectorSum = peakVectorSum;
    }

    public Double getPeakVectorSum2() {
	return this.peakVectorSum2;
    }

    @Trim
    public void setPeakVectorSum2(final Double peakVectorSum2) {
	this.peakVectorSum2 = peakVectorSum2;
    }

    public String getTime() {
	return this.time;
    }

    @Trim
    public void setTime(final String time) {
	this.time = time;
    }

    public String getUnitSerialNumber() {
	return this.unitSerialNumber;
    }

    @Trim
    public void setUnitSerialNumber(final String unitSerialNumber) {
	this.unitSerialNumber = unitSerialNumber;
    }

    public String getReportType() {
	return (StringUtils.isEmpty(this.getEventFFTFileName14())
		&& StringUtils.isEmpty(this.getEventFFTFileName58()) ? EVENT_REPORT_HISTOGRAM
		: EVENT_REPORT_WAVEFORM);
    }

    public boolean isUserReportType(final int userReportType) {
	return (userReportType == USER_REPORT_TYPE_ALL)
		|| (userReportType == USER_REPORT_TYPE_WAVEFORM && getReportType()
			.equalsIgnoreCase(EVENT_REPORT_WAVEFORM))
		|| (userReportType == USER_REPORT_TYPE_HISTOGRAM && getReportType()
			.equalsIgnoreCase(EVENT_REPORT_HISTOGRAM));
    }

    public String getEventFFTFileData1_4() {
	return eventFFTFileData14;
    }

    public String getEventFFTFileData5_8() {
	return eventFFTFileData58;
    }

    public String getEventFFTFileName1_4() {
	return eventFFTFileName14;
    }

    public String getEventFFTFileName5_8() {
	return eventFFTFileName58;
    }

    public String getEventReportFileData1_4() {
	return eventReportFileData14;
    }

    public String getEventReportFileData5_8() {
	return eventReportFileData58;
    }

    public String getEventReportFileName1_4() {
	return eventReportFileName14;
    }

    public String getEventReportFileName5_8() {
	return eventReportFileName58;
    }

    public void setEventFFTFileData1_4(final String eventFFTFileData14) {
	this.eventFFTFileData14 = eventFFTFileData14;
    }

    public void setEventFFTFileData5_8(final String eventFFTFileData58) {
	this.eventFFTFileData58 = eventFFTFileData58;
    }

    public void setEventFFTFileName1_4(final String eventFFTFileName14) {
	this.eventFFTFileName14 = eventFFTFileName14;
    }

    public void setEventFFTFileName5_8(final String eventFFTFileName58) {
	this.eventFFTFileName58 = eventFFTFileName58;
    }

    public void setEventReportFileData1_4(final String eventReportFileData14) {
	this.eventReportFileData14 = eventReportFileData14;
    }

    public void setEventReportFileData5_8(final String eventReportFileData58) {
	this.eventReportFileData58 = eventReportFileData58;
    }

    public void setEventReportFileName1_4(final String eventReportFileName14) {
	this.eventReportFileName14 = eventReportFileName14;
    }

    public void setEventReportFileName5_8(final String eventReportFileName58) {
	this.eventReportFileName58 = eventReportFileName58;
    }

    public String getExLocationName() {
	return exLocationName;
    }

    public void setExLocationName(String exLocationName) {
	this.exLocationName = exLocationName;
    }

    public UUID getExLocationId() {
	return exLocationId;
    }

    public void setExLocationId(UUID exLocationId) {
	this.exLocationId = exLocationId;
    }

    public String doubleFormating(Double value) {

	if (value == null) {
	    return "9999998";
	} else if (value.equals(Double.MAX_VALUE)) {
	    // return "\"OORANGE\"";
	    return "9999999";
	} else if (Double.isInfinite(value)) {
	    // return "\"OORANGE\"";
	    return "9999999";
	} else {
	    return value.toString();
	}
    }

}
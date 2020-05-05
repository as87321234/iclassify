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
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.blastvibrations.jpa.json.JsonBinaryType;
import com.blastvibrations.jpa.json.JsonStringType;

/**
 * The persistent class for the ex_blast_report database table.
 *
 */
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
	@TypeDef(name = "json", typeClass = JsonStringType.class) })
@Entity
@Table(name = "ex_blast_report_eventdata_mapping")
@NamedQuery(name = "ExBlastReportEventdataMapping.findAll", query = "SELECT e FROM ExBlastReportEventdataMapping e")
@ToString
public class ExBlastReportEventdataMapping extends ExEntity implements
	Serializable {

    private static final long serialVersionUID = 1L;

    public static final String DEFAULT_NAME = "Blast Report";

    @Override
    public void clearKey() {
	super.clearKey();
	this.blastEventDataId = null;
    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "blast_eventdata_id")
    private UUID blastEventDataId;

    @Column(name = "blast_id")
    private UUID blastId;

    @Column(name = "event_data_id")
    private UUID eventDataId;

    public UUID getBlastEventDataId() {
	return blastEventDataId;
    }

    public void setBlastEventDataId(UUID blastEventDataId) {
	this.blastEventDataId = blastEventDataId;
    }

    public UUID getBlastId() {
	return blastId;
    }

    public void setBlastId(UUID blastId) {
	this.blastId = blastId;
    }

    public UUID getEventDataId() {
	return eventDataId;
    }

    public void setEventDataId(UUID eventDataId) {
	this.eventDataId = eventDataId;

    }

}

package com.blastvibrations.jpa.orm;

import java.io.Serializable;
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

import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the ex_blast_complaint database table.
 *
 */
@Entity
@Table(name = "ex_blast_complaint_note")
@NamedQuery(name = "ExBlastComplaintNote.findAll", query = "SELECT e FROM ExBlastComplaintNote e")
@ToString
public class ExBlastComplaintNote extends ExEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String UPDATE = "Complaint Update";
    public static final String CLOSE = "Complaint Close";
    public static final String OPEN = "Complaint Open";

    @Override
    public void clearKey() {
	super.clearKey();
	this.blastComplaintNoteId = null;

    }

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "blast_complaint_note_id")
    private UUID blastComplaintNoteId;

    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // @GeneratedValue(generator = "uuid")
    @Column(name = "blast_complaint_id")
    private UUID blastComplaintId;

    @Column(name = "blast_complaint_note_type")
    private String blastComplaintNoteType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "note_date")
    private Date noteDate;

    @Column(name = "description")
    private String description;

    public Date getNoteDate() {
	return noteDate;
    }

    public void setNoteDate(Date noteDate) {
	this.noteDate = noteDate;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public UUID getBlastComplaintNoteId() {
	return blastComplaintNoteId;
    }

    public void setBlastComplaintNoteId(UUID blastComplaintNoteId) {
	this.blastComplaintNoteId = blastComplaintNoteId;
    }

    public UUID getBlastComplaintId() {
	return blastComplaintId;
    }

    public void setBlastComplaintId(UUID blastComplaintId) {
	this.blastComplaintId = blastComplaintId;
    }

    public String getBlastComplaintNoteType() {
	return blastComplaintNoteType;
    }

    public void setBlastComplaintNoteType(String blastComplaintNoteType) {
	this.blastComplaintNoteType = blastComplaintNoteType;
    }

}

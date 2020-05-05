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
 * The persistent class for the ex_blast_attachment database table.
 *
 */
@Entity
@Table(name = "ex_blast_attachment")
@NamedQuery(name = "ExBlastAttachment.findAll", query = "SELECT e FROM ExBlastAttachment e")
@ToString
// Lombok you need to install lombok into eclipse java -jar lombok.jar and point
// to eclipse.ini Bingo
public class ExBlastAttachment extends ExEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.blastAttachmentId = null;
	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "blast_attachment_id")
	private UUID blastAttachmentId;

	@Column(name = "blast_id")
	private UUID blastId;

	private String description;

	private String key;

	private String name;

	private String path;

	@Column(name = "thumbnail_key")
	private String thumbnailKey;

	@Column(name = "thumbnail_path")
	private String thumbnailPath;

	private String type;

	public ExBlastAttachment() {
	}

	public UUID getBlastAttachmentId() {
		return this.blastAttachmentId;
	}

	public void setBlastAttachmentId(final UUID blastAttachmentId) {
		this.blastAttachmentId = blastAttachmentId;
	}

	public void setBlastId(final UUID blastId) {
		this.blastId = blastId;
	}

	public UUID getBlastId() {
		return this.blastId;
	}

	public String getDescription() {
		return this.description;
	}

	@Trim
	public void setDescription(final String description) {
		this.description = description;
	}

	public String getKey() {
		return this.key;
	}

	@Trim
	public void setKey(final String key) {
		this.key = key;
	}

	public String getName() {
		return this.name;
	}

	@Trim
	public void setName(final String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	@Trim
	public void setPath(final String path) {
		this.path = path;
	}

	public String getThumbnailKey() {
		return this.thumbnailKey;
	}

	@Trim
	public void setThumbnailKey(final String thumbnailKey) {
		this.thumbnailKey = thumbnailKey;
	}

	public String getThumbnailPath() {
		return this.thumbnailPath;
	}

	@Trim
	public void setThumbnailPath(final String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getType() {
		return this.type;
	}

	@Trim
	public void setType(final String type) {
		this.type = type;
	}

}
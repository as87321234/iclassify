package com.pointtomap.iclassify.jpa.orm;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pointtomap.iclassify.jpa.util.ReflectionUtils;

import lombok.ToString;

/**
 * The persistent class for the ic_image database table.
 *
 */
@Entity
@Table(name = "ic_document")
@EnableJpaRepositories
@NamedQueries({

		@NamedQuery(name = IcDocument.FIND_ALL, query = "SELECT e FROM IcDocument e")

})

@ToString
public class IcDocument extends IcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "IcImage.findAll";

	@Override
	public void clearKey() {
		super.clearKey();
		this.documentId = null;

	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "document_id", updatable = false, nullable = false)
	private UUID documentId;

	@Column(name = "description")
	private String description;

	private String documentSha1;

	@OneToMany(mappedBy = "icDocument")
	Set<IcUserDocument> icUserDocuments;

	public IcDocument() {
	}

	public IcDocument(final IcDocument icImage) {

		ReflectionUtils.cloneSkipNull(icImage, this, null);
	}

	public UUID getDocumentId() {
		return documentId;
	}

	public void setDocumentId(UUID documentId) {
		this.documentId = documentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocumentSha1() {
		return documentSha1;
	}

	public void setDocumentSha1(String documentSha1) {
		this.documentSha1 = documentSha1;
	}

	public Set<IcUserDocument> getIcUserDocuments() {
		return icUserDocuments;
	}

	public void setIcUserDocuments(Set<IcUserDocument> icUserDocuments) {
		this.icUserDocuments = icUserDocuments;
	}

}
package com.pointtomap.iclassify.jpa.orm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pointtomap.iclassify.jpa.util.ReflectionUtils;

import lombok.ToString;

/**
 * The persistent class for the ic_user database table.
 *
 */
@Entity
@Table(name = "ic_user_document")
@EnableJpaRepositories
@NamedQueries({

		@NamedQuery(name = IcUserDocument.FIND_ALL, query = "SELECT e FROM IcUserImage e") })

@ToString
public class IcUserDocument extends IcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "IcUserImage.findAll";

	@Override
	public void clearKey() {
		super.clearKey();
		this.userDocumentId = null;

	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "userDocumentId", updatable = false, nullable = false)
	private UUID userDocumentId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private IcUser icUser;

	@ManyToOne
	@JoinColumn(name = "document_id")
	private IcDocument icDocument;

	public IcUserDocument() {
	}

	public IcUserDocument(final IcUserDocument icUser) {

		ReflectionUtils.cloneSkipNull(icUser, this, null);
	}

	public UUID getUserDocumentId() {
		return userDocumentId;
	}

	public void setUserDocumentId(UUID userDocumentId) {
		this.userDocumentId = userDocumentId;
	}

	public IcUser getIcUser() {
		return icUser;
	}

	public void setIcUser(IcUser icUser) {
		this.icUser = icUser;
	}

	public IcDocument getIcDocument() {
		return icDocument;
	}

	public void setIcDocument(IcDocument icDocument) {
		this.icDocument = icDocument;
	}

}
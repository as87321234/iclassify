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
@Table(name = "ic_user_image")
@EnableJpaRepositories
@NamedQueries({

		@NamedQuery(name = IcUserImage.FIND_ALL, query = "SELECT e FROM IcUserImage e") })

@ToString
public class IcUserImage extends IcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "IcUserImage.findAll";

	@Override
	public void clearKey() {
		super.clearKey();
		this.userImageId = null;

	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "userImageId", updatable = false, nullable = false)
	private UUID userImageId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private IcUser icUser;

	@ManyToOne
	@JoinColumn(name = "image_id")
	private IcImage icImage;

	public IcUserImage() {
	}

	public IcUserImage(final IcUserImage icUser) {

		ReflectionUtils.cloneSkipNull(icUser, this, null);
	}

	public UUID getUserImageId() {
		return userImageId;
	}

	public IcUser getIcUser() {
		return icUser;
	}

	public IcImage getIcImage() {
		return icImage;
	}

	public void setUserImageId(UUID userImageId) {
		this.userImageId = userImageId;
	}

	public void setIcUser(IcUser icUser) {
		this.icUser = icUser;
	}

	public void setIcImage(IcImage icImage) {
		this.icImage = icImage;
	}

}
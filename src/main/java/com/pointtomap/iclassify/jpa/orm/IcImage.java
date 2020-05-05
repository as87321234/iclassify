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
@Table(name = "ic_image")
@EnableJpaRepositories
@NamedQueries({

		@NamedQuery(name = IcImage.FIND_ALL, query = "SELECT e FROM IcImage e")

})

@ToString
public class IcImage extends IcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "IcImage.findAll";

	@Override
	public void clearKey() {
		super.clearKey();
		this.imageId = null;

	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "image_id", updatable = false, nullable = false)
	private UUID imageId;

	@Column(name = "description")
	private String description;

	private boolean enabled = true;

	private String imageSha1;

	@OneToMany(mappedBy = "icImage")
	Set<IcUserImage> icUserImages;

	public IcImage() {
	}

	public IcImage(final IcImage icImage) {

		ReflectionUtils.cloneSkipNull(icImage, this, null);
	}

	public UUID getImageId() {
		return imageId;
	}

	public String getDescription() {
		return description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public String getImageSha1() {
		return imageSha1;
	}

	public Set<IcUserImage> getIcUserImages() {
		return icUserImages;
	}

	public void setImageId(UUID imageId) {
		this.imageId = imageId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setImageSha1(String imageSha1) {
		this.imageSha1 = imageSha1;
	}

	public void setIcUserImages(Set<IcUserImage> icUserImages) {
		this.icUserImages = icUserImages;
	}

}
package com.pointtomap.iclassify.jpa.orm;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.pointtomap.iclassify.jpa.annotation.Trim;

@Configuration
@EnableJpaRepositories
@MappedSuperclass

public class IcEntity {

	private static Logger log = LoggerFactory.getLogger(IcEntity.class);
	static long iteration = 0;

	@Type(type = "uuid-char")
	@Column(name = "_id")
	private UUID id2;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "_created")
	private Date created;

	@Column(name = "_created_by_user")
	private String createdByUser;

	@Column(name = "_created_by_user_id")
	private UUID createdByUserId;

	@Column(name = "_deleted")
	private boolean deleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "_modified")
	private Date modified;

	@Column(name = "_last_modified_by_user")
	private String lastModifiedByUser;

	@Column(name = "_last_modified_by_user_id")
	private UUID lastModifiedByUserId;

	public void clearKey() {
		this.id2 = null;
	};

	public UUID getId() {
		return this.id2;
	}

	public void setId(final UUID id) {
		this.id2 = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(final Date created) {
		this.created = created;
	}

	public String getCreatedByUser() {
		return this.createdByUser;
	}

	@Trim
	public void setCreatedByUser(final String createdByUser) {
		this.createdByUser = createdByUser;
	}

	public UUID getCreatedByUserId() {
		return this.createdByUserId;
	}

	public void setCreatedByUserId(final UUID createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(final boolean deleted) {
		this.deleted = deleted;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(final Date modified) {
		this.modified = modified;
	}

	public String getLastModifiedByUser() {
		return this.lastModifiedByUser;
	}

	@Trim
	public void setLastModifiedByUser(final String lastModifiedByUser) {
		this.lastModifiedByUser = lastModifiedByUser;
	}

	public UUID getLastModifiedByUserId() {
		return this.lastModifiedByUserId;
	}

	public void setLastModifiedByUserId(final UUID lastModifiedByUserId) {
		this.lastModifiedByUserId = lastModifiedByUserId;
	}

	public void prePersist(final IcEntity entity) {

		try {
			for (final PropertyDescriptor propertyDescriptor : Introspector.getBeanInfo(entity.getClass())
					.getPropertyDescriptors()) {

				final Annotation[] annotations = (propertyDescriptor.getWriteMethod() != null
						? propertyDescriptor.getWriteMethod().getAnnotations()
						: new Annotation[0]);

				final List<String> annotationList = new ArrayList<String>();

				for (final Annotation annotation : annotations) {
					annotationList.add(annotation.annotationType().getCanonicalName());

					IcEntity.iteration++;

				}

				if (annotationList.contains(Trim.class.getCanonicalName())) {

					final Object o = propertyDescriptor.getReadMethod().invoke(this);

					if (o instanceof List) {

						final List<String> list = (List<String>) o;

						final List<String> trimmedList = new ArrayList<String>();

						for (int i = 0; i < list.size(); i++) {

							final String trimmed = list.get(i).trim();
							trimmedList.add(trimmed);
						}

						propertyDescriptor.getWriteMethod().invoke(this, trimmedList);

					} else if (o instanceof String) {

						String str = (String) propertyDescriptor.getReadMethod().invoke(this);

						if (str != null) {
							str = str.trim();
						}

						propertyDescriptor.getWriteMethod().invoke(this, str);
					}
				}

				// propertyEditor.getReadMethod() exposes the getter
				// btw, this may be null if you have a write-only property
				// System.out.println(propertyDescriptor.getReadMethod());
			}
		} catch (final IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (final IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("Number of iterations" + IcEntity.iteration);
		IcEntity.iteration = 0;

	}

	public String adjustToTimezone(Date d, int offset) {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		// String abbr = getTimeZoneShortName();
		long t = d.getTime() + (offset * 3600000);
		d = new Date(t);
		return df.format(d);

	}

}

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

import com.pointtomap.iclassify.jpa.util.HashUtil;
import com.pointtomap.iclassify.jpa.util.ReflectionUtils;

import lombok.ToString;

/**
 * The persistent class for the ic_user database table.
 *
 */
@Entity
@Table(name = "ic_user")
@EnableJpaRepositories
@NamedQueries({

		@NamedQuery(name = IcUser.FIND_ALL, query = "SELECT e FROM IcUser e"),

		@NamedQuery(cacheable = false, readOnly = false, name = IcUser.FIND_USER_BY_USER_ID, query = "SELECT c FROM IcUser c where c.userId = :userId and c.deleted=false "),

		@NamedQuery(cacheable = false, readOnly = false, name = IcUser.FIND_ALL_ACTIVE_USERS, query = "SELECT c FROM IcUser c where c.deleted = 'false' order by lower(c.username) asc "),

		@NamedQuery(cacheable = false, readOnly = false, name = IcUser.FIND_USER_BY_USERNAME, query = "SELECT c FROM IcUser c where c.username = :username and c.deleted = 'false' ") })

@ToString
public class IcUser extends IcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "IcUser.findAll";
	public static final String FIND_USER_BY_USER_ID = "IcUser.findByUserid";

	public static final String FIND_ALL_ACTIVE_USERS = "IcUser.findAllActiveUsers";

	public static final String FIND_USER_BY_USERNAME = "IcUser.findUserByUsername";

	@Override
	public void clearKey() {
		super.clearKey();
		this.userId = null;

	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "user_id", updatable = false, nullable = false)
	private UUID userId;

	@Column(name = "email_address")
	private String emailAddress;

	private boolean enabled = true;

	private String username;

	private String hashedPasswd = UUID.randomUUID().toString();

	private EnumUserGroup userGroup = EnumUserGroup.READ_ONLY;

	@OneToMany(mappedBy = "icUser")
	Set<IcUserDocument> icUserDocuments;

	public IcUser() {
	}

	public IcUser(final IcUser icUser) {

		ReflectionUtils.cloneSkipNull(icUser, this, null);
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashedPasswd() {
		return hashedPasswd;
	}

	public void setHashedPasswd(String password) {
		this.hashedPasswd = HashUtil.sha256(password);
	}

	public EnumUserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(EnumUserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public Set<IcUserDocument> getIcUserDocuments() {
		return icUserDocuments;
	}

	public void setIcUserDocuments(Set<IcUserDocument> icUserDocuments) {
		this.icUserDocuments = icUserDocuments;
	}

}
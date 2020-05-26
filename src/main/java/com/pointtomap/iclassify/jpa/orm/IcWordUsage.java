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
@Table(name = "ic_word_usage")
@EnableJpaRepositories
@NamedQueries({

		@NamedQuery(name = IcWordUsage.FIND_ALL, query = "SELECT e FROM IcWordUsage e")

//		@NamedQuery(cacheable = false, readOnly = false, name = IcWordUsage.FIND_USER_BY_USER_ID, query = "SELECT c FROM IcUser c where c.userId = :userId and c.deleted=false "),
//
//		@NamedQuery(cacheable = false, readOnly = false, name = IcWordUsage.FIND_ALL_ACTIVE_USERS, query = "SELECT c FROM IcUser c where c.deleted = 'false' order by lower(c.username) asc "),
//
//		@NamedQuery(cacheable = false, readOnly = false, name = IcWordUsage.FIND_USER_BY_USERNAME, query = "SELECT c FROM IcUser c where c.username = :username and c.deleted = 'false' ")
})

@ToString
public class IcWordUsage extends IcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "IcWordUsage.findAll";
//	public static final String FIND_USER_BY_USER_ID = "IcUser.findByUserid";
//
//	public static final String FIND_ALL_ACTIVE_USERS = "IcUser.findAllActiveUsers";
//
//	public static final String FIND_USER_BY_USERNAME = "IcUser.findUserByUsername";

	@Override
	public void clearKey() {
		super.clearKey();
		this.wordUsageId = null;

	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "word_usage_id", updatable = false, nullable = false)
	private UUID wordUsageId;

	@ManyToOne
	@JoinColumn(name = "word_translation_id")
	private IcWordTranslation icWordTranslation;

	private IcWordUsageTypeEnum wordUsageTypeEnum;

	private String usageExample;

	public IcWordUsage() {
	}

	public IcWordUsage(final IcWordUsage wordUsageId) {

		ReflectionUtils.cloneSkipNull(wordUsageId, this, null);
	}

	public IcWordUsageTypeEnum getWordUsageTypeEnum() {
		return wordUsageTypeEnum;
	}

	public void setWordUsageTypeEnum(IcWordUsageTypeEnum wordUsageTypeEnum) {
		this.wordUsageTypeEnum = wordUsageTypeEnum;
	}

	public String getUsageExample() {
		return usageExample;
	}

	public void setUsageExample(String usageExample) {
		this.usageExample = usageExample;
	}

}
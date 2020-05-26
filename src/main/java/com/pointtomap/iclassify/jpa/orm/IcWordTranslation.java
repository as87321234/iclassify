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
 * The persistent class for the ic_user database table.
 *
 */
@Entity
@Table(name = "ic_word_translation")
@EnableJpaRepositories

@NamedQueries({

		@NamedQuery(name = IcWordTranslation.FIND_ALL, query = "SELECT e FROM IcWordTranslation e")

//		@NamedQuery(cacheable = false, readOnly = false, name = IcWordTranslation.FIND_USER_BY_USER_ID, query = "SELECT c FROM IcUser c where c.userId = :userId and c.deleted=false "),
//
//		@NamedQuery(cacheable = false, readOnly = false, name = IcWordTranslation.FIND_ALL_ACTIVE_USERS, query = "SELECT c FROM IcUser c where c.deleted = 'false' order by lower(c.username) asc "),
//
//		@NamedQuery(cacheable = false, readOnly = false, name = IcWordTranslation.FIND_USER_BY_USERNAME, query = "SELECT c FROM IcUser c where c.username = :username and c.deleted = 'false' ") 
})

@ToString
public class IcWordTranslation extends IcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "IcWordTranslation.findAll";
//	public static final String FIND_USER_BY_USER_ID = "IcWordTranslation.findByWordTranslationid";
//
//	public static final String FIND_ALL_ACTIVE_USERS = "IcWordTranslation.findAllActiveUsers";
//
//	public static final String FIND_USER_BY_USERNAME = "IcWordTranslation.findUserByUsername";

	@Override
	public void clearKey() {
		super.clearKey();
		this.wordTranslationId = null;

	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "word_translation_id", updatable = false, nullable = false)
	private UUID wordTranslationId;

	private String french;
	private String frenchPhonetic;

	private String spanish;
	private String spanishPhonetic;

	private String english;
	private String englishPhonetic;

	@OneToMany(mappedBy = "icWordTranslation")
	Set<IcWordUsage> icWordUsage;

	public IcWordTranslation() {
	}

	public IcWordTranslation(final IcWordTranslation icWordTranslation) {

		ReflectionUtils.cloneSkipNull(icWordTranslation, this, null);
	}

	public UUID getWordTranslationId() {
		return wordTranslationId;
	}

	public String getFrench() {
		return french;
	}

	public String getFrenchPhonetic() {
		return frenchPhonetic;
	}

	public String getSpanish() {
		return spanish;
	}

	public String getSpanishPhonetic() {
		return spanishPhonetic;
	}

	public String getEnglish() {
		return english;
	}

	public String getEnglishPhonetic() {
		return englishPhonetic;
	}

	public Set<IcWordUsage> getIcWordUsage() {
		return icWordUsage;
	}

	public void setWordTranslationId(UUID wordTranslationId) {
		this.wordTranslationId = wordTranslationId;
	}

	public void setFrench(String french) {
		this.french = french;
	}

	public void setFrenchPhonetic(String frenchPhonetic) {
		this.frenchPhonetic = frenchPhonetic;
	}

	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}

	public void setSpanishPhonetic(String spanishPhonetic) {
		this.spanishPhonetic = spanishPhonetic;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public void setEnglishPhonetic(String englishPhonetic) {
		this.englishPhonetic = englishPhonetic;
	}

	public void setIcWordUsage(Set<IcWordUsage> icWordUsage) {
		this.icWordUsage = icWordUsage;
	}

}
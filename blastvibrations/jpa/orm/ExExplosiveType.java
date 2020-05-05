package com.blastvibrations.jpa.orm;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.ToString;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.blastvibrations.jpa.annotation.Trim;
import com.blastvibrations.jpa.json.JsonBinaryType;
import com.blastvibrations.jpa.json.JsonStringType;

/**
 * The persistent class for the ex_explosive_type database table.
 *
 */
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
	@TypeDef(name = "json", typeClass = JsonStringType.class) })
@Entity
@Table(name = "ex_explosive_type")
@NamedQuery(name = "ExExplosiveType.findAll", query = "SELECT e FROM ExExplosiveType e")
@ToString
public class ExExplosiveType extends ExEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void clearKey() {
		super.clearKey();
		this.explosiveTypeId = null;

	}

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid")
	@Column(name = "explosive_type_id")
	private UUID explosiveTypeId;

	@Type(type = "jsonb")
	@Column(name = "detonator_type_names", columnDefinition = "jsonb")
	private List<String> detonatorTypeNames;

	@Column(name = "explosive_type_name")
	private String explosiveTypeName;

	@Type(type = "jsonb")
	@Column(name = "product_type_names", columnDefinition = "jsonb")
	private List<String> productTypeNames;

	public ExExplosiveType() {
	}

	public UUID getExplosiveTypeId() {
		return this.explosiveTypeId;
	}

	public void setExplosiveTypeId(final UUID explosiveTypeId) {
		this.explosiveTypeId = explosiveTypeId;
	}

	public List<String> getDetonatorTypeNames() {
		return this.detonatorTypeNames;
	}

	@Trim
	public void setDetonatorTypeNames(final List<String> detonatorTypeNames) {
		this.detonatorTypeNames = detonatorTypeNames;
	}

	public String getExplosiveTypeName() {
		return this.explosiveTypeName;
	}

	@Trim
	public void setExplosiveTypeName(final String explosiveTypeName) {
		this.explosiveTypeName = explosiveTypeName;
	}

	public List<String> getProductTypeNames() {
		return this.productTypeNames;
	}

	@Trim
	public void setProductTypeNames(final List<String> productTypeNames) {
		this.productTypeNames = productTypeNames;
	}

}
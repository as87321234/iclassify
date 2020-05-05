package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.explosivetype.ExplosiveTypeQueries;
import com.blastvibrations.jpa.orm.ExExplosiveType;

@Repository
public class ExExplosiveTypeDaoImpl extends GenericDaoImpl<ExExplosiveType>
implements ExExplosiveTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExExplosiveType> findAllExplosiveTypes() {

		List<ExExplosiveType> exExplosiveTypeList = null;

		try {
			exExplosiveTypeList = getEntityManagerNamedQuery(
					ExplosiveTypeQueries.EXPLOSIVETYPE_FIND_ALL_EXPLOSIVE_TYPE)
					.getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exExplosiveTypeList == null) {
			return new ArrayList<ExExplosiveType>();
		} else {
			return exExplosiveTypeList;
		}
	}

}

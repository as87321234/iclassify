package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.regressiondata.RegressionDataQueries;
import com.blastvibrations.jpa.orm.ExRegressionData;

@Repository
public class ExRegressionDataDaoImpl extends GenericDaoImpl<ExRegressionData>
implements ExRegressionDataDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExRegressionData> findRegressionDataByClientId(
			final UUID clientId) {
		List<ExRegressionData> exRegressionDataList = null;

		try {
			exRegressionDataList = getEntityManagerNamedQuery(
					RegressionDataQueries.FIND_BY_CLIENTID).setParameter(
							"clientId", clientId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exRegressionDataList == null) {
			return new ArrayList<ExRegressionData>();
		} else {
			return exRegressionDataList;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExRegressionData> findRegressionDataByClientAndUserId(
			final UUID clientId, final UUID userId) {
		List<ExRegressionData> exRegressionDataList = null;

		try {
			exRegressionDataList = getEntityManagerNamedQuery(
					RegressionDataQueries.FIND_BY_CLIENT_AND_USER_ID)
					.setParameter("clientId", clientId)
					.setParameter("userId", userId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exRegressionDataList == null) {
			return new ArrayList<ExRegressionData>();
		} else {
			return exRegressionDataList;
		}
	}
}

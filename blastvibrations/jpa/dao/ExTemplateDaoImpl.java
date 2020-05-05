package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.template.TemplateQueries;
import com.blastvibrations.jpa.orm.ExTemplate;

@Repository
public class ExTemplateDaoImpl extends GenericDaoImpl<ExTemplate> implements
ExTemplateDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExTemplate> findTemplatesForUser(final UUID userId) {

		List<ExTemplate> exTemplateList = null;

		try {
			exTemplateList = getEntityManagerNamedQuery(
					TemplateQueries.MONITOR_FIND_TEMPLATE_FOR_USER)
					.setParameter("userId", userId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exTemplateList == null) {
			return new ArrayList<ExTemplate>();
		} else {
			return exTemplateList;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExTemplate> findTemplateByClientId(final UUID clientId) {
		List<ExTemplate> exClientCustomizationList = null;

		try {
			exClientCustomizationList = getEntityManagerNamedQuery(
					TemplateQueries.FIND_BY_CLIENTID).setParameter("clientId",
							clientId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exClientCustomizationList == null) {
			return new ArrayList<ExTemplate>();
		} else {
			return exClientCustomizationList;
		}
	}

}

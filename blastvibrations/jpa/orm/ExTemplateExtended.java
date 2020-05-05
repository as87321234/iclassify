package com.blastvibrations.jpa.orm;

import java.util.UUID;

import com.blastvibrations.jpa.annotation.Trim;

public class ExTemplateExtended {

	private ExTemplate exTemplate;

	public ExTemplateExtended() {
		exTemplate = new ExTemplate();
	}

	public ExTemplateExtended(final ExTemplate exTemplate) {
		this.exTemplate = exTemplate;
	}

	public ExTemplate getExTemplate() {
		return exTemplate;
	}

	public void setExTemplate(final ExTemplate exTemplate) {
		this.exTemplate = exTemplate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return exTemplate.toString();
	}

	public UUID getTemplateId() {
		// TODO Auto-generated method stub
		return exTemplate.getTemplateId();
	}

	public void setTemplateId(final UUID templateId) {
		// TODO Auto-generated method stub
		exTemplate.setTemplateId(templateId);
	}

	public UUID getClientId() {
		// TODO Auto-generated method stub
		return exTemplate.getClientId();
	}

	public void setClientId(final UUID clientId) {
		// TODO Auto-generated method stub
		exTemplate.setClientId(clientId);
	}

	public boolean getEnabled() {
		// TODO Auto-generated method stub
		return exTemplate.getEnabled();
	}

	public void setEnabled(final boolean enabled) {
		// TODO Auto-generated method stub
		exTemplate.setEnabled(enabled);
	}

	public String getTemplateData() {
		// TODO Auto-generated method stub
		return exTemplate.getTemplateData();
	}

	@Trim
	public void setTemplateData(final String templateData) {
		// TODO Auto-generated method stub
		exTemplate.setTemplateData(templateData);
	}

	public String getTemplateName() {
		// TODO Auto-generated method stub
		return exTemplate.getTemplateName();
	}

	@Trim
	public void setTemplateName(final String templateName) {
		// TODO Auto-generated method stub
		exTemplate.setTemplateName(templateName);
	}

	public UUID getUserId() {
		// TODO Auto-generated method stub
		return exTemplate.getUserId();
	}

	public void setUserId(final UUID userId) {
		// TODO Auto-generated method stub
		exTemplate.setUserId(userId);
	}

}

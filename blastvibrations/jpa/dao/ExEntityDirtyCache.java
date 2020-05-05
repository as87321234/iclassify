package com.blastvibrations.jpa.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.orm.ExEntity;

@Repository
public class ExEntityDirtyCache {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	private final Map<String, ExEntity> dirtyEntityModified = new HashMap<String, ExEntity>();

	public ExEntityDirtyCache() {

	}

	public Date getModified(final Class c, final String jsession) {

		Date watermark = null;

		if (dirtyEntityModified.get(c.getCanonicalName() + jsession) == null) {
			watermark = refreshEntity(c, jsession).getModified();
		}

		watermark = dirtyEntityModified.get(c.getCanonicalName() + jsession)
				.getModified();

		if (watermark == null) {
			watermark = new Date();
		}

		return watermark;

	}

	public void setModified(final ExEntity e, final String jsession) {

		@SuppressWarnings("rawtypes")
		final Class c = e.getClass();

		if (dirtyEntityModified.get(c.getCanonicalName() + jsession) == null) {
			refreshEntity(e.getClass(), jsession).getModified();
		}

		dirtyEntityModified.get(c.getCanonicalName() + jsession).setModified(
				e.getModified());

	}

	private ExEntity refreshEntity(final Class c, final String jsession) {

		final Query q = em.createQuery("SELECT e FROM " + c.getName()
				+ " e  order by modified desc ");

		ExEntity e = (ExEntity) q.setMaxResults(1).getSingleResult();

		if (e == null) {
			try {
				e = (ExEntity) c.newInstance();
			} catch (final InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (final IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.setModified(new Date());
		}

		if (e.getModified() == null) {
			e.setModified(new Date());
		}

		dirtyEntityModified.put(c.getCanonicalName() + jsession, e);

		return e;

	}

}

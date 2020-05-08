package com.pointtomap.iclassify;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pointtomap.iclassify.jpa.orm.IcEntity;

@Repository
public class ICEntityDirtyCache {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	private final Map<String, IcEntity> dirtyEntityModified = new HashMap<String, IcEntity>();

	public ICEntityDirtyCache() {

	}

	public Date getModified(final Class<? extends IcEntity> c, final String jsession) {

		Date watermark = null;

		if (dirtyEntityModified.get(c.getCanonicalName() + jsession) == null) {
			watermark = refreshEntity(c, jsession).getModified();
		}

		watermark = dirtyEntityModified.get(c.getCanonicalName() + jsession).getModified();

		if (watermark == null) {
			watermark = new Date();
		}

		return watermark;

	}

	public void setModified(final IcEntity e, final String jsession) {

		final Class<? extends IcEntity> c = e.getClass();

		if (dirtyEntityModified.get(c.getCanonicalName() + jsession) == null) {
			refreshEntity(e.getClass(), jsession).getModified();
		}

		dirtyEntityModified.get(c.getCanonicalName() + jsession).setModified(e.getModified());

	}

	private IcEntity refreshEntity(final Class<? extends IcEntity> c, final String jsession) {

		final Query q = em.createQuery("SELECT e FROM " + c.getName() + " e  order by modified desc ");

		IcEntity e = (IcEntity) q.setMaxResults(1).getSingleResult();

		if (e == null) {
			try {
				e = (IcEntity) c.newInstance();
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

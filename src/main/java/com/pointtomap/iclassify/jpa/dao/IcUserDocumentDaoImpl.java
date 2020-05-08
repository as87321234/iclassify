package com.pointtomap.iclassify.jpa.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.pointtomap.iclassify.jpa.orm.IcDocument;
import com.pointtomap.iclassify.jpa.orm.IcUser;
import com.pointtomap.iclassify.jpa.orm.IcUserDocument;

@Repository
public class IcUserDocumentDaoImpl extends GenericDaoImpl<IcUserDocument> implements IcUserDocumentDao {

	@Override
	public IcUserDocument findByIcDocument(IcDocument document, IcUser user) {

		IcUserDocument userDocument = null;

		try {

			userDocument = (IcUserDocument) getEntityManagerNamedQuery(IcUserDocument.FIND_BY_IC_DOCUMENT)
					.setParameter("icDocument", document).setParameter("icUser", user).getSingleResult();

			if (userDocument == null) {
				throw new Exception("Username not found");
			}

		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}
		return userDocument;

	}

}

package com.pointtomap.iclassify.jpa.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.pointtomap.iclassify.jpa.orm.IcDocument;

@Repository
public class IcDocumentDaoImpl extends GenericDaoImpl<IcDocument> implements IcDocumentDao {

	@Override
	public IcDocument findByDocumentSha1(String filenameHash) {

		IcDocument document = null;

		try {
			document = (IcDocument) getEntityManagerNamedQuery(IcDocument.FIND_DOCUMENT_BY_SHA1)
					.setParameter("documentSha1", filenameHash).getSingleResult();

			if (document == null) {
				throw new Exception(String.format("Document %s not found", filenameHash));
			}

		} catch (final NoResultException noResultEx) {
			logInfo(noResultEx.getMessage());
		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		return document;
	}

}

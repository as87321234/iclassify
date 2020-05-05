package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.blastattachment.BlastAttachmentQueries;
import com.blastvibrations.jpa.orm.ExBlastAttachment;

@Repository
public class ExBlastAttachmentDaoImpl extends GenericDaoImpl<ExBlastAttachment>
implements ExBlastAttachmentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ExBlastAttachment> findAttachmentNotDeleted(final UUID blastId) {
		List<ExBlastAttachment> exBlastAttachmentList = null;

		try {
			exBlastAttachmentList = getEntityManagerNamedQuery(
					BlastAttachmentQueries.FIND_BLAST_ATTACHMENT_NOT_DELETED)
					.setParameter("blastId", blastId).getResultList();

		} catch (final Exception ex) {
			ex.printStackTrace();
			logInfo(ex.getMessage(), ex);
		}

		if (exBlastAttachmentList == null) {
			return new ArrayList<ExBlastAttachment>();
		} else {
			return exBlastAttachmentList;
		}

	}

}

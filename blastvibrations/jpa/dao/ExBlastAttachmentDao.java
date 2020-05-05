package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExBlastAttachment;
import com.blastvibrations.jpa.orm.ExClient;

public interface ExBlastAttachmentDao {

    public List<ExBlastAttachment> findAll();

    public List<ExBlastAttachment> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExBlastAttachment> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public ExBlastAttachment find(final Object blastAttachmentId);

    public void delete(final Object blastAttachmentId);

    public void deleteLogical(final ExBlastAttachment exBlastAttachment);

    public ExBlastAttachment persist(final ExBlastAttachment exBlastAttachment);

    public List<ExBlastAttachment> findAttachmentNotDeleted(UUID blastId);

}

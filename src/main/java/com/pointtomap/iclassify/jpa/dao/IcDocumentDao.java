package com.pointtomap.iclassify.jpa.dao;

import java.util.List;

import com.pointtomap.iclassify.jpa.orm.IcDocument;

public interface IcDocumentDao {

	public List<IcDocument> findAll();

//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet);
//
//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet, boolean includeDeletedRecords);

	public IcDocument find(final Object IcDocumentId);

	public void delete(final Object IcDocumentId);

	public void deleteLogical(final IcDocument IcDocumentId);

	public IcDocument persist(final IcDocument IcDocumentId);

	public IcDocument findByDocumentSha1(String filenameHash);

}

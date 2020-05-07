package com.pointtomap.iclassify.jpa.dao;

import java.util.List;

import com.pointtomap.iclassify.jpa.orm.IcUserDocument;

public interface IcUserDocumentDao {

	public List<IcUserDocument> findAll();

//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet);
//
//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet, boolean includeDeletedRecords);

	public IcUserDocument find(final Object IcUserDocumentId);

	public void delete(final Object IcUserDocumentId);

	public void deleteLogical(final IcUserDocument IcUserDocumentId);

	public IcUserDocument persist(final IcUserDocument IcUserDocumentId);

}

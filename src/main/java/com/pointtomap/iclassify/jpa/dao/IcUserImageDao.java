package com.pointtomap.iclassify.jpa.dao;

import java.util.List;

import com.pointtomap.iclassify.jpa.orm.IcUserDocument;

public interface IcUserImageDao {

	public List<IcUserDocument> findAll();

//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet);
//
//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet, boolean includeDeletedRecords);

	public IcUserDocument find(final Object IcUserImageId);

	public void delete(final Object IcUserImageId);

	public void deleteLogical(final IcUserDocument IcUserImage);

	public IcUserDocument persist(final IcUserDocument IcUserImage);

}

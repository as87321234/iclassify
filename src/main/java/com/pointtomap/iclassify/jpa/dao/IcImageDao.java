package com.pointtomap.iclassify.jpa.dao;

import java.util.List;

import com.pointtomap.iclassify.jpa.orm.IcDocument;

public interface IcImageDao {

	public List<IcDocument> findAll();

//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet);
//
//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet, boolean includeDeletedRecords);

	public IcDocument find(final Object IcImageId);

	public void delete(final Object IcImageId);

	public void deleteLogical(final IcDocument IcImage);

	public IcDocument persist(final IcDocument IcImage);

}

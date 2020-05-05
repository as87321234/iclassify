package com.pointtomap.iclassify.jpa.dao;

import java.util.List;

import com.pointtomap.iclassify.jpa.orm.IcImage;

public interface IcImageDao {

	public List<IcImage> findAll();

//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet);
//
//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet, boolean includeDeletedRecords);

	public IcImage find(final Object IcImageId);

	public void delete(final Object IcImageId);

	public void deleteLogical(final IcImage IcImage);

	public IcImage persist(final IcImage IcImage);

}

package com.pointtomap.iclassify.jpa.dao;

import java.util.List;

import com.pointtomap.iclassify.jpa.orm.IcUserImage;

public interface IcUserImageDao {

	public List<IcUserImage> findAll();

//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet);
//
//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet, boolean includeDeletedRecords);

	public IcUserImage find(final Object IcUserImageId);

	public void delete(final Object IcUserImageId);

	public void deleteLogical(final IcUserImage IcUserImage);

	public IcUserImage persist(final IcUserImage IcUserImage);

}

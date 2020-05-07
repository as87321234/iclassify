package com.pointtomap.iclassify.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.pointtomap.iclassify.jpa.orm.IcUser;

public interface IcUserDao {

	public List<IcUser> findAll();

//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet);
//
//	public List<IcUser> tableSorting(List<IcUser> list, final SQLClause[] whereClauseList,
//			final OrderByClause[] orderByList, final int maxResultSet, boolean includeDeletedRecords);

	public IcUser find(final Object IcUserId);

	public void delete(final Object IcUserId);

	public void deleteLogical(final IcUser IcUser);

	public IcUser persist(final IcUser IcUser);

	public IcUser findByUserId(final UUID userId);

	public IcUser findUserByUsername(String username);

	public boolean checkCredential(String username, String password);

}

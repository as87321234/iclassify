package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExClient;
import com.blastvibrations.jpa.orm.ExUser;

public interface ExUserDao {

    public List<ExUser> findAll();

    public ExUser find(final Object exUserId);

    public List<ExUser> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet);

    public List<ExUser> tableSorting(List<ExClient> list,
	    final SQLClause[] whereClauseList,
	    final OrderByClause[] orderByList, final int maxResultSet,
	    boolean includeDeletedRecords);

    public void delete(final Object exUserId);

    public void deleteLogical(final ExUser exUser);

    public ExUser persist(final ExUser exUser);

    public ExUser findUsername(final String username);

    public ExUser findLoginUsername(final String username);

    public List<ExUser> findWhereUsernameNotNullOrderAcending();

    public List<ExUser> findUserIdforGivenListOfClient(List<UUID> clientList);

    public List<ExUser> findListUserByClientId(UUID clientId);

    public List<ExUser> findListUnassingedForClientid(UUID clientId);

}

package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.blastcontacts.BlastContactQueries;
import com.blastvibrations.jpa.orm.ExBlastContact;

@Repository
public class ExBlastContactDaoImpl extends GenericDaoImpl<ExBlastContact>
	implements ExBlastContactDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastContact> findBlastContactsForClientId(final UUID userId,
	    final UUID clientId) {

	List<ExBlastContact> exBlastContactList = null;

	final String querySql = "select * from ( SELECT json_array_elements (client_ids) as e, C.* "
		+ "from ex_blast_contact as C  where C.deleted = false ) as r , ex_client_user_mapping map where map.user_id = '"
		+ userId.toString()
		+ "' and cast (r.e as text ) = '\""
		+ clientId.toString()
		+ "\"' "
		+ "and map.client_id = cast (  '"
		+ clientId.toString()
		+ "' as uuid ) ";

	try {

	    final Query q = getEntityManager().createNativeQuery(querySql,
		    ExBlastContact.class);

	    exBlastContactList = q.getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastContactList == null) {
	    return new ArrayList<ExBlastContact>();
	} else {

	    // if (sort != null) {
	    // if (sort.equalsIgnoreCase("contactName")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.CLIENT);
	    // } else if (sort.equalsIgnoreCase("addresse")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.CLIENT);
	    // } else if (sort.equalsIgnoreCase("client")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.CLIENT);
	    // } else if (sort.equalsIgnoreCase("status")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.STATUS);
	    //
	    // }
	    // }

	    // Integer maxPredicatesIncludingPredicates = (new Integer(
	    // MAX_NUMBER_OF_PREDICATE_VALUES_PER_IN_CLAUSE)) - 3;
	    //
	    // final StringBuffer exSQL = new StringBuffer();
	    // exSQL.append("SELECT * FROM ExBlastContact WHERE clientIds IN ("
	    // + getClientIdSQLInClause(user) + ") AND deleted != 'true' ");
	    //
	    // if (filterClient != null && !filterClient.equalsIgnoreCase("")) {
	    // exSQL.append(" AND clientIds = '" + filterClient + "' ");
	    // maxPredicatesIncludingPredicates =
	    // maxPredicatesIncludingPredicates - 1;
	    // }
	    //
	    // if ((sort != null)
	    // && ((sort.equalsIgnoreCase("contactName"))
	    // || (sort.equalsIgnoreCase("emailAddress")) || (sort
	    // .equalsIgnoreCase("address")))) {
	    // exSQL.append(" AND " + sort + " is not null ORDER BY " + sort +
	    // "");
	    // maxPredicatesIncludingPredicates =
	    // maxPredicatesIncludingPredicates - 2;
	    // } else {
	    // exSQL.append(" AND contactName is not null ORDER BY contactName");
	    // maxPredicatesIncludingPredicates =
	    // maxPredicatesIncludingPredicates - 2;
	    //
	    // }
	    // // order by
	    // if ((order != null)
	    // && ((order.equalsIgnoreCase("ASC") || (order
	    // .equalsIgnoreCase("DESC"))))) {
	    // exSQL.append(" " + order);
	    // } else {
	    // exSQL.append(" ASC");
	    // }

	    return exBlastContactList;
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastContact> findBlastContactsForUserId(final UUID userId) {

	List<ExBlastContact> exBlastContactList = null;

	final String querySql = " select  * from (  SELECT json_array_elements (client_ids) as e, C.* from ex_blast_contact as C where c.deleted = false ) "
		+ "as r , ex_client_user_mapping map "
		+ "where map.user_id =cast ( '"
		+ userId.toString()
		+ "' as uuid ) "
		+ "and cast (r.e as text ) like '%' || cast (map.client_id  as text) || '%'";

	try {

	    final Query q = getEntityManager().createNativeQuery(querySql,
		    ExBlastContact.class);

	    exBlastContactList = q.getResultList();

	    Map<UUID, ExBlastContact> exBlastContactMap = new HashMap<UUID, ExBlastContact>();

	    exBlastContactList
		    .forEach(c -> exBlastContactMap.put(c.getId(), c));

	    exBlastContactList.clear();

	    final List<ExBlastContact> exBlastContactListCopy = new ArrayList<ExBlastContact>();
	    exBlastContactMap.forEach((k, v) -> exBlastContactListCopy.add(v));

	    exBlastContactList = exBlastContactListCopy;

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastContactList == null) {
	    return new ArrayList<ExBlastContact>();
	} else {

	    // if (sort != null) {
	    // if (sort.equalsIgnoreCase("contactName")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.CLIENT);
	    // } else if (sort.equalsIgnoreCase("addresse")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.CLIENT);
	    // } else if (sort.equalsIgnoreCase("client")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.CLIENT);
	    // } else if (sort.equalsIgnoreCase("status")) {
	    // Collections.sort(exBlastRequestList,
	    // ExBlastRequestComparators.STATUS);
	    //
	    // }
	    // }

	    // Integer maxPredicatesIncludingPredicates = (new Integer(
	    // MAX_NUMBER_OF_PREDICATE_VALUES_PER_IN_CLAUSE)) - 3;
	    //
	    // final StringBuffer exSQL = new StringBuffer();
	    // exSQL.append("SELECT * FROM ExBlastContact WHERE clientIds IN ("
	    // + getClientIdSQLInClause(user) + ") AND deleted != 'true' ");
	    //
	    // if (filterClient != null && !filterClient.equalsIgnoreCase("")) {
	    // exSQL.append(" AND clientIds = '" + filterClient + "' ");
	    // maxPredicatesIncludingPredicates =
	    // maxPredicatesIncludingPredicates - 1;
	    // }
	    //
	    // if ((sort != null)
	    // && ((sort.equalsIgnoreCase("contactName"))
	    // || (sort.equalsIgnoreCase("emailAddress")) || (sort
	    // .equalsIgnoreCase("address")))) {
	    // exSQL.append(" AND " + sort + " is not null ORDER BY " + sort +
	    // "");
	    // maxPredicatesIncludingPredicates =
	    // maxPredicatesIncludingPredicates - 2;
	    // } else {
	    // exSQL.append(" AND contactName is not null ORDER BY contactName");
	    // maxPredicatesIncludingPredicates =
	    // maxPredicatesIncludingPredicates - 2;
	    //
	    // }
	    // // order by
	    // if ((order != null)
	    // && ((order.equalsIgnoreCase("ASC") || (order
	    // .equalsIgnoreCase("DESC"))))) {
	    // exSQL.append(" " + order);
	    // } else {
	    // exSQL.append(" ASC");
	    // }

	    return exBlastContactList;
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExBlastContact> findBlastContactsForContactIdList(
	    final List<String> recipientContactIds) {

	final List<UUID> uuidContactList = new ArrayList<UUID>();

	recipientContactIds
		.forEach(c -> uuidContactList.add(UUID.fromString(c)));

	List<ExBlastContact> exBlastContactList = null;

	try {

	    final Query q = getEntityManager().createNamedQuery(
		    BlastContactQueries.FIND_FOR_CONTACT_ID_LIST).setParameter(
		    "contactIdList", uuidContactList);

	    exBlastContactList = q.getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exBlastContactList == null) {
	    return new ArrayList<ExBlastContact>();
	} else {

	    return exBlastContactList;
	}
    }
}

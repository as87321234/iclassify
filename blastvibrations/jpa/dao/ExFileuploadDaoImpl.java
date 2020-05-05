package com.blastvibrations.jpa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.blastvibrations.jpa.dao.queries.fileupload.FileuploadQueries;
import com.blastvibrations.jpa.orm.ExFileupload;

@Repository
public class ExFileuploadDaoImpl extends GenericDaoImpl<ExFileupload> implements
	ExFileuploadDao {

    @SuppressWarnings("unchecked")
    @Override
    public ExFileupload findByFileuploadId(UUID exFileuploadId) {

	List<ExFileupload> exFileuploadList = null;

	try {
	    exFileuploadList = (List<ExFileupload>) getEntityManagerNamedQuery(
		    FileuploadQueries.EX_FILEUPLOAD_FIND_ALL_FILEUPLOAD_BY_UUID)
		    .setParameter("fileuploadId", exFileuploadId)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exFileuploadList == null) {
	    return null;
	} else {
	    return exFileuploadList.get(0);
	}

    }

    @Override
    public ExFileupload findByShortUuid(String exFileuploadId) {
	List<ExFileupload> exFileuploadList = null;

	try {
	    exFileuploadList = (List<ExFileupload>) getEntityManagerNamedQuery(
		    FileuploadQueries.EX_FILEUPLOAD_FIND_ALL_FILEUPLOAD_BY_SHORT_UUID)
		    .setParameter("fileuploadId", exFileuploadId)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exFileuploadList == null) {
	    return null;
	} else {
	    return exFileuploadList.get(0);
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ExFileupload> findAllActiveFileuploads() {

	List<ExFileupload> exFileuploadList = null;

	try {
	    exFileuploadList = (List<ExFileupload>) getEntityManagerNamedQuery(
		    FileuploadQueries.EX_FILEUPLOAD_FIND_ALL_FILEUPLOAD)
		    .getResultList();

	} catch (final Exception ex) {
	    ex.printStackTrace();
	    logInfo(ex.getMessage(), ex);
	}

	if (exFileuploadList == null) {
	    return new ArrayList<ExFileupload>();
	} else {
	    return exFileuploadList;
	}

    }

}

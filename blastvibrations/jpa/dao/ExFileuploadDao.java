package com.blastvibrations.jpa.dao;

import java.util.List;
import java.util.UUID;

import com.blastvibrations.jpa.orm.ExFileupload;

public interface ExFileuploadDao {

    public List<ExFileupload> findAll();

    public ExFileupload find(final Object exFileuploadId);

    public void delete(final Object exFileuploadId);

    public void deleteLogical(final ExFileupload exFileupload);

    public ExFileupload persist(final ExFileupload exFileupload);

    public ExFileupload findByFileuploadId(final UUID exFileuploadId);

    public ExFileupload findByShortUuid(final String exFileuploadId);

    List<ExFileupload> findAllActiveFileuploads();

}

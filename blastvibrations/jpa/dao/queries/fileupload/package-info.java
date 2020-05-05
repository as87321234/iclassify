//@formatter:off
@org.hibernate.annotations.NamedQueries({

	@org.hibernate.annotations.NamedQuery(
		cacheable = false,
		readOnly = false,
		name = FileuploadQueries.EX_FILEUPLOAD_FIND_ALL_FILEUPLOAD_BY_UUID,
		query = "SELECT f FROM ExFileupload f where f.fileuploadId = :fileuploadId and f.deleted=false order by f.created desc ")
	,
	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = FileuploadQueries.EX_FILEUPLOAD_FIND_ALL_FILEUPLOAD_BY_SHORT_UUID,
			query = "SELECT f FROM ExFileupload f where f.fileuploadId  like :fileuploadId and f.deleted=false order by f.created desc ")
	,
	
	
	
	@org.hibernate.annotations.NamedQuery(
			cacheable = false,
			readOnly = false,
			name = FileuploadQueries.EX_FILEUPLOAD_FIND_ALL_FILEUPLOAD,
			query = "SELECT f FROM ExFileupload f where f.deleted=false order by f.created desc ")
})

package com.blastvibrations.jpa.dao.queries.fileupload;


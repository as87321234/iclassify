package com.blastvibrations.jpa.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.ToString;

import com.blastvibrations.jpa.annotation.Trim;

@Entity
@Table(name = "ex_fileupload")
@NamedQuery(name = "ExFileupload.findAll", query = "SELECT f FROM ExFileupload f")
@ToString
public class ExFileupload extends ExEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public void clearKey() {
	super.clearKey();
	this.fileuploadId = null;
    }

    @Id
    @Column(name = "fileupload_id")
    private String fileuploadId;

    @Column(name = "download_count")
    private Integer downloadCount;

    @Column(name = "filename")
    private String filename;

    @Column(name = "pin_number")
    private String pinNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "s3_file_uuid")
    private String s3FileUuid;

    public ExFileupload() {
    }

    public String getFileuploadId() {
	return fileuploadId;
    }

    public void setFileuploadId(String fileuploadId) {
	this.fileuploadId = fileuploadId;
    }

    public Integer getDownloadCount() {
	return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
	this.downloadCount = downloadCount;
    }

    @Trim
    public String getFilename() {
	return filename;
    }

    @Trim
    public void setFilename(String filename) {
	this.filename = filename;
    }

    public String getPinNumber() {
	return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
	this.pinNumber = pinNumber;
    }

    public String getEmailAddress() {
	return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
    }

    public String getS3FileUuid() {
	return s3FileUuid;
    }

    public void setS3FileUuid(String s3FileUuid) {
	this.s3FileUuid = s3FileUuid;
    }

    public String getURL() {

	String url = "s_url.do?command=d&r="
		+ this.getFileuploadId().substring(0, 8);

	return url;

    }
}
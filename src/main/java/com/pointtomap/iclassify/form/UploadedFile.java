package com.pointtomap.iclassify.form;

import com.pointtomap.iclassify.jpa.orm.IcDocumentTypeEnum;

public class UploadedFile

{

	private byte[] fileByteArray;
	private String filename;

	public byte[] getFileByteArray() {
		return fileByteArray;
	}

	public UploadedFile(byte[] fileByteArray, String filename) {
		super();
		this.fileByteArray = fileByteArray;
		this.filename = filename;
	}

	public void setFileByteArray(byte[] fileByteArray) {
		this.fileByteArray = fileByteArray;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public IcDocumentTypeEnum getDocumentType() {
		return IcDocumentTypeEnum.valueOf(getFileExtention());
	}

	private String getFileExtention() {

		String[] filenameTokens = filename.split("\\.");
		String fileExtension = filenameTokens[filenameTokens.length - 1];

		if (filenameTokens.length > 1 && fileExtension.length() <= 4) {

			return fileExtension.toUpperCase();

		}

		return "unknown";

	}

}

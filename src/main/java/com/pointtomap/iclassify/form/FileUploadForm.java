
package com.pointtomap.iclassify.form;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * <h1>NistPacketForm</h1>
 *
 * The NistPacketForm is DTO object that receives data for request sent to the
 * NistPacketController.
 * 
 * @author Andre St-Louis
 * @version 1.0
 * @since 2020-04-15
 */

public class FileUploadForm {

	private static Logger log = LoggerFactory.getLogger(FileUploadForm.class);

	private List<MultipartFile> fileselect;

	public List<MultipartFile> getFileselect() {
		return fileselect;
	}

	public void setFileselect(List<MultipartFile> fileselect) {
		this.fileselect = fileselect;
	}

}

package com.pointtomap.iclassify.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class MainControllerForm {

	private static Logger log = LoggerFactory.getLogger(MainControllerForm.class);

	private String jsessionId;
	private String username;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJsessionId() {
		return jsessionId;
	}

	public void setJsessionId(String jsessionId) {
		this.jsessionId = jsessionId;
	}

}
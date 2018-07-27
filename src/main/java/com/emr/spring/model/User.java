
package com.emr.spring.model;

import java.sql.Date;

public class User {

	private long id;
	private Date dateUpdated;
	private String updatedBy;

	private String name;
	private String username;
	private String password;
	private String userType;
	private boolean isActive;

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}
	
}

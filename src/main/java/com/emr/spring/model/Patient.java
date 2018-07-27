package com.emr.spring.model;

import java.sql.Date;

public class Patient {

	private long id;
	private Date dateUpdated;
	private String updatedBy;

	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private String contactNumber;
	private String username;
	private String password;
	
	private long doctorId;
}

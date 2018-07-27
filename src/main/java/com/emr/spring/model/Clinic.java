package com.emr.spring.model;

import java.sql.Date;

public class Clinic {

	private long id;
	private Date dateUpdated;
	private String updatedBy;

	private String name;
	private String address;
	private String startTime;
	private String endTime;
	private String daysOfWeek;
	
	private long doctorId;
}

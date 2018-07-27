package com.emr.spring.model;

import java.sql.Date;

public class Appointment {

	private long id;
	private Date dateUpdated;
	private String updatedBy;
	
	private String patientName;
	private int queueNumber;
	
	private long doctorId;
	private long clinicId;
}

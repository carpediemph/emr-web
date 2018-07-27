package com.emr.spring.model;

import java.sql.Date;

public class MedicalRecord {

	private long id;
	private Date dateUpdated;
	private String updatedBy;

	private int height;
	private int weight;
	private int bloodPressure;
	private Date dateTaken;
	private String symptoms;
	private String diagnosis;
	private String remarks;
	private String prescription;
	private Date followupDate;
	
	private long patientId;
	private long doctorId;
}

package com.emr.spring.model;

import java.sql.Date;

public class AccountSettings {

	private long id;
	private Date dateUpdated;
	private String updatedBy;

	private boolean staffEnabled;
	private Date subscriptionStartDate;
	private Date subscriptionEndDate;
	
	private long doctorId;
}

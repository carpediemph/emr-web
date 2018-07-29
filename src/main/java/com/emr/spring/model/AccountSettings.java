package com.emr.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT_SETTINGS")
public class AccountSettings {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="date_updated")
	private Date dateUpdated;
	
	@Column(name="updated_by")
	private String updatedBy;

	
	@Column(name="staff_enabled")
	private boolean staffEnabled;
	
	@Column(name="subs_start_date")
	private Date subscriptionStartDate;
	
	@Column(name="subs_end_date")
	private Date subscriptionEndDate;
	
	
	@Column(name="doctor_id")
	private long doctorId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean isStaffEnabled() {
		return staffEnabled;
	}

	public void setStaffEnabled(boolean staffEnabled) {
		this.staffEnabled = staffEnabled;
	}

	public Date getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	public void setSubscriptionStartDate(Date subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	public Date getSubscriptionEndDate() {
		return subscriptionEndDate;
	}

	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountSettings [id=").append(id).append(", dateUpdated=").append(dateUpdated)
				.append(", updatedBy=").append(updatedBy).append(", staffEnabled=").append(staffEnabled)
				.append(", subscriptionStartDate=").append(subscriptionStartDate).append(", subscriptionEndDate=")
				.append(subscriptionEndDate).append(", doctorId=").append(doctorId).append("]");
		return builder.toString();
	}
}

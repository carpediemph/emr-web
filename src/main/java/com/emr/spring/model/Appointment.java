package com.emr.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENTS")
public class Appointment {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="date_updated")
	private Date dateUpdated;
	
	@Column(name="updated_by")
	private String updatedBy;

	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="queue_number")
	private int queueNumber;
	
	
	@Column(name="doctor_id")
	private long doctorId;
	
	@Column(name="clinic_id")
	private long clinicId;

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

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getQueueNumber() {
		return queueNumber;
	}

	public void setQueueNumber(int queueNumber) {
		this.queueNumber = queueNumber;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public long getClinicId() {
		return clinicId;
	}

	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Appointment [id=").append(id).append(", dateUpdated=").append(dateUpdated)
				.append(", updatedBy=").append(updatedBy).append(", patientName=").append(patientName)
				.append(", queueNumber=").append(queueNumber).append(", doctorId=").append(doctorId)
				.append(", clinicId=").append(clinicId).append("]");
		return builder.toString();
	}
}

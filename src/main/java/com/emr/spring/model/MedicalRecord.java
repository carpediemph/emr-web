package com.emr.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medical_record")
public class MedicalRecord {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="date_updated")
	private Date dateUpdated;
	
	@Column(name="updated_by")
	private String updatedBy;

	
	@Column(name="height")
	private int height;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="blood_pressure")
	private int bloodPressure;
	
	@Column(name="date_taken")
	private Date dateTaken;
	
	@Column(name="symptoms")
	private String symptoms;
	
	@Column(name="diagnosis")
	private String diagnosis;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="prescription")
	private String prescription;
	
	@Column(name="followup_date")
	private Date followupDate;
	
	
	@Column(name="patient_id")
	private long patientId;
	
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public Date getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(Date dateTaken) {
		this.dateTaken = dateTaken;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public Date getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
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
		builder.append("MedicalRecord [id=").append(id).append(", dateUpdated=").append(dateUpdated)
				.append(", updatedBy=").append(updatedBy).append(", height=").append(height).append(", weight=")
				.append(weight).append(", bloodPressure=").append(bloodPressure).append(", dateTaken=")
				.append(dateTaken).append(", symptoms=").append(symptoms).append(", diagnosis=").append(diagnosis)
				.append(", remarks=").append(remarks).append(", prescription=").append(prescription)
				.append(", followupDate=").append(followupDate).append(", patientId=").append(patientId)
				.append(", doctorId=").append(doctorId).append("]");
		return builder.toString();
	}
}

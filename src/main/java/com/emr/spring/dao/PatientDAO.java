package com.emr.spring.dao;

import java.util.List;

import com.emr.spring.model.Patient;

public interface PatientDAO {

	public void addPatient(Patient patient);
	public void updatePatient(Patient patient);
	public List<Patient> listPatients();
	public List<Patient> listPatientsByDoctorId(long doctorId);
	public Patient getPatientById(long id);
}

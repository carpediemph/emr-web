package com.emr.spring.service;

import java.util.List;

import com.emr.spring.model.Clinic;

public interface ClinicService {

	public void addClinic(Clinic clinic);
	public void updateClinic(Clinic clinic);
	public List<Clinic> listClinics();
	public List<Clinic> listClinicsByDoctorId(long doctorId);
	public Clinic getClinicById(long id);
}

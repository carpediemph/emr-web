package com.emr.spring.dao;

import java.util.List;

import com.emr.spring.model.Clinic;

public interface ClinicDAO {

	public void addClinic(Clinic clinic);
	public void updateClinic(Clinic clinic);
	public List<Clinic> listClinics();
	public Clinic getClinicById(long id);
}

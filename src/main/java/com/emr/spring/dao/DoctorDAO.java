package com.emr.spring.dao;

import java.util.List;

import com.emr.spring.model.Doctor;

public interface DoctorDAO {

	public void addDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public List<Doctor> listDoctors();
	public Doctor getDoctorById(long id);
	
}

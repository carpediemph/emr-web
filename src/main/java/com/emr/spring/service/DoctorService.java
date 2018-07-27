package com.emr.spring.service;

import java.util.List;

import com.emr.spring.model.Doctor;

public interface DoctorService {

	public void addDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public List<Doctor> listDoctors();
	public Doctor getDoctorById(long id);
}

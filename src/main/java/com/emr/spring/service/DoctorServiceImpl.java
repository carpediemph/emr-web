package com.emr.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.spring.dao.DoctorDAO;
import com.emr.spring.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	private static final Logger logger = LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	@Autowired
	private DoctorDAO doctorDAO;

	@Override
	@Transactional
	public void addDoctor(Doctor doctor) {
		this.doctorDAO.addDoctor(doctor);
	}

	@Override
	@Transactional
	public void updateDoctor(Doctor doctor) {
		this.doctorDAO.updateDoctor(doctor);
	}

	@Override
	@Transactional
	public List<Doctor> listDoctors() {
		return doctorDAO.listDoctors();
	}

	@Override
	@Transactional
	public Doctor getDoctorById(long id) {
		return doctorDAO.getDoctorById(id);
	}

}

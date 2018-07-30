package com.emr.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.spring.dao.PatientDAO;
import com.emr.spring.model.Patient;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO;
	
	@Override
	public void addPatient(Patient patient) {
		patientDAO.addPatient(patient);
	}

	@Override
	public void updatePatient(Patient patient) {
		patientDAO.updatePatient(patient);
	}

	@Override
	public List<Patient> listPatients() {
		return patientDAO.listPatients();
	}

	@Override
	public List<Patient> listPatientsByDoctorId(long doctorId) {
		return patientDAO.listPatientsByDoctorId(doctorId);
	}

	@Override
	public Patient getPatientById(long id) {
		return patientDAO.getPatientById(id);
	}

}

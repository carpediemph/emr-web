package com.emr.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emr.spring.model.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO {

	private static Logger logger = LoggerFactory.getLogger(PatientDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addPatient(Patient patient) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(patient);
		logger.info("Patient saved successfully. Patient details=" + patient);
	}

	@Override
	public void updatePatient(Patient patient) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(patient);
		logger.info("Patient updated successfully. Patient details=" + patient);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> listPatients() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Patient> patients = session.createQuery("from Patient").list();
		logger.info("List patients" + patients);
		return patients;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> listPatientsByDoctorId(long doctorId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Patient> patients = session.createCriteria(Patient.class)
				.add(Restrictions.eq("doctorId", doctorId))
				.list();
		logger.info("List patients" + patients);
		return patients;
	}

	@Override
	public Patient getPatientById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Patient patient = (Patient) session.get(Patient.class, id);
		logger.info("Patient loaded successfully. Patient details=" + patient);
		return patient;
	}

}

package com.emr.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emr.spring.model.Doctor;

@Repository
public class DoctorDAOImpl implements DoctorDAO {

	private static final Logger logger = LoggerFactory.getLogger(DoctorDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addDoctor(Doctor doctor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(doctor);
		logger.info("Doctor saved successfully. Doctor details=" + doctor);
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(doctor);
		logger.info("Doctor updated successfully. Doctor details=" + doctor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> listDoctors() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Doctor> doctors = session.createQuery("from Doctor").list();
		logger.info("List doctors" + doctors);
		return doctors;
	}

	@Override
	public Doctor getDoctorById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Doctor doctor = (Doctor) session.load(Doctor.class, new Long(id));
		logger.info("Doctor loaded successfully. Doctor details=" + doctor);
		return doctor;
	}

}

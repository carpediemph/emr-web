package com.emr.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emr.spring.model.Clinic;

@Repository
public class ClinicDAOImpl implements ClinicDAO {
	
	private static Logger logger = LoggerFactory.getLogger(ClinicDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addClinic(Clinic clinic) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(clinic);
		logger.info("clinic saved successfully. clinic details=" + clinic);
	}

	@Override
	public void updateClinic(Clinic clinic) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(clinic);
		logger.info("clinic updated successfully. clinic details=" + clinic);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clinic> listClinics() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Clinic> clinics = session.createQuery("from Clinic").list();
		logger.info("List clinics" + clinics);
		return clinics;
	}

	@Override
	public Clinic getClinicById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Clinic clinic = (Clinic) session.load(Clinic.class, new Long(id));
		logger.info("Clinic loaded successfully. Clinic details=" + clinic);
		return clinic;
	}

}

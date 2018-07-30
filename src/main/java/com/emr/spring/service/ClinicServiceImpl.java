package com.emr.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.spring.dao.ClinicDAO;
import com.emr.spring.model.Clinic;

@Service
public class ClinicServiceImpl implements ClinicService {
	
	private static Logger logger = LoggerFactory.getLogger(ClinicServiceImpl.class);
	
	@Autowired
	private ClinicDAO clinicDAO;

	@Override
	public void addClinic(Clinic clinic) {
		logger.info("Adding clinic="+clinic);
		clinicDAO.addClinic(clinic);
	}

	@Override
	public void updateClinic(Clinic clinic) {
		clinicDAO.updateClinic(clinic);
	}

	@Override
	public List<Clinic> listClinics() {
		return clinicDAO.listClinics();
	}

	@Override
	public List<Clinic> listClinicsByDoctorId(long doctorId) {
		return clinicDAO.listClinicsByDoctorId(doctorId);
	}

	@Override
	public Clinic getClinicById(long id) {
		return clinicDAO.getClinicById(id);
	}

}

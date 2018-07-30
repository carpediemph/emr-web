package com.emr.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.spring.dao.StaffDAO;
import com.emr.spring.model.Staff;

@Service
public class StaffServiceImpl implements StaffService {

	private static Logger logger = LoggerFactory.getLogger(StaffServiceImpl.class);
	
	@Autowired
	private StaffDAO staffDAO;
	
	@Override
	public void addStaff(Staff staff) {
		staffDAO.addStaff(staff);
	}

	@Override
	public void updateStaff(Staff staff) {
		staffDAO.updateStaff(staff);
	}

	@Override
	public List<Staff> listStaffs() {
		return staffDAO.listStaffs();
	}

	@Override
	public List<Staff> listStaffByDoctorId(long doctorId) {
		return staffDAO.listStaffByDoctorId(doctorId);
	}

	@Override
	public List<Staff> listStaffByClinicId(long clinicId) {
		return staffDAO.listStaffByClinicId(clinicId);
	}

	@Override
	public List<Staff> listStaffByDoctorIdAndClinicId(long doctorId, long clinicId) {
		logger.info("doctorId="+doctorId+"\nclinicId="+clinicId);
		return staffDAO.listStaffByDoctorIdAndClinicId(doctorId, clinicId);
	}

	@Override
	public Staff getStaffById(long id) {
		return staffDAO.getStaffById(id);
	}

}

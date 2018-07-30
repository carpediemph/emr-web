package com.emr.spring.dao;

import java.util.List;

import com.emr.spring.model.Staff;

public interface StaffDAO {

	public void addStaff(Staff staff);
	public void updateStaff(Staff staff);
	public List<Staff> listStaffs();
	public List<Staff> listStaffByDoctorId(long doctorId);
	public List<Staff> listStaffByClinicId(long clinicId);
	public List<Staff> listStaffByDoctorIdAndClinicId(long doctorId, long clinicId);
	public Staff getStaffById(long id);
}

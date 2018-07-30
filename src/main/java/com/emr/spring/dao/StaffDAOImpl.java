package com.emr.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emr.spring.model.Staff;

@Repository
public class StaffDAOImpl implements StaffDAO {

	private static Logger logger = LoggerFactory.getLogger(StaffDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addStaff(Staff staff) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(staff);
		logger.info("Staff added successfully. Staff="+staff);
	}

	@Override
	public void updateStaff(Staff staff) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(staff);
		logger.info("Staff updated successfully. Staff="+staff);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> listStaffs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Staff> staffs = session.createQuery("from Staff").list();
		return staffs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> listStaffByDoctorId(long doctorId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Staff> staffs = session.createCriteria(Staff.class)
				.add(Restrictions.eq("doctorId", doctorId)).list();
		return staffs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> listStaffByClinicId(long clinicId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Staff> staffs = session.createCriteria(Staff.class)
				.add(Restrictions.eq("clinicId", clinicId)).list();
		return staffs;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> listStaffByDoctorIdAndClinicId(long doctorId, long clinicId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Staff> staffs = session.createCriteria(Staff.class)
				.add(Restrictions.eq("doctorId", doctorId))
				.add(Restrictions.eq("clinicId", clinicId))
				.list();
		return staffs;
	}

	@Override
	public Staff getStaffById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Staff staff = (Staff) session.get(Staff.class, new Long(id));
		return staff;
	}

}

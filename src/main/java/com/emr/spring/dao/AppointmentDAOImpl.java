package com.emr.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emr.spring.model.Appointment;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {

	private static Logger logger = LoggerFactory.getLogger(AppointmentDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addAppointment(Appointment appointment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(appointment);
		logger.info("Appointment saved. Appointment details="+appointment);
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(appointment);
		logger.info("Appointment udpated. Appointment details="+appointment);
	}

	@Override
	public void deleteAppointment(long appointmentId) {
		Session session = this.sessionFactory.getCurrentSession();
		Appointment appointment = (Appointment) session.get(Appointment.class, appointmentId);
		if (appointment != null) {
			session.delete(appointment);
		}
		logger.info("Appointment deleted. Appointment details="+appointmentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> listAppointmentsByDoctorIdAndClinicId(long doctorId, long clinicId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Appointment> appointments = session.createCriteria(Appointment.class)
				.add(Restrictions.eq("doctorId", doctorId))
				.add(Restrictions.eq("clinicId", clinicId))
				.list();
		return appointments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> listAppointmentsByDoctorId(long doctorId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Appointment> appointments = session.createCriteria(Appointment.class)
				.add(Restrictions.eq("doctorId", doctorId))
				.list();
		return appointments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Appointment> listAppointmentsByClinicId(long clinicId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Appointment> appointments = session.createCriteria(Appointment.class)
				.add(Restrictions.eq("clinicId", clinicId))
				.list();
		return appointments;
	}

	@Override
	public Appointment getAppointment(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Appointment appointment = (Appointment) session.get(Appointment.class, id);
		return appointment;
	}

}

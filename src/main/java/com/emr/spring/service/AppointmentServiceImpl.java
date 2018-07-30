package com.emr.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emr.spring.dao.AppointmentDAO;
import com.emr.spring.model.Appointment;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDAO appointmentDAO;
	
	@Override
	public void addAppointment(Appointment appointment) {
		this.appointmentDAO.addAppointment(appointment);
	}

	@Override
	public void updateAppointment(Appointment appointment) {
		this.appointmentDAO.updateAppointment(appointment);
	}

	@Override
	public void deleteAppointment(long appointmentId) {
		this.appointmentDAO.deleteAppointment(appointmentId);
	}

	@Override
	public List<Appointment> listAppointmentsByDoctorIdAndClinicId(long doctorId, long clinicId) {
		List<Appointment> appointments = this.appointmentDAO.listAppointmentsByDoctorIdAndClinicId(doctorId, clinicId);
		return appointments;
	}

	@Override
	public List<Appointment> listAppointmentsByDoctorId(long doctorId) {
		List<Appointment> appointments = this.appointmentDAO.listAppointmentsByDoctorId(doctorId);
		return appointments;
	}

	@Override
	public List<Appointment> listAppointmentsByClinicId(long clinicId) {
		List<Appointment> appointments = this.appointmentDAO.listAppointmentsByClinicId(clinicId);
		return appointments;
	}

	@Override
	public Appointment getAppointment(long id) {
		return this.appointmentDAO.getAppointment(id);
	}

}

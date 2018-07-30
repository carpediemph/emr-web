package com.emr.spring.service;

import java.util.List;

import com.emr.spring.model.Appointment;

public interface AppointmentService {

	public void addAppointment(Appointment appointment);
	public void updateAppointment(Appointment appointment);
	public void deleteAppointment(long appointmentId);
	public List<Appointment> listAppointmentsByDoctorIdAndClinicId(long doctorId, long clinicId);
	public List<Appointment> listAppointmentsByDoctorId(long doctorId);
	public List<Appointment> listAppointmentsByClinicId(long clinicId);
	public Appointment getAppointment(long id);
}

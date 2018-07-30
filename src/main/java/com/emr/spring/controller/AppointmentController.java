package com.emr.spring.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emr.spring.model.Appointment;
import com.emr.spring.model.Clinic;
import com.emr.spring.model.Doctor;
import com.emr.spring.service.AppointmentService;
import com.emr.spring.service.ClinicService;
import com.emr.spring.service.DoctorService;

@Controller
public class AppointmentController {

	private static Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping(value = "/appointments/doctor/{did}", method = RequestMethod.GET)
	public String listAppointmentsByDoctorId(@PathVariable("did") long doctorId, Model model) {
		Doctor doctor = doctorService.getDoctorById(doctorId);
		List<Clinic> clinics = clinicService.listClinicsByDoctorId(doctorId);
		Map<Long, List<Appointment>> appointments = clinics.stream()
				.collect(Collectors.toMap(
						(Clinic clinic) -> clinic.getId(), 
						(Clinic clinic) -> appointmentService.listAppointmentsByDoctorIdAndClinicId(doctorId, clinic.getId())
						));
		model.addAttribute("doctor", doctor);
		model.addAttribute("clinics", clinics);
		model.addAttribute("appointments", appointments);
		return "list-appointments-doctor";
	}
	
	@RequestMapping(value = "/appointments/doctor/{did}/clinic/{cid}", method = RequestMethod.GET)
	public String listAppointmentsByDoctorIdAndClinicId(@PathVariable("did") long doctorId, @PathVariable("cid") long clinicId, Model model) {
		Doctor doctor = doctorService.getDoctorById(doctorId);
		Clinic clinic = clinicService.getClinicById(clinicId);
		List<Appointment> appointments = appointmentService.listAppointmentsByDoctorIdAndClinicId(doctorId, clinicId);
		model.addAttribute("doctor", doctor);
		model.addAttribute("clinic", clinic);
		model.addAttribute("appointments", appointments);
		return "list-appointments-clinic";
	}
	
	@RequestMapping(value = "/appointment/add/{did}", method = RequestMethod.GET)
	public String addAppointmentForm(@PathVariable("did") long doctorId, Model model) {
		Doctor doctor = doctorService.getDoctorById(doctorId);
		List<Clinic> clinics = clinicService.listClinicsByDoctorId(doctorId);
		model.addAttribute("doctor", doctor);
		model.addAttribute("clinics", clinics);
		return "add-appointment";
	}
	
	@RequestMapping(value = "/appoinment/add", method = RequestMethod.POST)
	public String addAppointment(@ModelAttribute("appointment") Appointment appointment, Model model) {
		appointment.setDateUpdated(Date.valueOf(LocalDate.now()));
		if (appointment.getId() == 0) {
			logger.info("Adding new appointment="+appointment);
			appointmentService.addAppointment(appointment);
		} else {
			logger.info("Updating appointment="+appointment);
			appointmentService.updateAppointment(appointment);
		}
		return "redirect:/appointment/"+appointment.getId();
	}
	
	@RequestMapping(value = "/appointment/edit/{id}", method = RequestMethod.GET)
	public String editAppointment(@PathVariable("id") long id, Model model) {
		Appointment appointment = appointmentService.getAppointment(id);
		Doctor doctor = doctorService.getDoctorById(appointment.getDoctorId());
		Clinic clinic = clinicService.getClinicById(appointment.getClinicId());
		List<Clinic> clinics = clinicService.listClinicsByDoctorId(appointment.getDoctorId());
		model.addAttribute("appointment", appointment);
		model.addAttribute("doctor", doctor);
		model.addAttribute("clinic", clinic);
		model.addAttribute("clinics", clinics);
		return "edit-appointment";
	}
	
	@RequestMapping(value = "/appointment/delete/{id}/{did}", method = RequestMethod.POST)
	public String cancelAppointment(@PathVariable("id") long id, @PathVariable("did") long doctorId) {
		appointmentService.deleteAppointment(id);
		return "redirect:/appointments/doctor/"+doctorId;
	}
	
	@RequestMapping(value = "/appointment/{id}", method = RequestMethod.GET)
	public String viewAppointment(@PathVariable("id") long id, Model model) {
		Appointment appointment = appointmentService.getAppointment(id);
		Doctor doctor = doctorService.getDoctorById(appointment.getDoctorId());
		Clinic clinic = clinicService.getClinicById(appointment.getClinicId());
		model.addAttribute("appointment", appointment);
		model.addAttribute("doctor", doctor);
		model.addAttribute("clinic", clinic);
		return "view-appointment";
	}
}

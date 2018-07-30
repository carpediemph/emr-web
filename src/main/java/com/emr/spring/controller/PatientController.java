package com.emr.spring.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emr.spring.model.Patient;
import com.emr.spring.service.DoctorService;
import com.emr.spring.service.PatientService;

@Controller
public class PatientController {

	private static Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value = "/patients/doctor/{id}", method = RequestMethod.GET)
	public String listPatientsByDoctorId(@PathVariable("id") long doctorId, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(doctorId));
		model.addAttribute("patients", patientService.listPatientsByDoctorId(doctorId));
		return "list-patients-doctor";
	}
	
	@RequestMapping(value = "/patient/add/{did}", method = RequestMethod.GET)
	public String addPatientForm(@PathVariable("did") long doctorId, Model model) {
		model.addAttribute("patient", new Patient());
		model.addAttribute("doctor", doctorService.getDoctorById(doctorId));
		return "add-patient";
	}
	
	@RequestMapping(value = "/patient/add", method = RequestMethod.POST)
	public String addPatient(@ModelAttribute("patient") Patient patient, Model model) {
		patient.setDateUpdated(Date.valueOf(LocalDate.now()));
		if (patient.getId() == 0) {
			logger.info("Adding new patient="+patient);
			patientService.addPatient(patient);
		} else {
			logger.info("Updating patient="+patient);
			patientService.updatePatient(patient);
		}
		return "redirect:/patients/doctor/"+patient.getDoctorId();
	}
	
	@RequestMapping(value = "/patient/edit/{id}", method = RequestMethod.GET)
	public String editPatient(@PathVariable("id") long id, Model model) {
		model.addAttribute("staff", patientService.getPatientById(id));
		return "edit-patient";
	}
	
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
	public String viewPatient(@PathVariable("id") long id, Model model) {
		model.addAttribute("staff", patientService.getPatientById(id));
		return "view-patient";
	}
}

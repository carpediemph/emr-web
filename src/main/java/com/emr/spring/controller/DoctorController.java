package com.emr.spring.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emr.spring.model.Doctor;
import com.emr.spring.service.DoctorService;

@Controller
public class DoctorController {

	private static Logger logger = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value = "/doctors", method = RequestMethod.GET)
	public String listDoctors(Model model) {
		model.addAttribute("doctor", new Doctor());
		model.addAttribute("doctors", doctorService.listDoctors());
		return "list-doctors";
	}
	
	@RequestMapping(value = "/doctor/add", method = RequestMethod.GET)
	public String addClinic(Model model) {
		model.addAttribute("doctor", new Doctor());
		return "add-doctor";
	}
	
	@RequestMapping(value = "/doctor/add", method = RequestMethod.POST)
	public String addDoctor(@ModelAttribute("doctor") Doctor doctor) {
		doctor.setDateUpdated(Date.valueOf(LocalDate.now()));
		if (doctor.getId() == 0) {
			logger.info("Adding new doctor="+doctor);
			doctorService.addDoctor(doctor);
		} else {
			logger.info("Updating doctor="+doctor);
			doctorService.updateDoctor(doctor);
		}
		return "redirect:/doctors";
	}
	
	@RequestMapping(value = "/doctor/edit/{id}", method = RequestMethod.GET)
	public String editDoctor(@PathVariable("id") int id, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(id));
		model.addAttribute("doctors", doctorService.listDoctors());
		return "edit-doctor";
	}
	
	@RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
	public String viewDoctor(@PathVariable("id") long id, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(id));
		return "view-doctor";
	}
	
	@RequestMapping(value = "/doctors/json", method = RequestMethod.GET)
	public @ResponseBody List<Doctor> listDoctorsJson(){
		return doctorService.listDoctors();
	}
	
	@RequestMapping(value = "/doctor/{id}/json", method = RequestMethod.GET)
	public @ResponseBody Doctor getDoctorById(@PathVariable("id") long id) {
		return doctorService.getDoctorById(id);
	}
	
}

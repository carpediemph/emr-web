package com.emr.spring.controller;

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

import com.emr.spring.model.Clinic;
import com.emr.spring.service.ClinicService;

@Controller
public class ClinicController {

	private static Logger logger = LoggerFactory.getLogger(ClinicController.class);
	
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping(value = "/clinics", method = RequestMethod.GET)
	public String listClinics(Model model) {
		model.addAttribute("clinic", new Clinic());
		model.addAttribute("clinics", clinicService.listClinics());
		return "list-clinic";
	}
	
	@RequestMapping(value = "/clinic/add", method = RequestMethod.GET)
	public String addClinic(Model model) {
		model.addAttribute("clinic", new Clinic());
		return "add-clinic";
	}
	
	@RequestMapping(value = "/clinic/add", method = RequestMethod.POST)
	public String addClinic(@ModelAttribute("clinic") Clinic clinic) {
		if (clinic.getId() == 0) {
			clinicService.addClinic(clinic);
		} else {
			clinicService.updateClinic(clinic);
		}
		return "redirect:/clinics";
	}
	
	@RequestMapping(value = "/clinic/edit/{id}", method = RequestMethod.GET)
	public String editClinic(@PathVariable("id") long id, Model model) {
		model.addAttribute("clinic", clinicService.getClinicById(id));
		model.addAttribute("clinics", clinicService.listClinics());
		return "edit-clinic";
	}
	
	@RequestMapping(value = "/clinic/{id}", method = RequestMethod.GET)
	public String viewClinic(@PathVariable("id") long id, Model model){
		model.addAttribute("clinic", clinicService.getClinicById(id));
		return "view-clinic";
	}
	
	@RequestMapping(value = "/clinics/json", method = RequestMethod.GET)
	public @ResponseBody List<Clinic> listClinicsJson() {
		return clinicService.listClinics();
	}
	
	@RequestMapping(value = "/clinic/{id}/json", method = RequestMethod.GET)
	public @ResponseBody Clinic getClinicById(@PathVariable("id") long id) {
		return clinicService.getClinicById(id);
	}
}

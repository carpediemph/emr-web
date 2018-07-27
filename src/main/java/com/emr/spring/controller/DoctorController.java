package com.emr.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emr.spring.model.Doctor;
import com.emr.spring.service.DoctorService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(value = "/doctors", method = RequestMethod.GET)
	public String listDoctors(Model model) {
		model.addAttribute("doctor", new Doctor());
		model.addAttribute("doctors", doctorService.listDoctors());
		return "list-doctors";
	}
	
	@RequestMapping(value = "/doctors/json", method = RequestMethod.GET)
	public @ResponseBody List<Doctor> listDoctorsJson(){
		return doctorService.listDoctors();
	}
}

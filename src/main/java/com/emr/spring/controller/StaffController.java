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

import com.emr.spring.model.Clinic;
import com.emr.spring.model.Staff;
import com.emr.spring.service.ClinicService;
import com.emr.spring.service.DoctorService;
import com.emr.spring.service.StaffService;

@Controller
public class StaffController {

	private static Logger logger = LoggerFactory.getLogger(StaffController.class);
	
	@Autowired
	private StaffService staffService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private ClinicService clinicService;
	
	@RequestMapping(value = "/staffs/doctor/{id}", method = RequestMethod.GET)
	public String listStaffsByDoctorId(@PathVariable("id") long doctorId, Model model) {
		model.addAttribute("doctor", doctorService.getDoctorById(doctorId));
		model.addAttribute("staffs", staffService.listStaffByDoctorId(doctorId));
		return "list-staffs-doctor";
	}
	
	@RequestMapping(value = "/staffs/clinic/{id}", method = RequestMethod.GET)
	public String listStaffsByClinicId(@PathVariable("id") long clinicId, Model model) {
		model.addAttribute("clinic", clinicService.getClinicById(clinicId));
		model.addAttribute("staffs", staffService.listStaffByClinicId(clinicId));
		return "list-staffs-clinic";
	}
	
	@RequestMapping(value = "/staffs/doctor/{did}/clinic/{cid}", method = RequestMethod.GET)
	public String listStaffsByDoctorId(@PathVariable("did") long doctorId, @PathVariable("cid") long clinicId, Model model) {
		logger.info("doctorId="+doctorId+"\nclinicId="+clinicId);
		model.addAttribute("doctor", doctorService.getDoctorById(doctorId));
		model.addAttribute("clinic", clinicService.getClinicById(clinicId));
		model.addAttribute("staffs", staffService.listStaffByDoctorIdAndClinicId(doctorId, clinicId));
		return "list-staffs";
	}
	
	@RequestMapping(value = "/staff/add/{did}", method = RequestMethod.GET)
	public String addStaffForm(@PathVariable("did") long doctorId, Model model) {
		model.addAttribute("staff", new Staff());
		model.addAttribute("doctor", doctorService.getDoctorById(doctorId));
		List<Clinic> clinics = clinicService.listClinicsByDoctorId(doctorId);
		model.addAttribute("clinics", clinics);
		return "add-staff";
	}
	
	@RequestMapping(value = "/staff/add", method = RequestMethod.POST)
	public String addStaff(@ModelAttribute("staff") Staff staff, Model model) {
		staff.setDateUpdated(Date.valueOf(LocalDate.now()));
		if (staff.getId() == 0) {
			logger.info("Adding new staff="+staff);
			staffService.addStaff(staff);
		} else {
			logger.info("Updating staff="+staff);
			staffService.updateStaff(staff);
		}
		return "redirect:/staffs/doctor/"+staff.getDoctorId()+"/clinic/"+staff.getClinicId();
	}
	
	@RequestMapping(value = "/staff/edit/{id}", method = RequestMethod.GET)
	public String editStaff(@PathVariable("id") long id, Model model) {
		model.addAttribute("staff", staffService.getStaffById(id));
		return "edit-staff";
	}
	
	@RequestMapping(value = "/staff/{id}", method = RequestMethod.GET)
	public String viewStaff(@PathVariable("id") long id, Model model) {
		model.addAttribute("staff", staffService.getStaffById(id));
		return "view-staff";
	}
	
}

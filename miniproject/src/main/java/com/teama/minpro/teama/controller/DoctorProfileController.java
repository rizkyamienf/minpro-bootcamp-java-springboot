package com.teama.minpro.teama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class DoctorProfileController {
	
	@GetMapping("/doctor/{id}")
	public ModelAndView profile() {
		ModelAndView view = new ModelAndView("doctor/profile.html");
		return view;
	}
}

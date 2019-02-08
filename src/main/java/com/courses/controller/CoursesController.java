package com.courses.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CoursesController {
	
	Logger LOG = LoggerFactory.getLogger(CoursesController.class);
	
	@Value("${courses.url}")
	private String courseUrl;
	
	@GetMapping("/resttemplate")
	public String getCourses(Model model) {
		
		LOG.info("url is "+courseUrl);
		//model.addAttribute("message", "welcome");
		return "index.html";
	}
	
	
	
	

}

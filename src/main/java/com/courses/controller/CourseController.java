package com.courses.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import com.courses.model.Courses;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


@Controller
public class CourseController {
	
	Logger LOG = LoggerFactory.getLogger(CourseController.class);
	
	@Value("${courses.url}")
	private String courseUrl;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}
	
//	@SuppressWarnings("deprecation")
//	@ControllerAdvice
//	public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
//
//	    public JsonpAdvice() {
//	    	
//	    	super("callback");
//	    	//String[] callback=  new String{"courses"};
//	        
//	    }
//	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/javaparse")
	public String getCourses(Model model) {
		
		LOG.info("url is "+courseUrl);
		Courses courses = readJsonObjectFromUrl();
		Courses coursesrest = restTemplate.getForObject(courseUrl, Courses.class);
		LOG.info("size is "+coursesrest.getCourses().size());
		LOG.info("size is "+courses.getCourses().size());
		model.addAttribute("coursedata", courses);
		return "javaparse.html";
	}
	
	@GetMapping("/jqajax")
	public String getCoursesUsingjquery(Model model) {
		
		LOG.info("jqajax called ");
		return "jqajax.html";
	}
	
	@GetMapping("/")
	public String getWelcomepage(Model model) {
		
		LOG.info("index page called ");
		return "index.html";
	}
	
	
	
	public Courses readJsonObjectFromUrl()  {
		try {
			URL url = new URL(courseUrl);
		    URLConnection request = url.openConnection();
		    request.connect();

		    
		   
		    InputStreamReader is = new InputStreamReader((InputStream) request.getContent());
		    String badJson = new BufferedReader(is).lines().collect(Collectors.joining("\n"));
		    LOG.error(badJson);
		    String jsonResponse = badJson.substring(badJson.indexOf("{", 0), badJson.lastIndexOf("}")+1);
		    LOG.info(jsonResponse);
		   
		    Gson gson = new Gson();
		    Courses courses = gson.fromJson(jsonResponse, Courses.class);
		    LOG.info("size is "+courses.getCourses().size());
		    
		    return courses;
		   
		}catch(IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
	  }
	
	
	
	

}

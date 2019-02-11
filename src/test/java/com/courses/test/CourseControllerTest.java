package com.courses.test;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import com.courses.controller.CourseController;
import com.courses.controller.CourseRun;


/**
 * @author Likin Gera
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CourseRun.class, webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CourseControllerTest {
	
	Logger LOG = LoggerFactory.getLogger(CourseControllerTest.class);
	
	
	@Autowired
    private MockMvc mockMvc;
	
	
	@InjectMocks
	CourseController controller;
	
	
	@Mock
    RestTemplate restTemplate=  new RestTemplate();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		 MockitoAnnotations.initMocks(this);
		 //Mockito.when(restTemplate.getForObject(Mockito.anyString(),ArgumentMatchers.any(Class.class))).thenReturn(Mockito.any());
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testControllerObject() {
		assertTrue(controller!= null);
	}
	
	
	

	@Test
	public void testControllerResponse_200javaparse() {
		
		try {
			
			ResultActions actions = mockMvc.perform(get("/javaparse"));
			
			actions.andExpect(status().isOk())
					.andExpect(view().name("javaparse.html"))
					.andExpect(model().attribute("coursedata",hasProperty("courses", hasSize(4))));
			
			LOG.info(""+content());
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void testControllerResponse_200index() {
		
		try {
			
			
			ResultActions actions = mockMvc.perform(get("/"));
			
			actions.andExpect(status().isOk())
					.andExpect(view().name("index.html"));
			
			LOG.info(""+content());
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		 
	}
	
	@Test
	public void testControllerResponse_200jquery() {
		
		try {
			
			
			ResultActions actions = mockMvc.perform(get("/jqajax"));
			
			actions.andExpect(status().isOk())
					.andExpect(view().name("jqajax.html"));
			
			LOG.info(""+content());
		
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		 
	}

}

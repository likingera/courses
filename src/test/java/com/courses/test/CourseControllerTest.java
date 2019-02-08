package com.courses.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import com.courses.controller.CourseRun;
import com.courses.controller.CoursesController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CourseRun.class, webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CourseControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	CoursesController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void testControllerObject() {
		assertTrue(controller!= null);
	}
	
	
	

	@Test
	public void testControllerResponse_200() {
		
		try {
			
			
			ResultActions actions = mockMvc.perform(get("/resttemplate"));
			
			actions.andExpect(status().isOk());
			
			System.out.println(content());
			
			
			actions.andExpect(content().string(containsString("Hello World")));
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		 
	}

}

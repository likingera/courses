package com.courses.model;

import java.util.List;

/**
 * @author Likin Gera
 *
 */

public class Courses {
	
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Courses [courses=" + courses + "]";
	}

}

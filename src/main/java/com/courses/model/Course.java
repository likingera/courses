package com.courses.model;

import java.util.List;

/**
 * @author Likin Gera
 *
 */

public class Course {
	
	private String id;
	private String start;
	private String end;
	private String qualification;
	private List<Student> students;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", start=" + start + ", end=" + end + ", qualification=" + qualification
				+ ", students=" + students + "]";
	}
	

}

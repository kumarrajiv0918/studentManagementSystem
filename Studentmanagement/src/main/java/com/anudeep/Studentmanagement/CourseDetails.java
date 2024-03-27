package com.anudeep.Studentmanagement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CourseDetails {
	@Id
	private String  cid;
	private String courseName;
	private String courseDetails;

	public CourseDetails()
	{
		
	}
	public CourseDetails(String cid, String courseName, String courseDetails) {
		super();
		this.cid = cid;
		this.courseName = courseName;
		this.courseDetails = courseDetails;
	}

	@Override
	public String toString() {
		return "CourseDetails [cid=" + cid + ", courseName=" + courseName + ", courseDetails=" + courseDetails + "]";
	}

	public String getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public static String list() {
		// TODO Auto-generated method stub
		return "select * from CourseDetails";
	}
}

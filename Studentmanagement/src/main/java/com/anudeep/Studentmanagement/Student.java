package com.anudeep.Studentmanagement;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

import com.anudeep.MasterEmpAPP.Employee;

@Entity
//@NamedNativeQuery(name="findALL", query = "select * from Student" , resultClass=Employee.class)

public class Student {
	@Id
	private String id ;
	private String name;
	private String address;
	private String course;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getId() {
		return id;
	}
	public Student()
	{
		
	}
	public Student(String id, String name, String address, String course) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.course = course;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String  city) {
		this.address = city;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", course=" + course + "]";
	}
	public static String list() {
		// TODO Auto-generated method stub
		return "select * from student";
	}

}

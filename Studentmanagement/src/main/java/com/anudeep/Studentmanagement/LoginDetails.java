package com.anudeep.Studentmanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDetails {
	@Id
	private String name;
	@Column
	private String pass;
	
	public String getName() {
		return name;
	}
	public LoginDetails() {
		super();
	}
	public LoginDetails(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}	
	@Override
	public String toString() {
		return "LoginDetails [name=" + name + ", pass=" + pass + "]";
	}
}

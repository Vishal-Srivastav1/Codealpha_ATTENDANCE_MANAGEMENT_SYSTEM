package com.entity;

public class Faculty {
	private int id;
	private String name; 
	private String Location; 
	private String Qualification; 
	private String Branch; 
	private String email;
	 private String password;  
	private String description;
	 private String role;
	 private String pdate;
	
	public Faculty() {
		
	}

	public Faculty(String name, String location, String qualification, String branch, String email, String password,
			String description) {

		this.name = name;
		this.Location = location;
		this.Qualification = qualification;
		this.Branch = branch;
		this.email = email;
		this.password = password;
		this.description = description;
		
	}
	
	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		this.Location = location;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		this.Qualification = qualification;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		this.Branch = branch;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	
	
	
}

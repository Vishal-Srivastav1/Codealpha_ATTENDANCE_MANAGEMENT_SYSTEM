package com.entity;

public class User {
	
      private int id;
	  private String name;
	  private String Location;
	  private String Qualification;
	  private String Branch;
	  private String course;
	  private String email;
	  private String password;		
	  private String description;
	  private String role;
	  private String pdate;
	  private String Attend;
	  private String semester;
	  private String AttedenceDate;
	  private int attendID;
	 
	  
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String location, String qualification, String branch, String course, String semester, String email,
			String password, String description) {
		super();
		this.name = name;
		this.Location = location;
		this.Qualification = qualification;
		this.Branch = branch;
		this.course = course;
		this.semester=semester;
		this.email = email;
		this.password = password;
		this.description = description;
		
	}
	
	
	public User(String attend,String name, int id,String branch, String course) {
		this.Attend = attend;
		this.name=name;
		this.id=id;
		this.Branch=branch;
		this.course=course;
	}
	
	public User(String name, String branch, String course, String semester) {
		this.name = name;
		this.Branch = branch;
		this.course = course;
		this.semester = semester;
	}
	
	
	public int getAttendID() {
		return attendID;
	}
	public void setAttendID(int attendID) {
		this.attendID = attendID;
	}
	public String getAttedenceDate() {
		return AttedenceDate;
	}
	public void setAttedenceDate(String attedenceDate) {
		this.AttedenceDate = attedenceDate;
	}
	
	public String getAttend() {
		return Attend;
	}
	public void setAttend(String attend) {
		this.Attend = attend;
	}

	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	  
	  
	  
}













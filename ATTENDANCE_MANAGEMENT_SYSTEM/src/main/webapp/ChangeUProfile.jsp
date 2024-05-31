<%@page import="com.entity.User"%>
<%@page import="com.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- jstl jar -->
   <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Edit_Student</title>
<link rel="icon" href="img/logo.png" type="image/x-icon">
<%@include file="all_component/all_css.jsp"%>
<style type="text/css">
   body{
	   background-color:cyan;
	    overflow-x :hidden;
	   width:100%;
	   height:70vh;
	   background-repeat: no-repeat;
	   background-size: cover;
	   margin-top:20px;
	   
	   
	   
   }
   .main{
    
           border-radius: 10px;
   }
  button{
  margin-left:23%;
 
  
  }
 </style>
</head>
<body>
  <c:if test="${userobj.role ne 'Faculty' && userobj.role ne 'admin'}"> 
  
   <c:redirect url="login.jsp"></c:redirect>
  </c:if>
  <%response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); %>
	<%@include file="all_component/navbar.jsp"%>

     <br>
     <br>
     
       <div class="continer-fluid ">
          <div class="row g-3 ">
             <div class="col-md-6 offset-md-3">
                 <div class="card main">
					<div class="card-body">
						<div class="text-center text-success">
							<i class="fa fa-user-friends fa-3x"></i>
							
								<%
					int id=Integer.parseInt(request.getParameter("id"));					
					UserDao dao = new UserDao(DBConnect.getConn());
					User j=dao.getuserById(id);
			   %>
						<c:if test="${not empty succMsg }">  <!--Jstl jar codes  -->     
					        <div class="alert alert-success text-center" role="alert">${succMsg}</div>
							<c:remove var="succMsg"/>
							
    					</c:if> 
							<h5>Edit Student</h5>
							<hr class="featurette-divider w-90 mx-4">
						</div>
			
						
						<form action="update_Student" method="post">
							<input type="hidden" value="<%=j.getId() %>" name="id">
							
							<div class="form-group">
								<label for="title1" class="form-label">Enter Student Name</label> <input
									type="text" name="name" value="<%=j.getName()%>" class="form-control" id="title1"
									placeholder="Enter Student name " required class="form-control" autofocus>
							</div>
							<br>
                                 
							<div class="d-flex">
								<div class="form-group col-md-4">
									<label for="selecter1" class="form-label">Location</label> <select
										class="form-select" name="Location" id="selecter1" required>               
										<option  value="<%=j.getLocation()%>"><%=j.getLocation()%></option>
										<option value="Hydrabad">Hydrabad</option>
										<option value="Bhopal">Bhopal</option>
										<option value="Banglore">Banglore</option>
										<option value="Chennai">Chennai</option>
										<option value="Delhi">Delhi</option>
										<option value="Gorakhpur">Gorakhpur</option>
										<option value="Lucknow">Lucknow</option>
										<option value="Bhopal">Bhopal</option>
										<option value="Gujrat">Gujrat</option>
										<option value="Noida">Noida</option>
										<option value="Jharkhand">Jharkhand</option>
										<option value="Odisha">Odisha</option>

									</select>
								</div> 
								  &nbsp;
								<div class="form-group col-md-4">
									<label for="selecter2" class="form-label">Qualification</label> <select
										class="form-select" name="Qualification" id="selecter2" required>
										<option  value="<%=j.getQualification()%>"><%=j.getQualification()%></option>										
										<option value="10th">10th</option>											
										<option value="12th">12th</option>
								
									</select>
								</div>
								  &nbsp;
								<div class="form-group col-md-4">
									<label for="selecter3" class="form-label">Subject/Branch</label> <select
										class="form-select" name="Branch" id="selecter3" required>
										<option  value="<%=j.getBranch()%>"><%=j.getBranch()%></option>
										<option  value="Automobile Engineering">Automobile Engineering</option>
										<option  value="Computer Science">Computer Science</option>
										<option  value="Civil Engineering">Civil Engineering</option>
										<option  value="Mechanical Engineering">Mechanical Engineering</option>
										<option  value="Electrical engineering">Electrical engineering</option>
										<option  value="Electronics and Communica">Electronics and Communica</option>
										<option  value="Robotics">Robotics</option>
									</select>
								</div>
								
							</div>
							
							<div class="d-flex">
							<div class="form-group col-md-4">
									<label for="selecter3" class="form-label">Course</label> <select
										class="form-select" name="course" id="selecter3" required>
										<option  value="<%=j.getCourse()%>"><%=j.getCourse()%></option>
										<option  value="BE">BE</option>
										<option  value="B.tech">B.tech</option>
										<option  value="PHD">PHD</option>
										<option  value="Diploma">Diploma</option>
										
									</select>
								</div>
								  &nbsp;
								  <div class="form-group col-md-4">
									<label for="selecter3" class="form-label">Semester</label> <select
										class="form-select" name="semester" id="selecter3" required>
										<option  value="<%=j.getSemester()%>"><%=j.getSemester()%></option>
										<option  value="1st">1st</option>
										<option  value="2nd">2nd</option>
										<option  value="3rd">3rd</option>
										<option  value="4th">4th</option>
										<option  value="5th">5th</option>
										<option  value="6th">6th</option>
										<option  value="7th">7th</option>
										<option  value="8th">8th</option>
										
									</select>
								</div>
							</div>
								
								<div class="d-flex">
								
								<div class="form-group col-md-4">
								<label for="title3" class="form-label">Enter Student Email</label> <input
									type="email" name="email" value="<%=j.getEmail()%>" class="form-control" id="title3"
									placeholder="Student Email" required class="form-control">
							   </div>
								
							</div>
								
							
							<div class="form-group">
								<label for="Frmgrp" class="form-label">Enter Address in Details</label>
								<textarea class="form-control" name="description" id="Frmgrp" rows="3"
									cols="" required placeholder="Enter Details here "><%=j.getDescription()%></textarea>
							</div>
							<br>

							<button class="btn btn-primary w-50 ">update Student</button>					   
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>


</body>
</html>

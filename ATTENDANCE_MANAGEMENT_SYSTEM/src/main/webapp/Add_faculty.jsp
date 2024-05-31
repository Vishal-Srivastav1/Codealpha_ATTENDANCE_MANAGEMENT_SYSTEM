<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- jstl jar -->
   <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Add_Faculty</title>
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
  <c:if test="${userobj.role ne 'admin' }"> 
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
							
							
						<c:if test="${not empty succMsg }">  <!--Jstl jar codes  -->     
					        <div class="alert alert-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg"/>
							
    					</c:if> 
							<h5>Add Faculty</h5>
							<hr class="featurette-divider w-90 mx-4">
						</div>
						
						<form action="add_faculty" method="post">
							<div class="form-group">
								<label for="title1" class="form-label">Enter Faculty Name</label> <input
									type="text" name="name" class="form-control" id="title1"
									placeholder="Enter Faculty name " required class="form-control" autofocus>
							</div>
							<br>
                                 
							<div class="d-flex">
								<div class="form-group col-md-4">
									<label for="selecter1" class="form-label">Location</label> <select
										class="form-select" name="Location" id="selecter1" required>               
										<option selected disabled value="">Choose...</option>
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
										<option selected disabled value="">Choose...</option>										
										<option value="B.Com">B.Com</option>											
										<option value="BSC">BSC</option>
										<option value="B.Tech">B.Tech</option>											
										<option value="MA">MA</option>											
										<option value="BA">BA</option>										
										<option value="B.Ed">B.Ed</option>
										<option value="BCA">BCA</option>
										<option value="MBA">MBA</option>
										<option value="PHD">PHD</option>
										<option value="TGT">TGT</option>
									</select>
								</div>
								  &nbsp;
								<div class="form-group col-md-4">
									<label for="selecter3" class="form-label">Branch HOD</label> <select
										class="form-select" name="Branch" id="selecter3" required>
										<option selected disabled value="">Choose..</option>
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
								  &nbsp;
								<div class="d-flex">
								
								<div class="form-group col-md-6">
								<label for="title3" class="form-label">Enter Faculty Email</label> <input
									type="email" name="email" class="form-control" id="title3"
									placeholder="Faculty Email" required class="form-control">
							   </div>
								
								  &nbsp;
								<div class="form-group col-md-6">
								  <label for="title4" class="form-label">Enter Faculty password</label> <input
									type="password" name="password" class="form-control" id="title4"
									placeholder="Faculty password" required class="form-control">
								</div>
								
							</div>
								
							
							<div class="form-group">
								<label for="Frmgrp" class="form-label">Enter Description</label>
								<textarea class="form-control" name="description" id="Frmgrp" rows="3"
									cols="" required placeholder="Enter Description here "></textarea>
							</div>
							<br>

							<button class="btn btn-primary w-50 ">ADD Faculty</button>					   
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	


</body>
</html>

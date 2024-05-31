
<%@page import="com.entity.User"%>
<%@page import="com.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- jstl jar -->
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Semester</title>
<%@include file="all_component/all_css.jsp"%>
   <style type="text/css">
     body{
      background-color:cyan;
      margin-top:20px;
     }
   </style>
</head>
<body>
<c:if test="${userobj.role ne 'User'}"> 
   <c:redirect url="login.jsp"></c:redirect>
  </c:if>
	<%@include file="all_component/navbar.jsp"%>
	
	<div class="container fluid ">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<h5 class="text-center text-primary">Admit Card</h5>
					<c:if test="${not empty succMsg }">  <!--Jstl jar codes  -->     
					        <div class="alert alert-success text-center" role="alert">${succMsg}</div>
							<c:remove var="succMsg"/>
							
    					</c:if>
				<h6>Student Profile</h6>
				<%
				UserDao dao = new UserDao(DBConnect.getConn());
				List<User> list = dao.getAllUser();
				for (User j : list) {
				%>
				
				<div class="card ">
					<div class="card-body">
						<div class="text-center text success">
							<i class="fas fa-user-circle fa-3x"></i>
						</div>

						<table class="table ">

							<tbody>
							<c:if test="${userobj.role eq 'User'}">
								<tr>
									<th scope="row">Student Name</th>
									<th class="text-end"><%=j.getName()%></th>
								</tr>
								<tr>
									<th scope="row">Email</th>
									<th class="text-end"><%=j.getEmail()%></th>
								</tr>
								<tr>
									<th scope="row">Course</th>
									<th class="text-end"><%=j.getCourse()%></th>
								</tr>
								
								<tr>
									<th scope="row">Branch</th>
									<th class="text-end"><%=j.getBranch()%></th>
								</tr>
								<tr>
									<th scope="row">Semester</th>
									<th class="text-end"><%=j.getSemester()%></th>
								</tr>
								<tr>
									<th scope="row">Location</th>
									<th class="text-end"><%=j.getLocation()%></th>
								</tr>
								
								<tr>
									<th scope="row">Registration Date</th>
									<th class="text-end text"><%=j.getPdate()%></th>
								</tr>
								<tr>
									<th scope="row">Details Address</th>
									<th class="text-end"><%=j.getDescription()%></th>
								</tr>
								
                           </c:if>
                                 
							</tbody>
						</table>

						<!--  
					<a href="update_profile.jsp?id=${userobj.id }" class="btn btn-sm bg-success text-white ">Edit Profile</a>
				-->


					</div>
				</div>
             <%
				}
			%>
				
				
            </div>
			
			</div>
		</div>


</body>
</html>
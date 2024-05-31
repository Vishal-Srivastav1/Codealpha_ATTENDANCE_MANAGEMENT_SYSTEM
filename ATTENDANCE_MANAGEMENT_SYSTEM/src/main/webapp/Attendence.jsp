
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
<title>Attendence</title>
<%@include file="all_component/all_css.jsp"%>
   <style type="text/css">
     body{
    background-color:cyan;
    margin-top:20px;
     }
   </style>
</head>
<body>
	<c:if test="${userobj.role ne 'Faculty' }"> 
   <c:redirect url="login.jsp"></c:redirect>
  </c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container fluid">
		<div class="row ">
			<div class="col-md-12 ">
				<h5 class="text-center text-primary">Take Attendence</h5>
				
				 <c:if test="${not empty succMsg }">
							<!--Jstl jar codes  -->
							<div class="alert alert-success text-center" role="alert">${succMsg}</div>
							<c:remove var="succMsg" />
						</c:if>
				All Student
				
		
				<%
				UserDao dao = new UserDao(DBConnect.getConn());
				List<User> list = dao.getAllUser();
				for (User j : list) {
				%>
				 <form action="Attendence" method="Post">
				 <input type="hidden" value="<%=j.getId() %>" name="id">
          <div class="form-row d-flex">
         
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value="Present" name="Attend"
						id="flexCheckDefault"> <label class="form-check-label"
						for="flexCheckDefault">
						 
							<input type="text" name="name" class="form-control form-control-sm "
						value="Student Name: <%=j.getName()%>" readonly>
					</label>
				</div>
				
				<div class="form-group col-md-2">
					<input type="text" class="form-control form-control-sm " name="course"
						value="Course: <%=j.getCourse()%>" readonly>
				</div>
				<div class="form-group col-md-2">
					<input type="text" class="form-control form-control-sm " name="Branch"
						value="Branch: <%=j.getBranch()%>" readonly>
				</div>
				<div class="form-group col-md-2">
					<input type="text" class="form-control form-control-sm "
						value="Location: <%=j.getLocation()%>" readonly>
				</div>&nbsp;
			 <div class=""><button class="btn btn-primary text-center mx-4">Attendence&nbsp;<i class="fa-solid fa-check"></i></button>	</div>
			
            </div>
            <br>
            
				</form>	
           	
				<%
				}
				%>
				<br>
	
					
			</div>
		</div>
	</div>
	
	<script>
		
	</script>
</body>
</html>
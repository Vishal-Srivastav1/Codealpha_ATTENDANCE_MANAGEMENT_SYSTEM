
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
<title>Present Student</title>
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
			     <h1 class="text-center text-primary"><i class="fa-solid fa-users"></i></h1>
				<h5 class="text-center text-primary">Present Student</h5>
				
				 <c:if test="${not empty succMsg }">
							<!--Jstl jar codes  -->
							<div class="alert alert-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" />
						</c:if>
				Present All Student<br>
				
		
				<%
				UserDao dao = new UserDao(DBConnect.getConn());
				List<User> list = dao.getAllUserAttencence();
				for (User j : list) {
				%>
				
				
          <div class="form-row d-flex">
         
				<div class="form-group col-md-2">
					<input type="text" class="form-control form-control-sm "
						value=" <%=j.getName()%>" readonly>
				</div>
				
				<div class="form-group col-md-2">
					<input type="text" class="form-control form-control-sm "
						value=" <%=j.getCourse()%>" readonly>
				</div>
				<div class="form-group col-md-2">
					<input type="text" class="form-control form-control-sm "
						value=" <%=j.getBranch()%>" readonly>
				</div>
				<div class="form-group col-md-2">
					<input type="text" class="form-control form-control-sm "
						value=" <%=j.getAttend()%>" readonly>
				</div>
				<div class="form-group col-md-2">
					<input type="text" class="form-control form-control-sm "
						value=" <%=j.getAttedenceDate()%>" readonly>
				</div>&nbsp;
			
            </div>
            <br>
            
					
           	
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
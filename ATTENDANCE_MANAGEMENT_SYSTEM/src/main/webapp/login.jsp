
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
  <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
   <link rel="stylesheet" href="/static/css/style.css">
      <title>Login Page</title>
      <link rel="icon" href="img/logo.png" type="image/x-icon">
     <%@include file="all_component/all_css.jsp"%>
     
    <style type="text/css">
  form input, form option {
   width: 100%;
   border: 0;
   outline: none;
   background: #262626;
   padding: 15px;
   margin: 15px 0;
   color: #fff;
   font-size: 18px;
   border-radius: 6px;

}


     body{
    background-color:cyan;
    margin-top:20px;
     }
 
    </style> 

</head>
<body>
<%response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); %>
	<%@include file="all_component/navbar.jsp"%>

    
 <section my-5>
  <div class="container">
    <div class="row d-flex align-items-center justify-content-center h-100 my-5">
      <div class="col-md-6 col-lg-7 col-xl-6">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg"
          class="img-fluid" alt="Phone image">
          
      </div>
      <div class="col-md-4 col-lg-5 col-xl-5 offset-xl-1">

           
              
             
           <h3 class="text-center text-secondary">Login Panel</h3>

                 <c:if test="${not empty succMsg }">
							<!--Jstl jar codes  -->
							<div class="alert alert-success text-center" role="alert">${succMsg}</div>
							<c:remove var="succMsg" />
						</c:if>

                              <form action="login" method="post">
        
                                <div class="form-group col-md-6">
									<label for="selecter1" class="form-label">Your Role</label> <select
										class="form-select" name="role" id="selecter1" required>               
										<option selected disabled value="">Choose...</option>
										<option value="admin">Admin</option>
										<option value="user">Student</option>
										<option value="faculty">Faculty</option>

									</select>
								</div>
              <input  class="vishal" type="email" name="email" placeholder="Your Email" required>
              <input  class="vishal" type="password" name="passwd" placeholder="Your Password" required>
                                

          <div class="text-center ">
            <!-- Checkbox -->
           
            <a href="#!">Forgot password?</a>
          </div>

          <!-- Submit button -->
          <button type="submit" class="btn btn-primary btn-m btn-block">Sign in</button>
          <button type="reset" class="btn btn-danger btn-m btn-block">clear</button>

          </form>
          
          <div class="text-center">
            <p>OR</p>
         

          <a class="btn btn-primary btn-lg btn-block my-2" style="background-color: #3b5998" href="#!"
            role="button">
            <i class="fab fa-facebook-f me-2 "></i>Continue with Facebook
          </a>
          <br>
          <a class="btn btn-primary btn-lg btn-block my-2" style="background-color: #55acee" href="#!"
            role="button">
            <i class="fab fa-twitter me-2"></i>Continue with Twitter</a>
        </div>
      
      </div>
    </div>
  </div>
</section>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  
</body>
</html>
















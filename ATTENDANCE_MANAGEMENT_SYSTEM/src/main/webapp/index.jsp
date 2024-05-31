  <%@page import="com.db.DBConnect"%> 
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   <%@ page isELIgnored="false" %>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RGPV - University - Rajiv Gandhi Proudyogiki Vishwavidyalaya</title>
<link rel="icon" href="img/logo.png" type="image/x-icon">
<%@include file="all_component/all_css.jsp"%>

<style type="text/css">

.vxy{
  margin-bottom:37%;
}

body{

	margin: 18px;

	overflow-x: hidden;
	
    box-shadow: 10px 25px 20px gray,
           -10px -5px 20px gray,
           
           10px -5px 20px gray,
           -10px 25px 20px gray;
          
                border-radius: 10px;
}

.mimg{
  width:100%;
    margin-left:-25px;
    height:350px;
    margin-top:50px;
    
}
.mainvk{
       overflow-x: hidden;
       display:flex;
       padding:6px;
       overflow:auto;
      
 
 }
     .vk{
			width: 250px;
            height: 150px;
             border-radius: 15px;
             margin-top:10px;
         }
    .rk{
	      text-align:center;
	      margin-top:15px;
	      margin-bottom:10px;
     }
     .m{
	       margin-left: 5%;
	        text-align:center;
	       padding:10px;
	       color:blue;
	       background-color:cyan;
	       
	       margin-top:10px;
	       border:none;
	      
	       border-radius: 25px;
       
     }
     .hk{
      background-color:cyan;
	       height:300px;
	       width:260px;
	       padding:4px;
	        border-radius: 25px;
	        box-shadow: 5px 0px 7px gray,
	           -5px 0px 7px gray,
	           
	             5px 0px 7px gray,
	           -5px 0px 7px gray;
       
     }
     .hkm{
      	 margin-left:40px;
    
     }
    .spid{
         color:yellow;
     }
     
     .homepage{
       width:50%;
        height:100px;
         margin-left:25%;   
         padding:2px;
       
     }
     
   .lead{
      font-size: 15px;
      margin-top:-40px;
   }
   

 .vk:hover{
          
           margin-top:-2px;
	       box-shadow: inset -5px 5px 5px rgba( 255,255,255,0.2),       
		               inset -8px 8px 8px rgba(15, 14, 15, 0.1),
		               inset 8px 8px 8px rgba(15, 14, 15, 0.1),
		                inset 8px -8px 8px rgba(15, 14, 15, 0.1);
           border-radius: 25px;
 
       }
       
       .ch{
	           width:50px;
	          height:50px;
	          padding:0px;
          
       }
       .rmk{
	        display: flex;
            justify-content:center;
            align-items: center;
          border-radius: 50%;
          margin:auto;
          margin-top:10px;
          
           margin-bottom:10px;
        
       }
       
       .rmk:hover{
         
          box-shadow: 5px 0px 7px gray,
           -5px 0px 7px gray,
           
              5px 0px 7px gray,
           -5px 0px 7px gray;
           
       }
       .al{
            overflow-x: hidden;
             justify-content:center;
            
       }

       
</style>
</head>
<body>
<%response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); %>
	<%@include file="all_component/navbar.jsp"%>

 <div>
    <img alt="" src="img/logo.png" class="homepage">
 </div>
 

<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
    <div class="carousel-caption text-center vxy">
            <c:if test="${not empty succMsg }">
					<div class="alert alert-success" role="alert">${succMsg}</div>
					<c:remove var="succMsg" />
		  </c:if>
        </div>
      <img src="img/new_slide1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="img/new_slide2.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="img/new_slide3.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<br>
    <br>
	

	<div class="text-center">
		<h1 class="text-black">
			<span class="text-muted">Our Institutions </span>
		</h1>
		<hr class="featurette-divider">
		<br>
		
         <br>

        
 <div class="container-fluid mainvk">
 
  <div class="col hkm">
    <div class="card hk">
      <img src="img/img_ins_pvt.jpg" class="card-img-top vk" alt="...">
      <div class="card-body ">
        <h5 class="card-title rk">Private</h5>
           <button class=" m"><b>Visit</b></button>
      </div>
    </div>
  </div>
  <div class="col hkm">
    <div class="card hk">
      <img src="img/img_ins_poly.jpg" class="card-img-top vk" alt="...">
      <div class="card-body">
        <h5 class="card-title rk">Polytechnic</h5>
         <button class=" m"><b>Visit</b></button>
      </div>
    </div>
  </div>

  <div class="col hkm">
    <div class="card hk">
      <img src="img/img_ins_govt.jpg" class="card-img-top vk" alt="...">
      <div class="card-body">
        <h5 class="card-title rk">Government</h5>
       
         <button class=" m"><b>Visit</b></button>
      </div>
    </div>
  </div>
</div>
		
		
	</div>
	<br>
	<hr class="featurette-divider">

	<div class="row featurette">
	<h1><span class="text-muted m-5">About Us </span></h1>
		<div class="col-md-7">
			<h2 class="featurette-heading p-4">Rajiv Gandhi Proudyogiki Vishwavidyalaya</h2>
			<p class="lead p-4"> RGPV Established in the year 1998, by Madhya Pradesh Vidhan Sabha Act 13, 
			1998. Over a sprawling Campus of about 247 acres, the Rajiv Gandhi Proudyogiki Vishwavidyalaya is 
			marching towards development into a center of excellence in the arena of Technical Education, Research 
			and Innovations. Under its umbrella there are 05 UTD's, 200 affiliated Engineering Colleges, 98 Pharmacy Colleges,
			 95 MCA Colleges and 04 Architecture Colleges imparting Graduate level instructions running around 17 under graduate level courses, 
			 57 Polytechnic institutions offering diploma courses in emerging and conventional disciplines. Situated amidst an aesthetic and hilly 
			 surrounding, the University is now offering Ph Ds and and 11 post-graduate courses in five University Teaching departments under the 
			 faculties of Information Technology, Pharmaceutical Sciences, Nano Technology, Biotechnology, Energy Technology, Civil Engineering Electrical
			  Engineering and Mechanical Engineering keeping in tune with the needs of the ever expanding Global Knowledge Economy. The affiliated colleges and the
			   University Departments conduct a good number of conventional and emerging multidisciplinary programmes. Some of the affiliated colleges have been permitted
			    to impart Post Graduate teaching. It is really encouraging to put on record that the University has kept abreast of the proliferation of new domains of
			     knowledge introducing world class research oriented post graduate programmes in Computer Technology and Applications, Quality Assurance in Pharmaceutical Sciences, 
			     Power System and Energy Technology in its campus.
			</p>
		</div>
		<div class="col-md-5">
			<img src="img/new_slide2.jpg" class="rounded float-left mimg" alt="Img">

		</div>
	</div>
	<br>
	

	<%@include file="all_component/footer.jsp"%>
</body>
</html>
package com.servlet;
/**
 * Servlet implementation class AddPostServlet
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FacultyDao;
import com.db.DBConnect;
import com.entity.Faculty;


@WebServlet("/add_faculty")
public class AddfacultyServlet extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    		
        String name=req.getParameter("name");
  		String Location=req.getParameter("Location");
  		String Qualification=req.getParameter("Qualification");
  		String Branch=req.getParameter("Branch");
  		String email=req.getParameter("email");
  		String password=req.getParameter("password");		
  		String description=req.getParameter("description");
  		
  		
  		 HttpSession session= req.getSession();
			if (name!= null && !name.equals("") && Location != null && !Location.equals("")
					&& Qualification != null && !Qualification.equals("") && Branch!= null && !Branch.equals("")
					&& email != null && !email.equals("") && password != null && !password.equals("") && description != null && !description.equals("")) {
		  try {
		
			  FacultyDao dao=new FacultyDao(DBConnect.getConn());
	        	
	        	 Faculty faculty=new Faculty(name,Location,Qualification,Branch,email,password,description);
	        	 
	        	 boolean f=dao.addfaculty(faculty);
	        	
	        	 if (f) {
	    				session.setAttribute("succMsg", "Registration Successfully..");
	    				resp.sendRedirect("Add_faculty.jsp");
	    			}else {
	    				session.setAttribute("succMsg", "Error: Problem in Server Side..");
	    				resp.sendRedirect("Add_faculty.jsp");
	    			}
	        	 
		} catch (Exception e) {
			e.printStackTrace();
		}
			}else {
				session.setAttribute("succMsg", "All Fields required..");
				resp.sendRedirect("Add_faculty.jsp");
			}
    	
    }
}

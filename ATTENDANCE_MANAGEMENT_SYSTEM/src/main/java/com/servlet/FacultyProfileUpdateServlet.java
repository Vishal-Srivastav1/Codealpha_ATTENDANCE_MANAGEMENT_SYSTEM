package com.servlet;
/**
 * Servlet implementation class Profile_UpdateServlet
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

@WebServlet("/edit_faculty")
public class FacultyProfileUpdateServlet extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		    int id=Integer.parseInt(req.getParameter("id"));
		    String name=req.getParameter("name");
	  		String Location=req.getParameter("Location");
	  		String Qualification=req.getParameter("Qualification");
	  		String Branch=req.getParameter("Branch");
	  		String email=req.getParameter("email");		
	  		String description=req.getParameter("description");
	  		
	  	
	  		 HttpSession session= req.getSession();
				if (name!= null && !name.equals("") && Location != null && !Location.equals("")
						&& Qualification != null && !Qualification.equals("") && Branch!= null && !Branch.equals("")
						&& email != null && !email.equals("") && description != null && !description.equals("")) {
			  try {
			
				  FacultyDao dao=new FacultyDao(DBConnect.getConn());
		        	
		        	 Faculty faculty=new Faculty();
		        	     faculty.setId(id);
			       		faculty.setName(name);
			       		faculty.setLocation(Location);
			       		faculty.setQualification(Qualification);
			       		faculty.setBranch(Branch);
			       		faculty.setEmail(email);
			       		
		        	 boolean f=dao.updateFaculty(faculty);
		        	 
        		if (f) {
    				session.setAttribute("succMsg", "profile Updated Successfully");
    				resp.sendRedirect("All_Faculty.jsp");
    			}else {
    				session.setAttribute("succMsg", "Error: Problem in Server Side..");
    				resp.sendRedirect("Edit_Faculty.jsp");
    			}
        	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			session.setAttribute("succMsg", "Error: All Form filled required");
			resp.sendRedirect("Edit_Faculty.jsp");
		}
    }
	
	
}













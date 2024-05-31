package com.servlet;
/**
 * Servlet implementation class LoginServlet
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FacultyDao;
import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.Faculty;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
         String role=req.getParameter("role");
         String eml=req.getParameter("email");
		 String pswd=req.getParameter("passwd");
		 
		   HttpSession session= req.getSession();
		   
			if (eml != null && !eml.equals("") && pswd != null && !pswd.equals("") && role!=null && !role.equals("")) {
		  try {
			
			  User u=new User();
			
			 
			    //Using String in Switch expression  
			    switch(role){    
			    //Using String Literal in Switch case  
			   
			    case "admin": 
			    	
			    	if ("admin@gmail.com".equals(eml) && "admin@123".equals(pswd) && "admin".equals(role)) {
						 session.setAttribute("userobj", u);
						u.setRole("admin");
						resp.sendRedirect("index.jsp");
						
					}else {
						session.setAttribute("succMsg", "Invalid user Email or password");
						resp.sendRedirect("login.jsp");
					}
			    break; 
			    
			    case "user": 
			    	
			    	UserDao dao =new UserDao(DBConnect.getConn());
					User user=dao.login(eml, pswd);
					
					if (user!=null) {
						
						session.setAttribute("userobj", user);
						user.setRole("User");
						resp.sendRedirect("index.jsp");
					}else {
						session.setAttribute("succMsg", "Invalid user Email or password");
						resp.sendRedirect("login.jsp");
					}
					
			    break; 
			    
			    case "faculty": 
			    	
			    	FacultyDao fdao =new FacultyDao(DBConnect.getConn());
					Faculty faculty=fdao.login(eml, pswd);
		
					if (faculty!=null) {
						
						session.setAttribute("userobj", faculty);
						faculty.setRole("Faculty");
						resp.sendRedirect("index.jsp");
					}else {
						session.setAttribute("succMsg", "Invalid user Email or password");
						resp.sendRedirect("login.jsp");
					}
				
			         break;  
			    
			    default:  
			    	session.setAttribute("succMsg", "Invalid user Email or password");
					resp.sendRedirect("login.jsp");
			      break;  
			    }    
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else {
		session.setAttribute("succMsg", "Email or password required..");
		resp.sendRedirect("login.jsp");
	}
	}
}

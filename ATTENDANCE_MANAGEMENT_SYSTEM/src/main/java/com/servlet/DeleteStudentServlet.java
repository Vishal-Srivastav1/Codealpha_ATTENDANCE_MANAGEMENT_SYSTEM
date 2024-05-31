
	package com.servlet;

	import java.io.IOException;

/**
	 * Servlet implementation class DeletePostServlet
	 */
	

	import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FacultyDao;
import com.dao.UserDao;
import com.db.DBConnect;

	@WebServlet("/deleteStudent")
	public class DeleteStudentServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				int id=Integer.parseInt(req.getParameter("id"));
				
				UserDao dao=new UserDao(DBConnect.getConn()); 		
	    		boolean f= dao.deleteUserbyid(id);
				
	    		HttpSession session=req.getSession();
	    		
	    		if (f) {
					session.setAttribute("succMsg", "Student removed Successfully..");
					resp.sendRedirect("index.jsp");
				}else {
					session.setAttribute("succMsg", "Error: Problem in Server Side..");
					resp.sendRedirect("view_jobs.jsp");
				}
	    		
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	
	
	


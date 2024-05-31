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
import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.Faculty;
import com.entity.User;

@WebServlet("/Attendence")
public class AttendenceServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int attendID = Integer.parseInt(req.getParameter("id"));
		String Attend = req.getParameter("Attend");
		String name = req.getParameter("name");
		String Branch = req.getParameter("Branch");
		String course = req.getParameter("course");

		System.out.println(Attend);
		HttpSession session = req.getSession();
		if (Attend != null && !Attend.equals("") ) {
			try {

				UserDao dao = new UserDao(DBConnect.getConn());

				User u = new User(Attend,name,attendID,Branch,course);

				boolean f = dao.addAttendence(u);

				if (f) {
					session.setAttribute("succMsg", "Attendence Successfully..");
					resp.sendRedirect("Attendence.jsp");
				} else {
					session.setAttribute("succMsg", "Error: Problem in Server Side..");
					resp.sendRedirect("Attendence.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			session.setAttribute("succMsg", "Fields required..");
			resp.sendRedirect("Attendence.jsp");
		}

	}
}

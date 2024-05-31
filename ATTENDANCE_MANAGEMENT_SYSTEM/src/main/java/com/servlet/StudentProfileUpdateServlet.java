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
import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.Faculty;
import com.entity.User;

@WebServlet("/update_Student")
public class StudentProfileUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		String name = req.getParameter("name");
		String Location = req.getParameter("Location");
		String Qualification = req.getParameter("Qualification");
		String Branch = req.getParameter("Branch");
		String course = req.getParameter("course");
		String email = req.getParameter("email");
		String description = req.getParameter("description");

		HttpSession session = req.getSession();
		if (name != null && !name.equals("") && Location != null && !Location.equals("") && Qualification != null
				&& !Qualification.equals("") && Branch != null && !Branch.equals("") && course != null
				&& !course.equals("") && email != null && !email.equals("")
				&& description != null && !description.equals("")) {
			try {

				UserDao dao = new UserDao(DBConnect.getConn());

				User u = new User();
				u.setId(id);
				u.setName(name);
				u.setLocation(Location);
				u.setQualification(Qualification);
				u.setBranch(Branch);
				u.setCourse(course);
				u.setEmail(email);
				u.setDescription(description);
				boolean f = dao.updateUser(u);

				if (f) {
					session.setAttribute("succMsg", "profile Updated Successfully");
					resp.sendRedirect("All_Student.jsp");
				} else {
					session.setAttribute("succMsg", "Error: Problem in Server Side..");
					resp.sendRedirect("ChangeUProfile.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			session.setAttribute("succMsg", "Error: All Form filled required");
			resp.sendRedirect("ChangeUProfile.jsp");
		}
	}

}

package main.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/forget")
public class Forgetpassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("new");
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date dob = Date.valueOf(req.getParameter("dob"));

		MyDao dao = new MyDao();
		Doctor d = dao.fetchdoctor(id);
		Staff s = dao.fetchstaff(id);
		if (d != null) {

			if (d.getName().equals(name) && d.getDob().equals(dob) && d.getMobile() == mobile) {
				d.setPassword(password);
				dao.updatedoctor(d);
				resp.getWriter().print("<h1><center> Password Updated Successfully in Doctor account  </h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}

			else {

				resp.getWriter().print("<h1> Invalid details </h1>");
				req.getRequestDispatcher("ForgetPassword.html").include(req, resp);
			}

		} else if (s != null) {

			if (s.getName().equals(name) && s.getDob().equals(dob) && s.getMobile() == mobile) {
				s.setPassword(password);
				dao.updateStaff(s);
				resp.getWriter().print("<h1> Password Updated Successfully in Staff account </h1>");
				req.getRequestDispatcher("Login.html").include(req, resp);
			}

			else {
				resp.getWriter().print("<h1> Invalid details </h1>");
				req.getRequestDispatcher("ForgetPassword.html").include(req, resp);
			}

		} else {
			resp.getWriter().print("<h1> Id does't present in either Doctor or Staff account </h1>");
			req.getRequestDispatcher("ForgetPassword.html").include(req, resp);
		}
	}

}

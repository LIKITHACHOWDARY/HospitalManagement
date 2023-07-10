package main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MyDao;
import dto.Doctor;
import dto.Staff;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

		MyDao dao = new MyDao();
		Doctor doctor = dao.fetchdoctor(id);
		Staff std = dao.fetchstaff(id);
		if (std == null && doctor == null && id != 999999) {
			resp.getWriter().print("<h1 style='color:red'> Incorrect Id</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			if (std != null) {
				if (std.getPassword().equals(password)) {

					if (std.isStatus()) {
						req.getSession().setAttribute("staff", std);
						resp.getWriter().print("<h1 style='color:green'> Login Success</h1>");
						req.getRequestDispatcher("StaffHome.html").include(req, resp);
					} else {
						resp.getWriter().print("<h1 style='color:green'>Wait for Admin Approval</h1>");
						req.getRequestDispatcher("Login.html").include(req, resp);
					}
				} else {
					resp.getWriter().print("<h1 style='color:green'> Incorrect Password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
			}
			if (doctor != null) {
				if (doctor.getPassword().equals(password)) {
					if (doctor.isStatus()) {
						req.getSession().setAttribute("doctor", doctor);
						resp.getWriter().print("<h1 style='color:green'> Login Success</h1>");
						req.getRequestDispatcher("Doctorhome.html").include(req, resp);
					} else {
						resp.getWriter().print("<h1 style='color:green'>Wait for Admin Approval</h1>");
						req.getRequestDispatcher("Login.html").include(req, resp);
					}

				} else {
					resp.getWriter().print("<h1 style='color:green'> Incorrect Password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
			}
			if (id == 999999) {
				if ("999999".equals(password)) {
					req.getSession().setAttribute("admin", "admin");
					resp.getWriter().print("<h1 style='color:green'> Login Success</h1>");
					req.getRequestDispatcher("Adminhome.html").include(req, resp);
				} else {
					resp.getWriter().print("<h1 style='color:green'> Incorrect Password</h1>");
					req.getRequestDispatcher("Login.html").include(req, resp);
				}
			}

		}
	}
}

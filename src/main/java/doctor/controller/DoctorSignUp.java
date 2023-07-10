package doctor.controller;

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

@WebServlet("/doctorsignup")
public class DoctorSignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		Long mobile = Long.parseLong(req.getParameter("mobile"));
		String password = req.getParameter("password");
		String qualification = req.getParameter("qualification");
		String specialization = req.getParameter("specialization");
		String gender = req.getParameter("gender");
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		MyDao std = new MyDao();
		if (std.fetchdoctorbyemaill(email) == null && std.fetchdoctorbymobile(mobile) == null
				&& std.fetchByemail(email) == null && std.fetchByMobile(mobile) == null) {
			Doctor doctor = new Doctor();
			doctor.setEmail(email);

			doctor.setGender(gender);
			doctor.setPassword(password);
			// doctor.setStatus(false);
			doctor.setSpecialization(specialization);
			doctor.setQualification(qualification);
			doctor.setMobile(mobile);
			doctor.setName(name);
			doctor.setDob(dob);
			doctor.setAge(age);

			std.saveDoctor(doctor);

			resp.getWriter().print("<h1> Doctor account created Successfully wait for Admin Approval</h1>");
			resp.getWriter().print("<h1>Your Doctor Id:" + doctor.getId() + "</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1>Doctor mobile and email already Exists</h1>");
			req.getRequestDispatcher("DoctorSignUp.html").include(req, resp);

		}
	}
}
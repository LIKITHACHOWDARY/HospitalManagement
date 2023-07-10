package staff.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MyDao;
import dto.Patient;

@WebServlet("/patient")
@MultipartConfig
public class AddPatient extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		Date dob = Date.valueOf(req.getParameter("dob"));
		int age = Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
		Part picture = req.getPart("picture");
		byte[] image = new byte[picture.getInputStream().available()];
		picture.getInputStream().read(image);

		MyDao dao = new MyDao();
		Patient p1 = dao.fetchpatientbymobile(mobile);

		if (p1 == null) {
			Patient p = new Patient();
			p.setAge(age);
			p.setDob(dob);
			p.setName(name);
			p.setMobile(mobile);
			p.setPicture(image);

			dao.savePatient(p);

			resp.getWriter().print("<h1> Patient details inserted sucessfully</h1>");
			req.getRequestDispatcher("StaffHome.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1> Patient Mobile number is already Exist</h1>");
			req.getRequestDispatcher("StaffHome.html").include(req, resp);
		}

	}
}

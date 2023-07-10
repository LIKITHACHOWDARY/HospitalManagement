package doctor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Doctor;

@WebServlet("/changedoctoravailablity")
public class ChangeDoctorAvailablity extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Doctor doctor = (Doctor) req.getSession().getAttribute("doctor");
		MyDao dao = new MyDao();
		if (doctor == null) {
			resp.getWriter().print("<h1>Session expired</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			if (doctor.isAvailable()) {
				doctor.setAvailable(false);
				dao.updatedoctor(doctor);
				req.getSession().setAttribute("doctor", doctor);
				resp.getWriter().print("<h1> Changed to not Available</h1>");
			} else {
				doctor.setAvailable(true);
				dao.updatedoctor(doctor);
				req.getSession().setAttribute("doctor", doctor);
				resp.getWriter().print("<h1> Changed to  Available</h1>");
			}
		}
	}

}

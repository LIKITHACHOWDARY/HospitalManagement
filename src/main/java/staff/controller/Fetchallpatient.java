package staff.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Patient;

@WebServlet("/fetchallpatient")
public class Fetchallpatient extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute("staff") != null) {
			MyDao dao = new MyDao();
			List<Patient> list = dao.Fetchallpatient();
			if (list.isEmpty()) {
				resp.getWriter().print("<h1 style='color:red'>No Patients present</h1>");
				req.getRequestDispatcher("StaffHome.html").include(req, resp);
			} else {
				req.setAttribute("list", list);
				resp.getWriter().print("<h1> Book Appointment</h1>");
				req.getRequestDispatcher("FetchallPatient.jsp").include(req, resp);
			}
		} else {
			resp.getWriter().print("<h1>Session Expired, Login again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}

	}
}

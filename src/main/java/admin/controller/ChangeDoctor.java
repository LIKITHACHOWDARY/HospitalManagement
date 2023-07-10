package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Doctor;

@WebServlet("/changedoctorstatus")
public class ChangeDoctor extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		MyDao dao = new MyDao();
		Doctor doctor = dao.fetchdoctor(id);
		if (doctor.isStatus()) {
			doctor.setStatus(false);
		} else {
			doctor.setStatus(true);
		}
		dao.updatedoctor(doctor);

		resp.getWriter().print("<h1> updated Sucessfully</h1>");
		req.setAttribute("list", dao.Fetchalldoctor());
		req.getRequestDispatcher("ApproveDoctor.jsp").include(req, resp);
	}
}

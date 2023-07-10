package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Doctor;

@WebServlet("/adminfetchalldoctor")
public class FetchallDoctor extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("admin") != null) {
			MyDao dao = new MyDao();
			List<Doctor> list = dao.Fetchalldoctor();
			if (list.isEmpty()) {
				resp.getWriter().print("<h1 style='color:red'>No Doctors present</h1>");
				req.getRequestDispatcher("Adminhome.html").include(req, resp);
			} else {
				req.setAttribute("list", list);
				req.getRequestDispatcher("ApproveDoctor.jsp").include(req, resp);
			}
		} else {
			resp.getWriter().print("<h1>Session Expired, Login again</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		}
	}
}

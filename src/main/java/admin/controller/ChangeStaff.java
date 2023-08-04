package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.Staff;

@WebServlet("/changestaffstatus")
public class ChangeStaff extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		MyDao dao = new MyDao();
		Staff staff = dao.fetchstaff(id);
		if (staff.isStatus()) {
			staff.setStatus(false);
		} else {
			staff.setStatus(true);
		}
		dao.updateStaff(staff);

		resp.getWriter().print("<h1  style='margin-left: 470px; margin-top: 150px; color:green'> updated Sucessfully</h1>");
		req.setAttribute("list", dao.Fetchallstaff());
		req.getRequestDispatcher("Approvestaff.jsp").include(req, resp);
	}

}

package staff.controller;

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
import dto.Staff;

@WebServlet("/staff")
public class StaffSignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Date date = Date.valueOf(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		// String spec=req.getParameter("specialization");
		long mobile = Long.parseLong(req.getParameter("mobile"));
		int age = Period.between(date.toLocalDate(), LocalDate.now()).getYears();
		MyDao stafdao = new MyDao();

		if (stafdao.fetchByMobile(mobile) == null && stafdao.fetchByemail(email) == null) {
			Staff staff = new Staff();
			staff.setDob(date);
			;
			staff.setEmail(email);
			staff.setName(name);
			staff.setPassword(password);
			staff.setMobile(mobile);
			staff.setAge(age);
			staff.setGender(gender);

			stafdao.saveStaff(staff);
			resp.getWriter().print("<h1>Staff Id  Is Created Successfully wait for Admin Approval</h1>");
			resp.getWriter().print("<h1>Your Staff Id is:" + staff.getId() + "</h1>");
			req.getRequestDispatcher("Login.html").include(req, resp);
		} else {
			resp.getWriter().print("<h1>Mobile Number or email already exists </h1>");
			req.getRequestDispatcher("StaffSignUp.html").include(req, resp);
		}

		// StaffSignupdao stafdao=new StaffSignupdao();

	}
}
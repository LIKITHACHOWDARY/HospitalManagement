<%@page import="dao.MyDao"%>
<%@page import="dto.Staff"%>
<%@page import="dto.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="dto.Staff"%>
<%@page import="dto.Patient"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment Form</title>
</head>
<body>
<div style="margin-left: 350px;margin-top: 150px;">
<h1>Appoint Form</h1>
	<%
		Staff staff = (Staff) session.getAttribute("staff");
		int id = Integer.parseInt(request.getParameter("id"));
		MyDao dao = new MyDao();
		Patient patient = dao.fetchpatient(id);
		if (patient != null) {
			List<Doctor> list = dao.fetchAvailableDoctor();
			if (list.isEmpty()) {
				response.getWriter().print("<h1> No Doctors are Available</h1>");
				request.getRequestDispatcher("StaffHome.html").include(request, response);
			} else {
	%>

	<form action="bookappointment" method="post">
		<tabel>
		<tr>
			<td><label for="name">Patient id</label></td>
			<td><input id="name" type="text" name="pid" value="<%=id%>"
				readonly="readonly"></td>
			<br>
			<br>
		</tr>
		<tr>
			<td><label for="patientname">Patient Name</label></td>
			<td><input id="patientname" type="text" name="patientname"
				value="<%=patient.getName()%>" readonly="readonly"></td>
			<br>
			<br>
		</tr>
		<tr>
			<td><label for="staffname">Staff Name</label></td>
			<td><input id="staffname" type="text" name="staffname"
				value="<%=staff.getName()%>"></td>
			<br>
			<br>
		</tr>
		<tr>
			<td><label for="patient">Problem</label></td>
			<td><input id="patient" type="text" name="problem"></td>
			<br>
			<br>
		</tr>
		<tr>
			<td><label for="sd">Select Doctor</label></td>
			<td><select name="Doctor" id="sd">
					<%
						for (Doctor doctor : list) {
					%>
					<option value="<%=doctor.getId()%>"><%=doctor.getId()%>(<%=doctor.getSpecialization()%>)
						<%
						}
					%>
					
			</select></td>
			<br>
			<br>
		</tr>
		<tr>
			<td><button type="reset">Cancel</button></td>
			<td><button>Fix Appointment</button>
		</tabel>
		<br><br>
		<a href="Appointment.jsp"><button>Back</button></a>
	</form>

	<%
		}
		} else {
			response.getWriter().print("<h1> Enter correct ID</h1>");
			request.getRequestDispatcher("BookappointmentbyID.html").include(request, response);
		}
	%>

</div>
</body>
</html>
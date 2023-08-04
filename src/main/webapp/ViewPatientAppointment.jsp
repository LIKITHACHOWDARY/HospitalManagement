<%@page import="dao.MyDao"%>
<%@page import="dto.Staff"%>
<%@page import="dto.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="dto.Patient"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="margin-top: 200px">

	<%
		int pid = Integer.parseInt(request.getParameter("id"));
		MyDao dao = new MyDao();
		Patient patient = dao.fetchpatient(pid);
		List<Appointment> list = patient.getAppointments();
		if (list.isEmpty()) {
			response.getWriter().print("<h1 style='color:red' align='center'>No Apppoinments Yet</h1>");
			request.setAttribute("list", dao.Fetchallpatient());
			request.getRequestDispatcher("ViewPatientHistory.jsp").include(request, response);
		} else {
	%>

	<h1>Appointment Details</h1>
	<table border='1'>
		<tr>

			<th>Appointment ID</th>
			<th>Patient Name</th>
			<th>Problem</th>
			<th>Doctor</th>
			<th>Appointment Date</th>

		</tr>
		<tr>
			<%
				for (Appointment std : list) {
			%>
			<td><%=std.getId()%></td>
			<td><%=std.getPatient().getName()%></td>
			<td><%=std.getProblem()%></td>
			<td><%=std.getDoctor().getName()%></td>
			<td>
				<%
					if (std.getTime() == null) {
				%> Not Yet Visited Doctor <%
					} else {
				%> <%=std.getTime()%>
				<%
					}
				%>
			</td>
		</tr>
		<%
			}
		%>

	</table>
	<br>
	<a href="adminfetchallpatients"><button style="border-radius: 50px; margin-left: -530px;">Back</button></a>
	<%
		}
	%>
	</div>
</body>
</html>
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
	<h2>Booking Appointment</h2>
	<%
		if (session.getAttribute("staff") == null) {
			response.getWriter().print("<h1> Session expired</h1>");
			request.getRequestDispatcher("Login.html").include(request, response);
		} else {
	%>
	<a href="fetchallpatient"><button>View All Patient</button></a>
	<br>
	<br>
	<a href="BookappointmentbyID.html"><button>Fetch Patient By Id</button></a>
	<br>
	<br>
	<%
		}
	%>
	<a href="StaffHome.html"><button>Back</button></a>
	</div>
	
</body>
</html>
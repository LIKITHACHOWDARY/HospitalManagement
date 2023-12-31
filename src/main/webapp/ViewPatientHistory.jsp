<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dto.Patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="margin-top: 50px;">
	<h2>Patient Details</h2>
<%
		List<Patient> list = (List<Patient>) request.getAttribute("list");
%> 
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Age</th>
			<th>Picture</th>
			<th>View Previous Appointments</th>
		</tr>
		<%
			for (Patient patient : list) {
		%>
		<tr>
			<th><%=patient.getId()%></th>
			<th><%=patient.getName()%></th>
			<th><%=patient.getMobile()%></th>
			<th><%=patient.getAge()%></th>
			<th>
			<%
			String base64=Base64.encodeBase64String(patient.getPicture());
			%>
			<img height="50px" width="50px" alt="unknown" src="data:image/jpeg;base64,<%=base64%>">
			</th>
			<th><a href="ViewPatientAppointment.jsp?id=<%=patient.getId()%>"><button style="border-radius: 50px">Click</button></a></th>
		</tr>
		<%
			}
		%>
	</table><br><br>
	<a href="Adminhome.html"><button style="border-radius: 50px; margin-left: -480px;">Back</button></a>
	</div>
</body>
</html>
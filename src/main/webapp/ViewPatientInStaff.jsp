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
<div style="margin-left: 350px;">
	<h2>Patient Details</h2>
	<%
		List<Patient> list = (List<Patient>) request.getAttribute("list");
	%>
	<div>
		<table border='1'>
			<tr>

				<th>PID</th>
				<th>PName</th>
				<th>PAge</th>
				<th>Mobile</th>
				<th>PImage</th>
			</tr>
			<%
				for (Patient patient : list) {
			%>
			<tr>
				<td><%=patient.getId()%></td>
				<td><%=patient.getName()%></td>
				<td><%=patient.getAge()%></td>
				<td><%=patient.getMobile()%></td>
				<td>
					<%
						String base64 = Base64.encodeBase64String(patient.getPicture());
					%> <img height="50" width="50" alt="unknown"
					src="data:image/jpeg;base64,<%=base64%>">

				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<br>
	<a href="StaffHome.html"><button>Back</button></a>
	</div>
</body>
</html>
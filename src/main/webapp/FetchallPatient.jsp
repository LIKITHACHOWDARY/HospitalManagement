<%@page import="org.apache.commons.codec.binary.Base64"%>

<%@page import="java.util.Arrays"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxDatatypes.Array"%>
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

	<%
		List<Patient> list = (List<Patient>) request.getAttribute("list");
	%>
	<div>
		<table border='1'>
			<tr>
				<th>PID</th>
				<th>PName</th>
				<th>Mobile</th>
				<th>Age</th>
				<th>PImage</th>
				<th>Book</th>
			</tr>
			<%
				for (Patient patient : list) {
			%>
			<tr>
				<td><%=patient.getId()%></td>
				<td><%=patient.getName()%></td>
				<td><%=patient.getMobile()%></td>
				<td><%=patient.getAge()%></td>
				<td>
					<%
						String base64 = Base64.encodeBase64String(patient.getPicture());
					%>

					<img height="50" width="50" alt="unknown"
					src="data:image/jpeg;base64,<%=base64%>">
				</td>
				<td><a href="BookbyID.jsp?id=<%=patient.getId()%>"><button>Book</button></a></td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<a href="Appointment.jsp"><button>Back</button></a>
	</div>
</body>
</html>
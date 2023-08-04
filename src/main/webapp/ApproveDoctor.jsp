<%@page import="java.util.List"%>
<%@page import="dto.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center"  >
	<h2>Doctor Details</h2>
	<%
		List<Doctor> list = (List<Doctor>) request.getAttribute("list");
	%>
	<div>
		<table border='1'>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Age</th>
				<th>specialization</th>
				<th>Status</th>
				<th>Change Status</th>
			</tr>
			<%
				for (Doctor doctor : list) {
			%>
			<tr>
				<td><%=doctor.getId()%></td>
				<td><%=doctor.getName()%></td>
				<td><%=doctor.getMobile()%></td>
				<td><%=doctor.getAge()%></td>
				<td><%=doctor.getSpecialization()%></td>
				<td><%=doctor.isStatus()%></td>
				<td><a href="changedoctorstatus?id=<%=doctor.getId()%>"><button style="border-radius: 50px;">Change</button></a></td>
			</tr>
			<%
				}
			%>
		</table>
		<br> <a href="Adminhome.html"><button style="border-radius: 50px;margin-left: -500px;">Back</button></a>

	</div>
	</div>
</body>
</html>
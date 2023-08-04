<%@page import="dto.Staff"%>
<%@page import="java.util.List"%>
<%@page import="dto.Staff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="margin-left: 500px; ">Staff Details</h1>
	<%
		List<Staff> list = (List<Staff>) request.getAttribute("list");
	%>
	<div>
		<table border='1' style="margin-left: 430px; ">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Age</th>
				<th>Status</th>
				<th>Change Status</th>
			</tr>
			<%
				for (Staff std : list) {
			%>
			<tr>
				<td><%=std.getId()%></td>
				<td><%=std.getName()%></td>
				<td><%=std.getMobile()%></td>
				<td><%=std.getAge()%></td>
				<td><%=std.isStatus()%></td>
				<td><a href="changestaffstatus?id=<%=std.getId()%>"><img alt="change" src="changestatus.jpg" height="50px" width="50px" ></a></td>
			</tr>
			<%
				}
			%>
		</table>
		<br> <a href="Adminhome.html"><img alt="Back" src="Back.jpg" height="50px" width="50px" style="margin-left: 430px;"></a>

	</div>
</body>
</html>
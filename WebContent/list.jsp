<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body>
	<h2>
		<%
			String name = (String) session.getAttribute("NAME");
			if (name != null) {
				out.print("Welcome " + name);
			}
		%>
	</h2>
	<c:if test="${not empty usersList}">
		<h1>List of Users</h1>
		<table border=1>
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Email Id</td>
					<td>Status</td>
					<td><center>Action</center></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${usersList}">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.emailId}</td>
						<td>${user.active}</td>
						<td><a href="EditServlet?id=${user.id}">edit</a> <a
							href="DeleteServlet?id=${user.id}">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<h2>
		<%
			String message = (String) request.getAttribute("MESSAGE");
			if (message != null) {
				out.print(message);
			}
		%>
	</h2>
	<a href="register.html">Add User</a>
	<br>
	<a href="LogoutServlet">Logout</a>
</body>
</html>
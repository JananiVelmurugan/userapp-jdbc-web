<%@page import="com.userapp.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>

	<form action="UpdateServlet" method="post">
		<h1>Edit User</h1>
		<h3>
			Id<input type="text" name="id" value=${USER.id } readonly /><br>
			Name <input type="text" name="name" value=${USER.name } required
				autofocus> <br>Email Id<input type="email"
				name="email_id" value=${USER.emailId } required> <br>Password<input
				type="password" name="password" value=${USER.password }><br>
			Active<input type="text" name="active" value=${USER.active }><br>
			<button type="submit">Update</button>
		</h3>
	</form>
</body>
</html>
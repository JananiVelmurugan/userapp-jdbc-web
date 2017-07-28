<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>

<body>
	<h1>Welcome to User Management System</h1>
	<h2>
		<% String message = (String) request.getAttribute("MESSAGE");
		if (message != null) { out.print(message); } %>
	</h2>
	<h3>
		<a href="register.html">Register</a> <br> <a href="login.jsp">Login</a>
		<br>
	</h3>
</body>
</html>
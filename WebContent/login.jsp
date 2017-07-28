<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>
		<%
			String message = (String) request.getAttribute("MESSAGE");
			if (message != null) {
				out.print(message);
			}
		%>
	</h2>
	<form action="LoginServlet" method="post">
		<h1>Login Form</h1>
		<h3>
			Email Id<input type="email" name="email_id" value="admin@gmail.com"
				required autofocus><br> Password<input type="password"
				name="password" value="admin"><br>
			<button type="submit">Login</button>
		</h3>
	</form>
	<br>
	<a href="index.jsp">Home</a>
</body>
</html>
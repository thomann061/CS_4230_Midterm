<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Application Login</title>
</head>
<body>
<form action="Login" method="post">
	<label for="username">User Name:</label>
	<input type="text" name="username" /><br />
	<label for="password">Password:</label>
	<input type="password" name="password" /><br />
	
	<input type="submit" value="Login" /><br />
	<a href="register.jsp">Sign up</a>
</form>
</body>
</html>
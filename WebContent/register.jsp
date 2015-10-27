<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Movie Registration</title>
</head>
<body>
<form action="register" method="post">
	<label for="username">User Name:</label>
	<input type="text" name="username" />
	<label for="password">Password:</label>
	<input type="password" name="password" /><br />
	
	<label for="firstName">First Name:</label>
	<input type="text" name="firstName" />
	<label for="lastName">Last Name:</label>
	<input type="text" name="lastName" /><br />
	
	<input type="submit" value="Register" />
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the user interface</h1>
	<hr>
	<div>
		<form action="adminlogin", method="post">
		<input type="text" placeholder="admin" name="admin">
		<br>
		<input type="password" placeholder="789388" name="pass">
		<br>
		<input type="checkbox" required> I Am not robot
		<br>
		<input type="submit" value="Login">
		</form>
	</div>

</body>
</html>
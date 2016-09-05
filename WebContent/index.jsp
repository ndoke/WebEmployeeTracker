<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to employee portal</title>
</head>
<body>
	<h1>Employee Portal</h1>
	<hr>
	<form action="EmployeeDisplayServlet" method="get">
		View Employee List <input type="submit" value="Go">
	</form>
	<br />

	<form action="employee-add.jsp">
		Add an Employee <input type="submit" value="Go">
	</form>
</body>
</html>
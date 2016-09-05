<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add an employee</title>
</head>
<body>
	<h2>Enter employee details</h2>
	<form action="EmployeeAddServlet" method="get">
		Enter name: <input type="text" name="name"> <br /> <br />
		Enter age: <input type="text" name="age"> <br /> <br />
		Enter salary: <input type="text" name="salary"> <br /> <br />
		<input type="submit" value="Add employee">
	</form>
</body>
</html>
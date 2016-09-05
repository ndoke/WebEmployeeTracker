<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
	<h2>Update employee details</h2>
	<form action="EmployeeUpdateServlet" method="post">
		<input type="hidden" value="${the_employee.eid}" name="eid" />
		Enter name: <input type="text" name="name" value="${the_employee.name}">
		<br /> <br />
		Enter age: <input type="text" name="age" value="${the_employee.age}">
		<br /> <br />
		Enter salary: <input type="text" name="salary" value="${the_employee.salary}">
		<br /> <br />
		<input type="submit" value="Update">
	</form>
</body>
</html>
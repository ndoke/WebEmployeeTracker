<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<h2>Employees</h2>
	<form action="EmployeeDisplayServlet" method="get">
		<table border="1px">
			<c:forEach var="tempEmployee" items="${employee_list}">
				<c:url var="updateLink" value="EmployeeUpdateServlet">
					<c:param name="command" value="LOAD" />
					<c:param name="empID" value="${tempEmployee.eid}" />
				</c:url>
				<c:url var="deleteLink" value="EmployeeDeleteServlet">
					<c:param name="command" value="LOAD" />
					<c:param name="empID" value="${tempEmployee.eid}" />
				</c:url>
				<tr>
					<td>${tempEmployee.eid}</td>
					<td>${tempEmployee.name}</td>
					<td>${tempEmployee.age}</td>
					<td>${tempEmployee.salary}</td>
					<td><a href="${updateLink}">Update</a></td>
					<td><a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delete this record?'))) return false;">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<br />
	<a href="index.jsp">Back to main page</a>
</body>
</html>
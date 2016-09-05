package com.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeDisplayServlet")
public class EmployeeDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDisplayDAO employeeDisplayDAO;

	public EmployeeDisplayServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// creating employeedisplay object
		employeeDisplayDAO = new EmployeeDisplayDAO();
		
		// extracting data
		List<Employee> employee = employeeDisplayDAO.getEmployeeDBUtil();
		
		// sending the list to the jsp page
		request.setAttribute("employee_list", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-display.jsp");
		dispatcher.forward(request, response);
	}

}

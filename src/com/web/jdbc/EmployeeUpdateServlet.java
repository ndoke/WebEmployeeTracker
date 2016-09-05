package com.web.jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeUpdateDAO employeeUpdateDAO;

	public EmployeeUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String theCommand = request.getParameter("command");
		if (theCommand.equals("LOAD")) {
			// read employee id
			String empID = request.getParameter("empID");

			// getting employee from database
			employeeUpdateDAO = new EmployeeUpdateDAO();
			Employee theEmployee = employeeUpdateDAO.getEmployee(Integer.parseInt(empID));

			// place that employee in a request attribute
			request.setAttribute("the_employee", theEmployee);

			// send the employee to jsp page
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee-update.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// read employee details
		int empID = Integer.parseInt(request.getParameter("eid"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		double salary = Double.parseDouble(request.getParameter("salary"));

		// save the updated record to database
		employeeUpdateDAO = new EmployeeUpdateDAO();
		employeeUpdateDAO.setEmployeeDBUtil(empID, name, age, salary);

		// display success message
		request.setAttribute("success_message", "Employee details successfully saved!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-update-success.jsp");
		dispatcher.forward(request, response);
	}

}

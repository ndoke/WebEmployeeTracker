package com.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDeleteDAO employeeDeleteDAO;
	private EmployeeDisplayDAO employeeDisplayDAO;

	public EmployeeDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String theCommand = request.getParameter("command");
		if (theCommand.equals("LOAD")) {
			// read employee id
			String empID = request.getParameter("empID");

			// deleting employee from database
			employeeDeleteDAO = new EmployeeDeleteDAO();
			employeeDeleteDAO.deleteEmployee(Integer.parseInt(empID));

			// delete success jsp page
			employeeDisplayDAO = new EmployeeDisplayDAO();

			// create a new updated list
			List<Employee> employee = employeeDisplayDAO.getEmployeeDBUtil();

			// send it to the display page
			request.setAttribute("employee_list", employee);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee-display.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

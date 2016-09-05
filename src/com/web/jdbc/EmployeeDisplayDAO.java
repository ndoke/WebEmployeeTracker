package com.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDisplayDAO {

	public List<Employee> getEmployeeDBUtil() {

		List<Employee> list = new ArrayList<Employee>();
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "@Godfather01");

			String sql = "select * from empdata.employee";
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();

			while (myRs.next()) {
				int id = myRs.getInt("eid");
				String name = myRs.getString("name");
				int age = myRs.getInt("age");
				double salary = myRs.getDouble("salary");

				Employee emp = new Employee(id, name, age, salary);
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

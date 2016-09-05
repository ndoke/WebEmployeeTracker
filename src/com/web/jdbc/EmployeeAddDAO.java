package com.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeAddDAO {

	public void setEmployeeDBUtil(String name, int age, double salary) {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "@Godfather01");

			String sqlSize = "SELECT MAX(eid) FROM empdata.employee;";
			myStmt = myConn.prepareStatement(sqlSize);
			myRs = myStmt.executeQuery();

			if (Employee.size == 0) {
				while (myRs.next())
					Employee.size = myRs.getInt(1);
			}

			String sql = "INSERT INTO empdata.employee VALUES (" + ++Employee.size + ",'" + name + "', '" + age + "', '"
					+ salary + "')";
			myStmt = myConn.prepareStatement(sql);
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

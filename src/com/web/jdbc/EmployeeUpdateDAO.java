package com.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeUpdateDAO {

	public Employee getEmployee(int eid) {
		Employee emp = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "@Godfather01");

			String sql = "SELECT * FROM empdata.employee WHERE eid = " + eid + ";";
			myStmt = myConn.prepareStatement(sql);
			myRs = myStmt.executeQuery();

			while (myRs.next()) {
				int id = myRs.getInt("eid");
				String name = myRs.getString("name");
				int age = myRs.getInt("age");
				double salary = myRs.getDouble("salary");
				emp = new Employee(id, name, age, salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	public void setEmployeeDBUtil(int empID, String name, int age, double salary) {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "@Godfather01");

			String sql = "UPDATE empdata.employee SET name= ?, age=?, salary=? WHERE eid=?;";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, name);
			myStmt.setInt(2, age);
			myStmt.setDouble(3, salary);
			myStmt.setInt(4, empID);
			myStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package za.co.register.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {


	static String url = "jdbc:mysql://localhost:3306/unisa_db";
	static String username = "root";
	static String password = "pvi@2021";

	public static Connection getConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static ResultSet getResultSet(String sqlQuery) throws SQLException{
		Statement statement = null;
		Connection con = getConnection();
		try {
			statement = con.createStatement();
		}catch (Exception e) {
			e.printStackTrace();
		}
		ResultSet resultset = statement.executeQuery(sqlQuery);
		return resultset;
	}

	public static int executeQuery(String sqlQuery) throws SQLException {
		Statement stmt = null;
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
		int affectedRows = stmt.executeUpdate(sqlQuery);

		return affectedRows;
	}
	public String insert(String studentQuery) {
		//connectDriver(dbDriver);
		//Connection conn =DriverManager.getConnection(studentQuery);
		String result = "Student Successfully Registered !";

		try {
			Connection conn =DriverManager.getConnection(studentQuery);
			Statement stmt = conn.createStatement();
			
			stmt.execute(studentQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			result = "Data not entered";
		}

		return result;

	}
}

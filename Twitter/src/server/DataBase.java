package server;

import java.sql.*;

public class DataBase {
	private Connection connection;
	private Statement statement;
	public DataBase() throws Exception {
		String user = "mysql";
		String password="prac";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection=DriverManager.getConnection("jdbc:mysql://localhost/twitter?user="+user+"&password="+password);
		statement=connection.createStatement();
	}
	public ResultSet executeSQL(String query) throws SQLException{
		return statement.executeQuery(query);
	}
	public void disconnectBD() throws SQLException{
		statement.close();
		connection.close();
	}
}

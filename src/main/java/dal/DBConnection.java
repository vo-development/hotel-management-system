package dal;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {	
	
	private static Connection connection = null;

	private static String URL = "jdbc:mysql://localhost:3306/hms_db";
	private static String USER_NAME = "root";
	private static String PASSWORD = "1234";


	public static Connection getConnection() {

		if (connection == null) {

			try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection= DriverManager.getConnection(URL,USER_NAME,PASSWORD);

			}catch(ClassNotFoundException e ) {
				System.out.println("Class Not Found");
			}catch(SQLException e ) {
				System.out.println("Cannot connecting");;
			}

		}
		return connection;
		
			
	}
				
			public static void closeConnection() throws SQLException{
				
			if (connection != null && !connection.isClosed()) 
				connection.close();
			
		
	}
}


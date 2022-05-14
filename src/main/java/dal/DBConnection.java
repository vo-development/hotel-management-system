package dal;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {	
	
	private static Connection connection = null;
	
	public static Connection getConnection() {

		if (connection == null) {

			try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hms_db","root","1234");
			
			
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


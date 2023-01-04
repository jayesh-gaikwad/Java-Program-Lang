package in.ineuron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	private  JDBCUtil()
	{
		
	}
	
	//Using Method to establish connection getJDBCConnection() of connection type making 
	//as a static type so need to create object 
	public static Connection getJDBCConnection() throws SQLException {
		//Establish the connection
		Connection connection=null;
		
		//Using resources
		String url="jdbc:mysql://localhost:3306/enterprisejavawithspringboot";
		String user="root";
		String password="cdac";
		
		connection=DriverManager.getConnection( url, user, password);
		
		if(connection!=null)
			return connection;
		
		return connection;
	}
	
	//Using a Method for close connection name as closeConnection(object,object,object) of void type making 
	//as a static type so need to create object
	public static void closeConnection(ResultSet resultSet,Statement statement,
			Connection connection) throws SQLException{
		
		//Closing the resources which are used
		if(resultSet!=null)
		{
			resultSet.close();
		}
		
		if(statement!=null)
		{
			statement.close();
		}
		
		if(connection!=null)
		{
			connection.close();
		}
	}
	
	

	
	
}

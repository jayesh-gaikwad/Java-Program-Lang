package in.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateApp {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		Statement statement=null;
		
		String url="jdbc:mysql://localhost:3306/enterprisejavawithspringboot";
		String user="root";
		String password="cdac";
		
		try {
			
			connection=DriverManager.getConnection(url, user, password);
			
			if(connection!=null)
			{
				statement = connection.createStatement();
			}
			if(statement!=null)
			{
				String updateQuery="update student set sage=25 where sid=47";
				int noOfRowsUpdated=statement.executeUpdate(updateQuery);
				System.out.println("No of rows updated is:"+noOfRowsUpdated);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
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

}

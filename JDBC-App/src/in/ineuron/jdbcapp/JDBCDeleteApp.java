package in.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDeleteApp {

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
				String deleteQuery="delete from student where sid=56";
				int noOfRowsDeleted=statement.executeUpdate(deleteQuery);
				System.out.println("No of rows deleted is:"+noOfRowsDeleted);
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
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

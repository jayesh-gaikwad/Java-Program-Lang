package in.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertApp {

	public static void main(String[] args) throws SQLException {
		
		//Initialize With null
		Connection connection=null;
		Statement statement=null;
		
		//1.Establish the Connection
		String url="jdbc:mysql://localhost:3306/enterprisejavawithspringboot";
		String user="root";
		String password="cdac";
		
		try {
			connection=DriverManager.getConnection(url, user, password);
			if(connection!=null)
			{
				//2.Create statement object
				statement=connection.createStatement();
			}
			if(statement!=null)
			{
				//3.Execute the query.
				String insertSQLQuery="insert into student (`sname`,`sage`,`saddr`)values('nitin','29','RCB')";
				int noOfRows=statement.executeUpdate(insertSQLQuery);
				System.out.println("No of rows affcted is:"+noOfRows);
			}
			
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			
			//4.Closing the connection
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

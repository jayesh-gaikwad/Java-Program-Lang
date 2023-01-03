package in.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCAppIndustrialStandardWay {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		//2.Establish the connection.
		String url="jdbc:mysql://localhost:3306/enterprisejavawithspringboot";
		String user="root";
		String password="cdac";
		try
		{
			connection=DriverManager.getConnection(url, user, password);
			
			if(connection!=null)
			{
				//3.Creation statement object 
				statement=connection.createStatement();
			}
			if(statement!=null)
			{
				String sqlExecuteQuery="select sid,sname,sage,saddr from student";
				
				resultSet=statement.executeQuery(sqlExecuteQuery);
			}
			if(resultSet!=null)
			{
				System.out.println("SID\tSNAME\tSAGE\tSADDR");
				System.out.println();
				while(resultSet.next())
				{
					int sid=resultSet.getInt("sid");
					String sname=resultSet.getString("sname");
					int sage=resultSet.getInt("sage");
					String saddr=resultSet.getString("saddr");
					System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddr);
				}
				
			}
		}catch(SQLException se)
		{
			se.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
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

}

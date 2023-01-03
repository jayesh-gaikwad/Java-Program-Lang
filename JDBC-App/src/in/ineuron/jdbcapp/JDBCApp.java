package in.ineuron.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCApp {

	public static void main(String[] args) throws SQLException {
		
		//1.Load and register driver.
		Driver driver=new Driver(); //From Third Party DB Vendor 
		DriverManager.registerDriver(driver);
		
		//2. Establish the connection.
		String url="jdbc:mysql://localhost:3306/enterprisejavawithspringboot";
		String user="root";
		String password="cdac";
		Connection connection=DriverManager.getConnection(url, user, password);
		
		//3.Create statement object.
		Statement statement=connection.createStatement();
		
		//4.Using statement object to execute query.
		String sqlQuery="select sid,sname,sage,saddr from student";
		ResultSet resultSet=statement.executeQuery(sqlQuery);
		
		//5.Process the result set to get data.
		System.out.println("SID\tSNAME\tSAGE\tSADDR");
		while(resultSet.next())
		{
			int sid=resultSet.getInt("sid");
			String sname=resultSet.getString("sname");
			int sage=resultSet.getInt("sage");
			String saddr=resultSet.getString("saddr");
			System.out.println(sid +"\t"+ sname+"\t"+ sage+"\t"+ saddr);
		}
		
		//6.Closing the connection
		resultSet.close();
		statement.close();
		connection.close();
	}

}

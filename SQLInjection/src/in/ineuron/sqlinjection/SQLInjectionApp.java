package in.ineuron.sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjectionApp {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "cdac");
		
		Statement statement=connection.createStatement();
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the username:");
		String uname=scanner.next();

		System.out.println("Enter the password:");
		String password =scanner.next();
		
		uname="'"+uname+"'";
		password="'"+password+"'";
		
		String sqlSelectQuery="select count(*) from users where username="+uname+" and pwd="+password+"";
		
		ResultSet resultSet=statement.executeQuery(sqlSelectQuery);
	
		int count=0;
		if(resultSet.next())
		{
			count=resultSet.getInt(1);
		}
		if(count==1)
		{
			System.out.println("Valid Credentials");
		}else
		{
			System.out.println("Invalid credentials");
		}
		
		scanner.close();
		resultSet.close();
		statement.close();
		connection.close();
	}

}

/*
Enter the username:
virat
Enter the password:
kohli
Valid Credentials
*/

/*
Enter the username:
virat'--
Enter the password:
kohli
Valid Credentials
*/

package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//JDBC4.X autoloading feature is enabled.
public class InsertAppDynamic {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step2. Establish the Connection
		String url="jdbc:mysql://localhost:3306/enterprisejavawithspringboot";
		String user="root";
		String password="cdac";
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println("CONNECTION object created...");

		// Step3. Create statement Object and send the Query
		Statement statement = connection.createStatement();
		System.out.println("STATEMENT object created...");
		
		Scanner scan=null;
		
		
		scan=new Scanner(System.in);
		
		System.out.println("Enter the student name:");
		String sname=scan.next();
		
		System.out.println("Enter the student age:");
		int sage=scan.nextInt();
		
		System.out.println("Enter the student address:");
		String saddr=scan.next();
		
		// Step4. Execute the Query and Process the resultSet
		String sqlSelectQuery = String.format("insert into student(`sname`,`sage`,`saddr`) values('%s',%d,'%s')",sname,sage,saddr);
		int noOfRowsUpdted = statement.executeUpdate(sqlSelectQuery);
		System.out.println("No of rows updated are:"+noOfRowsUpdted);
		System.out.println("RESULTSET object created...");

		// Step6. Close the resources
		statement.close();
		connection.close();
		System.out.println("Closing the resources...");

	}
}

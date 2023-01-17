package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC4.X autoloading feature is enabled.
public class DeleteApp {

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

		// Step4. Execute the Query and Process the resultSet
		String sqlSelectQuery = "delete from student where sid=57";
		int noOfRowsUpdted = statement.executeUpdate(sqlSelectQuery);
		System.out.println("No of rows updated are:"+noOfRowsUpdted);
		System.out.println("RESULTSET object created...");

		// Step6. Close the resources
		statement.close();
		connection.close();
		System.out.println("Closing the resources...");

	}
}

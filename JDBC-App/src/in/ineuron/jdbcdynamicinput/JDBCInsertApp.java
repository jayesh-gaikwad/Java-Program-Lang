package in.ineuron.jdbcdynamicinput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsertApp {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		Statement statement=null;
		Scanner scan=null;
		
		String url="jdbc:mysql://localhost:3306/enterprisejavawithspringboot";
		String user="root";
		String password="cdac";
		
		scan=new Scanner(System.in);
		
		System.out.println("Enter the name:");
		String sname=scan.next();
		
		System.out.println("Enter the age:");
		int sage=scan.nextInt();
			
		System.out.println("Enter the address:");
		String saddr=scan.next();
		
		sname =" ' "+sname+" ' ";
		saddr =" ' "+saddr+" ' ";
		
		try {
			connection=DriverManager.getConnection(url,user,password);
			if(connection!=null)
			{
				statement=connection.createStatement();
			}
			if(statement!=null)
			{
				String insertSQLQuery="insert into student(`sname`,`sage`,`saddr`) "
						+ "values ("+sname+","+sage+","+saddr+")";
				System.out.println(insertSQLQuery);
				int noOfRowsInserted=statement.executeUpdate(insertSQLQuery);
				System.out.println("No of rows inserted are:"+noOfRowsInserted);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(statement!=null)
			{
				statement.close();
			}
			if(connection!=null)
			{
				connection.close();
			}
			if(scan!=null)
			{
				scan.close();
			}
		}
	}
}

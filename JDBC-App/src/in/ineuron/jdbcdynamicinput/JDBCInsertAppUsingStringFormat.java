package in.ineuron.jdbcdynamicinput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCInsertAppUsingStringFormat {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		Statement statement=null;
		Scanner scanner=null;
		
		String url="jdbc:mysql://localhost:3306/enterprisejavawithspringboot";;
		String user="root";
		String password="cdac";
		
		scanner=new Scanner(System.in);
		
		System.out.println("Enter the name:");
		String sname=scanner.next();
		
		System.out.println("Enter the age:");
		int sage=scanner.nextInt();
		
		System.out.println("Enter the address:");
		String saddr=scanner.next();
		
		
		try {
			connection=DriverManager.getConnection(url, user, password);
			if(connection!=null)
			{
				statement=connection.createStatement();
			}
			if(statement!=null)
			{	
				//%d ->integer %s->String %f->float
				//Syntax of string format ->String.format(query,object)
				String insertSQLQuery=String.format("insert into student(`sname`,`sage`,`saddr`) "
						+ "values('%s','%d','%s')",sname,sage,saddr);
				System.out.println(insertSQLQuery);
				int noOfRowsUpdated=statement.executeUpdate(insertSQLQuery);
				System.out.println("No of rows inserted are:"+noOfRowsUpdated);
			}
			
		} catch (SQLException se) {
			
			se.printStackTrace();
		} catch (Exception e) {
			
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
			if(scanner!=null)
			{
				scanner.close();
			}
		}
	}
}

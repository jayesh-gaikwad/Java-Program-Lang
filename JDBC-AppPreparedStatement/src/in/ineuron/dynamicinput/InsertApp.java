package in.ineuron.dynamicinput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JDBCUtil;


public class InsertApp {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		Scanner scanner=null;
		
		//To get the input from user
		scanner=new Scanner(System.in);
		
		System.out.println("Enter the sname:");
		String sname=scanner.next();
		
		System.out.println("Enter the sage:");
		int sage=scanner.nextInt();
		
		System.out.println("Enter the saddress:");
		String saddr=scanner.next();
		
		String insertSQLQuery="insert into student(`sname`,`sage`,`saddr`) values(?,?,?)";
		
		try {
			
			//Fetch the connection from  JDBCUtil class
			
			connection=JDBCUtil.getJDBCConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(insertSQLQuery);
			}
			
			//using prepared statement object pstmt to execute the query  
			if(pstmt!=null)
			{
				pstmt.setString(1, sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3, saddr);
				
				int noOfRowsUpdated=pstmt.executeUpdate();
				System.out.println("No of rows inserted are:"+noOfRowsUpdated);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			//Fetch the close connection from  JDBCUtil class
			JDBCUtil.closeConnection(null, pstmt, connection);
			
			if(scanner!=null)
			{
				scanner.close();
			}
		} 
		
	}

}

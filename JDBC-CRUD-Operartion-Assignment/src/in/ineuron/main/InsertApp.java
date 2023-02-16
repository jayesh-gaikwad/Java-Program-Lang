package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;


public class InsertApp {
		
	Scanner scanner = null;
	public void InsertOpertaion() {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		

		try {
			connection = JdbcUtil.getJdbcConnection();

			String sqlInsertQuery = "insert into student(`sid`,`sname`,`sage`,`saddr`)values(?,?,?,?)";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			
			System.out.println("Insert your Details: ");
			
			if (pstmt != null) {

				scanner = new Scanner(System.in);
				
				System.out.print("Enter the id of the student ::");
				int sid=scanner.nextInt();
				
				System.out.print("Enter the name of the student :: ");
				String sname = scanner.next();

				System.out.print("Enter the age of the student :: ");
				int sage = scanner.nextInt();

				System.out.print("Enter the address of the student :: ");
				String address = scanner.next();

				// use precompiled query to set the values
				pstmt.setInt(1,sid);
				pstmt.setString(2, sname);
				pstmt.setInt(3, sage);
				pstmt.setString(4, address);
				
				System.out.println(sqlInsertQuery);

				// execute the query
				int rowCount = pstmt.executeUpdate();
				if(rowCount==1)
				{
					System.out.println("Record Inserted Successfully !!!");
					System.out.println("No of rows updated is :: " + rowCount);
				}else {
					System.out.println("Record not Inserted !!!");
				}
				
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
				scanner.close();
				System.out.println("Closing the resource...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}



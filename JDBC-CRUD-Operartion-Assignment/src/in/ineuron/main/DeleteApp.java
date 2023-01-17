package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class DeleteApp {

	public void DeleteOperation() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;

		try {
			connection = JdbcUtil.getJdbcConnection();
			
			String sqlDeleteQuery = "delete from student where sid = ?";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			
			System.out.println("Delete your Details: ");
			
			if (pstmt != null) {
				scanner = new Scanner(System.in);

				System.out.print("Enter the id of the student :: ");
				int sid = scanner.nextInt();

				// use precompiled query to set the values
				pstmt.setInt(1, sid);

				// execute the query
				int rowCount = pstmt.executeUpdate();
				if(rowCount==1)
				{
					System.out.println("Record Deleted Successfully !!!");
					System.out.println("No of rows deleted is :: " + rowCount);					
				}else {
					System.out.println("Record Not available for given ID !!!");
				}
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.cleanUp(connection, pstmt, null);
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}
}

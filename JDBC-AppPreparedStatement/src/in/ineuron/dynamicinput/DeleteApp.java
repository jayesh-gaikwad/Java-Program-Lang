package in.ineuron.dynamicinput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JDBCUtil;

public class DeleteApp {

	public static void main(String[] args) throws SQLException {
		
		// Resource used in jdbc select app
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner =null;

		scanner = new Scanner(System.in);
		System.out.print("Enter the sid: ");
		int sid = scanner.nextInt();
		
		String deleteQuery = "delete from student where sid=?";

		try {
			//getting connection with from the JDBCUtil package 
			connection = JDBCUtil.getJDBCConnection();
			if (connection != null)
			{
				//getting data into prepared statement
				pstmt = connection.prepareStatement(deleteQuery);
			}
			if (pstmt != null) 
			{
				pstmt.setInt(1, sid);
				//after getting data storing inside the resultSet object
				 int noOfRowsDeleted=pstmt.executeUpdate();
				 System.out.println("No of rows deleted are:"+noOfRowsDeleted);
			}
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			//USed closeConnection class from JDBCUtil class
			JDBCUtil.closeConnection(null, pstmt, connection);
			if (scanner != null)
			{
				scanner.close();
			}	
		}		
	}

}

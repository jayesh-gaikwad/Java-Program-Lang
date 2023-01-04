package in.ineuron.dynamicinput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JDBCUtil;

public class UpdateApp {

	public static void main(String[] args) throws SQLException{
		
		// Resource used in jdbc select app
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner =null;

		scanner = new Scanner(System.in);
		System.out.print("Enter the sid: ");
		int sid = scanner.nextInt();

		System.out.print("Enter the sage: ");
		int sage = scanner.nextInt();
		
		String sqlUpdateQuery = "update student set sage=? where sid=?";

		try {
			//getting connection with from the JDBCUtil package 
			connection = JDBCUtil.getJDBCConnection();
			if (connection != null)
			{
				//getting data into prepared statement
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}
			if (pstmt != null) 
			{
				pstmt.setInt(1, sage);
				pstmt.setInt(2, sid);
				//after getting data storing inside the resultSet object
				 int noOfRowsUpdated=pstmt.executeUpdate();
				 System.out.println("No of rows updated are:"+noOfRowsUpdated);
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

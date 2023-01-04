package in.ineuron.dynamicinput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JDBCUtil;

public class SelectApp {

	public static void main(String[] args) throws SQLException {

		// Resource used in jdbc select app
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner scanner =null;

		scanner = new Scanner(System.in);
		System.out.print("Enter the sid: ");
		int sid = scanner.nextInt();

		String sqlSelectQuery = "select sid,sname,sage,saddr from student where sid=?";

		try {
			//getting connection with from the JDBCUtil package 
			connection = JDBCUtil.getJDBCConnection();
			if (connection != null)
			{
				//getting data into prepared statement
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			if (pstmt != null) 
			{
				pstmt.setInt(1, sid);
				//after getting data storing inside the resultSet object
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) 
			{
				if (resultSet.next()) 
				{
					System.out.println("SID\tSNAME\tSAGE\tSADDR");
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));
				} 
				else 
				{
					System.out.println("Record not available for the given id:: " + sid);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			//USed closeConnection class from JDBCUtil class
			JDBCUtil.closeConnection(resultSet, pstmt, connection);
			if (scanner != null)
			{
				scanner.close();
			}	
		}
	}
}

package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;


public class SelectApp {

	public void SelectOperation() {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		ResultSet resultSet = null;
		int sid = 0;

		try {
			connection = JdbcUtil.getJdbcConnection();

			String sqlSelectQuery = "select sid,sname,sage,saddr from student where sid =?";
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			
			System.out.println("Retrieve your Details: ");
			
			if (pstmt != null) {

				scanner = new Scanner(System.in);

				System.out.print("Enter the student id of the student :: ");
				sid = scanner.nextInt();

				// use precompiled query to set the values
				pstmt.setInt(1, sid);

				// execute the query
				resultSet = pstmt.executeQuery();
			}
			if (resultSet != null) {

				if (resultSet.next()) {
					System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));
				} else {
					System.out.println("Record not available for the give id :: " + sid);
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
				JdbcUtil.cleanUp(connection, pstmt, resultSet);
				System.out.println("Closing the resource...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

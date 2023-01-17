package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class UpdateApp {

	public void UpdateOperation() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet =null;
		int sid=0;

		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if (connection != null) {
				
				pstmt=connection.prepareStatement("select sid, sname, sage, saddr from student where sid= ?");
				if(pstmt!=null) {
		            System.out.println("Enter Student ID for Update: ");
		            Scanner scan=new Scanner(System.in);
		            sid = scan.nextInt();
		            pstmt.setInt(1, sid);
		            resultSet = pstmt.executeQuery();
		        }
		        if(resultSet!=null){
		            if(resultSet.next()){
		                System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
		                System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
		            
		                String sqlUpdateQuery = "update student set sname= ?, sage=?, saddr = ? where sid = ?";
		    			pstmt = connection.prepareStatement(sqlUpdateQuery);
		    			
		    			System.out.println("Update your Details: ");
		    			
		    			if (pstmt != null) {
		    				Scanner scanner = new Scanner(System.in);
		    				
		    				System.out.println("Enter the student name for updating... ::");
		    				String sname=scanner.next();
		    				
		    				System.out.println("Enter the student age for updating... :: ");
		    				int sage=scanner.nextInt();
		    				
		    				System.out.print("Enter the student saddress for updating... :: ");
		    				String saddr = scanner.next();

		    				// use precompiled query to set the values
		    				pstmt.setString(1, sname);
		    				pstmt.setInt(2, sage);
		    				pstmt.setString(3, saddr);
		    				pstmt.setInt(4,sid);
		    				
		    				// execute the query
		    				int rowCount = pstmt.executeUpdate();
		    				
		    				if(rowCount==1)
		    				{
		    					System.out.println("Rercord Inserted Successfully !!");
		    					System.out.println("No of rows updated is :: " + rowCount);		    					
		    				}else {
		    					System.out.println("Record updation failed !!!");
		    				}
		    			}
		            }else{
		                System.out.println("Record Not Found !!!");
		            }
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

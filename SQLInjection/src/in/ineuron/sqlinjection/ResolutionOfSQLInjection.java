package in.ineuron.sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ResolutionOfSQLInjection {

	//To avoid SQLInjection we can use PreparedStatement Object 
	public static void main(String[] args) throws SQLException {
		
		Scanner scanner=new Scanner(System.in); 
		
		System.out.println("Enter the username:");
		String uname=scanner.next();
		
		System.out.println("Enter the password:");
		String password=scanner.next();
		
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "cdac");
		
		String sqlSelectQuery="select count(*) from users where username=? and pwd=?";
		PreparedStatement pstmt=connection.prepareStatement(sqlSelectQuery);
	

		pstmt.setString(1, uname);
		pstmt.setString(2, password);
		
		ResultSet resultSet=pstmt.executeQuery();
		
		int count=0;
		if(resultSet.next()) {
			count=resultSet.getInt(1);
		}
		
		if(count==1) {
			System.out.println("valid credentials");
		}else {
			System.out.println("Invalid Credentials");
		}
		
		scanner.close();
		resultSet.close();
		pstmt.close();	
	}

}

/*

Enter the username:
virat
Enter the password:
kohli
valid credentials

Enter the username:
virat'--
Enter the password:
kohli
Inavalid Credentials

 */
 

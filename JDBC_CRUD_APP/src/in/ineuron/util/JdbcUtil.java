package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	
	private JdbcUtil() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException,IOException{
		
		String fileLoc="C:\\Programming lang\\Full-Stack-Java-Developer\\JDBC_CRUD_APP\\src\\in\\ineuron\\properties\\application.properties";
		FileInputStream fis=new FileInputStream(fileLoc);
		Properties properties=new Properties();
		properties.load(fis);
		
		String url=properties.getProperty("jdbcUrl");
		String username=properties.getProperty("user");
		String password=properties.getProperty("password");
			
		return DriverManager.getConnection(url,username,password);
	}

}

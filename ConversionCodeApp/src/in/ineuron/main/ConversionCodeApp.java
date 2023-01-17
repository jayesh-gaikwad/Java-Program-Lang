package in.ineuron.main;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConversionCodeApp {

	public static void main(String[] args) throws Exception {
		
		//Read the input from the user
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the date:: (MM-yyyy-dd)");
		String sdate = scanner.next();
		
		//Convert the date from String format to java.util.Date
		SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy-dd");
		java.util.Date uDate = sdf.parse(sdate);
		
	
		//Convert java.util.Date to java.sql.Date
		long value = uDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(value);
		
		//Printing all the 3 formats of Date
		System.out.println("String format date is :: "+sdate);
		System.out.println("Util Date is  :: "+uDate);
		System.out.println("SqlDate   is  :: "+sqlDate);
		
		System.out.println();
		
		System.out.print("Enter the dom in the following format ::(yyyy-MM-dd) ");
		String standardInput = scanner.next();
		java.sql.Date sqlStandardInput = java.sql.Date.valueOf(standardInput);
		System.out.println("String standardInput    :: "+standardInput);
		System.out.println("String sqlStandardInput :: "+sqlStandardInput);
		
		scanner.close();
	}

}

package in.ineuron.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws IOException, SQLException{
		
		InsertApp insertApp=new InsertApp();
        SelectApp selectApp=new SelectApp();
        UpdateApp updateApp=new UpdateApp();
        DeleteApp deleteApp=new DeleteApp();
        
		Scanner scanner=new Scanner(System.in);
        System.out.println("=========================================\n" +
                "Menu For Performing CRUD Operation\n" +
                "1.INSERT Operation\n"+
                "2.SELECT Operation\n"+
                "3.UPDATE Operation\n"+
                "4.DELETE Operation\n"+
                "Press any key to Exit the Application\n"+
                "=========================================");
        int choice=scanner.nextInt();
        
        while (choice>=1&&choice<=5)
        {
        		if (choice == 1) {
        			insertApp.InsertOpertaion();
        		} else if (choice==2) {
        			selectApp.SelectOperation();
        		} else if (choice==3) {
        			updateApp.UpdateOperation();
        		} else if (choice==4) {
        			deleteApp.DeleteOperation();
        		}
        		else{
					System.exit(0);
				}
        		System.out.println("=========================================\n" +
                        "Menu for performing CRUD Operation\n" +
                        "1.INSERT Operation\n"+
                        "2.SELECT Operation\n"+
                        "3.UPDATE Operation\n"+
                        "4.DELETE Operation\n"+
                        "Press any key to Exit the Application\n"+
                        "=========================================");
                		choice=scanner.nextInt();
                		scanner.close();
            	}
        	
        	}        

}         
	


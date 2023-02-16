package in.ineuron.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class ResponseInfoApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/jpg");
		
		File file=new File("C:\\Programming lang\\Full-Stack-Java-Developer\\ResponseInfoApp\\jayesh.jpg");
		FileInputStream fis=new FileInputStream(file);
		
		byte[] b =new byte[(int)file.length()];
		fis.read(b);
		
		ServletOutputStream sos= response.getOutputStream();
		sos.write(b);
		
		sos.flush();
		sos.close();
		fis.close();	
	}

}

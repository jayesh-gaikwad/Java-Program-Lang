package in.ineuron.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
	
		LocalDateTime date=LocalDateTime.now();
		
		int hour =date.getHour();
		String msg="";
		if(hour<12)
		{
			msg=msg+ "Good Morning";
		}else if(hour<16)
		{
			msg=msg+"Good Afternoon";
		}else if(hour<20)
		{
			msg=msg+"Good Evening";
		}else {
			msg=msg+"Good Night";
		}
		out.println("<h1 style='color:red;text-align:center'>Wecome To Servlet Coding !!!</h1>");
		out.println("<h1 style='color:blue;text-align:center'>The Current date and time is:"+date+"</h1>");
		out.println("<h1 style='color:blue;text-align:center'>Greeting from the Server:"+msg+"</h1>");
		
		out.println("<br/>Servlet Request Object Address is :"+request.hashCode());
		out.println("<br/>ServletResponse Objet Address is:"+request.hashCode());
		out.println("<br/>Current Servlet Object Address is:"+this.hashCode());
		out.println("<br/>Current Request-Thread Object address is:"+Thread.currentThread().hashCode());
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

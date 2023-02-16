package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class AttributeDataApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		ServletContext context=getServletContext();
		context.setAttribute("name", "Jayesh");
		context.setAttribute("address", "Pune");
		
		out.println("<html><head><title>Attribute Data</title></head>");
		out.println("<body");
		out.println("<center>");
		out.println("<h1 style='color:blue;'>Dynamic Information in Application Scope...</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>Attribute Name</th><th>Attribute Value</th></tr>");
		Enumeration<String>attributeNames=context.getAttributeNames();
		while(attributeNames.hasMoreElements())
		{
			String attributeName=(String)attributeNames.nextElement();
			Object attributeValue=context.getAttribute(attributeName);
			out.println("<tr>");
			out.println("<td>"+attributeName+"</td>");
			out.println("<td>"+attributeValue+"</td>");
				
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}

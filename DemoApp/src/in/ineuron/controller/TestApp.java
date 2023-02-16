package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestApp
 */
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(response);

		String stdName = "Jayesh";
		String stdAge = "25";
		String stdAddress = "MI";

		System.out.println(stdName + " " + stdAge + " " + stdAddress);
	}

	private void doProcess(HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>DISP</title></head></html>");
		out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

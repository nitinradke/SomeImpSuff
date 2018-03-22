package com.nitin.radke;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Userinfo
 */
@WebServlet("/userinfo")
public class Userinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("number");
		System.out.print(num);
		long number = Long.parseLong(num);
		try {
			String name = new Testingjdbc().getInfo(number);
			
			response.getWriter().println("<h3>The Information of user is : </h3>"
				 	                     +"<table border=1px ><thead><th>Name</th><th>Phone Number</th></thead>"
				 	                     + "<tbody><td>"+name+"</td><td>"+number+"</td></tbody></table>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

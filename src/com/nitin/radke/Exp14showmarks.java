package com.nitin.radke;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exp14showmarks
 */
@WebServlet("/exp14showmarks")
public class Exp14showmarks extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome "+request.getParameter("username")+"</h1> <p align='right'><a href='Exp14changepasswd.html'>Wanna Change Password?</a></p>");
		out.println("<table border=1px >"
				+ 	"<thead>"
				+ 		"<th>Sessional Marks</th>"
				+       "<th>Class Test Marks</th>"
				+   "</thead>" 
				+   "<tbody>"
				+ 		"<td>"+request.getAttribute("sess")+"</td>"
				+       "<td>"+request.getAttribute("ct")+"</td>"
				+    "</tbody>"
				+ "</table>");
	}

}

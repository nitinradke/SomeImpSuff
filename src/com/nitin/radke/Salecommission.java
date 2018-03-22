package com.nitin.radke;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Salecommission
 */
@WebServlet("/salecommission")
public class Salecommission extends HttpServlet {
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
		int sales = Integer.parseInt(request.getParameter("sale"));
		float rate  = Float.parseFloat(request.getParameter("commissionrate"));
		response.getWriter().print("<h3>The Commission rate is :<h3/><br>"+
				                     "Sales: "+sales+"<br>"+
				                     "Rate :"+rate+"<br>"+
				                     "Commission "+((sales*rate)/100));
	}

}

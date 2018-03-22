package com.nitin.radke;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Equationroot
 */
@WebServlet("/equationroot")
public class Equationroot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Equationroot() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		float a = Float.parseFloat(request.getParameter("a"));
		float b = Float.parseFloat(request.getParameter("b"));
		float c = Float.parseFloat(request.getParameter("c"));
		double d = b*b-4*a*c;
		if(d>=0){	
			double root1 = (-b+Math.sqrt(d))/2*a;
			double root2 = (-b-Math.sqrt(d))/2*a;
			response.getWriter().print("<h3> The Roots of Quadratic Equations are :</h3><br>"
									   +"Root1: "+root1+"<br>"
									   +"Root2: "+root2);
		}
		else {
			response.getWriter().println("<h3> The Roots are imaginary</h3>");
		}
	}
	

}

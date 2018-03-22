package com.nitin.radke;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleIntrest
 */
@WebServlet("/simpleintrest")
public class SimpleIntrest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleIntrest() {
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
		float p = Integer.parseInt(request.getParameter("p"));
		float r = Integer.parseInt(request.getParameter("r"));
		int t = Integer.parseInt(request.getParameter("t"));
		double sic = si(p, r, t);
		response.getWriter().print("<h3>The Simple Intrest of the given:<br>"
				                     + "Principal: "+p+
				                     "<br>Rate: "+r+
				                     "<br>Time: "+t+
				                     "<br>Simple Intrest: "+sic);
	}
	
	
	double si(float p,float r,int t) {
		return ((p*r*t)/100);
	}

}

package com.nitin.radke;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CsvtuRegistration
 */
@WebServlet("/csvturegistration")
public class CsvtuRegistration extends HttpServlet {
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
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		String security = request.getParameter("security");
		System.out.println(name);
		System.out.println(pass);
		System.out.println(security);
		
		Registrationdb registrationdb =new Registrationdb();
		try {
			int status = registrationdb.setcsvtudb(name, pass, security);
			if(status>0) {
				System.out.println("done");
			    request.getRequestDispatcher("Login.html").include(request, response); 
			}
			else
				System.out.println("not done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

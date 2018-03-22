package com.nitin.radke;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
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
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone"));
		Registrationdb registrationdb =new Registrationdb();
		try {
			int status = registrationdb.setdb(name, pass, email, phone);
			if(status>0) {
				System.out.println("done");
			    request.getRequestDispatcher("Registration.html").include(request, response); 
			}
			else
				System.out.println("not done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

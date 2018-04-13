package com.nitin.radke;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
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
		try {
			Connection connection  = Registrationdb.getConnection();
			PreparedStatement pStatement = connection.prepareStatement("select * from info where name=?");
			pStatement.setString(1,request.getParameter("Username"));
			ResultSet rSet = pStatement.executeQuery();
			while (rSet.next()) {
				String pass = request.getParameter("Password");
				if(pass.equals(rSet.getString(2)))
				{
					request.getRequestDispatcher("Logedinpage.html").forward(request, response);
				}
				else 
				{
					request.getRequestDispatcher("Login.html").forward(request, response);
				}
						
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

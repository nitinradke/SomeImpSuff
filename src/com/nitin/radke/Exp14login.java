package com.nitin.radke;


import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exp14login
 */
@WebServlet("/exp14login")
public class Exp14login extends HttpServlet {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sql ="select * from csvtu where name=?"; 
		try {
			Connection con = Registrationdb.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rSet = statement.executeQuery();
			while(rSet.next())
			{
				if(rSet.getString(2).equals(password)) {
					int sess = rSet.getInt(3);
					int ct = rSet.getInt(4);
					request.setAttribute("sess", sess);
					request.setAttribute("ct", ct);
					request.getRequestDispatcher("exp14showmarks").forward(request, response);
				}
				else
				{
					response.getWriter().println("<center><p style='color:red'>Permission Deniend</p></center>");
					request.getRequestDispatcher("/Exp14loginpage.html").include(request, response);
				}
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

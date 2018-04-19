package com.nitin.radke;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exp14ChangePassword
 */
@WebServlet("/exp14changepassword")
public class Exp14ChangePassword extends HttpServlet {
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
			System.out.print("nitin");
			PrintWriter out = response.getWriter();
			Connection con = Registrationdb.getConnection();
			String current = request.getParameter("answer");
			String password = request.getParameter("passwd1");
			String q="update csvtu set password='"+password+"' where security_ans='"+current+"'";
			Statement statement = con.createStatement();
			int rs=statement.executeUpdate(q);
			if(rs !=0 ){
					out.println("<p> Password Updated !</p>");
			        request.getRequestDispatcher("Exp14loginpage.html").include(request, response);
				
			}
			else{
				
			        out.println("<p> Password could not be updated !</p>");
			        request.getRequestDispatcher("Exp14changepasswd.html").include(request,response);
			
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

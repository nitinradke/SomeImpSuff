package com.nitin.radke;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookRegistration
 */
@WebServlet("/bookregistration")
public class BookRegistration extends HttpServlet {
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
		String Bookname = request.getParameter("bookname");
		long price = Long.parseLong(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int avalible = Integer.parseInt(request.getParameter("avaliable"));
		try {
			Connection connection = Registrationdb.getConnection();
			PreparedStatement pStatement = connection.prepareStatement("Insert into books values (?,?,?,?)");
			pStatement.setString(1, Bookname);
			pStatement.setLong(2,price);
			pStatement.setInt(3, quantity);
			pStatement.setInt(4, avalible);
			int status = pStatement.executeUpdate();
			if(status>0)
			{
				System.out.println("done");
				request.getRequestDispatcher("Book.html").forward(request, response);
			}
			else
			{
				response.getWriter().print("Sorry Somethig went Wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

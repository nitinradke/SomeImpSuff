package com.nitin.radke;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListUsers
 */
@WebServlet("/listusers")
public class ListUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='Registration.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<User> list=GetAllUsers.getAllUsers();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Name</th><th>Password</th><th>Email</th><th>Phone</th>");  
        for(User e:list){  
         out.print("<tr><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td> <td>"+e.getEmail()+"</td><td>"+e.getnumber());  
        }  
        out.print("</table>");  
          
        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

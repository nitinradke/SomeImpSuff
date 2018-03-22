package com.nitin.radke;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class Factorial extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String numbr = req.getParameter("number");
		int num = Integer.parseInt(numbr);
		int fact = 1;
		for(int i=num;i>1;i--)
		{
			fact = fact*i;
		}
		resp.getWriter().println("The Factorial of "+num+" is "+fact);
//		req.setAttribute("fact", fact);
//		req.getRequestDispatcher("Factorial.jsp").forward(req, resp);
	}

}

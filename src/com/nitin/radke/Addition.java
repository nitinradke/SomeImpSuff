package com.nitin.radke;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class Addition extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("number1"));
		int num2 = Integer.parseInt(req.getParameter("number2"));
		long sum = add(num1,num2);
		resp.getWriter().println("The sum of two given numbers are "+sum);
	}
	
	
	
	long add(int a,int b){
		return a+b;
	}

}

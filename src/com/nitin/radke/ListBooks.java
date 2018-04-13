package com.nitin.radke;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListBooks
 */
@WebServlet("/listbooks")
public class ListBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Books List</h1>");  
          
        List<BookDetails> list=BookList.getAllBooks();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Name</th><th>Price</th><th>Quantity</th><th>Avaliable</th>");  
        for(BookDetails e:list){  
         out.print("<tr><td>"+e.getBookName()+"</td><td>"+e.getPrice()+"</td> <td>"+e.getQuantity()+"</td><td>"+e.getAvaliable());  
        }  
        out.print("</table>");  
          
        out.close();  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

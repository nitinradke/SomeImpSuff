<!DOCTYPE HTML>
<%@ page import="java.util.*" %>
<html>
	<head>
		<title>My Cart</title>	
		<script>
			function add(){
				window.location("exp15.html");
			}
		</script>
	</head>
	<body>
		<h1> MY CART</h1>
				
		
		
		<%
	// get the TO DO items from the session
	List<String> items = (List<String>) session.getAttribute("mycartList");

	// if the TO DO items doesn't exist, then create a new one
	if (items == null) {
		items = new ArrayList<String>();
		session.setAttribute("mycartList", items);
	}
	
	// see if there is form data to add
	String theItem = request.getParameter("item");
	if (theItem != null) {
		items.add(theItem);
	}
%>
<ol>
<%
	for (String temp : items) {
		out.println("<li>" + temp + "</li>");
	}
	
	%>
</ol>
<hr>
<a href="exp15.html">Add more to cart?</a> <br>

                <a href="exp15logout.jsp">Logout</a> <br>
	</body>
</html>
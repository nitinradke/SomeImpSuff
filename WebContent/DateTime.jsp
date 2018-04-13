<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Date Time</title>
</head>
<body>
<center><b><h1>JSP Date and time application</h1></b></center>
<% 
Date d = new Date();
out.print("Today's date is : " + d.toString());
%>

</body>
</html>
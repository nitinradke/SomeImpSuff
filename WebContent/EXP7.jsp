<!-- EXP.jsp -->
<html>  
	<body> 
		<%! double calcIT(double income)
			{
				double tax;
				if(income <= 50000)
				{
					tax = 0.01;
				}
				else if(income <= 75000)
				{
					tax = 0.02;
				}
				else if(income <= 100000)
				{
					tax = 0.03;
				}
				else if (income <= 250000)
				{
					tax = 0.04;
				}
				else if (income <= 500000)
				{
					tax = 0.05;
				}
				else
				{
					tax = 0.06;
				}
				return(tax * income);
			}
		%>
		<center>
		<h1> Income Calculator</h1><br>
		<form action="EXP7.jsp">
			Enter Your Annual Income: <input type="text" name="income" placeholder="Enter Your Income" />
			<br><input type="submit" value="Find" />  
			<input type="reset" value = "reset"/>
		</form>
		
		<% 	try
			{
				String param1 = request.getParameter("income");
				if(param1 != null)
				{
					double income = Double.parseDouble(param1);
					out.println("Your total income tax is : "+calcIT(income));
				}
			}
			catch(Exception e)
			{
				out.println("Something Went Wrong !");
			}
		%>
		</center>
	</body>  
</html> 
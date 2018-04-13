package com.nitin.radke;
import java.sql.*;



public class GetTelephoneDetails  {
	
	Connection getConnection() throws Exception
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	return con;    
	}
	
	long getName(String username) throws Exception
	{
		long number=0;
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from new where name=?");
		statement.setString(1, username);
		ResultSet rs = statement.executeQuery();
		while(rs.next())
		{
			number = rs.getLong(2);
		}
		return number;
	}
		
}
	



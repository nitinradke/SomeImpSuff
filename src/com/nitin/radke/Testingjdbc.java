package com.nitin.radke;
import java.sql.*;



public class Testingjdbc  {
	
	Connection getConnection() throws Exception
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
	return con;    
	}
	
	String getNumber(long number) throws Exception
	{
		String name = null;
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from new where mobile=?");
		statement.setLong(1, number);
		ResultSet rs = statement.executeQuery();
		while(rs.next())
		{
			name = rs.getString(1);
		}
		return name;
	}
	
	String getInfo(long number) throws Exception {
		Testingjdbc testingjdbc =new Testingjdbc();
		String name = testingjdbc.getNumber(number);
		return(name);
	}
		
}
	



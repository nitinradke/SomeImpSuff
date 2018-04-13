package com.nitin.radke;
import java.sql.*;


public class Registrationdb {
	static Connection  getConnection() throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		return connection;
	}
	
	int setdb(String name,String pass,String email,long phone) throws Exception
	{
		
		Connection connection =getConnection();
		PreparedStatement pStatement = connection.prepareStatement("insert into info values(?,?,?,?)");
		pStatement.setString(1,name);
		pStatement.setString(2,pass);
		pStatement.setString(3,email);
		pStatement.setLong(4,phone);
		int status = pStatement.executeUpdate();
		
		return status;
	}
	int setcsvtudb(String name,String pass,String security) throws Exception
	{
		
		Connection connection =getConnection();
		PreparedStatement pStatement = connection.prepareStatement("insert into csvtu values(?,?,0,0,?)");
		pStatement.setString(1,name);
		pStatement.setString(2,pass);
		pStatement.setString(3,security);
		int status = pStatement.executeUpdate();
		
		return status;
	}
}

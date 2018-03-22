package com.nitin.radke;
import java.util.*;
import java.sql.*;


public  class GetAllUsers
{
public static List<User> getAllUsers(){  
    List<User> list=new ArrayList<User>();  
      
    try{  
        Connection con=new Registrationdb().getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from info");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            User e=new User();
            String name = rs.getString(1);
            System.out.println(name);
            e.setName(rs.getString(1));  
            e.setPassword(rs.getString(2));  
            e.setEmail(rs.getString(3));  
            e.setnumber(rs.getLong(4));  
            list.add(e);  
        }  
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return list;  
	}  
}
package com.nitin.radke;
import java.util.*;
import java.sql.*;


public  class BookList
{
public static List<BookDetails> getAllBooks(){  
    List<BookDetails> list=new ArrayList<BookDetails>();  
      
    try{  
        Connection con= Registrationdb.getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from books");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            BookDetails e=new BookDetails();
            String bookname = rs.getString(1);
            System.out.println(bookname);
            e.setBookName(rs.getString(1));  
            e.setPrice(rs.getLong(2)); 
            e.setQuantity(rs.getInt(3));  
            e.setAvaliable(rs.getInt(4));  
            list.add(e);  
        }  
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return list;  
	}  
}
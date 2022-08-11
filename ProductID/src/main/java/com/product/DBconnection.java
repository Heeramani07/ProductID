package com.product;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnection {
	static Connection con=null;
	public static Connection getMyConnection() {
		try{  
			
			//step1 load the driver class in memory at run time 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step2 create  the connection object 
			 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","Heeramani@07");  
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return con;
		
		}
}


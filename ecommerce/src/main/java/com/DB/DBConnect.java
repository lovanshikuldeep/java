package com.DB;
import java.sql.*;
public class DBConnect {
      private static Connection connection;
      public static Connection getConnetion()
      {
    	  try {
    		  if(connection == null)
    		  {
    			  Class.forName("com.mysql.cj.jdbc.Driver");
    			  connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
    			  		
    		  }
    		  
    	  }catch (Exception e) {
    		  e.printStackTrace();
    	  }
		return connection;
      }
	

}

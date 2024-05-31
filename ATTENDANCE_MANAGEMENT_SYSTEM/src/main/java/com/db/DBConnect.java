package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
       private static Connection conn;
       
       public static Connection getConn() {
//    	   
//      String url="jdbc:mysql:///job_portal";
//      String dbName="job_portal";
//     
//      String userName="root";  vishal123
//      String password="#vmk5657";  vishal123
      
		   
    	   try {
    		   
			if (conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				conn=DriverManager.getConnection("jdbc:mysql:///attendance_management","root","#vmk5657");                           
				//conn=DriverManager.getConnection(url+dbName,userName,password); 
				//jdbc:mysql://localhost:3306/your_database_name
               System.out.println("connection established sussefully");
			}
			   
			
		} catch (Exception e) {
			
			System.out.println("error in DBConnect");
		}
    	   
    	   return conn;
    	   
          
	}
}

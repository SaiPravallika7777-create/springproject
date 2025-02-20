package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo {
	
	static String dbURL="jdbc:mysql://localhost:3306/sai";
	static String username="root";
	static String password="Balu@7777";
	static Connection conn=null;

	public static void main(String[] args) {
		
	       try {
	    	 //load driver
				Class.forName("com.mysql.jdbc.Driver");
				//create connection
				
				conn=DriverManager.getConnection(dbURL,username,password);
				if(conn!=null) {
					System.out.println("Connected");
					
					//create statement
					PreparedStatement ps=conn.prepareStatement("insert into EMPLOYEE values (?,?,?)");
				    ps.setInt(1, 102);
				    ps.setString(2, "pravallika");
				    ps.setInt(3, 3000);
				    
				    // execute statement
				    
				    int noOfCreatedRows=ps.executeUpdate();
				    
				    System.out.println(noOfCreatedRows);
				    if(noOfCreatedRows>0) {
				    	System.out.println("Successfully Inserted");
				    }
				    
					
				}
	    	   
	       }
	       catch(Exception e) {
	    	   
	    	   e.printStackTrace();
	    	   
	       }
			
			
			
			
			
		

	}

}

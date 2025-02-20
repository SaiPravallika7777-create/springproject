package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteDemo {
	
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
					PreparedStatement ps=conn.prepareCall("delete from EMployee where id =(?)");
				    ps.setInt(1, 102);
				  
				    
				    // execute statement
				    
				    int noOfDeletedRows=ps.executeUpdate();
				    
				    System.out.println(noOfDeletedRows);
				    if(noOfDeletedRows>0) {
				    	System.out.println("Successfully Deleted");
				    }
				    
					
				}
	    	   
	       }
	       catch(Exception e) {
	    	   
	    	   e.printStackTrace();
	    	   
	       }
			
			
			
			
			
		

	}

}

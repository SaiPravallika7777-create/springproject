package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDemo {
	
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
					
					String query="select * from Employee";
					//create statement
					PreparedStatement ps=conn.prepareCall(query);
					
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
					}
				   
				  
					
				}
	    	   
	       }
	       catch(Exception e) {
	    	   
	    	   e.printStackTrace();
	    	   
	       }
	       
	       finally {
	    	   try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }
	

	}
	


}

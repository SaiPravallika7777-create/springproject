package problem1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoClass {

	
	static String dbURL="jdbc:mysql://localhost:3306/sai";
	static String username="root";
	static String password="Balu@7777";
	static Connection conn;
	
	static Connection createConnection() {
		
		try {
			//load driver
			
			Class.forName("com.mysql.jdbc.Driver");
			//create connection
			
			conn=DriverManager.getConnection(dbURL,username,password);
			if(conn!=null) {
				System.out.println("Connected");
				return conn;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
		
		return null;
		
	}
	
	static void insertRecord(int id,String name, int salary) {
		try {
			Connection conn=DaoClass.createConnection();
			if(conn!=null) {
                System.out.println("Insert Records");
				//create statement
				PreparedStatement ps=conn.prepareStatement("insert into EMPLOYEE values (?,?,?)");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, salary);
			    // execute statement
			    
			    int noOfCreatedRows=ps.executeUpdate();
			    
			    System.out.println(noOfCreatedRows);
			    if(noOfCreatedRows>0) {
			    	System.out.println("Successfully Inserted");
			    }
			}
			
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static void retrieveRecord() {
		try {
			    Connection conn=DaoClass.createConnection();
				if(conn!=null) {
					System.out.println("Retrieve Records");
					
					String query="select * from Employee";
					//create statement
					PreparedStatement ps=conn.prepareStatement(query);
					
					ResultSet rs=ps.executeQuery();
					
					while(rs.next()) {
						
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
					}
				   
				  
					
				}
				conn.close();
	    	   
	       }
	       catch(Exception e) {
	    	   
	    	   e.printStackTrace();
	    	   
	       }
	}
	
	
	
	static void updateRecord(int id,int salary) {
		try {
			Connection conn=DaoClass.createConnection();
			
			if(conn!=null) {
				System.out.println("Update Records");
				//create statement
				PreparedStatement ps=conn.prepareStatement("update EMPLOYEE set salary=(?) where id=(?)");
			    // execute statement
				ps.setInt(1, salary);
				ps.setInt(2,id);
			    
			    int noOfUpdateRows=ps.executeUpdate();
			    
			    System.out.println(noOfUpdateRows);
			    if(noOfUpdateRows>0) {
			    	System.out.println("Successfully Updated");
			    }
			    else {
			    	System.out.println("No records updated");
			    }
			}
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	static void deleteRecord(int id) {
		try {
			     Connection conn=DaoClass.createConnection();
				if(conn!=null) {
				
					System.out.println("Delete Records");
					//create statement
					PreparedStatement ps=conn.prepareStatement("delete from EMployee where id =(?)");
                    ps.setInt(1, id);
				    
				    // execute statement
				    
				    int noOfDeletedRows=ps.executeUpdate();
				    
				    System.out.println(noOfDeletedRows);
				    if(noOfDeletedRows>0) {
				    	System.out.println("Successfully Deleted");
				    }
				    else {
				    	System.out.println("no records deleted");
				    }
				    
					
				}
				conn.close();
	    	   
	       }
	       catch(Exception e) {
	    	   
	    	   e.printStackTrace();
	    	   
	       }
	}
	
	
	
	
}

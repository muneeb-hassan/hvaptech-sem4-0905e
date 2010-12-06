package login;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public static void main(String[] srg) 
	   {
	       String driverName
	          = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // Start JDBC
	       String dbURL = "jdbcqlserver:DatabaseName=BudgetAuthorization";  //  Connect the server and the database
	       //String userName = "Administrator";  // windows user
	       //String userPwd = "password";  // windows login password
	       String userName="sa";
	       String userPwd="chihung";
	       Connection dbConn;

	       try 
	       {
	          Class.forName(driverName);
	          dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
	          System.out.println("Connection Successful!");  
	          // if successful print Connection Successful!
	        } 
	       catch (Exception e) 
	       {
	           e.printStackTrace();
	        }
	}


}

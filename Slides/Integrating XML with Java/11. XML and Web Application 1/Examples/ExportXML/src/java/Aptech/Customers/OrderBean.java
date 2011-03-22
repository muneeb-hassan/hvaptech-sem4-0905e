/*
 * OrderBean.java
 * The object of this class retrieves the customer orders from the SQL Server database and 
 * stores those in a vector. The caller retrieves the vector by calling the getOrders method.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 *
 * @author Vincent
 *
 */

package Aptech.Customers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

public class OrderBean implements Serializable {
    
    private Vector orders = new Vector();
    private Connection con = null;
    private ResultSet rs = null;
    
    /* In the constructor we retrieve and store all orders in the vector. */
    public OrderBean() {
        try {
            
            // create a variable for the connection string.
            String connectionUrl = "jdbc:sqlserver://localhost:1113;databaseName=master;user=sa;password=aptech";
            
            // setting up jdbc for the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // to get a connection with the SQL Server
            con = DriverManager.getConnection(connectionUrl);
            
            // to create a statement object
            Statement stmt = con.createStatement();;
            
            // create an SQL statement that retrieves customer orders
            String SQL = "SELECT * FROM CustomerOrders order by Name";
            
            // to execute the query and store the results in 'rs'
            rs = stmt.executeQuery(SQL);
            
            // iterate through the data in the result set and add it to the vector
            while (rs.next()) {
                
                // to add a record in the database to the 'orders' object
                orders.addElement(new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            
            // close database connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // this method returns the vector containing customer orders to the caller.
    public Iterator getOrders() {
        
        //  to return an iterator over the orders
        return orders.iterator();
    }
}
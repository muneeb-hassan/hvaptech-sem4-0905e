
package Aptech.Customers;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 * Order.java
 * Each order is captured in the instance of this class.
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
/*
 *@author Vincent */

public class Order implements Serializable {
    
    // messages are captured in msg string.
    private String msg = "";
    private Connection con = null;
    private int count = 1;
    
    // private variable corresponding to sub-elements of
    // customer tag
    private String name;
    private String item;
    private String quantity;
    private String price;
    
    // The caller retrieves all accumulated messages by calling this method
    public String getMsg() {
        
        // returns the 'msg'
        return msg;
        
    }
    // Setter methods for four fields of Order class
    public void setItem(String item) {
        
        // initializes the object 'item' with the parameter
        this.item = item;
    }
    public void setName(String name) {
        
        // initializes the object 'name' with the parameter
        this.name = name;
    }
    
    public void setPrice(String price) {
        // initializes the object 'price' with the parameter
        this.price = price;
    }
    
    public void setQuantity(String quantity) {
        // initializes the object 'quantity' with the parameter
        this.quantity = quantity;
    }
    
    // Getter methods for four fields of Order class
    public String getName() {
        
        // returns the object 'name'
        return name;
    }
    public String getItem() {
        
        // returns the object 'item'
        return item;
    }
    
    public String getPrice() {
        
        // returns the object 'price'
        return price;
    }
    
    public String getQuantity() {
        
        // returns the object 'quantity'
        return quantity;
    }
    // Constructor that initializes the created object with the four parameters
    public Order(String name, String item, String quantity, String price) {
        
        // initializes the created object 'name' with the parameter
        this.name = name;
        
        // initializes the created object 'item' with the parameter
        this.item = item;
        
        // initializes the created object 'quantity' with the parameter
        this.quantity = quantity;
        
        // initializes the created object 'price' with the parameter
        this.price = price;
    }
    // default constructor
    public Order() {
        this.name = "";
        this.item = "";
        this.quantity = "";
        this.price = "";
    }
    
    /* saveOrder method saves the state of the current object in the SQL Server database
     */
    public String saveOrder() {
        try {
            
            // Modify the connection string appropriate to your database
            String connectionUrl = "jdbc:sqlserver://localhost:1113;" + "databaseName=master;user=sa;password=aptech";
            
            // Load the driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Establish the connection
            con = DriverManager.getConnection(connectionUrl);
            
            // Initialize the sql statement
            Statement stmt = null;
            
            // Creating an SQL statement
            stmt = con.createStatement();
            
            // Create and execute an SQL statement that returns some data
            String SQL = "INSERT INTO [CustomerOrders] VALUES ('";
            SQL += this.getName();
            SQL += "', '";
            SQL += this.getItem();
            SQL += "', '";
            SQL += this.getQuantity();
            SQL += "', '";
            SQL += this.getPrice();
            SQL += "');";
            stmt.execute(SQL);
            con.commit();
            
            // Disconnect from database
            con.close();
        } catch (Exception e) {
            
            // Add the error message to the 'msg' variable
            msg += e.getMessage();
        }
        return msg;
    }
}
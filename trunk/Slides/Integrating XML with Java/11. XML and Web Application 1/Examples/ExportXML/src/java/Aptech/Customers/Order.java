/*
 * Order.java
 * This class is an object-representation of the CustomerOrders table.
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */

package Aptech.Customers;

import java.io.Serializable;

/*
 *@author Vincent
 */
public class Order implements Serializable {
    
    // Each variable represents a particular column in the database table.
    
    //Declares the name of the customer
    private String name;
    
    //Declares the name of the item
    private String item;
    
    //Declares the quatity
    private String quantity;
    
    //Declares the price
    private String price;
    
    // Getter methods for accesing private variables.
    
    // Calls the method to get the name of the customer.
    public String getName() {
        
        //   Returns name of the customer
        return name;
    }
    
    // Calls the method to get the name of the item.
    public String getItem() {
        
        //   Returns item
        return item;
    }
    
    // Calls the method to get the price of the item.
    public String getPrice() {
        
        //   Returns price
        return price;
    }
    
    // Calls the method to get the quantity.
    public String getQuantity() {
        
        //   Returns quatity
        return quantity;
    }
    
    // Constructor that initializes the created object with the four parameters.
    public Order(String name, String item, String quantity, String price) {
        
        // initializes the object 'name' with the parameter
        this.name = name;
        
        // initializes the object 'item' with the parameter
        this.item = item;
        
        
        // initializes the object 'quatity' with the parameter
        this.quantity = quantity;
        
        // initializes the object 'price' with the parameter
        this.price = price;
    }
}
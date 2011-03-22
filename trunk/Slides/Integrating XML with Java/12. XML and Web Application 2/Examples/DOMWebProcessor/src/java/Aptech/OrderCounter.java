/*
 * OrderCounter.java
 * This class provides a method for counting the number of customer
 * orders
 *
 * @author Vincent
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */

package Aptech;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OrderCounter {
    
    // initializes count
    int count = 0;
    
    // client calls this to retrieve the order count
    public int getCount() {
        
        // returns count
        return count;
    }
    
    /* A recursive method to count the number of customer elements
     * in the input document. Each customer element represents an order
     */
    public void CountOrders(Node node) {
        
        // null value indicates that you have reached a leaf node
        if (node == null) {
            return;
        }
        // Increaments the count if a 'customer' node is found
        if (node.getNodeName().equals("customer")) {
            count++;
        }
        // get children of the current node
        NodeList children = node.getChildNodes();
        int i = 0;
        
        // processes all the nodes
        while (i < children.getLength()) {
            
            // recurse through the function to visit each node
            CountOrders(children.item(i++));
        }
    }
}
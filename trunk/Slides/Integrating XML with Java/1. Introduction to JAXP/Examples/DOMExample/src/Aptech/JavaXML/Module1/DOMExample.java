/*
 * DOMExample.java
 *
 * This program counts the number of users defined in
 * tomcat-users.xml configuration file used by tomcat server.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */

package Aptech.JavaXML.DOMExample;

/*
 * Author:   Vincent
 */

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMExample {
    
    // Declare a document object
    static Document doc;
    static int count = 0;
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DomExample tomcat-users.xml");
            System.exit(1);
        }
        try {
            // Declare file object
            File f = new File("tomcat-users.xml");
            // Obtain factory instance
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Obtain builder instance
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Parse document
            doc = db.parse(f);
            // Get the number of 'user' elements
            getUsers(doc);
            // print the result
            System.out.println("No of users: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     *  getUsers is a recursive function that counts the number of occurences
     *  of 'user' element.
     */
    private static void getUsers(Node node) {
        // null value indicates that we have reached a leaf node
        if (node == null) {
            return;
        }
        // Increament the count if a 'user' node is found
        if (node.getNodeName().equals("user")) {
            count++;
        }
        // Get children of the current node
        NodeList children = node.getChildNodes();
        // recurse through the function to visit each node
        int i = 0;
        while (i < children.getLength()) {
            getUsers(children.item(i++));
        }
    } 
}

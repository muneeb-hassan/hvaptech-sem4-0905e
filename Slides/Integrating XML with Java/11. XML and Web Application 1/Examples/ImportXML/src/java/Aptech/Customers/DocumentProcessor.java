/*
 * DocumentProcessor.java
 * This class populates an order object with the data in the XML document.
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
/*
 *@author Vincent
 */

package Aptech.Customers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// The SAX event handler class
public class DocumentProcessor extends DefaultHandler {
    
    // boolean flags to de-mark the begin and end of each sub-element
    // of customer tag
    private boolean nameFound = false;
    private boolean itemFound = false;
    private boolean quantityFound = false;
    private boolean priceFound = false;
    
    // capture messages in 'msg' string
    private String msg = "";
    
    // referece to Order object
    private Order order = null;
    
    // getter method for captured messages
    public String getMsg() {
        
        // returns the message
        return msg;
    }
    
    /*
     * The parser calls this method at the beginning of each element
     * that it encounters during parsing
     */
    public void startElement(String namespaceURI, String simpleName, String qualifiedName, Attributes attributeList)
    throws SAXException {
        
        // for each customer tag found, create a new Order object
        if (qualifiedName.equals("customer")) {
            
            // create new Order object
            order = new Order();
        }
        
        // for each sub-element of customer tag set the corresponding
        // flag true to indicate the beginning of the sub-element
        if (qualifiedName.equals("name")) {
            nameFound = true;
        }
        if (qualifiedName.equals("item")) {
            itemFound = true;
        }
        if (qualifiedName.equals("quantity")) {
            quantityFound = true;
        }
        if (qualifiedName.equals("price")) {
            priceFound = true;
        }
    }
    /*
     * Parser calls this method whenever it encounters character data
     * during document processing
     */
    public void characters(char[] buf, int off, int len) throws SAXException {
        
        // Create a String object from the character buffer
        String str = new String(buf, off, len);
        
        // Trim white space at the end
        str = str.trim();
        
        // for each sub-element store its text contents in the corresponding
        // field of order element and reset its found flag
        if (nameFound) {
            
            //set name in the order
            
            
            // reset flag
            nameFound = false;
        }
        if (itemFound) {
            
            // set item in the order
            order.setItem(str);
            
            // reset flag
            itemFound = false;
        }
        if (quantityFound) {
            
            // set quantity in the order
            order.setQuantity(str);
            
            // reset flag
            quantityFound = false;
        }
        if (priceFound) {
            
            // set price in the order
            order.setPrice(str);
            
            // reset flag
            priceFound = false;
        }
    }
    
    /* The SAX Processor calls this method for each encounter of the
     * end element
     */
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        
        // at the end of customer tag, save the record to the database
        if (qualifiedName.equals("customer")) {
            
            // save the record to the database
            msg = order.saveOrder();
            
            // assign the value null
            order = null;
        }
    }
}
/*
 * SAXProcessor.java
 * This class creates a SAX processor. It uses DocumentProcessor
 * class for event handling. The predefined XML file is parsed.
 * The success and error messages are captured into msg string and returned
 * to the calling JSP.
 */
/* Copyright © 2007 Aptech Software Limited. All rights reserved.
 */
/*
 * @author Vincent
 */

package Aptech.Customers;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXProcessor {
    
    private String msg = "";
    
    public String Save() {
        
        // Create a class instance for event handling
        DocumentProcessor docObject = new DocumentProcessor();
        
        // Obtain a factory instance
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            
            // Create a parser
            SAXParser parser = spf.newSAXParser();
            
            // Call the parse method. The first parameter is the
            // xml document reference and second parameter refers
            // to the event handler
            parser.parse(new File("CustomerOrders.xml"), docObject);
            
            // Capture all messages in msg string
            msg = docObject.getMsg();
            msg += "Successfully added XML data";
        }catch (Exception e) {
            msg = e.getMessage();
        }
        // return("in save");
        return msg;
    }
}
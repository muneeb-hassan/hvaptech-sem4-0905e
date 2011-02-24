/*
 * SAXAttributeProcessing.java
 *
 * This example demonstarates the use of SAX parser for a simple search
 * in XML document.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */

package Aptech.JavaXML.Module2;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXAttributeProcessing extends DefaultHandler {
    
    static String user = null;
    static boolean found = false;
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java SAXExample tomcat-users.xml username");
            System.exit(1);
        }
        // Copy the user name argument to a local variable
        user = args[1];
        
        // Create class instance for SAX event handler
        SAXAttributeProcessing saxObject = new SAXAttributeProcessing();
        
        // Create a factory instance
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            // Create parser
            SAXParser parser = spf.newSAXParser();
            // Parse the document
            parser.parse(new File(args[0]), saxObject);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    /*
     * The parser calls this method at the beginning of each element during
     * document parsing
     */
    public void startElement(String namespaceURI, String simpleName,
            String qualifiedName, Attributes attributeList) throws SAXException {
        // check if current element is 'user'
        if (qualifiedName.equals("user")){
            // get the value of username attribte
            String name = attributeList.getValue("username");
            // check if the username value matches the command line input user name
            if (name.equals(user)) {
                // if found, print the message on the user console
                found = true;
                System.out.println("User " + user + " is a registered user on Tomcat Server");
            }
        }
    }
    /*
     * The parser calls this method whenever it encounters the end of
     * document during processing.
     */
    public void endDocument() throws SAXException {
        // if the user was not found, print an appropriate message
        if (!found) {
            System.out.println("User " + user + " is not currently defined on Tomcat Server");
        } 
    }
}

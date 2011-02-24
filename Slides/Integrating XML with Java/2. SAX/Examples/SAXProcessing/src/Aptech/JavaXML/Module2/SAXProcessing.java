/*
 * SAXProcessing.java
 *
 * This example demonstarates the use of SAX parser.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 */

package Aptech.JavaXML.Module2;

/*
 * Author : Vincent
 */

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXProcessing extends DefaultHandler {
    
    static int count = 0;
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SAXProcessing tomcat-users.xml");
            System.exit(1);
        }
        // Create a class instance for event handling
        SAXProcessing saxObject = new SAXProcessing();
        
        // Obtain a factory instance
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            // Create a parser
            SAXParser parser = spf.newSAXParser();
            // Call the parse method by passing xml document reference and the event handler
            parser.parse(new File(args[0]), saxObject);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
     /*
      * The parser calls this method at the beginning of each element
      * that it encounters during parsing
      */
    public void startElement(String namespaceURI, String simpleName, String qualifiedName, Attributes attributeList) throws SAXException {
        if (qualifiedName.equals("user")) {
            count++;
        }
    }
    /*
     * The parser calls this method whenever it encounters the end of documnet
     * during parsing
     */
    public void endDocument() throws SAXException {
        System.out.println(count + " users defined on Tomcat Server");
    } 
}
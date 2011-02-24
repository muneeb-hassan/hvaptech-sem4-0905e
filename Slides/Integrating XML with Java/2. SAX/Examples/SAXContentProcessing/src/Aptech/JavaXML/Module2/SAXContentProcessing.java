/*
 * SAXContentProcessing.java
 *
 * This example demonstarates the use of SAX parser for processing
 * the contents of a XML document.
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

public class SAXContentProcessing extends DefaultHandler {
    
    static String user = null;
    static boolean found = false;
    static boolean IDfound = false;
    static boolean namefound = false;
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SAXContentProcessing StudentList.xml");
            System.exit(1);
        }
        
        // Create class instance for SAX event handler
        SAXContentProcessing saxObject = new SAXContentProcessing();
        
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
     * Parser calls this method whenever it encounters character data
     * during document processing
     */
    public void characters(char[] buf, int off, int len) throws SAXException {
        // Create a String object from the character buffer
        String str = new String(buf, off, len);
        // Trim white space at the end
        str = str.trim();
        
        // print student ID if found
        if (IDfound) {
            System.out.print("ID: " + str);
            IDfound = false;
        }
        // print student name if found
        if (namefound) {
            System.out.println("\tName: " + str);
            namefound = false;
        }
    }
    /*
     * The parser calls this method at the beginning of each element during
     * document parsing
     */
    public void startElement(String namespaceURI, String simpleName,
            String qualifiedName, Attributes attributeList) throws SAXException {
        // If ID element is found, set the flag to true
        if (qualifiedName.equals("ID")) {
            IDfound = true;
        }
        // If name element is found, set the flag to true
        if (qualifiedName.equals("name")) {
            namefound = true;
        } 
    }
}

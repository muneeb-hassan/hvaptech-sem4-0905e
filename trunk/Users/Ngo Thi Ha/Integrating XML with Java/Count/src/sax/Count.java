/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sax;

/**
 *
 * @author Windy
 */

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Count extends DefaultHandler{
        int count = 0;
	int countStudent=0;
	public static String e;


	public Count() {
		int count = 0;
	}

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String s = new String(ch, start, length);
	System.out.println("Character is: " + s);
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
	System.out.println("Total class: " + count);
	System.out.println("Total Student: " + countStudent);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println("End Element of " + qName);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("name")) {
			countStudent++;
		}
		if (qName.equals("class")) {
			System.out.println("Class name: " + attributes.getValue(0));
			count++;
		}
    }
}

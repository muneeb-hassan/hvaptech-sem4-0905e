package sax;

import java.io.File;

import javax.xml.parsers.SAXParserFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		javax.xml.parsers.SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		Count handler = new Count();
		parser.parse(new File("list.xml"), handler);
	}

}

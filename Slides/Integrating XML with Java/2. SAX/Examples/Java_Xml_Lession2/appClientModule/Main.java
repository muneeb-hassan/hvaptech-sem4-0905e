import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class Main {
	public static void main(String[] args) {
		String xmlPath = args[0];
		String tagName = args[1];
		if (tagName == null)
			System.exit(0);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXMyHandler myHandler = new SAXMyHandler(tagName);
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(new File(xmlPath), myHandler);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}
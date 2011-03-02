import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class EntityHandlerExample extends DefaultHandler implements LexicalHandler {
	
	static boolean entityFound = false;
	static boolean commenFound = false;
	static boolean dtdFound = false;
	static boolean cdataFound = false;
	static int countEntity = 0;
	static int countCommen = 0;
	static int countDTD = 0;
	static int countCDATA = 0;

	@Override
	public InputSource resolveEntity(String publicId, String systemId)
			throws IOException, SAXException {
		// TODO Auto-generated method stub
		System.out.println("Resolved Entity - publicID " + publicId + " SystemID " + systemId);
		return null;
	}

	@Override
	public void comment(char[] arg0, int arg1, int arg2) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(new String(arg0));
		
	}

	@Override
	public void endCDATA() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("End CDATA");
	}

	@Override
	public void endDTD() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("End Entity");
	}

	@Override
	public void startCDATA() throws SAXException {
		// TODO Auto-generated method stub
		if (cdataFound == false)
			cdataFound = true;
		countCDATA++;
	}

	@Override
	public void startDTD(String arg0, String arg1, String arg2)
			throws SAXException {
		if (!dtdFound)
			dtdFound = true;
		countDTD++;
	}

	@Override
	public void startEntity(String arg0) throws SAXException {
		// TODO Auto-generated method stub
		if (!entityFound)
			entityFound = true;
		countEntity++;
		System.out.println("Entity: " + arg0);
	}
		
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Usage: java EntityHandlerExample XMLdocument");
			System.exit(0);
		}
		EntityHandlerExample handlerExample = new EntityHandlerExample();
		//SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setProperty("http://xml.org/sax/properties/lexical-handler", handlerExample);
			reader.setEntityResolver(handlerExample);
			reader.parse(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (entityFound)
			System.out.println("Count of Entity: " + countEntity);
		else
			System.out.println("No Entity is not found.");
		if (dtdFound)
			System.out.println("Count of DTD: " + countDTD);
		else
			System.out.println("No DTD is not found.");
		if (cdataFound)
			System.out.println("Count of CDATA: " + countCDATA);
		else
			System.out.println("No CDATA is not found.");
	}
}

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXMyHandler extends DefaultHandler {
	static int count = 0;
	String handleTagName;
	
	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println(new String(ch, start, length));
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("End document");
		System.out.println("Count of " + handleTagName + " : " + count);
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("End element: " + name);
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Start document");
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		if (name.equals(handleTagName)) {
			++count;
		}
		System.out.println("Start element: " + name);
		for (int i = 0; i < attributes.getLength(); i++) {
			System.out.println("Attribute " + (i + 1) + ": " + attributes.getValue(i));
		}
	}

	
	
	/**
	 * 
	 * @param handleTagName
	 */
	public SAXMyHandler(String handleTagName) {
		this.handleTagName = handleTagName;
	}
}

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class MoveXmlNode {
	static Node aNode;
	static Node bNode;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("No xml file to processes.");
			System.exit(0);
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.parse(new File(args[0]));
			moveNode(xml);
			// Output xml
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StringWriter stringWriter = new StringWriter();
			StreamResult result = new StreamResult(stringWriter);
			DOMSource domSource = new DOMSource(xml);
			transformer.transform(domSource, result);
			String xmlSring = stringWriter.toString();
			System.out.println(xmlSring);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void moveNode(Node node) {
		// null value indicates that we have reached a leaf node.
		if (node == null)
			return;
		
		// Check if the current element is 'b'
		if (node.getNodeName().equals("b")) {
			if (bNode == null)
				bNode = node;
			NodeList bChildren = bNode.getChildNodes();
			for (int i = 0; i < bChildren.getLength(); i++) {
				if (!bChildren.item(i).equals("#text"))
					if (aNode != null) {
						// insert clone of children of b node before first child node of a.
						aNode.insertBefore(
								bChildren.item(i).cloneNode(true),
								aNode.getFirstChild());
					}
			}
			// Remove b node.
			bNode.getParentNode().removeChild(bNode);
		} else if (node.getNodeName().equals("a")) {
			if (aNode == null)
				aNode = node;
		}
		
		// Get children of the current node.
		NodeList children = node.getChildNodes();
		// Recurse through the function to visit each node.
		int i = 0;
		while (i < children.getLength()) {
			moveNode(children.item(i++));
		}
	}
}

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.w3c.dom.traversal.TreeWalker;
import org.xml.sax.SAXException;


public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please specify the xml document location.");
			System.exit(0);
		}
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = builder.parse(new File(args[0]));
			DOMImplementation impl = builder.getDOMImplementation();
			if (!impl.hasFeature("traversal", "2.0")) {
				System.out.println("A DOM implementation that supports" +
						" traversal is required.");
				return;
			}
			DocumentTraversal traversal = (DocumentTraversal) doc;
			NodeIterator iterator = traversal.createNodeIterator(
					doc,
					NodeFilter.SHOW_ALL,
					null,
					true);
			Node node;
			while ((node = iterator.nextNode()) != null) {
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					if (node == doc.getFirstChild()) {
						System.out.println("\t-" + node.getNodeName());
						continue;
					}
					if (node.getTextContent().indexOf("\n") != -1)
						System.out.println("\t\t-" + node.getNodeName());
					else
						System.out.println("\t\t\t-" + node.getNodeName());
				}
			}
			/*TreeWalker treeWalker = traversal.createTreeWalker(
					doc,
					NodeFilter.SHOW_ALL,
					null,
					true);
			
			traverseNodes(treeWalker, "");*/
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

	private static void traverseNodes(TreeWalker treeWalker, String indent) {
		Node currentNode = treeWalker.getCurrentNode();
		if (currentNode.getNodeType() == Node.ELEMENT_NODE)
			System.out.println(indent + "- " + ((Element) currentNode).getTagName());
		for (Node n = treeWalker.firstChild(); n != null; n = treeWalker.nextSibling()) {
			traverseNodes(treeWalker, indent + "\t");
		}
		treeWalker.setCurrentNode(currentNode);
	}
	
}
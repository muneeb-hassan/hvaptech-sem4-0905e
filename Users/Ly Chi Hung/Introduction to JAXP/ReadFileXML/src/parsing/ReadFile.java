package parsing;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadFile {
	
	static Document doc;
    static int count = 0;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
            // Declare file object
            File f = new File("src//student.xml");
            // Obtain factory instance
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Obtain builder instance
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Parse document
            doc = db.parse(f);
            // Get the number of 'user' elements
            getStudentList(doc);
            // print the result
            System.out.println("No of student: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	private static void getStudentList(Node node) {
        // null value indicates that we have reached a leaf node
        if (node == null) {
            return;
        }
        // Increament the count if a 'user' node is found
        if (node.getNodeName().equals("Stu_name")) {
            count++;
        }
        // Get children of the current node
        NodeList children = node.getChildNodes();
        // recurse through the function to visit each node
        int i = 0;
        while (i < children.getLength()) {
        	getStudentList(children.item(i++));
        }
    } 


}

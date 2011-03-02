package dom_example;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test01 {

	/**
	 * @param args
	 */
	static Document doc;
	static int count=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			File openfile = new File("D:/Student.xml");
			doc = db.parse(openfile);
			
			//Root node
			System.out.println("Root name : " + doc.getDocumentElement().getNodeName());
			
			/*Xac dinh node can lay gia tri 
			Xac dinh bao nhieu Node Child ten Student
			In gia tri cua tat ca cac Note trong Student*/
			NodeList nodeLst = doc.getElementsByTagName("Student");
			System.out.println("Tong so hoc sinh : " + nodeLst.getLength());
			for(int i=0; i<nodeLst.getLength(); i++){
				Node myNode = nodeLst.item(i);
				System.out.println(myNode.getNodeName());
				System.out.println(myNode.getTextContent());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void CountStudent(Node nodeList){
		
	}
}

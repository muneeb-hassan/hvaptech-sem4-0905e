/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package A4_ModifyXML;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Leung
 */
public class ModifyXML {

    private String xmlFilePath = "sample.xml";
    private String bNodeName = "b";
    private String aNodeName = "a";
    private String modifedFilePath = "modifiedSample.xml";

    public void process() {
        File sampleFile = new File(xmlFilePath);

        try {
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = docBuilder.parse(sampleFile);

            System.out.println("Sample Xml file content : ");
            OutputFormat format = new OutputFormat(doc);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);

            StringWriter out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(doc);
            System.out.println(out.toString());

            // Get doc root element
            Element rootElement = doc.getDocumentElement();

            // Get root childs
            if (rootElement.hasChildNodes()) {

                // Get bNode childs
                Node bNode = rootElement.getElementsByTagName(bNodeName).item(0);
                Node aNode = rootElement.getElementsByTagName(aNodeName).item(0);

                // Moving childs of bNode to aNode
                if (bNode.hasChildNodes()) {
                    NodeList bNodeChilds = bNode.getChildNodes();
                    for (int i = 0; i < bNodeChilds.getLength(); i++) {
                        // Move to aNode
                        Node currNode = bNodeChilds.item(i);
                        if (currNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementNode = (Element) currNode;
                            // Insert to aNode
                            aNode.insertBefore(elementNode, aNode.getFirstChild());
                            // Remove from bNode
                        }
                    }
                }
                
                System.out.println("==================================");
                System.out.println("Modified Sample Xml file content : ");
                out.getBuffer().setLength(0); // clear the writer

                serializer.serialize(doc);
                System.out.println(out.toString());

                try {
                    Transformer trans = TransformerFactory.newInstance().newTransformer();
                    trans.setOutputProperty(OutputKeys.INDENT, "yes");

                    //initialize StreamResult with File object to save to file
                    File modifiedFile = new File(modifedFilePath);
                    StreamResult result = new StreamResult(new FileOutputStream(modifiedFile));
                    DOMSource source = new DOMSource(doc);
                    trans.transform(source, result);
                    System.out.println("The modified sample xml file saved .");
                } catch (TransformerException ex) {
                    Logger.getLogger(ModifyXML.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SAXException ex) {
            Logger.getLogger(ModifyXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModifyXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ModifyXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new ModifyXML().process();
    }
}

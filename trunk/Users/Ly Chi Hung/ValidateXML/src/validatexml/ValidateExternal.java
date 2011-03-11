

package validatexml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import error.SimpleErrorHandler;

public class ValidateExternal{

    public static void main(String[] args) {
    	String xml = "";
    	String schema = "";
    	if(args[0]!=null){
    		xml = args[0];
    	}
    	if(args[1]!=null){
    		schema = args[1];
    	}
    	
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            factory.setValidating(false);
            factory.setNamespaceAware(true);

            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

            factory.setSchema(schemaFactory.newSchema(new Source[] {new StreamSource(schema.trim())}));

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new SimpleErrorHandler());
            builder.parse(new InputSource(xml.trim()));        
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

<%--
Document:    Index.jsp
Author:      Vincent
This JSP validates the specified XML document against a specified schema. It
uses the DOM validator to validate the document. On success, it prints an
appropriate message to the user. On error, it prints the error message on
the user terminal.

Before running the program ensure that XML data file (CustomerOrders.xml)
and the schema file (CustomerOrders.xsd) are available in Tomcat installation folder. 
C:\Program Files\Apache Software Foundation\Tomcat 5.5\ 
--%>
<%-- Copyright © 2007 Aptech Software Limited. All rights reserved.--%>
<html>
    <%@ page contentType="text/html" %>
    <%@ page import="javax.xml.*" %>
    <%@ page import="javax.xml.parsers.*" %>
    <%@ page import="javax.xml.transform.*" %>
    <%@ page import="javax.xml.transform.stream.*" %>
    <%@ page import="javax.xml.transform.dom.*" %>
    <%@ page import="javax.xml.validation.*" %>
    <%@ page import="org.w3c.dom.*" %>
    <%@ page import="org.xml.sax.*" %>
    <%@ page import="java.io.*" %>
    
    <body>
        <%

            // declare a string object str and assign null to it
            String str = "";
            try {

                // create an object of DocumentBuilder class
                DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();

                // parse an XML document into a DOM tree
                Document document = parser.parse(new File("CustomerOrders.xml"));

                // create a SchemaFactory capable of understanding WXS schemas
                SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                
                // create an object of Source class
                Source schemaFile = new StreamSource(new File("CustomerOrders.xsd"));
                
                // load a WXS schema, represented by a Schema instance
                Schema schema = factory.newSchema(schemaFile);
                
                // create a Validator instance, which can be used to validate an instance document
                Validator validator = schema.newValidator();
                
                // validate the DOM tree
                validator.validate(new DOMSource(document));
            } catch (Exception ex) {
                str = ex.getMessage() + "<br/>";
            } finally {
                // if there are no errors, str remains null
                if (str.equals(""))
                    str = "Document is valid";
            }
        %>
        <%-- output message to the user --%>
        <%=str%><br/>
    </body>
</html>
<%--
Document:    Index.jsp
Author:      Vincent
--%>
<%--
This JSP processes the CustomerOrders XML document to count the number of 
orders currently available for execution. 

Before running the program ensure that XML data file (CustomerOrders.xml)
is available in Tomcat installation folder. 
C:\Program Files\Apache Software Foundation\Tomcat 5.5\ 
--%>
<%-- Copyright © 2007 Aptech Software Limited. All rights reserved.--%>
<html>
    <%@ page contentType="text/html" %>
    <%@ page import="javax.xml.parsers.*" %>
    <%@ page import="org.w3c.dom.*" %>
    <%@ page import="java.io.*" %>
    
    <%-- Instantiate the OrderCounter --%>
    <jsp:useBean id="orders" 
    class="Aptech.OrderCounter" />
    <body>
        <%
            String str = "";
            try {

                // create an object of DocumentBuilder class
                DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();

                // parse an XML document into a DOM tree
                Document document = parser.parse(new File("CustomerOrders.xml"));

                // call the iterative method to count number of orders
                orders.CountOrders(document);

                // retrieve the number of orders
                int count = orders.getCount();

                // create a message string for the user
                str = "Number of orders: " + count;
            } catch (Exception ex) {

                // in case of error, set the error message for output
                str = ex.getMessage();
            }
        %>
        <%-- output message to the user --%>
        <%=str%><br/>
    </body>          
</html>
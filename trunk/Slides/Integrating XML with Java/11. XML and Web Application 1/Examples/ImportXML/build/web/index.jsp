<%--
Document:    Index.jsp
Author:      Vincent
This JSP adds the data from XML document into SQL Server database.
JSP instantiates SAXProcessor Java class and calls its Save method. 
The SAXProcessor passes the SAX events to DocumentProcessor event handler.
The event handler creates a Order object for each Customer element 
encountered in the document. The process initializes the fields of the 
Order with the data obtained from the subelements of Customer element. 
The Order object eventually uses DAO class to store the data into SQL Server.

Before running the program ensure that XML data file called CustomerOrders.xml
is available in Tomcat installation folder. 
C:\Program Files\Apache Software Foundation\Tomcat 5.5\CustomerOrders1.xml 
--%>
<%--Copyright © 2007 Aptech Software Limited. All rights reserved. --%>

<html>
    <%@ page contentType="text/html" %>
    <%@ page import="Aptech.Customers.*" %>    
       
    <%-- Instantiate the Processor bean --%>
    <jsp:useBean id="SAXProcessor" 
    class="Aptech.Customers.SAXProcessor" />
    
    <body>
        Adding XML data to SQL Server database ...<br/>         
        
        <%-- call the processor's save method to save data to database --%>
        <%=SAXProcessor.Save()%> 
    </body>
</html>
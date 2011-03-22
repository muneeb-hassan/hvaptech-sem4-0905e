<%--
Document:    Index.jsp
Author:      Vincent

Description: This JSP displays the list of customer orders in tabular form. 
The page picks up all active orders from SQL Server database. The retrieved
data is first put into XML format. Applying a stylesheet to this XML data
converts it into HTML which is then presented to the user. 

--%>
<%-- Copyright © 2007 Aptech Software Limited. All rights reserved.--%>

<%@ page contentType="text/xml" %>
<%@ page import="Aptech.Customers.*" %>

<%-- Instantiate the OrderBean --%>
<jsp:useBean id="orders" 
class="Aptech.Customers.OrderBean" />

<%-- Retreive all orders into a vector --%>
<%
    java.util.Iterator orderList = orders.getOrders();
    Order trade = null;
%>

<%-- Create an XML declaration --%>
<?xml version="1.0" encoding="UTF-8"?>

<%-- Set up the stylesheet for transformation.--%>
<?xml:stylesheet type="text/xsl" href="OrderProcessing.xslt" version="1.0" encoding="UTF-8"?>


<%-- For all orders generate the XML fragment --%>
<customers>
  <% while (orderList.hasNext()) { %>
    <% trade = (Order)orderList.next(); %>
    <customer>
      <name><%= 
      trade.getName() %></name>
      <item><%=
      trade.getItem() %></item>
      <quantity><%=
      trade.getQuantity() %></quantity>
      <price><%= 
      trade.getPrice() %></price>
    </customer>
  <% } %>
</customers>

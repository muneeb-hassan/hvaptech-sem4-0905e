<%--
 * GeneralPurpose.jsp
 *
 * This program uses general purpose tags in the core tag library.
 *  
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 --%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
 * @author vincent
 *
 --%>
 <%-- Declaring an array of cars --%>   
<% String[] cars = { "Ferrari", "Porsche", "Toyota" }; %>

<%-- Assigns values to the variables in scope --%> 
<c:set var="simple" value="${2+1}" scope="page" />
<c:set var="bike" value="Ferrari" scope="page" />

<%-- Creating and setting the object referred to by the variables
 into a context accessible from the page--%>  
<% pageContext.setAttribute("Example", "CoreTag",PageContext.PAGE_SCOPE); %>
<HTML>
    <HEAD>
        <TITLE>Using Core Tag Library</TITLE>
    </HEAD>
    <BODY>
   <%--Provides output --%>
        There is a <c:out value="${pageScope.simple}"/> car. The Name is Ferrari <br/>
        <UL>
            
             </BODY>
</HTML>

<%--
 * DecisionMaking.jsp
 *
 * This program uses DecisionMaking tags in the core tag library.
 *  
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 --%>
<%--
 * @author vincent
 *
 --%>
  <%-- Declaring an array of cars --%>   
<% String[] cars = { "Ferrari", "Porsche", "Toyota" }; %>

<%-- Assigns values to the variables in scope --%> 
<c:set var="simple" value="${2+1}" scope="page" />
<c:set var="car" value="Honda" scope="page" />

<%-- Creating and setting the object referred to by the variables
 into a context accessible from the page--%>  
<% pageContext.setAttribute("Example", "CoreTag",PageContext.PAGE_SCOPE); %>
<HTML>
    <HEAD>
        <TITLE>Using Core Tag Library</TITLE>
    </HEAD>
    <BODY>
    <%--Provides output --%>
     There is <c:out value="${pageScope.simple}"/> a car. The Name is Honda: <br/>
      <%-- Removes the variable and the scope  --%>
      <c:remove var="simple" scope="page"/>
       <%-- Checking of the condition --%>
        <c:if test="${pageScope.Example == 'CoreTag'}">
            <c:set var="Success" value="true" scope="page" />
        </c:if>
         <%-- Gives the output if the condition is true --%>
        <c:choose>
            <c:when test="${pageScope.Success == true}">
                Successfully Shown the Name.
            </c:when>
          </c:choose>
    </BODY>
</HTML>
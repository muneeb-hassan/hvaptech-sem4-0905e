<%--
 * Iteration.jsp
 *
 * This program uses Iteration tags in the core tag library.
 *  
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 --%>
<%--
 * @author vincent
 *
 --%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%-- Declaring an array of cars --%>   
<% String[] cars = { "Ferrari", "Porsche", "Toyota" }; %>
<%-- Assigns values to the variables in scope --%>
<c:set var="simple" value="${2+1}" scope="page" />
<c:set var="bike" value="Kawasaki:Honda;Ducati|BMW" scope="page" />
<%-- Creating and setting the object referred to by the variables
 into a context accessible from the page--%>  
<% pageContext.setAttribute("Example", "CoreTag",PageContext.PAGE_SCOPE); %>
<HTML>
    <HEAD>
        <TITLE>Using Core Tag Library</TITLE>
    </HEAD>
    <BODY>
    <%--Print "There are 3 cars. The Names are:"  --%>
        There are <c:out value="${pageScope.simple}"/> cars. The Names are: <br/>
        
         Shows the names of the cars --%>
        <UL>
            <c:forEach var="car" items="<%= cars %>">
                <LI><c:out value="${car}" />
            </c:forEach>
            
        </UL>
        The Names of the Bikes are: <br/>
        <%-- Iterate over a collection of tokens separated by user-specified delimiters--%>
        <c:forTokens items="${pageScope.bike}" delims=":;|" var="bikenames">
            <UL>
                <LI> <c:out value="${bikenames}" /> <br />
            </UL>
        </c:forTokens>
        
        <%-- Removes the variable and the scope  --%>
        <c:remove var="simple" scope="page"/>
        
        <%-- Checking of the condition --%>
        <c:if test="${pageScope.Example == 'CoreTag'}">
            <c:set var="Success" value="true" scope="page" />
        </c:if>
        
         <%-- Gives the output if the condition is true --%>
        <c:choose>
            <c:when test="${pageScope.Success == true}">
                Successfully Shown the Names
            </c:when>
            <c:otherwise>
                Unsuccessful To Show the Names
            </c:otherwise>
        </c:choose>
    </BODY>
</HTML>
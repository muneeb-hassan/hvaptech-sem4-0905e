<%--
* Bill.jsp
*
* This program demonstrates the changes of property of a JavaBean.
* 
* Copyright © 2007 Aptech Software Limited. All rights reserved.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language = "java" %>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%--
* @ author vincent
--%>
<html>
<body>
<h1 align = "center">Welcome to Optech </h1>
<jsp:useBean id = "beanalias" scope = "session" class = "Mybean.Billing" />
<jsp:setProperty name = "beanalias" property = "registrationcost" value ="300" />
<jsp:setProperty name = "beanalias" property = "quantity" value = "5" />
<p>
Cost of each registration is : <jsp:getProperty name = "beanalias" property ="registrationcost"/><br/>
Total number of employees registered :<jsp:getProperty name = "beanalias" property= "quantity" /><br/>
<br/>
<%
int cost = beanalias.getRegistrationcost();
int quantity = beanalias.getQuantity();
int total = cost*quantity;
out.println("Total amount to be paid: Rs. "+total+"/-");
%>
<br/><br/>
</p>
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>


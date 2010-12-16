<%--
* Session.jsp
*
* This program demonstrates the use of session object in JSP.
* 
* Copyright © 2007 Aptech Software Limited. All rights reserved.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page language="java" %>
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
   <%
      //It tests the pageContext Attribute
if (pageContext.getAttribute("pageCount")==null) {
    pageContext.setAttribute("pageCount", new Integer(0));
}
//It tests the session Attribute
if (session.getAttribute("sessionCount")==null) {
    session.setAttribute("sessionCount",new Integer(0));
}
//It tests the application Attribute
if (application.getAttribute("appCount")==null) {
    application.setAttribute("appCount",new Integer(0));
}

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
  <h1>Session,Application,PageContext</h1>
    <% 
       //In count object the pageCount is stored
Integer count = (Integer)pageContext.getAttribute("pageCount");
//The pageCount value is incrementing by 1
pageContext.setAttribute("pageCount", new Integer(count.intValue()+1));
//In count2 object the sessionCount is stored
Integer count2 = (Integer)session.getAttribute("sessionCount");
//The sessionCount value is incrementing by 1
session.setAttribute("sessionCount",new Integer(count2.intValue()+1));
//In count3 object the appCount is stored
Integer count3 = (Integer)application.getAttribute("appCount");
//The sessionCount value is incrementing by 1
application.setAttribute("appCount",new Integer(count3.intValue()+1));
%>
 <%--
The value of Page count is displayed
--%>
<b>Page Count = </b>
<%=pageContext.getAttribute("pageCount")%>
<%--
The value of session count is displayed
--%>
<br/><b>Session count = </b>
<%=session.getAttribute("sessionCount")%>
<%--
The value of app count is displayed
--%>
<br/><b>Application count = </b>
<%=application.getAttribute("appCount")%>
<%--
The time is displayed
--%>
<br/><b>Time = </b>
<%=new java.sql.Time(System.currentTimeMillis()) %>
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

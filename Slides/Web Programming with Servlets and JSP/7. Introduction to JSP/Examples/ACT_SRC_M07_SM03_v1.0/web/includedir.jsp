<%--
 * includedir.jsp
 *
This program demonstrates the include directive to include the code from another jsp file index.jsp.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 --%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%-- 
    @ auhthor vincent
--%>
<html>
    <head><title>Include Directive JSP Page.</title></head>
    <body>
        <font size="5"><%="This program includes the index.jsp file" %></font>		                
        <%@include file="index.jsp" %><br/>
    </body>
</html>   


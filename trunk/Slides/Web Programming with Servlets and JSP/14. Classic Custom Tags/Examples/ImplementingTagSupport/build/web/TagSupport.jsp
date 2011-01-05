<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the tag library descriptor file of
 the custom tag used in this JSP page.
--%>

<%@taglib uri="/WEB-INF/tlds/EmptyTag.tld" prefix="emptytag"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TagSupport Class Implementation</title>
    </head>
    <body bgcolor="Blue">
 <h1><font color="Red">Empty Custom Tag Implementing TagSupport class </font>
 </h1>
    <font color="Green" face="impact" size="10">
    <%--The empty custom tag is called here--%>
    <emptytag:EmptyTag></emptytag:EmptyTag>
    </font> 
    </body>
</html>

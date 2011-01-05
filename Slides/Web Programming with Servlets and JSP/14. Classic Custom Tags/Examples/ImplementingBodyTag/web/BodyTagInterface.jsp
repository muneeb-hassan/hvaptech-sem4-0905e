<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%--
The taglib directive below imports the tag library descriptor file of the 
custom tag used in this JSP page. 
--%>
<%@taglib uri="/WEB-INF/tlds/BodyTag.tld" prefix="bodytag"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BodyTag Implementation</title>
    </head>
    <body>
    <h1>Outside Tag</h1>
    This statement is outside the classic custom tag.
    <%--The tag is called here--%>
    <br><bodytag:Interface  count="2">
        <h1>Inside Tag</h1>
        <br>These statements are displayed using tag handler which implements 
            BodyTag Interface.
        <%--Displays the current system time--%>
        <br>Current time: <%= new java.util.Date() %>
        <%--Displays the host name--%>
        <br>Requesting hostname: <%= request.getRemoteHost() %>
    </bodytag:Interface>
    </body>
</html>

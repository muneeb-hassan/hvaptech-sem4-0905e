<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the tag library descriptor of the custom
tag used in this JSP page.
--%>

<%@taglib uri="/WEB-INF/tlds/UpperCase.tld" prefix="uppercase"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custom tag Handler With JSP Codes</title>
    </head>
    <body>
    <h1> Custom tag Handler With JSP Codes </h1>
    This message is displayed without using the handler <br>
    <%--Custom tag is called--%>
    <br><uppercase:UpperCase>
        These following information are displayed using tag handler:
        <OL>
           <%--This gives the current system time--%>
           <LI>Current time: <%= new java.util.Date() %>
           <%--This provides the host name--%>
           <LI>Requesting hostname: <%= request.getRemoteHost() %>
           <%--This provides the current session Id--%>
           <LI>Session ID: <%= session.getId() %>
        </OL>
    </uppercase:UpperCase>
    </body>
</html>

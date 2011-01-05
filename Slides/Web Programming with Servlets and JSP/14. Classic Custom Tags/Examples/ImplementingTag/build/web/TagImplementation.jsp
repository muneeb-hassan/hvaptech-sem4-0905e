<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%--
The taglib directive below imports the tag library descriptor file for 
the custom tag used in this JSP page.
--%>

<%@taglib uri="/WEB-INF/tlds/TagInterface.tld" prefix="taginterface"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tag Interface Implementation</title>
    </head>
    <body>
    <h1>Implementation of  Tag Interface</h1>
    <h2>
        <%--The custom tag is called here.--%>
        <taginterface:Implement></taginterface:Implement>
    </h2>
    </body>
</html>

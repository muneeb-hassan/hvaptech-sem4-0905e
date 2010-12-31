<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

 <%--The tag library descriptor file of the custom tag with attribute 
is imported--%> 

<%@taglib uri="/WEB-INF/tlds/AttributeTag.tld" prefix="attributetag"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
       <%-- The tag is called here--%>
          <attributetag:AttributeTag name="Attribute."/>       
    </body>
</html>

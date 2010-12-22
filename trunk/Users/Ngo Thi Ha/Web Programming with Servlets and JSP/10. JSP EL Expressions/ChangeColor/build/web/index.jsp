<%-- 
    Document   : index
    Created on : Dec 22, 2010, 7:33:48 PM
    Author     : Windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change BgColor Page</title>
    </head>
    <body bgcolor="${param.color}">
        <form action="index.jsp">
            <h1>Change BgColor Page</h1>
            Bgcolor: <input type="text" name="color" value="${param.color}" ><br/>
            <input type="submit" value="Change Background Color"><br/>
            Sum of 10 to 20: ${10+20}
        </form>
    </body>
</html>

<%-- 
    Document   : Login
    Created on : Dec 13, 2010, 2:36:52 PM
    Author     : DoanNX
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="j_security_check" method="post">
            username:<input type="text" name="j_username" value=""/><br>
            password:<input type="password" name="j_password" value=""/><br>
            <input type="submit" value="Login"/><br>
        </form>
    </body>
</html>

<%-- 
    Document   : index
    Created on : Dec 29, 2010, 7:11:10 PM
    Author     : Windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="index.jsp" method="Post">
            <h1>Money Exchange!</h1>
            Amount: <input type="text" name="amount"><br/>
            Currency Types <br/>
            <input type="radio" name="Names" value="vi_VN"> Vietnam <br/>
            <input type="radio" name="Names" value="en_US"> USA <br/>
            <input type="radio" name="Names" value="en_IN"> India <br/>
            <input type="submit" name="submit" value="Exchange"><br/>
            <fmt:setLocale value="${param.Names}"/>
            <fmt:formatNumber value="${param.amount}" type="currency" minFractionDigits="5"/>
            
        </form>
    </body>
</html>

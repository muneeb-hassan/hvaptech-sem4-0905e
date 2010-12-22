<%-- 
    Document   : index
    Created on : Dec 22, 2010, 7:10:34 PM
    Author     : Windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculate Avg Page</title>
    </head>
    <body>
        <form action="index.jsp">
            <h1>Calculate AVG Page</h1>
<!--            English's mark:<input type="text" name="en" value="${param["en"]}" maxlength="2">/100<br/>
            Science's mark:<input type="text" name="sci" value="${param["sci"]}" maxlength="2">/100<br/>
            History's mark:<input type="text" name="his" value="${param.his}" maxlength="2">/100<br/>
            Geography's mark:<input type="text" name="geo" value="${param.geo}" maxlength="2">/100<br/>
            Math's mark:<input type="text" name="math" value="${param["math"]}" maxlength="2">/100<br/>
            Total: ${param.en + param.sci + param.his + param.geo + param.math}<br/>
            Avg: ${(param.en + param.sci + param.his + param.geo + param.math)/500*100}<br/>-->
            Num 1: <input type="text" name="num1" value="${param["num1"]}"><br/>
            Num 2: <input type="text" name="num2" value="${param.num2}"><br/>
            Num 3: <input type="text" name="num3" value="${param.num3}"><br/>
            Total: <input type="text" value="${param["num1"] + param["num2"] + param["num3"]}"><br/>
            Avg: <input type="text" value="${(param["num1"] + param["num2"] + param["num3"])/3}"><br/>
            Percentage: <input type="text" value="${(param["num1"] + param["num2"] + param["num3"])/100}"><br/>
            <input type="submit" value="Calculate">
        </form>
    </body>
</html>

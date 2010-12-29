<%-- 
    Document   : index
    Created on : Dec 27, 2010, 8:38:19 PM
    Author     : Windy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="index.jsp" method="post">
            <h1>Product Information!</h1>
            <%! String[] productName={"Name","Dell","Hp","Sony","Acer","Asus"}; %>
            <%! String[] price={"Price","400","350","450","500","470"}; %>
            <table border="1">
                <tr>
            <c:forEach var="name" items="<%=productName%>">
                    <td><c:out value="${name}"/></td>
            </c:forEach>
            </tr><tr>
            <c:forEach var="pri" items="<%=price%>">
                <td><c:out value="${pri}"/></td>
            </c:forEach>

                </tr>
            </table>
        </form>
    </body>
</html>

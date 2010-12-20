<%--
* EmployeeList.jsp
*
* This program demonstrates the Employee data. 
* 
* Copyright © 2007 Aptech Software Limited. All rights reserved.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%--
* @ author vincent
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <h3>Welcome to Optech</h3>
    </head>
    <body>
<%--This shows the heading--%>
<h1 align="center">Optech Employee List</h1>
<%--This shows the table--%>
<table width="80%" border="0" align="center">
<tr>
<td><h3><U>EmployeeID</U></h3> </td>
<td><h3><U>EmployeeName</U></h3> </td>
</tr>
<%--This shows the data in the table--%>
<tr>
<td>8563</td>
<td>Priyabrat Robinson</td>
</tr>
<tr>
<td>9084</td>
<td>Surya Fernandes</td>
</tr>
<tr>
<td>8302</td>
<td>Mayank Dcosta</td>
</tr>
<tr>
<td>8109</td>
<td>Satish Richardson</td>
</tr>
<tr>
<td>9830</td>
<td>Jagadish Champbel</td>
</tr>
</table>
    
    
    <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
    <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>

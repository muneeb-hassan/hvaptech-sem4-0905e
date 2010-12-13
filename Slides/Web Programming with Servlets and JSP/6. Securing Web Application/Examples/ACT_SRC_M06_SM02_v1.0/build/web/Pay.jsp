<%--
* Pay.jsp
*
* This program demonstrates the salary of the employees.
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
 <HTML>
<HEAD>
<TITLE>Compensation Plans</TITLE>
<LINK REL=STYLESHEET
HREF="company-styles.css"
TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
<TR><TH CLASS="TITLE">Compensation Plans</TABLE>
<P>
This is the salary structure for employees. This is shortly incremented.
<H3>Regular Employees</H3>
Pay for medium level employee (Master's degree, eight year's
experience):
<UL>
<LI><B>2002:</B> $50,000.
<LI><B>2003:</B> $30,000.
<LI><B>2004:</B> $25,000.
<LI><B>2005:</B> $20,000.
</UL>
<% if (request.isUserInRole("executive")) { %>
 <H3>Executives</H3>
Pay for corporate executives:
<UL>
<LI><B>2002:</B> $500,000.
<LI><B>2003:</B> $600,000.
<LI><B>2004:</B> $700,000.
<LI><B>2005:</B> $800,000.
</UL>
<% } %>

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

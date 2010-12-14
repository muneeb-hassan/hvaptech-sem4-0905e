<%--
 * time.jsp
 *
 * This program greets the user with an appropriate message based on system time.
 *
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 --%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.Date"%>
<%--
* @ author vincent
--%>
 <HTML>
 <HEAD>
 <TITLE>Greeting</TITLE>
 </HEAD><BODY> <H1><font color=Red>"Welcome" </font> </H1>
 <font size="5" color= blue> 
  <%
     Calendar cal = Calendar.getInstance();
      if (cal.get(Calendar.AM_PM) == Calendar.AM) {
        out.print("Good Morning!");             
      }
      else
      {
        out.print(" Good Afternoon!");
      }
    %>
  </font>
  <br>Today's date is: <%= new java.util.Date() %>; <br>
  </BODY>
  </HTML>
    
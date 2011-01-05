<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the tag libray descriptor file for the classic
 custom tag used in this JSP page. 
--%>

<%@taglib uri="/WEB-INF/tlds/Iteration.tld" prefix="iteration"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IterationTag Implementation</title>    
    </head>
    <body>
    <h1>Implementing IterationTag Interface</h1>
    <%--The classic custom tag is called here with a welcome message--%>
     <iteration:Iteration count="10">
        
    Welcome to Classic Custom Tag Programming by IterationTag Implementation.<BR>
    
   </iteration:Iteration>
    </body>
</html>

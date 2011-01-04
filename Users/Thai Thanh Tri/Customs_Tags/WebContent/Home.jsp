<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/tlds/nest.tld" prefix="nest"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP Page</h1>
   
    <nest:IfTag> 
        
        <nest:Condition>true</nest:Condition>

        <nest:Then>The condition was True<br/></nest:Then> 
       
        <nest:ElseTag>The condition was False<br/></nest:ElseTag>
        
    </nest:IfTag>
</body>
</html>
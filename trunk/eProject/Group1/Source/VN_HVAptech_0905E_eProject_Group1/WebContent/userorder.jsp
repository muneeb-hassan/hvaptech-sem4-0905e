<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
</head>
<body>
<div id="wrapper">
	
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="menu.jsp" flush="true"/>
	<%
		try{
			String userrole=session.getAttribute("userrole").toString();
			if(userrole.isEmpty() || userrole == null){response.sendRedirect(response.encodeRedirectURL("login.jsp"));}            	
		}catch(Exception e){
			response.sendRedirect("login.jsp");	
		}	
	%>
	
    <div id="content">

  	</div>
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
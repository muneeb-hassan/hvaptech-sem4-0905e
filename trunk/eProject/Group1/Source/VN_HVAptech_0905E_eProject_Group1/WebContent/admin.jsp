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
	
	<jsp:include page="header.jsp" />
	<jsp:include page="menu.jsp" />
	
	<%
		if(session.getAttribute("userrole") == null){
			%>
			<jsp:forward page="login.jsp" />
		<%}else{
			if(!session.getAttribute("userrole").toString().equals("2")){
				%>
				<jsp:forward page="login.jsp" />
			<%
			}
		}
	%>    
	
    <div id="content">
		<ul>
        	<li><a href="feedback_admin02.jsp"> Manage Feedback</a></li>
            <li><a href="contact_admin02.jsp">Manage Contact</a></li>
            <li><a href="contact_admin01.jsp">Add new Contact</a></li>
            <li><a href="domain_admin.jsp">Manage Domain</a></li>
            <li><a href="faq_admin02.jsp">Manage FAQ</a></li>
            <li><a href="faq_admin01.jsp">Add new FAQ</a></li>
            <li><a href="projects_admin02.jsp">Manage Projects</a></li>
            <li><a href="projects_admin01.jsp">Add new Project</a></li>
            <li><a href="services_admin.jsp">Manage Services</a></li>
            <li><a href="user_admin02.jsp">Manage User</a></li>
            <li><a href="userorder.jsp">Add Order Service</a></li>
        </ul>
        
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
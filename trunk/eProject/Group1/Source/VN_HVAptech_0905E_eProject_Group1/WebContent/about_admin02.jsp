<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tblaboutus"%>
<%@page import="sessionbean.dao.AboutUsDaoRemote"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/about.css" />
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>
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

		<div id="content_top-left">
    		<img src="Images/about_img.jpg">
        </div>
        <div id="content_top-right">
        	<img src="Images/About.jpg"><p>
                	<%
						try{
						    InitialContext context = new InitialContext();
						    AboutUsDaoRemote aboutAdmin = (AboutUsDaoRemote)context.lookup("AboutUsDao/remote");
						    List<Tblaboutus> lst = aboutAdmin.getAll();
						    if(lst != null){
						        int ID = lst.size();
						        boolean flag = false;
						        while(flag==true){
						        	Tblaboutus object = aboutAdmin.findByID(ID);
						        	if(object == null){
						        		ID = ID - 1;
						        		flag = true;
						        	}else{
						        		ID = ID + 1;
						        	}
						        }
						        Tblaboutus object = aboutAdmin.findByID(ID);			                   
			                    out.println(object.getIntroduction());
			                    out.println("<p><a href=\"about_admin01.jsp?ID=" + object.getId()+ "\" name=\"sendCommand\">Edit</a></p>");
		                    }
						}catch (Exception e){
							out.print("Error system. Please contact admin");
						}
                	%>
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tblaboutus"%>
<%@page import="sessionbean.dao.AboutUsDaoRemote"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css">
<link rel="stylesheet" type="text/css" href="CSS/about.css">
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>
</head>
<body>
<div id="wrapper">
	
    <jsp:include page="header.jsp" />

	<div id="menu">
    	<ul>
        	<li><a href="index.jsp">Home</a></li>
            <li><a href="about.jsp" class="selected">About us</a></li>
            <li><a href="projects.jsp">Projects</a></li>
            <li><a href="services.jsp">Services</a></li>
            <li><a href="contact.jsp">Contact us</a></li>
            <li><a href="feedback.jsp">Feedback</a></li>
            <li><a href="faq.jsp">FAQs</a></li>
		<%
    		if(session.getAttribute("userrole") != null){
    			if(session.getAttribute("userrole").toString().equals("1")){out.print("<li><a href=\"userorder.jsp\" class=\"selected\" rel=\"menu_order\">Order</a></li>");}
    			if(session.getAttribute("userrole").toString().equals("2")){out.print("<li><a href=\"#\" class=\"selected\" rel=\"menu_admin\">Admin</a></li>");}
			}
		%>
        </ul>
    </div>
    <%
    	if(session.getAttribute("userrole") != null){
    		if(session.getAttribute("userrole").toString().equals("2")){
    			out.println("<div id=\"menu_admin\" class=\"admintabs\">");
    			out.println("<a href=\"home_admin.jsp\"> Manage Home</a>");
    			out.println("<a href=\"about_admin02.jsp\">Manage About us</a>");  			
    			out.println("<a href=\"projects_admin02.jsp\">Manage Projects</a>");
    			out.println("<a href=\"projects_admin01.jsp\">Add new Project</a>");
    			out.println("<a href=\"services_admin.jsp\">Manage Services</a>");
    			out.println("<a href=\"contact_admin02.jsp\">Manage Contact</a>");
    			out.println("<a href=\"feedback_admin02.jsp\"> Manage Feedback</a>");
    			out.println("<a href=\"domain_admin.jsp\">Manage Domain</a>");
    			out.println("<a href=\"faq_admin02.jsp\">Manage FAQ</a>");
    			out.println("<a href=\"faq_admin01.jsp\">Add new FAQ</a>");
    			out.println("<a href=\"user_admin02.jsp\">Manage User</a>");
    			out.println("<a href=\"admin_order_management.jsp\">Manage Order</a>");    
    			out.println("</div>");  
    			out.println("<script type=\"text/javascript\">");
    			out.println("tabdropdown.init(\"menu\", 0)");
    			out.println("</script>");
    		}else{
    			out.println("<div id=\"menu_order\" class=\"admintabs\">");
    			out.println("<a href=\"userorder.jsp\">Order Service</a>");
    			out.println("<a href=\"user_order_management.jsp\">Manage Order</a>");
    			out.println("</div>");  
    			out.println("<script type=\"text/javascript\">");
    			out.println("tabdropdown.init(\"menu\", 0)");
    			out.println("</script>");			
			}
    	}
	%>

	<%
		String aboutdetail="";
    	int aboutID = 0;    	
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
		        aboutdetail = object.getIntroduction();
		    }
		}catch (Exception e){
			out.print("Error system. Please contact admin.");
		}		
	%>
 
    <div id="content">
    
		<div id="content_top-left">
    		<img src="Images/about_img.jpg">
        </div>
        <div id="content_top-right">
        	<img src="Images/About.jpg"><p><%out.print(aboutdetail); %>
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
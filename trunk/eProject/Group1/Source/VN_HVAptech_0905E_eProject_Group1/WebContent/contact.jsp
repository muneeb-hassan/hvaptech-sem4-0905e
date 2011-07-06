<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.PageContactDaoRemote" %>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tblpagecontact" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/contact.css" />
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>
</head>
<body>
<div id="wrapper">
	
	<jsp:include page="header.jsp" />

	<div id="menu">
    	<ul>
        	<li><a href="index.jsp">Home</a></li>
            <li><a href="about.jsp">About us</a></li>
            <li><a href="projects.jsp">Projects</a></li>
            <li><a href="services.jsp">Services</a></li>
            <li><a href="contact.jsp" class="selected">Contact us</a></li>
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
    			out.println("<a href=\"feedback_admin02.jsp\"> Manage Feedback</a>");
    			out.println("<a href=\"contact_admin02.jsp\">Manage Contact</a>");
    			out.println("<a href=\"contact_admin01.jsp\">Add new Contact</a>");
    			out.println("<a href=\"domain_admin.jsp\">Manage Domain</a>");
    			out.println("<a href=\"faq_admin02.jsp\">Manage FAQ</a>");
    			out.println("<a href=\"faq_admin01.jsp\">Add new FAQ</a>");
    			out.println("<a href=\"projects_admin02.jsp\">Manage Projects</a>");
    			out.println("<a href=\"projects_admin01.jsp\">Add new Project</a>");
    			out.println("<a href=\"services_admin.jsp\">Manage Services</a>");
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
    <div id="content">
    	<div id="setcontent">
            <div class="content_001">
                <img src="Images/ContactBuilding.jpg">
            </div>
            <div class="content_002">
                <div class="setcontent">
                    <img src="Images/Contact.jpg">
                </div>
                <div class="setcontent">
                	<%
						try{
		                    InitialContext context = new InitialContext();
		                    PageContactDaoRemote contactCustomer = (PageContactDaoRemote)context.lookup("PageContactDao/remote");
		                    List<Tblpagecontact> lst = contactCustomer.getAll();
		                    if(lst != null){
			                    int ID = lst.size();
			                    boolean flag = false;
			                    while(flag==true){
			                    	Tblpagecontact object = contactCustomer.findByID(ID);
			                    	if(object == null){
			                    		ID = ID - 1;
			                    		flag = true;
			                    	}else{
			                    		ID = ID + 1;
			                    	}
			                    }
			                    Tblpagecontact object = contactCustomer.findByID(ID);
			                    out.println(object.getIntrodution());
		                    }
		                    
						}catch (Exception e){
							out.print("Loi cap nhat he thong");
						}
                	%>
            	</div>
        	</div>
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    			out.println("<a href=\"userorder.jsp\">Add Order Service</a>");    
    			out.println("</div>");  
    			out.println("<script type=\"text/javascript\">");
    			out.println("tabdropdown.init(\"menu\", 0)");
    			out.println("</script>");
    		}
    	}
	%> 
    <div id="content">
    
		<div id="content_top-left">
    		<img src="Images/about_img.jpg">
        </div>
        <div id="content_top-right">
        	<img src="Images/About.jpg"><p>
            Our goal is to bring to you the finest design and decorating ideas from the most 
            beautiful homes in North America so that you can pick and choose those details 
            that best suit your personal taste... special ideas that will help make your house a home!
    
            <P>Every picture has a story... whether you're thinking about renovating, remodeling, 
            decorating a new house or redecorating your existing home, perhaps with new furniture, 
            different window treatments or maybe just a color change...you've come to the right place! 
            Our site is devoted to inspirational home ideas that you can choose, save, and email to a 
            friend or supplier. The getdecorating photo collection reflects the latest in design and building 
            trends from the leading interior designers and builders in the country.
            You'll see the most contemporary aspects of architecture, new home products 
            and interior design available anywhere. Search, sort and view thousands of images 
            including fully-furnished kitchens, bathrooms, master bedrooms, pools, patios, landscaping and much, much, more. </P>
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
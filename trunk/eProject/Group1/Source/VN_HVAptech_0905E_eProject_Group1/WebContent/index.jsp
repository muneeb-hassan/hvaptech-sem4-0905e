<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/index.css" />
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>
</head>
<body>

<script type="text/javascript">
	tabdropdown.init("menu", 3)
</script>

<div id="wrapper">
  <jsp:include page="header.jsp" />     

	<div id="menu">
    	<ul>
			<li><a href="index.jsp" class="selected">Home</a></li>
			<li><a href="about.jsp">About us</a></li>
			<li><a href="projects.jsp">Projects</a></li>
			<li><a href="services.jsp">Services</a></li>
			<li><a href="contact.jsp">Contact us</a></li>
			<li><a href="feedback.jsp">Feedback</a></li>
			<li><a href="faq.jsp">FAQs</a></li>
            <%
            	try{
            		String userrole=session.getAttribute("userrole").toString();
            		if(userrole.equals("1")){out.print("<li><a href=\"userorder.jsp\" class=\"selected\" rel=\"menu_order\">Order</a></li>");}
            		if(userrole.equals("2")){out.print("<li><a href=\"admin.jsp\" class=\"selected\" rel=\"menu_admin\">Admin</a></li>");}
            	}catch(Exception e){
            		
            	}	
            %>
        </ul>
    </div>
    
 	<div id="menu_admin" class="admintabs">
		<a href="feedback_admin02.jsp"> Manage Feedback</a>
		<a href="contact_admin02.jsp">Manage Contact</a>
		<a href="contact_admin01.jsp">Add new Contact</a>
		<a href="domain_admin.jsp">Manage Domain</a>
		<a href="faq_admin02.jsp">Manage FAQ</a>
		<a href="faq_admin01.jsp">Add new FAQ</a>
		<a href="projects_admin02.jsp">Manage Projects</a>
		<a href="projects_admin01.jsp">Add new Project</a>
		<a href="services_admin.jsp">Manage Services</a>
		<a href="user_admin02.jsp">Manage User</a>
		<a href="userorder.jsp">Add Order Service</a>     
	</div>    

    	
    <div id="content">
    
    	<div id="content_top">
        	<div class="content_top_01">
                <div class="content_top_01A"><img src="Images/Content_top.jpg" /></div>
                <div class="content_top_01B">
                    Designs, colors, paints, trends -- you name it, we've got it. Learn the basics of decorating or search 
                    room by room or ideas to decorate your home or your business. 
                </div>
          	</div>
            <div class="content_top_02"><img src="Images/Landscaping.jpg" width="680px" height="460px" title=""/></div>
        </div>

      <div id="content_top_right">
        	<div class="content_top_right_01">Today's Top Decorating Sites</div>
            <ul>
            	<li><img src="Images/img161.jpg"> <a href="http://www.homeandfamilynetwork.com">Better Homes and Gardens Decorating</a></li>
            	<li><img src="Images/img183.jpg"> <a href="http://www.homeandfamilynetwork.com">The Decorating Diva, LLC</a></li>
            	<li><img src="Images/img187.jpg"> <a href="http://www.homeandfamilynetwork.com">Pure Style Home</a></li>
            	<li><img src="Images/img192.jpg"> <a href="http://www.homeandfamilynetwork.com">Your home, only better.</a></li>
                <li><img src="Images/img158.jpg"> <a href="http://www.homeandfamilynetwork.com">BH&G Home Improvement.</a></li>
            </ul>
        </div>
        <div id="content_center">
        	<div class="content_center_top">JOIN AND START DECORATING TODAY</div>
            <table>
            	<tr>
                	<td width="250"><img src="Images/House 005.jpg"></td>
                    <td width="430">Decorating the House</td>
                </tr>
                <tr>
                <tr>
                	<td><img src="Images/Office.jpg"></td>
                    <td>Decorating the Offices</td>
                </tr>
                <tr>
                	<td><img src="Images/Restaurant.jpg"></td>
                    <td>Decoration of the Restaurants </td>
                </tr>
                <tr>
                	<td><img src="Images/Communical.jpg"></td>
                    <td>Decoration of the Community Halls</td>
                </tr>
            </table>
        </div>   
	</div>
		
	<jsp:include page="footer.jsp" />

</div>
</body>
</html>
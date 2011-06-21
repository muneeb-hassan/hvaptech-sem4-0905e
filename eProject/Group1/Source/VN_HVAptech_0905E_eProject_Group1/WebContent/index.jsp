<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/index.css" />
</head>
<body>
<div id="wrapper">

	<jsp:include page="header.jsp" flush="true"/>
      
	<div id="menu">
    	<ul>
        	<li><a href="index.jsp">Home</a></li>
            <li><a href="about.jsp">About us</a></li>
            <li><a href="projects.jsp">Projects</a></li>
            <li><a href="services.jsp">Services</a></li>
            <li><a href="contact.jsp">Contact us</a></li>
            <li><a href="feedback.jsp">Feedback</a></li>
            <li><a href="faq.jsp">FAQs</a></li>
        </ul>
    </div>
	
    <div id="content">
    
    	<div id="content_top">
        	<div class="content_top_01">
                <div class="content_top_01A"><img src="Images/Content_top.jpg" /></div>
                <div class="content_top_01B">
                    Designs, colors, paints, trends -- you name it, we've got it. Learn the basics of decorating or search 
                    room by room for ideas to decorate your home or your business. 
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
		
	<jsp:include page="footer.jsp" flush="true"/>

</div>
</body>
</html>
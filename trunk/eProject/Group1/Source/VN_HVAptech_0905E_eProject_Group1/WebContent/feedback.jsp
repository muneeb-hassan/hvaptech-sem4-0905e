<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/feedback.css" />

</head>
<body>
<div id="wrapper">
	
    <div id="header">	
        <div class="setImage">
            <img src="Images/Logo.jpg" width="376" height="108" alt="Logo" longdesc="Images/Logo.jpg">
        </div>
        <div class="setLogin">
            <a href="register.jsp">Register</a> | <a href="login.jsp">Login</a>
        </div>
	</div>
    
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
        <form action="" method="post">
        	<fieldset id="feedbackform">
            	<div class="setfeedback">
            		<img src="Images/Feedback.jpg" />
                </div>
                <div class="setfeedback">
                    <label for="fullname">Full name</label>
                    <input name="fullname" id="fullname" class="input" type="text" maxlength="50" style="width: 280px; ">
                </div>
                <div class="setfeedback">
                    <label for="address">Address</label>
                    <input name="address" id="address" class="input" type="text" maxlength="100" style="width: 280px; ">
            	</div>
                <div class="setfeedback">
                    <label for="phone">Phone</label>
                    <input name="phone" id="phone" class="input" type="text" maxlength="20">
            	</div>
                <div class="setfeedback">
                    <label for="email">Email</label>
                    <input name="email" id="email" class="input" type="text" maxlength="50" style="width: 280px; ">
            	</div>
                <div class="setfeedback">
                  <label for="feedback">Comment</label>
                    <textarea name="feedback" class="input" id="feedback" style="width: 336px; height: 197px"></textarea>
            	</div>
                <div class="setfeedback">
                	<div class="setcenter">
                        <input name="submit" type="submit" class="submit" value=" " style="background-image:url(Images/2btn_submit.gif);
                            width: 90px; height: 35px" />
                    </div>
                </div>                      
            </fieldset>
        </form>
  	</div>
	
    <div id="footer">
		<div class="setposition">
	    	<div class="setposition1"> ©Copyright 2011, Alluring Decors. All Rights Reserved.</div> 
	        <div class="setposition2">
	        	<div style="width:80px; float:left;">Design by</div> 
	        	<div style="width:200px; float:left;">
	            	Nguyen Viet Thang<br/>
	        		Truong Quoc Toan<br/>
	        		Nguyen The Anh
	            </div>
	        </div>
        </div>
    </div>
    
</div>
</body>
</html>
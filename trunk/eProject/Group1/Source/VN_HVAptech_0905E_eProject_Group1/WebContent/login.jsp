<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/login.css" />
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
        <fieldset id="loginform">
        	<div class="setloginform">
        		<img src="Images/login-header.jpg" width="371" height="65">
        	</div>
            <div class="setloginform">
                <label for="email">Email</label>
                <input name="email" id="email" type="text" class="input" maxlength="100" style="width: 220px; ">
            </div>
            <div class="setloginform">
                <label for="password">Password</label>
                <input name="password" id="password" type="password" class="input" maxlength="20" style="width: 220px; ">
            </div>
            <div class="setloginform">
            	<div class="setcenter">
                    <input name="submit" type="submit" class="submit" style="background-image:url(Images/loginbutton.gif); 
                        width: 178px; height: 35px" value=" " />
                </div>
            </div>
            <div class="setloginform">
            	<div class="setcenter">
            		<a href="register.jsp">Or, click here to<br /><b>CREATE NEW ACCOUNT</b></a>
                </div>
            </div>
        </fieldset>
        </form>
  	</div>
	
    <div id="footer">
		<div class="setposition">
	    	<div class="setposition1"> �Copyright 2011, Alluring Decors. All Rights Reserved.</div> 
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
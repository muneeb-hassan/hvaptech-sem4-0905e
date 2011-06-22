<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/register.css" />
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
        <form action="" method="post">
        	<fieldset id="registerform">
            	<div class="setregister">
            		<img src="Images/createaccount_t.gif" />
                </div>
                <div class="setregister">
                    <label for="fullname">Full name</label>
                    <input name="fullname" id="fullname" class="input" type="text" maxlength="50" style="width: 280px; ">
                </div>
                <div class="setregister">
                    <label for="address">Address</label>
                    <input name="address" id="address" class="input" type="text" maxlength="100" style="width: 280px; ">
            	</div>
                <div class="setregister">
                    <label for="phone">Phone</label>
                    <input name="phone" id="phone" class="input" type="text" maxlength="20">
            	</div>
                <div class="setregister">
                    <label for="email">Email</label>
                    <input name="email" id="email" class="input" type="text" maxlength="50" style="width: 280px; ">
            	</div>
                <div class="setregister">
                    <label for="password">Password</label>
                    <input name="password" id="password" class="input" type="password" maxlength="20">  
                </div>
                <div class="setregister">
                	<div class="setcenter">
                        <input name="submit" type="submit" class="submit" value=" " style="background-image:url(Images/submitinfo.gif);
                            width: 155px; height: 35px" />
                    </div>
                </div>                      
            </fieldset>
        </form>
  	</div>
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
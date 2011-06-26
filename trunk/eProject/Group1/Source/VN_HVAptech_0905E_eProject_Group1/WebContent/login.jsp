<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/login.css" />
<script type="text/javascript" language="Javascript" src="Scripts/checkvalidate.js"></script>
<script type="text/javascript">
	function ValidateForm(){
		var emailID=document.Loginform.email
		var passwordID = document.Loginform.password
		
		if(checkemail(emailID.value) == false){
			alert("Email Invalid.Please check your Email again.")
			emailID.focus()
			return false
		}else{
			if(checknull(passwordID.value) == false){
				alert("Input your password.")
				return false
			}
		}

		return true
 }
</script>
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
    	<form name="Loginform" action="checkuserlogin" method="post" onSubmit="return ValidateForm()">
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
            <div class="setloginform">
            	<%
                	String messageLogin="";
                	try{
                		messageLogin = session.getAttribute("messageLogin").toString();
                	}catch (Exception e){
                		messageLogin="";
                	}
                	if(!messageLogin.isEmpty() || messageLogin != null)
                		out.print(messageLogin);
                		
                	session.removeAttribute("messageLogin");
                %>
            </div>
        </fieldset>
        </form>
  	</div>
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
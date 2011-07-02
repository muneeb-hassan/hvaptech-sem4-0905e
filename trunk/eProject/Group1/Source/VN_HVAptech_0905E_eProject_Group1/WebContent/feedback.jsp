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
	
	<jsp:include page="header.jsp" flush="true"/>

	<div id="menu">
    	<ul>
        	<li><a href="index.jsp">Home</a></li>
            <li><a href="about.jsp">About us</a></li>
            <li><a href="projects.jsp">Projects</a></li>
            <li><a href="services.jsp">Services</a></li>
            <li><a href="contact.jsp">Contact us</a></li>
            <li><a href="feedback.jsp" class="selected">Feedback</a></li>
            <li><a href="faq.jsp">FAQs</a></li>
            <%
            	try{
            		String userrole=session.getAttribute("userrole").toString();
            		if(userrole.equals("1")){out.print("<li><a href=\"userorder.jsp\">Order</a></li>");}
            		if(userrole.equals("2")){out.print("<li><a href=\"admin.jsp\">Admin</a></li>");}            	
            	}catch(Exception e){
            		
            	}	
            %>
        </ul>
    </div>
	
    <div id="content">
        <form action="addDel_feedback" method="post">
        	<fieldset id="feedbackform">
            	<div class="setfeedback">
            		<img src="Images/Feedback.jpg" />
                </div>
                <div class="setfeedback">
                    <label for="fullname">Full name</label>
                    <input name="fullname" id="fullname" class="input" type="text" maxlength="50" style="width: 280px; ">
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
	
	<jsp:include page="footer.jsp" flush="true"/>
        
</div>
</body>
</html>
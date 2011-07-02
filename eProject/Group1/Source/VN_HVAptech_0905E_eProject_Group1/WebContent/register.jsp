<%@page import="javassist.bytecode.stackmap.BasicBlock.Catch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/register.css" />

<script type="text/javascript" src="Scripts/jquery-1.5.1.js"></script>
<script type="text/javascript" src="Scripts/jquery.ui.core.js"></script>
<script type="text/javascript" src="Scripts/jquery.ui.widget.js"></script>
<script type="text/javascript" src="Scripts/jquery.ui.datepicker.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="CSS/ui.theme.css" />
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		$('#datebirth').datepicker({changeYear: true});
	});
</script>     
<body>
<div id="wrapper">
	
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="menu.jsp" flush="true"/>
	
    <div id="content">
        <form action="registeruser" method="post">
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
                	<label for="sex">Sex</label>
					<input type="radio" name="sex" value="Male" id="sex_0"> Male
					<input type="radio" name="sex" value="Female" id="sex_1"> Female
                </div>
                <div class="setregister">
                    <label for="datebirth">Date of Birth</label>
                    <input name="datebirth" id="datebirth" class="input" type="text" readonly>
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
                <div class="setregister">
                	<%
                		String messageUser="";
                		try{
                			messageUser = session.getAttribute("messageUser").toString();
                		}catch (Exception e){
                			messageUser="";
                		}
                		if(!messageUser.isEmpty() || messageUser != null)
                			out.print(messageUser);
                		
                		session.removeAttribute("messageUser");
                	%>
                </div>                      
            </fieldset>
        </form>
  	</div>
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
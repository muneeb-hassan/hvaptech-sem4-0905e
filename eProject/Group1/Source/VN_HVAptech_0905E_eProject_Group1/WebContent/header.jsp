    <%
    	boolean acceptuser = false;
    	String fullname = "";
    	String useremail="";
    	String userrole = "";
    	try{
    		useremail = session.getAttribute("useremail").toString();
    		fullname = session.getAttribute("fullname").toString();
    		userrole =  session.getAttribute("userrole").toString();
    		if(useremail != null && fullname != null && userrole != null)
    			acceptuser = true;
    		if(!useremail.isEmpty() && !fullname.isEmpty() && !userrole.isEmpty())
    			acceptuser = true;
    	}catch (Exception e){
    		acceptuser = false;
    	}
    %>
    <div id="header">
    	<div class="header_Logo">
			<img src="Images/Logo.jpg" width="376" height="108" alt="Logo" longdesc="Images/Logo.jpg" />
        </div>
      	<div class="header_Login">
      		<%
      			if(acceptuser ==false){
      				out.print("<ul><li><a href=\"register.jsp\">Register</a></li><li>|</li><li><a href=\"login.jsp\">Login</a></li></ul>");
      			}else{
      				out.print("<ul><li><a href=\"logout\">Logout</a></li><li>|</li><li><a href=\"userorder.jsp\">"+ fullname +"</a></li></ul>");
      			}
      		%>
      	</div> 
	</div>
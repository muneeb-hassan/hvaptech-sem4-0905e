    <%
    	boolean acceptuser;
    	String fullname="";
    	try{
    		fullname = session.getAttribute("fullname").toString();
    		acceptuser = (Boolean)session.getAttribute("acceptuser");
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
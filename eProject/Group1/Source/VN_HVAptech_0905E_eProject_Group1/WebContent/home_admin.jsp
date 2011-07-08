<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.HomeDaoRemote"%>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tblhome"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/home_admin.css" />
<script type="text/javascript" language="Javascript" src="Scripts/checkvalidate.js"></script>
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>
</head>
<body>
<script type="text/javascript">
	function ValidateForm(){
		var formname = document.getElementById("frmUpdatehome")
		var editor = formname.editor1
		if(checknull(editor.value)==false){
			editor.focus()
			alert("Please enter information your contact")
			return false
		}
		return true
 	}
</script>
<div id="wrapper">
	
	<jsp:include page="header.jsp" />
	<jsp:include page="menu.jsp" />
	
	<%
		if(session.getAttribute("userrole") == null){
			%>
			<jsp:forward page="login.jsp" />
		<%}else{
			if(!session.getAttribute("userrole").toString().equals("2")){
				%>
				<jsp:forward page="login.jsp" />
			<%
			}
		}
	%>
	<%
    	String mainintrodution="";
    	String domainintrodution="";
    	String serviceintrodution="";
    	int homeID = 0;
    	
		try{
		    InitialContext context = new InitialContext();
		    HomeDaoRemote UpdateAdmin = (HomeDaoRemote)context.lookup("HomeDao/remote");
		    List<Tblhome> lst = UpdateAdmin.getAll();
			
		    for(Tblhome p:lst){
				mainintrodution = p.getMainintrodution();
				domainintrodution = p.getDomainintrodution();
				serviceintrodution = p.getServiceintrodution();
				homeID = p.getId();
		     }
		}catch (Exception e){
			out.print("Error system. Please contact admin.");
		}		
	%>
    <div id="content">
    	<form action="addDel_home" method="post" name="frmUpdatehome" id="frmUpdatehome" onSubmit="return ValidateForm()">
    	<div id="content_center">
        	<div class="content_01">
            	<img src="Images/Manage home.jpg" style="margin-bottom:20px;">
            </div>
        	<div class="content_01">
            	<label>Description top content</label>
                <textarea name="mainintrodution" cols="" rows="3" style="width: 500px;" class="input"><%out.print(mainintrodution);%></textarea>
            </div>
            <div class="content_01">
            	<label>Description domain</label>
                <textarea name="domainintrodution" cols="" rows="3" style="width: 500px;" class="input"><%out.print(domainintrodution);%></textarea>
            </div>
            <div class="content_01">
            	<label>Description service</label>
                <textarea name="serviceintrodution" cols="" rows="3" style="width: 500px;" class="input"><%out.print(serviceintrodution);%></textarea>
            </div>
            <div class="content_01">
            	<div class="cmd"><input name="homeID" type="hidden" value="<%out.print(homeID);%>">
            		<input name="submit" type="submit" value="Update" style="width: 92px; height: 35px">
                </div>
            </div>         
        </div>
        </form>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
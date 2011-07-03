<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.FeedBackDaoRemote" %>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tblfeedback" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/ColReorder.css" />
<link rel="stylesheet" type="text/css" href="CSS/feedbacklist.css" />
<link rel="stylesheet" type="text/css" href="CSS/Sorttable.css" />
<script type="text/javascript" src="Scripts/jquery-1.5.1.js"></script>
<script type="text/javascript" src="Scripts/ColReorder.js"></script>
<script type="text/javascript" src="Scripts/jquery.dataTables.js"></script>
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>

</head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready( function () {
				var oTable = $('#feedbacklist').dataTable( {
					"sDom": 'Rlfrtip'
				} );
			} );
		</script>
<body>
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
	
    <div id="content">
    	<div id="content_center">
        	<img src="Images/Manager feedback.jpg" class="img">
				<%
					try{
                    InitialContext context = new InitialContext();
                    FeedBackDaoRemote feedbacklist = (FeedBackDaoRemote)context.lookup("FeedBackDao/remote");
                    List<Tblfeedback> lst = feedbacklist.getAll();
                    	if(lst !=null){
                    		out.print("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" id=\"feedbacklist\" class=\"display\">");
                    		out.print("<thead>");
							out.print("<tr>");
							out.print("<th width=\"100px\">Date</th>");
							out.print("<th width=\"200px\">Fullname</th>");
							out.print("<th width=\"200px\">Email</th>");
							out.print("<th width=\"500px\">Comment</th>");
							out.print("</tr>");
							out.print("<tbody>");
	                    	for(Tblfeedback p:lst){
	                    		out.print("<tr>");
	                        	out.println("<td>" + p.getDatecreate()+ "</td>"
	                        			+ "<td>" + p.getFullname() + "</td>" 
	                        			+ "<td>" + p.getEmail()+ "</td>" 
	                        			+ "<td>" + p.getComment() + "</td>");
	                    		out.print("</tr>");
	                    	}
	                    	out.print("</tbody>");
	                    	out.print("</table>");
                    	}else{
                    		out.print("List user is empty");
                    	}
                    }catch (Exception e){
						out.print("System error.");
					}
					
                %>                	
  		</div>
    </div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
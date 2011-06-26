<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.UserDetailDaoRemote" %>
<%@page import="sessionbean.dao.LevelDaoRemote" %>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tbluserdetail" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/ColReorder.css" />
<link rel="stylesheet" type="text/css" href="CSS/userlist.css" />
<link rel="stylesheet" type="text/css" href="CSS/Sorttable.css" />
<script type="text/javascript" src="Scripts/jquery-1.5.1.js"></script>
<script type="text/javascript" src="Scripts/ColReorder.js"></script>
<script type="text/javascript" src="Scripts/jquery.dataTables.js"></script>
</head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready( function () {
				var oTable = $('#userlist').dataTable( {
					"sDom": 'Rlfrtip'
				} );
			} );
		</script>
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
				<%
					try{
                    InitialContext context = new InitialContext();
                    UserDetailDaoRemote userlist = (UserDetailDaoRemote)context.lookup("UserDetailDao/remote");
                    List<Tbluserdetail> lst = userlist.getAll();
                    	if(lst !=null){
                    		out.print("<table id=\"userlist\" class=\"display\">");
                    		out.print("<thead>");
							out.print("<tr>");
							out.print("<th>Full name</th>");
							out.print("<th>Address</th>");
							out.print("<th>Phone</th>");
							out.print("<th>Email</th>");
							out.print("<th>Active</th>");
							out.print("</tr>");
							out.print("<tbody>");
	                    	for(Tbluserdetail p:lst){
	                    		out.print("<tr>");
	                        	out.println("<td>" + p.getFullname()+ "</td>" 
	                        			+ "<td>" + p.getAddress() + "</td>" 
	                        			+ "<td>" + p.getPhone() + "</td>" 
	                        			+ "<td>" + p.getEmail() + "</td>" 
	                        			+ "<td>" + p.isIsactive() + "</td>" );
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
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
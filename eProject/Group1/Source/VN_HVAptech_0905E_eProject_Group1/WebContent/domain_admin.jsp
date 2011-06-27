<%@page import="entitybean.Tbldomain"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.DomainDaoRemote"%>
<%@page import="java.util.List" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/ColReorder.css" />
<link rel="stylesheet" type="text/css" href="CSS/domainlist.css" />
<link rel="stylesheet" type="text/css" href="CSS/Sorttable.css" />
<script type="text/javascript" src="Scripts/jquery-1.5.1.js"></script>
<script type="text/javascript" src="Scripts/ColReorder.js"></script>
<script type="text/javascript" src="Scripts/jquery.dataTables.js"></script>
</head>
		<script type="text/javascript" charset="utf-8">
			$(document).ready( function () {
				var oTable = $('#domainlist').dataTable( {
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
    	<div id="content_center">
        <form action="" method="post" name="updatedomain">
        <input name="" type="button" onClick="setvalue()">
		<%
			try{
                InitialContext context = new InitialContext();
                DomainDaoRemote domainlist = (DomainDaoRemote)context.lookup("DomainDao/remote");
                Tbldomain domain = new Tbldomain();
                List<Tbldomain>lst = domainlist.getAll();
                if(lst != null){
               		out.print("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" id=\"domainlist\" class=\"display\">");
            		out.print("<thead>");
					out.print("<tr>");
					out.print("<th width=\"340px\">Domain name</th>");
					out.print("<th width=\"80px\">Edit</th>");
					out.print("<th width=\"80px\">Delete</th>");
					out.print("</tr>");
					out.print("<tbody>");
                	for(Tbldomain p:lst){
                		out.print("<tr>");
                		out.print("<td>" + p.getDomainname() + "<input name=\"" + p.getId() + "01A\" type=\"text\">" +"</td>" );
                		out.print("<td>" + "<input type=\"button\" value=\"Edit\" onClick=\"setvalue(this.form)\">" + "</td>" );
                		out.print("<td>" + "<a href=\"Example\">Delete</a>" + "</td>" );
                		out.print("</tr>");
                	}
                	out.print("</tbody>");
                	out.print("</table>");
                }else{
                	out.print("No find record.");
                }
			}catch(Exception e){
				out.print("System error. Please come back later.");
			}
		%>
        </form>
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
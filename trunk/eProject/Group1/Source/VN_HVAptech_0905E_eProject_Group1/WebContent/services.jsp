<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.ServiceDaoRemote"%>
<%@page import="sessionbean.dao.DomainDaoRemote"%>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tbldomain" %>
<%@page import="entitybean.Tblservice" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/services.css" />
<script type="text/javascript" src="Scripts/accordition.js"></script>

</head>
<body>
<script type="text/javascript">
        $(document).ready(function() {
            $('.servicelist_content:not(:first)').hide();
            $('h1:first').addClass('active');
            $('h1').click(function() {
                $('.active').removeClass('active');
                $('.servicelist_content').slideUp('normal');
                if($(this).next('.servicelist_content').is(':hidden') == true) {
                $(this).addClass('active');
                $(this).next('.servicelist_content').slideDown('normal');
                }
            });
            $('h1').hover(function(){//over
                $(this).addClass('on');
            },function() {//out
                $(this).removeClass('on');
            });
        });
</script>
<div id="wrapper">
	
	<jsp:include page="header.jsp" flush="true"/>

	<div id="menu">
    	<ul>
        	<li><a href="index.jsp">Home</a></li>
            <li><a href="about.jsp">About us</a></li>
            <li><a href="projects.jsp">Projects</a></li>
            <li><a href="services.jsp" class="selected">Services</a></li>
            <li><a href="contact.jsp">Contact us</a></li>
            <li><a href="feedback.jsp">Feedback</a></li>
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
    
    	<div id="content_center">
        <div class="content_left">
		<%
			try{
				InitialContext context = new InitialContext();
				DomainDaoRemote ordercus = (DomainDaoRemote)context.lookup("DomainDao/remote");
				ServiceDaoRemote ordercusdetail = (ServiceDaoRemote)context.lookup("ServiceDao/remote");
								
				List<Tbldomain> lst = ordercus.getAll();
	
				for(Tbldomain p:lst){
					out.println("<h1><img src=\"Images/chair-1-icon.png\">" + p.getDomainname() + "</h1>");
					List<Tblservice> sublst = ordercus.getServicesByDomainID(p.getId());
					if(sublst != null){
						out.println("<div id=\"servicelist\" class=\"servicelist_content\">");
						for(Tblservice p1:sublst){
							out.println("<ul>");
							out.println("<li>" + p1.getDescription() + "</li>");
							out.print("</ul>");
						}
						out.println("</div>");
					}
				}
			}catch (Exception e){
				out.print("Loi he thong khong the cap nhat");
				e.printStackTrace();
			}
        %>
        </div>
        </div>
        
  	</div>
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
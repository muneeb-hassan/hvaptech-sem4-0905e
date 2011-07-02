<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.ProjectTypeDaoRemote" %>
<%@page import="sessionbean.dao.ProjectDaoRemote" %>
<%@page import="entitybean.Tblproject" %>
<%@page import="entitybean.Tblprojecttype" %>
<%@page import="java.util.List" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/project.css" />
<script type="text/javascript" src="Scripts/accordition.js"></script>
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>
</head>
<script type="text/javascript">
        $(document).ready(function() {
            $('.project_content:not(:first)').hide();
            $('h1:first').addClass('active');
            $('h1').click(function() {
                $('.active').removeClass('active');
                $('.project_content').slideUp('normal');
                if($(this).next('.project_content').is(':hidden') == true) {
                $(this).addClass('active');
                $(this).next('.project_content').slideDown('normal');
                }
            });
            $('h1').hover(function(){//over
                $(this).addClass('on');
            },function() {//out
                $(this).removeClass('on');
            });
        });
</script>
<body>
<div id="wrapper">
	
	<jsp:include page="header.jsp" flush="true"/>

	<div id="menu">
    	<ul>
        	<li><a href="index.jsp">Home</a></li>
            <li><a href="about.jsp">About us</a></li>
            <li><a href="projects.jsp" class="selected">Projects</a></li>
            <li><a href="services.jsp">Services</a></li>
            <li><a href="contact.jsp">Contact us</a></li>
            <li><a href="feedback.jsp">Feedback</a></li>
            <li><a href="faq.jsp">FAQs</a></li>
		<%
    		if(session.getAttribute("userrole") != null){
    			if(session.getAttribute("userrole").toString().equals("1")){out.print("<li><a href=\"userorder.jsp\" class=\"selected\" rel=\"menu_order\">Order</a></li>");}
    			if(session.getAttribute("userrole").toString().equals("2")){out.print("<li><a href=\"#\" class=\"selected\" rel=\"menu_admin\">Admin</a></li>");}
			}
		%>
        </ul>
    </div>
    <%
    	if(session.getAttribute("userrole") != null){
    		if(session.getAttribute("userrole").toString().equals("2")){
    			out.println("<div id=\"menu_admin\" class=\"admintabs\">");
    			out.println("<a href=\"feedback_admin02.jsp\"> Manage Feedback</a>");
    			out.println("<a href=\"contact_admin02.jsp\">Manage Contact</a>");
    			out.println("<a href=\"contact_admin01.jsp\">Add new Contact</a>");
    			out.println("<a href=\"domain_admin.jsp\">Manage Domain</a>");
    			out.println("<a href=\"faq_admin02.jsp\">Manage FAQ</a>");
    			out.println("<a href=\"faq_admin01.jsp\">Add new FAQ</a>");
    			out.println("<a href=\"projects_admin02.jsp\">Manage Projects</a>");
    			out.println("<a href=\"projects_admin01.jsp\">Add new Project</a>");
    			out.println("<a href=\"services_admin.jsp\">Manage Services</a>");
    			out.println("<a href=\"user_admin02.jsp\">Manage User</a>");
    			out.println("<a href=\"userorder.jsp\">Add Order Service</a>");    
    			out.println("</div>");  
    			out.println("<script type=\"text/javascript\">");
    			out.println("tabdropdown.init(\"menu\", 0)");
    			out.println("</script>");
    		}
    	}
	%> 	
    <div id="content">
    	<div id="content_center">
		<%
			try{
				InitialContext context = new InitialContext();
				ProjectTypeDaoRemote projectcus = (ProjectTypeDaoRemote)context.lookup("ProjectTypeDao/remote");
				ProjectDaoRemote subprojectcus = (ProjectDaoRemote)context.lookup("ProjectDao/remote");
								
				List<Tblprojecttype> lst = projectcus.getAll();
				
				for(Tblprojecttype p:lst){
					out.println("<h1> <img src=\"Images/chair-1-icon.png\">"+p.getProjectName()+"</h1>");
					List<Tblproject> get_sublst = projectcus.getProjectsByTypeID(p.getId());
					if(get_sublst != null){
						out.println("<div id=\"project\" class=\"project_content\">");
						for(Tblproject p1:get_sublst){
							out.println("<div class=\"project_content_01\">");
							out.println("<div class=\"project_content_01_A\">" + "<img src=\"Images/" + p1.getImage() + "\" width=\"200px\" height=\"134px\" alt=\"Image\">" + "<b>"+p1.getProjectname()+"</b>" + "</div>" + "<div class=\"project_content_01_B\">" + p1.getDescription()+"</div>");
							out.println("</div>");
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
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
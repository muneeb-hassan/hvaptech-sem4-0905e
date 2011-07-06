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
		<%
			try{
				InitialContext context = new InitialContext();
				ProjectTypeDaoRemote projectcus = (ProjectTypeDaoRemote)context.lookup("ProjectTypeDao/remote");
				ProjectDaoRemote subprojectcus = (ProjectDaoRemote)context.lookup("ProjectDao/remote");
								
				List<Tblprojecttype> lst = projectcus.getAll();
				
				for(Tblprojecttype p:lst){
					out.println("<h1> <img src=\"Images/chair-1-icon.png\">"+ p.getProjectName()+"</h1>");
					List<Tblproject> get_sublst = projectcus.getProjectsByTypeID(p.getId());
					if(get_sublst != null){
						out.println("<div id=\"project\" class=\"project_content\">");
						for(Tblproject p1:get_sublst){
							out.println("<div class=\"project_content_01\">");
							out.println("<div class=\"project_content_01_A\">" + "<img src=\"Images/" + p1.getImage() + "\" width=\"200px\" height=\"134px\" alt=\"Image\">" 
									+ "<b>"+p1.getProjectname()+"</b>" + "</div>" + "<div class=\"project_content_01_B\">" + p1.getDescription()
									+ "<div class=\"project01\"><a href=\"projects_admin01.jsp?ID=" + p1.getId()+ "\" name=\"sendCommand\">Edit</a>"
						+ " | " + "<a href=\"addDel_project?ID=" + p1.getId()+ "\" name=\"sendCommand\" onclick=\"return confirm('Are you sure you want to delete?')\">Delete</a></div>"+"</div>");
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
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
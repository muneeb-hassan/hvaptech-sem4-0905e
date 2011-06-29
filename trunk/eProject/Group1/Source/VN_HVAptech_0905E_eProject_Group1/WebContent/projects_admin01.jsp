<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.ProjectTypeDaoRemote" %>
<%@page import="sessionbean.dao.ProjectDaoRemote" %>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tblprojecttype" %>
<%@page import="entitybean.Tblproject" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/faq_admin.css" />
<link href="ckeditor/_samples/sample.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script src="ckeditor/_samples/sample.js" type="text/javascript"></script>
</head>
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
			
			<%
				String projectname ="";
				String description="";
				String image="";
				int ProjectTypeID = 0;
				List<Tblprojecttype> lst;
				
				InitialContext context = new InitialContext();
				ProjectTypeDaoRemote project = (ProjectTypeDaoRemote)context.lookup("ProjectTypeDao/remote");
				ProjectDaoRemote subproject = (ProjectDaoRemote)context.lookup("ProjectDao/remote");
				
				lst = project.getAll();
				
				boolean getvalue;
				getvalue = false;
				
				if(request.getParameter("ID") != null){
					int ID = Integer.parseInt(request.getParameter("ID"));
					Tblproject Editproject = subproject.findByID(ID);
					if(Editproject != null){
						projectname = Editproject.getProjectname();
						description = Editproject.getDescription();
						image = Editproject.getImage();
						ProjectTypeID = Editproject.getProjecttypeid().getId();
						getvalue = true;
					}
				}
				
			%>
			
			<div id="content_center">
            <form name="project_update" action="addDel_project" method="post">
            	<div class="faq_update_01">
               	  <label for="projecttype">Project type</label>
                    <select name="projecttype" style="width: 300px; height:25px; ">
                    	<% 
                    		for(Tblprojecttype p:lst){
                    			out.print("<option value=\"" + p.getId()+ '"'); 
                    			if(getvalue==true && p.getId() == ProjectTypeID) 
                    				out.print("selected");
                    			out.print(">" + p.getProjectName() + "</option>");
                    		}
                    	%>	
                    </select>
                </div>
                <div class="faq_update_01">
                    <label for="projectname">Project name</label>
                    <input name="projectname" type="text" id="projectname" style="width: 450px; " value="<% if(getvalue==true) out.print(projectname);%>">
                    <input name="projectID" type="hidden" value="<% if(getvalue==true) out.print(request.getParameter("ID"));%> ">
            	</div>
                <div class="faq_update_01">
                    <label for="image">Image</label>
                    <input name="image" type="text" id="image" style="width: 450px; " value="<% if(getvalue==true) out.print(image);%>">
            	</div>            	
                <div class="faq_update_01">
                	<label for="editor1">Description</label>
                	<textarea name="editor1" id="editor1" class="ckeditor" style="width: 450px; "><% if(getvalue==true) out.println(description); %></textarea>
                </div>
                <div class="faq_update_01" style="margin-top:20px; margin-bottom:20px;">
                	<input name="submit" class="submit" type="submit" <% if(getvalue==true){out.println("value=\"Update\"");}else{out.println("value=\"Insert\"");} %>value="Insert" style="width: 90px; height: 30px">
                </div>
            </form>
        </div>

  	</div>
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
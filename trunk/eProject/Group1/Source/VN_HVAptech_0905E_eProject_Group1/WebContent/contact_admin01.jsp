<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.PageContactDaoRemote" %>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tblpagecontact" %>

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
				String contactdetail="";
				InitialContext context = new InitialContext();
				PageContactDaoRemote contactAdmin = (PageContactDaoRemote)context.lookup("PageContactDao/remote");
				boolean getvalue;
				getvalue = false;
				
				if(request.getParameter("ID") != null){
					int ID = Integer.parseInt(request.getParameter("ID"));
					Tblpagecontact Editcontact = contactAdmin.findByID(ID);
					if(Editcontact != null){
						contactdetail = Editcontact.getIntrodution();
						getvalue = true;
					}
				}
				
			%>
			
			<div id="content_center">
            <form name="contact_update" action="addDel_contact" method="post">
            	<div class="faq_update_01">
                    <input name="ContactID" type="hidden" value="<% if(getvalue==true) out.print(request.getParameter("ID"));%>">
            	</div>
                <div class="faq_update_01">
                	<label for="editor1">Contact Detail</label>
                	<textarea name="editor1" id="editor1" class="ckeditor" style="width: 450px; "><% if(getvalue==true) out.println(contactdetail); %></textarea>
                </div>
                <div class="faq_update_01" style="margin-top:20px; margin-bottom:20px;">
                	<input name="submit" class="submit" type="submit" <% if(getvalue==true){out.println("value=\"Update\"");}else{out.println("value=\"Insert\"");} %>value="Insert" style="width: 90px; height: 30px">
                </div>
            </form>
        </div>

  	</div>
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
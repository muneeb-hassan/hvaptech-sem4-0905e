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
<link rel="stylesheet" type="text/css" href="CSS/contact.css" />
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
    	<div id="setcontent">
            <div class="content_001">
                <img src="Images/ContactBuilding.jpg">
            </div>
            <div class="content_002">
                <div class="setcontent">
                    <img src="Images/Contact.jpg">
                </div>
                <div class="setcontent">
                	<%
						try{
		                    InitialContext context = new InitialContext();
		                    PageContactDaoRemote contactCustomer = (PageContactDaoRemote)context.lookup("PageContactDao/remote");
		                    List<Tblpagecontact> lst = contactCustomer.getAll();
		                    if(lst != null){
			                    int ID = lst.size();
			                    boolean flag = false;
			                    while(flag==true){
			                    	Tblpagecontact object = contactCustomer.findByID(ID);
			                    	if(object == null){
			                    		ID = ID - 1;
			                    		flag = true;
			                    	}else{
			                    		ID = ID + 1;
			                    	}
			                    }
			                    Tblpagecontact object = contactCustomer.findByID(ID);
			                    out.println(object.getIntrodution());
			                    out.println("<p><a href=\"contact_admin01.jsp?ID=" + object.getId()+ "\" name=\"sendCommand\">Edit</a></p>");
		                    }
						}catch (Exception e){
							out.print("Loi cap nhat he thong");
						}
                	%>
            	</div>
        	</div>
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
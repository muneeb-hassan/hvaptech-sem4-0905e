<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.FaqDaoRemote" %>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tblfaq" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/faq_02.css" />
<script type="text/javascript" src="Scripts/accordition.js"></script>
</head>
<script type="text/javascript">
        $(document).ready(function() {
            $('p:not(:first)').hide();
            $('h1:first').addClass('active');
            $('h1').click(function() {
                $('.active').removeClass('active');
                $('p').slideUp('normal');
                if($(this).next('p').is(':hidden') == true) {
                $(this).addClass('active');
                $(this).next('p').slideDown('normal');
                }
            });
            $('h1').hover(function(){//over
                $(this).addClass('on');
            },function() {//out
                $(this).removeClass('on');
            });
        });
		function callServlet(id){
			document.faq_Update.value = "Edit"
			document.faq_Update.value = "Delete"
			document.location.href="http://localhost:8080/VN_HVAptech_0905E_eProject_Group1/faq_admin01.jsp"
		}
     </script>
<body>
<div id="wrapper">
	
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="menu.jsp" flush="true"/>
	
    <div id="content">
    	<div id="content_center">
        <h2>Most Frequently Asked Questions</h2>
        <div class="faq_content">
        
		<%
			InitialContext context = new InitialContext();
			FaqDaoRemote faqadmin02 = (FaqDaoRemote)context.lookup("FaqDao/remote");
			List<Tblfaq> lst = faqadmin02.getAll();
			for(Tblfaq p:lst)
				out.println("<div class=\"faq01\"><a href=\"faq_admin01.jsp?ID=" + p.getId()+ "\" name=\"sendCommand\">Edit</a>"
						+ " | " + "<a href=\"addDel_faq?ID=" + p.getId()+ "\" name=\"sendCommand\">Delete</a></div>"
						+ "<div class=\"faq02\">" +"<h1>" + p.getQuestion() + "</h1>" 
						+ p.getAnswer() + "</div>");
		%>
		
		</div>
        </div>
  	<% out.print(request.getAttribute("result")); %>
    </div>
	
	<jsp:include page="footer.jsp" flush="true"/>
    
</div>
</body>
</html>
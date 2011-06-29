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
	
	<jsp:include page="header.jsp" />
	<jsp:include page="menu.jsp" />
	
	<%
		if(session.getAttribute("userrole") == null){
			%>
			<jsp:forward page="login.jsp" />
		<%}
	%>
	
    <div id="content">
		<%
			try{
				InitialContext context = new InitialContext();
				DomainDaoRemote ordercus = (DomainDaoRemote)context.lookup("DomainDao/remote");
				ServiceDaoRemote ordercusdetail = (ServiceDaoRemote)context.lookup("ServiceDao/remote");
								
				List<Tbldomain> lst = ordercus.getAll();
				
				for(Tbldomain p:lst){
					out.println("<h1>" + p.getDomainname() + "</h1>");
					List<Tblservice> sublst = ordercus.getServicesByDomainID(p.getId());
					if(sublst != null){
						out.println("<div id=\"servicelist\" class=\"servicelist_content\">");
						for(Tblservice p1:sublst){
							out.println("<div class=\"servicelist_content_01\">");
							out.println(p1.getDescription());
							out.print("</div>");
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
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
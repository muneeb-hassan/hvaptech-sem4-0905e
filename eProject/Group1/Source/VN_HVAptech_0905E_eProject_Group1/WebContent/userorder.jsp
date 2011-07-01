<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.ServiceDaoRemote"%>
<%@page import="sessionbean.dao.DomainDaoRemote"%>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tbldomain" %>
<%@page import="entitybean.Tblservice" %>
<%@page import="addtocart.getService" %>
<%@page import="addtocart.getDomain" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/userorder.css" />
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

<script type="text/javascript">
	function setvalue (serviceid){
		var url;
		url = "addcart?ID=" + serviceid;
		document.location.href=url;
	}
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
								out.print("<table width=\"400px\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");
                                for(Tblservice p1:sublst){
                                    out.print("<tr>");
                                    out.print("<td width=\"340px\">" + p1.getDescription() + "</td>");
									out.print("<td>" + "<a href=\"#\" onclick=\"setvalue('" + p1.getId() + "')\"><img src=\"Images/add-to-cart.jpg\"></a>" + "</td>");
                                    out.print("</tr>");
                                }
								out.print("</table>");
                                out.println("</div>");
                            }
                        }
                    }catch (Exception e){
                        out.print("Loi he thong khong the cap nhat");
                        e.printStackTrace();
                    }
                %>
            </div>
            <div class="content_right">
            	<%
    				String username = session.getAttribute("useremail").toString();
    				String sessionServiceList = "ServiceList" + username;
    				String sessionDomainList = "DomainList" + username;
    			
            		if(session.getAttribute(sessionServiceList)!= null && session.getAttribute(sessionDomainList)!=null){
            			List<getService> ServiceList = (List<getService>)session.getAttribute(sessionServiceList);
            			List<getDomain> DomainList = (List<getDomain>)session.getAttribute(sessionDomainList);
            			for(getDomain p:DomainList ){
            				out.print("<H3>" + p.getDomainName()+"</H3>");
                			for (getService p1:ServiceList){
                				if(p.getIdDomain() == p1.getIdDomain())
                					out.print(p1.getServiceName() + "<br/>");
                			}            				
            			}

            		}
            		
            	%>
            	<a href="#" onClick="setvalue('clearcart')">Clear Cart</a>
            </div>
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
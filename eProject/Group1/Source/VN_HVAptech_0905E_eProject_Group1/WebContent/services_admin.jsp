<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.DomainDaoRemote"%>
<%@page import="sessionbean.dao.ServiceDaoRemote"%>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tbldomain"%>
<%@page import="entitybean.Tblservice"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/ColReorder.css" />
<link rel="stylesheet" type="text/css" href="CSS/servicelist.css" />
<link rel="stylesheet" type="text/css" href="CSS/Sorttable.css" />
<script type="text/javascript" src="Scripts/jquery-1.5.1.js"></script>
<script type="text/javascript" src="Scripts/ColReorder.js"></script>
<script type="text/javascript" src="Scripts/jquery.dataTables.js"></script>

</head>
<body>
	<script type="text/javascript" charset="utf-8">
		$(document).ready( function () {
			var oTable = $('#updateservicetable').dataTable( {
				"sDom": 'Rlfrtip'
			} );
		} );
	</script>
	<script type="text/javascript">
		function setvalue (service, serviceid){
			var frmsetvalue = document.getElementById("updateservice");
			frmsetvalue.service.value = domain
			frmsetvalue.serviceid.value = domainid
			frmsetvalue.submit.value="Update"
		}
		function setreset(){
			var frmsetvalue = document.getElementById("updateservice");
			frmsetvalue.submit.value="Insert"
		}
		function getdomainid(){
			var frmsetvalue = document.getElementById("updateservice");
			var url
			url = "addDel_service?ID=" + frmsetvalue.domainlist.value
			document.location.href=url
		}
	</script>
<div id="wrapper">
	
	<jsp:include page="header.jsp" />
	<jsp:include page="menu.jsp" />
    
	<%
		if(session.getAttribute("userrole") == null){
			%>
			<jsp:forward page="login.jsp" />
		<%}else{
			if(!session.getAttribute("userrole").equals("2")){
				%>
				<jsp:forward page="login.jsp" />
			<%
			}
		}
	%>    
	
    <div id="content">
        <%
    		String domainid;
    		if(session.getAttribute("domainid")!= null){
    			domainid = session.getAttribute("domainid").toString();
    			
    		}else{
    			domainid = "1";
    			session.setAttribute("domainid",domainid);
    		}
        	InitialContext context = new InitialContext();
       		DomainDaoRemote domainlist = (DomainDaoRemote)context.lookup("DomainDao/remote");
       		ServiceDaoRemote servicelist = (ServiceDaoRemote)context.lookup("ServiceDao/remote");
       		
        	List<Tbldomain>lst = domainlist.getAll();
    	%>
        
    	<div id="content_center">
    	<form action="addDel_service" method="post" name="updateservice" id="updateservice">
			<div class="content_left" id="content_left">
            	<div class="content_left_01">
	                <label for="domainlist">Select domain</label>
	                <select name="domainlist" style="width: 300px; height: 25px" class="input" onChange="getdomainid()">
	                    <% 
	                        for(Tbldomain p:lst){
	                            out.print("<option value=\"" + p.getId()+ '"'); 
	                            if(p.getId() == Integer.parseInt(domainid)) 
	                                out.print("selected");
	                                    out.print(">" + p.getDomainname() + "</option>");
	                        }
	                    %>	
	                </select>
                </div>
                <div class="content_left_01">
					<%
                    try{ 
                    	List<Tblservice> sub = domainlist.getServicesByDomainID(Integer.parseInt(domainid));
                        if(sub != null){
                            out.print("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" id=\"updateservicetable\" class=\"display\">");
                            out.print("<thead>");
                            out.print("<tr>");
                            out.print("<th width=\"390px\">Services name</th>");
                            out.print("<th width=\"80px\">Edit</th>");
                            out.print("<th width=\"80px\">Delete</th>");
                            out.print("</tr>");
                            out.print("<tbody>");
                            for(Tblservice p:sub){
                                out.print("<tr>");
                                out.print("<td>" + p.getDescription() + "</td>" );
                                out.print("<td>" + "<a href=\"javascript:void(0);\" onclick=\"setvalue('" + p.getDescription() + "','" + p.getId() + "')\">Edit</a>"+ "</td>" );
                                out.print("<td>" + "<a href=\"#\">Delete</a>" + "</td>" );
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
                </div>
            </div>
            <div class="content_right" id="content_right">
                <div class="content_right_01">
                	<label for="service">Service name</label>
                    <input name="service" type="text" style="width: 300px; " class="input">
                    <input name="serviceid" type="hidden" value="" class="input">
              	</div>
                <div class="content_right_01">
                    <input name="submit" type="submit" value="Insert" style="width: 75px; " class="button">
                    <input name="reset" type="reset" value="Reset" style="width: 75px; " class="button" onClick="setreset()">
                </div>
            </div>
		 </form>    
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
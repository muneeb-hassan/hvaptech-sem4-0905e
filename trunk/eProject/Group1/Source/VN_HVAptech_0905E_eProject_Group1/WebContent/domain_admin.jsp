<%@page import="entitybean.Tbldomain"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.DomainDaoRemote"%>
<%@page import="java.util.List" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/ColReorder.css" />
<link rel="stylesheet" type="text/css" href="CSS/domainlist.css" />
<link rel="stylesheet" type="text/css" href="CSS/Sorttable.css" />
<script type="text/javascript" src="Scripts/jquery-1.5.1.js"></script>
<script type="text/javascript" src="Scripts/ColReorder.js"></script>
<script type="text/javascript" src="Scripts/jquery.dataTables.js"></script>

</head>
		
<body>
	<script type="text/javascript" charset="utf-8">
		$(document).ready( function () {
			var oTable = $('#domainlist').dataTable( {
				"sDom": 'Rlfrtip'
			} );
		} );
	</script>
	<script type="text/javascript">
		function setvalue (domain, domainid){
			var frmsetvalue = document.getElementById("updatedomain");
			frmsetvalue.domain.value = domain
			frmsetvalue.domainid.value = domainid
			frmsetvalue.submit.value="Update"
		}
		function setreset(){
			var frmsetvalue = document.getElementById("updatedomain");
			frmsetvalue.submit.value="Insert"
		}
	</script>
<div id="wrapper">
	
	<jsp:include page="header.jsp" />
	<jsp:include page="menu.jsp" />
    
	<%
		if(session.getAttribute("userrole") == null || !session.getAttribute("userrole").equals("2")){
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
                        DomainDaoRemote domainlist = (DomainDaoRemote)context.lookup("DomainDao/remote");
                        Tbldomain domain = new Tbldomain();
                        List<Tbldomain>lst = domainlist.getAll();
                        if(lst != null){
                            out.print("<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" id=\"domainlist\" class=\"display\">");
                            out.print("<thead>");
                            out.print("<tr>");
                            out.print("<th width=\"340px\">Domain name</th>");
                            out.print("<th width=\"80px\">Edit</th>");
                            out.print("<th width=\"80px\">Delete</th>");
                            out.print("</tr>");
                            out.print("<tbody>");
                            for(Tbldomain p:lst){
                                out.print("<tr>");
                                out.print("<td>" + p.getDomainname() + "</td>" );
                                out.print("<td>" + "<a href=\"javascript:void(0);\" onclick=\"setvalue('" + p.getDomainname() + "','" + p.getId() + "')\">Edit</a>"+ "</td>" );
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
            <div class="content_right" id="content_right">
            	<form action="addDel_Domain" method="post" name="updatedomain" id="updatedomain">
                <div class="content_right_01">
                	<label for="domain">Domain name</label>
                    <input name="domain" type="text" style="width: 300px; " class="input">
                    <input name="domainid" type="hidden" value="" class="input">
              	</div>
                <div class="content_right_01">
                    <input name="submit" type="submit" value="Insert" style="width: 75px; " class="button">
                    <input name="reset" type="reset" value="Reset" style="width: 75px; " class="button" onClick="setreset()">
                </div>
            	</form>
            </div>
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
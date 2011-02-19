<%@ page contentType="text/html; charset=Cp1252" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Gift" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>



<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=Cp1252"/>
		<title></title>
	</head>
	<body>
		<html:form method="POST" action="search.do">
         <html:text property="txtSearch"></html:text><html:submit property="btnSubmit">Search</html:submit><br />
         Input gift name!<br />
         <html:submit property="btnSubmit">List</html:submit>
		</html:form>
        <table border="1">
        <tr>
        <%
        ArrayList<Gift> gifts = (ArrayList<Gift>)request.getAttribute("gifts");
        if(gifts != null){
            int i = 1;
            for (Gift gift : gifts) {
                out.println("<td>");
                out.println("ID: " + gift.getId().toString()+"<br />");
                out.println("Name: " + gift.getName().toString()+"<br />");
                out.println("Price: " + gift.getPrice().toString()+"<br />");
                out.println("Quantity: " + gift.getQuantity().toString());
                out.println("</td>");
                if(i%3==0){
                    out.println("</tr>");
                    out.println("<tr>");
                }
                i++;
            }
        }
        %>
        </tr>
        </table>
	</body>
</html:html>


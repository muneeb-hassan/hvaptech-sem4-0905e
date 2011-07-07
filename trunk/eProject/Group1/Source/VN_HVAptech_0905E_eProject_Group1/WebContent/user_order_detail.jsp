<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="javax.naming.InitialContext" %>
<%@page import="sessionbean.dao.UserDetailDaoRemote"%>
<%@page import="java.util.List" %>
<%@page import="entitybean.Tbluserdetail" %>


<%@page import="sessionbean.dao.RequestDaoRemote"%>
<%@page import="entitybean.Tblrequest"%>
<%@page import="sessionbean.dao.RequestDetailDaoRemote"%>
<%@page import="sessionbean.dao.PaymentDaoRemote"%>
<%@page import="entitybean.Tblrequestdetail"%>
<%@page import="entitybean.Tblpayment"%>
<%@page import="sessionbean.dao.ServiceDaoRemote"%>
<%@page import="entitybean.Tblservice"%>
<%@page import="entitybean.Tbldomain"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alluring Decors</title>
<link rel="stylesheet" type="text/css" href="CSS/default.css" />
<link rel="stylesheet" type="text/css" href="CSS/servicelist.css" />
<script type="text/javascript" src="Scripts/dropdowntabs.js"></script>
</head>
<body>

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
        <div>Order detail</div>
    	<form action="user_update_order" method="post" name="updateorder" id="updateorder">
			<div class="content_left" id="content_left">
                <div class="content_left_01">
			    <%
					Tblrequest order = null;
					List<Tblrequestdetail> listDetail = null;
					List<Tblpayment> listPayment = null;
					InitialContext context = new InitialContext();
                    try{
                        RequestDaoRemote requestDao = (RequestDaoRemote)context.lookup("RequestDao/remote");
                        RequestDetailDaoRemote rdDao = (RequestDetailDaoRemote)context.lookup("RequestDetailDao/remote");
                        PaymentDaoRemote paymentDao = (PaymentDaoRemote)context.lookup("PaymentDao/remote");
                        if(request.getParameter("requestid") != null && !request.getParameter("requestid").isEmpty()){
                          int requestid = Integer.parseInt(request.getParameter("requestid"));
                          if(requestid > 0){
                             order = requestDao.findByID(requestid);
                             listDetail = rdDao.getListRequestDetailsByRequestID(requestid);
                             listPayment = paymentDao.getListPaymentsByRequestID(requestid);
                          }
                          
                        }
                    }catch(Exception e){
                        out.print("System error. Please come back later.");
                    }
               	%>
                   <fieldset>
                      <legend>Request:</legend>
                      <%
                      if(order != null){
                          %>
                      <table>
                          <tr><td>Request Date:</td><td><% out.println(order.getDaterequest()); %></td></tr>
                          <tr><td>Location:</td><td><textarea name="txtLocation" style="width: 150px; " ><% out.println(order.getLocation()); %></textarea></td></tr>
                          <tr><td>Note:</td><td><textarea name="txtNote" style="width: 250px; " ><% out.println(order.getNote()); %></textarea></td></tr>
                          <tr><td>Total Payment:</td><td><% out.println(order.getTotalpayment()); %></td></tr>
                          <tr><td>Total Amount:</td><td><% out.println(order.getTotalpaidamount()); %></td></tr>
                          <tr><td>Begin Date:</td><td><% out.println(order.getDatebegin()); %></td></tr>
                          <tr><td>Complete Date:</td><td><% out.println(order.getDatecomplete()); %></td></tr>
                          <tr><td>Status:</td><td><% out.println(order.getStatus()); %></td></tr>
                          <%if("received".equals(order.getStatus()) || "waiting".equals(order.getStatus())){%>
                          <tr>
                            <td colspan="2">
                             <input type="hidden" name="txtRequestID" value="<%= order.getId() %>" >
                             <input type="submit" name="submit" value="Update" onclick="return confirm('Are you sure you want to update the request?')" />
                             <input type="submit" name="submit" value="Cancel" onclick="return confirm('Are you sure you want to cancel the request?')" />
                             <%if("waiting".equals(order.getStatus())){%>
                                <input type="submit" name="submit" value="Accept" onclick="return confirm('Are you sure you want to accept the request?')" />
                             <%} %>
                            </td>
                          </tr>
                          <%} %>
                      </table>
                      <% } %>
                   </fieldset>
                </div>
            </div>
            <div class="content_right" id="content_right">
                <div class="content_right_01">
                	<fieldset>
                      <legend>Requested Services:</legend>
                      <%
                           try{
                               ServiceDaoRemote serviceDao = (ServiceDaoRemote)context.lookup("ServiceDao/remote");
                               if(listDetail != null && listDetail.size() > 0){
                                   Tblservice service;
                                   Tbldomain domain;%>
                                   <table border="1">
                                   <tr>
                                     <td>Service Name</td>
                                     <td>Domain Name</td>
                                   </tr>
                                   <% for(Tblrequestdetail detail : listDetail){
                                       service = serviceDao.findByID(detail.getServiceid());
                                       domain = service.getDomainid();%>
                                       <tr>
                                         <td><% out.println(service.getServicename()); %></td>
                                         <td><% out.println(domain.getDomainname()); %></td>
                                       </tr>
                                   <%}%>
                                   </table>
                               <%}%>
                           <%}catch(Exception e){
                               out.print("System error. Please come back later.");
                           }%>
                   </fieldset>
              	</div>
                <div class="content_right_01">
                    <fieldset>
                      <legend>Payment:</legend>
                      <%
                      if(listPayment != null && listPayment.size() > 0){
                          %>
                      <table border="1">
                      <tr>
                        <td>Paid Amount</td>
                        <td>Paid Date</td>
                      </tr>
                        <%for(Tblpayment payment : listPayment){%>
                        <tr>
                          <td><%out.println(payment.getPaidamount()); %></td>
                          <td><%out.println(payment.getDate()); %></td>
                        </tr>
                        <%} %>
                      </table>
                      <% } %>
                   </fieldset>
                </div>
            </div>
		 </form>    
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
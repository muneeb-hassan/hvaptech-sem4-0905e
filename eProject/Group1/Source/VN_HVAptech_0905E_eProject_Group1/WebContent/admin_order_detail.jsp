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
		<%}else{
			if(!session.getAttribute("userrole").toString().equals("2")){
				%>
				<jsp:forward page="login.jsp" />
			<%
			}
		}
	%>      
    	
    <div id="content">
        <div class="img"><img src="Images/Manage Order.jpg"></div>
    	<div id="content_center">
    	    <form action="admin_update_order" method="post" name="updateorder" id="updateorder">
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
                   <fieldset id="Orderdetail">
                      <legend>Request:</legend>
                      <%
                      if(order != null){
                          %>
                      	<div class="roworder">
                        	<label>Request Date</label>
                          	<label class="input"><% out.println(order.getDaterequest()); %><label>
                        </div>
                        <div class="roworder">
                        	<label>Email</label>
							<label class="input"><% out.println(order.getEmail().getEmail()); %></label>
                        </div>
                        <div class="roworder">
                        	<label>Location</label>
                            <textarea class="input" name="txtLocation" style="width: 350px; " readonly="readonly" ><% out.println(order.getLocation()); %></textarea>
                        </div>
                        <div class="roworder">
                         	<label>Note</label>
                            <textarea class="input" name="txtNote" style="width: 350px; " readonly="readonly" ><% out.println(order.getNote()); %></textarea>
                        </div>
                        <div class="roworder">
                        	<label>Total Payment</label>
                        	<input class="input" type="text" name="txtTotalPayment" value="<% out.println(order.getTotalpayment()); %>"/>
                        </div>
                        <div class="roworder">
                        	<label>Total Amount</label>
                            <input class="input" type="text" name="txtTotalAmount" value="<% out.println(order.getTotalpaidamount()); %>"/>
                        </div>
                        <div class="roworder">
                        	<label>Begin Date</label>
                            <input class="input" type="text" name="txtDateBegin" value="<% out.println(order.getDatebegin()); %>" />
                        </div>
                        <div class="roworder">
                        	<label>Complete Date</label>
                            <input class="input" type="text" name="txtDateComplete" value="<% out.println(order.getDatecomplete()); %>" />
                        </div>
                        <div class="roworder">
                            <label>Status</label>
                            <select name="cbxStatus" class="input">
                                 <option value="received" <%if("received".equals(order.getStatus())){out.println("selected");} %>>Receive</option>
                                 <option value="canceled" <%if("canceled".equals(order.getStatus())){out.println("selected");} %>>Cancel</option>
                                 <option value="rejected" <%if("rejected".equals(order.getStatus())){out.println("selected");} %>>Reject</option>
                                 <option value="waiting" <%if("waiting".equals(order.getStatus())){out.println("selected");} %>>Waiting</option>
                                 <option value="accepted" <%if("accepted".equals(order.getStatus())){out.println("selected");} %>>Accept</option>
                                 <option value="paymentreceived" <%if("paymentreceived".equals(order.getStatus())){out.println("selected");} %>>Payment Received</option>
                                 <option value="began" <%if("began".equals(order.getStatus())){out.println("selected");} %>>Began</option>
                                 <option value="completed" <%if("completed".equals(order.getStatus())){out.println("selected");} %>>Complete</option>
                             </select>
                          </div>
                          <div class="roworder">
                             <input type="hidden" name="txtRequestID" value="<%= order.getId() %>" >
                             <input type="submit" name="submit" value="Update" onClick="return confirm('Are you sure you want to update the request?')" />
                          </div>
                      <% } %>
                   </fieldset>
                </div>
            </div>
            </form>
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
        </div>
  	</div>
	
	<jsp:include page="footer.jsp" />
    
</div>
</body>
</html>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<%@page import="vn.edu.hungvuongaptech.dao.UserDAO"%>
<f:view>
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>Home</title>
	</head>
	<body>
	<h1>User Management</h1>
	<h:dataTable var="item" value="#{userBean.userModels}" border="1" cellpadding="4">
		<h:column>
			<f:facet name="header">
				<h:outputText value="#" />
			</f:facet>
			<h:outputText value="#{item.userId}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Username" />
			</f:facet>
			<h:outputText value="#{item.username}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Email" />
			</f:facet>
			<h:outputText value="#{item.email}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Address" />
			</f:facet>
			<h:outputText value="#{item.address}" />
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Class" />
			</f:facet>
			<h:outputText value="#{item.classname}" />
		</h:column>
	</h:dataTable>

	</body>
	</html>
</f:view>
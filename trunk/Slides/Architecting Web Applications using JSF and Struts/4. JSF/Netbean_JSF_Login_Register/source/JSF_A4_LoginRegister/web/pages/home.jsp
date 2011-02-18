<%-- 
    Document   : home
    Created on : Feb 20, 2010, 7:48:41 PM
    Author     : Leung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1>JSF-Assignment4- Login Registration App</h1>
            <h:outputText value="Current User : #{sessionScope['user'].userName}"/>
            
            <center>
                <h:panelGrid columns="1" bgcolor="#e6dfde">
                    <f:facet name="header">
                        <h:outputText value="List Users"/>
                    </f:facet>

                    <h:dataTable border="1" value="#{userBean.users}" var="user">
                        <h:column>
                            <f:facet name="header"><h:outputText value="UserId"/></f:facet>
                            <h:outputText value="#{user.userId}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header"><h:outputText value="UserName"/></f:facet>
                            <h:outputText value="#{user.userName}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header"><h:outputText value="Email"/></f:facet>
                            <h:outputText value="#{user.email}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header"><h:outputText value="Added Date"/></f:facet>
                            <h:outputText value="#{user.addedDate}"/>
                        </h:column>
                    </h:dataTable>
                </h:panelGrid>
            </center>
        </body>
    </html>
</f:view>

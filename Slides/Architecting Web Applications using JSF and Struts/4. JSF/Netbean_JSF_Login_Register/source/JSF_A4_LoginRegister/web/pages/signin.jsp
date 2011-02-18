<%-- 
    Document   : signin
    Created on : Feb 21, 2010, 6:53:18 PM
    Author     : Leung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Login Page</title>
        </head>
        <body>
             <h1>JSF-Assignment4- Login Registration App</h1>
            <center>
                <h:form id="login">
                    <h:panelGrid columns="3" bgcolor="#e6dfde" border="0">
                        <f:facet name="header">
                            <h:outputText>Login Form</h:outputText>
                        </f:facet>

                        <h:panelGroup/>
                        <h:messages globalOnly="true" style="color:red"/>
                        <h:panelGroup/>

                        <h:outputLabel for="userName" value="User Name : "/>
                        <h:inputText id="userName" value="#{AuthenBean.userName}" required="true"
                                     requiredMessage="*" size="25" maxlength="25" >
                            <f:validateLength maximum="25" minimum="5"/>
                        </h:inputText>
                        <h:message for="userName"/>

                        <h:outputLabel for="password" value="Password : "/>
                        <h:inputSecret id="password" value="#{AuthenBean.password}" required="true"
                                       requiredMessage="*" size="25" maxlength="25">
                            <f:validateLength maximum="25" minimum="5"/>
                        </h:inputSecret>
                        <h:message for="password"/>

                        <h:panelGroup/>
                        <h:commandButton action="#{AuthenBean.login}" value="Login"/>
                        <h:panelGroup/>

                        <h:panelGroup/>
                        <h:outputText value="New user ?"/>
                        <h:commandLink value="Register here >>" action="newuser" immediate="true"/>
                    </h:panelGrid>
                </h:form>
            </center>
        </body>
    </html>
</f:view>
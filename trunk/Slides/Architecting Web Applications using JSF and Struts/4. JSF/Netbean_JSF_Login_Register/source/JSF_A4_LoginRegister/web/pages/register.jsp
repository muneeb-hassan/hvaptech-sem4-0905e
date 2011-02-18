<%-- 
    Document   : register
    Created on : Feb 20, 2010, 7:48:12 PM
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
            <title>User Registration</title>
        </head>
        <body>
             <h1>JSF-Assignment4- Login Registration App</h1>
            <center>
                <h:form id="register">

                    <h:panelGrid columns="2" bgcolor="#e6dfde" border="0"  >
                        <f:facet name="header">
                            <h:outputText value="User Registration Form"/>
                        </f:facet>

                        <h:panelGroup/>
                        <h:messages globalOnly="true" style="color:red"/>
                        
                        <h:outputLabel for="userName" value="User Name: "/>
                        <h:panelGroup>
                        <h:inputText id="userName" value="#{userBean.userName}" required="true"
                                     requiredMessage="*" maxlength="25" size="25">
                            <f:validateLength maximum="25" minimum="5"/>
                        </h:inputText>
                        <h:message for="userName"/>
                        </h:panelGroup>

                        <h:outputLabel for="password" value="Password : "/>
                         <h:panelGroup>
                             <h:inputSecret id="password" value="#{userBean.password}" required="true"
                                       requiredMessage="*" maxlength="25" size="25">
                            <f:validateLength maximum="25" minimum="5"/>
                        </h:inputSecret>
                        <h:message for="password"/>
                         </h:panelGroup>

                        <h:outputLabel for="email" value="Email : "/>
                         <h:panelGroup>
                        <h:inputText id="email" value="#{userBean.email}" required="true"
                                     requiredMessage="*" maxlength="50" size="25">
                        </h:inputText>
                        <h:message for="email"/>
                         </h:panelGroup>

                        <h:panelGroup/>
                        <h:commandButton value="Proceed" action="#{userBean.registerNewUser}"/>

                        <h:panelGroup/>
                        <h:commandLink action="login" value="go to login" immediate="true"/>
                    </h:panelGrid>

                </h:form>
            </center>
        </body>
    </html>
</f:view>

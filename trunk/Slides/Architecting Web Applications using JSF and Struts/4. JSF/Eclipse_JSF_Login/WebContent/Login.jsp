<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<f:view>
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <title>Login</title>
        </head>
        <body>
            <h:form>
                <h:panelGrid style="margin: auto;">

                    <f:facet name="header">
                        <h1>Login Form</h1>
                        <h:messages errorStyle="color:red;" infoStyle="color:green;" layout="table" />
                    </f:facet>

	                <h:outputText value="Username" />
	                <h:inputText value="#{loginBean.username}" />

	                <h:outputText value="Password" />
	                <h:inputSecret value="#{loginBean.password}"/>

                    <f:facet name="footer">
                        <h:commandButton value="Login" action="#{loginBean.action}" />
                        <a href="Register.jsf">Register</a>
                    </f:facet>

                </h:panelGrid>
            </h:form>
        </body>
    </html>
</f:view>
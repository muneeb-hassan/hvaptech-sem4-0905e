<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<f:view>
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
            <title>Register</title>
        </head>
        <body>
            <h:form>
                <table style="margin: auto;">
                	<tr>
                		<td colspan="2">
                			<h1>Register Form</h1>
                			<h:messages errorStyle="color: red;" layout="table" />
                		</td>
                	</tr>
                    <tr>
                        <td>Username</td>
                        <td><h:inputText value="#{registerBean.username}" validator="#{registerBean.validateUsername}" required="true" requiredMessage="Username not allow null" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><h:inputSecret value="#{registerBean.password}" validator="#{registerBean.validatePassword}" required="true" requiredMessage="Password not allow null" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><h:inputText value="#{registerBean.email}" validator="#{registerBean.validateEmail}" required="true" requiredMessage="Email not allow null" /></td>
                    </tr>
                    <tr>
                        <td>Class</td>
                        <td><h:inputText value="#{registerBean.classname}" validator="#{registerBean.validateClass}" required="true" requiredMessage="Class not allow null" /></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><h:inputText value="#{registerBean.address}" validator="#{registerBean.validateAddress}" required="true" requiredMessage="Address not allow null" /></td>
                    </tr>
                    <tr>
                    	<td></td>
                    	<td>
                    		<h:commandButton action="#{registerBean.registerAction}" value="Register" />
                    	</td>
                    </tr>
                </table>
		    </h:form>
        </body>
    </html>
</f:view>
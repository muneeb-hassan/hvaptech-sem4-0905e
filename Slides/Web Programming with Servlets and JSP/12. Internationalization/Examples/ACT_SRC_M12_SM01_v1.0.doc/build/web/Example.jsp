<%--
 * ResourceBundle.jsp
 *
 * This program uses resource bundling for internationalization of servlets.
 *  
 * Copyright © 2007 Aptech Software Limited. All rights reserved.
 --%>
<%--
 * @author vincent
 *       
<%-- Setting of type of content --%>
<%@ page contentType="text/html" %>

<%-- Setting tag library type and uri --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<% request.setCharacterEncoding("utf-8");%>

<%-- Testing the condition and setting of locales --%>
<c:if test="${param.language == 'en'}">
    <fmt:setLocale value="en" scope="session"/>
</c:if>
<c:if test="${param.language == 'sv'}">
    <fmt:setLocale value="sv" scope="session" />
</c:if>
<c:if test="${param.language == 'de'}">
    <fmt:setLocale value="de" scope="session" />
</c:if>
<c:if test="${empty param.language || param.language == 'vi_VN'}">
    <c:out value="vao tieng viet"/>
    <fmt:setLocale value="vi_VN" scope="session" />
</c:if>

<%-- Setting of Resource Bundle --%>
<fmt:setBundle basename="input" var="inputBundle" scope="session"/>
<fmt:setBundle basename="input" scope="session" />

<%-- Formatting message and date --%>
<html>
    <head>
        <title>
            <fmt:message key="title" />
        </title>
    </head>
    <body bgcolor="white">
        <h1>
            <fmt:message key="title" />
        </h1>
        <fmt:message key= "select_language" />
        <form action= "Example.jsp">
            <c:set var= "currLang" value="${inputBundle.locale.language}" />
            <c:out value="${inputBundle.locale.language}"/>
            <input type= "radio" name="language" value="vi_VN" <c:if test="${currLang == 'vi_VN'}">checked</c:if>>
            <fmt:message key="vietnam" /><br>
            <input type= "radio" name="language" value="en" <c:if test="${currLang == 'en'}">checked</c:if>>
            <fmt:message key="english" /><br>
            <input type= "radio" name="language" value="sv" <c:if test="${currLang == 'sv'}">checked</c:if>>
            <fmt:message key="swedish" /><br>
            <input type="radio" name="language" value="de" <c:if test="${currLang == 'de'}">checked</c:if>>
            <fmt:message key="german" /><br>
            <p>
            <input type="submit" value="<fmt:message key="new_language" />">
        </form>
        <form action="process.jsp" method="post">
            <fmt:message key="date" /><br>
            <br>
            <jsp:useBean id="now" class="java.util.Date" />
            <input type="text" name="date">
            (<fmt:formatDate value="${now}" dateStyle="full" />)
            <p>
            <fmt:message key="number" /><br>
            <br>
            <input type=?text? name=?number?>
            (<fmt:formatNumber value="1000.9" pattern="####.00"/>)
            <p>
            <input type="submit" value="<fmt:message key="submit" />">
        </form>
    </body>
</html>
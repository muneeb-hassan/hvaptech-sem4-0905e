<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit xml</title>
</head>
<body>
<h1>Edit Xml document</h1>
<form action="UploadXmlController" method="post" enctype="multipart/form-data">
	<input type="file" name="xml_doc" />
	<input type="submit" value="Upload" />
	<c:if test="${not empty requestScope.error}">
        <span style="color: red; clear: both;">
            ${ requestScope.error }
        </span>
    </c:if>
	<c:if test="${not empty sessionScope.xml_name}">
		<table>
			<tr>
				<td>Current XML:</td>
				<td><b>${ sessionScope.xml_name }</b></td>
			</tr>
			<tr>
				<td>Size in bytes:</td>
				<td><b>${ sessionScope.xml_size }</b></td>
			</tr>
			<tr>
			     <td align="right" colspan="2">
			         <input type="submit" name="btnSubmit" value="Save" />
			     </td>
			</tr>
			<tr>
			     <td>
			         <a href="<%= request.getContextPath() %>/saved_xml.xml">View modified xml</a>
			     </td>
			</tr>
		</table>
		<textarea name="tatXml" rows="25" cols="100" style="font-family: monospace; font-size: 13px; clear: both;">
			<c:out value="${sessionScope.xml_doc}" />
		</textarea>
	</c:if>
</form>
</body>
</html>
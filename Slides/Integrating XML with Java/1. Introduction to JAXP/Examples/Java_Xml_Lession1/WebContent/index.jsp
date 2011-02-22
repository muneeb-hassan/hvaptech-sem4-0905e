<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Parse xml</title>
</head>
<body>
<h1>Parse Xml document</h1>
<form action="UploadXmlController" method="post" enctype="multipart/form-data">
	<input type="file" name="xml_doc" />
	<input type="submit" value="Upload" />
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
				<td>Parse node:</td>
				<td>
					<input type="text" name="txtNode" />
					<input type="submit" value="Parse" />
				</td>
			</tr>
			<tr>
				<td>Node count result:</td>
				<td><b><%= request.getAttribute("nodeCount") == null ? 0 : request.getAttribute("nodeCount") %></b></td>
			</tr>
		</table>
		<textarea rows="25" cols="100" readonly="readonly" style="font-family: monospace; font-size: 13px;">
			<c:out value="${sessionScope.xml_doc}" />
		</textarea>
	</c:if>
</form>
</body>
</html>
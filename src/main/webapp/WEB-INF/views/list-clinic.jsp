<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Clinics</title>
</head>
<body>
<h3>List of Clinics</h3>
<ul>
	<c:forEach var="clinic" items="${clinics}">
	<li>${clinic}</li>
	</c:forEach> 
</ul>
</body>
</html>
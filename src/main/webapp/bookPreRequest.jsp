<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>PreRequest Book</title>
<link rel="stylesheet" href="assets/css/bookprerequest.css">
</head>
<body>

<fieldset id="register">
<legend></legend>

	
	<h3><c:out value="${preRequestStatus}" /></h3>
	<button><a href="logout.jsp">logout</a></button>
	<button><a href="user.jsp">User</a></button>
</fieldset>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/bookunavailable.css">
<title>Book Unavailable</title>
</head>
<body>

<fieldset id="register">
<legend></legend>

<span class="badge bg-danger">The Book is not available</span><br>
<a href="bookPrerequest">Prerequest Book</a><br><br>
<a href="user.jsp">Back to user Page</a><br><br>
<a href="bookShowUser">Back to view Books</a><br><Br>
<button><a href="logout.jsp" id="but">Logout</a></button>
</fieldset>

</body>
</html>
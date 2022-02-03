<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.library.dao.impl.*"
	import="com.library.model.*"
	import="com.library.exception.InvalidReturnException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<title>Book Return</title>
<link rel="stylesheet" href="assets/css/returnbook.css">
</head>
<body>

	<div class="topnav">
		<h2 style="float: left;">Library Management</h2>
		<a href="user.jsp">Home</a> 
		<a href="logout.jsp">Logout</a>
	</div>
	<h1>The Books To be Returned</h1>
	<fieldset id="register">
		<legend></legend>
		<form action="bookReturn">


			<c:forEach var="returnBook" items="${returnBookList}">
${returnBook.bookTitle}&emsp;&ensp;<a
					href="bookReturn?bookreturn=${returnBook.bookTitle}">Return
					Book</a>
				<br>
				<br>

			</c:forEach>



		</form>
	</fieldset>
</body>
</html>
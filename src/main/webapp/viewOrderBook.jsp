<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.dao.impl.*" import="com.library.model.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<title>Ordered Books</title>
<link rel="stylesheet" href="assets/css/vieworder.css">
</head>
<body>

	<div class="topnav" >
	<h1 style="float:left;color:white;">Library Management</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<h3>Ordered Book List</h3>

		<table class="container">
		<caption>
		</caption>
		<tr>
		<th id="head"><strong>BookName</strong></th>
		<th id="head"><strong>Author</strong></th>
		<th id="head"><strong>Status</strong></th>
		<th id="head"><strong>Add Book</strong></th>
		</tr>
	<c:forEach var="orderBook" items="${adminOrderBook}">
			<tr>
			<td>${orderBook.bookName }</td>
			<td>${orderBook.author }</td>
			<td>${orderBook.status }</td>
			<c:set var="sent" value="sent" />
			<c:if test="${orderBook.status eq sent}">
			<td><button style="font-size:large;width:100px;"><a href="addOrderBook?orderBookName=${orderBook.bookName}&orderAuthorName=${orderBook.author}" style="text-decoration:none;">Add Book</a></button></td>
			</c:if>
			</tr>
	</c:forEach>
	</table>
	

		
	
	
	


</body>
</html>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.connection.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List of Available Books</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/availablebooklist.css">
</head>
<body>

<div class="topnav" >

  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  <h1 style="float:left;">Library Management</h1>
  
  
</div>
<h2>Available Book List</h2>
<div class="container-fluid">
<table class="table table-hover" style="font-size:larger;">
<caption></caption>
<tr>
<th id="head">Book Name</th>

<th id="head1">Category</th>
<th id="head2">Author</th>
<th id="head3">Rack Number</th>
<th id="head4">Price</th>
<th id="head5">PreRequest</th>

</tr>

<c:forEach var="books" items="${availableBookList }">					
			<tr>
<td>${books.bookTitle}</td>
<td>${books.category}</td>
<td>${books.author}</td>
<td>${books.rackNum}</td>
<td> ${books.price}</td>
<td> ${books.prerequest}</td>
</tr>	
				
</c:forEach>		
		
			</table>
			</div>

</body>
</html>
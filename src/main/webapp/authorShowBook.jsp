<%@page import="com.library.model.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.library.util.*" import ="java.util.List" import ="com.library.test.*" import="java.sql.*" import="com.library.dao.impl.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/authorshowbook.css">
</head>
<body>

<div class="topnav" >
<h1 style="float:left;">Library Management</h1> 
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<h2>Book List</h2>
<div class="container-fluid">
<table class="table table-hover" style="font-size:larger;">
<caption></caption>
<tr>
<th id="head1"><h3>BookName</h3></th>
<th id="head2"><h3>Category</h3></th>
<th id="head3"><h3>Author</h3></th>
</tr>



<c:forEach var="books" items="${booksList}">
<tr>
<td>${books.bookTitle}</td>
<td>${books.author}</td>
<td>${books.category}</td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>
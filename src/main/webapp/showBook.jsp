<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.library.connection.*" import ="java.util.List" import ="com.library.test.*" import="java.sql.*" import="com.library.model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Show Book</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/showbook.css">
</head>
<body>



<div class="topnav" >
<h1 style="float:left;"> Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<div class="container-fluid">
<form action="bookName" method="post">
<table class="table table-hover" style="font-size:larger;">
<caption></caption>
<tr>
<th id="head">BookName</th>
<th id="head">Author</th>
<th id="head">Category</th>
<th id="head">Borrow</th>

</tr>

<c:forEach var="books" items="${booksList}">
<tr>
<td>${books.bookTitle}</td>
<td>${books.author}</td>
<td>${books.category}</td>
<td> <a href="bookName?bookname=${books.bookTitle}">Borrow Book</a> </td>
</tr>
</c:forEach>

</table>
</form>	
</div>








</body>
</html>
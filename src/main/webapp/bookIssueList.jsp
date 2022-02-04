<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.util.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Books Issue List</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/bookissuelist.css">
</head>
<body>

<div class="topnav" >
<h1 style="float:left;">Library Management</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
 
  
</div>

<h1>Book Issue List</h1>
<br><br>
<div class="container-fluid">
<table class="table table-hover" style="font-size:larger;" >
<caption>Book Issue List</caption>
<tr>
<th id="head1"><strong>Issue No</strong></th>
<th id="head2"><strong>Book Name</strong></th>
<th id="head3"><strong>User Name</strong></th>
<th id="head4"><strong>Issued Date</strong></th>
<th id="head5"><strong>Return Date</strong></th>
<th id="head6"><strong>Date Returned</strong></th>
<th id="head7"><strong>Fine Range in Month</strong></th>
<th id="head7"><strong>Fine </strong></th>

</tr>
<c:forEach var="books" items="${BookIssueList }">				
<tr>
<td> ${books.bookIssueId}</td>
<td> ${books.bookCode}</td>
<td id="capital"> ${books.userName}</td>
<td>${books.dateIssue}</td>
<td> ${books.dateReturn}</td>
<td> ${books.dateReturned}</td>
<td> ${books.fineRange}</td>
<td>Rs. ${books.fine}</td>

</tr>	
</c:forEach>
			
			</table>
</div>
</body>
</html>
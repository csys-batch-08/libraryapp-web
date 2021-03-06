<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.util.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User History</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/userhistory.css">
</head>
<body>

<div class="topnav" >
<h1 style="float:left;"> Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
  
</div>
<br><br>

<div class="container">
<h1 style="float:left;">Book Borrow History</h1>
<table class="table table-hover" style="color:white;">
<caption>
</caption>
<tr>
<th id="head"><strong>Book Name</strong></th>
<th id="head"><strong>Borrowed Date</strong></th>
<th id="head"><strong>Actual Return Date</strong></th>
<th id="head"><strong>Returned Date</strong></th>
<th id="head"><strong>Fine Range in Month</strong></th>
<th id="head"><strong>Fine amount</strong></th>
</tr>
<c:forEach var="bookIssue" items="${bookIssueList}">					
			<tr>

<td>${bookIssue.bookCode }</td>
<td>${bookIssue.dateIssue }  </td>
<td>${bookIssue.dateReturn }</td>
<td>${bookIssue.dateReturned }</td>
<td>${bookIssue.fineRange }</td>
<td>Rs ${bookIssue.fine }</td>

</tr>	
</c:forEach>				
			
			
			</table>
</div>
</body>
</html>
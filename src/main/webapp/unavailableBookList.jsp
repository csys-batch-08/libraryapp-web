<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.library.connection.*" import="com.library.dao.impl.*" import="com.library.model.*"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List of Unavailable Books</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/unavailablebooklist.css">
</head>
<body>

<div class="topnav">
<h1 style="float:left;">Library Managemen</h1>
  <a class="active" href="admin.jsp">Home</a>
  <a href="logout.jsp">Logout</a>
<h1>t	</h1>

  
</div>


<br><br>
<div class="container">
<table class="table table-hover" style="font-size:larger;">
<caption>
</caption>
<tr>
<th id="head">Book Name</th>
<th id="head"> Category </th>
<th id="head"> Author </th>
<th id="head"> User Name </th>
<th id="head"> Price </th>
<th id="head"> PreRequest</th>
</tr>
<c:forEach var="availableBooks" items="${unavailableBookList }">
					
			<tr>

<td>${availableBooks.bookTitle }</td>
<td>${availableBooks.category }</td>
<td>${availableBooks.author }</td>
<td id="capital">${availableBooks.userName }</td>
<td>${availableBooks.price }</td>
<td>${availableBooks.prerequest }</td>
</tr>	
				
			</c:forEach>
			
			</table>
</div>
</body>
</html>
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
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

        table{
            width: 350px;
            margin-left: 600px;
            font-size:larger;
            color:white;
            
        }
        body{
            background-image: url(Assets/Rose-flowers-books.jpg);
           background-repeat: no-repeat;
            background-size:cover;
            color:white;
        }
             .topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}
.topnav a:hover {
  background-color: #ddd;
  color: black;
}
a{
color:black;
}

/* Add a color to the active/current link */
.topnav a {
  color: white;
  float: right;
}
table tabl-hover{
font-size:larger;
}
table tr{
color:white;
}

table tr:hover{
color:black;
background-color:white; 
}
.topnav{
background-color: gray;
overflow:hidden;
}
</style>
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
	<br>

		
	
	
	


</body>
</html>
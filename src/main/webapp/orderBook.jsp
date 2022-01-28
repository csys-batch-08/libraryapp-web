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
.button {
  background-color:pink; 
  border: none;
  color: white;
  padding: 4px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
  border-radius:20px;
  
}
.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid pink;
  }
  .button1:hover {
  background-color:gray;
  color: white;
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
/* Add a color to the active/current link */
.topnav a {
 
  color: white;
  float: right;
} 

</style>
</head>
<body>

	
	<div class="topnav" >
	<h1 style="float:left;">Library Management</h1>
  <a class="active" href="user.jsp">Home</a>
  <a href="logout.jsp">Logout</a>  
</div>
<h2>Ordered Books</h2>

		<table class = "container" aria-describedby="Show All home places">
		<tr>
		<th id="head"><strong>BookName</strong></th>
		<th id="head"><strong>Author</strong></th>
		<th id="head"><strong>Status</strong></th>
		<th id="head"><strong>Borrow</strong></th>
		</tr>
	<c:forEach var="orderBook" items="${adminOrderBook}">
			<tr>
			<td>${orderBook.bookName }</td>
			<td>${orderBook.author }</td>
			<td>${orderBook.status }</td>
			<c:set var="sent" value="arrived" />
			<c:if test="${orderBook.status eq sent}">
			<td><button style="font-size:large;width:100px;" class="button button1"><a href="bookName?bookname=${orderBook.bookName}&orderAuthorName=${orderBook.author}" style="text-decoration:none;">Borrow Book</a></button></td>
			</c:if>
			</tr>
	</c:forEach>
			</table>

</body>
</html>